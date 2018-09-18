package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nba")
public class NbaBean {
    private String rocket;

    private String lakers;

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public String getLakers() {
        return lakers;
    }

    public void setLakers(String lakers) {
        this.lakers = lakers;
    }
}
