/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgControlador;

import java.sql.DriverManager;

/**
 *
 * @author Garces
 */
public class clsConecta {
    java.sql.Connection con;    
    java.sql.Statement st;
    java.sql.ResultSet res; 
    public clsConecta()
    {
        try {
            try 
            {
                Class.forName("org.postgresql.Driver");
                System.out.println("Driver correcto");
            } 
            catch (Exception e) 
            {
                System.out.println("Error de driver");
            }
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/seguridad", "postgres", "12345qwe");
        } 
        catch (Exception e) 
        {
            System.out.println("No pudo conectar con el motor.");
        }
    }
    public java.sql.ResultSet consulta(String sql)
    {
        try {
            st = con.createStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Error consultando: " + e.toString());
            return null;
        }
    }
    public boolean insertar(String sql)
    {
        try {
            st = con.createStatement();
            int resultado = st.executeUpdate(sql);
            if(resultado == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error insertando: " + e.toString());
            return false;
        }
    }
    public String eliminar(String sql)
    {
        try {
            st = con.createStatement();
            int resultado = st.executeUpdate(sql);
            if(resultado == 1)
            {
                return "Elimino";
            }
            else
            {
                return "Error";
            }
        } catch (Exception e) {
            System.out.println("Error eliminando: " + e.toString());
            return "error";
        }
    }
    public String modifica(String sql)
    {
        try {
            st = con.createStatement();
            int resultado = st.executeUpdate(sql);
            if(resultado == 1)
            {
                return "Modofico";
            }
            else
            {
                return "Error";
            }
        } catch (Exception e) {
            System.out.println("Error modificando: " + e.toString());
            return "Error";
        }
    }
    public boolean validar(String sql)
    {
        java.sql.ResultSet hoja_resultado = null;
        try {
            st = con.createStatement();
            hoja_resultado = st.executeQuery(sql);
            
            if(hoja_resultado.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error validando: " + e.toString());
            return false;
        }
    }
}
