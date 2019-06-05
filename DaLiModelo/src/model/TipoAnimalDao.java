package model;

import entities.Tipoanimal;
import util.Conexion;

public class TipoAnimalDao 
	extends Conexion<Tipoanimal> 
	implements GenericDao<Tipoanimal>{

	public TipoAnimalDao() {
		// TODO Auto-generated constructor stub
		super(Tipoanimal.class);
	}
}
