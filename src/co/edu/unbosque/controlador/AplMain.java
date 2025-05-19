package co.edu.unbosque.controlador;

/**
 * Clase principal del sistema NeoLeague Arena.
 * <p>
 * Esta clase contiene el método {@code main}, que actúa como punto de entrada 
 * para la ejecución de la aplicación. Desde aquí se inicializa el 
 * {@link ControladorPrincipal}, encargado de orquestar la carga de vistas,
 * servicios y lógica general del sistema.
 * 
 * <p>
 * La creación del {@code ControladorPrincipal} da inicio al flujo de la aplicación, 
 * cargando la ventana de login y preparando el entorno para los diferentes roles 
 * de usuario: administrador, entrenador y jugador.
 * 
 * @version 1.0
 */
public class AplMain {

    /**
     * Método principal que inicia la ejecución del sistema NeoLeague Arena.
     * 
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        ControladorPrincipal controlador = new ControladorPrincipal();
    }

}
