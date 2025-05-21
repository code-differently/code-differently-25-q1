package com.codedifferently.lesson26.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMediaItemResponse {
  private MediaItemResponse item;
}
