package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class Proveedores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proveedores frame = new Proveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Proveedores() {
		setTitle("Gesti\u00F3n de Proveedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Gesti\u00F3n de Proveedores", null, panel, null);
		panel.setLayout(null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 25, 829, 16);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo de proveedor");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(195, 112, 194, 26);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setBounds(401, 112, 116, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNombre.setBounds(195, 151, 126, 26);
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(401, 151, 275, 26);
		panel.add(textField_1);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblApellidos.setBounds(195, 190, 126, 26);
		panel.add(lblApellidos);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(401, 190, 275, 26);
		panel.add(textField_2);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDireccin.setBounds(195, 229, 126, 26);
		panel.add(lblDireccin);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(401, 229, 275, 26);
		panel.add(textField_3);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnLimpiar.setBounds(195, 307, 116, 25);
		panel.add(btnLimpiar);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnInsertar.setBounds(323, 307, 105, 25);
		panel.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnModificar.setBounds(440, 307, 116, 25);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEliminar.setBounds(568, 307, 108, 25);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Listado de Proveedores", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblListaDeProveedores = new JLabel("LISTA DE PROVEEDORES ");
		lblListaDeProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProveedores.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDeProveedores.setBounds(12, 29, 829, 16);
		panel_1.add(lblListaDeProveedores);
		
		JLabel lblUtilizaLosBotones = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		lblUtilizaLosBotones.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilizaLosBotones.setFont(new Font("Verdana", Font.BOLD, 15));
		lblUtilizaLosBotones.setBounds(12, 60, 829, 16);
		panel_1.add(lblUtilizaLosBotones);
		
		JLabel label_1 = new JLabel("C\u00F3digo de proveedor");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_1.setBounds(189, 117, 194, 26);
		panel_1.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(395, 117, 116, 26);
		panel_1.add(textField_4);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(189, 156, 126, 26);
		panel_1.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(395, 156, 275, 26);
		panel_1.add(textField_5);
		
		JLabel label_3 = new JLabel("Apellidos");
		label_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_3.setBounds(189, 195, 126, 26);
		panel_1.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(395, 195, 275, 26);
		panel_1.add(textField_6);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_4.setBounds(189, 234, 126, 26);
		panel_1.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(395, 234, 275, 26);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(189, 273, 43, 26);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(279, 273, 43, 26);
		panel_1.add(textField_9);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDe.setBounds(244, 273, 32, 26);
		panel_1.add(lblDe);
		
		JButton button = new JButton("|<<");
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(334, 273, 71, 25);
		panel_1.add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_1.setBounds(417, 273, 71, 25);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton(">>");
		button_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_2.setBounds(516, 273, 71, 25);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton(">>|");
		button_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_3.setBounds(599, 273, 71, 25);
		panel_1.add(button_3);
		
		JButton btnEjecutarConsultla = new JButton("Ejecutar consulta");
		btnEjecutarConsultla.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEjecutarConsultla.setBounds(189, 311, 377, 25);
		panel_1.add(btnEjecutarConsultla);
		
		JButton btnBaja = new JButton("Baja");
		btnBaja.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBaja.setBounds(578, 311, 92, 25);
		panel_1.add(btnBaja);
	}
}
