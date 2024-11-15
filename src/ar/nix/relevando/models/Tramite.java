package ar.nix.relevando.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Tramite extends DbModel {

	protected String table = "tramites";
	private Integer id;
	private Integer peligroId;
	private Integer responsableId;
	private Integer estado;
	private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificado;
    
    public Tramite(Integer id, Integer peligroId,Integer responsableId, Integer estado,String descripcion) {
        this.id = id;
        this.setPeligroId(peligroId);
        this.responsableId = responsableId;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaCreacion = new Timestamp(System.currentTimeMillis());
        this.fechaModificado = new Timestamp(System.currentTimeMillis());
        
    }
    
    public Tramite(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.peligroId = rs.getInt("peligro_id");
            this.responsableId = rs.getInt("responsable_id");
            this.estado = rs.getInt("estado");
            this.descripcion = rs.getString("descripcion");
            this.setFechaCreacion(rs.getTimestamp("fecha_creacion"));
            this.setFechaModificado(rs.getTimestamp("fecha_modificado"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	@Override
	public String getTable() {
		return "tramites";
	}
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getResponsableId() {
		return responsableId;
	}
	public void setResponsableId(Integer responsableId) {
		this.responsableId = responsableId;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
    @Override
    public String toString() {
        return "Tramite{" +
                "id=" + id +
                       ", peligroId=" + peligroId +
                ", responsableId=" + responsableId +
                ", estado=" + estado +
                '}';
    }

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPeligroId() {
		return peligroId;
	}

	public void setPeligroId(Integer peligroId) {
		this.peligroId = peligroId;
	}
	
	public List<Tramite> findAll() {

    	List<Tramite> listModel = new ArrayList<Tramite>();
    	var resultSet = this.findAllFromDb();
    	try {
			while (resultSet.next()) {
				Tramite model = new Tramite(resultSet);
				listModel.add(model);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return listModel;
    }
    
    public Tramite findOne(Integer idParam) {
    	var resultSet = this.findOneFromDb(idParam);
    	Tramite model = null;
    	try {
			while (resultSet.next()) {
				model = new Tramite(resultSet);
			}
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    } 
    
    


	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaModificado() {
		return fechaModificado;
	}

	public void setFechaModificado(Timestamp fechaModificado) {
		this.fechaModificado = fechaModificado;
	}

    
}
