package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * {@code PanelInferior} es un panel gráfico que contiene los botones principales
 * de acciones administrativas para la gestión de usuarios, como crear, editar y eliminar.
 * 
 * Esta clase forma parte de la interfaz de usuario del módulo de administración y
 * es utilizada normalmente en la parte inferior de una ventana o sección administrativa.
 * 
 * Cada botón tiene asociado un comando de acción que debe ser gestionado desde el controlador.
 * 
 * <p>Responsabilidades:
 * <ul>
 *   <li>Mostrar los botones de acción: Crear, Editar y Eliminar.</li>
 *   <li>Delegar el control de eventos al controlador externo.</li>
 * </ul>
 * </p>
 * 
 * @author
 */
public class PanelInferior extends JPanel {

    private JButton crearButton, editarButton, eliminarButton;

    /**
     * Crea una instancia del panel inferior con disposición de botones alineada a la derecha
     * y con fondo gris claro.
     */
    public PanelInferior() {
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }

    /**
     * Inicializa y agrega los botones de acción al panel.
     */
    private void inicializarComponentes() {
        crearButton = new JButton("Crear nuevo usuario");
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
     * @return el botón para crear un nuevo usuario.
     */
    public JButton getCrearButton() {
        return crearButton;
    }

    /**
     * @param crearButton botón para crear un nuevo usuario.
     */
    public void setCrearButton(JButton crearButton) {
        this.crearButton = crearButton;
    }

    /**
     * @return el botón para editar un usuario.
     */
    public JButton getEditarButton() {
        return editarButton;
    }

    /**
     * @param editarButton botón para editar un usuario.
     */
    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    /**
     * @return el botón para eliminar un usuario.
     */
    public JButton getEliminarButton() {
        return eliminarButton;
    }

    /**
     * @param eliminarButton botón para eliminar un usuario.
     */
    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }
}
