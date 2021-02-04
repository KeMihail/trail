package org.training.core.additions;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.Test;
import org.training.core.constants.GeneratedTrainingCoreConstants;

import static org.junit.Assert.assertTrue;

@UnitTest
public class GeneratedTypesTest {

    @Test
    public void testProductAttribute() {
        assertTrue(ProductModel.INTERNALONLY.equals(GeneratedTrainingCoreConstants.Attributes.Product.INTERNALONLY));
    }

    @Test
    public void testCustomerAttribute() {
        assertTrue(CustomerModel.ISINTERNAL.equals(GeneratedTrainingCoreConstants.Attributes.Customer.ISINTERNAL));
    }

}
