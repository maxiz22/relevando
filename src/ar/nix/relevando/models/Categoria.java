package ar.nix.relevando.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Categoria extends DbModel {


    private String nombre;
    private String descripcion;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
  
    public Categoria(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.setFechaCreado(new Timestamp(System.currentTimeMillis()));
        this.setFechaModificado(new Timestamp(System.currentTimeMillis()));
    }
    
    public Categoria(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nombre = rs.getString("nombre");
            this.descripcion = rs.getString("descripcion");
            this.setFechaCreado(rs.getTimestamp("fecha_creado"));
            this.setFechaModificado(rs.getTimestamp("fecha_modificado"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Categoria() {}
    
	public Integer getId() {
		return this.id;
	}
	
    @Override
    public String getTable() {
        return "categorias";
    }
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    
    
    public List<Categoria> findAll() {

    	List<Categoria> listModel = new ArrayList<Categoria>();
    	var resultSet = this.findAllFromDb();
    	try {
			while (resultSet.next()) {
				Categoria model = new Categoria(resultSet);
				listModel.add(model);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return listModel;
    }
    
    public Categoria findOne(Integer idParam) {
    	Categoria model = null;
    	var resultSet = this.findOneFromDb(idParam);

    	try {
    	
			while (resultSet.next()) {
				model = new Categoria(resultSet);
			}
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    } 
    
    

	public Timestamp getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(Timestamp fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public Timestamp getFechaModificado() {
		return fechaModificado;
	}

	public void setFechaModificado(Timestamp fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

 
}
