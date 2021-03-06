package com.greenfoxacademy.googleapiauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateCustomizer;

@SpringBootApplication
public class GoogleapiauthApplication {

  public static void main(String[] args) {
    SpringApplication.run(GoogleapiauthApplication.class, args);
  }
}
