package Usuarios;
   
import java.io.Serializable;

/**
 * Autor.java
 * Clase correspondiente a un usuario de tipo autor (registrado).
 * @author Daniel Mateo
 * @author Franccy del Piero Sambrano
 * @author Miguel Manzano
 */

import java.time.LocalDate;
import java.util.*;
  
import Musica.*;
  
   
@SuppressWarnings("serial")
public class Autor extends Usuario implements Serializable{
    private LocalDate fechaDeNacimiento;
    private String nickname;
    private boolean premium;
    private boolean bloqueado;
    private List <Autor> listaseguidos;
    private List <Autor> listaseguidores;
    private List<Cancion> listacancion;
    private LocalDate fechaBloqueado;
    private ArrayList<Listas> listaListas;
    private int repTotalesPropias;
    private LocalDate fechainicio;
 
      
    /**
     * Constructor de un usuario registrado
     * @param nombre nombre del usuario registrado
     * @param contrasenia contraseña del usuario registrado
     * @param repTotalesExternas reproducciones totales externas
     * @param fechaDeNacimiento fecha de nacimiento del usuario
     * @param nickname nickname del usuario
     * @param premium parametro que verifica si el usuario está registrado
     */
    public Autor(String nombre, String contrasenia, int repTotalesExternas, LocalDate fechaDeNacimiento, String nickname, boolean premium) {
        super(nombre,contrasenia,repTotalesExternas);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nickname = nickname;
        this.premium = premium;
        this.bloqueado = false;
        this.listaseguidos = new ArrayList<Autor>();
        this.listaseguidores = new ArrayList<Autor>();
        this.listacancion = new ArrayList<Cancion>();
        this.listaListas = new ArrayList<Listas>();
        this.fechaBloqueado = null;
        this.repTotalesPropias = 0;
        this.fechainicio = null;
    }
       
    /**
     * Metodo que devuelve la fecha de nacimiento del usuario
     * @return fechaDeNacimiento fecha de nacimiento del usuario
     */
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
       
    /**
     * Metodo que obtiene el nickname del usuario
     * @return nickname nombre del usuario en la aplicacion
     */
    public String getNickname() {
        return nickname;
    }
       
    /**
     * Metodo que obtiene si el usuario es premium
     * @return premium
     */
    public boolean isPremium() {
        return premium;
    }
       
    /**
     * Metodo donde obtenemos el usuario el cambio a premium
     * @param premium Valor de premium.
     */
    public void ConvertirsePremium(Boolean premium){
            this.premium = premium;
    }
     /**
      * Funcion que comprueba si el autor esta bloqueado
      * @return bloqueado devuelve el valor de autor
      */
    public boolean isBloqueado() {
        return bloqueado;
    }
  /**
   * Cambia el estado del usuario registrado
   * @param bloqueado cambio de estado del usuario
   */
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    /**
     * Obtiene la lista de seguidos de un usuario registrado
     * @return listaseguidos lista de seguidos de un autor
     */
    public List<Autor> getListaseguidos() {
        return listaseguidos;
    }
    /**
     * Obtiene la lista de seguidores
     * @return listaseguidores lista de seguidores
     */
    public List<Autor> getListaseguidores() {
        return listaseguidores;
    }
    /**
     * Obtiene la lista de la cancion
     * @return listacancion lista de cancion de un usuario registrado
     */
    public List<Cancion> getListacancion() {
        return listacancion;
    }
    /**
     * Obtiene la lista de reproduccion de un usuario
     * @return listaListas lista de reproduccion de un usuario
     */
    public List<Listas> getListaListas() {
        return listaListas;
    }
   
    /**
     * Funcion que obtiene la fecha cuando se convirtio en premium el autor
     * @return fechainicio fecha de inicio del autor premium
     */
    public LocalDate getFechainicio() {
        return fechainicio;
    }
     
    /**
     * Cambia el estado de la fecha de inicio de un usuario premium
     * @param fechainicio fecha de inicio premium a cambiar
     */
    public void setFechainicio(LocalDate fechainicio) {
        this.fechainicio = fechainicio;
    }
        
    /**
     * Funcionalidad que permite asignar a un usuario seguir a otro
     * @param autor autor a seguir
     * @return true si se ha realizado correctamente, en caso contrario, false.
     */
    public boolean SeguirAutor(Autor autor) {
        if(listaseguidos.contains(autor)) {
            return false;
        }
        this.listaseguidos.add(autor);
        autor.getListaseguidores().add(this);
        return true;
    }
       
    /**
     * Funcionalidad que permite borrar a un usario de seguir a un autor
     * @param autor autor que desea dejar de seguir
     * @return  true si se ha realizado correctamente, en caso contrario, false.
     */
    public boolean DejarDeSeguirAutor(Autor autor) {
        if(listaseguidos.contains(autor) == false) {            
            return false;
        }
        this.listaseguidos.remove(autor);
        autor.getListaseguidores().remove(this);
        return true;
    }
   
    /**
     * Funcion que mira si el usuario es mayor de edad
     * @param fecha fecha a comprobar
     * @return true si es mayor, en caso contario false
     */
    public boolean mayorEdad(LocalDate fecha) {
        LocalDate fecha1 = this.getFechaDeNacimiento();
           
        if((fecha.getYear() - fecha1.getYear()) > 18) {
        	return true;
        }
        else if((fecha.getYear() - fecha1.getYear()) == 18) {
        	if(fecha.getMonthValue() >= fecha1.getMonthValue()) {
        		if(fecha.getDayOfMonth() >= fecha1.getDayOfMonth()) {
                	return true;
        		}
        	}
        	return false;
        }
        else {
            return false;
        }
    }
       
    /**
     * Obtiene la fecha de bloqueado de un usuario
     * @return fechabloqueado fecha del usuario bloqueado
     */
    public LocalDate getFechaBloqueado() {
        return fechaBloqueado;
    }
  
    /**
     * Cambia la fecha del usuario bloqueado 
     * @param fechaBloqueado fecha del usuario bloqueado a cambiar
     */
    public void setFechaBloqueado(LocalDate fechaBloqueado) {
        this.fechaBloqueado = fechaBloqueado;
    }
 
    /**
     * Funcionalidad que suma las reproducciones totales de un autor
     */
    public void SumarRepTotalesPropias() {
        int reprototal=0;
        for(Cancion c: this.getListacancion())
        reprototal = reprototal +  c.getNReproducciones();
        this.repTotalesPropias = reprototal;
    }
  
	/**
	 * Devuelve la informacion correspondiente a un autor.
	 * @return informacion Info de un autor.
	 */
    @Override
    public String toString() {
        return "Autor [fechaDeNacimiento=" + fechaDeNacimiento + ", nickname=" + nickname + ", premium=" + premium
                + " - " + this.getFechainicio() + " -, Rep: " + repTotalesPropias +  ", bloqueado: " +  this.isBloqueado() + " listacancion=" + listacancion + "] Notifs: " + this.getNotificaciones();
    }
     
}
   