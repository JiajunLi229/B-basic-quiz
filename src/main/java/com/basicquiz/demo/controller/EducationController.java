package com.basicquiz.demo.controller;
import com.basicquiz.demo.domain.Education;
import com.basicquiz.demo.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//TODO GTB-知识点: - 用 @RestController 替代 @Controller 和 @ResponseBody 的组合。
//TODO GTB-知识点: - 用 @GetMapping、@PostMapping 等代替 @RequestMapping。

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

    @RequestMapping(value = "/users/{id}/educations", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEducationInformation(@PathVariable Long id, @RequestBody @Valid Education education) {
        educationService.createEducationInformation(id, education);
    }
}
