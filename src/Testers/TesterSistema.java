package Testers;
   
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
 
import FechaSimulada.FechaSimulada;
import Musica.Cancion;
import Musica.EstadosCancion;
import Musica.ListaReproduccion;
import Musica.Album;
 
import Sistema.*;
import Usuarios.*;
import es.uam.eps.padsof.telecard.FailedInternetConnectionException;
import es.uam.eps.padsof.telecard.InvalidCardNumberException;
import es.uam.eps.padsof.telecard.OrderRejectedException;
import pads.musicPlayer.Mp3Player;
import pads.musicPlayer.exceptions.Mp3PlayerException;
   
public class TesterSistema {
   
    public static void main(String[] args) throws FileNotFoundException, Mp3PlayerException, InvalidCardNumberException, FailedInternetConnectionException, OrderRejectedException, InterruptedException {
   
   
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //FECHA SIMULADA
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
        LocalDate fecha1 = FechaSimulada.fijarFecha(30, 3, 2019);
        LocalDate fecha2 = FechaSimulada.fijarFecha(1, 1, 2019);
        LocalDate fecha3 = FechaSimulada.fijarFecha(29, 3, 2019);
          
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CREACION DE LOS USUARIOS
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
        Usuario anonimo = new Usuario("anonimo", "anonimo", 0);
        Usuario administrador = new Usuario("admin", "admin", 0);
        Usuario nuevo = null;
           
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CREACION DE LOS AUTORES
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
        Autor autor = new Autor("Miguel","ManzanoMar", 0, fecha1, "Capitan", false);
        Autor autor2 = new Autor("Mateo","MateoMor", 0, fecha1, "mateo", false);
        Autor autor3 = new Autor("Franccy","SambranoGonz", 0, fecha1, "Capitan", false);
        Autor autor4 = new Autor("Franccy", "SambranoGonz", 0, fecha1, "franccy", false);
        Autor autorx = null;
        Autor aux = null;
        Autor aux2 = null;
        Autor aux3 = null;
        Autor premium = null;  
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CREACION DE LAS CANCIONES
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
        Cancion b = new Cancion(0,"chicle3", 01, EstadosCancion.VALIDADA, "chicle3.mp3", autor);
        Cancion caux = null;
        Cancion fire = new Cancion(0, "np", 02, EstadosCancion.NO_VALIDADA, "np.mp3", autor);
        Cancion caux2 = null;
        Cancion caux3 = null;
        Cancion hawaii = new Cancion(0, "Hawaii5.0", 03, EstadosCancion.VALIDADA, "Hawaii.mp3", autor);
        Cancion pirates = new Cancion(0, "Pirates", 03, EstadosCancion.VALIDADA, "pirates.mp3", autor);
   
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CREACION DEL SISTEMA
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
        Sistema s = new Sistema(0, 30, 15, 27, administrador, anonimo);
                   
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CREACION DE AUXILIARES PARA FUNCIONES DE BUSQUEDA
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////  
         
        ArrayList<Album> listamisalbumes = new ArrayList<Album>();
        ArrayList<ListaReproduccion> listamislistasRep = new ArrayList<ListaReproduccion>();
        ArrayList<Cancion> listaCancionesNombre = new ArrayList<Cancion>();
        ArrayList<Cancion> listaCancionesAutor = new ArrayList<Cancion>();
        ArrayList<Cancion> listaCancionMisCanciones = new ArrayList<Cancion>();  
        ArrayList<Album> listaAlbumesNombre = new ArrayList<Album>();  
           
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //INICIANDO TESTER
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
        System.out.println("Se va a intentar acceder al sistema como anonimo:");
           
           
        //se intentara acceder al sistema como anonimo
           
        if(s.accederAnonimo() == false) {
            System.out.println("Error al acceder como anonimo");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el usuario anonimo  " + nuevo);
            System.out.println(" ");
        }
                   
        //el anonimo saldra del sistema
           
        System.out.println("Se va a intentar desconectarse del sistema como anonimo");
           
           
        if(s.salirAnonimo() == false) {
            System.out.println("Error al intentar desconectarse como anonimo");
            System.out.println(" ");
               
        }else {
            System.out.println("Anonimo desconectado");
            System.out.println(" ");
        }
                   
                   
           
        //Se intentara realizar el login del autor1
        //Esto claramente dara error, ya que el autor1 esta intentando hacer un login sin haberse registrado antes
                   
        System.out.println("Autor1 va a realizar el login: ");
           
           
        if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario Conectado: " + nuevo);
            System.out.println(" ");
        }
                   
           
                   
