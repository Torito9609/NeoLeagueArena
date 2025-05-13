package co.edu.unbosque.modelo.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.exception.UsuarioNoEncontradoException;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.dao.UsuarioDaoImpl;
import co.edu.unbosque.utils.Encriptador;

public class UsuarioService {

    private UsuarioDaoImpl usuarioDao;

    public UsuarioService() throws AccesoDatosException {
        usuarioDao = new UsuarioDaoImpl();
    }

    public List<Usuario> obtenerTodos() throws AccesoDatosException {
        return usuarioDao.obtenerTodos();
    }

    public Usuario buscarPorId(String id) throws AccesoDatosException {
        List<Usuario> usuarios = usuarioDao.obtenerTodos();
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void crearUsuario(Usuario usuario, String passwordInicial) throws AccesoDatosException {
        usuario.setPasswordHash(Encriptador.encriptarSHA256(passwordInicial));
        usuario.setNecesitaCambioPassword(true);
        usuarioDao.guardar(usuario);
    }

    public void actualizarUsuario(String idActualizar, Usuario usuarioActualizado) throws AccesoDatosException, IOException {
        usuarioDao.actualizar(idActualizar, usuarioActualizado);
    }

    public void eliminarUsuario(String id) throws AccesoDatosException, IOException {
        usuarioDao.eliminar(id);
    }

    public List<Jugador> obtenerSoloJugadores() throws AccesoDatosException {
        List<Usuario> todos = usuarioDao.obtenerTodos();
        List<Jugador> jugadores = new ArrayList<>();
        for (Usuario u : todos) {
            if (u instanceof Jugador) {
                jugadores.add((Jugador) u);
            }
        }
        return jugadores;
    }

    public List<Entrenador> obtenerSoloEntrenadores() throws AccesoDatosException {
        List<Usuario> todos = usuarioDao.obtenerTodos();
        List<Entrenador> entrenadores = new ArrayList<>();
        for (Usuario u : todos) {
            if (u instanceof Entrenador) {
                entrenadores.add((Entrenador) u);
            }
        }
        return entrenadores;
    }

    public List<Usuario> filtrarPorPais(String pais) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getPais().equalsIgnoreCase(pais)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    public List<Usuario> filtrarPorCiudad(String ciudad) throws AccesoDatosException {
        List<Usuario> resultado = new ArrayList<>();
        List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) { 
                resultado.add(u);
            }
        }
        return resultado;
    }

    public boolean verificarCredenciales(String correo, String password) throws AccesoDatosException {
        List<Usuario> usuarios = usuarioDao.obtenerTodos();
        String hash = Encriptador.encriptarSHA256(password);
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getPasswordHash().equals(hash)) {
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
        String hash = Encriptador.encriptarSHA256(nuevaPassword);
        u.setPasswordHash(hash);
        u.setNecesitaCambioPassword(false);
        actualizarUsuario(u.getId(), u);
    }
}
