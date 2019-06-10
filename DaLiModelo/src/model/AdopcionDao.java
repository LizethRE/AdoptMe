package model;

import entities.Adopcion;
import util.Conexion;

public class AdopcionDao 
	extends Conexion<Adopcion> 
	implements GenericDao<Adopcion>{

	public AdopcionDao() {
		// TODO Auto-generated constructor stub
		super(Adopcion.class);
	}
}
