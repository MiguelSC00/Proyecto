<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : subirPdfEntrenador
    Created on : 7 jun 2023, 10:27:01
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/styles.css"> 
        <link rel="stylesheet" type="text/css" href="../css/stylesSubirPdf.css"> 
        <title>Subir archivo</title>
    </head>
    <body>
        
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
                        <jsp:include page="../headerEntrenador.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="headerCliente.jsp"/>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        <section>
            <h1>Subir PDF</h1>
            <h1>${nombreUsuario}</h1>
            <form action="../CrearPdfEntrenador" method="post" enctype="multipart/form-data">
            
                <div>
                    <input type="text" name="titulo"/>
                </div>
                
                <div>
                    <input type="file" name="fichero"/>
                </div>
                
                <div>
                    <input type="hidden" name="nombreUsuario" value="miguel"/>
                    <input type="submit" name="submitEntrenador" value="Aceptar"/>
                </div>
                
            </form>
            
        </section>
        
        
        
    </body>
</html>
