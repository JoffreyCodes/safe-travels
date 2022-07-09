package safe.model;

import java.sql.Timestamp;

public class Review {
    protected Integer ReviewId;
    protected String UserName;
    protected Timestamp Created;
    protected String UserReview;
    protected Double Rating;
    protected Integer ProfileId;

    public Review(Integer reviewId, String userName, Timestamp created, String userReview, Double rating, Integer profileId) {
        this.ReviewId = reviewId;
        this.UserName = userName;
        this.Created = created;
        this.UserReview = userReview;
        this.Rating = rating;
        this.ProfileId = profileId;
    }

    public Review(String userName, Timestamp created, String userReview, Double rating, Integer profileId) {
        UserName = userName;
        Created = created;
        UserReview = userReview;
        Rating = rating;
        ProfileId = profileId;
    }

    public Integer getReviewId() {
        return ReviewId;
    }

    public void setReviewId(Integer reviewId) {
        ReviewId = reviewId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Timestamp getCreated() {
        return Created;
    }

    public void setCreated(Timestamp created) {
        Created = created;
    }

    public String getUserReview() {
        return UserReview;
    }

    public void setUserReview(String userReview) {
        UserReview = userReview;
    }

    public Double getRating() {
        return Rating;
    }

    public void setRating(Double rating) {
        Rating = rating;
    }

    public Integer getProfileId() {
        return ProfileId;
    }

    public void setProfileId(Integer profileId) {
        ProfileId = profileId;
    }



}
