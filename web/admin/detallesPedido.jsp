
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Producto"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : detallesPedido
    Created on : 2 jun 2023, 14:23:01
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/stylesDetallesPedido.css">
        <title>Detalles del pedido</title>
    </head>
    <body>
        
        <header>
            <jsp:include page="../headerAdmin.jsp"/>

            <nav class="nav-admin">
                <div>
                    <h3>Panel de control</h3>
                </div>

                <div>
                    <ul class="menu-admin">
                        <li><a href="MostrarUsuarios">Gestionar usuarios</a></li>
                        <li><a href="MostrarProductos?target=administrar">Gestionar productos</a></li>
                        <li class="actual"><a href="MostrarPedidos">Gestionar pedidos</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <section>
             
            <div>
                <h1>#${pedido.getCodigo()}</h1>
                <p>Destinatario: ${pedido.getUsuario()}</p>
                <p>Fecha: ${pedido.getFecha()}</p>
                <p>Dirección: ${pedido.getDireccion()}</p>
                <p>Estado: ${pedido.getEstado()}</p>
            </div>
        
        
            <div class="productos">
                <c:forEach begin="0" step="1" end="${productos.size()-1}" var="i">
            
                    <div class="producto">
                        <img src="img/productos/${productos.get(i).codigo}.webp" heigth="150px" width="150px" alt="">

                        <div>
                            <h2>${productos.get(i).getNombre()}</h2>
                            <span>${productos.get(i).getPrecio()}</span>
                            <p>Unidades: ${cantidades.get(i)}</p>
                        </div>           
                    </div>

                </c:forEach>
                
                <div class="botom">
                    <h3>${pedido.getPrecio()}</h3>

                    <button onclick="location.href='MostrarPedidos'">Volver</button>
                </div>
            </div>
            
        </section>
        
    </body>
</html>
