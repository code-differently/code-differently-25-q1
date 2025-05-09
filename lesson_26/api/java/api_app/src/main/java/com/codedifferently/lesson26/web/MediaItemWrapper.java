package com.codedifferently.lesson26.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class MediaItemWrapper {

  @NotNull(message = "Item is required") @Valid
  private MediaItemRequest item;

  public MediaItemRequest getItem() {
    return item;
  }

  public void setItem(MediaItemRequest item) {
    this.item = item;
  }
}
