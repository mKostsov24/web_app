package com.example.hrsample.controller;

import com.example.hrsample.amq.JmsProducer;
import com.example.hrsample.mapper.ConectionsMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/сonections")
public class ConectionsController {

    JmsProducer jmsProducer;
    private ConectionsMapper conectionsMapper;

    @Autowired
    public ConectionsController(ConectionsMapper conectionsMapper, JmsProducer jmsProducer) {
        this.conectionsMapper = conectionsMapper;
        this.jmsProducer = jmsProducer;
    }

    @PostMapping("/save")
    @ApiOperation(value = "Сохраняет связь между студентом и преподавателем по их \"id\", данные приходят в строке запроса")
    void saveConection(@RequestParam(name = "tid") Long tId,
                       @RequestParam(name = "sid") Long sId) {
        conectionsMapper.saveConection(tId, sId);
        jmsProducer.send("do do do");

    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Удаляет связь между студентом и преподавателем по их \"id\", данные приходят в строке запроса")
    void deleteConection(@RequestParam(name = "tid") Long tId,
                         @RequestParam(name = "sid") Long sId) {
        conectionsMapper.deleteConection(tId, sId);
        jmsProducer.send("do do do");
    }
}