package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String correo;

	private String contraseña;

	private String foto;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Adopcion
	@OneToMany(mappedBy="usuario")
	private List<Adopcion> adopcions;

	//bi-directional many-to-one association to Callejero
	@OneToMany(mappedBy="usuario")
	private List<Callejero> callejeros;

	public Usuario() {
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return this.contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Adopcion> getAdopcions() {
		return this.adopcions;
	}

	public void setAdopcions(List<Adopcion> adopcions) {
		this.adopcions = adopcions;
	}

	public Adopcion addAdopcion(Adopcion adopcion) {
		getAdopcions().add(adopcion);
		adopcion.setUsuario(this);

		return adopcion;
	}

	public Adopcion removeAdopcion(Adopcion adopcion) {
		getAdopcions().remove(adopcion);
		adopcion.setUsuario(null);

		return adopcion;
	}

	public List<Callejero> getCallejeros() {
		return this.callejeros;
	}

	public void setCallejeros(List<Callejero> callejeros) {
		this.callejeros = callejeros;
	}

	public Callejero addCallejero(Callejero callejero) {
		getCallejeros().add(callejero);
		callejero.setUsuario(this);

		return callejero;
	}

	public Callejero removeCallejero(Callejero callejero) {
		getCallejeros().remove(callejero);
		callejero.setUsuario(null);

		return callejero;
	}

}