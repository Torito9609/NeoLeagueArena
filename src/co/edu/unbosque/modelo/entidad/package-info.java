/**
 * Este paquete contiene las clases del modelo de dominio del sistema NeoLeague Arena.
 * <p>
 * Aquí se definen las entidades principales que representan los elementos centrales del sistema,
 * incluyendo usuarios (jugadores, entrenadores), equipos, torneos, juegos y partidas.
 * Estas clases modelan la lógica y estructura real del negocio, manteniendo el estado
 * y las relaciones entre los distintos componentes del ecosistema de e-sports.
 * <p>
 * Entre las entidades destacadas se encuentran:
 * <ul>
 *   <li><b>Usuario</b>, <b>Jugador</b> y <b>Entrenador</b>: Representan a los distintos tipos de usuarios del sistema.</li>
 *   <li><b>Equipo</b>: Agrupa jugadores y puede ser asignado a un entrenador.</li>
 *   <li><b>Juego</b>: Representa videojuegos disponibles como FIFA, Rocket League, Fórmula 1 y Gran Turismo.</li>
 *   <li><b>Torneo</b>: Contiene la lógica y estructura de cada torneo organizado, incluyendo su tipo de fase.</li>
 *   <li><b>Partida</b> y subtipos: Instancias de juego específicas con datos particulares según el tipo de competencia.</li>
 *   <li><b>Resultado</b> y subtipos: Registran el desenlace de una partida, ya sea por puntaje, posición o tiempo.</li>
 *   <li><b>Fase</b> y subtipos: Definen el formato de competencia (campeonato, eliminación directa, round robin).</li>
 *   <li><b>Circuito</b>, <b>GrandPrix</b>: Modelan escenarios de carrera usados en juegos como F1 o Gran Turismo.</li>
 * </ul>
 * Estas clases son utilizadas por los DAOs para persistencia, por los servicios para aplicar reglas de negocio,
 * y por los controladores para coordinar acciones desde la vista.
 * 
 * @see co.edu.unbosque.modelo.dto
 * @see co.edu.unbosque.dao
 * @see co.edu.unbosque.servicio
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.entidad;
