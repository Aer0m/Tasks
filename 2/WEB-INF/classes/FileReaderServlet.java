import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getList")
public class FileReaderServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                PrintWriter writer = response.getWriter();
                String path = "D:\\xampp\\tomcat\\webapps\\FileReader\\";
                String str;
                ArrayList<String> employers = new ArrayList<>();

                try{
                    BufferedReader input = new BufferedReader(new java.io.FileReader(path + "file.txt"));
                    int k = 1;
                    while((str = input.readLine()) != null) {
                        employers.add(str.toLowerCase());
                        k++;
                    }
                    input.close();
                }

                catch (FileNotFoundException e){
                    writer.println("<p>Файл не найден" + e + "</p>");
                }

                catch (IOException e){
                    writer.println("<p>Ошибка доступа к файлу:" + e + "</p>");
                }

                writer.println("<p>Считывание завершено</p>");
                
                request.setAttribute("employers", employers);
                getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
    }
}
