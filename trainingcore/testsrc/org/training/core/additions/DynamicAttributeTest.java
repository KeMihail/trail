package org.training.core.additions;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.user.UserService;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@IntegrationTest
public class DynamicAttributeTest extends ServicelayerTransactionalTest {

    @Resource
    private ModelService modelService;

    @Resource
    private UserService userService;

    CustomerModel customer;

    private static final String INNER_CUSTOMER_UID = "mihail@hybris.de";
    private static final String NOT_INNER_CUSTOMER_UID = "mihail@yandex.ru";

    @Before
    public void setUp() {
        customer = modelService.create(CustomerModel.class);
        customer.setUid(INNER_CUSTOMER_UID);
        modelService.save(customer);
    }

    @Test
    public void testIsInternalAttribute() {
        CustomerModel result = (CustomerModel) userService.getUserForUID(INNER_CUSTOMER_UID);
        assertTrue(result.getIsInternal());

        result.setUid(NOT_INNER_CUSTOMER_UID);
        modelService.save(result);
        result = (CustomerModel) userService.getUserForUID(NOT_INNER_CUSTOMER_UID);
        assertTrue(!result.getIsInternal());

    }

}
