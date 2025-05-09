package co.edu.unbosque.modelo.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.entidad.Jugador;
import co.edu.unbosque.modelo.entidad.Entrenador;
import co.edu.unbosque.modelo.dao.UsuarioDao;
import co.edu.unbosque.utils.Encriptador;

public class UsuarioService {

    private UsuarioDao usuarioDao;

    public UsuarioService() {
        usuarioDao = new UsuarioDao();
    }

    public List<Usuario> obtenerTodos() {
        return usuarioDao.obtenerTodos();
    }

    public Optional<Usuario> buscarPorId(String id) {
        List<Usuario> usuarios = usuarioDao.obtenerTodos();
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    public void crearUsuario(Usuario usuario, String passwordInicial) {
        usuario.setPasswordHash(Encriptador.encriptarSHA256(passwordInicial));
        usuario.setNecesitaCambioPassword(true);
        usuarioDao.guardar(usuario);
    }

    public void actualizarUsuario(Usuario usuarioActualizado) {
        usuarioDao.actualizar(usuarioActualizado);
    }

    public void eliminarUsuario(String id) {
        usuarioDao.eliminar(id);
    }

    public List<Jugador> obtenerSoloJugadores() {
        List<Usuario> todos = usuarioDao.obtenerTodos();
        List<Jugador> jugadores = new ArrayList<>();
        for (Usuario u : todos) {
            if (u instanceof Jugador) {
                jugadores.add((Jugador) u);
            }
        }
        return jugadores;
    }

    public List<Entrenador> obtenerSoloEntrenadores() {
        List<Usuario> todos = usuarioDao.obtenerTodos();
        List<Entrenador> entrenadores = new ArrayList<>();
        for (Usuario u : todos) {
            if (u instanceof Entrenador) {
                entrenadores.add((Entrenador) u);
            }
        }
        return entrenadores;
    }

    public List<Usuario> filtrarPorPais(String pais) {
        List<Usuario> resultado = new ArrayList<>();
        List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getPais().equalsIgnoreCase(pais)) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    public List<Usuario> filtrarPorCiudad(String ciudad) {
        List<Usuario> resultado = new ArrayList<>();
        List<Usuario> todos = usuarioDao.obtenerTodos();
        for (Usuario u : todos) {
            if (u.getCiudad().equalsIgnoreCase(ciudad)) { 
                resultado.add(u);
            }
        }
        return resultado;
    }

    public boolean verificarCredenciales(String correo, String password) {
        List<Usuario> usuarios = usuarioDao.obtenerTodos();
        String hash = Encriptador.encriptarSHA256(password);
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo) && u.getPasswordHash().equals(hash)) {
                return true;
            }
        }
        return false;
    }
}
