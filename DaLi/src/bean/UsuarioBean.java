package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import entities.Usuario;
import model.UsuarioDao;

@ManagedBean
@SessionScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private Usuario usuarioAutenticado = null;
	private Integer combo;
	private String alerta = "";
	private String alerta2 = "";

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(Usuario usuarioValidado) {
		this.usuarioAutenticado = usuarioValidado;
	}

	public Integer getCombo() {
		return combo;
	}

	public void setCombo(Integer combo) {
		this.combo = combo;
	}

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public String getAlerta2() {
		return alerta2;
	}

	public void setAlerta2(String alerta2) {
		this.alerta2 = alerta2;
	}
	
	public String permiso() {
		if (this.usuarioAutenticado == null) {
			this.alerta = "";
			this.alerta2 = "";
			return "iniciarSesion";
		}
		return "";
	}

	public String login() {
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.findByField("correo", usuario.getCorreo());

		if (u != null) {
			if (u.getCorreo().contentEquals(usuario.getCorreo())) {
				if (u.getContraseña().contentEquals(usuario.getContraseña())) {
					this.usuarioAutenticado = u;
					
					HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
							.getSession(true);
					session.setAttribute("nombre", usuarioAutenticado.getNombre());
					session.setAttribute("correo", usuarioAutenticado.getCorreo());
					System.out.println("Session");
					System.out.println(session.getAttribute("correo"));
					return "inicio";
				} else {
					this.usuarioAutenticado = null;
					this.alerta = "Error al iniciar sesión: credenciales inválidas";
					return "error";
				}
			} else {
				this.usuarioAutenticado = null;
				this.alerta = "Error al iniciar sesión: credenciales inválidas";
				return "error";
			}
		} else {
			this.usuarioAutenticado = null;
			this.alerta = "Error al iniciar sesión: credenciales inválidas";
			return "error";
		}
	}

	public String logout() {
		if (this.usuarioAutenticado != null) {
			HttpSession session = (HttpSession) javax.faces.context.FacesContext.getCurrentInstance().getExternalContext()
					.getSession(false);
			session.invalidate();
			this.usuarioAutenticado = null;
			this.alerta = "";
			this.alerta2 = "";
			System.out.println("Cerrar Sesiom");
			return "index";
			// return "index?faces-redirect=true";
		} else {
			System.out.println("No hay Sesiom");
			return "iniciarSesion";
		}
	}

	public String registrar() {
		UsuarioDao uDao = new UsuarioDao();
		Usuario u = uDao.findByField("correo", usuario.getCorreo());

		if (u != null) {
			this.alerta = "Error al registrarse: usuario ya existe";
			return "error";
		} else {
			usuario.setFoto("/assets/paper_img/placeholder.jpg");
			uDao.insert(usuario);
			this.alerta = "";
			this.alerta2 = "";
			return "iniciarSesion";
		}
	}

	public List<Usuario> listar() {
		UsuarioDao uDao = new UsuarioDao();
		System.out.println(this.combo);
		return uDao.list();
	}
}