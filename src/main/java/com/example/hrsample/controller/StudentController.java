package com.example.hrsample.controller;

import com.example.hrsample.amq.JmsProducer;
import com.example.hrsample.dto.StudentDTO;
import com.example.hrsample.model.Student;
import com.example.hrsample.service.api.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Validated
@RequiredArgsConstructor
public class StudentController {

    private final JmsProducer jmsProducer;
    private final StudentService studentService;
    private static final String MASSAGE = "do do do";

    @GetMapping
    @ApiOperation(value = "Возвращает всех студентов")
    public List<StudentDTO> getAll() {
        jmsProducer.send(MASSAGE);
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает информацию о студенте по его \"id\"", notes = "В теле запроса указывается \"id\" студента")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }


    @GetMapping("/by/{id}")
    @ApiOperation(value = "Возвращает всех студентов преподавателя с данным \"id\"")
    public List<StudentDTO> getAllStudentByTeacher(@PathVariable Long id) {
        jmsProducer.send(MASSAGE);
        return studentService.getAllStudentByTeacher(id);

    }

    @PostMapping("/save")
    @ApiOperation(value = "Позволяет сохранять студента,пришедшего в теле запроса ", notes = "Поле \"id\" вводить ненужно")
    public void save(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
        jmsProducer.send(MASSAGE);
    }

    @DeleteMapping
    @ApiOperation(value = "Удаляет студенрта из БД по его \"id\"", notes = "В теле запроса указывается \"id\" студента")
    public void delete(@RequestBody StudentDTO studentDTO) {
        studentService.delete(studentDTO);
        jmsProducer.send(MASSAGE);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет студента из БД по его \"id\"", notes = "В теле запроса указывается \"id\" студента")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        jmsProducer.send(MASSAGE);
    }

    @PostMapping("/update")
    @ApiOperation(value = "Обновляет информацию студента по его \"id\" из тела запроса", notes = "В теле запроса необходимо указать \"id\" и обновленную информацию студента")
    public void update(@RequestBody StudentDTO studentDTO) {
        studentService.update(studentDTO);
        jmsProducer.send(MASSAGE);
    }
}