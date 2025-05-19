package co.edu.unbosque.modelo.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.modelo.dto.PartidaDto;
import co.edu.unbosque.modelo.entidad.Partida;
import co.edu.unbosque.modelo.exception.AccesoDatosException;
import co.edu.unbosque.modelo.mapper.PartidaMapHandlerI;
import co.edu.unbosque.modelo.mapper.PartidaMapHandlerFactory;
import co.edu.unbosque.modelo.persistencia.ConstanteArchivo;
import co.edu.unbosque.modelo.persistencia.GestorPersistencia;

public class PartidaDaoImpl implements ICrudDao<Partida<?>> {

    private final String RUTA_ARCHIVO = ConstanteArchivo.ARCHIVO_PARTIDAS;
    private final GestorPersistencia<Partida<?>, PartidaDto> gestor;
    private List<Partida<?>> partidas;

    public PartidaDaoImpl(String tipoPartida) throws AccesoDatosException {
        this.partidas = new ArrayList<>();
        PartidaMapHandlerI mapper = PartidaMapHandlerFactory.getHandler(tipoPartida);
        this.gestor = new GestorPersistencia<>(RUTA_ARCHIVO, mapper);
        actualizarBD();
    }

    private void actualizarBD() throws AccesoDatosException {
        partidas = gestor.cargar();
    }

    private void recrearArchivo() throws IOException {
        if (gestor.getUbicacionArchivo().exists()) {
            gestor.getUbicacionArchivo().delete();
        }
        gestor.getUbicacionArchivo().createNewFile();
    }

    @Override
    public List<Partida<?>> obtenerTodos() throws AccesoDatosException {
        return new ArrayList<>(partidas);
    }

    @Override
    public boolean guardar(Partida<?> u) throws AccesoDatosException {
        if (buscarPorId(u.getId()) == null) {
            partidas.add(u);
            gestor.guardar(partidas);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(String id) throws AccesoDatosException, IOException {
        Partida<?> p = buscarPorId(id);
        if (p != null) {
            partidas.remove(p);
            recrearArchivo();
            gestor.guardar(partidas);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizar(String idActualizar, Partida<?> uActualizado) throws AccesoDatosException, IOException {
        for (int i = 0; i < partidas.size(); i++) {
            if (partidas.get(i).getId().equals(idActualizar)) {
                partidas.set(i, uActualizado);
                recrearArchivo();
                gestor.guardar(partidas);
                return true;
            }
        }
        return false;
    }

    @Override
    public Partida<?> buscarPorId(String id) {
        for (Partida<?> p : partidas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean guardarTodos(List<Partida<?>> lista) {
        try {
            gestor.guardar(lista);
            return true;
        } catch (AccesoDatosException e) {
            e.printStackTrace();
            return false;
        }
    }
}
