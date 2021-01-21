
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ocama
 */
public class DAOcalc {
        Connection con = null;
    
    void connection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gpacalculator","root","");
        Statement st = con.createStatement();
        }
        catch(Exception ex){
            System.out.print(ex);        
            System.out.print("in connect");        

        }
    }
    
    int LoginCheck(Student S){
        int res=0;
        try{
        connection();
        String query = "Insert into registration values(?,?,?.?)";
        
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,S.id);
        pst.setInt(1,S.rollno);
        pst.setString(2,S.name);
        pst.setString(3,S.degree);
        

        res = pst.executeUpdate();
        if(res>0){
           System.out.print("OH YES IT WORKED");        
        }
        else
        {
           System.out.print("OH SNAP! Error Ocurred");        

        }
        }
        catch(Exception ex){
           System.out.print("OH SNAP");        
             System.out.print(ex);        
        }
        return res;
    }
}
