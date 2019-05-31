package model;

import entities.Mascota;
import util.Conexion;

public class MascotaDao 
	extends Conexion<Mascota> 
	implements GenericDao<Mascota>{

	public MascotaDao() {
		super(Mascota.class);
	}
	
}