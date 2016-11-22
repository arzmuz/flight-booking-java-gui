/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flightbooking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import net.ucanaccess.converters.TypesMap.AccessType;
import net.ucanaccess.ext.FunctionType;
import net.ucanaccess.jdbc.UcanaccessConnection;
import net.ucanaccess.jdbc.UcanaccessDriver;

/**
 *
 * @author arzam
 */
public class NewClass {
    
public static void main(String[] args) throws ClassNotFoundException, SQLException {
   
//    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//    System.out.println("Driver loaded");
//    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://Users/arzam/Desktop/flightBookingDB.accdb"); 
//    System.out.println("Database connected");
    
    Class.forName("org.postgresql.Driver");
    System.out.println("Driver loaded");
    
    Connection connection = null;
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/flightBooking","postgres", "wavelet");
    System.out.println("Database connected");
    
    connection.close();
}
    
}
