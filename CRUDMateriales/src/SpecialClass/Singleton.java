/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SpecialClass;

import View.ViewMateriales;
import View.ViewSearchMateriales;
import View.ViewUbicacion;
import View.ViewUnidad;
import View.ViewUsuario;


/**
 *
 * @author Alonso
 */
public class Singleton 
{
    private static ViewMateriales instancia;
    
    public static ViewMateriales getInstancia()
    {
        if(instancia==null)
        {
            instancia= new ViewMateriales();
        }
        return instancia;
    }
    private static ViewSearchMateriales search;
    
    public static ViewSearchMateriales getInstanciaSearchMateriales()
    {
        if(search==null)
        {
            search= new ViewSearchMateriales();
        }
        return search;
    }
    private static ViewUbicacion instanciaUbicacion;
    
    public static ViewUbicacion getInstanciaUbicacion()
    {
        if(instanciaUbicacion==null)
        {
            instanciaUbicacion= new ViewUbicacion();
        }
        return instanciaUbicacion;
    }
    private static ViewUnidad instanciaUnidad;
    
    public static ViewUnidad getInstanciaUnidad()
    {
        if(instanciaUnidad==null)
        {
            instanciaUnidad= new ViewUnidad();
        }
        return instanciaUnidad;
    }
    private static ViewUsuario instanciaUsuario;
    
    public static ViewUsuario getInstanciaUsuario()
    {
        if(instanciaUsuario==null)
        {
            instanciaUsuario= new ViewUsuario();
        }
        return instanciaUsuario;
    }
}
