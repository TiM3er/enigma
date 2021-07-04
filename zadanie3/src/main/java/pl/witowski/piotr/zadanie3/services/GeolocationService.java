package pl.witowski.piotr.zadanie3.services;

import pl.witowski.piotr.zadanie3.dtos.Positon;

import java.util.List;
import java.util.UUID;

public interface GeolocationService {
    void insertNewPosision(Positon positon);

    List<Positon> getAllPositionByDeviceId(UUID deviceId);

    Positon getLastPositionByDeviceId(UUID deviceId);

    void deleteAllPositionByDeviceId(UUID deviceId);


}
