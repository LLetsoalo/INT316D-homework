<%-- 
    Document   : add_outcome
    Created on : 01 May 2024, 2:51:17 PM
    Author     : Student
--%>


<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Added</h1>
        <%
            String name = request.getAttribute("name").toString();
            String nickname = request.getAttribute("nickname").toString();
            String id = request.getAttribute("id").toString();
            String address = request.getAttribute("address").toString();
            byte[] img = (byte[]) request.getAttribute("picture");
            String picture = "data:image/png;base64," + Base64.getEncoder().encodeToString(img);
        %>

        <table border="1">
            
            <th>ID</th>
            <th>Name</th>
            <th>Nickname</th>
            <th>Address</th>
            <th>Picture</th>
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
                <td><%=nickname%></td>
                <td><%=address%></td>
                <td><img src="<%=picture%>" height="125px"></td>
            </tr>
        </table>


        <br> <br>
        return to menu <a href="index.html"> home</a>
    </body>
</html>
