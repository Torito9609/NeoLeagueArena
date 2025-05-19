/**
 * Este paquete contiene las clases DAO (Data Access Object) del sistema NeoLeague Arena,
 * responsables de realizar las operaciones de persistencia sobre archivos binarios.
 * <p>
 * Cada clase DAO implementa la interfaz genérica {@code ICrudDao<T>}, la cual define
 * los métodos básicos para crear, leer, actualizar y eliminar datos de una entidad.
 * <p>
 * Estas clases actúan como puente entre el modelo de datos y los servicios, 
 * asegurando el acceso eficiente a la información persistida, sin exponer
 * detalles internos de la estructura de archivos al resto del sistema.
 * <p>
 * Se proveen DAOs específicos para usuarios (administradores, entrenadores, jugadores),
 * torneos, equipos, juegos, partidas por tipo (FIFA, Rocket League, Fórmula 1, Gran Turismo),
 * resultados, asignaciones y participaciones.
 * <p>
 * La implementación incluye mecanismos de serialización y deserialización, garantizando
 * la integridad de los datos y facilitando su recuperación para uso en la aplicación.
 * 
 * @see co.edu.unbosque.dao.ICrudDao
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.dao;
