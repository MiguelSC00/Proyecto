<%-- 
    Document   : crearProducto
    Created on : 13 jun 2022, 21:08:06
    Author     : Miguel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/styles.css">
        <link rel="stylesheet" type="text/css" href="css/stylesGestionUsuarios.css">
        <title>Crear Usuario</title>
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
                            <li class="actual"><a href="MostrarProductos?target=administrar">Gestionar productos</a></li>
                            <li><a href="MostrarPedidos">Gestionar pedidos</a></li>
                        </ul>
                    </div>
                </nav>
            </header>
        
                <section class="form-div">
                    <form action="CrearProducto" method="post" class="form">
                        <div>
                          <label for="codigo" >Código</label>
                          <input type="text" name="codigo" id="codigo" value="El código se asigna de manera automática." disabled/>
                        </div>

                        <div>
                          <label for="nombre" class="form-label">Nombre</label>
                          <input type="text" class="form-control" name="nombre" id="nombre" aria-describedby="emailHelp">
                        </div>

                        <div>
                          <label for="precioStr" >Precio</label>
                          <input type="text" name="precioStr" id="precioStr"/>
                        </div>

                        <div>
                          <label for="stock">Stock</label>
                          <input type="number" name="stock" id="stock">
                        </div>

                        <div>
                            <p class="error">${errorCrear}</p> 
                        </div>

                      <input type="submit" name="submit" value="Añadir Producto"/>
                    </form>
                </section>    
            
    </body>
</html>