        //Registramos al autor1 en la aplicacion
           
        System.out.println("Autor1 va a registrarse:");
           
        if(s.registrarse(autor.getNombre(), autor.getContrasenia(), autor.getFechaDeNacimiento(), autor.getNickname()) == false) {
            System.out.println("Error al registarse");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados");
               
            for(Autor a: s.getListaUsuarios()) {
            System.out.println("Informacion de usuario registrado: " + a);
            System.out.println(" ");
            }
                       
        }
                   
                           
        //ahora vamos a probar a volver a hacer login con el autor1 ya registrado
           
        System.out.println("Autor1 va a realizar el login: ");
           
        if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
                   
           
        //el autor1 saldra del sistema
           
        System.out.println("Autor1 va a realizar el logout: ");
           
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor1");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor1 desconectado");
            System.out.println(" ");
        }
                   
               
        //Registramos otro autor
           
        System.out.println("Registramos otro autor, Autor2 va a registrarse:");
           
        if(s.registrarse(autor2.getNombre(), autor2.getContrasenia(), autor2.getFechaDeNacimiento(), autor2.getNickname()) == false) {
            System.out.println("Error al registarse");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados");
               
            for(Autor a: s.getListaUsuarios()) {
                System.out.println("Informacion de usuario registrado: " + a);
                }
            System.out.println(" ");                
        }
                   
                   
        //ahora vamos a probar a volver a hacer login con el nuevo autor ya registrado
           
        System.out.println("Autor2 va a realizar el login: ");
           
        if(s.login(autor2.getNickname(), autor2.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
           
           
        //el autor2 saldra del sistema
           
        System.out.println("Autor2 va a realizar el logout: ");
           
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor2");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor2 desconectado");
            System.out.println(" ");
        }
                           
        //vamos a probar a registrar el autor3, que no se deberia poder registrar, ya que ya existe un usuario con su nickname
           
        System.out.println("Autor3 va a intentar registrarse en el sistema: ");
           
        if(s.registrarse(autor3.getNombre(), autor3.getContrasenia(), autor3.getFechaDeNacimiento(), autor3.getNickname()) == false) {
            System.out.println("Error al registrarse");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados");
               
            for(Autor a: s.getListaUsuarios()) {
                System.out.println("Informacion de usuario registrado: " + a);
                }
            System.out.println(" ");
        }
                   
        //Autor2 realizara el login
           
        System.out.println("Autor2 va a realizar el login: ");
                   
        if(s.login(autor2.getNickname(), autor2.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
                   
        //Guardaremos el autor actual en un auxiliar para futuros usos
           
        for(Autor au: s.getListaUsuarios()) {
            if(au.getNickname() == autor2.getNickname()) {
                aux = au;
            }
        }
           
        //Autor2 va a crear un nuevo Album
           
        System.out.println("Autor2 va a crear un nuevo album:");
           
        if(s.crearAlbum("MateoAlbum") == false) {
            System.out.println("Error al crear el album");
            System.out.println(" ");
        }
        else {
            System.out.println("Listas de sistemas: " + s.getListaListas());        
            System.out.println("Listas del autor: " + aux.getListaListas());
            System.out.println(" ");
        }
          
        //Tras esto vamos a comprobar la funcion de busqueda de un album en los albumes de un usuario
        System.out.println(" Busqueda de un album en los albumes de un usuario ");
         
        autorx = (Autor)s.getUsuarioConectado();
        System.out.println("Estos son los albumes del usuario conectado: " + autorx.getListaListas());
         
        listamisalbumes = s.buscarAlbumesMisAlbumes("MateoAlbum");
             
        System.out.println("Album recuperado: " + listamisalbumes);
        System.out.println(" ");
         
        //A su vez, comprobaremos tambien la funcion de busqueda de un album por nombre
         
        System.out.println(" Busqueda de un album por nombre: ");
         
         
        listaAlbumesNombre = s. buscarAlbumesNombre("MateoAlbum");
             
        System.out.println("Album recuperado: " + listaAlbumesNombre);
        System.out.println(" ");
         
   
        //Autor2 va a crear una nueva Lista de Reproduccion
           
        System.out.println("Autor2 va a crear una nueva lista de Reproduccion:");
           
        if(s.crearListaRep("MateoListaRepr") == false) {
            System.out.println("Error al crear la lista de Reproduccion");
            System.out.println(" ");
        }
        else {
            System.out.println("Listas de sistemas: " + s.getListaListas());        
            System.out.println("Listas del autor: " + aux.getListaListas());
            System.out.println(" ");
        }
           
        //Tras esto vamos a comprobar la funcion de busqueda de una lista en las listas de un usuario
         
        System.out.println(" Busqueda de una lista de reproduccion en las listas de un usuario ");
         
        autorx = (Autor)s.getUsuarioConectado();
        System.out.println("Estos son las listas y albumes del usuario conectado: " + autorx.getListaListas());
         
        listamislistasRep = s.buscarListasRepMisListasRep("MateoListaRepr");
             
        System.out.println("Lista recuperada: " + listamislistasRep);
        System.out.println(" ");
         
        //lista de usuarios actual
         
        System.out.println("Lista de usuarios registrados antes de cancelar registro");
           
        for(Autor a: s.getListaUsuarios()) {
            System.out.println("Informacion de usuario registrado: " + a);
        }
           
        System.out.println(" ");
           
        //Ahora vamos a probar a cancelar el registro de un usuario ya registrado segun el tester deberia de borrarse el registro de autor 2 de sistema
           
        System.out.println("Se va a realizar la cancelacion del registro de Autor2");
           
        if(s.cancelarRegistro() == false) {
            System.out.println("Error al cancelar el registro");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados tras cancelar el registro del usuario actual");
               
            for(Autor a: s.getListaUsuarios()) {
                System.out.println("Informacion de usuario registrado: " + a);
                }
                System.out.println(" ");
        }
                   
        //Ahora usuario1 va a realizar el login 
        System.out.println(" ");
        System.out.println("Autor1 va a realizar el login: ");
           
        if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
           
        //Tras esto, probaremos a modificar la configuracion del sistema, es decir informacion que es constante como el precio para convertirse en premium, etc.
           
        System.out.println("Los valores de configuracion actuales son: " + s.getLimiteRepAnonimo() + ", " + s.getLimiteRepNormal() + ", " + s.getTopeSerPremium() + ", " + s.getCostePremium());
        System.out.println(" ");
                   
        //En la primera prueba, deberia dar error ya que vamos a intentarlo siendo un usuario cualquiera y solo el administrador puede cambiar la configuracion
           
        if(s.cambiarConfiguracion(14, 100, 50, 30) == false) {
            System.out.println("Error al intentar cambiar la configuracion");
            System.out.println(" ");
        }
        else {
            System.out.println(" ");
            System.out.println("Los nuevos valores de configuracion son: " + s.getLimiteRepAnonimo() + ", " + s.getLimiteRepNormal() + ", " + s.getTopeSerPremium() + ", " + s.getCostePremium());
            System.out.println(" ");
        }
                   
        //Como ha dado error, debemos hacer un logout del usuario actual y hacer que sea el admin quien entre en el sistema para poder acceder al sistema
                   
        System.out.println("Autor 1 va a realizar el logout: ");
           
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor desconectado");
            System.out.println(" ");
        }
                   
                   
        //Ahora realizaremos la conexion del administrador para poder cambiar la configuracion
                   
        System.out.println("Se va a intentar acceder al sistema como administrador");
                   
        if(s.accederAdministrador("admin") == false) {
            System.out.println("Error al acceder como administrador");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el administrador  " + nuevo);
            System.out.println(" ");
        }
                   
        //Ahora si cambiaremos la configuracion
                   
        System.out.println("El administrador ahora si va a proceder a cambiar los valores de la configuracion");
                   
        if(s.cambiarConfiguracion(14, 100, 50, 30) == false) {
            System.out.println("Error al intentar cambiar la configuracion");
            System.out.println(" ");
        }
        else {
            System.out.println("Los nuevos valores de configuracion son: " + s.getLimiteRepAnonimo() + ", " + s.getLimiteRepNormal() + ", " + s.getTopeSerPremium() + ", " + s.getCostePremium());
            System.out.println(" ");
        }
                   
        //Tras esto, administrador saldra del sistema
                   
        System.out.println("Administrador se desconectara del sistema: ");
           
        if(s.salirAdministrador() == false) {
            System.out.println("Error al intentar desconectarse como administrador");
            System.out.println(" ");
        }
        else {
            System.out.println("administrador desconectado");
            System.out.println(" ");
        }
                   
                       
        //Ahora usuario1 va a realizar el login 
           
        System.out.println("Autor1 va a realizar el login: ");
                   
        if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
                   
        //subimos la cancion
                   
        System.out.println("Autor1 va a subir la cancion: ");
           
        if(s.subirCancion(b.getName(), "chicle3.mp3") == false){
            System.out.println("Error al subir la cancion");
            System.out.println(" ");
        }else {
            System.out.println("Cancion subida");
            System.out.println("Lista canciones del sistema" + s.getListaCanciones());
               
            for(Autor au: s.getListaUsuarios()) {
                if(au.getNickname() == autor.getNickname()) {
                    aux = au;
                }
            }
               
            System.out.println("Lista de canciones del autor" + aux.getListacancion());
   
            System.out.println(" ");
        }
         
        //vamos a comprobar antes, la funcion que devuelve la cancion de la lista de canciones de un usuario
         
        System.out.println("Vamos a conseguir la cancion de la lista de canciones del autor: ");
         
        listaCancionMisCanciones = s.buscarCancionesMisCanciones("chicle3");
         
        System.out.println("Cancion encontrada: " + listaCancionMisCanciones);
        System.out.println(" ");
         
        //Autor1 realizara el logout para poder conectarnos como administrador
        System.out.println("Autor1 va a realizar el logout: ");
           
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor1");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor1 desconectado");
            System.out.println(" ");
        }
         
         
         
        //Una vez subida la cancion, vamos a validarla
          
        //Para esto, se conectara el administrador
          
        System.out.println("El administrador va a conectarse al sistema: ");
          
        if(s.accederAdministrador("admin") == false) {
            System.out.println("Error al acceder como administrador");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el administrador  " + nuevo);
            System.out.println(" ");
        }
          
          
          
        //Ahora si, validamos la cancion
        System.out.println("Se va a validar la cancion: ");
          
        for(Cancion c: s.getListaCanciones()) {
            if(c.getName() == b.getName()) {
                caux = c;
            }
        }
          
        System.out.println("Informacion de la cancion antes de validarla: " + caux);
          
        try {
            s.validarCancion(s.getListaCanciones().get(0));
        } catch (Mp3PlayerException e) {
            s.getListaCanciones().get(0).modificarEstado(EstadosCancion.NO_VALIDADA);
        }
         
        System.out.println("Informacion de la cancion despues de validarla: " + caux);
        System.out.println(" ");
          
          
        //Tras esto, administrador saldra del sistema
          
        System.out.println("Administrador se desconectara del sistema: ");
           
        if(s.salirAdministrador() == false) {
            System.out.println("Error al intentar desconectarse como administrador");
            System.out.println(" ");
        }
        else {
            System.out.println("administrador desconectado");
            System.out.println(" ");
        }
          
        //Volvemos a registrar al autor2
           
        System.out.println("Registramos otro autor, Autor2 va a registrarse:");
           
        if(s.registrarse(autor2.getNombre(), autor2.getContrasenia(), autor2.getFechaDeNacimiento(), autor2.getNickname()) == false) {
            System.out.println("Error al registarse");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados");
               
            for(Autor a: s.getListaUsuarios()) {
                System.out.println("Informacion de usuario registrado: " + a);
                }
            System.out.println(" ");                
        }
           
        //Ahora usuario2 va a realizar el login 
           
        System.out.println("Autor2 va a realizar el login: ");
                           
        if(s.login(autor2.getNickname(), autor2.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
                   
        //Autor2 va a probar a buscar la cancion que ha subido el autor1 para asi comprobar el metodo buscar canciones por nombre
         
        System.out.println(" Busqueda de una cancion por nombre ");
         
         
        System.out.println("Estos son las canciones del sistema: " + s.getListaCanciones());
         
        listaCancionesNombre = s.buscarCancionesNombre("chicle3");
             
        System.out.println("Cancion recuperada: " + listaCancionesNombre);
        System.out.println(" ");
         
        //De la misma forma Autor2 tambien puede buscar las canciones del autor1 con el metodo buscar canciones por autor
         
        System.out.println(" Busqueda de una cancion por autor ");
         
        //aux fue el usuario que subio la cancion en sistema asi que le pasamos su nickname
        listaCancionesAutor = s.buscarCancionesAutor(aux.getNickname());
        System.out.println("Estos son las canciones del autor: " + listaCancionesAutor);    
         
        System.out.println(" ");
         
        //Vamos a probar a reportar el plagio de una cancion del autor 1
           
        System.out.println("Siendo autor2 voy a reportar plagio de una cancion del autor1");
           
        System.out.println(aux.getListacancion());
           
        if(s.reportarPlagio(aux.getListacancion().get(0), "Me apetece reportarla") == false) {
            System.out.println("Error al intentar reportar");
            System.out.println(" ");
        }else {
            System.out.println("Se ha reportado correctamente");
            System.out.println(" ");
               
        }
           
       
        //En primer lugar vamos a intentar revisar el plagio de una cancion como un usuario normal, es decir, sin ser administrador, lo cual deberia dar error
           
        System.out.println("Se va a revisar el plagio de la cancion");
           
        if(s.revisarPlagio(b, true, 0) == false) {
            System.out.println("Error al revisar plagio");
            System.out.println(" ");
        }
        else {
            System.out.println("plagio revisado");
               
            autorx = (Autor)s.getUsuarioConectado();
               
            if(autorx.isBloqueado() == false){
                System.out.println("El usuario no ha sido bloqueado");
            }
            else {
                System.out.println("El usuario ha sido bloqueado");
                   
                   
                if(b.getEstado() == EstadosCancion.BLOQUEADA) {
                    System.out.println("La cancion no ha sido bloqueada");
                    System.out.println(" ");
                }
                else {
                    System.out.println("La cancion ha sido bloqueada");
                    System.out.println(" ");
                }
            }
        }
                   
               
                   
        //primero realizamos el logout de este usuario y conectamos el administrador
           
        System.out.println("Autor2 va a realizar el logout: ");
           
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor2");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor2 desconectado");
            System.out.println(" ");
        }
                   
           
        System.out.println("El administrador va a conectarse al sistema: ");
           
        if(s.accederAdministrador("admin") == false) {
            System.out.println("Error al acceder como administrador");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el administrador  " + nuevo);
            System.out.println(" ");
        }
                   
        //nuevamente, siendo ahora administrador probaremos la funcion revisarplagio. Para esta comprobacion, vamos a hacer que la denuncia de revisarPlagio
        // sea falsa, de forma que asi pueda bloquear al usuario que ha realizado la denuncia y podamos comprobar que realmente funciona
          
        for(Autor w: s.getListaUsuarios()) {
            if(w.getNickname() == "mateo") {
                aux2 = (Autor)w;
            }
        }
           
        for(Cancion r: s.getListaCanciones()) {
            System.out.println("Se va a revisar el plagio de la cancion");
               
            if(s.revisarPlagio(r, false, 0) == false) {
                System.out.println("Error al revisar plagio");
                System.out.println(" ");
            }
            else {
                System.out.println("plagio revisado");
                System.out.println(s.getUsuarioConectado());
                   
                autorx = r.getAutor();
                   
                if(autorx.isBloqueado() == false){
                    System.out.println("El usuario no ha sido bloqueado");
                    System.out.println("Autor1: "+ autorx);
                    System.out.println("Autor2: "+ aux2);
                }
                else {
                    System.out.println("El usuario ha sido bloqueado");
                    System.out.println("Autor1: "+ autorx);
                    System.out.println("Autor2: "+ aux2);
                       
                    if(r.getEstado() == EstadosCancion.BLOQUEADA) {
                        System.out.println("La cancion ha sido bloqueada");
                        System.out.println("Cancion "+ r);
                        System.out.println(" ");
                    }
                    else {
                        System.out.println("La cancion no ha sido bloqueada");
                        System.out.println("Cancion "+ r);
                        System.out.println(" ");
                    }
                }
            }
                           
        }
        
          
      //Tras esto, administrador saldra del sistema
          
        System.out.println("Administrador se desconectara del sistema: ");
           
        if(s.salirAdministrador() == false) {
            System.out.println("Error al intentar desconectarse como administrador");
            System.out.println(" ");
        }
        else {
            System.out.println("administrador desconectado");
            System.out.println(" ");
        }
          
      //Registramos al autor4 en la aplicacion
          
        System.out.println("Autor4 va a registrarse:");
           
        if(s.registrarse(autor4.getNombre(), autor4.getContrasenia(), autor4.getFechaDeNacimiento(), autor4.getNickname()) == false) {
            System.out.println("Error al registarse");
            System.out.println(" ");
        }
        else {
            System.out.println("Lista de usuarios registrados");
               
            for(Autor a: s.getListaUsuarios()) {
            System.out.println("Informacion de usuario registrado: " + a);
            }
              
            System.out.println(" ");
                       
        }
          
        //Volvemos a conectar al administrador
          
        System.out.println("El administrador va a conectarse al sistema: ");
          
        if(s.accederAdministrador("admin") == false) {
            System.out.println("Error al acceder como administrador");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el administrador  " + nuevo);
            System.out.println(" ");
        }
          
        //Vamos a bloquear al usuario recien creado
          
        System.out.println("Se va a bloquear al usuario recien creado: ");
          
        if(s.bloquearUsuario(autor4) == false) {
            System.out.println("Error al bloquear al usuario");
            System.out.println("Informacion del usuario:  "+ autor4);
            System.out.println(" ");
        }
        else {
            System.out.println("Se ha bloqueado al usuario");
            System.out.println("Informacion del usuario:  "+ autor4);
            System.out.println(" ");
        }
          
        //Aprovechando que estamos conectados como administrador, y que se ha bloqueado un usuario anteriormente, vamos a probar a desbloquearle
          
        System.out.println("Se va a desbloquear al autor4, el cual ha sido bloqueado antes: ");
   
          
        //Para desbloquearle, vamos a modificar la fecha de bloqueado de forma que cumpla el plazo de 30 dias para desbloquearle
          
        autor4.setFechaBloqueado(fecha2);
          
        if(s.desbloquearUsuario(autor4) == false) {
            System.out.println("Error al desbloquear al usuario");
            System.out.println("Informacion del usuario:  "+ autor4);
            System.out.println(" ");
        }
        else {
            System.out.println("Se ha desbloqueado al usuario");
            System.out.println("Informacion del usuario:  "+ autor4);
            System.out.println(" ");
        }
          
        //Vamos a probar a bloquear una cancion
          
        System.out.println("Se va a bloquear la cancion ");
        System.out.println("Informacion de la cancion antes de bloquearla: " + caux);
          
        if(s.bloquearCancion(caux) == false) {
            System.out.println("No se ha podido bloquear la cancion");
            System.out.println("Informacion de la cancion despues de bloquearla: " + caux);
            System.out.println(" ");
        }
        else {
            System.out.println("Se ha podido bloquear la cancion");
            System.out.println("Informacion de la cancion despues de bloquearla: " + caux);
            System.out.println(" ");
        }
          
        //Tras esto, administrador saldra del sistema
          
        System.out.println("Administrador se desconectara del sistema: ");
           
        if(s.salirAdministrador() == false) {
            System.out.println("Error al intentar desconectarse como administrador");
            System.out.println(" ");
        }
        else {
            System.out.println("administrador desconectado");
            System.out.println(" ");
        }
          
        //Ahora usuario1 va a realizar el login 
          
        System.out.println("Autor1 va a realizar el login: ");
                   
        if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
            System.out.println("Error login");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Usuario conectado  " + nuevo);
            System.out.println(" ");
        }
          
        //subimos la cancion fire
          
        System.out.println("Autor1 va a subir la cancion: ");
           
        if(s.subirCancion(fire.getName(), fire.getMP3()) == false){
            System.out.println("Error al subir la cancion");
            System.out.println(" ");
        }else {
            System.out.println("Cancion subida");
            System.out.println("Lista canciones del sistema" + s.getListaCanciones());
               
            for(Autor su: s.getListaUsuarios()) {
                if(su.getNickname() == autor.getNickname()) {
                    aux3 = su;
                }
            }
               
            System.out.println("Lista de canciones del autor" + aux3.getListacancion());
   
            System.out.println(" ");
        }
          
        System.out.println("Informacion de la cancion antes de bloquearla: " + fire);
          
        //Ahora, comprobaremos la funcion modificar cancion la cual nos permite cambiar el estado de una cancion de NO_VALIDADA  a VALIDADA
        //Esta comprobacion solo va a servir para comprobar que se cambie correctamente bien el estado de la cancion
          
        System.out.println("Se va a modificar la cancion: ");
        fire.modificarFechaNV(fecha3);
          
        if(s.modificarCancion(fire, aux3) == false) {
            System.out.println("Error al modificar la cancion");
            for(Cancion c: s.getListaCanciones()) {
                if(c.getName() == fire.getName()) {
                    caux2 = c;
                }
            }
            System.out.println("Informacion de la cancion despues de modificarla: " + caux2);
            System.out.println(" ");
        }
        else {
            System.out.println("Se ha modificado la cancion");
            for(Cancion c: s.getListaCanciones()) {
                if(c.getName() == fire.getName()) {
                    caux2 = c;
                }
            }
            System.out.println("Informacion de la cancion despues de modificarla: " + caux2);
            System.out.println(" ");
        }
         
        //Procedemos ahora a probar el metodo comprobarExplicito, primero realizamos el logout de este usuario y conectamos el administrador
         
        System.out.println("Autor2 va a realizar el logout: ");
         
        if(s.logout() == false) {
            System.out.println("Error al intentar desconectarse autor2");
            System.out.println(" ");
        }
        else {
            System.out.println("Autor2 desconectado");
            System.out.println(" ");
        }
         
      //Volvemos a conectar al administrador
         
        System.out.println("El administrador va a conectarse al sistema: ");
          
        if(s.accederAdministrador("admin") == false) {
            System.out.println("Error al acceder como administrador");
            System.out.println(" ");
        }
        else {
            nuevo = s.getUsuarioConectado();
            System.out.println("Soy el administrador  " + nuevo);
            System.out.println(" ");
        }
         
        //Una vez siendo administrador, comprobaremos la funcion comprobarExplicito
         
        System.out.println("Se va a modificar a explicito el estado de la cancion: ");
         
        for(Cancion c: s.getListaCanciones()) {
            if(c.getName() == fire.getName()) {
                caux3 = c;
            }
        }   
         System.out.println("Informacion de la cancion antes de modificarla: " + caux3);
          
         if(s.comprobarExplicito(caux3) == false) {
             System.out.println("No se ha podido modificar el contenido explicito de la cancion");
             System.out.println("Informacion de la cancion despues de modificarla: " + caux3);
             System.out.println(" ");
         }
         else {
             System.out.println("Se ha podido modificar el contenido explicito de la cancion");
             System.out.println("Informacion de la cancion despues de modificarla: " + caux3);
             System.out.println(" ");
         }
         
         //Una vez hecho esto, volvemos a desconectarnos de administrador y realizaremos un login de un usuario para comprobar las funciones
         //relacionadas con el estado de premium de un usuario, asi como convertirseEnPremium y vencimientoPremium
          
         //Tras esto, administrador saldra del sistema
          
         System.out.println("Administrador se desconectara del sistema: ");
            
         if(s.salirAdministrador() == false) {
             System.out.println("Error al intentar desconectarse como administrador");
             System.out.println(" ");
         }
         else {
             System.out.println("administrador desconectado");
             System.out.println(" ");
         }
           
         //Ahora usuario1 va a realizar el login 
           
         System.out.println("Autor1 va a realizar el login: ");
                    
         if(s.login(autor.getNickname(), autor.getContrasenia()) == false) {
             System.out.println("Error login");
             System.out.println(" ");
         }
         else {
             nuevo = s.getUsuarioConectado();
             System.out.println("Usuario conectado  " + nuevo);
             System.out.println(" ");
         }
          
         //Comprobaremos la funcion convertirse en premium con este usuario
          
         System.out.println("Usuario va a convertirse en premium");
         premium = (Autor)s.getUsuarioConectado();
         System.out.println("Informacion usuario actual: " + premium);
          
         if(s.convertirsePremium("4245386583252549") == false) {
            System.out.println("Error al convertirse en premium");
            System.out.println("Usuario actual tras premium: " + premium);
            System.out.println(" ");
         }
         else {
            System.out.println("El usuario se ha convertido en premium");
            System.out.println("Usuario actual tras premium: " + premium);
            System.out.println(" ");
         }
          
         //Ahora comprobaremos si ha vencido el plazo de premium de un usuario
         //de forma que cambiaremos su fecha de creacion del premium para que la compruebe con la actual
          
         System.out.println("Se va a comprobar el vencimiento del premium del usuario: ");
          
         premium.setFechainicio(fecha2);
         if(s.vencimientoPremium() == false) {
            System.out.println("El tiempo de premium no ha llegado a su fin, o ha sucedido algun error: ");
            System.out.println("Usuario actual tras comprobar el tiempo de premium: " + premium);
            System.out.println(" ");
          }
          else {
            System.out.println("El tiempo de premium de este usuario ha llegado a su fin: ");
            System.out.println("Usuario actual tras premium: " + premium);
            System.out.println(" ");
          }
         
          
         //Ahora el usuario 2 va a seguir al usuario 1
         //Cuando el usuario 1 suba un cancion y se valide, se le notificara de la subida
         System.out.println("Ahora se va a comprobar el seguimiento de un autor a otro:");
         for(Autor z: s.getListaUsuarios()) {
             if(z.getNickname() == autor.getNickname()) {
                 aux = z;
             }
         } 
         for(Autor z2: s.getListaUsuarios()) {
             if(z2.getNickname() == autor2.getNickname()) {
                 aux2 = z2;
             }
         } 
         
         if(aux2.SeguirAutor(aux)) {
        	 System.out.println("Usuario 2 acaba de seguir al usuario 1");
        	 System.out.println("Seguidores de usuario 1: " + aux.getListaseguidores());
        	 System.out.println("Usuarios seguidos por usuario 2: " + aux2.getListaseguidos());
         }
         else {
        	 System.out.println("Usuario 1 no pudo ser seguido por el usuario 2");
         }
         
         
         //Ahora se van a comprobar las notificaciones de subida
         //Cuando autor 1 suba dos cancion y sean validadas por el administrador, se notificara al autor 2 que le sigue
         //Tambien se le notifica al administrador para que valide las canciones que quiere subir el autor 1
         //Se puede observar que el administrador tiene muchas notificaciones de subidas anteriores y reportes por plagio
         System.out.println(" ");
         if(s.subirCancion(hawaii.getName(), hawaii.getMP3())) {
        	 System.out.println("Usuario 1 ha subido la cancion: " + hawaii.getName());
         }
         if(s.subirCancion(pirates.getName(), pirates.getMP3())) {
        	 System.out.println("Usuario 1 ha subido la cancion: " + pirates.getName());
         }
         if(s.logout()) {
        	 System.out.println("Usuario 1 ha hecho el logout");
         }
         System.out.println("El administrador ha accedido");
         s.accederAdministrador("admin");
         
         for(Cancion q: s.getListaCanciones()) {
        	 if(q.getName() == hawaii.getName()) {
        		 caux = q;
        	 }
         }
         s.validarCancion(caux);
         System.out.println("Cancion " + caux.getName() + " validada");

         for(Cancion q2: s.getListaCanciones()) {
        	 if(q2.getName() == pirates.getName()) {
        		 caux = q2;
        	 }
         }
         s.validarCancion(caux);
         System.out.println("Cancion " + caux.getName() + " validada");
         
         if(s.salirAdministrador()) {
             System.out.println("El administrador cerro sesion");
         }

         System.out.println(" ");
         System.out.println("Ahora el autor 2 va a hacer login y sera notificado de la subida de las canciones de autor 1:");
         System.out.println("Autor 2 realizo el login");
         s.login(autor2.getNickname(), autor2.getContrasenia());
             

         //Ahora vamos a probar la reproduccion de canciones
         //Para ello, buscaremos la cancion hawaii en el sistema y luego la reproduciremos
         System.out.println(" ");
         System.out.println("Ahora se va a comprobar la reproduccion de las canciones subidas antes: ");
         listaCancionesAutor = s.buscarCancionesAutor(autor.getNickname());
         if(listaCancionesAutor.size() > 0) {
             System.out.println("Canciones encontradas del autor " + aux.getNombre() + ":");
             for(Cancion en: listaCancionesAutor) {
                 System.out.println("->" + en);
             }
         }
         caux = listaCancionesAutor.get(2);
         Mp3Player player = new Mp3Player();
         player = s.reproducirCancion(caux);
         if(player!=null) {
             System.out.println(" ");
             System.out.println(">>> Reproduciendo la cancion: " + caux.getName() + " >>>");
         }
             
         //Ahora vamos a probar la pausa de canciones
         //Para ello, pararemos las canciones reproducidas tras 25 segundos
 		 System.out.println("Tiempo escuchado de la cancion: ");
         for(int i=1; i<26; i++) {
     		 Thread.sleep(1000);
     		 System.out.print(" " + i + "s");
         }

 		 s.pausarCancion(player);
         System.out.println(" ");
 		 System.out.println("Cancion " + caux.getName() + " detenida");
 		 
         caux = listaCancionesAutor.get(3);
         Mp3Player player2 = new Mp3Player();
         player2 = s.reproducirCancion(caux);
         if(player!=null) {
             System.out.println(" ");
             System.out.println(">>> Reproduciendo la cancion: " + caux.getName() + " >>>");
         }       
 	     for(int i=1; i<26; i++) {
 	    	 Thread.sleep(1000);
      		 System.out.print(" " + i + "s");
         }
 	      
  		 s.pausarCancion(player2);
         System.out.println(" ");
 		 System.out.println("Cancion " + caux.getName() + " detenida");
 		 
    }
}