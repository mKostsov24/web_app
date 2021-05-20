package com.example.hrsample.dto;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Студент DTO", description = "Data Transfer Object для сущности студента")
public class StudentDTO {
    private Long studentId;
    private String fio;
    private String course;
    private String specialty;
}
