package pl.witowski.piotr.zadanie3;

import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.witowski.piotr.zadanie3.dtos.Positon;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class Zadanie3Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Zadanie3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(new Gson().toJson(new Positon(UUID.randomUUID(), LocalDateTime.now(), new Random().nextDouble(), new Random().nextDouble())));
    }
}
