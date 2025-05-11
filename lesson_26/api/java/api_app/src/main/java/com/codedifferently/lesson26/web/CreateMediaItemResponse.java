package com.codedifferently.lesson26.web;

import com.codedifferently.lesson26.library.MediaItem;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMediaItemResponse {
  private UUID id;

  public static CreateMediaItemResponse from(MediaItem item) {
    return CreateMediaItemResponse.builder().id(item.getId()).build();
  }
}
