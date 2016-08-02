/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursepairprogramming.entity;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author shneha
 */
public class Course {
   private int course_id;
    private String course_name;
    private double price;

    public Course() {
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public double getPrice() {
        return price;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
