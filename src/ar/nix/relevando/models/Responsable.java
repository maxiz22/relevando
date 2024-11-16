package ar.nix.relevando.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Responsable extends DbModel {
	

    private Integer id;
    private String nombre;
    private String email;
    private String telefono;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    public Responsable(Integer id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaCreado = new Timestamp(System.currentTimeMillis());
        this.fechaModificado = new Timestamp(System.currentTimeMillis());
    }
    
    public Responsable(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.nombre = rs.getString("nombre");
            this.email = rs.getString("email");
            this.telefono = rs.getString("telefono");
            this.setFechaCreado(rs.getTimestamp("fecha_creado"));
            this.setFechaModificado(rs.getTimestamp("fecha_modificado"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Responsable() {}
    
	@Override
	public String getTable() {
		return "responsables";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
	public List<Responsable> findAll() {

    	List<Responsable> listModel = new ArrayList<Responsable>();
    	var resultSet = this.findAllFromDb();
    	try {
			while (resultSet.next()) {
				Responsable model = new Responsable(resultSet);
				listModel.add(model);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return listModel;
    }
    
    public Responsable findOne(Integer idParam) {
    	var resultSet = this.findOneFromDb(idParam);
    	Responsable model = null;
    	try {
			while (resultSet.next()) {
				model = new Responsable(resultSet);
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

 
    @Override
    public String toString() {
        return "Responsable{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }


}
