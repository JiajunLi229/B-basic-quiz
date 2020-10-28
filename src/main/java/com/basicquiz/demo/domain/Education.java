package com.basicquiz.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    private long id;

    @NotNull
    private long year;

    @NotNull
    @Length(min = 1, max = 256)
    private String title;

    @NotNull
    @Length(min = 1, max = 4096)
    private String description;
}
