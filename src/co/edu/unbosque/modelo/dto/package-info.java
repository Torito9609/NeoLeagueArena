/**
 * Este paquete contiene los Data Transfer Objects (DTOs) utilizados en el sistema NeoLeague Arena,
 * encargados de transportar datos entre la vista, los controladores y los servicios, manteniendo 
 * la separación entre las capas de presentación y lógica de negocio.
 * <p>
 * Los DTOs definidos aquí representan de manera simplificada las entidades del modelo, y se utilizan
 * tanto para la visualización en tablas como para la persistencia de datos en archivos binarios y CSV.
 * <p>
 * Entre los DTOs principales se encuentran:
 * <ul>
 *   <li><b>UsuarioDto</b> y subtipos: encapsulan información de administradores, entrenadores y jugadores.</li>
 *   <li><b>EquipoDto</b>: contiene los datos de cada equipo registrado.</li>
 *   <li><b>JuegoDto</b>: representa un videojuego disponible para torneos.</li>
 *   <li><b>TorneoDto</b>: describe los torneos organizados, su tipo y configuración.</li>
 *   <li><b>ParticipacionTorneoDto</b>: vincula equipos con torneos.</li>
 *   <li><b>AsignacionEntrenadorDto</b>: gestiona la asignación de entrenadores a equipos.</li>
 *   <li><b>PartidaDto</b> y subtipos:
 *     <ul>
 *       <li><b>PartidaFifaDto</b>, <b>PartidaRocketLeagueDto</b>: contienen resultados tipo campeonato.</li>
 *       <li><b>PartidaCarreraDto</b>: utilizada para juegos como Fórmula 1 o Gran Turismo, con tiempos por circuito.</li>
 *     </ul>
 *   </li>
 * </ul>
 * Este enfoque permite mantener el diseño desacoplado, facilitar las pruebas, y optimizar el manejo de datos
 * en interfaces gráficas y procesos de serialización.
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.dto;
