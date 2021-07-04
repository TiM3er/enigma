package pl.witowski.piotr;

import retrofit2.Response;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PayUService payUService = RetrfitConfig.config().create(PayUService.class);

        Main main = new Main();
        OAuthRespons body = main.getTokenAuthorization(payUService);
        main.newOrder(payUService, body);
    }

    public OAuthRespons getTokenAuthorization(PayUService payUService) {

        try {
            return payUService.getNewOAuthAccesToken("client_credentials", "id", "secret").execute().body();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response<StatusA> newOrder(PayUService payUService, OAuthRespons body) {
        List<Product> products = new LinkedList<Product>();
        products.add(new Product("Wireless Mouse for Laptop", "15000", "1"));
        Order order = new Order("https://your.eshop.com/notify", "127.0.0.1", "366561", "RTV market", "PLN"
                , "15000", new Buyer("john.doe@example.com", "654111654", "John", "Doe"));
        order.setProducts(products);

        try {
            Response<StatusA> execute = payUService.newOrder("Bearer " + body.getAccess_token(), order).execute();
            return execute;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
