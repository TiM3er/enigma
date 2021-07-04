package pl.witowski.piotr.zadanie3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.witowski.piotr.zadanie3.controllers.GeolocationController;
import pl.witowski.piotr.zadanie3.dtos.Positon;
import pl.witowski.piotr.zadanie3.services.GeolocationerviceImpl;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class GeolocationControllerTests {

    private MockMvc mvc;

    @InjectMocks
    private GeolocationController geolocationController;

    GeolocationerviceImpl geolocationervice;

    @Before
    public void setUp() throws Exception {
        geolocationervice = new GeolocationerviceImpl();
        mvc = MockMvcBuilders.standaloneSetup(geolocationController).build();
    }

    @Test
    public void testInsertNewPosition() throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.post("/position")
                        .contentType(APPLICATION_JSON)
                        .content("{\n" +
                                "    \"deviceId\": \"325ebb70-671e-498f-8c25-2a381b667764\",\n" +
                                "    \"positionDateTime\": \"2019-10-07 21:55:31\",\n" +
                                "    \"latitiude\": 0.8318357836991034,\n" +
                                "    \"longitude\": 0.03933759585470986\n" +
                                "}")

        ).andExpect(MockMvcResultMatchers.status().isOk());


    }

    @Test
    public void getAllPositionTest() throws Exception {
        UUID uuid = UUID.randomUUID();

        geolocationController.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        MvcResult deviceId = mvc.perform(MockMvcRequestBuilders.get("/positions/{uuid}", uuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].deviceId", is(uuid.toString())))
                .andReturn();
        System.out.println(deviceId.getResponse().getContentAsString());
    }

    @Test
    public void getLastPositionTest() throws Exception {
        UUID uuid = UUID.randomUUID();

        geolocationController.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));
        MvcResult deviceId = mvc.perform(MockMvcRequestBuilders.get("/position/{uuid}", uuid))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deviceId", is(uuid.toString())))
                .andReturn();
        System.out.println(deviceId.getResponse().getContentAsString());
    }

    @Test
    public void deleteAllPositionByDeviceIdTest() throws Exception {
        UUID uuid = UUID.randomUUID();

        geolocationController.insertNewPosision(new Positon(uuid, LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble()));

        mvc.perform(
                MockMvcRequestBuilders.delete("/position/{uuid}", uuid)
                        .contentType(APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(
                MockMvcRequestBuilders.delete("/position/{uuid}", "test")
                        .contentType(APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest());


    }

}
