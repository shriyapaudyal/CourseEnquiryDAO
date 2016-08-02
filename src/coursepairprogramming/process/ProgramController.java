/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursepairprogramming.process;

import coursepairprogramming.entity.Course;
import coursepairprogramming.entity.Enquiry;
import coursepairprogramming.entity.dao.CourseDAO;
import coursepairprogramming.entity.dao.EnquiryDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author shneha
 */
public class ProgramController {
    CourseDAO courseDAO;
    EnquiryDAO enquiryDAO;
    

    public ProgramController(CourseDAO courseDAO, EnquiryDAO enquiryDAO) {
        this.courseDAO = courseDAO;
        this.enquiryDAO = enquiryDAO;
    }
    
     private void course() throws FileNotFoundException, IOException
    {
        System.out.println("Reading course.csv....");
        try ( 
            BufferedReader bufferedReader=new BufferedReader(new FileReader("C:\\Users\\shneha\\Desktop\\course.csv")))
                {
            String line="";
            while((line=bufferedReader.readLine())!=null)
            {
                Course c = new Course();
                String[] tokens=line.split(",");
                c.setCourse_id(Integer.parseInt(tokens[0]));
                c.setCourse_name(tokens[1]);
                c.setPrice(Double.parseDouble(tokens[2]));
                
                courseDAO.insert(c);
                if (!courseDAO.insert(c)) {
                    System.out.println("Cannot Insert into Course array.");
                }
                
                
            }
            
            bufferedReader.close();
        }
    }
    
      private void enquiry() throws FileNotFoundException, IOException
    {
         System.out.println("Reading enquiry.csv..");
         
        try ( BufferedReader bufferedReader1 = new BufferedReader(new FileReader("C:\\Users\\shneha\\Desktop\\enquiry.csv"))) {
            BufferedWriter errorwriter =new BufferedWriter(new FileWriter("C:\\Users\\shneha\\Desktop\\error.csv"));
         BufferedWriter outputwriter =new BufferedWriter(new FileWriter("C:\\Users\\shneha\\Desktop\\output.csv"));
            String line1="";
            while((line1=bufferedReader1.readLine())!=null)
            {
                String[] tokens1=line1.split(",");
                Enquiry e = new Enquiry();
                if(enquiryDAO.searchByemail(tokens1[4])||(!courseDAO.searchById(Integer.parseInt(tokens1[1]))))
                {
                    writeToErrorFile(tokens1,errorwriter);
                }
                else{
                    
                    e.setStudentId(Integer.parseInt(tokens1[0]));
                    e.setCourseId(Integer.parseInt(tokens1[1]));
                    e.setFirstName(tokens1[2]);
                    e.setLastName(tokens1[3]);
                    e.setEmail(tokens1[4]);
                    
                    enquiryDAO.insert(e);
                    
                    writeToOutputFile(e,outputwriter);
                    
                    if (!enquiryDAO.insert(e)) {
                        System.out.println("Cannot Insert into Enquiry array.");
                    }
                }
                
            }
              errorwriter.close();
              outputwriter.close();
              bufferedReader1.close();
            
        }
         
        
        
    }
    
    private void writeToErrorFile(String[] array,BufferedWriter errorwriter) throws IOException
    {
        
                
                 
            
                try {
                    
                    errorwriter.write(array[0]+","+array[1]+","+array[2]+"," +array[3]+","+array[4]);
                    errorwriter.newLine();
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            
       
          
        
                    
    }
    
    private void writeToOutputFile(Enquiry e,BufferedWriter outputwriter) throws IOException
    {        
                try {
                    
                    outputwriter.write(e.getStudentId()+","+e.getCourseId()+","+e.getFirstName()+","+e.getLastName()+","+e.getEmail());
                    outputwriter.newLine();
                    
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
           
           
         
        
                    
                
    }
   public void process() throws IOException
    {
        
        course();
        System.out.println("==========================");
       
        enquiry();
    }  
    
}

    
    

