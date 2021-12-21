package com.example.hrsample.service;

import com.example.hrsample.dto.TeacherDTO;
import com.example.hrsample.mapper.TeacherMapper;
import com.example.hrsample.model.Teacher;
import com.example.hrsample.service.api.TeacherService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceIlmpl implements TeacherService {

    private final ModelMapper mapper = new ModelMapper();
    private final TeacherMapper teacherMapper;

    @Override
    public void save(TeacherDTO teacherDTO) {
        Teacher teacher = mapper.map(teacherDTO, Teacher.class);
        teacherMapper.save(teacher);
    }

    @Override
    public List<TeacherDTO> getAll() {
        return teacherMapper.getAll().stream()
                .map(teacher -> mapper.map(teacher, TeacherDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public void delete(TeacherDTO teacherDTO) {
        Teacher teacher = mapper.map(teacherDTO, Teacher.class);
        teacherMapper.delete(teacher);
    }

    @Override
    public void update(TeacherDTO teacherDTO) {
        Teacher teacher = mapper.map(teacherDTO, Teacher.class);
        teacherMapper.update(teacher);
    }

    @Override
    public List<TeacherDTO> getAllTeachersByStudent(Long id) {
        return teacherMapper.getAllTeacherByStudent(id).stream()
                .map(teacher -> mapper.map(teacher, TeacherDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherMapper.deleteTeacherById(id);
    }
}
