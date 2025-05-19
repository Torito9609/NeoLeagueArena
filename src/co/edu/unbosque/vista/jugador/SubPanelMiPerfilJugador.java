package co.edu.unbosque.vista.jugador;

import co.edu.unbosque.modelo.dto.JugadorDto;
import co.edu.unbosque.modelo.enums.NivelCompetitivoJugador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Panel gráfico que permite a un jugador visualizar y editar su perfil dentro del sistema NeoLeague Arena.
 * <p>
 * Incluye campos de entrada para datos personales (nombres, correo, país, etc.), 
 * configuración de nivel competitivo y gamer tag, así como la posibilidad de 
 * seleccionar y previsualizar una foto de perfil.
 * <p>
 * Este panel se usa dentro de la vista principal del jugador y permite tanto 
 * cargar datos desde un {@link JugadorDto} como recolectarlos para su posterior guardado.
 */
public class SubPanelMiPerfilJugador extends JPanel {
	private JLabel lblFotoPerfilGrande;
	private JButton btnSeleccionarFoto;
	private File archivoFotoSeleccionada;

	private JTextField txtId;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtCorreo;
	private JTextField txtCelular;
	private JTextField txtPais;
	private JTextField txtCiudad;
	private JTextField txtFechaNacimiento;
	private JComboBox<String> comboZonaHoraria;

	private JTextField txtGamerTag;
	private JComboBox<NivelCompetitivoJugador> comboNivelCompetitivo;
	private JLabel lblRankingPuntos;

	private JButton btnGuardarCambiosPerfil;

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
	
