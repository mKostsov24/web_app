package com.example.hrsample.controller;

import com.example.hrsample.amq.JmsProducer;
import com.example.hrsample.dto.StudentDTO;
import com.example.hrsample.model.Student;
import com.example.hrsample.service.api.StudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Validated
public class StudentController {

    JmsProducer jmsProducer;
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService, JmsProducer jmsProducer) {
        this.studentService = studentService;
        this.jmsProducer = jmsProducer;
    }

    @GetMapping
    @ApiOperation(value = "Возвращает всех студентов")
    public List<StudentDTO> getAll() {
        jmsProducer.send("do do do");
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Возвращает информацию о студенте по его \"id\"",notes = "В теле запроса указывается \"id\" студента")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }


    @GetMapping("/by/{id}")
    @ApiOperation(value = "Возвращает всех студентов преподавателя с данным \"id\"")
    public List<StudentDTO> getAllStudentByTeacher(@PathVariable Long id) {
        jmsProducer.send("do do do");
        return studentService.getAllStudentByTeacher(id);

    }


    @PostMapping("/save")
    @ApiOperation(value = "Позволяет сохранять студента,пришедшего в теле запроса ", notes = "Поле \"id\" вводить ненужно")
    public void save(@RequestBody StudentDTO studentDTO) {
        studentService.save(studentDTO);
        jmsProducer.send("do do do");
    }


    @DeleteMapping
    @ApiOperation(value = "Удаляет студенрта из БД по его \"id\"", notes = "В теле запроса указывается \"id\" студента")
    public void delete(@RequestBody StudentDTO studentDTO) {
        studentService.delete(studentDTO);
        jmsProducer.send("do do do");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет студента из БД по его \"id\"", notes = "В теле запроса указывается \"id\" студента")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        jmsProducer.send("do do do");
    }

    @PostMapping("/update")
    @ApiOperation(value = "Обновляет информацию студента по его \"id\" из тела запроса", notes = "В теле запроса необходимо указать \"id\" и обновленную информацию студента")
    public void update(@RequestBody StudentDTO studentDTO) {
        studentService.update(studentDTO);
        jmsProducer.send("do do do");
    }


}