package pl.witowski.piotr.zadanie3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import pl.witowski.piotr.zadanie3.dtos.Positon;
import pl.witowski.piotr.zadanie3.services.GeolocationerviceImpl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
public class GeolocationServiceTests {

    GeolocationerviceImpl geolocationService;

    @Before
    public void initTests() {
        geolocationService = new GeolocationerviceImpl();
    }

    @Test
    public void insertNewPosisionTest() {
        UUID uuid = UUID.randomUUID();
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        Assert.assertNotEquals(0, geolocationService.getPositons().size());
        Assert.assertNotNull(geolocationService.getPositons());
        Assert.assertEquals(uuid, geolocationService.getPositons().get(0).getDeviceId());
    }

    @Test
    public void getAllPositionByDeviceIdTest() {
        UUID uuid = UUID.randomUUID();
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));

        Assert.assertFalse(geolocationService.getPositons().isEmpty());
        Assert.assertFalse(geolocationService.getAllPositionByDeviceId(uuid).isEmpty());
        Assert.assertEquals(4, geolocationService.getAllPositionByDeviceId(uuid).size());


    }

    @Test
    public void getLastPositionByDeviceIdTest() {
        UUID uuid = UUID.randomUUID();
        double latitiude = new Random().nextDouble();
        double longitude = new Random().nextDouble();

        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), latitiude, longitude));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));


        Assert.assertNotNull(geolocationService.getLastPositionByDeviceId(uuid));
        Assert.assertEquals(latitiude, geolocationService.getLastPositionByDeviceId(uuid).getLatitiude(), 0.0);
        Assert.assertEquals(longitude, geolocationService.getLastPositionByDeviceId(uuid).getLongitude(), 0.0);
    }

    @Test
    public void deleteAllPositionByDeviceIdTest() {
        UUID uuid = UUID.randomUUID();
        double latitiude = new Random().nextDouble();
        double longitude = new Random().nextDouble();

        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(uuid, LocalDateTime.now(), latitiude, longitude));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        geolocationService.insertNewPosision(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));


        Assert.assertNotNull(geolocationService.getAllPositionByDeviceId(uuid));
        geolocationService.deleteAllPositionByDeviceId(uuid);
        Assert.assertTrue(geolocationService.getAllPositionByDeviceId(uuid).isEmpty());
    }
}
