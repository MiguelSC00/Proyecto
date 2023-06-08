<%-- 
    Document   : header
    Created on : 10 jun 2022, 10:34:38
    Author     : Miguel
--%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="fixed-nav">
            <img src="img/barbell.webp" alt="" class="icono-mancuerna">
            <ul class="menu">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <c:if test="${empty usuario.getSuscripcion()}">
                    <li><a href="asesorias.jsp">Asesorías</a></li>
                </c:if>
                <c:if test="${!empty usuario.getSuscripcion()}">
                    <li><a href="DetallesUsuario?usuario=${usuario.usuario}">Mi asesoría</a></li>
                </c:if>
                
                <li><a href="MostrarProductos?target=tienda">Tienda</a></li>
                <li><a href="cesta.jsp"><img src="img/cesta.png" width="22px" height="22px"></img>(${cesta.size()})</a></li>
                <li><a href="perfil.jsp">Mi cuenta</a></li>
                <li><a href="CerrarSesion"><img src="img/iconos/icono_cerrar_sesion.png" width="22px" height="22px"/></a></li>
            </ul>
    </nav>
