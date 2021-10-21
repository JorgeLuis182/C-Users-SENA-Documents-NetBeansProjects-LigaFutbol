/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesGenericas;

import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian araujo
 */
public class ConectorBD {
    private String servidor;
    private String puerto;
    private String usuario;
    private String clave;
    private String baseDatos;
    
    private Connection conexion; 

    /*public ConectorBD() {
    
        Properties propiedades =new Properties();
        try{
         propiedades.load(this.getClass().getClassLoader().getResourceAsStream("configuracion.ini"));
         
         servidor=propiedades.getProperty("servidor");
         puerto=propiedades.getProperty("puerto");
         usuario=propiedades.getProperty("usuario");
         clave=propiedades.getProperty("clave");
         baseDatos=propiedades.getProperty("baseDatos");
         
        }catch(IOException ex){
            System.out.println("No se encontro el archivo de configuracion del sistema "+ex);
        }
    }
    
    public boolean conectar(){
        boolean conectado=false;
        try{
            Class.forName("org.postgresql.Driver");//controlador de conexion de BD
            conexion = DriverManager.getConnection("jbdc:postgresql://"+servidor+":"+puerto+"/"+baseDatos,usuario,clave);
            conectado=true;
        }catch(ClassNotFoundException ex){
            
            System.out.println("No se puede conectar a la base de datos por el controlador");
        }
        catch(SQLException ex){
            System.out.println("No se puedo conectar a la Base de Datos");
        }
        return conectado; 
    }*/
    
    public ConectorBD(){
        
            servidor="localhost";
            puerto="5432";
            usuario="adsi";
            clave="utilizar";
            baseDatos="futbol";
        
    }
    public boolean conectar(){
        boolean conectado=false;
        try {
            Class.forName("org.postgresql.Driver");//Controlador de la conexcion de la base de datos 
            conexion=(Connection) DriverManager.getConnection("jdbc:postgresql://localhost:5432/futbol","adsi","utilizar");
            conectado=true;
        } catch (ClassNotFoundException ex) {
            System.out.println("No se pudo conectar a la base de datos por el controlador: "+ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("No se puede conectar a la base de datos "+ex.getMessage());
        }
        return conectado;
    }
    
    public void desconetar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet consultar(String cadenaSQL){
        ConectorBD conector=new ConectorBD();
        if(!conector.conectar()) System.out.println("Error al conectarse a la BD");
        ResultSet resultado=null;
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL,ResultSet.TYPE_SCROLL_SENSITIVE,0);
            resultado=sentencia.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Otro Error en la CadenaSQL:"+cadenaSQL+". \n"+ex.getMessage());
        }
        conector.desconetar();
        return resultado;
    }
   
    public static boolean ejecutarQuery(String cadenaSQL){
        ConectorBD conector=new ConectorBD();
        if(!conector.conectar())System.out.println("OTROOOOOO? Error al conectarse a la Base de Datos");
        try {
            PreparedStatement sentencia=conector.conexion.prepareStatement(cadenaSQL);
            boolean resultado=sentencia.execute();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Otro Erro en la cadena SQL:"+cadenaSQL+". \n"+ex.getMessage());
            return false;
        }
    }
}
