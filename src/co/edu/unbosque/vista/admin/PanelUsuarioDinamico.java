package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;

/**
 * Representa un panel dinámico para la gestión de usuarios en la interfaz de administración.
 * Utiliza un `CardLayout` para cambiar entre diferentes vistas dependiendo del tipo de usuario seleccionado.
 */
public class PanelUsuarioDinamico extends JPanel {

    private CardLayout cardLayout;
    private JPanel panelCentro;
    private JButton crearButton, cancelarButton, editarButton;

    /**
     * Constructor que inicializa el panel y sus botones de acción.
     */
    public PanelUsuarioDinamico() {
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        panelCentro = new JPanel(cardLayout);
        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        crearButton = new JButton("Crear");
        crearButton.setActionCommand("CREAR_GUARDAR_USUARIO");
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setActionCommand("CANCELAR_GUARDAR_USUARIO");
        editarButton = new JButton("Editar");
        editarButton.setActionCommand("EDITAR_GUARDAR_USUARIO");
        panelBotones.add(crearButton);
        panelBotones.add(cancelarButton);
        panelBotones.add(editarButton);
        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Muestra el panel correspondiente al tipo de usuario seleccionado.
     *
     * @param tipoUsuario Tipo de usuario cuya vista debe mostrarse.
     */
    public void mostrarPanel(String tipoUsuario) {
        JPanel nuevoPanel = FabricaPanelUsuarioDinamico.crearPanel(tipoUsuario);
        panelCentro.removeAll();
        panelCentro.add(nuevoPanel, "panel");
        cardLayout.show(panelCentro, "panel");
        revalidate();
        repaint();
    }

    /**
     * Obtiene el panel actualmente visible en la interfaz.
     *
     * @return El panel activo, o {@code null} si no hay panel visible.
     */
    public JPanel getPanelActual() {
        for (Component comp : panelCentro.getComponents()) {
            if (comp.isVisible()) {
                return (JPanel) comp;
            }
        }
        return null;
    }

    // Métodos de acceso a los atributos del panel dinámico

    public CardLayout getCardLayout() { return cardLayout; }
    public void setCardLayout(CardLayout cardLayout) { this.cardLayout = cardLayout; }

    public JPanel getPanelCentro() { return panelCentro; }
    public void setPanelCentro(JPanel panelCentro) { this.panelCentro = panelCentro; }

    public JButton getCrearButton() { return crearButton; }
    public void setCrearButton(JButton crearButton) { this.crearButton = crearButton; }

    public JButton getCancelarButton() { return cancelarButton; }
    public void setCancelarButton(JButton cancelarButton) { this.cancelarButton = cancelarButton; }

    public JButton getEditarButton() { return editarButton; }
    public void setEditarButton(JButton editarButton) { this.editarButton = editarButton; }
}