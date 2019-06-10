package model;

import entities.Usuario;
import util.Conexion;

public class UsuarioDao 
	extends Conexion<Usuario> 
	implements GenericDao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
}