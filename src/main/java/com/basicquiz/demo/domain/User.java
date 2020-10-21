package com.basicquiz.demo.domain;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long userId;

    @NotNull
    @Length(min = 1, max = 128)
    private String name;

    @NotNull
    @Min(17)
    private long age;

    @NotNull
    @Length(min = 8, max = 512)
    private String avatar;

    @Length(max = 1024)
    private String description;

}
