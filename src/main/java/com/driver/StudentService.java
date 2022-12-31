package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;

    public void addStudent(Student student){
        studentrepository.addstudentInDB(student);
    }
    public void addTeacher(Teacher teacher){
        studentrepository.addteacherInDB(teacher);
    }
    public void addstudentTeacher(String student,String teacher){
        studentrepository.addstudentteacherINDB(student,teacher);
    }
    public Student getStudentbyName(String name){
        Student s = studentrepository.getStudentbyNameInDB(name);
        return s;
    }
    public Teacher getTeacherbyName(String name){
        Teacher t = studentrepository.getTeacherbyNameInDB(name);
        return t;
    }
    public List<String> getStudentList(String teacher){
        List<String> L = studentrepository.getStudentListInDB(teacher);
        return L;
    }
    public List<String> getAllstudentsList(){
        List<String> st = studentrepository.getAllstudentsList();
        return st;
    }
    public void deleteteacher(String name){
        studentrepository.deleteteacherinDB(name);
    }
    public void teacherstudentdelete(){
        studentrepository.deleteINDB();
    }

}
