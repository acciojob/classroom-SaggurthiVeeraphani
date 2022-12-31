package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    // hashmap for student
   HashMap<String,Student> studentMap = new HashMap<String,Student>();
   // hashmap for teacher
   HashMap<String,Teacher> teacherMap =new HashMap<String,Teacher>();
   // hashmap for pair
   HashMap<String, List<String>> teacherstudentMapping = new HashMap<String,List<String>>();;


    public void addstudentInDB(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addteacherInDB(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addstudentteacherINDB(String student,String teacher){
        List<String> studentList = teacherstudentMapping.getOrDefault(teacher,new ArrayList<>());
        studentList.add(student);
        teacherstudentMapping.put(teacher,studentList);
    }
    public Student getStudentbyNameInDB(String name){
        if(studentMap.containsKey(name)){
            return studentMap.get(name);
        }
        return null;
    }
    public Teacher getTeacherbyNameInDB(String name){
        if(teacherMap.containsKey(name)){
            return teacherMap.get(name);
        }
        return null;
    }
    public List<String> getStudentListInDB(String teacher){
        if(teacherstudentMapping.containsKey(teacher)){
            return teacherstudentMapping.get(teacher);
        }
       return null;
    }
    public List<String> getAllstudentsList(){
        List<String> AllStudent = new ArrayList<>();
        for(String s : studentMap.keySet()){
            AllStudent.add(s);
        }
        return AllStudent;
    }
    public void deleteteacherinDB(String name){
        List<String> studentList = teacherstudentMapping.get(name);
        for(String student : studentList){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        teacherstudentMapping.remove(name);
    }
    public void deleteINDB(){
        for(String teacher : teacherstudentMapping.keySet()){
            List<String> studentList = teacherstudentMapping.get(teacher);
            for(String student : studentList){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
        }
        teacherstudentMapping.clear();

    }

}
