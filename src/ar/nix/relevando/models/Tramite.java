package ar.nix.relevando.models;

import java.sql.Timestamp;

public class Tramite extends DbModel {

	protected String table = "tramites";
	private Integer id;
	private Integer peligroId;
	private Integer responsableId;
	private Integer estado;
	private String descripcion;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    public Tramite(Integer id, Integer peligroId,Integer responsableId, Integer estado,String descripcion) {
        this.id = id;
        this.setPeligroId(peligroId);
        this.responsableId = responsableId;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fechaCreado = new Timestamp(System.currentTimeMillis());
        this.fechaModificado = new Timestamp(System.currentTimeMillis());
        
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
    
}
