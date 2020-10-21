package com.basicquiz.demo.controller;

import com.basicquiz.demo.domain.Education;
import com.basicquiz.demo.service.EducationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @RequestMapping(value = "/users/{id}/educations", method = RequestMethod.GET)
    @ResponseBody
    public List<Education> getEducationListById(@PathVariable long id) {
        return educationService.getEducationListById(id);
    }
}