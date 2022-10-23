package app.servlets;

import database.config.DbConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

//javac -cp .;"D:\xampp\tomcat\lib\servlet-api.jar" app.servlets.Office.java

@WebServlet("/profile")
public class Profile extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                ArrayList<String> employers = new ArrayList<>();
                response.setContentType("text/html");

                String person = request.getParameter("person");
                final String url = "jdbc:postgresql://localhost/users";
                final String user = "postgres";
                final String password = "123";

                try{
                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM employers");
                        int iter = 0;
                        while (resultSet.next()){
                            iter++;
                            if(Objects.equals(person, resultSet.getString(iter))){
                                person = resultSet.getString(iter);
                                break;
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("person", person);
                getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
