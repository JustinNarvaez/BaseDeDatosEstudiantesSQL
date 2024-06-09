package co.edu.unbosque.persistence.implement;

import co.edu.unbosque.dtos.StudentDTO;
import co.edu.unbosque.model.Student;
import co.edu.unbosque.persistence.InterfaceDAO;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentDAOImplement implements InterfaceDAO {



    @PersistenceContext(unitName = "StudentsPU")
    private EntityManager manager;

    @Override
    public void createStudent(Student student) {



                manager.persist(student);
                System.out.println("Student " + student.getName() + " created");


    }

    @Override
    public void deleteStudent(Student student) {

                manager.remove(student);


    }

    @Override
    public void updateStudent(Student student) {

       manager.merge(student);


    }

    @Override
    public Student getStudent(int id) {

        try{

            return manager.find(Student.class, id);

        }catch (NullPointerException e){
           e.printStackTrace();
        }


        return null;
    }

    @Override
    public ArrayList<Student> getStudents() {

        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s", Student.class);
        List<Student> students = query.getResultList();

        ArrayList<Student> studentArrayList = new ArrayList<>(students);
        return studentArrayList;

    }
}
