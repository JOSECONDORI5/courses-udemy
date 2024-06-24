package classes.streams;

import java.util.Objects;

public class Review {
    private String comment;
    private Integer score;

    public Review() {
    }

    /**
     * @param review
     * @param score
     */
    public Review(String review, Integer score) {
        this.comment = review;
        this.score = score;
    }

    /**
     * @return the review
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param review the review to set
     */
    public void setComment(String review) {
        this.comment = review;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String json = """
                {"review":"%s","score":%d}
                """;
        return String.format(json, comment, score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review review)) return false;
        return Objects.equals(comment, review.comment) && Objects.equals(score, review.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, score);
    }
}
