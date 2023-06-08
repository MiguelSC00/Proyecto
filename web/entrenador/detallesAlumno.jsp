<%-- 
    Document   : detallesAlumno
    Created on : 6 jun 2023, 20:33:57
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
        <link rel="stylesheet" type="text/css" href="css/stylesDetallesUsuario.css">
        <title>Usuario</title>
    </head>
    <body>
        
        <jsp:include page="../headerEntrenador.jsp"/>
        
        <section>

            <div class="detalles">
                <div>
                    <img src="img/usuario.png" alt="" width="120px" height="120px">
                </div>

                <div>
                    <div>
                        <h1>${usu.getUsuario()}</h1>
                    </div>

                    <div>
                        <h3>${usu.getNombre()} ${usu.getApellidos()}</h3>
                    </div>

                    <div>
                        <p>Email: ${usu.getEmail()}</p>
                    </div>

                    <div>
                        <p>Teléfono: ${usu.getTelefono()}</p>
                    </div>

                    <div>
                        <p class="tipo">Culturismo</p>
                    </div>
                </div>
            </div>

            <div class="contenedor-tablas">
                <div>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Entrenamientos</th>
                                <th class="adjuntar"><a href="CrearPdfEntrenador?nombreUsuario=${usu.getUsuario()}"><img src="img/adjuntar-archivo.png" alt="" width="30px" height="30px"></a></th>
                            </tr>
                            <tr>
                                <th>Fecha</th>
                                <th>Archivo PDF</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>06/06/2023</td>
                                <td><a href="AbrirPdf"><img src="img/pdf.png" alt="" width="40px" height="40px"></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div>
                    <table>
                        <thead>
                            <tr>
                                <th colspan="2">Revisiones</th>
                            </tr>
                            <tr>
                                <th>Fecha</th>
                                <th>Archivo PDF</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>06/06/2023</td>
                                <td><img src="img/pdf.png" alt="" width="40px" height="40px"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>



        </section>
        
    </body>
</html>
