/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clasesGenericas.ConectorBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian araujo
 */
public class ResultadoPartido {
    private String id;
    private String fecha;
    private String hora;
    private String lugar;
    private String idequipoLocal;
    private int golesEquipoLocal;
    private String idEquipoVisitante;
    private int golesEquipoVisitante;
    

    public ResultadoPartido() {
    }

    public ResultadoPartido(String id, String fecha, String hora, String lugar, String idequipoLocal, int golesEquipoLocal, String idEquipoVisitante, int golesEquipoVisitante) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.idequipoLocal = idequipoLocal;
        this.golesEquipoLocal = golesEquipoLocal;
        this.idEquipoVisitante = idEquipoVisitante;
        this.golesEquipoVisitante = golesEquipoVisitante;
        
    }

    public ResultadoPartido(String id) {
        String cadenaSQL="select id, fecha, hora, lugar, idequipoLocal, golesEquipoLocal, idEquipoVisitante, golesEquipoVisitante from resultadopartido where id="+id;
        
        try {
            ResultSet resultado=ConectorBD.consultar(cadenaSQL);
            if(resultado.next()){
                this.id = id;
                this.fecha=resultado.getString("fecha");
                this.hora=resultado.getString("hora");
                this.lugar=resultado.getString("lugar");
                this.idequipoLocal=resultado.getString("idequipolocal");
                this.golesEquipoLocal=Integer.parseInt(resultado.getString("golesequipolocal"));
                this.idEquipoVisitante=resultado.getString("idequipovisitante");
                this.golesEquipoVisitante=Integer.parseInt(resultado.getString("golesequipovisitante"));
                //this.puntosLocal=Integer.parseInt(resultado.getString("puntosLocal"));
                //this.puntosVisitante=Integer.parseInt(resultado.getString("puntosVisitante"));
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo leer la cadenaSQL "+cadenaSQL+"\n ERROR: "+ex.getMessage());
        }
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getIdequipoLocal() {
        return idequipoLocal; 
    }
    
    public Equipo getEquipoLocal(){
        return new Equipo(idequipoLocal);
    }

    public void setIdequipoLocal(String idequipoLocal) {
        this.idequipoLocal = idequipoLocal;
    }

    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    public String getIdEquipoVisitante() {
        return idEquipoVisitante;
    }
    
    public Equipo getEquipoVisitante(){
        return new Equipo(idEquipoVisitante);
    }
    
    /*
    public TipoVehiculo getTipoVehiculo(){
        return new TipoVehiculo(idTipoVehiculo);
    }
    */

    public void setIdEquipoVisitante(String idEquipoVisitante) {
        this.idEquipoVisitante = idEquipoVisitante;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    /*public int getPuntosLocal() {
        return puntosLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }
    */

    @Override
    public String toString() {
        return "ResultadoPartido{" + "idequipoLocal=" + idequipoLocal + ", idEquipoVisitante=" + idEquipoVisitante + '}';
    }

    

    
    public void guardar(){
        String cadenaSQL="insert into resultadopartido (fecha, hora, lugar, idequipoLocal, golesEquipoLocal, idEquipoVisitante, golesEquipoVisitante) "
                + "values ('"+fecha+"','"+hora+"','"+lugar+"','"+idequipoLocal+"',"+golesEquipoLocal+",'"+idEquipoVisitante+"',"+golesEquipoVisitante+""
                + ")";
        ConectorBD.ejecutarQuery(cadenaSQL);
        
    }
    public void modificar(){
        String cadenaSQL="update resultadoPartido set fecha='"+fecha+"', hora='"+hora+"', lugar='"+lugar+"', idequipoLocal='"+idequipoLocal+"', "
                + "golesEquipoLocal="+golesEquipoLocal+",idEquipoVisitante= '"+idEquipoVisitante+"', golesEquipoVisitante="+golesEquipoVisitante+""
                + " where id="+id;
        ConectorBD.ejecutarQuery(cadenaSQL);
    }
    public void eliminar(){
        String cadenaSQL="delete  from resultadopartido where id="+id;
        ConectorBD.ejecutarQuery(cadenaSQL);
    }
    
    public static ResultSet getLista(){
        String cadenaSQL="select id, fecha, hora, lugar, idequipoLocal, golesEquipoLocal, idEquipoVisitante, golesEquipoVisitante from resultadopartido";
        //System.out.println("CadenasSQL="+cadenaSQL);
        return ConectorBD.consultar(cadenaSQL);
        
    }
    
    public static ArrayList<ResultadoPartido> getListEnObjetos(){
        ArrayList<ResultadoPartido> lista=new ArrayList<ResultadoPartido>();
        ResultSet resultado=ResultadoPartido.getLista();
        try {
            while(resultado.next()){
                ResultadoPartido resultadoPartido=new ResultadoPartido();
                
                resultadoPartido.setId(resultado.getString("id"));
                resultadoPartido.setFecha(resultado.getString("fecha"));
                resultadoPartido.setHora(resultado.getString("hora"));
                resultadoPartido.setLugar(resultado.getString("lugar"));
                resultadoPartido.setIdequipoLocal(resultado.getString("idequipolocal"));
                resultadoPartido.setGolesEquipoLocal(Integer.parseInt(resultado.getString("golesequipolocal")));
                resultadoPartido.setIdEquipoVisitante(resultado.getString("idequipovisitante"));
                resultadoPartido.setGolesEquipoVisitante(Integer.parseInt(resultado.getString("golesequipovisitante")));
                
                lista.add(resultadoPartido);
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo cargar la lista de los resultados de los partidos"+ex.getMessage());
        }
        return lista;
    }
    
    public static int calcularPuntos(int golesEquipoLocal, int golesEquipoVisitante){
        int puntos=0;
        int puntosEquipoLocal=0;
        int puntosEquipoVisitante=0;
        for (int i = 0; i < puntos; i++) {
            if(golesEquipoLocal>golesEquipoVisitante){
                 puntosEquipoLocal=3;
                 puntosEquipoLocal++;
            }else if(golesEquipoLocal<golesEquipoVisitante){
                puntosEquipoVisitante=3;
                puntosEquipoVisitante++;
            }else if(golesEquipoLocal==golesEquipoVisitante){
                puntosEquipoVisitante=1;
                puntosEquipoVisitante++;
                puntosEquipoLocal=1;
                puntosEquipoLocal++;
            }
        }
        return puntos;
      }
    
    public static void generaTablaPosiciones(){
        String partidos="";
        
        ArrayList<ResultadoPartido> datos=ResultadoPartido.getListEnObjetos();
        
        ArrayList<Equipo> lista= Equipo.getListEnObjetos();
        ResultadoPartido resultadoPartido= new ResultadoPartido();
        // ArrayList<Equipo> lista=new ArrayList<Equipo>();
        Equipo  equipo=new Equipo();
        for (int i = 0; i < datos.size(); i++) {
             datos=ResultadoPartido.getListEnObjetos();
            
        }
        
    }
}
