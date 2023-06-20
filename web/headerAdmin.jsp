<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : headerAdmin
    Created on : 10 jun 2022, 10:30:06
    Author     : Miguel
--%>
    <script src="scripts/script_menu.js"></script>
    <nav class="fixed-nav">
            <img src="img/barbell.webp" alt="" class="icono-mancuerna">
            <ul class="menu">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <li><a href="MostrarProductos?target=tienda">Tienda</a></li>
                <li><a href="cesta.jsp"><img src="img/cesta.png" width="22px" height="22px"></img>(${cesta.size()})</a></li>
                <li><a href="CargarPanel">Panel de control</a></li>
                <li><a href="perfil.jsp">Mi cuenta</a></li>
                <li><a href="CerrarSesion"><img src="img/iconos/icono_cerrar_sesion.png" width="22px" height="22px"/></a></li>
            </ul>
            <img src="img/lista.png" onclick="ocultar_mostrar()" alt="" width="40px" class="menu-burguer" id="menu_burguer">
    </nav>
             
    <nav class="nav-responsive" id="nav-responsive" style="display: none;">
            <ul class="menu-responsive">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <li><a href="MostrarProductos?target=tienda">Tienda</a></li>
                <li><a href="cesta.jsp"><img src="img/cesta.png" width="22px" height="22px"></img>(${cesta.size()})</a></li>
                <li><a href="CargarPanel">Panel de control</a></li>
                <li><a href="perfil.jsp">Mi cuenta</a></li>
                <li><a href="CerrarSesion"><img src="img/iconos/icono_cerrar_sesion.png" width="22px" height="22px"/></a></li>
            </ul>
    </nav>

    

