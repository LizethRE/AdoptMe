package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.GeneroDao;
import entities.Genero;

@ManagedBean
@SessionScoped
public class GeneroBean {
	private Genero genero = new Genero();
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> listarGenero() {
		GeneroDao gDao = new GeneroDao();
		return gDao.list();
	}
}