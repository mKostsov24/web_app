package com.example.hrsample.controller;


import com.example.hrsample.amq.JmsProducer;
import com.example.hrsample.dto.TeacherDTO;
import com.example.hrsample.service.api.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    JmsProducer jmsProducer;
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService, JmsProducer jmsProducer) {
        this.teacherService = teacherService;
        this.jmsProducer = jmsProducer;
    }


    @GetMapping
    @ApiOperation(value = "Возвращает всех преподавателей")
    public List<TeacherDTO> getAll() {
        jmsProducer.send("do do do");
        return teacherService.getAll();
    }

    @GetMapping("/by/{id}")
    @ApiOperation(value = "Возвращает всех преподавателей студента с данным \"id\"")
    public List<TeacherDTO> getAllTeachersByStudent(@PathVariable Long id) {
        jmsProducer.send("do do do");
        return teacherService.getAllTeachersByStudent(id);
    }

    @PostMapping("/save")
    @ApiOperation(value = "Позволяет сохранять преподавателя,пришедшего в теле запроса ", notes = "Поле \"id\" вводить ненужно")
    public void save(@RequestBody TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);
        jmsProducer.send("do do do");
    }


    @PostMapping("/delete")
    @ApiOperation(value = "Удаляет преподавателя из БД по его \"id\"", notes = "В теле запроса указывается \"id\" преподавателя")
    public void delete(@RequestBody TeacherDTO teacherDTO) {
        teacherService.delete(teacherDTO);
        jmsProducer.send("do do do");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Удаляет преподавателя из БД по его \"id\"", notes = "В строке запроса указывается \"id\" преподавателя")
    public void deleteTeacherById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        jmsProducer.send("do do do");
    }

    @PostMapping("/update")
    @ApiOperation(value = "Обновляет информацию преподавателя по его \"id\" из тела запроса", notes = "В теле запроса необходимо указать обновленную информацию преподавателя")
    public void update(@RequestBody TeacherDTO teacherDTO) {
        teacherService.update(teacherDTO);
        jmsProducer.send("do do do");
    }


}