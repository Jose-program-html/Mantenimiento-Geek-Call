/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ReportClients;

/**
 *
 * @author Shary
 */
public class ListaClientes {
    private String ip;
    private String nombre;
    private String telefono;
    private String caso;
    private String comentario;

    public ListaClientes(String ip, String nombre, String telefono, String caso, String comentario) {
        this.ip = ip;
        this.nombre = nombre;
        this.telefono = telefono;
        this.caso = caso;
        this.comentario = comentario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
