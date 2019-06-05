package model;

import entities.Genero;
import util.Conexion;

public class GeneroDao 
	extends Conexion<Genero> 
	implements GenericDao<Genero>{

	public GeneroDao() {
		// TODO Auto-generated constructor stub
		super(Genero.class);
	}
}
