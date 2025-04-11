package com.codedifferently.lesson16.tiktokvideosystem;

import org.hamcrest.MatcherAssert.assertThat.assertEquals;
import org.hamcrest.Matchers.is;
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
  void getVideoCategory() {
    assertEquals(TiktokVideo.VideoCategory.VLOG, tiktokVideo.getVideoCategory());
  }

  @Test
  void testIncreaseViewsPositive() {
    tiktokVideo.increaseViews(500);
    // got the is matcher idea from chat gpt
    assertThat(tiktokVideo.getViewsCount(), is(1500));
  }

  @Test
  void testDecreaseViewsNegative() {
    tiktokVideo.InvalidViewIncrementException(-78);
    assertThrows(InvalidViewIncrementException.class, () -> tiktokVideo);
  }

  @Test
  String showCommennts() {}

  @Test
  void getCreatorName() {

    assertEquals(TiktokVideo.String, tiktokVideo.getCreator());
  }
}
