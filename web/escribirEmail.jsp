
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <link rel="stylesheet" type="text/css" href="css/stylesSubirPdf.css"> 
        <title>JSP Page</title>
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
                        <jsp:include page="headerEntrenador.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="headerCliente.jsp"/>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        <section class="ancho">
            <div><h2>Destinatario: ${destinatario.nombre} ${destinatario.apellidos}</h2></div>
            
            <div>
                <form action="EnviarEmail" method="post">
                    <input type="hidden" name="usuario" value="${destinatario.usuario}">
                    <label>Asunto</label>
                    <input type="text" name="asunto" required="">
                    <br>
                    <label>Texto del Mensaje</label>
                    <textarea name="texto"></textarea>
                    <br>
                    <label>Contraseña</label>
                    <input type="password" name="password" required="">
                    <br>
                    <input type="submit" name="enviar" value="Enviar">
                </form>
            </div>
            <div>
                <a href="MostrarUsuariosSuscritos?filtro=todos">Volver</a>
            </div>
        </section>
        
        
        
            
            
        
    </body>
</html>
