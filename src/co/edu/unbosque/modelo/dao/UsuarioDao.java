package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.entidad.Usuario;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class UsuarioDao {

    private final String ruta = "data/usuarios.dat";
    private final GestorPersistencia<Usuario> gestor = new GestorPersistencia<>();

    public List<Usuario> obtenerTodos() {
        try {
            return gestor.cargarLista(ruta);
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void guardarTodos(List<Usuario> lista) {
        try {
            gestor.guardarLista(ruta, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardar(Usuario u) {
        List<Usuario> usuarios = obtenerTodos();
        usuarios.add(u);
        guardarTodos(usuarios);
    }

    public Usuario buscarPorId(String id) {
        List<Usuario> usuarios = obtenerTodos();
        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }

    public void eliminar(String id) {
        List<Usuario> usuarios = obtenerTodos();
        Usuario usuarioAEliminar = null;

        for (Usuario u : usuarios) {
            if (u.getId().equals(id)) {
                usuarioAEliminar = u;
                break;
            }
        }

        if (usuarioAEliminar != null) {
            usuarios.remove(usuarioAEliminar);
            guardarTodos(usuarios);
        }
    }

    public void actualizar(Usuario usuarioActualizado) {
        List<Usuario> usuarios = obtenerTodos();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuarioActualizado.getId())) {
                usuarios.set(i, usuarioActualizado);
                break;
            }
        }
        guardarTodos(usuarios);
    }
}
