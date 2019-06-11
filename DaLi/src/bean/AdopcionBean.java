package bean;	

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.AdopcionDao;
import model.AnimalDao;
import model.GeneroDao;
import model.TamanioDao;
import model.TipoAnimalDao;
import model.UsuarioDao;
import entities.Adopcion;
import entities.Animal;
import entities.Genero;
import entities.Tamanio;
import entities.Tipoanimal;
import entities.Usuario;

@ManagedBean
@SessionScoped
public class AdopcionBean {
	private Adopcion adopcion = new Adopcion();
	private Animal animal = new Animal();
	private String comboTipoAnimal;
	private String comboGenero;
	private String comboTamanio;
	private Part archivoTomcat;
	private String imagen = "";

	public Adopcion getAdopcion() {
		return adopcion;
	}

	public void setAdopcion(Adopcion adopcion) {
		this.adopcion = adopcion;
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public String getComboTipoAnimal() {
		return comboTipoAnimal;
	}

	public void setComboTipoAnimal(String comboTipoAnimal) {
		this.comboTipoAnimal = comboTipoAnimal;
	}

	public String getComboGenero() {
		return comboGenero;
	}

	public void setComboGenero(String comboGenero) {
		this.comboGenero = comboGenero;
	}

	public String getComboTamanio() {
		return comboTamanio;
	}

	public void setComboTamanio(String comboTamanio) {
		this.comboTamanio = comboTamanio;
	}
	
	public Part getArchivoTomcat() {
		return archivoTomcat;
	}

	public void setArchivoTomcat(Part archivoTomcat) {
		this.archivoTomcat = archivoTomcat;
	}

	public String publicar() {
		AdopcionDao aDao = new AdopcionDao();
		UsuarioDao uDao = new UsuarioDao();
		AnimalDao anDao = new AnimalDao();
		TipoAnimalDao taDao = new TipoAnimalDao();
		GeneroDao gDao = new GeneroDao();
		TamanioDao tDao = new TamanioDao();
		HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		System.out.println(session.getAttribute("correo"));
		Usuario u = uDao.findByField("correo", session.getAttribute("correo"));
		adopcion.setUsuario(u);
		
		Tipoanimal ta = taDao.find(Integer.parseInt(comboTipoAnimal));
		System.out.println(ta.getDescripcion());
		animal.setTipoanimal(ta);
		Genero g = gDao.find(Integer.parseInt(comboGenero));
		System.out.println(g.getDescripcion());
		animal.setGenero(g);
		Tamanio t = tDao.find(Integer.parseInt(comboTamanio));
		System.out.println(t.getDescripcion());
		animal.setTamanio(t);
		anDao.insert(animal);
		Animal animalRegistrado = anDao.findByField("nombre", animal.getNombre());
		System.out.println(animalRegistrado.getNombre());
		adopcion.setAnimal(animalRegistrado);
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		System.out.println(servletContext.getResourcePaths("/publicaciones/adopcion"));
		//String path = servletContext.getRealPath("/publicaciones/adopcion");
		String path = "C:/Users/Windows 7/Documents/Git/dali/DaLi/WebContent/publicaciones/adopcion";
		System.out.println(path);
    	//InputStream inputStream=null;
    	//inputStream = archivo.getInputStream();
    	
    	try (InputStream imgEntrada = archivoTomcat.getInputStream()) {
    		System.out.println(archivoTomcat.getSubmittedFileName());
    		System.out.println(archivoTomcat.getName());
    		System.out.println(archivoTomcat.getSize());
    		System.out.println(archivoTomcat.getContentType());
 
    		String sha1 = "";
    		try {
    			MessageDigest digest = MessageDigest.getInstance("SHA-1");
    	        digest.reset();
    	        digest.update(animalRegistrado.getNombre().getBytes("utf8"));
    	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
    		} catch (Exception e){
    			e.printStackTrace();
    		}  		
    		
    		String imagenSalida = sha1 + ".jpg";
    		imagen = "../publicaciones/adopcion/" + imagenSalida;
    		
	        Files.copy(imgEntrada, new File(path, imagenSalida).toPath(), StandardCopyOption.REPLACE_EXISTING);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
		adopcion.setFoto(imagen);
		aDao.insert(adopcion);
		
		//Volver null para que no guarde las variables insertadas
		adopcion.setDescripcion("");
		adopcion.setFoto("");
		adopcion.setUbicacion("");
		animal.setNombre("");
		animal.setEdad("");
		comboTipoAnimal = "";
		comboGenero = "";
		comboTamanio = "";
		
		return "publicacionesMascota";
	}
	
	public List<Adopcion> listarMisAdopciones() {
		AdopcionDao aDao = new AdopcionDao();
		UsuarioDao uDao = new UsuarioDao();
		HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		System.out.println("listarAdocionws mias");
		System.out.println(session.getAttribute("correo"));
		Usuario u = uDao.findByField("correo", session.getAttribute("correo"));
		
		String usuario = u.getCorreo();
		System.out.println(usuario);
		return aDao.findByFieldList("ubicacion", "Mi casa");
	}
	
	public List<Adopcion> listarAdopciones() {
		AdopcionDao aDao = new AdopcionDao();
		return aDao.list();
	}
	
	public void eliminarAdopcion(Adopcion a) {
		AdopcionDao aDao = new AdopcionDao();
		aDao.delete(a);;
	}
}