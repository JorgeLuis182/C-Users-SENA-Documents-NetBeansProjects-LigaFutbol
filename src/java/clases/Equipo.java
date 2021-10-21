/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian araujo
 */
public class Equipo {
    private String  id;
    private String nombre;

    public Equipo() {
    }

    public Equipo(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Equipo(String id) {
        String cadenaSQL="select id, nombre from equipo where id="+id;
        ResultSet resultado=ConectorBD.consultar(cadenaSQL);
        try {
            if(resultado.next()){
                this.id = id;
                this.nombre=resultado.getString("nombre");
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar la cadenaSQL="+cadenaSQL+"\n error:"+ex.getMessage());
        }
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        if(nombre==null) return "";
        else return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    public void guardar(){
        String cadenaSQL="insert into equipo (nombre) values ('"+nombre+"')";
        ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public void modificar(){
        String cadenaSQL="update equipo set nombre='"+nombre+"' where id="+id;
        ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public void eliminar(){
        String cadenaSQL="delete from equipo where id="+id;
        ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public static ResultSet getLista(){
        String cadenaSQL="select id, nombre from equipo";
        return ConectorBD.consultar(cadenaSQL);
    }
    
    public static ArrayList<Equipo> getListEnObjetos(){
        ArrayList<Equipo> lista=new ArrayList<Equipo>();
        ResultSet resultado=Equipo.getLista();
        try {
            while(resultado.next()){
                Equipo equipo=new Equipo();
                
                equipo.setId(resultado.getString("id"));
                equipo.setNombre(resultado.getString("nombre"));
                
                lista.add(equipo);
                
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo consultar la lista de equipos"+ex.getMessage());
        }
        return lista;
    }
    
    public static String getListaEnOptions(String predeterminado){
        String lista="";
        ArrayList<Equipo> resultado=Equipo.getListEnObjetos();
        for (int i = 0; i < resultado.size(); i++) {
            Equipo equipo = resultado.get(i);
            String auxiliar="";
            if(equipo.getId().equals(predeterminado)) auxiliar="selected";
            lista+="<option value=' "+equipo.getId()+" ' "+auxiliar+" > " +equipo.getNombre()+ " </option>";
        }
        return lista;
    }
}
