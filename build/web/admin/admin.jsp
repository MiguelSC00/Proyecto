<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/stylesAdmin.css">
    <title>Administración</title>
</head>
<body>
    <header>
        
        <nav class="fixed-nav">
            <img src="img/barbell.webp" alt="" class="icono-mancuerna">
            <ul class="menu">
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="nosotros.jsp">Nosotros</a></li>
                <li><a href="asesorias.jsp">Asesorías</a></li>
                <li><a href="tienda.jsp">Tienda</a></li>
                <li><a href="">Panel de control</a></li>
                <li><a href="perfil.jsp">Mi cuenta</a></li>
                <li><a href="CerrarSesion"><img src="img/iconos/icono_cerrar_sesion.png" width="22px" height="22px"/></a></li>
            </ul>
        </nav>

        <nav class="nav-admin">
            <div>
                    <h3>Panel de control</h3>
            </div>

            <div>
                <ul class="menu-admin">
                    <li><a href="MostrarUsuarios">Gestionar usuarios</a></li>
                    <li><a href="MostrarProductos?target=administrar">Gestionar productos</a></li>
                    <li><a href="">Gestionar pedidos</a></li>
                </ul>
            </div>
        </nav>
        
    </header>

    <section class="seccion contenedor ">
        <div>
            <table class="t-admin main-table">
                <thead>
                    <th>Panel de control</th>
                </thead>
                <tbody>
                    <tr onclick="location.href='MostrarUsuarios'">
                        <td>
                            <div>
                                <img src="img/iconos/usuario.png" alt="" height="24px" width="24px"> Usuarios 
                            </div>
                            <div>
                                <span>20</span>
                            </div>
                        </td>
                    </tr>
                    <tr onclick="location.href='MostrarProductos?target=administrar'">
                        <td>
                            <div>
                                <img src="img/iconos/producto.png" alt="" height="24px" width="24px"> Productos 
                            </div>
                            <div>  
                                <span>${productosSinStock}</span>
                            </div>
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <div>
                                <img src="img/iconos/pedido.png" alt="" height="24px" width="24px"> Pedidos 
                            </div>
                            <div>  
                                <span>4</span>
                            </div>
                        </td>    
                    </tr>
                </tbody>
            </table>
        </div>
            
        <div>
            <table class="t-vista-rapida main-table">
                <thead>
                    <th colspan="3">Vista rápida</th>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <div>
                                <img src="img/iconos/usuario.png" alt="" height="55px" width="55px"><span>&nbsp;${totalUsuarios}</span>
                            </div>
                            <div>
                                <p>Usuarios</p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <img src="img/iconos/producto.png" alt="" height="64px" width="64px"><span>&nbsp;${totalProductos}</span>
                            </div>
                            <div>
                                <p>Productos</p>
                            </div>
                        </td>
                        <td>
                            <div>
                                <img src="img/iconos/pedido.png" alt="" height="64px" width="64px"><span>&nbsp;8</span>
                            </div>
                            <div>
                                <p>Pedidos</p>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>

            <table class="t-pedidos-recientes main-table">
                <thead>
                    <th>Pedidos pendientes</th>
                </thead>
                <tbody>
                    <td class="td-flex">
                        <table class="tabla-secundaria">
                            <thead>
                                <th>Número pedido</th>
                                <th>Usuario</th>
                                <th>Fecha</th>
                                <th>Dirección</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>12345</td>
                                    <td>MiguelSC00</td>
                                    <td>30/05/2022</td>
                                    <td>Calle Azahar Nº16</td>
                                </tr>
                                <tr>
                                    <td>12345</td>
                                    <td>MiguelSC00</td>
                                    <td>30/05/2022</td>
                                    <td>Calle Azahar Nº16</td>
                                </tr>
                                <tr>
                                    <td>12345</td>
                                    <td>MiguelSC00</td>
                                    <td>30/05/2022</td>
                                    <td>Calle Azahar Nº16</td>
                                </tr>
                                <tr>
                                    <td>12345</td>
                                    <td>MiguelSC00</td>
                                    <td>30/05/2022</td>
                                    <td>Calle Azahar Nº16</td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                    
                </tbody>
            </table>
        </div>
            
        
    </section>
</body>
</html>