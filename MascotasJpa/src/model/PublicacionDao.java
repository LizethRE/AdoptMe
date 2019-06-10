package model;

import entities.Publicacion;
import util.Conexion;

public class PublicacionDao 
	extends Conexion<Publicacion> 
	implements GenericDao<Publicacion>{

	public PublicacionDao() {
		super(Publicacion.class);
	}
	
}