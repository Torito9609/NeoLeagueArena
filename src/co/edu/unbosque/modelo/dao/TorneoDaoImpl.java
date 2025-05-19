package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.TorneoDto;
import co.edu.unbosque.modelo.entidad.Torneo;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.TorneoMapHandler;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class TorneoDaoImpl implements ICrudDao<Torneo> {

    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_TORNEOS;
    private final List<Torneo> torneos;
    private final GestorPersistencia<Torneo, TorneoDto> gestor;

    public TorneoDaoImpl() throws AccesoDatosException {
        this.torneos = new ArrayList<>();
        this.gestor = new GestorPersistencia<Torneo, TorneoDto>(RUTA_ARCHIVO, new TorneoMapHandler("DESCONOCIDO")); 
        actualizarBD();
    }

    private void actualizarBD() throws AccesoDatosException {
        torneos.clear();
        torneos.addAll(gestor.cargar());
    }

    private void recrearArchivo() throws IOException {
        if (gestor.getUbicacionArchivo().exists()) {
            gestor.getUbicacionArchivo().delete();
        }
        gestor.getUbicacionArchivo().createNewFile();
    }

    @Override
    public List<Torneo> obtenerTodos() throws AccesoDatosException {
        return new ArrayList<>(torneos);
    }

    @Override
    public boolean guardar(Torneo t) throws AccesoDatosException {
        if (buscarPorId(t.getId()) == null) {
            torneos.add(t);
            gestor.guardar(torneos);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        Torneo encontrado = buscarPorId(id);
        if (encontrado != null) {
            torneos.remove(encontrado);
            recrearArchivo();
            gestor.guardar(torneos);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizar(String idActualizar, Torneo actualizado) throws AccesoDatosException, IOException {
        for (int i = 0; i < torneos.size(); i++) {
            if (torneos.get(i).getId().equals(idActualizar)) {
                torneos.set(i, actualizado);
                recrearArchivo();
                gestor.guardar(torneos);
                return true;
            }
        }
        return false;
    }

    @Override
    public Torneo buscarPorId(String id) {
        for (Torneo t : torneos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public boolean guardarTodos(List<Torneo> lista) {
        try {
            torneos.clear();
            torneos.addAll(lista);
            gestor.guardar(lista);
            return true;
        } catch (AccesoDatosException e) {
            e.printStackTrace();
            return false;
        }
    }
}
