package com.example.hrsample.service.api;

import com.example.hrsample.dto.TeacherDTO;
import com.example.hrsample.model.Teacher;

import java.util.List;

public interface TeacherService {
    void save(TeacherDTO teacherDTO);

    List<TeacherDTO> getAll();

    Teacher getTeacherById(Long id);

    void delete(TeacherDTO teacherDTO);

    void update(TeacherDTO teacherDTO);

    void deleteTeacherById(Long id);

    List<TeacherDTO> getAllTeachersByStudent(Long id);
}
