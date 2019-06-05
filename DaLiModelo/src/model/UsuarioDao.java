package model;

import entities.Usuario;
import util.Conexion;

public class UsuarioDao 
	extends Conexion<Usuario> 
	implements GenericDao<Usuario>{

	public UsuarioDao() {
		// TODO Auto-generated constructor stub
		super(Usuario.class);
	}
	
}
