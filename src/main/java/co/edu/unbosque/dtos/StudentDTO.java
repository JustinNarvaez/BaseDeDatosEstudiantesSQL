package co.edu.unbosque.dtos;

public class StudentDTO {

    private int idStudent;
    private String name;
    private int age;
    private String subject;

    public StudentDTO(int idStudent, String name, int age, String subject) {
        this.idStudent = idStudent;
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public StudentDTO() {
        // Constructor vacío necesario para algunas operaciones
    }

    // Getters y setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}
