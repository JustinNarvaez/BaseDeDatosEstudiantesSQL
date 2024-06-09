package co.edu.unbosque.persistence;

import co.edu.unbosque.model.Student;

import java.util.ArrayList;

public interface InterfaceDAO {

    public void createStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Student student);
    public Student getStudent(int id);
    public ArrayList<Student> getStudents();


}
