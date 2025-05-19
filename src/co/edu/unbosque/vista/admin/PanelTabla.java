package co.edu.unbosque.vista.admin;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import co.edu.unbosque.modelo.dto.UsuarioDto;

/**
 * Representa un panel gráfico que contiene una tabla no editable para visualizar una lista de usuarios en la interfaz de administración.
 * La tabla muestra los siguientes datos por usuario: cédula, nombre, correo, rol, país y ciudad.
 * Permite actualizar dinámicamente su contenido mediante una lista de objetos {@link UsuarioDto}.
 * 
 * <p>Este panel está diseñado para ser utilizado en el módulo de administración del sistema, proporcionando un componente visual reutilizable
 * y desacoplado de la lógica de control.</p>
 */
public class PanelTabla extends JPanel {

    /** Tabla Swing que contiene la visualización de usuarios. */
    private JTable tablaUsuarios;

    /** Modelo de la tabla que maneja los datos mostrados en la interfaz. */
    private DefaultTableModel modeloTabla;

    /**
     * Constructor que configura el diseño del panel, establece sus bordes e inicializa los componentes gráficos.
     */
    public PanelTabla() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        inicializarComponentes();
    }

    /**
     * Inicializa los componentes gráficos del panel, incluyendo la tabla de usuarios con columnas predefinidas y comportamiento no editable.
     */
    private void inicializarComponentes() {
        String[] columnas = {"Cedula", "Nombre", "Correo", "Rol", "País", "Ciudad"};

        modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita edición directa de celdas.
            }
        };

        tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Actualiza el contenido de la tabla con una nueva lista de usuarios.
     * Elimina las filas actuales y las reemplaza con los datos proporcionados.
     * 
     * @param usuarios Lista de usuarios a mostrar en la tabla.
     */
    public void actualizarTabla(List<UsuarioDto> usuarios) {
        modeloTabla.setRowCount(0); // Limpia la tabla

        for (UsuarioDto usuario : usuarios) {
            Object[] fila = {
                usuario.getId(),
                usuario.getNombres(),
                usuario.getCorreo(),
                usuario.getTipoUsuario(),
                usuario.getPais(),
                usuario.getCiudad()
            };
            modeloTabla.addRow(fila);
        }
    }

    /**
     * Devuelve la tabla interna del panel, útil para acceder a propiedades o comportamientos específicos de JTable desde otros componentes.
     * 
     * @return La instancia de {@code JTable} usada en el panel.
     */
    public JTable getTablaUsuarios() {
        return tablaUsuarios;
    }
}