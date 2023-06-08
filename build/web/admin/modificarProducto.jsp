<%-- 
    Document   : modificarProducto
    Created on : 13 jun 2022, 21:55:37
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
    <title>Modificar usuario</title>
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
                
                <form action="ModificarProducto?codigo=${productoModificar.codigo}" method="post" class="form">
                    
                    <div>
                        <h1>Modificar producto</h1>
                    </div>
                    
                    <div>
                        <label for="codigo">Código</label>
                        <input type="number" name="codigo" id="codigo" value="${productoModificar.codigo}" disabled=""/>
                    </div>
                    
                    <div>
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" id="nombre" value="${productoModificar.nombre}"/>
                    </div>
                    
                    <div>
                        <label for="precio">Precio</label>
                        <input type="text" name="precio" id="precio" value="${productoModificar.precio}"/>
                    </div>
                    
                    <div>
                        <label for="stock">Stock</label>
                        <input type="number" name="stock" id="stock" value="${productoModificar.stock}"/>
                    </div>
                    
                    <div>
                        <p class="error">${error}</p>
                    </div>   
                    
                        <div>
                            <input type="submit" class="input" name="modificar" value="Modificar"/>
                        </div>    
                        
                </form>
                
            </section>
    </body>
</html>
