<%@ page import="java.util.ArrayList" pageEncoding="UTF-8" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
</head>
<body>
<ul>
    <%
        ArrayList<String> employers = (ArrayList<String>) (request.getAttribute("employers"));
        PrintWriter output = response.getWriter();
        for(int i = 0; i < employers.toArray().length; i++){

            output.println("<li>" + "<a href='#'>" + employers.get(i) + "</a>" + "</li>");
        }
    %>
</ul>
</body>
</html>