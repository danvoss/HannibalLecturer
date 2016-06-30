package com.dvoss.services;

import com.dvoss.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dan on 6/30/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
