package ar.nix.relevando.models;

import java.sql.Timestamp;

public class Categoria {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    public Categoria(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
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
}
