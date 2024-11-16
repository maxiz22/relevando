package ar.nix.relevando.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ar.nix.relevando.enums.EstadoPeligro;
import ar.nix.relevando.utils.RandomStringGenerator;

public class Peligro extends DbModel {


    protected Integer id;
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
    private Integer relevadorId  = 1;
    private Integer categoriaId;
    private Timestamp fechaCreado;
    private Timestamp fechaModificado;
    
    
    public Peligro(Integer id, String titulo, String descripcion, String dirección, String barrio, String ciudad, String provincia,Integer responsableId,Integer categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = EstadoPeligro.NUEVO.getCodigo();
        this.codigo = RandomStringGenerator.generateRandomString(5); //Genera un código aleatorio
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.responsableId = responsableId;
        this.categoriaId = categoriaId;
        this.fechaCreado = new Timestamp(System.currentTimeMillis());
        this.fechaModificado = new Timestamp(System.currentTimeMillis());
    }


    public Peligro(ResultSet rs) {
        try {
            this.id = rs.getInt("id");
            this.titulo = rs.getString("titulo");
            this.descripcion = rs.getString("descripcion");
            this.estado = rs.getInt("estado");
            this.codigo = rs.getString("codigo");
            this.barrio = rs.getString("barrio");
            this.ciudad = rs.getString("ciudad");
            this.provincia = rs.getString("provincia");
            this.responsableId = rs.getInt("responsable_id");
            this.categoriaId = rs.getInt("categoria_id");
            this.setFechaCreado(rs.getTimestamp("fecha_creado"));
            this.setFechaModificado(rs.getTimestamp("fecha_modificado"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Peligro() {}
    
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public String getTable() {
		return "peligros";
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
    
	public List<Peligro> findAll() {

    	List<Peligro> listModel = new ArrayList<Peligro>();
    	var resultSet = this.findAllFromDb();
    	try {
			while (resultSet.next()) {
				Peligro model = new Peligro(resultSet);
				listModel.add(model);
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return listModel;
    }
    
    public Peligro findOne(Integer idParam) {
    	var resultSet = this.findOneFromDb(idParam);
    	Peligro model = null;
    	try {
			while (resultSet.next()) {
				model = new Peligro(resultSet);
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
	    return "Peligro{" +
	            "id=" + id +
	            ", titulo='" + titulo + '\'' +
	            ", descripcion='" + descripcion + '\'' +
	            ", codigo='" + codigo + '\'' +
	            ", estado='" + (EstadoPeligro.getByCodigo(estado) != null ? EstadoPeligro.getByCodigo(estado).getDescripcion() : "Desconocido") + '\'' +
	            ", ubicacion=" + (ubicacion != null ? ubicacion.toString() : "null") +
	            ", direccion='" + direccion + '\'' +
	            ", barrio='" + barrio + '\'' +
	            ", ciudad='" + ciudad + '\'' +
	            ", provincia='" + provincia + '\'' +
	            ", responsableId=" + responsableId +
	            ", relevadorId=" + relevadorId +
	            ", categoriaId=" + categoriaId +
	            ", fechaCreado=" + fechaCreado +
	            ", fechaModificado=" + fechaModificado +
	            '}';
	}

	public Integer getRelevadorId() {
		return relevadorId;
	}


	public void setRelevadorId(Integer relevadorId) {
		this.relevadorId = relevadorId;
	}
}
