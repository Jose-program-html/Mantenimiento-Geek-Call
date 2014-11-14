/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SuperUsuario;

/**
 *
 * @author Lee
 */
public class Variables_globales {
    private static boolean sesion=false;
    public static boolean isSesion() {
        return sesion;
    }
    public static void setSesion(boolean aSesion) {
        sesion = aSesion;
    }
    private static String sesion_usuario;
    public static String getSesion_usuario() {
        return sesion_usuario;
    }
    public static void setSesion_usuario(String aSesion_usuario) {
        sesion_usuario = aSesion_usuario;
    }
    private static int session_tipo;
    public static int getSession_tipo() {
        return session_tipo;
    }
    public static void setSession_tipo(int aSession_tipo) {
        session_tipo = aSession_tipo;
    }
    private static boolean servidor_status=false;
    public static boolean isServidor_status() {
        return servidor_status;
    }

    /**
     * @param aServidor_status the servidor_status to set
     */
    public static void setServidor_status(boolean aServidor_status) {
        servidor_status = aServidor_status;
    }
    
}
