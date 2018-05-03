/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ovidiomolina
 */
public class JSON {
    private static final String STUDENTS = "/Users/ovidiomolina/NetBeansProjects/StudyWithMaven/src/main/java/com/ovidiomolina/studywithmaven/students.json";
    public static void main(String args[]) {
        try {
            List<Student> students = studentsFromJson();
        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static List<Student> studentsFromJson() throws IOException {
        String json = getJsonString();
        List<Student> students = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(json);
        if(element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            Iterator<JsonElement> jsonIterator = jsonArray.iterator();
            
            while(jsonIterator.hasNext()) {
                JsonElement current = jsonIterator.next();
                JsonObject jsonObj = current.getAsJsonObject();
                String name = jsonObj.get("name").getAsString();
                String id = jsonObj.get("id").getAsString();
                Student student = new Student(name, id);
                List<Course> courses = new ArrayList<>();
                JsonArray coursesArray = jsonObj.get("courses").getAsJsonArray();
                Iterator<JsonElement> coursesIterator = coursesArray.iterator();
                while(coursesIterator.hasNext()) {
                    JsonElement courseData = coursesIterator.next();
                    JsonObject courseJsonData = courseData.getAsJsonObject();
                    String courseName = courseJsonData.get("name").getAsString();
                    String courseId = courseJsonData.get("id").getAsString();
                    courses.add(new Course(courseId, courseName));
                }
                student.setCourses(courses);
                students.add(student);
            }
        }
        return students;
    }
    
    private static String getJsonString() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(STUDENTS));
        StringBuilder sb = new StringBuilder();
        while(br.ready()) {
            sb.append(br.readLine());
        }
        return sb.toString();
    }
}
