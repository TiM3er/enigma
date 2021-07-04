import retrofit2.Call;
import retrofit2.http.*;

public interface PayUService {


    @POST("/api/v2_1/orders ")
    @Headers("Content-Type: application/json")
    Call<StatusA> newOrder(@Body Order order);

    @POST("/pl/standard/user/oauth/authorize")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @FormUrlEncoded
    Call<OAuthRespons> getNewOAuthAccesToken(@Field("grant_type") String grantType,@Field("client_id") String clientId,@Field("client_secret") String clientSecret);
}
