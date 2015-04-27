package pqmanagedbeans;

import java.util.*;

public class TablaBean 
{
    private String titulo;
        
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }  
    
    private List<Pelicula> listapeliculas; //la lista a mostrar en la tabla

     public List<Pelicula> getListapeliculas() {
        return listapeliculas;
    }

    public void setListapeliculas(List<Pelicula> listapeliculas) {
        this.listapeliculas = listapeliculas;
    }
   
    public void buscarTituloListener() 
    {
        //cada vez que haya un cambio en el texto, vuelve a generar la lista        
        try
        {
            DatosBean d = new DatosBean();
             //... actualizamos el contenido 
             //y cargamos lista con los elementos encontrados
            listapeliculas = d.getPeliculas(titulo); 
        }catch (Exception ex)
        {
            System.out.println("Error pelis" + ex);
            
        }    
    }
}
