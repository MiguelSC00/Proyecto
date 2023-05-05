<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : cesta
    Created on : 9 ene 2023, 1:43:31
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesCesta.css"/>
    </head>
    <body>
        
        <%
            double precioTotal = 0;
            int indice = 0;
            HttpSession sesion = request.getSession();
            List<Producto> cesta = (ArrayList)sesion.getAttribute("cesta");
            
            for (Producto p : cesta) {
                precioTotal += p.getPrecio();
            }
            
            sesion.setAttribute("precioTotal", precioTotal);
        %>
        
        <c:choose>
            <c:when test="${empty usuario}">
                <jsp:include page="header.jsp"/>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${usuario.getRol().equals('Administrador')}">
                        <jsp:include page="headerAdmin.jsp"/>
                    </c:when>
                    <c:when test="${usuario.getRol().equals('Entrenador')}">
                        <jsp:include page="headerEntrenador.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="headerCliente.jsp"/>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        <section class="seccion-productos">
            <div class="productos">
                <c:forEach items="${cesta}" var="p">
                    <div class="producto">
                        <img src="img/cinturon.webp" heigth="250px" width="250px" alt="Foto <?=$producto->getNombre()?>">

                        <form action="EliminarProductoCesta" method="post">
                            <h2>${p.nombre}</h2>
                            <span>${p.precio}€</span>

                            <%
                            out.print("<input type='hidden' value='" + indice + "' name='indiceProducto'>");
                            indice++;
                            %>
                            <br><input type="submit" name="eliminarProducto" value="Eliminar del carrito">
                        </form>
                    </div>
                </c:forEach>
            </div>

            <div class="pagar">
                <h2>Precio Total: ${precioTotal}€</h2>

                <form action="../controlador/pagarControlador.php" method="post">
                    <input type="submit" name="pagar" value="Pagar">
                </form>

                <form action="../controlador/cestaControlador.php" method="post">
                    <input type="submit" name="vaciarCesta" value="Vaciar cesta">
                </form>
            </div>
        </section>
        
    </body>
</html>
