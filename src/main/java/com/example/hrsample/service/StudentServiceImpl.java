package com.example.hrsample.service;

import com.example.hrsample.dto.StudentDTO;
import com.example.hrsample.mapper.StudentMapper;
import com.example.hrsample.model.Student;
import com.example.hrsample.service.api.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper mapper = new ModelMapper();
    private final StudentMapper studentMapper;

    @Override
    public void save(StudentDTO studentDTO) {
        Student student = mapper.map(studentDTO, Student.class);
        studentMapper.save(student);
    }

    @Override
    public List<StudentDTO> getAllStudentByTeacher(Long id) {
        return studentMapper.getAllStudentByTeacher(id).stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentMapper.getAll().stream()
                .map(student -> mapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudentById(Long id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public void delete(StudentDTO studentDTO) {
        Student student = mapper.map(studentDTO, Student.class);
        studentMapper.delete(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentMapper.deleteStudentById(id);
    }

    @Override
    public void update(StudentDTO studentDTO) {
        Student student = mapper.map(studentDTO, Student.class);
        studentMapper.update(student);
    }
}
