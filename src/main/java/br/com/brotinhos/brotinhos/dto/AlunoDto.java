package br.com.brotinhos.brotinhos.dto;

import br.com.brotinhos.brotinhos.enums.Course;
import br.com.brotinhos.brotinhos.enums.Period;

public class AlunoDto {
    
    private int id;
    private String student;
    private String mother;
    private String father;
    private String age;
    private String phone;
    private String email;
    
    private Course course;
    private Period period;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStudent() {
        return student;
    }
    public void setStudent(String student) {
        this.student = student;
    }
    public String getMother() {
        return mother;
    }
    public void setMother(String mother) {
        this.mother = mother;
    }
    public String getFather() {
        return father;
    }
    public void setFather(String father) {
        this.father = father;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public Period getPeriod() {
        return period;
    }
    public void setPeriod(Period period) {
        this.period = period;
    }
   
}
