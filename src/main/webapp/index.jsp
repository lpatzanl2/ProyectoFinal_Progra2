
<h2>Hello World!</h2>
<%@page import="Connection.api_nyt" %>
<%@page import="javax.swing.table.DefaultTableModel" %>



<html>
<head>
    <title>JSP Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>


<body>
<h2>Hello World!</h2>

<div class="container mt-3">
    <h2>Basic Table</h2>
    <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>
    <table class="table">
        <thead>
        <tr>
            <th>Title</th>
            <th>Abstract</th>
            <th>Byline</th>
            <th>URL</th>
        </tr>
        </thead>
        <tbody>
        <%
            api_nyt api = new api_nyt();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla = api.leer();
            for(int t=0; t<tabla.getRowCount(); t++){
                System.out.println("<tr>");
                System.out.println("<td>" + tabla.getValueAt(t,0) + "</td");
                System.out.println("<td>" + tabla.getValueAt(t,1) + "</td");
                System.out.println("<td>" + tabla.getValueAt(t,2) + "</td");
                System.out.println("<td>" + tabla.getValueAt(t,3) + "</td");
                System.out.println("</tr>");
            }
        %>



        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
