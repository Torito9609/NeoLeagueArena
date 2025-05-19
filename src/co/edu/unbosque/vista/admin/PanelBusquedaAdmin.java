package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Representa un panel gráfico para la vista del administrador, permitiendo la búsqueda y filtrado de usuarios.
 * Los criterios de búsqueda incluyen nombre, cédula, correo, tipo de usuario, país y ciudad.
 * 
 * Este panel es pasivo y está diseñado para ser controlado externamente, sin contener lógica de negocio.
 */
public class PanelBusquedaAdmin extends JPanel {

    private JComboBox<String> buscarPorComboBox, filtroComboBox, tipoUsuarioComboBox, paisComboBox, ciudadComboBox;
    private JButton buscarButton, limpiarFiltrosButton;
    private JTextField buscarTextField;
    private JPanel panelFiltrosDinamico;

    /**
     * Constructor que inicializa el panel con su disposición y componentes visuales.
     */
    public PanelBusquedaAdmin() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setBackground(Color.LIGHT_GRAY);

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos base del panel de búsqueda.
     */
    private void inicializarComponentes() {
        buscarPorComboBox = new JComboBox<>(new String[]{"Seleccionar", "Nombre", "Cedula", "Correo"});
        buscarTextField = new JTextField(20);
        buscarButton = new JButton("Buscar");
        buscarButton.setActionCommand("BUSCAR");

        limpiarFiltrosButton = new JButton("Limpiar filtros");
        limpiarFiltrosButton.setActionCommand("LIMPIAR_FILTROS");

        add(new JLabel("Buscar por:"));
        add(buscarPorComboBox);
        add(buscarTextField);
        add(buscarButton);
        add(limpiarFiltrosButton);

        filtroComboBox = new JComboBox<>(new String[]{"Seleccionar", "Tipo Usuario", "Pais", "Ciudad"});
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
    public void mostrarFiltroPais(ArrayList<String> paises) {
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

    // Métodos de acceso a los componentes gráficos

    public JComboBox<String> getBuscarPorComboBox() { return buscarPorComboBox; }
    public JComboBox<String> getFiltroComboBox() { return filtroComboBox; }
    public JComboBox<String> getTipoUsuarioComboBox() { return tipoUsuarioComboBox; }
    public JComboBox<String> getPaisComboBox() { return paisComboBox; }
    public JComboBox<String> getCiudadComboBox() { return ciudadComboBox; }
    public JButton getBuscarButton() { return buscarButton; }
    public JButton getLimpiarFiltrosButton() { return limpiarFiltrosButton; }
    public JTextField getBuscarTextField() { return buscarTextField; }
    public JPanel getPanelFiltrosDinamico() { return panelFiltrosDinamico; }
}