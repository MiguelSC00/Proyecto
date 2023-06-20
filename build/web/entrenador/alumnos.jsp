<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : alumnos
    Created on : 6 jun 2023, 12:26:10
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alumnos</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/stylesAlumnos.css">
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

            <h1>Mis alumnos</h1>

            <div class="contenido">
                <div class="control">
                    <p>
                        <a href="MostrarUsuariosSuscritos?filtro=todos">Todos los alumnos</a>
                    </p>

                    <p>
                        <a href="MostrarUsuariosSuscritos?filtro=culturismo">Culturismo</a>
                    </p>

                    <p>
                        <a href="MostrarUsuariosSuscritos?filtro=powerlifting">Powerlifting</a>
                    </p>
                </div>

                <div>
                    <table>
                        <thead>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Usuario</th>
                            <th>Email</th>
                            <th>Teléfono</th>
                            <th>Plan de entrenamiento</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${usuarios}" var="u">
                            <tr>
                                <td data-titulo="Nombre"><c:out value="${u.nombre}"/></td>
                                <td data-titulo="Apellidos"><c:out value="${u.apellidos}"/></td>
                                <td data-titulo="Usuario"><c:out value="${u.usuario}"/></td>
                                <td data-titulo="Email"><c:out value="${u.email}"/></td>
                                <td data-titulo="Teléfono"><c:out value="${u.telefono}"/></td>
                                <td data-titulo="Asesoría"><c:out value="${u.suscripcion}"/></td>
                                <td class="modificar">
                                    <a href="DetallesUsuario?usuario=${u.usuario}"><img src="img/ver.png" alt="" height="25px" width="25px">
                                </td>
                                <td class="eliminar">
                                    <a href="EnviarEmail?usuario=${u.usuario}"><img src="img/correo.png" alt="" height="25px" width="25px">
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>


        </section>
        
    </body>
</html>
