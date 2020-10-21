package com.basicquiz.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId;
    private String name;
    private long age;
    private String avatar;
    private String description;

}
