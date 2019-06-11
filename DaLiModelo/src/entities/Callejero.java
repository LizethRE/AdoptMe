package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the callejero database table.
 * 
 */
@Entity
@Table(name="callejero")
@NamedQuery(name="Callejero.findAll", query="SELECT c FROM Callejero c")
public class Callejero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	private String foto;

	private String nombrecontacto;

	private String telefonocontacto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;

	public Callejero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombrecontacto() {
		return this.nombrecontacto;
	}

	public void setNombrecontacto(String nombrecontacto) {
		this.nombrecontacto = nombrecontacto;
	}

	public String getTelefonocontacto() {
		return this.telefonocontacto;
	}

	public void setTelefonocontacto(String telefonocontacto) {
		this.telefonocontacto = telefonocontacto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}