/**
 * Este paquete contiene las clases encargadas de transformar objetos entre entidades del modelo
 * y sus respectivos Data Transfer Objects (DTOs), así como otras estructuras necesarias para la
 * visualización y persistencia de datos en el sistema NeoLeague Arena.
 * <p>
 * Los {@code MapHandler} actúan como componentes intermedios entre las capas de datos y presentación,
 * permitiendo separar la lógica de transformación del resto del sistema y facilitando la reutilización.
 * <p>
 * Entre sus responsabilidades se encuentran:
 * <ul>
 *   <li>Convertir entidades como {@code Usuario}, {@code Equipo}, {@code Torneo}, {@code Partida} y sus subtipos en DTOs.</li>
 *   <li>Transformar de DTO a entidad cuando se reciben datos desde la vista.</li>
 *   <li>Mapear estructuras complejas como {@code PartidaCarrera}, {@code PartidaFifa}, etc., a sus representaciones para tablas u otros formatos.</li>
 *   <li>Centralizar la lógica de conversión mediante {@code PartidaMapHandlerFactory} y clases especializadas.</li>
 * </ul>
 * Este enfoque mejora la mantenibilidad del código y permite extender el sistema fácilmente cuando se agregan
 * nuevos tipos de partidas o entidades sin modificar la lógica central del controlador o la vista.
 * 
 * @see co.edu.unbosque.modelo.dto
 * @see co.edu.unbosque.modelo.entidad
 * @see co.edu.unbosque.servicio
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.mapper;
