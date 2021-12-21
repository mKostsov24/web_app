package com.example.hrsample.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Преподаватель DTO", description = "Data Transfer Object для сущности преподавателя")
public class TeacherDTO {
    private Long teacherId;
    private String fio;
    private String faculty;
}
