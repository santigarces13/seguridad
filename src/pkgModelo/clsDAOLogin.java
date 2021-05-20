/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModelo;

/**
 *
 * @author Garces
 */
public class clsDAOLogin extends clsLogin{
    pkgControlador.clsConecta objConecta;

    public clsDAOLogin() {
        objConecta = new pkgControlador.clsConecta();
    }
    public boolean valiteLogin()
    {
        String SQL = "select * from administrador.tbl_login where correoe ='" + super.getCorreoe() + "' and clave ='" + super.getClave() + "'";
        if(objConecta.validar(SQL) == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean valiteUsuario()
    {
        String SQL = "select * from administrador.tbl_login where correoe ='" + super.getCorreoe() + "'";
        if(objConecta.validar(SQL) == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public String insertRegister()
    {
        if(!valiteUsuario())
        {
            String SQL = "insert into administrador.tbl_login(correoe, clave) values ('" +  super.getCorreoe() + "', '" +  super.getClave() + "')";            
            

            if(objConecta.insertar(SQL) == false)
            {
                return "3";//3
            }
            else
            {
                return "1";//1
            }
        }
        else
        {
            return "2";//2
        }

        
    }
    
}
