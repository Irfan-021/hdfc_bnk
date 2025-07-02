package com.crm.mapper;

import com.crm.entity.Student;
import com.crm.payload.StudentDTO;

import java.net.HttpRetryException;

public class StudentMapper {

    public static Student mapToEntity(StudentDTO dto){

        if(dto==null)return null;

        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setMobile(dto.getMobile());

        return student;
    }

    public static StudentDTO mapToDTO(Student student){
        if(student == null){
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setMobile(student.getMobile());

        return studentDTO;
    }
    
}
