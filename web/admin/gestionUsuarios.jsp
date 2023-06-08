<%-- 
    Document   : gestionUsuarios
    Created on : 10 jun 2022, 9:43:31
    Author     : Miguel
--%>

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
                    <li class="actual"><a href="MostrarUsuarios">Gestionar usuarios</a></li>
                    <li><a href="MostrarProductos?target=administrar">Gestionar productos</a></li>
                    <li><a href="">Gestionar pedidos</a></li>
                </ul>
            </div>
        </nav>
    </header>

    <section>
        <div class="div-botones">
            <button onclick="location.href='CrearUsuario?creaAdmin=true'">Crear Usuario</button>
            
            <button onclick="location.href='CargarPanel'">Volver</button>
        </div>

        <div>
            <table>
                <thead>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Usuario</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                    <th>Rol</th>
                </thead>
                <tbody>
                    <c:forEach items="${usuarios}" var="u">
                    <tr>
                        <td><c:out value="${u.nombre}"/></td>
                        <td><c:out value="${u.apellidos}"/></td>
                        <td><c:out value="${u.usuario}"/></td>
                        <td><c:out value="${u.email}"/></td>
                        <td><c:out value="${u.telefono}"/></td>
                        <td><c:out value="${u.rol}"/></td>
                        <td class="modificar">
                            <a href="ModificarUsuario?usuario=${u.usuario}"><img src="img/icono_modificar.png" alt="Modificar usuario" height="25px" width="25px"></a>
                        </td>
                        <td class="eliminar">
                            <a href="EliminarUsuario?usuario=${u.usuario}"><img src="img/icono_eliminar.png" alt="Eliminar usuario" height="25px" width="25px"></a>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </section>

</body>
</html>
