package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel gráfico que contiene los botones principales de acciones administrativas
 * para la gestión de usuarios, como crear, editar y eliminar. Está diseñado para interactuar con la tabla de usuarios.
 * 
 * <p>Esta clase forma parte de la interfaz de usuario del módulo de administración y se utiliza en la parte inferior
 * de una ventana o sección administrativa.</p>
 * 
 * <p>Cada botón tiene asociado un comando de acción que debe ser gestionado desde el controlador.</p>
 * 
 * <h3>Responsabilidades:</h3>
 * <ul>
 *   <li>Mostrar los botones de acción: Crear, Editar y Eliminar.</li>
 *   <li>Delegar el control de eventos al controlador externo.</li>
 * </ul>
 */
public class PanelInferiorAdmin extends JPanel {

    private JButton crearButton, editarButton, eliminarButton;

    /**
     * Constructor que crea una instancia del panel inferior con disposición de botones alineada a la derecha
     * y con fondo gris claro.
     */
    public PanelInferiorAdmin() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }

    /**
     * Inicializa y agrega los botones de acción al panel.
     */
    private void inicializarComponentes() {
        crearButton = new JButton("Crear usuario");
        crearButton.setActionCommand("CREAR_USUARIO");
        add(crearButton);

        editarButton = new JButton("Editar usuario");
        editarButton.setActionCommand("EDITAR_USUARIO");
        add(editarButton);

        eliminarButton = new JButton("Eliminar usuario");
        eliminarButton.setActionCommand("ELIMINAR_USUARIO");
        add(eliminarButton);
    }

    /**
     * Devuelve el botón para editar un usuario.
     * 
     * @return Botón de edición de usuario.
     */
    public JButton getEditarButton() {
        return editarButton;
    }

    /**
     * Establece el botón para editar un usuario.
     * 
     * @param editarButton Nuevo botón de edición de usuario.
     */
    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    /**
     * Devuelve el botón para crear un usuario.
     * 
     * @return Botón de creación de usuario.
     */
    public JButton getCrearButton() {
        return crearButton;
    }

    /**
     * Establece el botón para crear un usuario.
     * 
     * @param crearButton Nuevo botón de creación de usuario.
     */
    public void setCrearButton(JButton crearButton) {
        this.crearButton = crearButton;
    }

    /**
     * Devuelve el botón para eliminar un usuario.
     * 
     * @return Botón de eliminación de usuario.
     */
    public JButton getEliminarButton() {
        return eliminarButton;
    }

    /**
     * Establece el botón para eliminar un usuario.
     * 
     * @param eliminarButton Nuevo botón de eliminación de usuario.
     */
    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }
}