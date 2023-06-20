<%-- 
    Document   : header.jsp
    Created on : 10 jun 2022, 10:36:09
    Author     : Miguel
--%>
<script src="scripts/script_menu.js"></script>
<nav class="fixed-nav">
            <img src="img/barbell.webp" alt="" class="icono-mancuerna">
            
            
            
            <ul class="menu">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <li><a href="asesorias.jsp">Asesorías</a></li>
                <li><a href="MostrarProductos?target=tienda">Tienda</a></li>
                <li><a href="iniciarSesion.jsp">Acceder</a></li>
            </ul>
            
            <img src="img/lista.png" onclick="ocultar_mostrar()" alt="" width="40px" class="menu-burguer" id="menu_burguer">
</nav>
<nav class="nav-responsive" id="nav-responsive" style="display: none;">
            <ul class="menu-responsive">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <li><a href="asesorias.jsp">Asesorías</a></li>
                <li><a href="MostrarProductos?target=tienda">Tienda</a></li>
                <li><a href="iniciarSesion.jsp">Acceder</a></li>
            </ul>
</nav>
