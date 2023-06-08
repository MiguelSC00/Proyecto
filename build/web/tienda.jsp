<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : tienda
    Created on : 9 jun 2022, 14:07:33
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesTienda.css"/>
        
    </head>
    <body>
        
        <script src="scripts/SweetAlet.js"></script>
        
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
            <c:forEach items="${productos}" var="p">
                <div class="producto">
                    <img src="img/productos/${p.codigo}.webp" heigth="350px" width="350px">
                    
                    <c:if test="${empty usuario}">
                        <form action="iniciarSesion.jsp" method="post">
                    </c:if>
                    <c:if test="${!empty usuario}">
                        <form action="AgregarCarrito" method="post">
                    </c:if>
                        <div>
                            <h2>${p.nombre}</h2>
                            <span>${p.precio}</span>
                        </div>
                        
                        <div>
                            <input type="hidden" value="${p.codigo}" name="codigo"> 
                            <input type="submit" name="submit" value="Añadir al carrito"> 
                        </div>
                    </form>
                </div>
            </c:forEach>
        </section>
        
    </body>
</html>
