package pl.witowski.piotr.zadanie3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.witowski.piotr.zadanie3.dtos.Positon;
import pl.witowski.piotr.zadanie3.services.GeolocationService;
import pl.witowski.piotr.zadanie3.services.GeolocationerviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@EnableWebMvc
public class GeolocationController {

    GeolocationService geolocationService;

    @Autowired
    public GeolocationController(GeolocationService geolocationService) {
        this.geolocationService = new GeolocationerviceImpl();
    }

    @RequestMapping(value = "/position",method = RequestMethod.POST)
    public ResponseEntity<Void> insertNewPosision(@RequestBody Positon positon) {
        geolocationService.insertNewPosision(positon);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/positions/{uuid}")
    @ResponseBody
    public ResponseEntity<List<Positon>> getAllPositionByDeviceId(@PathVariable(value = "uuid") String deviceId) {
        if (isUuidValid(deviceId)) {
            List<Positon> allPositionByDeviceId = geolocationService.getAllPositionByDeviceId(UUID.fromString(deviceId));
            if (allPositionByDeviceId.isEmpty()) {
                return new ResponseEntity<List<Positon>>(allPositionByDeviceId, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Positon>>(allPositionByDeviceId, HttpStatus.OK);
        }
        return new ResponseEntity<List<Positon>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/position/{uuid}")
    @ResponseBody
    public ResponseEntity<Positon> getLastPositionByDeviceId(@PathVariable(value = "uuid") String deviceId) {
        if (isUuidValid(deviceId)) {
            Positon lastPositionByDeviceId = geolocationService.getLastPositionByDeviceId(UUID.fromString(deviceId));
            if (lastPositionByDeviceId == null) {
                return new ResponseEntity<Positon>(lastPositionByDeviceId, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Positon>(lastPositionByDeviceId, HttpStatus.OK);
        }
        return new ResponseEntity<Positon>(new Positon(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/position/{uuid}")
    public ResponseEntity<Void> deleteAllPositionByDeviceId(@PathVariable(value = "uuid") String deviceId) {
        if (isUuidValid(deviceId)) {
            geolocationService.deleteAllPositionByDeviceId(UUID.fromString(deviceId));
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    private boolean isUuidValid(String deviceId) {
        try {
            UUID.fromString(deviceId);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
