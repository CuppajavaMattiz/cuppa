package com.mattiz.merge.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MergeXml {

	public static void main(String args[]) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException,
			TransformerException {
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc1 = builder.parse("./resources/XmlOne.xml");
		Document doc2 = builder.parse("./resources/XmlTwo.xml");
		String xPathString = "/Mattiz/Content";
		Document mergedDoc = passThroughXML(xpath, xPathString, doc1, doc2);
		System.out.println(getDocumentAsStringAfterTransformation(mergedDoc));
	}

	private static Document passThroughXML(XPath xpath, String xPathString,
			Document doc1, Document doc2) throws XPathExpressionException,
			TransformerException, IOException {
		Document document = null;
		XPathExpression xPathExpression = xpath.compile(xPathString);
		NodeList nodeList = (NodeList) xPathExpression.evaluate(doc2,
				XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
			XPathExpression innerXpathExpression = xpath.compile(xPathString
					.concat("[position()=" + (i + 1) + "]"));
			document = mergeXml(innerXpathExpression, doc1, doc2);
		}
		document = removeDuplicates(xPathString, xpath, document);
		return document;
	}

	private static Document mergeXml(XPathExpression innerXpathExpression,
			Document doc1, Document doc2) throws XPathExpressionException,
			IOException {
		Node doc1Node = (Node) innerXpathExpression.evaluate(doc1,
				XPathConstants.NODE);
		if (doc1Node == null) {
			throw new RuntimeException(doc1Node
					+ " - expression does not evaluate to a node");
		}
		Node doc2Node = (Node) innerXpathExpression.evaluate(doc2,
				XPathConstants.NODE);
		while (doc2Node.hasChildNodes()) {
			Node childNode = doc2Node.getFirstChild();
			doc2Node.removeChild(childNode);
			childNode = doc1.importNode(childNode, true);
			doc1Node.appendChild(childNode);
		}
		return doc1;
	}

	private static Document removeDuplicates(String xPathString, XPath xpath,
			Document document) throws XPathExpressionException,
			TransformerException {
		XPathExpression xPathExpression = xpath.compile(xPathString
				.concat("/Name[position()=2]"));
		NodeList nodeList = (NodeList) xPathExpression.evaluate(document,
				XPathConstants.NODESET);
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nodeToRemove = nodeList.item(i);
			nodeToRemove.getParentNode().removeChild(nodeToRemove);
		}
		return document;
	}

	private static String getDocumentAsStringAfterTransformation(Document document)
			throws TransformerConfigurationException, TransformerException {
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		Writer outWriter = new StringWriter();
		Result result = new StreamResult(outWriter);
		transformer.transform(source, result);
		String stringDoc = outWriter.toString();
		return stringDoc;
	}
}
