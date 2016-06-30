package com.dvoss.controllers;

import com.dvoss.entities.Lecturer;
import com.dvoss.entities.Review;
import com.dvoss.services.LecturerRepository;
import com.dvoss.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;


/**
 * Created by Dan on 6/30/16.
 */
@Controller
public class HannibalLecturerController {
    @Autowired
    LecturerRepository lecturers;
    @Autowired
    ReviewRepository reviews;

    Server dbui = null;
    @PostConstruct
    public void init() throws SQLException {
        dbui = Server.createWebServer().start();
    }
    @PreDestroy
    public void destroy() {
        dbui.stop();
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public String createLecturer(String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
        return "redirect:/";
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public String createReview(String author, String text, boolean isGood, int lecturerId) {
        Lecturer l = lecturers.findOne(lecturerId);
        Review review = new Review(author, text, isGood, l);
        reviews.save(review);
        return "redirect:/";
    }
}
