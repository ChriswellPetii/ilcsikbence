package com.greenfoxacademy.hellobeanworld.services;

import org.springframework.stereotype.Service;

@Service
public class BlueColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is blue in color...");
  }
}
