package com.codedifferently.lesson16.tiktokvideosystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson16.tiktokvideosystem.TiktokVideo.VideoCategory;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TiktokVideoTest {

  private TiktokVideo tiktokVideo;

  @BeforeEach
  void setUp() {
    tiktokVideo =
        new TiktokVideo("enigivensunday", 1000000, 500000, TiktokVideo.VideoCategory.VLOG);
  }

  @Test
  void testConstructor() {
    TiktokVideo video = new TiktokVideo("Jane", 3000, 1000, VideoCategory.DANCE);
  }

  @Test
  void testSetAndGetVideoCategory() {
    tiktokVideo.setVideoCategory(VideoCategory.COMEDY);
    assertEquals(VideoCategory.COMEDY, tiktokVideo.getVideoCategory());
  }

  @Test
  void getVideoCategory() {
    assertEquals(TiktokVideo.VideoCategory.VLOG, tiktokVideo.getVideoCategory());
  }

  @Test
  void testViewsCount() {
    assertEquals(1000000, tiktokVideo.getViewsCount());
  }

  @Test
  void testIncreaseViewsPositive() {
    tiktokVideo.increaseViews(500);
    // got the is matcher idea from chat gpt
    assertEquals(1000500, tiktokVideo.getViewsCount());
  }

  @Test
  void testDecreaseViewsNegative() {
    InvalidViewIncrementException exception =
        assertThrows(
            InvalidViewIncrementException.class,
            () -> {
              tiktokVideo.increaseViews(-1);
            });
    assertEquals("View increase amount must be positive.", exception.getMessage());
  }

  @Test
  void testDisplayComments() {
    // used google & chat for this unit test solution
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalOut = System.out;
    System.setOut(printStream);

    ArrayList<String> comments = new ArrayList<>();
    comments.add("Love this video!");
    comments.add("So funny");
    tiktokVideo.displayComments(comments);
    System.setOut(originalOut);
    String output = outputStream.toString().trim();
    String expectedOutput = "Love this video!\nSo funny";
    assertEquals(expectedOutput, output);
  }

  @Test
  void testDisplayCommentsWithNullList() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    PrintStream originalOut = System.out;
    System.setOut(printStream);

    tiktokVideo.displayComments(null);

    System.setOut(originalOut);

    String output = outputStream.toString().trim();
    assertEquals("No comments yet. Be the first to comment!", output);
  }

  @Test
  void getCreatorName() {
    assertEquals("enigivensunday", tiktokVideo.getCreator());
  }

  @Test
  void testAddComments() {
    tiktokVideo.addComments("This is awesome!");

    assertEquals("This is awesome!", tiktokVideo.getCommentsList().get(0));
  }

  @Test
  void testLikeToViewRatio() {
    // Create the object using the constructor with views and likes
    double result = tiktokVideo.likeToViewRatio();
    assertEquals(
        0.5, result, 0.0001); // got the idea to Use delta for comparing doubles from chatGpt
  }
}
