package pl.witowski.piotr;

import lombok.Data;

@Data
public class StatusA {
    StatusB  status;
    private String redirectUri;
    private String orderId;
    private String extOrderId;
}
