package com.texas.Miniproject.controllers;

import com.texas.Miniproject.entity.Class;
import com.texas.Miniproject.services.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping
    public ResponseEntity<Class> save(@RequestBody Class class){
        return new ResponseEntity<>(classService.saveClass(class), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Class> listClass() {
        return classService.listAllClass();
    }

    @GetMapping("/{id}")
    public Optional<Class> getById(@PathVariable Long id){
        return classService.getClassById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable Long id){
        classService.deleteClass(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Class> update(@RequestBody Class department){
        return new ResponseEntity<>(classService.updateClass(class), HttpStatus.OK);
    }
}
