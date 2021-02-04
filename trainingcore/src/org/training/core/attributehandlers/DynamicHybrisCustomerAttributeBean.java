package org.training.core.attributehandlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class DynamicHybrisCustomerAttributeBean implements DynamicAttributeHandler<Boolean, CustomerModel> {


    @Override
    public Boolean get(CustomerModel model) {
        if (model == null) {
            throw new IllegalArgumentException("Item model is required");
        }
        final String email = model.getUid();
        return Boolean.valueOf(email != null && (email.endsWith("hybris.de") || email.endsWith("hybris.com")));
    }

    @Override
    public void set(CustomerModel model, Boolean aBoolean) {

    }

}
