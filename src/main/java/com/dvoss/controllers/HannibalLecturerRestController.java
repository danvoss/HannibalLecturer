package com.dvoss.controllers;

import com.dvoss.entities.Lecturer;
import com.dvoss.entities.Review;
import com.dvoss.services.LecturerRepository;
import com.dvoss.services.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dan on 6/30/16.
 */
@RestController
public class HannibalLecturerRestController {
    @Autowired
    LecturerRepository lecturers;
    @Autowired
    ReviewRepository reviews;


    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> getLecturer() {
        return lecturers.findAll();
    }


    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> reviews(int lecturerId) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        return reviews.findByLecturer(lecturer);
    }
}


