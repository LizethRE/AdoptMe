package model;

import entities.Callejero;
import util.Conexion;

public class CallejeroDao 
	extends Conexion<Callejero> 
	implements GenericDao<Callejero>{

	public CallejeroDao() {
		// TODO Auto-generated constructor stub
		super(Callejero.class);
	}
}