package com.dvoss.services;

import com.dvoss.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Dan on 6/30/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer>{
}
