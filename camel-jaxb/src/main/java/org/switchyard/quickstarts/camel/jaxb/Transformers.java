package org.switchyard.quickstarts.camel.jaxb;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class Transformers {

    @Transformer(to = "{urn:switchyard-quickstart:camel-jaxb:1.0}greetingResponse")
    public Element transformGreetingResponseToGreetingResponse(
            GreetingResponse from) {
        try {
            System.out.println("====== Returning response: " + from.getGreeting());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.newDocument().getDocumentElement();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Transformer(from = "{urn:switchyard-quickstart:camel-jaxb:1.0}greetingRequest")
    public GreetingRequest transformGreetingRequestToGreetingRequest(
            Element from) {
        return new GreetingRequest("billy");
    }

}
