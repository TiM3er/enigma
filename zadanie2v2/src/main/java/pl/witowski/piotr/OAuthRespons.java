package pl.witowski.piotr;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OAuthRespons {
    private String access_token;
    private String token_type;
    private float expires_in;
    private String grant_type;

}
