package pl.witowski.piotr;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String name;
    private String unitPrice;
    private String quantity;
}
