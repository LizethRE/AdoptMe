package model;

import entities.Animal;
import util.Conexion;

public class AnimalDao 
	extends Conexion<Animal> 
	implements GenericDao<Animal>{

	public AnimalDao() {
		// TODO Auto-generated constructor stub
		super(Animal.class);
	}
}