	/**
	 * Constructor que inicializa y organiza todos los componentes gráficos del formulario de perfil del jugador.
	 * Configura el diseño del formulario, el panel de imagen, los campos de entrada y el botón de guardado.
	 */
	public SubPanelMiPerfilJugador() {
		setLayout(new BorderLayout(15, 15));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBackground(Color.WHITE);

		JPanel panelLateralFoto = new JPanel(new BorderLayout(10, 10));
		panelLateralFoto.setPreferredSize(new Dimension(180, 200));
		lblFotoPerfilGrande = new JLabel("Sin foto", SwingConstants.CENTER);
		lblFotoPerfilGrande.setPreferredSize(new Dimension(150, 150));
		lblFotoPerfilGrande.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		mostrarPrevisualizacionFoto(null);
		btnSeleccionarFoto = new JButton("Cambiar Foto");
		btnSeleccionarFoto.setActionCommand("SELECCIONAR_FOTO_JUGADOR");
		panelLateralFoto.add(lblFotoPerfilGrande, BorderLayout.CENTER);
		panelLateralFoto.add(btnSeleccionarFoto, BorderLayout.SOUTH);
		add(panelLateralFoto, BorderLayout.WEST);

		JPanel panelFormulario = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		int fila = 0;

		gbc.gridx = 0;
		gbc.gridy = fila;
		gbc.weightx = 0.2;
		panelFormulario.add(new JLabel("ID Usuario:"), gbc);
		gbc.gridx = 1;
		gbc.weightx = 0.8;
		txtId = new JTextField(20);
		txtId.setEditable(false);
		panelFormulario.add(txtId, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("GamerTag:"), gbc);
		gbc.gridx = 1;
		txtGamerTag = new JTextField(20);
		panelFormulario.add(txtGamerTag, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Nombres:"), gbc);
		gbc.gridx = 1;
		txtNombres = new JTextField(20);
		panelFormulario.add(txtNombres, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Apellidos:"), gbc);
		gbc.gridx = 1;
		txtApellidos = new JTextField(20);
		panelFormulario.add(txtApellidos, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Correo Electrónico:"), gbc);
		gbc.gridx = 1;
		txtCorreo = new JTextField(20);
		panelFormulario.add(txtCorreo, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Celular:"), gbc);
		gbc.gridx = 1;
		txtCelular = new JTextField(20);
		panelFormulario.add(txtCelular, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("País:"), gbc);
		gbc.gridx = 1;
		txtPais = new JTextField(20);
		panelFormulario.add(txtPais, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Ciudad:"), gbc);
		gbc.gridx = 1;
		txtCiudad = new JTextField(20);
		panelFormulario.add(txtCiudad, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"), gbc);
		gbc.gridx = 1;
		txtFechaNacimiento = new JTextField(10);
		panelFormulario.add(txtFechaNacimiento, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Zona Horaria:"), gbc);
		gbc.gridx = 1;
		comboZonaHoraria = new JComboBox<>(
				new String[] { "GMT-5 (Bogotá)", "GMT-6 (CDMX)", "GMT-3 (Buenos Aires)", "Otra" });
		panelFormulario.add(comboZonaHoraria, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Nivel Competitivo:"), gbc);
		gbc.gridx = 1;
		comboNivelCompetitivo = new JComboBox<>(NivelCompetitivoJugador.values());
		panelFormulario.add(comboNivelCompetitivo, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		panelFormulario.add(new JLabel("Puntos de Ranking:"), gbc);
		gbc.gridx = 1;
		lblRankingPuntos = new JLabel("0");
		panelFormulario.add(lblRankingPuntos, gbc);
		fila++;

		gbc.gridx = 0;
		gbc.gridy = fila;
		gbc.gridwidth = 2;
		gbc.weighty = 1.0;
		panelFormulario.add(new JLabel(" "), gbc);

		JScrollPane scrollFormulario = new JScrollPane(panelFormulario);
		scrollFormulario.setBorder(BorderFactory.createEmptyBorder());
		add(scrollFormulario, BorderLayout.CENTER);

		btnGuardarCambiosPerfil = new JButton("Guardar Cambios de Perfil");
		btnGuardarCambiosPerfil.setActionCommand("GUARDAR_PERFIL_JUGADOR");
		JPanel panelBotonGuardar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelBotonGuardar.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotonGuardar.add(btnGuardarCambiosPerfil);
		add(panelBotonGuardar, BorderLayout.SOUTH);

		btnSeleccionarFoto.addActionListener(e -> seleccionarNuevaFoto());
	}
	
	/**
	 * Lanza un selector de archivos que permite al jugador elegir una nueva foto de perfil.
	 * La imagen seleccionada se previsualiza en el panel lateral.
	 */
	private void seleccionarNuevaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Seleccionar Foto de Perfil");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes (JPG, PNG, GIF)", "jpg", "jpeg", "png",
				"gif");
		fileChooser.addChoosableFileFilter(filter);
		int resultado = fileChooser.showOpenDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			archivoFotoSeleccionada = fileChooser.getSelectedFile();
			mostrarPrevisualizacionFoto(archivoFotoSeleccionada.getAbsolutePath());
		}
	}
	
	/**
	 * Muestra una imagen previsualizada en el panel lateral a partir de una ruta de archivo.
	 * Si no se proporciona una ruta válida, muestra un ícono de marcador de posición.
	 *
	 * @param rutaFoto ruta absoluta del archivo de imagen, o {@code null} para mostrar un ícono por defecto.
	 */
	public void mostrarPrevisualizacionFoto(String rutaFoto) {
		ImageIcon icono;
		if (rutaFoto != null && !rutaFoto.isEmpty() && new File(rutaFoto).exists()) {
			icono = new ImageIcon(rutaFoto);
		} else {
			icono = createPlaceholderIcon(150, 150, "Perfil");
		}
		if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
			Image img = icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			lblFotoPerfilGrande.setIcon(new ImageIcon(img));
			lblFotoPerfilGrande.setText("");
		} else {
			lblFotoPerfilGrande.setIcon(createPlaceholderIcon(150, 150, "Error"));
			lblFotoPerfilGrande.setText("");
		}
	}
	
	/**
	 * Crea una imagen de marcador de posición con un texto personalizado para representar
	 * visualmente estados como "sin foto" o "error de carga".
	 *
	 * @param width  ancho del icono
	 * @param height alto del icono
	 * @param text   texto a mostrar en el marcador
	 * @return {@link ImageIcon} con el contenido renderizado
	 */
	private ImageIcon createPlaceholderIcon(int width, int height, String text) {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawRect(0, 0, width - 1, height - 1);
		g2d.setFont(new Font("Arial", Font.BOLD, 14));
		FontMetrics fm = g2d.getFontMetrics();
		int x = (width - fm.stringWidth(text)) / 2;
		int y = (fm.getAscent() + (height - (fm.getAscent() + fm.getDescent())) / 2);
		g2d.drawString(text, x, y);
		g2d.dispose();
		return new ImageIcon(image);
	}
	
	/**
	 * Carga los datos de un {@link JugadorDto} en los campos del formulario.
	 * Si se pasa {@code null}, limpia el formulario.
	 *
	 * @param jugadorDto objeto con los datos del jugador
	 */
	public void cargarDatosPerfil(JugadorDto jugadorDto) {
		if (jugadorDto == null) { // Limpiar el formulario
			txtId.setText("");
			txtGamerTag.setText("");
			txtNombres.setText("");
			txtApellidos.setText("");
			txtCorreo.setText("");
			txtCelular.setText("");
			txtPais.setText("");
			txtCiudad.setText("");
			txtFechaNacimiento.setText(""); // Reintroducido
			comboZonaHoraria.setSelectedIndex(-1); // -1 para ningún ítem seleccionado si es posible
			comboNivelCompetitivo.setSelectedIndex(-1);
			lblRankingPuntos.setText("0");
			mostrarPrevisualizacionFoto(null);
			this.archivoFotoSeleccionada = null;
			return;
		}
		txtId.setText(jugadorDto.getId() != null ? jugadorDto.getId() : "");
		txtGamerTag.setText(jugadorDto.getGamerTag() != null ? jugadorDto.getGamerTag() : "");
		txtNombres.setText(jugadorDto.getNombres() != null ? jugadorDto.getNombres() : "");
		txtApellidos.setText(jugadorDto.getApellidos() != null ? jugadorDto.getApellidos() : "");
		txtCorreo.setText(jugadorDto.getCorreo() != null ? jugadorDto.getCorreo() : "");
		txtCelular.setText(jugadorDto.getCelular() != null ? jugadorDto.getCelular() : "");
		txtPais.setText(jugadorDto.getPais() != null ? jugadorDto.getPais() : "");
		txtCiudad.setText(jugadorDto.getCiudad() != null ? jugadorDto.getCiudad() : "");
		txtFechaNacimiento.setText(
				jugadorDto.getFechaNacimiento() != null ? jugadorDto.getFechaNacimiento().format(dateFormatter) : ""); // Reintroducido
		comboZonaHoraria.setSelectedItem(jugadorDto.getZonaHoraria());
		comboNivelCompetitivo.setSelectedItem(jugadorDto.getNivelCompetitivo());
		lblRankingPuntos.setText(String.valueOf(jugadorDto.getRankingPuntos()));
		mostrarPrevisualizacionFoto(jugadorDto.getRutaFoto());
		this.archivoFotoSeleccionada = null;
	}
	
	/**
	 * Extrae los datos actuales del formulario y los encapsula en un nuevo {@link JugadorDto},
	 * que puede ser utilizado para guardar los cambios realizados por el jugador.
	 *
	 * @return DTO con los datos actuales del formulario
	 */
	public JugadorDto obtenerDatosParaGuardar() {
		JugadorDto datosNuevos = new JugadorDto();
		// El ID se mantiene del jugador actual, no se toma del campo editable (o no
		// editable)
		// datosNuevos.setId(txtId.getText());
		datosNuevos.setGamerTag(txtGamerTag.getText());
		datosNuevos.setNombres(txtNombres.getText());
		datosNuevos.setApellidos(txtApellidos.getText());
		datosNuevos.setCorreo(txtCorreo.getText());
		datosNuevos.setCelular(txtCelular.getText());
		datosNuevos.setPais(txtPais.getText());
		datosNuevos.setCiudad(txtCiudad.getText());
		try { // Reintroducido
			if (!txtFechaNacimiento.getText().trim().isEmpty()) {
				datosNuevos.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText(), dateFormatter));
			}
		} catch (DateTimeParseException e) {
			System.err
					.println("Formato de fecha inválido: " + txtFechaNacimiento.getText() + ". Se guardará como null.");
			datosNuevos.setFechaNacimiento(null);
		}
		datosNuevos.setZonaHoraria(
				comboZonaHoraria.getSelectedItem() != null ? comboZonaHoraria.getSelectedItem().toString() : null);
		datosNuevos.setNivelCompetitivo((NivelCompetitivoJugador) comboNivelCompetitivo.getSelectedItem());
		// RankingPuntos y rutaFoto se manejan por separado o vienen del DTO original.
		return datosNuevos;
	}

	// Getters
	public JButton getBtnSeleccionarFoto() {
		return btnSeleccionarFoto;
	}

	public JButton getBtnGuardarCambiosPerfil() {
		return btnGuardarCambiosPerfil;
	}

	public JTextField getTxtGamerTag() {
		return txtGamerTag;
	}

	public JTextField getTxtNombres() {
		return txtNombres;
	}

	public JTextField getTxtApellidos() {
		return txtApellidos;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public JTextField getTxtCelular() {
		return txtCelular;
	}

	public JTextField getTxtPais() {
		return txtPais;
	}

	public JTextField getTxtCiudad() {
		return txtCiudad;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	} // Reintroducido

	public JComboBox<String> getComboZonaHoraria() {
		return comboZonaHoraria;
	}

	public JComboBox<NivelCompetitivoJugador> getComboNivelCompetitivo() {
		return comboNivelCompetitivo;
	}

	public JLabel getLblRankingPuntos() {
		return lblRankingPuntos;
	}

	public File getArchivoFotoSeleccionada() {
		return archivoFotoSeleccionada;
	}

	public JLabel getLblFotoPerfilGrande() {
		return lblFotoPerfilGrande;
	}

	public JTextField getTxtId() {
		return txtId;
	}
}