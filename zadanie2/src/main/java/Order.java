import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
    @NonNull
    private String notifyUrl;
    @NonNull
    private String customerIp;
    @NonNull
    private String merchantPosId;
    @NonNull
    private String description;

    @NonNull
    private String currencyCode;

    @NonNull
    private String totalAmount;

    private String extOrderId;

    @NonNull

    Buyer BuyerObject;
    @NonNull
    List<Product> products = new LinkedList<Product>();
}
