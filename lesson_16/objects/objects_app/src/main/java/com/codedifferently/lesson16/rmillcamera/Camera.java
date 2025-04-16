package com.codedifferently.lesson16.rmillcamera;

import java.util.ArrayList;

public class Camera {
  private String brand;
  private int megapixels;
  private double price;
  private ArrayList<String> supportedFormats;
  private CameraMode mode;

  public Camera(String brand, int megapixels, double price, CameraMode mode) {
    this.brand = brand;
    this.megapixels = megapixels;
    this.price = price;
    this.mode = mode;
    this.supportedFormats = new ArrayList<>();
  }

  public void addFormat(String format) throws CameraException {
    if (format == null || format.isEmpty()) {
      throw new CameraException("Format cannot be empty.");
    }
    supportedFormats.add(format);
    System.out.println("Added format: " + format);
  }

  public void showFormats() {
    if (supportedFormats.isEmpty()) {
      System.out.println("No formats supported yet.");
    } else {
      System.out.println("Supported formats:");
      for (String format : supportedFormats) {
        System.out.println("- " + format);
      }
    }
  }

  public void isAffordable(double budget) {
    String result =
        (price <= budget) ? "This camera is within your budget." : "This camera is too expensive.";
    System.out.println(result);
  }

  public static void main(String[] args) {
    try {
      Camera myCamera = new Camera("Sony", 24, 899.99, CameraMode.PORTRAIT);

      myCamera.addFormat("JPEG");
      myCamera.addFormat("RAW");

      myCamera.showFormats();
      myCamera.isAffordable(1000);

    } catch (CameraException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
