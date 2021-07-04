package pl.witowski.piotr;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Buyer {
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
}
