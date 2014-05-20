package org.switchyard.quickstarts.camel.service;

import org.switchyard.annotations.Transformer;
import org.w3c.dom.Element;

public final class Transformers {

    @Transformer(from = "{urn:switchyard-quickstart:camel-service:0.1.0}acceptMessage")
    public String transformAcceptMessageToString(Element from) {
        return "sally: likes cheese";
    }

}
