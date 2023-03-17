package com.siemens.proj.controller;

import com.siemens.proj.dao.TeacherRepository;
import com.siemens.proj.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONArray;
import org.json.JSONObject;
import flexjson.JSONDeserializer;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/byname")
    public List<Teacher> searchByFirstOrLastName(){
        return teacherRepository.findTeachersByFirstNameContainingOrLastNameContaining("a","a");
    }
    @GetMapping("/bymail")
    public Teacher searchByMail(@RequestParam String mail){
        return teacherRepository.findTeacherByMail(mail);
    }
    @PostMapping("/add")
    public void addTeacher(@RequestBody String json){
        JSONDeserializer<Teacher> deserializer = new JSONDeserializer<Teacher>();
        Teacher teacher =  new Teacher();
        deserializer.deserializeInto(json,teacher);
        teacherRepository.save(teacher);
    }
    @GetMapping("/delete")
    public void delete(@RequestParam Long Id){
        teacherRepository.deleteById(Id);
    }



}
