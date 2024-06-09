package co.edu.unbosque.view;

import co.edu.unbosque.dtos.StudentDTO;
import co.edu.unbosque.model.Student;
import co.edu.unbosque.persistence.DataMapper;
import co.edu.unbosque.services.StudentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;

@Named
@RequestScoped
public class  StudentBean implements Serializable {

    private String string;
    private String string2;
    private String string3;
    private String string4;
    private boolean studentFound = false;
    private static final long serialVersionUID = 1L;
    StudentDTO studentDTO= new StudentDTO();


    @Inject
    private StudentService  studentService;
    private ArrayList<StudentDTO> students= new ArrayList<StudentDTO>();



    public void register() {
        int id = studentService.registerStudent(studentDTO);
        if (id != -1) {
            String nombreRegistrado = studentDTO.getName();
            students.add(studentDTO);
            studentDTO = new StudentDTO();
            string = "Gracias por registrarte señor " + nombreRegistrado + ", su id es: " + id;
        } else {
            string = "Error al registrar el estudiante.";
        }
    }


    public void findStudent() {

        StudentDTO foundStudent = studentService.findStudent(studentDTO.getIdStudent());
        if (foundStudent != null) {

            studentDTO = foundStudent;

            string2 = "Estudiante encontrado " + studentDTO.getName() + " " + studentDTO.getSubject();
        } else {
            string2 = "Estudiante no encontrado";
        }

    }

    public void deleteStudent() {

        studentService.deleteStudent(studentDTO.getIdStudent());

        string3 = "Estudiante eliminado ";


    }

    public void updateStudent(){

        studentService.updateStudent(studentDTO,studentDTO.getIdStudent());
        string4 = "El estudiante se actualizo exitosamente:  "+studentDTO.getName()+", "+studentDTO.getSubject();

    }public String getString4(){
        return string4;
    }

    public String getString3(){
        return string3;
    }

    public String getString2(){
        return string2;
    }

    public String getString(){
        return string;
    }




    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public ArrayList<StudentDTO> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<StudentDTO> students) {
        this.students = students;
    }


}
