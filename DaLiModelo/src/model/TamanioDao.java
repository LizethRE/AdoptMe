package model;

import entities.Tamanio;
import util.Conexion;

public class TamanioDao 
	extends Conexion<Tamanio> 
	implements GenericDao<Tamanio>{

	public TamanioDao() {
		// TODO Auto-generated constructor stub
		super(Tamanio.class);
	}

}