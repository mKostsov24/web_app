package com.example.hrsample.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel(value = "Студент", description = "Сущность студента")
public class Student {
    private Long studentId;
    private String fio;
    private String course;
    private String specialty;
}
