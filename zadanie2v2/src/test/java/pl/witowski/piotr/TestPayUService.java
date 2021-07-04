package pl.witowski.piotr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;

public class TestPayUService {

    Main main;
    PayUService payUService;

    @Before
    public void initMain() {
        main = new Main();
        payUService = RetrfitConfig.config().create(PayUService.class);

    }

    @Test
    public void configNewTokenAuthorizationTest() {
        OAuthRespons tokenAuthorization = main.getTokenAuthorization(payUService);
        Assert.assertNotNull(tokenAuthorization);
        Assert.assertFalse(tokenAuthorization.getAccess_token().isEmpty());
        Assert.assertFalse(tokenAuthorization.getGrant_type().isEmpty());
    }

    @Test
    public void newOrderTest() {
        OAuthRespons tokenAuthorization = main.getTokenAuthorization(payUService);
        Assert.assertNotNull(tokenAuthorization);
        Response<StatusA> statusAResponse = main.newOrder(payUService, tokenAuthorization);
        Assert.assertNotNull(statusAResponse.headers().get("Location"));
        Assert.assertEquals(302,statusAResponse.code());
    }
}
