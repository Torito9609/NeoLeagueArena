package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.UsuarioDaoImpl;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.RegistroDuplicadoException;
import co.edu.unbosque.modelo.exception.RegistroInvalidoException;
import co.edu.unbosque.modelo.exception.RegistroNoEncontradoException;
import co.edu.unbosque.utils.Encriptador;

public class UsuarioService {

    private final UsuarioDaoImpl usuarioDao;

    public UsuarioService() throws AccesoDatosException {
        usuarioDao = new UsuarioDaoImpl();
    }

    public List<Usuario> obtenerTodos() throws AccesoDatosException {
        return usuarioDao.obtenerTodos();
    }

    public Usuario buscarPorId(String id) throws AccesoDatosException {
        List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void crearUsuario(Usuario usuario, String passwordInicial) throws AccesoDatosException, RegistroDuplicadoException {
    	if(buscarPorId(usuario.getId()) != null) {
    		throw new RegistroDuplicadoException("El ID ingresado ya existe " + usuario.getId());
    	}
    	
    	if(correoExiste(usuario.getCorreo())) {
    		throw new RegistroDuplicadoException("El correo ya esta en uso " + usuario.getCorreo());
    	}
        prepararNuevoUsuario(usuario, passwordInicial);
        usuarioDao.guardar(usuario);
    }

    public void actualizarUsuario(Usuario usuarioActualizado)
            throws AccesoDatosException, IOException {
        usuarioDao.actualizar(usuarioActualizado.getId(), usuarioActualizado);
    }

    public void eliminarUsuario(String id) throws AccesoDatosException, IOException {
        usuarioDao.eliminar(id);
    }
    
    public List<Usuario> buscarPorNombre(String nombreParcial) throws AccesoDatosException{
    	List<Usuario> resultadosBusqueda = new ArrayList<Usuario>();
    	for(Usuario u : usuarioDao.obtenerTodos()) {
    		String nombreCompleto = u.getNombres() + u.getApellidos();
    		if(nombreCompleto.toLowerCase().contains(nombreParcial.toLowerCase())) {
    			resultadosBusqueda.add(u);
    		}
    	}
    	return resultadosBusqueda;
    }
    
    public Usuario buscarPorCorreo(String correo) throws AccesoDatosException {
    	List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    } 

    public List<Usuario> filtrarPorPais(String pais) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarioDao.obtenerTodos()) {
            if (u.getPais().equalsIgnoreCase(pais)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    public List<Usuario> filtrarPorCiudad(String ciudad) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        for (Usuario u : usuarioDao.obtenerTodos()) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) {
                resultado.add(u);
            }
        }
        return resultado;
    }
    
    public void prepararNuevoUsuario(Usuario usuario, String passwordInicial) {
    	String passwordHash = Encriptador.encriptarSHA256(passwordInicial);
    	usuario.setPasswordHash(passwordHash);
    	usuario.setNecesitaCambioPassword(true);
    }

    public boolean verificarCredenciales(String correo, String password) 
            throws AccesoDatosException {
        String hash = Encriptador.encriptarSHA256(password);
        for (Usuario u : usuarioDao.obtenerTodos()) {
            if (u.getCorreo().equalsIgnoreCase(correo)
             && u.getPasswordHash().equals(hash)) {
                return true;
            }
        }
        return false;
    }

    public void cambiarPassword(String idUsuario, String nuevaPassword)
            throws RegistroNoEncontradoException, AccesoDatosException, IOException, RegistroInvalidoException {

        if (!esPasswordValida(nuevaPassword)) {
            throw new RegistroInvalidoException("La contraseña debe tener al menos 8 caracteres, una mayúscula, un número y un carácter especial (!@#$%&*)");
        }

        Usuario u = buscarPorId(idUsuario);
        if (u == null) {
            throw new RegistroNoEncontradoException("Usuario no encontrado");
        }

        u.setPasswordHash(Encriptador.encriptarSHA256(nuevaPassword));
        u.setNecesitaCambioPassword(false);
        actualizarUsuario(u);
    }
    
    private boolean esPasswordValida(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        boolean tieneEspecial = false;

        String especiales = "!@#$%&*";

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (especiales.indexOf(c) >= 0) {
                tieneEspecial = true;
            }
        }

        return tieneMayuscula && tieneNumero && tieneEspecial;
    }

    
    public boolean correoExiste(String correo) throws AccesoDatosException {
    	return buscarPorCorreo(correo) != null;
    }

}
