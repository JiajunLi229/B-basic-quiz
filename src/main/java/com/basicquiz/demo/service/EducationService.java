package com.basicquiz.demo.service;

import com.basicquiz.demo.domain.Education;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EducationService {
    private final Map<Long, List<Education>> educationListMap = new HashMap<>();
    private final List<Education> educationArrayList = new ArrayList<>();

    public EducationService() {
        educationArrayList.add(new Education(1L, 2005, "Secondary school specializing in artistic", "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus."));
        educationArrayList.add(new Education(1L, 2009, "First level graduation in Graphic Design", "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus."));
        educationListMap.put(1L, educationArrayList);

    }

    public List<Education> getEducationListById(Long id) {
        List<Education> educationArrayList = educationListMap.get(id);
        if (educationArrayList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Education background not found");
        }
        return educationArrayList;
    }

    public void createEducationInformation(Long id, Education education) {
        education.setId(id);
        if (educationListMap.containsKey(id)) {
            educationListMap.get(id).add(education);
        } else {
            List<Education> educationList = new ArrayList<>();
            educationList.add(education);
            educationListMap.put(id, educationList);
        }


    }


}
