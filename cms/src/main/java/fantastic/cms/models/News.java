package fantastic.cms.models;

import java.util.Set;
import lombok.Data;

@Data
public class News {
    String id;
    String title;
    String content;
    User author;

    Set<User> mandatoryReviewers;
    Set<Review> reviews;
    Set<Category> categories;
    Set<Tag> tags;

    public Review addReview(String userId, Status status) {
        final Review review = new Review(userId, status);
        this.reviews.add(review);
        return review;
    }

    public Boolean revised() {
        return this.mandatoryReviewers.stream()
                .allMatch(reviewer -> this.reviews.stream()
                        .anyMatch(review -> reviewer.id.equals(review.userId) &&
                                Status.APPROVED == review.status));
    }


    public Set<Review> getReviews() {
        return reviews;
    }

    public void deleteReview(String reviewId) {
        reviews.removeIf(review -> review.getUserId().equals(reviewId));
    }

}
