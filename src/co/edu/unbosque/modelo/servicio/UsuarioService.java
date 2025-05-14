package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dao.UsuarioDaoImpl;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.UsuarioNoEncontradoException;
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

    public void crearUsuario(Usuario usuario, String passwordInicial) throws AccesoDatosException {
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
            throws UsuarioNoEncontradoException, AccesoDatosException, IOException {
        Usuario u = buscarPorId(idUsuario);
        if (u == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        u.setPasswordHash(Encriptador.encriptarSHA256(nuevaPassword));
        u.setNecesitaCambioPassword(false);
        actualizarUsuario(u);
    }

}
