package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@Table(name="animal")
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String edad;

	private String nombre;

	//bi-directional many-to-one association to Adopcion
	@OneToMany(mappedBy="animal")
	private List<Adopcion> adopcions;

	//bi-directional many-to-one association to Tamanio
	@ManyToOne
	@JoinColumn(name="idtamanio")
	private Tamanio tamanio;

	//bi-directional many-to-one association to Genero
	@ManyToOne
	@JoinColumn(name="idgenero")
	private Genero genero;

	//bi-directional many-to-one association to Tipoanimal
	@ManyToOne
	@JoinColumn(name="idtipoanimal")
	private Tipoanimal tipoanimal;

	public Animal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEdad() {
		return this.edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Adopcion> getAdopcions() {
		return this.adopcions;
	}

	public void setAdopcions(List<Adopcion> adopcions) {
		this.adopcions = adopcions;
	}

	public Adopcion addAdopcion(Adopcion adopcion) {
		getAdopcions().add(adopcion);
		adopcion.setAnimal(this);

		return adopcion;
	}

	public Adopcion removeAdopcion(Adopcion adopcion) {
		getAdopcions().remove(adopcion);
		adopcion.setAnimal(null);

		return adopcion;
	}

	public Tamanio getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Tipoanimal getTipoanimal() {
		return this.tipoanimal;
	}

	public void setTipoanimal(Tipoanimal tipoanimal) {
		this.tipoanimal = tipoanimal;
	}

}