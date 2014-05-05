package org.switchyard.quickstarts.bean.service;

import javax.inject.Named;

@Named("ExtraBean")
public class Extra {

    public void execute() {
        System.out.println("Executing ExtraBean");
    }
}
