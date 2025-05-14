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
        return usuarioDao.obtenerTodos().stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public void crearUsuario(Usuario usuario, String passwordInicial) throws AccesoDatosException {
        usuario.setPasswordHash(Encriptador.encriptarSHA256(passwordInicial));
        usuario.setNecesitaCambioPassword(true);
        usuarioDao.guardar(usuario);
    }

    public void actualizarUsuario(Usuario usuarioActualizado)
            throws AccesoDatosException, IOException {
        usuarioDao.actualizar(usuarioActualizado.getId(), usuarioActualizado);
    }

    public void eliminarUsuario(String id) throws AccesoDatosException, IOException {
        usuarioDao.eliminar(id);
    }

    public List<Jugador> obtenerSoloJugadores() throws AccesoDatosException {
        return filtrarPorClase(Jugador.class);
    }

    public List<Entrenador> obtenerSoloEntrenadores() throws AccesoDatosException {
        return filtrarPorClase(Entrenador.class);
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

    // ——— Helpers ———

    @SuppressWarnings("unchecked")
    private <T extends Usuario> List<T> filtrarPorClase(Class<T> tipo) 
            throws AccesoDatosException {
        List<T> lista = new ArrayList<>();
        for (Usuario u : usuarioDao.obtenerTodos()) {
            if (tipo.isInstance(u)) {
                lista.add((T) u);
            }
        }
        return lista;
    }
}
