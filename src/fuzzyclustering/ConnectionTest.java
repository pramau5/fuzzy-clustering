/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyclustering;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mpromod
 */
public class ConnectionTest {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
            System.out.println("Connection: " + conn);
        } catch (Exception exception) {

            exception.printStackTrace();
        }
    }
}
