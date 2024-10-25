package ar.nix.relevando.models;

import java.sql.Timestamp;

public class Tramite {

	private Integer id;
	private Integer responsableId;
	private Integer estado;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    public Tramite(Integer id, Integer responsableId, Integer estado) {
        this.id = id;
        this.responsableId = responsableId;
        this.estado = estado;
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
                ", responsableId=" + responsableId +
                ", estado=" + estado +
                '}';
    }
    
}
