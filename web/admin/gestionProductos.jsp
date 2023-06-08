<%-- 
    Document   : gestionProductos
    Created on : 10 jun 2022, 9:43:49
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <link rel="stylesheet" type="text/css" href="css/stylesGestionUsuarios.css">
    <title>Gestionar usuarios</title>
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
                    <li class="actual"><a href="MostrarProductos">Gestionar productos</a></li>
                    <li><a href="MostrarPedidos">Gestionar pedidos</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <section>
        <div class="div-botones">
            <button onclick="location.href='CrearProducto'">Añadir producto</button>
            
            <button onclick="location.href='CargarPanel'">Volver</button>
        </div>

        <div>
            <table>
                <thead>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                </thead>
                <tbody>
                    <c:forEach items="${productos}" var="p">
                    <tr>
                        <td><c:out value="${p.codigo}"/></td>
                        <td><c:out value="${p.nombre}"/></td>
                        <td><c:out value="${p.precio}"/></td>
                        <td><c:out value="${p.stock}"/></td>
                        <td class="modificar">
                            <a href="ModificarProducto?codigo=${p.codigo}"><img src="img/icono_modificar.png" alt="" height="25px" width="25px"></a>
                        </td>
                        <td class="eliminar">
                            <a href="EliminarProducto?codigo=${p.codigo}"><img src="img/icono_eliminar.png" alt="" height="25px" width="25px"></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </section>

</body>
</html>
