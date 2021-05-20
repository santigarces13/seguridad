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
public class clsDAOPersona extends clsPersona{
    pkgControlador.clsConecta objConecta;

    public clsDAOPersona() {
        objConecta = new pkgControlador.clsConecta();
    }
    
    public boolean valitePersona()
    {
        String SQL = "select * from administrador.tbl_persona where ced ='" + super.getCed()+ "'";
        if(objConecta.validar(SQL) == false)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public String insertpersona()
    {
        if(!valitePersona())
        {
            String SQL = "insert into administrador.tbl_persona(ced, nom, \"correoeF\") values ('" +  super.getCed() + "','" +  super.getNombre()+ "','" +  super.getCorreoeF()+ "')";          
            

            if(objConecta.insertar(SQL) == false)
            {
                return "3";//3
            }
            else
            {
                //Lllamar al crear persona
                return "1";//1
            }
        }
        else
        {
            return "2";//2
        }

        
    }
    
}
