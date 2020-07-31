
package com.mattiz.ws.test.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mattiz.ws.test.bean package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWelcomeStringResponse_QNAME = new QName("http:/com.mattiz/wsdl", "getWelcomeStringResponse");
    private final static QName _GetWelcomeString_QNAME = new QName("http:/com.mattiz/wsdl", "getWelcomeString");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mattiz.ws.test.bean
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWelcomeString }
     * 
     */
    public GetWelcomeString createGetWelcomeString() {
        return new GetWelcomeString();
    }

    /**
     * Create an instance of {@link GetWelcomeStringResponse }
     * 
     */
    public GetWelcomeStringResponse createGetWelcomeStringResponse() {
        return new GetWelcomeStringResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWelcomeStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http:/com.mattiz/wsdl", name = "getWelcomeStringResponse")
    public JAXBElement<GetWelcomeStringResponse> createGetWelcomeStringResponse(GetWelcomeStringResponse value) {
        return new JAXBElement<GetWelcomeStringResponse>(_GetWelcomeStringResponse_QNAME, GetWelcomeStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWelcomeString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http:/com.mattiz/wsdl", name = "getWelcomeString")
    public JAXBElement<GetWelcomeString> createGetWelcomeString(GetWelcomeString value) {
        return new JAXBElement<GetWelcomeString>(_GetWelcomeString_QNAME, GetWelcomeString.class, null, value);
    }

}
