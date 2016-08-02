/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursepairprogramming.entity.dao;

import coursepairprogramming.entity.Course;
import java.util.List;

/**
 *
 * @author shneha
 */
public interface CourseDAO {
     boolean insert(Course c);
     List <Course> getAll();
      boolean  searchById(int id);
}
    
    

