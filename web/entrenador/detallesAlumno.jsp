<%-- 
    Document   : detallesAlumno
    Created on : 6 jun 2023, 20:33:57
    Author     : Miguel
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/stylesDetallesUsuario.css">
        <title>Usuario</title>
    </head>
    <body>
        
        <c:choose>
            <c:when test="${empty usuario}">
                <jsp:include page="header.jsp"/>
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${usuario.getRol().equals('Administrador')}">
                        <jsp:include page="../headerAdmin.jsp"/>
                    </c:when>
                    <c:when test="${usuario.getRol().equals('Entrenador')}">
                        <jsp:include page="../headerEntrenador.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="../headerCliente.jsp"/>
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
        
        <section>

            <div class="detalles">
                <div>
                    <img src="img/usuario.png" alt="" width="120px" height="120px">
                </div>

                <div>
                    <div>
                        <h1>${usu.getUsuario()}</h1>
                    </div>

                    <div>
                        <h3>${usu.getNombre()} ${usu.getApellidos()}</h3>
                    </div>

                    <div>
                        <p>Email: ${usu.getEmail()}</p>
                    </div>

                    <div>
                        <p>Teléfono: ${usu.getTelefono()}</p>
                    </div>

                    <div>
                        <p class="tipo">Culturismo</p>
                    </div>
                </div>
            </div>

            <div class="contenedor-tablas">
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="3">Entrenamientos</th>
                                <c:if test="${usuario.getRol() == 'Entrenador'}">
                                <th class="adjuntar oculta" ><a href="entrenador/subirPdfEntrenador.jsp?nombreUsuario=${usu.getUsuario()}"><img src="img/adjuntar-archivo.png" alt="" width="30px" height="30px"></a></th>
                                </c:if>
                                
                            </tr>
                            <tr class="oculta">
                                <th>Título</th>
                                <th>Fecha</th>
                                <th>Archivo PDF</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${planes}" var="p">
                            <tr><td>${p.titulo}</td>
                                <td>${p.fecha}</td>
                                <td><a href="archivosPdf/${p.codigo}.pdf" target="_blank"><img src="img/pdf.png" alt="" width="40px" height="40px"></a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="3">Revisiones</th>
                                <c:if test="${usuario.getRol() == 'Cliente'}">
                                    <th class="adjuntar oculta" ><a href="subirPdfCliente.jsp"><img src="img/adjuntar-archivo.png" alt="" width="30px" height="30px"></a></th>
                                </c:if>
                            </tr>
                            <tr class="oculta">
                                <th>Título</th>
                                <th>Fecha</th>
                                <th>Archivo PDF</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${reportes}" var="r">
                            <tr>
                                <td>${r.titulo}</td>
                                <td>${r.fecha}</td>
                                <td><a href="archivosPdf/${r.codigo}.pdf" target="_blank"><img src="img/pdf.png" alt="" width="40px" height="40px"></a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>



        </section>
        
    </body>
</html>
