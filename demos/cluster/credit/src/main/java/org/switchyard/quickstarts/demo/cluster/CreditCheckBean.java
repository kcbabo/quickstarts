package org.switchyard.quickstarts.demo.cluster;

import org.switchyard.component.bean.Service;

@Service(CreditCheck.class)
public class CreditCheckBean implements CreditCheck {

    @Override
    public Application checkCredit(Offer offer) {
        offer.getApplication().setApproved(offer.getApplication().getCreditScore() >= 600);
        return offer.getApplication();
    }

}
