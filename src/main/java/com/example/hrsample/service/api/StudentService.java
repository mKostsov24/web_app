package com.example.hrsample.service.api;

import com.example.hrsample.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void save(StudentDTO studentDTO);

    List<StudentDTO> getAll();

    void delete(StudentDTO studentDTO);

    void update(StudentDTO studentDTO);

    void deleteStudentById(Long id);

    List<StudentDTO> getAllStudentByTeacher(Long id);
}
