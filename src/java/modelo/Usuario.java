package modelo;


import java.sql.Timestamp;
import java.util.Objects;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */
public class Usuario {
    private String usuario;
    private String password;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String rol;
    private String suscripcion;
    private Timestamp fechaSuscripcion;

    //Constructor
    
    
    public Usuario(String usuario, String password, String nombre, String apellidos, String email, String telefono, String rol, String suscripcion, Timestamp fechaSuscripcion) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.suscripcion = suscripcion;
        this.fechaSuscripcion = fechaSuscripcion;
    }
    
    public Usuario(String usuario, String password, String nombre, String apellidos, String email, String telefono, String rol, String suscripcion) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
        this.suscripcion = suscripcion;
    }
    
    public Usuario(String usuario, String password, String nombre, String apellidos, String email, String telefono, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.rol = rol;
    }
    
    //Getters y Setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setAdministrador(String rol) {
        this.rol = rol;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Timestamp getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Timestamp fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
        public void setEnviarEmail(Email email, String password) throws Exception {
        Properties p = new Properties();
// Servidor smtp de correo
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
// Usar TLS
        p.setProperty("mail.smtp.starttls.enable", "true");
// puerto del servidor smtp
        p.setProperty("mail.smtp.port", "587");
// Usuario smtp
        p.setProperty("mail.smtp.user", email.getFrom());
// Autenticación requerida
        p.setProperty("mail.smtp.auth", "true");
// Obtenemos la sesión
        Session sesion = Session.getDefaultInstance(p);
        sesion.setDebug(false);
// Creamos el mensaje
        MimeMessage mensaje = new MimeMessage(sesion);
// Y establecemos sus propiedades

        mensaje.setFrom(new InternetAddress(email.getFrom()));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
        mensaje.setSubject(email.getSubject());
        mensaje.setText(email.getText());
// Enviamos el mensaje
        Transport t = sesion.getTransport("smtp");
// Para conectarnos usamos usuario y password
        t.connect(email.getFrom(), password);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
    }

    
    
    
    
    
    
    

}
