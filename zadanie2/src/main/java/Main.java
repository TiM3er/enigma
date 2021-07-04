import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
// add your other interceptors …
// add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://secure.snd.payu.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient
                        .build())
                .build();


        PayUService payUService = retrofit.create(PayUService.class);
        OAuthRespons body = null;

        try {
            body = payUService.getNewOAuthAccesToken("client_credentials", "id", "secret").execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> products = new LinkedList<Product>();
        body.setToken_type(body.getToken_type());


        final OAuthRespons finalBody = body;
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + finalBody.getAccess_token())
                        .build();
                return chain.proceed(newRequest);
            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("https://secure.snd.payu.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(httpClient.build())
                .build();
        payUService = retrofit.create(PayUService.class);



        products.add(new Product("Wireless Mouse for Laptop", "15000", "1"));
        Order order = new Order("https://your.eshop.com/notify", "127.0.0.1", "145227", "RTV market", "PLN"
                , "15000", new Buyer("john.doe@example.com", "654111654", "John", "Doe"));
        order.setProducts(products);
        payUService.newOrder(order ).enqueue(new Callback<StatusA>() {
            public void onResponse(Call<StatusA> call, Response<StatusA> response) {
                System.out.println(response.code());
            }

            public void onFailure(Call<StatusA> call, Throwable throwable) {
                throwable.printStackTrace();
                System.out.println(throwable.toString());
            }
        });
    }
}
