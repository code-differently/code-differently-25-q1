package com.codedifferently.lesson26.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMediaItemResponse {

    static Object builder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  private MediaItemResponse item;
}
