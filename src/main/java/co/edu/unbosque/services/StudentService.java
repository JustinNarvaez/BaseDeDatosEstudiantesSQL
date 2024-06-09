package co.edu.unbosque.services;

import co.edu.unbosque.dtos.StudentDTO;
import co.edu.unbosque.model.Student;
import co.edu.unbosque.persistence.DataMapper;
import co.edu.unbosque.persistence.InterfaceDAO;
import co.edu.unbosque.persistence.implement.StudentDAOImplement;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;

@Stateful
public class StudentService {


    @Inject
    InterfaceDAO interfaceDAO;


    public int registerStudent(StudentDTO studentDTO) {
        try {
            Student student = DataMapper.DTOToEntity(studentDTO);
            interfaceDAO.createStudent(student);
            return student.getIdStudent(); // Devuelve el ID generado
        } catch (PersistenceException e) {
            e.printStackTrace();
            return -1; // Retorna -1 si ocurre un error
        }
    }


    public StudentDTO findStudent(int idStudent) {

        try {

            Student studentAux = interfaceDAO.getStudent(idStudent);
            if (studentAux != null) {

                return DataMapper.EntityToDTO(studentAux);
            }else {
                return null;
            }

        } catch (PersistenceException e) {

            e.printStackTrace();
             return null;
        }


    }

    public void deleteStudent(int idStudent) {

        Student student = interfaceDAO.getStudent(idStudent);
        if (student != null) {

            interfaceDAO.deleteStudent(student);

        }else{

            System.out.println("El estudiante no existe");
        }



    }

    public StudentDTO updateStudent(StudentDTO studentDTO, int idStudent) {

        Student student = interfaceDAO.getStudent(idStudent);
        if (student != null) {

            student.setName(studentDTO.getName());
            student.setSubject(studentDTO.getSubject());
            student.setAge(student.getAge());
            return DataMapper.EntityToDTO(student);

        }

        return null;

    }

}
