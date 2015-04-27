package pqmanagedbeans;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatosBean 
{
    Connection conexion = null;
    
    public void conectarSQL() throws SQLException
    {
       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
       conexion =DriverManager.getConnection("jdbc:oracle:thin:@LOCALHOST:1521:XE","system", "javaoracle");
    }
    
    public List<Pelicula> getPeliculas(String titulo) throws SQLException
    {
        String consulta = "SELECT TITULO, DIRECTOR, FOTO FROM PELIS WHERE TITULO LIKE ?";
        this.conectarSQL();
        PreparedStatement pst = this.conexion.prepareCall(consulta);
        pst.setString(1, titulo + "%");
        ResultSet rs = pst.executeQuery();
        ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
        while (rs.next())
        {
            Pelicula p = new Pelicula();
            p.setTitulo(rs.getString(("TITULO")));
            p.setDirector(rs.getString(("DIRECTOR")));
            p.setCartel(rs.getString(("FOTO")));
            
            pelis.add(p);
        }
        return pelis;
    }
}
