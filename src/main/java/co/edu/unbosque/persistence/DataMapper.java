package co.edu.unbosque.persistence;

import co.edu.unbosque.dtos.StudentDTO;
import co.edu.unbosque.model.Student;

public class DataMapper {

    public static Student DTOToEntity(StudentDTO studentDTO){

        Student student = new Student();

        student.setIdStudent(studentDTO.getIdStudent());
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setSubject(studentDTO.getSubject());

        return student;

    }

    public static StudentDTO EntityToDTO(Student student) {

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setIdStudent(student.getIdStudent());
        studentDTO.setName(student.getName());
        studentDTO.setAge(student.getAge());
        studentDTO.setSubject(student.getSubject());

        return studentDTO;


    }
}
