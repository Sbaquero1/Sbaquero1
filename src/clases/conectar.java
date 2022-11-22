/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author Stiven Baquero
 */
public class conectar {
    
    
    Connection cn;
    Statement as;
    
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3308/escuela";
    
    public Connection conexion(){
 
        try {
                    Class.forName(driver);
            // Nos conectamos a la bd
            cn= (Connection) DriverManager.getConnection(url, user, pass);
                       
                       System.out.println("conectado");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    
    
 return cn;

    }

    public PreparedStatement prepareStatement(String insert_into_curso_nomre_curso_VALUES_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
