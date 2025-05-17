package co.edu.unbosque.modelo.persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import co.edu.unbosque.modelo.entidad.Circuito;
import co.edu.unbosque.modelo.entidad.GrandPrix;
import co.edu.unbosque.modelo.exception.AccesoDatosException;

/**
 * Clase encargada de cargar configuraciones desde un archivo de propiedades.
 * <p>
 * Lee un archivo de propiedades especificado por su ruta de recurso y proporciona
 * métodos para extraer información específica, como listas de {@link Circuito}s
 * y {@link GrandPrix}.
 * </p>
 *
 * @see Properties
 * @see Circuito
 * @see GrandPrix
 * @see AccesoDatosException
 * @autor TuNombreCompletoAquí
 * @version 1.0
 */
public class ConfiguracionLoader {

    /**
     * Nombre o ruta del archivo de propiedades que se cargará.
     * Este campo puede ser modificado después de la instanciación.
     */
    private String recurso; // Este campo no es final, por lo que no se describe como tal.

    /**
     * Objeto {@link Properties} que almacena las propiedades cargadas desde el archivo.
     */
    private Properties props;

    /**
     * Constructor que carga las propiedades desde el archivo de recurso especificado.
     * <p>
     * Utiliza el cargador de clases para encontrar el archivo de recurso, lo lee
     * y carga su contenido en un objeto {@link Properties}.
     * </p>
     *
     * @param recurso El nombre o ruta del archivo de propiedades a cargar (ej. "config.properties").
     * Se busca en el classpath.
     * @throws IOException          Si ocurre un error de entrada/salida al leer el archivo.
     * @throws AccesoDatosException Si el archivo de propiedades no se encuentra en el classpath.
     */
    public ConfiguracionLoader(String recurso) throws IOException, AccesoDatosException {
        // El campo 'recurso' no se inicializa aquí con el parámetro,
        // lo que significa que this.recurso podría ser null a menos que se asigne explícitamente después.
        // Si el parámetro 'recurso' debe asignarse a this.recurso, se añadiría: this.recurso = recurso;
        props = new Properties();
        try (InputStream in = ConfiguracionLoader.class.getClassLoader().getResourceAsStream(recurso)) {
            if (in == null) {
                throw new AccesoDatosException("No se encontró el archivo de propiedades: " + recurso);
            }
            // Se usa BufferedReader con InputStreamReader para asegurar la correcta lectura de caracteres.
            props.load(new BufferedReader(new InputStreamReader(in)));
        }
    }

    /**
     * Carga una lista de objetos {@link Circuito} desde las propiedades.
     * <p>
     * Lee la propiedad "circuitos" para obtener una lista de IDs de circuitos,
     * y luego, para cada ID, lee las propiedades asociadas "nombre" y "rutaFoto"
     * para construir cada objeto {@code Circuito}.
     * </p>
     *
     * @return Una lista de {@code Circuito}s. La lista estará vacía si no se definen
     * circuitos o si la propiedad "circuitos" está vacía.
     */
    public List<Circuito> cargarCircuitos() {
        String[] ids = props.getProperty("circuitos", "").split(",");
        List<Circuito> lista = new ArrayList<>();
        for (String id : ids) {
            id = id.trim();
            if (id.isEmpty())
                continue;
            String nombre = props.getProperty("circuito." + id + ".nombre");
            String rutaFoto = props.getProperty("circuito." + id + ".rutaFoto");
            lista.add(new Circuito(id, nombre, rutaFoto));
        }
        return lista;
    }

    /**
     * Carga una lista de objetos {@link GrandPrix} desde las propiedades,
     * utilizando una lista preexistente de {@link Circuito}s para resolver las referencias.
     * <p>
     * Lee la propiedad "grandprix" para obtener una lista de IDs de Grand Prix.
     * Para cada ID, lee su "nombre" y el "circuitoId" asociado. Busca el {@code Circuito}
     * correspondiente en la lista de circuitos proporcionada.
     * </p>
     *
     * @param circuitos Una lista de todos los {@link Circuito}s disponibles, utilizada para
     * enlazar cada {@code GrandPrix} con su respectivo {@code Circuito}.
     * @return Una lista de {@code GrandPrix}. La lista estará vacía si no se definen
     * Grand Prix o si la propiedad "grandprix" está vacía.
     * @throws AccesoDatosException Si no se encuentra un {@code Circuito} referenciado por un
     * {@code GrandPrix} en la lista de circuitos proporcionada.
     */
    public List<GrandPrix> cargarGrandPrix(List<Circuito> circuitos) throws AccesoDatosException {
        // Crea un mapa de circuitos por ID para una búsqueda eficiente.
        Map<String, Circuito> mapa = new HashMap<>();
        if (circuitos != null) {
            for (Circuito c : circuitos) {
                if (c != null && c.getId() != null) {
                    mapa.put(c.getId(), c);
                }
            }
        }

        String[] gps = props.getProperty("grandprix", "").split(",");
        List<GrandPrix> lista = new ArrayList<>();
        for (String id : gps) {
            id = id.trim();
            if (id.isEmpty())
                continue;
            String nombre = props.getProperty("grandprix." + id + ".nombre");
            String circuitoId = props.getProperty("grandprix." + id + ".circuito");
            Circuito circ = mapa.get(circuitoId);
            if (circ == null) {
                throw new AccesoDatosException("Circuito no encontrado para Grand Prix '" + nombre + "': ID " + circuitoId);
            }
            lista.add(new GrandPrix(id, nombre, circ));
        }
        return lista;
    }

    /**
     * Obtiene el nombre o ruta del archivo de propiedades que se está utilizando.
     * @return El nombre/ruta del recurso. Puede ser {@code null} si no se estableció.
     */
    public String getRecurso() {
        return recurso;
    }

    /**
     * Establece el nombre o ruta del archivo de propiedades.
     * <p>
     * Nota: Cambiar el recurso después de la instanciación no recargará
     * automáticamente las propiedades. Se necesitaría una nueva carga.
     * </p>
     * @param recurso El nuevo nombre/ruta del recurso.
     */
    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    /**
     * Obtiene el objeto {@link Properties} que contiene todas las propiedades cargadas.
     * @return El objeto {@code Properties}.
     */
    public Properties getProps() {
        return props;
    }

    /**
     * Establece el objeto {@link Properties}.
     * Permite reemplazar el conjunto de propiedades cargadas.
     * @param props El nuevo objeto {@code Properties}.
     */
    public void setProps(Properties props) {
        this.props = props;
    }
}