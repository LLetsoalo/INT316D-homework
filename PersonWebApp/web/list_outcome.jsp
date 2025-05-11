<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entities.Person"%>
<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #007bff;
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
            border: 1px solid #dee2e6;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #dee2e6;
        }
        th {
            background-color: #007bff;
            color: #fff;
        }
        tbody tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tbody tr:hover {
            background-color: #dcdcdc;
        }
        img {
            max-height: 125px;
            max-width: 125px;
        }
        a {
            color: #007bff;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>CITIZENS OF OOO!</h1>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Nickname</th>
                <th>Address</th>
                <th>Picture</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Person> list = (List<Person>) request.getAttribute("list");

                for (int i = 0; i < list.size(); i++) {

                    String name = list.get(i).getName();
                    String nickname = list.get(i).getNickname();
                    int id = list.get(i).getId();
                    String address = list.get(i).getAddress();
                    String picture = "data:image/png;base64," + Base64.getEncoder().encodeToString(list.get(i).getPicture());
            %>
            <tr>
                <td><%=id%></td>
                <td><%=name%></td>
                <td><%=nickname%></td>
                <td><%=address%></td>
                <td><img src="<%=picture%>" alt="Profile Picture"></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <br> <br>
    Return to menu <a href="index.html">home</a>
</body>
</html>
