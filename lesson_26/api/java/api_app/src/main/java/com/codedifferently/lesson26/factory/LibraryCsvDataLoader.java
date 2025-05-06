package com.codedifferently.lesson26.factory;

import com.codedifferently.lesson26.library.MediaType;
import com.codedifferently.lesson26.models.CheckoutModel;
import com.codedifferently.lesson26.models.LibraryDataModel;
import com.codedifferently.lesson26.models.LibraryGuestModel;
import com.codedifferently.lesson26.models.MediaItemModel;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/** An object that loads data from a CSV and returns a LibraryDataModel object. */
@Service
public final class LibraryCsvDataLoader implements LibraryDataLoader {
  private static final String MEDIA_ITEMS_CSV_PATH = "csv/media_items.csv";
  private static final String GUESTS_CSV_PATH = "csv/guests.csv";
  private static final String CHECKED_OUT_ITEMS_CSV_PATH = "csv/checked_out_items.csv";

  @Override
  public LibraryDataModel loadData() throws IOException {
    var model = new LibraryDataModel();
    model.mediaItems = loadMediaItemsFromCsv(MEDIA_ITEMS_CSV_PATH);
    model.guests = loadGuestsFromCsv(GUESTS_CSV_PATH, CHECKED_OUT_ITEMS_CSV_PATH);
    return model;
  }

  private List<MediaItemModel> loadMediaItemsFromCsv(String filePath) throws IOException {
    List<MediaItemModel> mediaItems = new ArrayList<>();

    try (var reader = new FileReader(new ClassPathResource(filePath).getFile());
        var csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
      for (CSVRecord csvRecord : csvParser) {
        var item = new MediaItemModel();

        item.type = MediaType.fromString(csvRecord.get("type"));
        item.id = UUID.fromString(csvRecord.get("id"));
        item.title = csvRecord.get("title");
        item.isbn = csvRecord.get("isbn");
        item.authors = List.of(csvRecord.get("authors").split(", "));
        item.pages = parseIntOrDefault(csvRecord.get("pages"), 0);
        item.runtime = parseIntOrDefault(csvRecord.get("runtime"), 0);
        item.edition = csvRecord.get("edition");

        mediaItems.add(item);
      }

    } catch (IOException e) {
      return new ArrayList<>();
    }

    return mediaItems;
  }

  private int parseIntOrDefault(String value, int defaultVal) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      return defaultVal;
    }
  }

  private List<LibraryGuestModel> loadGuestsFromCsv(
      String guestsCsvPath, String checkedOutCsvPath) {
    List<LibraryGuestModel> guests = loadGuestRecordsFromCsv(guestsCsvPath);
    Map<String, List<CheckoutModel>> checkedOutItems = loadCheckoutsFromCsv(checkedOutCsvPath);
    for (LibraryGuestModel guest : guests) {
      if (checkedOutItems.containsKey(guest.email)) {
        guest.checkedOutItems = checkedOutItems.get(guest.email);
      } else {
        guest.checkedOutItems = new ArrayList<>();
      }
    }
    return guests;
  }

  private List<LibraryGuestModel> loadGuestRecordsFromCsv(String guestsCsvPath) {
    List<LibraryGuestModel> guests = new ArrayList<>();

    try (var reader = new FileReader(new ClassPathResource(guestsCsvPath).getFile());
        var csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
      for (CSVRecord csvRecord : csvParser) {
        var guest = new LibraryGuestModel();

        guest.type = csvRecord.get("type");
        guest.name = csvRecord.get("name");
        guest.email = csvRecord.get("email");

        guests.add(guest);
      }
    } catch (IOException e) {
      return new ArrayList<>();
    }

    return guests;
  }

  private Map<String, List<CheckoutModel>> loadCheckoutsFromCsv(String checkedOutCsvPath) {
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();

    try (var reader = new FileReader(new ClassPathResource(checkedOutCsvPath).getFile());
        var csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
      for (CSVRecord csvRecord : csvParser) {
        var checkout = new CheckoutModel();

        checkout.itemId = UUID.fromString(csvRecord.get("item_id"));
        checkout.dueDate = Instant.parse(csvRecord.get("due_date"));

        String guestEmail = csvRecord.get("email");
        checkoutsByGuestEmail.computeIfAbsent(guestEmail, e -> new ArrayList<>()).add(checkout);
      }
    } catch (IOException e) {
      return new HashMap<>();
    }

    return checkoutsByGuestEmail;
  }
}
