package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Representa el panel lateral del administrador, proporcionando accesos directos a las diferentes funcionalidades del sistema.
 * Este panel incluye botones para gestionar usuarios, equipos, torneos, partidas, reportes y notificaciones, así como para ir al inicio o cerrar sesión.
 */
public class PanelLateralAdmin extends JPanel {

    private JButton gestionarTorneoBtn;
    private JButton gestionarEquipoBtn;
    private JButton gestionarUsuarioBtn;
    private JButton gestionarPartidaBtn;
    private JButton analisisReportesBtn;
    private JButton moduloNotificacionesBtn;
    private JButton inicioBtn;
    private JButton cerrarSesionBtn;

    /**
     * Constructor que configura el diseño y apariencia general del panel lateral y llama al método de inicialización de componentes.
     */
    public PanelLateralAdmin() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(180, getHeight()));
        inicializarComponentes();
    }

    /**
     * Inicializa y agrega los componentes gráficos al panel, incluyendo el logo y los botones de acceso rápido.
     */
    private void inicializarComponentes() {
        // Carga y muestra el logo
        File archivo = new File("img/yo.jpg");
        ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());
        Image imgEscalada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(imgEscalada));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(logoLabel);

        // Inicialización de botones
        gestionarUsuarioBtn = crearBoton("Usuarios", "GESTIONAR_USUARIOS");
        gestionarEquipoBtn = crearBoton("Equipos", "GESTIONAR_EQUIPOS");
        gestionarTorneoBtn = crearBoton("Torneos", "GESTIONAR_TORNEOS");
        gestionarPartidaBtn = crearBoton("Partidas", "GESTIONAR_PARTIDAS");
        analisisReportesBtn = crearBoton("Análisis / Reportes", "ANALISIS_REPORTES");
        moduloNotificacionesBtn = crearBoton("Notificaciones", "MODULO_NOTIFICACIONES");
        inicioBtn = crearBoton("Inicio", "IR_A_INICIO");
        cerrarSesionBtn = crearBoton("Cerrar sesión", "CERRAR_SESION");

        // Agregar botones con espaciado
        add(gestionarUsuarioBtn);
        add(Box.createVerticalStrut(10));
        add(gestionarEquipoBtn);
        add(Box.createVerticalStrut(10));
        add(gestionarTorneoBtn);
        add(Box.createVerticalStrut(10));
        add(gestionarPartidaBtn);
        add(Box.createVerticalStrut(10));
        add(analisisReportesBtn);
        add(Box.createVerticalStrut(10));
        add(moduloNotificacionesBtn);
        add(Box.createVerticalGlue());
        add(inicioBtn);
        add(Box.createVerticalStrut(10));
        add(cerrarSesionBtn);
    }

    /**
     * Método auxiliar para crear un botón con un texto y un comando de acción.
     *
     * @param texto Texto visible en el botón.
     * @param actionCommand Comando de acción asociado al botón.
     * @return {@code JButton} creado y configurado.
     */
    private JButton crearBoton(String texto, String actionCommand) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setMaximumSize(new Dimension(160, 30));
        boton.setActionCommand(actionCommand);
        boton.setFocusPainted(false);
        boton.setBackground(Color.WHITE);
        boton.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        boton.setMargin(new Insets(5, 5, 5, 5));
        boton.setFocusable(false);
        boton.setPreferredSize(new Dimension(160, 30));
        return boton;
    }

    // Métodos de acceso a los componentes del panel

    public JButton getGestionarTorneoBtn() { return gestionarTorneoBtn; }
    public JButton getGestionarEquipoBtn() { return gestionarEquipoBtn; }
    public JButton getGestionarUsuarioBtn() { return gestionarUsuarioBtn; }
    public JButton getGestionarPartidaBtn() { return gestionarPartidaBtn; }
    public JButton getAnalisisReportesBtn() { return analisisReportesBtn; }
    public JButton getModuloNotificacionesBtn() { return moduloNotificacionesBtn; }
    public JButton getInicioBtn() { return inicioBtn; }
    public JButton getCerrarSesionBtn() { return cerrarSesionBtn; }
}