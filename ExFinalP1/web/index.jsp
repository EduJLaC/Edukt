<%--
  Created by IntelliJ IDEA.
  User: edulc
  Date: 9/1/20
  Time: 7:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.fisi.disoft.modelo.dao.DAOFactory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.fisi.disoft.modelo.dao.entity.Productor" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fisi.disoft.modelo.dao.entity.Vino" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Examen Final Parte 1</title>
</head>
<body>
<%
    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.NoRelacional);
%>
<h3>Pregunta 1</h3>
<hr>
<p>Region: Bourgogne</p>
<p>Cantidad de botellas: 200</p>
<%
    List<Productor> productores = factory
            .getProductorDAO()
            .productoresDeRegionPorProduccionMayorA("Bourgogne", 200);

    out.println("<table border=1>" +
            "<th>Nombre</th>" +
            "<th>Apellido</th>");
    for (Productor productor : productores) {
        out.println("<tr>" +
                "<td>" + productor.getNombre() + "</td>" +
                "<td>" + productor.getApellido() + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");
%>

<h3>Pregunta 2</h3>
<hr>
<%
    List<Integer> vino = factory
            .getVinoDAO()
            .vinoConGradoSuperiorProducidoPor(10, 3);

    out.println("<table border=1>" +
            "<th>ID Vino</th>");
    for (Integer id : vino) {
        out.println("<tr>" +
                "<td>" + id + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");
%>

<h3>Pregunta 3</h3>
<hr>
<%
   productores = factory
            .getProductorDAO()
            .productoresSinProduccion();

    out.println("<table border=1>" +
            "<th>Nombre</th>" +
            "<th>Apellido</th>");
    for (Productor productor : productores) {
        out.println("<tr>" +
                "<td>" + productor.getNombre() + "</td>" +
                "<td>" + productor.getApellido() + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");
%>

<h3>Pregunta 4</h3>
<hr>
<%
vino = factory.getVinoDAO().idVinoProducidoEnMayorCantidad();
    out.println("<table border=1>" +
            "<th>ID Vino</th>");
    for (Integer id : vino) {
        out.println("<tr>" +
                "<td>" + id + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");

%>

<h3>Pregunta 5</h3>
<hr>
<%
    productores = factory.getProductorDAO().productoresQueProducenALoMasVinos(500);
    out.println("<table border=1>" +
            "<th>Nombre</th>" +
            "<th>Apellido</th>");
    for (Productor productor : productores) {
        out.println("<tr>" +
                "<td>" + productor.getNombre() + "</td>" +
                "<td>" + productor.getApellido() + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");
%>

<h3>Pregunta 8</h3>
<hr>
<%
    productores = factory.getProductorDAO().productoresSinNombreNiProduccion();
    out.println("<table border=1>" +
            "<th>Nombre</th>" +
            "<th>Apellido</th>");
    for (Productor productor : productores) {
        out.println("<tr>" +
                "<td>" + productor.getNombre() + "</td>" +
                "<td>" + productor.getApellido() + "</td>" +
                "</tr>"
        );
    }
    out.println("</table>");
%>
</body>
</html>
