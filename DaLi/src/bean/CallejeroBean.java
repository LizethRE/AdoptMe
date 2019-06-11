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

import model.CallejeroDao;
import model.UsuarioDao;
import entities.Callejero;
import entities.Usuario;

@ManagedBean
@SessionScoped
public class CallejeroBean {
	private Callejero callejero = new Callejero();
	private Part archivoTomcat;
	private String imagen = "";

	public Callejero getCallejero() {
		return callejero;
	}

	public void setCallejero(Callejero callejero) {
		this.callejero = callejero;
	}
	
	public Part getArchivoTomcat() {
		return archivoTomcat;
	}

	public void setArchivoTomcat(Part archivoTomcat) {
		this.archivoTomcat = archivoTomcat;
	}
	
	public String publicar() {
		CallejeroDao cDao = new CallejeroDao();
		UsuarioDao uDao = new UsuarioDao();
		
		HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		System.out.println(session.getAttribute("correo"));
		Usuario u = uDao.findByField("correo", session.getAttribute("correo"));
		callejero.setUsuario(u);
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		System.out.println(servletContext.getResourcePaths("/publicaciones/callejero"));
		//String path = servletContext.getRealPath("/publicaciones/callejero");
		String path = "C:/Users/Windows 7/Documents/Git/dali/DaLi/WebContent/publicaciones/callejero";
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
    	        digest.update(callejero.getNombrecontacto().getBytes("utf8"));
    	        sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
    		} catch (Exception e){
    			e.printStackTrace();
    		}  		
    		
    		String imagenSalida = sha1 + ".jpg";
    		imagen = "../publicaciones/callejero/" + imagenSalida;
    		
	        Files.copy(imgEntrada, new File(path, imagenSalida).toPath(), StandardCopyOption.REPLACE_EXISTING);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
		callejero.setFoto(imagen);
		
		cDao.insert(callejero);
		
		//Volver null para que no guarde las variables insertadas
		callejero.setDescripcion("");
		callejero.setFoto("");
		callejero.setNombrecontacto("");
		callejero.setTelefonocontacto("");
		archivoTomcat = null;
		imagen = "";
		
		return "publicacionesCallejeros";
	}
	
	public List<Callejero> listarMisCallejeros() {
		CallejeroDao cDao = new CallejeroDao();
		UsuarioDao uDao = new UsuarioDao();
		HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false);
		System.out.println(session.getAttribute("correo"));
		Usuario u = uDao.findByField("correo", session.getAttribute("correo"));
		return cDao.findByFieldList("nombrecontacto", "Maria");
	}
	
	public List<Callejero> listarCallejeros() {
		CallejeroDao cDao = new CallejeroDao();
		return cDao.list();
	}
	
	public void eliminarCallejero(Callejero c) {
		CallejeroDao cDao = new CallejeroDao();
		cDao.delete(c);;
	}
}