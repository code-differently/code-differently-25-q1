package com.codedifferently.lesson16.evanphilakhong;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")

public enum Team {
    ALPINE, ASTON_MARTIN, FERRARI, HASS,
    MCLAREN, MERCEDES, VCARB, RED_BULL,
    SAUBER, WILLIAMS
}