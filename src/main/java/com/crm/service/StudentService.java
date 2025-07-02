package com.crm.service;

import com.crm.entity.Student;
import com.crm.payload.StudentDTO;
import com.crm.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    public Student updateStudent(Student student, Long id) {
        Student student1 = studentRepository.findById(id).get();

        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setMobile(student.getMobile());

        return studentRepository.save(student1);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentbyId(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public StudentDTO createStudent1(StudentDTO studentDTO) {
        Student student = mapToEntity(studentDTO);
        Student save = studentRepository.save(student);
        StudentDTO studentDTO1 = mapToDTO(save);

        return studentDTO1;
    }

    Student mapToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setMobile(studentDTO.getMobile());

        return student;
    }

    StudentDTO mapToDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMobile(student.getMobile());

        return studentDTO;
    }

    public StudentDTO updateStudent1(StudentDTO studentDTO, Long id) {
        Student student = studentRepository.findById(id).get();

        Student student1 = mapToEntity(studentDTO);
        student1.setId(student.getId());

        Student save = studentRepository.save(student1);
        StudentDTO studentDTO1 = mapToDTO(save);

        return studentDTO1;

    }

    public List<StudentDTO> getAllSTudent() {
        // ADD COMMENT HERE
        List<Student> all = studentRepository.findAll();
        List<StudentDTO> collect = all.stream().map(this::mapToDTO).collect(Collectors.toList());
        return collect;

    }


    public Student getByEmail(String email) {
        return studentRepository.getByEmail(email);
    }
}
