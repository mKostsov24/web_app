package com.example.hrsample.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "Преподаватель", description = "Сущность преподавателя")
public class Teacher {
    private Long teacherId;
    private String fio;
    private String faculty;
}
