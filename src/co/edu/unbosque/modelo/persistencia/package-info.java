/**
 * Este paquete contiene las clases responsables de gestionar la persistencia de datos
 * y la exportación de archivos en el sistema NeoLeague Arena.
 * <p>
 * Proporciona mecanismos para:
 * <ul>
 *   <li><b>Lectura y escritura en archivos binarios</b>: mediante {@code GestorPersistencia}, encargado de serializar entidades.</li>
 *   <li><b>Manejo de archivos CSV</b>: mediante {@code GestorCsv}, útil para exportar o importar datos en formato tabular.</li>
 *   <li><b>Generación de reportes PDF</b>: mediante {@code GeneradorPdf}, orientado a la creación de documentos imprimibles.</li>
 *   <li><b>Carga de configuración externa</b>: {@code ConfiguracionLoader} permite ajustar rutas o parámetros desde archivos de propiedades.</li>
 *   <li><b>Definición de constantes de rutas y nombres de archivo</b>: agrupadas en {@code ConstanteArchivo}.</li>
 * </ul>
 * Este paquete encapsula toda la lógica relacionada con la persistencia y exportación de datos, permitiendo a los
 * servicios y controladores interactuar con el sistema de archivos sin acoplarse a su implementación técnica.
 * 
 * @see java.io.Serializable
 * @see java.io.File
 * @see java.util.Properties
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.persistencia;
