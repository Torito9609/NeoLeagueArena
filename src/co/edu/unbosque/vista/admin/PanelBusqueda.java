package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * PanelBusqueda representa un panel gráfico utilizado en la vista del administrador
 * para permitir la búsqueda y filtrado de usuarios por diferentes criterios como nombre,
 * cédula, correo, tipo de usuario, país y ciudad.
 *
 * Este panel es pasivo y está diseñado para ser controlado desde un controlador externo,
 * sin contener lógica de negocio.
 * 
 * @author Kevin Andres Toro Moreno
 */
public class PanelBusqueda extends JPanel {

    private JComboBox<String> buscarPorComboBox, filtroComboBox, tipoUsuarioComboBox, paisComboBox, ciudadComboBox;
    private JButton buscarButton, filtrarButton;
    private JTextField buscarTextField;
    private JPanel panelFiltrosDinamico;

    /**
     * Constructor que inicializa el panel con su disposición y componentes visuales.
     */
    public PanelBusqueda() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos base del panel de búsqueda.
     */
    private void inicializarComponentes() {
        buscarPorComboBox = new JComboBox<>(new String[]{"Seleccionar", "Nombre", "Cedula", "Correo"});
        buscarPorComboBox.setActionCommand("BUSCAR_POR");

        buscarTextField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        buscarButton.setActionCommand("BUSCAR");

        add(new JLabel("Buscar por:"));
        add(buscarPorComboBox);
        add(buscarTextField);
        add(buscarButton);

        filtroComboBox = new JComboBox<>(new String[]{"Seleccionar", "TipoUsuario", "Pais", "Ciudad"});
        filtroComboBox.setActionCommand("FILTRO_POR");

        add(new JLabel("Filtrar por:"));
        add(filtroComboBox);

        panelFiltrosDinamico = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelFiltrosDinamico.setOpaque(false);
        add(panelFiltrosDinamico);
    }

    /**
     * Muestra el filtro dinámico para seleccionar tipo de usuario.
     */
    public void mostrarFiltroPorTipo() {
        panelFiltrosDinamico.removeAll();
        tipoUsuarioComboBox = new JComboBox<>(new String[]{"Seleccionar", "Jugador", "Entrenador"});
        tipoUsuarioComboBox.setActionCommand("FILTRO_TIPO");
        panelFiltrosDinamico.add(tipoUsuarioComboBox);
        recargarPanel();
    }

    /**
     * Muestra el filtro dinámico de países usando los valores proporcionados.
     *
     * @param paises Lista de nombres de países.
     */
    public void mostrarFiltroPorPais(ArrayList<String> paises) {
        panelFiltrosDinamico.removeAll();
        paisComboBox = new JComboBox<>();
        paisComboBox.addItem("Seleccionar");
        for (String pais : paises) {
            paisComboBox.addItem(pais);
        }
        paisComboBox.setActionCommand("FILTRO_PAIS");
        panelFiltrosDinamico.add(paisComboBox);
        recargarPanel();
    }

    /**
     * Muestra el filtro dinámico de ciudades usando los valores proporcionados.
     *
     * @param ciudades Lista de nombres de ciudades.
     */
    public void mostrarFiltroCiudad(ArrayList<String> ciudades) {
        panelFiltrosDinamico.removeAll();
        ciudadComboBox = new JComboBox<>();
        ciudadComboBox.addItem("Seleccionar");
        for (String ciudad : ciudades) {
            ciudadComboBox.addItem(ciudad);
        }
        ciudadComboBox.setActionCommand("FILTRO_CIUDAD");
        panelFiltrosDinamico.add(ciudadComboBox);
        recargarPanel();
    }

    /**
     * Limpia el panel de filtros dinámicos.
     */
    public void limpiarFiltroDinamico() {
        panelFiltrosDinamico.removeAll();
        recargarPanel();
    }

    /**
     * Fuerza la actualización del panel de filtros dinámicos.
     */
    private void recargarPanel() {
        panelFiltrosDinamico.revalidate();
        panelFiltrosDinamico.repaint();
    }

    // Métodos getter y setter para los componentes gráficos:

    /**
     * @return ComboBox de opciones de búsqueda.
     */
    public JComboBox<String> getBuscarPorComboBox() {
        return buscarPorComboBox;
    }

    public void setBuscarPorComboBox(JComboBox<String> buscarPorComboBox) {
        this.buscarPorComboBox = buscarPorComboBox;
    }

    /**
     * @return ComboBox de opciones de filtrado.
     */
    public JComboBox<String> getFiltroComboBox() {
        return filtroComboBox;
    }

    public void setFiltroComboBox(JComboBox<String> filtroComboBox) {
        this.filtroComboBox = filtroComboBox;
    }

    /**
     * @return ComboBox de tipo de usuario (Jugador/Entrenador).
     */
    public JComboBox<String> getTipoUsuarioComboBox() {
        return tipoUsuarioComboBox;
    }

    public void setTipoUsuarioComboBox(JComboBox<String> tipoUsuarioComboBox) {
        this.tipoUsuarioComboBox = tipoUsuarioComboBox;
    }

    /**
     * @return ComboBox de países.
     */
    public JComboBox<String> getPaisComboBox() {
        return paisComboBox;
    }

    public void setPaisComboBox(JComboBox<String> paisComboBox) {
        this.paisComboBox = paisComboBox;
    }

    /**
     * @return ComboBox de ciudades.
     */
    public JComboBox<String> getCiudadComboBox() {
        return ciudadComboBox;
    }

    public void setCiudadComboBox(JComboBox<String> ciudadComboBox) {
        this.ciudadComboBox = ciudadComboBox;
    }

    /**
     * @return Botón para ejecutar la búsqueda.
     */
    public JButton getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(JButton buscarButton) {
        this.buscarButton = buscarButton;
    }

    /**
     * @return Botón para ejecutar el filtrado.
     */
    public JButton getFiltrarButton() {
        return filtrarButton;
    }

    public void setFiltrarButton(JButton filtrarButton) {
        this.filtrarButton = filtrarButton;
    }

    /**
     * @return Campo de texto para ingresar el valor de búsqueda.
     */
    public JTextField getBuscarTextField() {
        return buscarTextField;
    }

    public void setBuscarTextField(JTextField buscarTextField) {
        this.buscarTextField = buscarTextField;
    }

    /**
     * @return Panel que contiene los filtros dinámicos.
     */
    public JPanel getPanelFiltrosDinamico() {
        return panelFiltrosDinamico;
    }

    public void setPanelFiltrosDinamico(JPanel panelFiltrosDinamico) {
        this.panelFiltrosDinamico = panelFiltrosDinamico;
    }
}
