package ar.nix.relevando.models;

import java.sql.Timestamp;

public class Peligro {

    private Integer id;
    private String titulo;
    private String descripcion;
    private String codigo;
    private Integer estado;
    private Location ubicacion;
    private String direccion;
    private String barrio;
    private String ciudad;
    private String provincia;
    private Integer responsableId;
    private Integer categoriaId;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    
    public Peligro(int id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Location getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Location ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Integer getResponsableId() {
		return responsableId;
	}
	public void setResponsableId(Integer responsableId) {
		this.responsableId = responsableId;
	}
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}
    
    @Override
    public String toString() {
        return "Peligro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
               // ", location='" + location + '\'' +
               // ", fechaCreado=" + fechaCreado +
               // ", fechaModificado=" + fechaModificado +
                '}';
    }
}
