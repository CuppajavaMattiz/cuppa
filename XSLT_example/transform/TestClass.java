package transform;

import java.io.*;
// Import for XML
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class TestClass {
	public static StringBuffer getContent(BufferedInputStream in, String xsl)
			throws Exception {
		try {
			TransformerFactory tFactory = null;
			Transformer transformer = null;
			tFactory = TransformerFactory.newInstance();
			transformer = tFactory.newTransformer(new StreamSource(xsl));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			transformer.transform(new StreamSource(in), new StreamResult(baos));
			// Output content
			StringBuffer buf = new StringBuffer();
			buf.append(baos.toString());
			baos.close();
			return buf;
		} catch (Exception e) {
			System.out.println("Exception in getContent");
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String args[]) {
		BufferedInputStream xmlStream = null;
		/*
		 * Open the files and initialize streams
		 */
		try {
			// xml input file hard coded
			FileInputStream xmlFile = new FileInputStream("test.xml");
			xmlStream = new BufferedInputStream(xmlFile);
		} catch (Exception ex) {
			System.exit(-1);
		}
		String xsl = "mytest.xsl";// transformation xsl file hard coded
		StringBuffer output = null;

		try {
			output = getContent(xmlStream, xsl);
		} catch (Exception ex) {
			System.out.println("Exception during parsing");
		}
		try {
			// html output file hard coded

			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter("finally.html")));
			out.write(output.toString(), 0, output.toString().length());
			out.flush();
			out.close();
		} catch (Exception ex) {
			System.out.println("Exception during processing output stream");
		}
	}

}
