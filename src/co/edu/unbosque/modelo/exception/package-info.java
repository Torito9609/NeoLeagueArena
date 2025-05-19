/**
 * Este paquete contiene las excepciones personalizadas definidas para el sistema NeoLeague Arena.
 * <p>
 * Estas clases extienden {@code Exception} o sus subtipos, y permiten capturar y manejar 
 * errores específicos del dominio de la aplicación, mejorando la claridad del flujo de control 
 * y facilitando la depuración.
 * <p>
 * Las excepciones incluidas abarcan casos como:
 * <ul>
 *   <li><b>AccesoDatosException</b>: Error general en la lectura o escritura de archivos.</li>
 *   <li><b>RegistroDuplicadoException</b>: Se intenta guardar un objeto que ya existe en el sistema.</li>
 *   <li><b>RegistroInvalidoException</b>: Datos ingresados no cumplen con las validaciones definidas.</li>
 *   <li><b>RegistroNoEncontradoException</b>: Se intenta acceder o editar un elemento inexistente.</li>
 *   <li><b>TorneoInvalidoException</b>: Reglas o condiciones del torneo no se cumplen al momento de su creación o modificación.</li>
 * </ul>
 * Estas excepciones son lanzadas desde la capa de servicios o DAO y pueden ser manejadas en los controladores
 * para informar adecuadamente al usuario o tomar acciones correctivas.
 * 
 * @see java.lang.Exception
 * @see co.edu.unbosque.servicio
 * 
 * @author Andres
 * @version 1.0
 */
package co.edu.unbosque.modelo.exception;
