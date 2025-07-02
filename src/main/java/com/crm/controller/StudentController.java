package com.crm.controller;

import com.crm.entity.Student;
import com.crm.payload.StudentDTO;
import com.crm.repository.StudentRepository;
import com.crm.service.StudentService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;
    private final StudentRepository studentRepository;

    public StudentController(StudentService studentService,
                             StudentRepository studentRepository) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @RequestParam Long id){
        return  new ResponseEntity<>(studentService.updateStudent(student, id),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);
        return  new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
       return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/byId")
    public ResponseEntity<Student> getStudentById(@RequestParam Long id){
        Student studentbyId = studentService.getStudentbyId(id);
        return  new ResponseEntity<>(studentbyId, HttpStatus.OK);
    }

    @PostMapping("/addStu")
    public ResponseEntity<StudentDTO> createStudent1(@RequestBody StudentDTO studentDTO){
        StudentDTO student1 = studentService.createStudent1(studentDTO);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/updateStu")
    public ResponseEntity<StudentDTO> updateSTudent(@RequestBody StudentDTO studentDTO, @RequestParam Long id){
        StudentDTO studentDTO1 = studentService.updateStudent1(studentDTO, id);
        return new ResponseEntity<>(studentDTO1, HttpStatus.OK);
    }

    public ResponseEntity<List<StudentDTO>> getAllSTudent(){
        studentService.getAllSTudent();
    }
}

