package org.example;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Data
    public static class DateTimeExample {

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd  HH:mm:ss:SSS", locale = "ru")
        private LocalDateTime dateTime;

        public DateTimeExample(LocalDateTime now) {
            dateTime = now;
        }
    }

    @RestController
    public static class DateTimeController {

        @GetMapping("/current-time")
        public DateTimeExample getCurrentTime() {
            return new DateTimeExample(LocalDateTime.now());
        }
    }
}
