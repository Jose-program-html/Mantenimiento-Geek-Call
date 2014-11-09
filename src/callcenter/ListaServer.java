/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package callcenter;

/**
 *
 * @author Shary
 */
public class ListaServer {
    private String inicio;
    private String fin;
    private String empleado;

    public ListaServer(String inicio, String fin, String empleado) {
        this.inicio = inicio;
        this.fin = fin;
        this.empleado = empleado;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
}
