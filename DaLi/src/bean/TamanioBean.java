package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Tamanio;
import model.TamanioDao;

@ManagedBean
@SessionScoped
public class TamanioBean {
	private Tamanio tamanio = new Tamanio();
	
	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public List<Tamanio> listarTamanio() {
		TamanioDao tDao = new TamanioDao();
		return tDao.list();
	}
}