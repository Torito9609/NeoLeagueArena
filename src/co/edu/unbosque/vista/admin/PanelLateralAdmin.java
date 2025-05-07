package co.edu.unbosque.vista.admin;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Clase que representa el panel lateral del administrador, el cual contiene
 * accesos directos a las diferentes funcionalidades del sistema.
 * Este panel incluye botones para gestionar usuarios, equipos, torneos,
 * partidas, reportes, notificaciones, así como para ir al inicio o cerrar sesión.
 * 
 * @author Kevin Andres Toro Moreno
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
     * Constructor que configura el diseño y apariencia general del panel,
     * y llama al método de inicialización de componentes.
     */
    public PanelLateralAdmin() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(180, getHeight()));
        inicializarComponentes();
    }

    /**
     * Inicializa y agrega los componentes gráficos al panel, incluyendo el logo
     * y todos los botones funcionales del menú lateral.
     */
    private void inicializarComponentes() {
        // Foto
        File archivo = new File("img/yo.jpg");
        ImageIcon icono = new ImageIcon(archivo.getAbsolutePath());

        Image imgEscalada = icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(imgEscalada));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(logoLabel);

        // Botones
        gestionarUsuarioBtn = crearBoton("Usuarios", "GESTIONAR_USUARIOS");
        gestionarEquipoBtn = crearBoton("Equipos", "GESTIONAR_EQUIPOS");
        gestionarTorneoBtn = crearBoton("Torneos", "GESTIONAR_TORNEOS");
        gestionarPartidaBtn = crearBoton("Partidas", "GESTIONAR_PARTIDAS");
        analisisReportesBtn = crearBoton("Análisis / Reportes", "ANALISIS_REPORTES");
        moduloNotificacionesBtn = crearBoton("Notificaciones", "MODULO_NOTIFICACIONES");
        inicioBtn = crearBoton("Inicio", "IR_A_INICIO");
        cerrarSesionBtn = crearBoton("Cerrar sesión", "CERRAR_SESION");

        // Agregar botones con espacio entre ellos
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
     * @param actionCommand Comando de acción para el botón.
     * @return JButton creado y configurado.
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

    // Getters y Setters con JavaDoc

    /** @return Botón para gestionar torneos. */
    public JButton getGestionarTorneoBtn() {
        return gestionarTorneoBtn;
    }

    /** @param gestionarTorneoBtn Botón para gestionar torneos. */
    public void setGestionarTorneoBtn(JButton gestionarTorneoBtn) {
        this.gestionarTorneoBtn = gestionarTorneoBtn;
    }

    /** @return Botón para gestionar equipos. */
    public JButton getGestionarEquipoBtn() {
        return gestionarEquipoBtn;
    }

    /** @param gestionarEquipoBtn Botón para gestionar equipos. */
    public void setGestionarEquipoBtn(JButton gestionarEquipoBtn) {
        this.gestionarEquipoBtn = gestionarEquipoBtn;
    }

    /** @return Botón para gestionar usuarios. */
    public JButton getGestionarUsuarioBtn() {
        return gestionarUsuarioBtn;
    }

    /** @param gestionarUsuarioBtn Botón para gestionar usuarios. */
    public void setGestionarUsuarioBtn(JButton gestionarUsuarioBtn) {
        this.gestionarUsuarioBtn = gestionarUsuarioBtn;
    }

    /** @return Botón para gestionar partidas. */
    public JButton getGestionarPartidaBtn() {
        return gestionarPartidaBtn;
    }

    /** @param gestionarPartidaBtn Botón para gestionar partidas. */
    public void setGestionarPartidaBtn(JButton gestionarPartidaBtn) {
        this.gestionarPartidaBtn = gestionarPartidaBtn;
    }

    /** @return Botón para análisis y reportes. */
    public JButton getAnalisisReportesBtn() {
        return analisisReportesBtn;
    }

    /** @param analisisReportesBtn Botón para análisis y reportes. */
    public void setAnalisisReportesBtn(JButton analisisReportesBtn) {
        this.analisisReportesBtn = analisisReportesBtn;
    }

    /** @return Botón para acceder al módulo de notificaciones. */
    public JButton getModuloNotificacionesBtn() {
        return moduloNotificacionesBtn;
    }

    /** @param moduloNotificacionesBtn Botón para el módulo de notificaciones. */
    public void setModuloNotificacionesBtn(JButton moduloNotificacionesBtn) {
        this.moduloNotificacionesBtn = moduloNotificacionesBtn;
    }

    /** @return Botón para volver al inicio. */
    public JButton getInicioBtn() {
        return inicioBtn;
    }

    /** @param inicioBtn Botón para volver al inicio. */
    public void setInicioBtn(JButton inicioBtn) {
        this.inicioBtn = inicioBtn;
    }

    /** @return Botón para cerrar sesión. */
    public JButton getCerrarSesionBtn() {
        return cerrarSesionBtn;
    }

    /** @param cerrarSesionBtn Botón para cerrar sesión. */
    public void setCerrarSesionBtn(JButton cerrarSesionBtn) {
        this.cerrarSesionBtn = cerrarSesionBtn;
    }
}
