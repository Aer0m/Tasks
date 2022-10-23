import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//javac -cp .;"D:\xampp\tomcat\lib\servlet-api.jar" XMLServlet.java

@WebServlet("/getlist")
public class XMLServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                ArrayList<String> employers = new ArrayList<>();

                try {
                    String path = "D:\\xampp\\tomcat\\webapps\\XMLReader\\";
                    File file = new File(path + "Employers_new.xml");
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(file);
                    doc.getDocumentElement().normalize();
                    System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                    NodeList nodeList = doc.getElementsByTagName("employer");


                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Node node = nodeList.item(i);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) node;
                            employers.add(eElement.getElementsByTagName("name").item(0).getTextContent());
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("employers", employers);
                getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
    }
}
