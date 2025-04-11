package com.codedifferently.lesson16.tiktokvideosystem;

import java.util.ArrayList;

public class TiktokVideo {
  private String creatorName;
  private int viewsCount;
  private int likesCount;
  private VideoCategory videoCategory;
  private ArrayList<String> commentsList;

  public enum VideoCategory {
    DANCE,
    COMEDY,
    VLOG,
    TUTORIAL
  }

  public TiktokVideo(
      String creatorName, int viewsCount, int likesCount, VideoCategory videoCategory) {
    this.creatorName = creatorName;
    this.viewsCount = viewsCount;
    this.likesCount = likesCount;
    this.videoCategory = videoCategory;
    this.commentsList = new ArrayList<>();
  }

  // One function uses a conditional expression to check if the video has more than a specific
  // number of views (e.g., 1 million views).
  public void increaseViews(int amount) {
    // Use a conditional to check if amount is positive
    if (amount > 0) {
      // If so, add amount to the views
      this.viewsCount += amount;
    }
    // Else, either print a message or throw an exception
    else {
      throw new InvalidViewIncrementException("View increase amount must be positive.");
    }
  }

  public double likeToViewRatio() {
    if (viewsCount == 0) {
      return 0.0;
    }

    int totalLikes = 0;
    // used chat because I was not sure how to make a ratio within a for loop
    for (int i = 0; i < likesCount; i++) {
      totalLikes++;
    }

    double ratio = (double) totalLikes / viewsCount;
    return ratio;
  }

  public void displayComments(ArrayList<String> userComments) {
    if (userComments == null) {
      System.out.println("No comments yet. Be the first to comment!");
    } else {
      for (int i = 0; i < userComments.size(); i++) {
        System.out.println(userComments.get(i));
      }
    }
  }

  public void addComments(String comment) {

    commentsList.add(comment);
  }

  public ArrayList<String> getCommentsList() {
    return commentsList;
  }

  public String getCreator() {
    return this.creatorName;
  }

  public void setVideoCategory(VideoCategory videoType) {
    this.videoCategory = videoType;
  }

  public VideoCategory getVideoCategory() {
    return this.videoCategory;
  }

  public int getViewsCount() {
    return this.viewsCount;
  }
}
