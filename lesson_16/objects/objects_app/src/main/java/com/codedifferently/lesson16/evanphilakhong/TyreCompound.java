package com.codedifferently.lesson16.evanphilakhong;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")

enum TyreCompound {
        SOFT, MEDIUM, HARD, INTERMEDIATE, WET
    }
