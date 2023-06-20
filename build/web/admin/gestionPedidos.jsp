<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : gestionPedidos
    Created on : 10 jun 2022, 9:44:05
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/stylesGestionUsuarios.css">
        <title>JSP Page</title>
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
        <!--<!-- comment 
        <div class="div-botones">
            <button onclick="location.href='CrearProducto'">Añadir producto</button>
            
            <button onclick="location.href='CargarPanel'">Volver</button>
        </div>-->

        <div>
            <table>
                <thead>
                    <th>Código</th>
                    <th>Usuario</th>
                    <th>Fecha</th>
                    <th>Precio</th>
                    <th>Dirección</th>
                    <th>Estado</th>
                </thead>
                <tbody>
                    <c:forEach items="${pedidos}" var="p">
                    <tr>
                        <td><c:out value="${p.codigo}"/></td>
                        <td><c:out value="${p.usuario}"/></td>
                        <td><c:out value="${p.fecha}"/></td>
                        <td><c:out value="${p.precio}"/></td>
                        <td><c:out value="${p.getDireccion()}"/></td>
                        <td><c:out value="${p.estado}"/></td>
                      
                        <td class="eliminar">
                            <a href="EliminarPedido?codigo=${p.codigo}"><img src="img/icono_eliminar.png" alt="" height="25px" width="25px"></a>
                        </td>
                        <td class="enviar">
                            <a href="DetallesPedido?codigo=${p.codigo}"><img src="img/iconos/ver-detalles.png" alt="" height="25px" width="25px"></a>
                        </td>
                        <td class="enviar">
                            <a href="EnviarPedido?codigo=${p.codigo}"><img src="img/iconos/entrega.png" alt="" height="25px" width="25px"></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </section>
        
        
        
    </body>
</html>
