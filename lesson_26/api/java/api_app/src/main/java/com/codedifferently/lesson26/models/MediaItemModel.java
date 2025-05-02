package com.codedifferently.lesson26.models;

import com.codedifferently.lesson26.library.MediaType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "media_items")
public class MediaItemModel {
  @Enumerated(EnumType.STRING)
  public MediaType type;

  @Id public UUID id;
  public String isbn;
  public String title;

  @Convert(converter = AuthorsConverter.class)
  public List<String> authors;

  public String edition;
  public Integer pages = 0;
  public Integer runtime = 0;
}
