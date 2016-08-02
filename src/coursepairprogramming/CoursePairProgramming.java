/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursepairprogramming;

import coursepairprogramming.entity.Course;
import coursepairprogramming.entity.Enquiry;
import coursepairprogramming.entity.dao.CourseDAO;
import coursepairprogramming.entity.dao.EnquiryDAO;
import coursepairprogramming.entity.dao.impl.CourseDAOImpl;
import coursepairprogramming.entity.dao.impl.EnquiryDAOImpl;
import coursepairprogramming.process.ProgramController;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author shneha
 */
public class CoursePairProgramming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        EnquiryDAO enquiryDAO=new EnquiryDAOImpl() ;
        CourseDAO courseDAO =new CourseDAOImpl();
 ProgramController pc=new ProgramController(courseDAO, enquiryDAO);
        pc.process();
        

    }
    
}
