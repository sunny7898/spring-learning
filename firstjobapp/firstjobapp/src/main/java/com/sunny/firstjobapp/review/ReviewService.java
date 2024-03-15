package com.sunny.firstjobapp.review;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId) ;
    boolean addReview(Long companyId, Review reviewData);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deleteReview(Long companyId, Long reviewId);
}
