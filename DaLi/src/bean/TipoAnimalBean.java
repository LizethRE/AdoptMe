package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.TipoAnimalDao;
import entities.Tipoanimal;

@ManagedBean
@SessionScoped
public class TipoAnimalBean {
	private Tipoanimal tipoAnimal = new Tipoanimal();

	public Tipoanimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(Tipoanimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
	
	public List<Tipoanimal> listarTipoAnimal() {
		TipoAnimalDao taDao = new TipoAnimalDao();
		return taDao.list();
	}
}