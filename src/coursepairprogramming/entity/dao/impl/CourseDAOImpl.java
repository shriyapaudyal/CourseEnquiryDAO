/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursepairprogramming.entity.dao.impl;

import coursepairprogramming.entity.Course;
import coursepairprogramming.entity.dao.CourseDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shneha
 */
public class CourseDAOImpl implements CourseDAO {

    private int counter = 0;
    private List<Course> courseList = new ArrayList<>();

    @Override
    public boolean insert(Course c) {
        return courseList.add(c);
    }

    @Override
    public List<Course> getAll() {
        return courseList;
    }

    @Override
    public boolean searchById(int id) {
        for (Course c : courseList) {
            if (c.getCourse_id() == id) {
                return true;
            }
        }
        return false;
    }
}
