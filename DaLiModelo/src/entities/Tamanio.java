package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tamanio database table.
 * 
 */
@Entity
@Table(name="tamanio")
@NamedQuery(name="Tamanio.findAll", query="SELECT t FROM Tamanio t")
public class Tamanio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Animal
	@OneToMany(mappedBy="tamanio")
	private List<Animal> animals;

	public Tamanio() {
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

	public List<Animal> getAnimals() {
		return this.animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal addAnimal(Animal animal) {
		getAnimals().add(animal);
		animal.setTamanio(this);

		return animal;
	}

	public Animal removeAnimal(Animal animal) {
		getAnimals().remove(animal);
		animal.setTamanio(null);

		return animal;
	}

}