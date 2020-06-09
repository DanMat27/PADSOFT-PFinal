package Sistema;

/**
 * Sistema.java
 * Clase correspondiente al sistema que gestiona la aplicacion.
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import Usuarios.*;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import es.uam.eps.padsof.telecard.TeleChargeAndPaySystem;
import pads.musicPlayer.Mp3Player;
import pads.musicPlayer.exceptions.Mp3PlayerException;
import Reproduccion.*;
import Musica.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;
import Excepciones.*;
import FechaSimulada.FechaSimulada;

public class Sistema {
	private int limiteRepAnonimo;
	private int limiteRepNormal;
	private int topeSerPremium;
	private double costePremium;
	private Usuario administrador;
	private Usuario anonimo;
	private Usuario usuarioConectado;
	private List<Autor> listaUsuarios;
	private List<Cancion> listaCanciones;
	private List<Listas> listaListas;
	private List<Notificaciones> listaNotif;
	private List<Reproduccion> listaRep;
	
	/**
	 * Constructor de la clase Sistema.
	 * @param limiteRepAnonimo Valor entero del limite de reproducciones del usuario anonimo.
	 * @param limiteRepNormal Valor entero del limite de reproducciones del usuario normal.
	 * @param topeSerPremium Valor entero del tope de reproducciones para convertirse premium.
	 * @param costePremium Valor entero del coste economico para convertirse en premium.
	 * @param administrador Usuario con la informacion correspondiente al administrador.
	 * @param anonimo Usuario con la informacion correspondiente al anonimo.
	 */
	public Sistema(int limiteRepAnonimo, int limiteRepNormal, int topeSerPremium, double costePremium,
	Usuario administrador, Usuario anonimo) {
		this.limiteRepAnonimo = limiteRepAnonimo;
		this.limiteRepNormal = limiteRepNormal;
		this.topeSerPremium = topeSerPremium;
		this.costePremium = costePremium;
		this.administrador = administrador;
		this.anonimo = anonimo;
		this.usuarioConectado = null;
		this.listaUsuarios = new ArrayList<Autor>(); 
		this.listaCanciones = new ArrayList<Cancion>();
		this.listaListas = new ArrayList<Listas>();
		this.listaNotif = new ArrayList<Notificaciones>();
		this.listaRep = new ArrayList<Reproduccion>();
	}
		
	/**
	 * Devuelve el limite de reproducciones establecido para un usuario anonimo.
	 * @return limiteRepAnonimo Limite de reproducciones.
	 */
	public int getLimiteRepAnonimo() {
		return limiteRepAnonimo;
	}
	
	/**
	 * Devuelve el limite de reproducciones establecido para un usuario registrado.
	 * @return limiteRepNormal
	 */
	public int getLimiteRepNormal() {
		return limiteRepNormal;
	}

	/**
	 * Devuelve el valor de reproducciones tope para que un usuario normal se haga premium.
	 * @return topeSerPremium Tope de reproducciones.
	 */
	public int getTopeSerPremium() {
		return topeSerPremium;
	}

	/**
	 * Devuelve el valor del coste para la suscripcion premium.
	 * @return costePremium Coste para premium.
	 */
	public double getCostePremium() {
		return costePremium;
	}

	/**
	 * Devuelve el usuario administrador del sistema.
	 * @return administrador Usuario administrador.
	 */
	public Usuario getAdministrador() {
		return administrador;
	}

	/**
	 * Devuelve el usuario anonimo del sistema.
	 * @return anonimo Usuario anonimo.
	 */
	public Usuario getAnonimo() {
		return anonimo;
	}
	
	/**
	 * Devuelve el usuario conectado actualmente en la aplicacion.
	 * @return usuarioConectado Usuario conectado en la aplicacion.
	 */
	public Usuario getUsuarioConectado() {
		return usuarioConectado;
	}

	/**
	 * Devuelve la lista de todos los usuarios registrados del sistema-
	 * @return listaUsuarios Lista de usuarios.
	 */
	public List<Autor> getListaUsuarios() {
		return listaUsuarios;
	}
	
	/**
	 * Devuelve la lista de todas las canciones del sistema.
	 * @return listaCanciones Lista de canciones.
	 */
	public List<Cancion> getListaCanciones() {
		return listaCanciones;
	}

	/**
	 * Devuelve la lista de listas (Listas de reproduccion y albumes) del sistema.
	 * @return listaListas Lista de listas.
	 */
	public List<Listas> getListaListas() {
		return listaListas;
	}

	/**
	 * Devuelve la lista de todas las notificaciones del sistema.
	 * @return listaNotif Lista de notificaciones.0
1	 */
	public List<Notificaciones> getListaNotif() {
		return listaNotif;
	}

	/**
	 * Devuelve la lista de reproducciones del sistema.
	 * @return listaRep Lista de reproducciones.
	 */
	public List<Reproduccion> getListaRep() {
		return listaRep;
	}

	/**
     * Funcion que realiza el acceso a la aplicación del usuario anonimo.
     * Guarda en usuarioConectado el usuario anonimo.
     * @return true si ha accedido sin problemas, false si no.
     */
    public Boolean accederAnonimo() {  	
        if(this.getUsuarioConectado() != null) {
            return false;
        }
        else{
        	this.usuarioConectado = this.getAnonimo();
        	return true; 
        }
    }
     
    /**
     * Funcion que realiza la desconexión de la aplicación de un usuario anónimo.
     * Quita de usuarioConectado el usuario anonimo
     * @return true si se ha desconectado sin problemas, sino false 
     */
    public Boolean salirAnonimo() {
        if(!this.getUsuarioConectado().getNombre().equals("anonimo")) {
            return false;
        }
          
        this.usuarioConectado = null;
        return true;
    }
     
    /**
     * Funcion que realiza el acceso a la aplicación del administrador.
     * Guarda en usuarioConectado el usuario administrador.
     * Se le notifica de las notificaciones recibidas en su ausencia.
     * @param password Contrasenia del administrador.
     * @return true si ha accedido sin problemas, false si no.
     */
    public Boolean accederAdministrador(String password) {
        if(!this.administrador.getContrasenia().equals("admin")) {
        	return false;
        }
             	
        if(this.getUsuarioConectado() != null) {
            return false;
        }
        else{
        	this.usuarioConectado = this.getAdministrador();
        	return true;
        }
    }
     
    /**
     * Funcion que realiza la desconexión de la aplicación de un usuario administrador.
     * Quita de usuarioConectado el usuario administrador
     * @return true si se ha desconectado sin problemas, sino false 
     */
    public Boolean salirAdministrador() {
        if(!this.getUsuarioConectado().getNombre().equals("admin")) {
            return false;
        }

        this.usuarioConectado = null;
        return true;
    }
    
    /**
     * Funcion que realiza el acceso a la aplicación de un usuario registrado.
     * Guarda en usuarioConectado el usuario registrado en cuestion.
     * Se le notifica de las notificaciones recibidas en su ausencia.
     * @param nick Nickname del usuario registrado que realiza el login.
     * @param password Contrasenia del usuario registrado que realiza el login.
     * @return true si ha accedido sin problemas, false si no.
     * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */
    public Boolean login(String nick, String password) throws UsuarioInvalido {
        if(this.getUsuarioConectado() != null) {
            return false;
        }
         
        for(Autor a: this.getListaUsuarios()) {
            if((a.getNickname().equals(nick)) && (a.getContrasenia().equals(password))){
                if(a.isBloqueado()!=true) {
                	this.usuarioConectado = a;
                    this.vencimientoPremium();
                    return true;
                }
            }
        }
        return false;
    }
	
    /**
     * Funcion que realiza la desconexion de la aplicación de un usuario registrado.
     * Quita de usuarioConectado el usuario registrado en cuestion.
     * @return true si se ha desconectado sin problemas, false si no.
     */
    public Boolean logout() {   
        if(this.getUsuarioConectado().getNombre().equals("admin") && this.getUsuarioConectado().getNombre().equals("anonimo")) {
            return false;
        }
    	
        this.usuarioConectado = null;
        return true;
    }
	
    /**
     * Funcion que realiza el registro de un nuevo usuario. 
     * Asigna la informacion introducida por el usuario al nuevo usuario registrado.
     * Aniade el nuevo usuario a la lista de usuario.
     * @param nombre Nombre del usuario.
     * @param contrasenia Contrasenia del usuario.
     * @param fechaDeNacimiento Fecha de nacimiento del usuario.
     * @param nickname Nickname del usuario.
     * @return true si se registro sin problemas, false si no.
     */
    public Boolean registrarse(String nombre, String contrasenia, LocalDate fechaDeNacimiento, String nickname) {

        for(Autor a: this.getListaUsuarios()) {
            if(a.getNickname().equals(nickname)) {
                return false;
            }
        }
        
        Autor a = new Autor(nombre, contrasenia, 0, fechaDeNacimiento, nickname, false);
        this.getListaUsuarios().add(a);
        return true;
    } 
	
	/**
	 * Funcion que desbloquea a un usuario en estado de bloqueado.
	 * @param a Autor para desbloquear.
	 * @return true si se ha desbloqueado con exito, false si no.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean desbloquearUsuario(Autor a) throws UsuarioInvalido {

		if(this.usuarioConectado.getNombre() != "admin") {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
	
		if (a.isBloqueado()) {
			
			if(a.getFechaBloqueado().getYear()!=2999) {
				
				if((FechaSimulada.getHoy().getDayOfYear() - a.getFechaBloqueado().getDayOfYear()) > 30) {
					a.setBloqueado(false);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Funcion que crea una cancion nueva.
	 * Comprueba que la cancion no exista ya en la aplicacion. 
	 * La cancion se crea en estado de EN_ESPERA.
	 * @param name Nombre de la cancion.
	 * @param MP3 Path de la cancion.
	 * @return true si se creo con exito, false si no.
	 * @throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido. 
	 */
	@SuppressWarnings("static-access")
	public Boolean subirCancion(String name, String MP3) throws FileNotFoundException, Mp3PlayerException, UsuarioInvalido {
		Mp3Player p = new Mp3Player();
		Autor a = (Autor)this.usuarioConectado;
		double aux = 0;  
		String path=null;
		Notificaciones notif = null;
		int id=0;
		
		path = "Canciones" + File.separator + MP3;
				
		if(this.usuarioConectado.getNombre().equals("anonimo") || this.usuarioConectado.getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
		
		try {
			aux = p.getDuration(path);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			return false;
		}
			
		Cancion c = new Cancion(aux,name,this.getListaCanciones().size(),EstadosCancion.EN_ESPERA,path, a);
	
		if (a.getListacancion().contains(c)) {
			return false;
		}
		else {
			a.getListacancion().add(c);
			this.getListaCanciones().add(c);
			
			id = this.getListaNotif().size();
			notif = new Notificaciones("El autor " + a.getNickname() + " quiere subir la cancion " + c.getName(), a, id);
			this.getListaNotif().add(notif);
			this.administrador.getNotificaciones().add(notif);
			
			return true;
		}
		
	}

	/**
     * Funcion que crea y aniade una lista nueva a la aplicacion.
     * Aniade la lista a la lista de listas del sistema.
     * La lista se crea vacia.
     * @param name Nombre de la lista
     * @return true si se creo con exito, false si no.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */ 
    public Boolean crearListaRep(String name) throws UsuarioInvalido {  
    	int id=0;
    	
        if(this.getUsuarioConectado().getNombre() == "anonimo" || this.getUsuarioConectado().getNombre() == "administrador") {
        	throw new UsuarioInvalido(this.getUsuarioConectado());
        }
         
        List<Cancion> canciones = new ArrayList<Cancion>();
        
        Autor a = null;
        
        a = (Autor)this.getUsuarioConectado();
        
        id = this.getListaListas().size();
        
        Listas l = new ListaReproduccion(0, name , canciones, a, id);
         
        a.getListaListas().add(l);
        this.getListaListas().add(l);
         
        return true;
    } 
     
    /**
     * Funcion que crea y aniade un album nuevo a la aplicacion.
     * Aniade el album a la lista de listas del sistema.
     * El album se crea vacio.
     * @param name Nombre del album.
     * @return true si se creo con exito, false si no. 
     * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */
    public Boolean crearAlbum(String name) throws UsuarioInvalido {
    	int id=0;
    	
        if(this.getUsuarioConectado().getNombre() == "anonimo" || this.getUsuarioConectado().getNombre() == "administrador") {
            throw new UsuarioInvalido(this.getUsuarioConectado());
        }
         
        List<Cancion> canciones = new ArrayList<Cancion>();
        
        Autor a = null;
        
        a = (Autor)this.getUsuarioConectado();
        
        id = this.getListaListas().size();
        
        Listas album = new Album(0, name , canciones, a, id);

        a.getListaListas().add(album);
        this.getListaListas().add(album);
         
        return true;
    }
	
	/**
	 * Funcion en la que se valida una cancion en estado de EN_ESPERA.
	 * La cancion pasa a estar VALIDADA si no tiene errores. Si no, pasa a ser
	 * NO_VALIDADA. 
	 * Una vez validada, se avisa a todos los seguidores del autor de la subida (si tiene).
	 * @param c Cancion para validar.
	 * @param val True si el admin quiere que se valide, false si no.
	 * @throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	@SuppressWarnings("static-access") 
	public void validarCancion(Cancion c, Boolean val) throws FileNotFoundException, Mp3PlayerException, UsuarioInvalido {
		if (this.usuarioConectado.getNombre().equals("admin")) {	
			if(c.getEstado() == EstadosCancion.EN_ESPERA) {
				Mp3Player m = new Mp3Player();
				if (m.isValidMp3File(c.getMP3()) && val==true) {
					
					if(c.getAutor().getListaseguidores().size() > 0) {
						int id = this.getListaNotif().size();
						Notificaciones notif = new Notificaciones("El usuario " + c.getAutor().getNickname() + " ha subido la cancion: " + c.getName(), c.getAutor(), id);
				        for(Autor au: c.getAutor().getListaseguidores()) {
				            au.getNotificaciones().add(notif);
				        }
				        this.getListaNotif().add(notif);
					}   				
					c.modificarEstado( EstadosCancion.VALIDADA);
				}
				else {
					c.modificarEstado(EstadosCancion.NO_VALIDADA);
					int id = this.getListaNotif().size();
					Notificaciones notif = new Notificaciones("Autor: " + c.getAutor().getNickname() + " tiene tres dias para cambiar el archivo de la cancion " + c.getName() + " antes de ser bloqueada.", c.getAutor(), id);
					c.getAutor().getNotificaciones().add(notif);
			        this.getListaNotif().add(notif);
				}
			}
			
		}
		else {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
			
	}
	
	/**
	 * Funcion en la que se comprueba si posee plagio la cancion. 
	 * Si contiene plagio, se procede a bloquear a la cancion y al usuario.
	 * @param c Cancion para revisar plagio.
	 * @param plagio Opinion del administrador sobre si la cancion tiene plagio.
	 * @param id Id de la notificacion del reporte.
	 * @return true si se ha realizado correctamente, false si no
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public boolean revisarPlagio(Cancion c, boolean plagio, int id) throws UsuarioInvalido {
		if(!this.getUsuarioConectado().getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado()); 
		}
		
		if(!this.getListaCanciones().contains(c)) {
			return false;
		}
		
		if(plagio == false) {
            Notificaciones n = null;
            n = this.getListaNotif().get(id);
             
            Autor aux = null;
            aux = (Autor)n.getUsuario();
             
            this.bloquearUsuario(aux);
             
            c.modificarEstado(EstadosCancion.VALIDADA);
            return true;
		}else {
			if(!this.getListaUsuarios().contains(c.getAutor())){
				return false;
			}
			this.bloquearUsuario(c.getAutor());
			FechaSimulada.restablecerHoyReal();
			c.getAutor().setFechaBloqueado(FechaSimulada.fijarFecha(1, 1, 2999));
            c.modificarEstado(EstadosCancion.BLOQUEADA);
			return true;
		}
	}
	
	/**
	 * Funcion en la que se bloquea a un usuario en concreto.
	 * El usuario podra ser bloqueado indefinidamente o durante 30 dias.
	 * El usuario indefinido tendra de anio bloqueo 2999.
	 * @param a Autor para bloquear.
	 * @return true si se bloqueo con exito, false si no.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean bloquearUsuario(Autor a) throws UsuarioInvalido {
		
		if(a.isBloqueado() || !this.usuarioConectado.getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado()); 
		} 
		
		FechaSimulada.restablecerHoyReal();
		a.setFechaBloqueado(FechaSimulada.getHoy());
		a.setBloqueado(true);
		
		return true;
	}
	
	/**
	 * Funcion que modifica los parametros o atributos que posee el sistema sobre 
	 * la aplicacion. Si uno no se quiere modificar, se introduce un -1.
	 * @param limiteRepAnonimo Valor entero del limite de reproducciones del usuario anonimo.
	 * @param limiteRepNormal Valor entero del limite de reproducciones del usuario normal.
	 * @param topeSerPremium Valor entero del tope de reproducciones para convertirse premium.
	 * @param costePremium Valor entero del coste economico para convertirse en premium.
	 * @return true si se cambiaron exitosamente, false si no.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean cambiarConfiguracion(int limiteRepAnonimo, int limiteRepNormal, int topeSerPremium, double costePremium) throws UsuarioInvalido {
		if(!this.getUsuarioConectado().getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado()); 
		}
		
		if(limiteRepAnonimo!=0) {
			this.limiteRepAnonimo = limiteRepAnonimo;
		}
		if(limiteRepNormal!=0) {
			this.limiteRepNormal = limiteRepNormal;
		}
		if(topeSerPremium!=0) {
			this.topeSerPremium = topeSerPremium;
		}
		if(costePremium!=0) {
			this.costePremium = costePremium;
		}
		
		return true;
	}
	
	/**
	 * Funcion en la que se bloquea a una cancion en concreto.
	 * La cancion pasa a estar en estado BLOQUEADA.
	 * @param c Cancion para bloquear.
	 * @return true si se bloqueo con exito, false si no.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean bloquearCancion(Cancion c) throws UsuarioInvalido {
		
		if (this.usuarioConectado.getNombre() == "admin") {
			if (c.getEstado() != EstadosCancion.BLOQUEADA) {
				c.modificarEstado(EstadosCancion.BLOQUEADA);
				return true;
			}
			
		}
		throw new UsuarioInvalido(this.getUsuarioConectado()); 

	}
	 
    /**
     * Esta funcion comprueba si el usuario ha agotado el periodo de premium.
     * Si lo ha agotado, el usuario deja de ser premium.
     * @return true si lo ha agotado, false si no.
     * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */
    public Boolean vencimientoPremium() throws UsuarioInvalido {
        if (this.usuarioConectado.getNombre() == "anonimo" || this.usuarioConectado.getNombre() == "admin") {
        	throw new UsuarioInvalido(this.getUsuarioConectado()); 
        } 
        Autor a = null;
         
        a = (Autor)this.getUsuarioConectado();
         
        if (!a.isPremium()) {
            return false;
        }
        FechaSimulada.restablecerHoyReal();
         
        if(FechaSimulada.getHoy().getYear() - a.getFechainicio().getYear()>0) {
        	int id = this.getListaNotif().size();
        	Notificaciones notif = new Notificaciones("Usted ha agotado su suscripcion premium", a, id);
        	this.getListaNotif().add(notif);
            a.ConvertirsePremium(false);
            return true;
        }
         
        else if(FechaSimulada.getHoy().getDayOfYear() - a.getFechainicio().getDayOfYear()  < 30) {
            return false;
        }
        else{
        	int id = this.getListaNotif().size();
        	Notificaciones notif = new Notificaciones("Usted ha agotado su suscripcion premium", a, id);
        	this.getListaNotif().add(notif);
            a.ConvertirsePremium(false);
            return true;
        }
     }
	
    /**
     * Funcion en la que se pone una cancion a explícito si el administrador quiere.
     * La cancion pasa a estar en el estado EXPLICITA.
     * @param c Cancion a la que catalogar.
     * @return true si se ha cambiado con exito, false si no.
     * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */
    public Boolean comprobarExplicito(Cancion c) throws UsuarioInvalido {
        if(!this.getUsuarioConectado().getNombre().equals("admin")) {
        	throw new UsuarioInvalido(this.getUsuarioConectado()); 
        }
         
        if(!this.getListaCanciones().contains(c) || c.getEstado()!=EstadosCancion.VALIDADA) {
            return false;
        }
         
        c.modificarEstado(EstadosCancion.EXPLICITA);
        return true;
    }
    
	/**
	 * Funcion en la que se cancela el registro de un usuario registrado.
	 * El usuario se quita de la lista de usuarios del sistema.
	 * @return true si se cambio con exito, false si no. 
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean cancelarRegistro() throws UsuarioInvalido {
		 if(this.getUsuarioConectado().getNombre() == "anonimo" || this.getUsuarioConectado().getNombre() == "admin") {
			 throw new UsuarioInvalido(this.getUsuarioConectado()); 
	      }
		 
		 if(!this.getListaUsuarios().contains(this.getUsuarioConectado())){
			 return false;
		 }
		 
		 this.getListaUsuarios().remove(this.getUsuarioConectado());
		 this.usuarioConectado = null;
		 return true;
	}
	 
    /**
     * Funcion en la que un usuario denuncia una cancion en concreto por plagio.
     * La cancion pasa a BLOQUEADA provisionalmente.
     * El usuario realiza un texto justificando el motivo.
     * @param c Cancion a reportar
     * @param denuncia Texto del reporte
     * @return true si se reporto con exito, false si no.
     */
    public Boolean reportarPlagio(Cancion c, String denuncia) {
        int id=0;
        if (!this.listaCanciones.contains(c)) {
            return false;
        }
        if (c.getEstado() == EstadosCancion.BLOQUEADA) {
            return false;
        }
         
        id = this.getListaNotif().size();
        Notificaciones n = new Notificaciones(denuncia,this.usuarioConectado, id);
        this.listaNotif.add(n);
        this.administrador.getNotificaciones().add(n);
        c.modificarEstado(EstadosCancion.BLOQUEADA);
        return true;
    }
	
    /**
     * Funcion en la que un usuario modifica una cancion suya en estado de NO_VALIDADA 
     * antes del plazo de eliminacion.
     * @param c Cancion para modificar.
     * @param a Autor que quiere modificar su cancion.
     * @return true si se modifico con exito, false si no.
     * @throws Mp3PlayerException 
     * @throws FileNotFoundException 
     * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
     */
    public Boolean modificarCancion(Cancion c, Autor a) throws FileNotFoundException, Mp3PlayerException, UsuarioInvalido {
        if (c.getEstado() == EstadosCancion.NO_VALIDADA) {
            if(FechaSimulada.getHoy().getDayOfYear() - c.getFechaNV().getDayOfYear() <=3) {
                for(Cancion d:this.getListaCanciones()) {
                	if(d.getName() == c.getName()) {
                		this.getListaCanciones().remove(d);
                   		a.getListacancion().remove(d);
                		this.subirCancion(c.getName(), c.getMP3());
                	}
                }
                return true;
            }
        }
        return false;
    }
	
	/**
	 * Funcion en la que un usuario registrado normal se convierte en premium.
	 * @param tarjeta Tarjeta de credito.
	 * @return true si se convirtio con exito, false si no.
	 * @throws OrderRejectedException 
	 * @throws FailedInternetConnectionException 
	 * @throws InvalidCardNumberException 
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 */
	public Boolean convertirsePremium(String tarjeta) throws InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, UsuarioInvalido {
		Autor a = (Autor)this.getUsuarioConectado();
		if(this.getUsuarioConectado().getNombre() == "anonimo" || this.getUsuarioConectado().getNombre() == "admin") {
			throw new UsuarioInvalido(this.getUsuarioConectado()); 
		}
		
		if(a.isPremium() == true) { 
			return false;
		}
		
		TeleChargeAndPaySystem.charge(tarjeta, "Conversion a Premium", this.getCostePremium());

		FechaSimulada.restablecerHoyReal();
		a.setFechainicio(FechaSimulada.getHoy());
		
		a.ConvertirsePremium(true);
		
		return true;
	}
	
	/**
	 * Funcion en la que se reproduce una cancion especifica.
	 * La cancion debe estar en estado de VALIDADA.
	 * @param c Cancion para reproducir.
	 * @return player Gestor MP3 que reproduce la cancion.
	 * @throws Mp3PlayerException 
	 * @throws FileNotFoundException 
	 */
	public Mp3Player reproducirCancion(Cancion c) throws Mp3PlayerException, FileNotFoundException {
		Mp3Player player = new Mp3Player();
		Reproduccion rep = null;
		LocalDate fecha;
		int repTot;
		int id;
		Autor aux = null;
		
		FechaSimulada.restablecerHoyReal();
		fecha = FechaSimulada.getHoy();
		
		if(c.getEstado() != EstadosCancion.VALIDADA && c.getEstado() != EstadosCancion.EXPLICITA) {
			return null;
		}
		
		aux = (Autor)this.usuarioConectado;
		if(c.getEstado() == EstadosCancion.EXPLICITA && aux.isPremium()==true) {
			if(!aux.mayorEdad(fecha) ) {
				return null;
			}
		}
		
		player.add(c.getMP3());
		player.play();
		
		if(this.getUsuarioConectado().getNombre() == "anonimo") {
			if(this.getUsuarioConectado().getRepTotalesExternas() == this.getLimiteRepAnonimo()) {
				return null;
			}
		}
		
		if(this.getUsuarioConectado().getNombre() != "admin") {
			if(this.getUsuarioConectado().getRepTotalesExternas() == this.getLimiteRepNormal()) {
				return null;
			}
		}
		
		if(this.getUsuarioConectado() != c.getAutor()) {
			id = this.getListaRep().size();
			rep = new Reproduccion(fecha, this.getUsuarioConectado(), c, id);
			
			repTot = this.getUsuarioConectado().getRepTotalesExternas();
			this.getUsuarioConectado().modificarRepTotalesExternas(repTot + 1);
			repTot = c.getNReproducciones();
			c.modificarNReproducciones(repTot + 1);
			
			this.getListaRep().add(rep);
			c.getListaReproducciones().add(rep);
			
			c.getAutor().SumarRepTotalesPropias();
		}
		
		return player;
	}
	
	/**
	 * Funcion que detiene la reproducion de una cancion.
	 * @param player Gestor MP3 que reproduce la cancion.
	 */
	public void pausarCancion(Mp3Player player) {
		if(player == null) {
			return;
		}
		player.stop();
	}
	
	/**
	 * Funcion que realiza la busqueda de canciones en la aplicacion con filtro por nombre.
	 * Devuelve una lista de las canciones resultada de la busqueda.
	 * @param name Nombre de la cancion.
	 * @return lista de canciones encontrada en la busqueda.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Cancion> buscarCancionesNombre(String name) throws MusicaNoEncontrada {
		ArrayList<Cancion> listaCan = new ArrayList<Cancion>();
		
		for(Cancion c: this.getListaCanciones()) {
			if(c.getName().equals(name) && c.getEstado()!=EstadosCancion.BLOQUEADA  && c.getEstado()!=EstadosCancion.NO_VALIDADA) {
				listaCan.add(c);
			}
		}
		
		if (listaCan.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaCan;
	}
	
	/**
	 * Funcion que realiza la busqueda de canciones en la aplicacion con filtro por autor.
	 * Devuelve una lista de las canciones resultada de la busqueda.
	 * @param name Nombre del autor.
	 * @return lista de canciones encontrada en la busqueda.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Cancion> buscarCancionesAutor(String name) throws MusicaNoEncontrada {
		ArrayList<Cancion> listaCan = new ArrayList<Cancion>();
		
		for(Cancion c: this.getListaCanciones()) {
			if(c.getAutor().getNickname().equals(name) && c.getEstado()!=EstadosCancion.BLOQUEADA && c.getEstado()!=EstadosCancion.NO_VALIDADA) {
				listaCan.add(c);
			}
		}
		
		if (listaCan.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaCan;
	}
	
	/**
	 * Funcion que realiza la busqueda de canciones en la aplicacion con filtro por tus propias canciones.
	 * Devuelve una lista de las canciones resultada de la busqueda.
	 * @param name Nombre de la cancion.
	 * @return lista de canciones encontrada en la busqueda.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Cancion> buscarCancionesMisCanciones(String name) throws UsuarioInvalido, MusicaNoEncontrada {
		ArrayList<Cancion> listaCan = new ArrayList<Cancion>();
		Autor aux = null;
		
		if(this.getUsuarioConectado().getNombre().equals("admin") || this.getUsuarioConectado().getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
		
		aux = (Autor)this.getUsuarioConectado();
		
		for(Cancion c: aux.getListacancion()) {
			if(c.getName().equals(name)  && c.getEstado()!=EstadosCancion.BLOQUEADA  && c.getEstado()!=EstadosCancion.NO_VALIDADA) { 
				listaCan.add(c);
			}
		}
		
		if (listaCan.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaCan;
	}
	
	/**
	 * Funcion que realiza la busqueda de albumes en la aplicacion por nombre.
	 * Devuelve una lista de albumes resultada de la busqueda.
	 * @param name Nombre del album.
	 * @return listaAlb Lista de albumes encontrados en la busqueda.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Album> buscarAlbumesNombre(String name) throws MusicaNoEncontrada {
		ArrayList<Album> listaAlb = new ArrayList<Album>();
		
		for(Listas l: this.getListaListas()) {
			if(l.getNameLista().equals(name) && l.isAlbum() == true) {
				listaAlb.add((Album)l);
			}
		}
		
		if (listaAlb.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaAlb;
	}
	
	/**
	 * Funcion que realiza la busqueda de albumes en la aplicacion por autor.
	 * Devuelve una lista de albumes resultada de la busqueda.
	 * @param name Nombre del autor.
	 * @return listaAlb Lista de albumes encontrados en la busqueda.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Album> buscarAlbumesAutor(String name) throws MusicaNoEncontrada {
		ArrayList<Album> listaAlb = new ArrayList<Album>();
		
		for(Listas l: this.getListaListas()) {
			if(l.getAutor().getNickname().equals(name) && l.isAlbum() == true) {
				listaAlb.add((Album)l);
			}
		}
		
		if (listaAlb.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaAlb;
	}
	
	/**
	 * Funcion que realiza la busqueda de albumes entre tus albumes.
	 * Devuelve una lista de albumes resultada de la busqueda.
	 * @param name Nombre del album.
	 * @return listaAlb Lista de albumes encontrados en la busqueda.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<Album> buscarAlbumesMisAlbumes(String name) throws UsuarioInvalido, MusicaNoEncontrada {
		ArrayList<Album> listaAlb = new ArrayList<Album>();
		
		if(this.getUsuarioConectado().getNombre().equals("admin") || this.getUsuarioConectado().getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
		
		for(Listas l: this.getListaListas()) {
			if(l.getNameLista().equals(name) && l.isAlbum() == true) {
				listaAlb.add((Album)l);
			}
		}
		
		if (listaAlb.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaAlb;
	}
	
	/**
	 * Funcion que realiza la busqueda de las listas de reproduccion entre las propias de un usuario.
	 * Devuelve una lista de listas de reproduccion resultada de la busqueda.
	 * @param name Nombre de la lista.
	 * @return listaRep Lista de listas encontradas en la busqueda.
	 * @throws UsuarioInvalido Excepcion de UsuarioInvalido.
	 * @throws MusicaNoEncontrada Excepcion de MusicaNoEncontrada.
	 */
	public ArrayList<ListaReproduccion> buscarListasRepMisListasRep(String name) throws UsuarioInvalido, MusicaNoEncontrada {
		ArrayList<ListaReproduccion> listaRep = new ArrayList<ListaReproduccion>();
		
		if(this.getUsuarioConectado().getNombre().equals("admin") || this.getUsuarioConectado().getNombre().equals("admin")) {
			throw new UsuarioInvalido(this.getUsuarioConectado());
		}
		
		for(Listas l: this.getListaListas()) {
			if(l.getNameLista().equals(name) && l.isLista() == true) {
				listaRep.add((ListaReproduccion)l);
			}
		}
		
		if (listaRep.size()==0) {
			throw new MusicaNoEncontrada();
		}
		
		return listaRep;
	}
	
	/**
	 * Funcion que devuelve una lista con las notificaciones recibidas de un usuario o del administrador.
	 * @return listaNotif Lista de notificaciones.
	 */
	public ArrayList<Notificaciones> notificar() {

		return this.getUsuarioConectado().getNotificaciones();
	}
	
	/**
	 * Funcion que guarda todos los datos del sistema en el fichero "/txt/mdftunes.txt".
	 * @throws IOException Excepcion de IOException. 
	 * @throws FileNotFoundException Excepcion de FileNotFoundException. 
	 */
	public void guardarDatos() throws IOException, FileNotFoundException {
		ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("txt" + File.separator + "mdftunes.txt"));
		
		o.writeObject(this.getListaUsuarios());
		o.writeObject(this.getListaCanciones());
		o.writeObject(this.getListaListas());
		o.writeObject(this.getListaRep());
		o.writeObject(this.getListaNotif());
		o.writeObject(this.getAdministrador());
		o.writeObject(this.getAnonimo());
		o.writeObject(this.getLimiteRepAnonimo());
		o.writeObject(this.getLimiteRepNormal());
		o.writeObject(this.getCostePremium());
		o.writeObject(this.getTopeSerPremium());
		
		o.close();
	}
	
	/**
	 * Funcion que lee todos los datos guardados en el fichero "/txt/mdftunes.txt" y los carga en el sistema.
	 * @throws IOException Excepcion de IOException. 
	 * @throws FileNotFoundException Excepcion de FileNotFoundException. 
	 * @throws ClassNotFoundException Excepcion de ClassNotFoundException.
	 */
	@SuppressWarnings("unchecked")
	public void cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream o = new ObjectInputStream(new FileInputStream("txt" + File.separator + "mdftunes.txt"));
		
		this.listaUsuarios = (List<Autor>) o.readObject();
		this.listaCanciones = (List<Cancion>) o.readObject();
		this.listaListas = (List<Listas>) o.readObject();
		this.listaRep = (List<Reproduccion>) o.readObject();
		this.listaNotif = (List<Notificaciones>) o.readObject();
		this.administrador = (Usuario) o.readObject();
		this.anonimo = (Usuario) o.readObject();
		this.limiteRepAnonimo = (int) o.readObject();
		this.limiteRepNormal = (int) o.readObject();
		this.costePremium = (double) o.readObject();
		this.topeSerPremium = (int) o.readObject();
		
		o.close();
	}

	/**
	 * Funcion que transforma una lista de canciones en una tabla de strings para el controlador.
	 * @param listaCanciones Lista de canciones para transformar.
	 * @return tablaCanciones Tabla con strings de las canciones.
	 */
	public String[][] ListaCancionesAString(ArrayList<Cancion> listaCanciones){
		String[][] tablaCanciones = new String[listaCanciones.size()][2];
		int i=0;
		
		if(listaCanciones.size()==0) {
			return tablaCanciones;
		}
		
		for(Cancion c: listaCanciones) {
			tablaCanciones[i][0] = c.getAutor().getNickname();
			tablaCanciones[i][1] = c.getName();
			i++;
		}
		
		return tablaCanciones;
	}
	
	/**
	 * Funcion que transforma una lista de notificaciones en una tabla de strings para el controlador.
	 * @param listaNotif Lista de notificaciones para transformar.
	 * @return tablaNotif Tabla con strings de las notificaciones.
	 */
	public String[][] ListaNotificacionesAString(ArrayList<Notificaciones> listaNotif){
		String[][] tablaNotif = new String[listaNotif.size()][3];
		int i=0;
		
		if(listaNotif.size()==0) {
			return tablaNotif;
		}
		
		for(Notificaciones n: listaNotif) {
			tablaNotif[i][0] = String.valueOf(n.getId());
			tablaNotif[i][1] = n.getUsuario().getNombre();
			tablaNotif[i][2] = n.getMensaje();
			i++;
		}
		
		return tablaNotif;
	}
	
	/**
	 * Funcion que transforma una lista de canciones en una tabla de strings para el controlador del administrador.
	 * @param listaCanciones Lista de canciones para transformar.
	 * @return tablaCanciones Tabla con strings de las canciones.
	 */
	public String[][] ListaCancionesAStringAdmin(ArrayList<Cancion> listaCanciones){
		String[][] tablaCanciones = new String[listaCanciones.size()][4];
		int i=0;
		
		if(listaCanciones.size()==0) {
			return tablaCanciones;
		}
		
		for(Cancion c: listaCanciones) {
			tablaCanciones[i][0] = String.valueOf(c.getId());
			tablaCanciones[i][1] = c.getAutor().getNickname();
			tablaCanciones[i][2] = c.getName();
			tablaCanciones[i][3] = String.valueOf(c.getEstado());
			i++;
		}
		
		return tablaCanciones;
	}
	
	/**
	 * Funcion que transforma una lista de autores en una tabla de strings para el controlador del administrador.
	 * @param listaAutores Lista de autores para transformar.
	 * @return tablaAutores Tabla con strings de los autores.
	 */
	public String[][] ListaAutoresAStringAdmin(ArrayList<Autor> listaAutores){
		String[][] tablaAutores = new String[listaAutores.size()][3];
		int i=0;
		
		if(listaCanciones.size()==0) {
			return tablaAutores;
		}
		
		for(Autor a: listaAutores) {
			tablaAutores[i][0] = a.getNombre();
			tablaAutores[i][1] = a.getNickname();
			if(a.isBloqueado()) {
				tablaAutores[i][2] = "BLOQUEADO";
			}
			else {
				tablaAutores[i][2] = "NORMAL";
			}
			i++;
		}
		
		return tablaAutores;
	}
	
	/**
	 * Funcion que transforma una lista de albumes en una tabla de strings para el controlador.
	 * @param listaAlbum Lista de albumes para transformar.
	 * @return tablaalbum Tabla con strings de los albumes.
	 */
	public String[][] ListaAlbumAString(ArrayList<Album> listaAlbum){
		String[][] tablaalbum = new String[listaAlbum.size()][2];
		int i=0, j=0;
		
		if(listaAlbum.size()==0) {
			return tablaalbum;
		}
		
		for(Album a: listaAlbum) {
			tablaalbum[i][0] = a.getAutor().getNickname();
			tablaalbum[i][1] = a.getNameLista();
			i++;
		}
		
		return tablaalbum;
	}
	
	/**
	 * Funcion que transforma una lista de autores en una tabla de strings para el controlador.
	 * @param listaUsuarios Lista de usuarios para transformar.
	 * @return tablaUser Tabla con strings de los usuarios.
	 */
	public String[][] ListaAutorAString(ArrayList<Autor> listaAutor){
		String[][] tablaUser = new String[listaAutor.size()][1];
		int i=0, j=0;
		
		if(listaAutor.size()==0) {
			return tablaUser;
		}
		
		for(Autor a: listaAutor) {
			tablaUser[i][0] = a.getNickname();
			i++;
		}
		
		return tablaUser;
	}
	
	/**
	 * Funcion que devuelve una lista de usuarios
	 * @return listaAutor Lista de autores
	 */
	public ArrayList<Autor> seguidores(){
		if (this.getUsuarioConectado().getNombre().equals("anonimo") || this.getUsuarioConectado().getNombre().equals("admin")) {
			return null;
		}
		Autor a = (Autor) this.usuarioConectado;
		return (ArrayList<Autor>) a.getListaseguidos();
	}
	
	/**
	 * Funcion que hace que un autor siga a otro.
	 * @param name Nombre del autor a seguir.
	 * @return 
	 */
	public boolean seguirA(String name) {
		if (this.getUsuarioConectado().getNombre().equals("anonimo") || this.getUsuarioConectado().getNombre().equals("admin")) {
				return false;
			}
		
		Autor a = (Autor) this.usuarioConectado;
		Autor aux2;
		
        for(Autor z2: this.getListaUsuarios()) {
            if(z2.getNickname().equals(name)) {
                aux2 = z2;
                a.SeguirAutor(aux2);
                return true;
            }
        } 
		
		return false;
	}
	
	/**
	 * Funcion que transforma una lista de canciones en una tabla de strings para el controlador.
	 * @param listaCanciones Lista de Canciones para transformar.
	 * @return tablaCancion Tabla con strings de las canciones.
	 */
	public String[][] ListaCanciones(List<Cancion> listaCanciones){
		String[][] tablaCancion = new String[listaCanciones.size()][3];
		int i=0;
		
		if(listaCanciones.size()==0) {
			return tablaCancion;
		}
		
		for(Cancion a: listaCanciones) {
			tablaCancion[i][0] = a.getName();
			tablaCancion[i][1] = String.valueOf(a.getEstado());
			tablaCancion[i][2] = String.valueOf(a.getNReproducciones());
			i++;
		}
		
		return tablaCancion;
	}
	
	/**
	 * Funcion que transforma una lista de Albumes en una tabla de strings para el controlador.
	 * @param listaAlbumes Lista de Albumes para transformar.
	 * @return tablaAlbum Tabla con strings de los Albumes.
	 */
	public String[][] ListaAlbumes(List<Album> listaAlbumes){
		String[][] tablaAlbum = new String[listaAlbumes.size()][2];
		int i=0;
		
		if(listaAlbumes.size()==0) {
			return tablaAlbum;
		}
		
		for(Album a: listaAlbumes) {
			tablaAlbum[i][0] = a.getNameLista();
			tablaAlbum[i][1] = String.valueOf(a.getDuracionLista());
			i++;
		}
		
		return tablaAlbum;
	}
	
	/**
	 * Funcion que transforma una lista en una tabla de strings para el controlador.
	 * @param listaListas Lista de Listas de Reproduccion para transformar.
	 * @return tablaListas Tabla con strings de las Listas.
	 */
	public String[][] ListaListas(List<Listas> listaListas){
		String[][] tablaLista = new String[listaListas.size()][2];
		int i=0;
		
		if(listaListas.size()==0) {
			return tablaLista;
		}
		
		for(Listas a: listaListas) {
			tablaLista[i][0] = a.getNameLista();
			tablaLista[i][1] = String.valueOf(a.getDuracionLista());
			i++;
		}
		
		return tablaLista;
	}
	
	@Override
	public String toString() {
		return "Sistema [limiteRepAnonimo=" + limiteRepAnonimo + ", limiteRepNormal=" + limiteRepNormal
				+ ", topeSerPremium=" + topeSerPremium + ", costePremium=" + costePremium + ", administrador="
				+ administrador + ", anonimo=" + anonimo + ", usuarioConectado=" + usuarioConectado + ", listaUsuarios="
				+ listaUsuarios + ", listaCanciones=" + listaCanciones + ", listaListas=" + listaListas
				+ ", listaNotif=" + listaNotif + ", listaRep=" + listaRep + "]";
	}
}
