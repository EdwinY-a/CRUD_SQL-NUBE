package com.example.examen_mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {
    Connection conn;

    public Connection open(){
        String url="jdbc:mysql://udrw0lln7sulfh2a:e4ryk6BiVGCzAlhkAaVK@bce9cs51gsbadpjupgwb-" +
                "mysql.services.clever-cloud.com:3306/bce9cs51gsbadpjupgwb";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url);
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void close(){
        if (conn!=null){
            try{
                conn.close();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("Exception controlada.");
            }
        }
    }
}
