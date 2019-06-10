package bean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.print.DocFlavor.URL;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Set;

@ManagedBean
@SessionScoped
public class ImagenBean {
	//Archivo en el directorio de Tomcat
	private Part archivoTomcat;
	
    public Part getArchivoTomcat() {
		return archivoTomcat;
	}

	public void setArchivoTomcat(Part archivoTomcat) {
		this.archivoTomcat = archivoTomcat;
	}

	public String guardarAdopcion (String nombre) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		System.out.println(servletContext.getResourcePaths("/publicaciones/"));
		String path = servletContext.getRealPath("/publicaciones");
		System.out.println(path);
    	//InputStream inputStream=null;
    	//inputStream = archivo.getInputStream();
    	
    	try (InputStream imgEntrada = archivoTomcat.getInputStream()) {
    		System.out.println(archivoTomcat.getSubmittedFileName());
    		System.out.println(archivoTomcat.getName());
    		System.out.println(archivoTomcat.getSize());
    		System.out.println(archivoTomcat.getContentType());
    		
	        Files.copy(imgEntrada, new File(path, "prueba.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
	        return "";
    	}catch (IOException e) {
    		e.printStackTrace();
    		return "";
    	}
    }
	
	public void guardarCallejero (String nombre) {
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		System.out.println(servletContext.getResourcePaths("/publicaciones/"));
		String path = servletContext.getRealPath("/publicaciones");
		System.out.println(path);
    	//InputStream inputStream=null;
    	//inputStream = archivo.getInputStream();
    	
    	try (InputStream imgEntrada = archivoTomcat.getInputStream()) {
    		System.out.println(archivoTomcat.getSubmittedFileName());
    		System.out.println(archivoTomcat.getName());
    		System.out.println(archivoTomcat.getSize());
    		System.out.println(archivoTomcat.getContentType());
    		
	        Files.copy(imgEntrada, new File(path, "prueba.jpg").toPath(), StandardCopyOption.REPLACE_EXISTING);
    	}catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
}
