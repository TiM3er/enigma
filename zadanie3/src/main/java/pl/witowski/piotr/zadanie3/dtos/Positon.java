package pl.witowski.piotr.zadanie3.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Positon {
    UUID deviceId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime positionDateTime;
    double latitiude;
    double longitude;
}
