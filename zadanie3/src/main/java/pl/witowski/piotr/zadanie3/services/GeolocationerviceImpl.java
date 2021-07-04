package pl.witowski.piotr.zadanie3.services;

import org.springframework.stereotype.Service;
import pl.witowski.piotr.zadanie3.dtos.Positon;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class GeolocationerviceImpl implements GeolocationService {

    private List<Positon> positons;

    public GeolocationerviceImpl() {
        this.positons = new LinkedList<>();
    }

    @Override
    public void insertNewPosision(Positon positon) {
        this.positons.add(positon);
        positon.toString();
    }

    @Override
    public List<Positon> getAllPositionByDeviceId(UUID deviceId) {
        List<Positon> positonList = new LinkedList<>();
        for (Positon positon : this.positons) {
            if (positon.getDeviceId().equals(deviceId)) {
                positonList.add(positon);
            }
        }
        return positonList;
    }

    @Override
    public Positon getLastPositionByDeviceId(UUID deviceId) {
        Positon positon1 = new Positon();
        for (Positon positon : this.positons) {
            if (positon.getDeviceId().equals(deviceId)) {
                positon1 = positon;
            }
        }
        return positon1;
    }

    @Override
    public void deleteAllPositionByDeviceId(UUID deviceId) {
        this.positons.removeIf(positon -> deviceId.equals(deviceId));
    }

    public List<Positon> getPositons() {
        return positons;
    }
}

