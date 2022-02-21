package com.luv2code.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user="springstudent";
        String pass="springstudent";
        String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver="com.mysql.jdbc.Driver";
        try{
            PrintWriter out= resp.getWriter();

            out.println("Connecting to database: "+jdbcUrl);

            Class.forName(driver);

            Connection myConn= DriverManager.getConnection(jdbcUrl,user,pass);
            out.println("SUCCESS!!!");
            myConn.close();
        }catch (Exception exc){
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
