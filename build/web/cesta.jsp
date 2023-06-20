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
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mi cesta</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesCesta.css"/>
    </head>
    <body>
        
        
        
        <%
            double precioTotal = 0;
            int indice = 0;
            HttpSession sesion = request.getSession();
            List<Producto> cesta = (ArrayList)sesion.getAttribute("cesta");
            List<Integer> cantidades = (ArrayList)sesion.getAttribute("cantidades");
            
            for (Producto p : cesta) {
                precioTotal += p.getPrecio() * cantidades.get(indice);
                indice++;
            }
            
            indice = 0;
            
            precioTotal = Math.round(precioTotal * 100.0) / 100.0;
            
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
                <c:if test="${!empty cesta}">
                    <c:forEach begin="0" step="1" end="${cesta.size()-1}" var="i">
                        <div class="producto">
                            <img src="img/productos/${cesta.get(i).codigo}.webp" heigth="250px" width="250px" alt="Foto <?=$producto->getNombre()?>">

                            <form action="EliminarProductoCesta" method="post">
                                <h2>${cesta.get(i).nombre}</h2>
                                <span>${cesta.get(i).precio}€</span>
                                <p>Unidades: ${cantidades.get(i)}</p>

                                <%
                                out.print("<input type='hidden' value='" + indice + "' name='indiceProducto'>");
                                indice++;
                                %>
                                <br><input type="submit" name="eliminarProducto" value="Eliminar de la cesta">
                            </form> 
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${empty cesta}">
                    <h1>No hay nada en la cesta...</h1>
                </c:if>
            </div>

            <div class="pagar">
                <h2>Precio Total: ${precioTotal}€</h2>
                
                <p stlyle="color: red">${error}</p>

                <form action="formularioPedido.jsp" method="post">
                    <input type="submit" name="pagar" value="Pagar">
                </form>

                <form action="VaciarCesta" method="post">
                    <input type="submit" name="vaciarCesta" value="Vaciar cesta">
                </form>
            </div>
        </section>
        
    </body>
</html>
