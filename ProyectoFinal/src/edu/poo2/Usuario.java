package edu.poo2;

import java.util.Vector;

public class Usuario {

    private String nick;
    private String contraseña;
    private String cContraseña;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getcContraseña() {
        return cContraseña;
    }

    public void setcContraseña(String cContraseña) {
        this.cContraseña = cContraseña;
    }
    public static int verificarUsuario(String usuario){
        Vector lista = mostrar();
        Usuario obj;
        for(int i=0;i<lista.size();i++){
            obj = (Usuario) lista.elementAt(i);
            if(obj.getNick().equalsIgnoreCase(usuario)){
                return i;
            }
        }
        return -1;
    }
    public static int verificarLogin(String usuario,String contraseña){
        Vector lista = mostrar();
        Usuario obj;
        for(int i = 0;i<lista.size();i++){
            obj = (Usuario) lista.elementAt(i);
            if(obj.getNick().equalsIgnoreCase(usuario)&& obj.getcContraseña().equalsIgnoreCase(contraseña)){
                return i;
            }
        }
        return -1;
    }

    public static Vector mostrar(){
        return ListaUsuario.mostrar();
    }

}
