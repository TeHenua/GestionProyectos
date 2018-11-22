package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectos frame = new VProyectos();
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
	public VProyectos() {
		setTitle("Gesti\u00F3n de Proyectos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Gesti\u00F3n de Proyectos", null, panel, null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setBounds(12, 25, 829, 16);
		panel.add(label);
		
		JLabel lblCdigoDeProyecto = new JLabel("C\u00F3digo de proyecto");
		lblCdigoDeProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDeProyecto.setBounds(195, 115, 194, 26);
		panel.add(lblCdigoDeProyecto);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(401, 112, 116, 26);
		panel.add(textField);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(195, 175, 126, 26);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(401, 175, 275, 26);
		panel.add(textField_1);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCiudad.setBounds(195, 238, 126, 26);
		panel.add(lblCiudad);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(401, 238, 275, 26);
		panel.add(textField_2);
		
		JButton button = new JButton("Limpiar");
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(195, 307, 116, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("Insertar");
		button_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_1.setBounds(323, 307, 105, 25);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Modificar");
		button_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_2.setBounds(440, 307, 116, 25);
		panel.add(button_2);
		
		JButton button_3 = new JButton("Eliminar");
		button_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_3.setBounds(568, 307, 108, 25);
		panel.add(button_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Listado de Proyectos", null, panel_1, null);
		
		JLabel lblListaDeProyectos = new JLabel("LISTA DE PROYECTOS ");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDeProyectos.setBounds(12, 29, 829, 16);
		panel_1.add(lblListaDeProyectos);
		
		JLabel label_6 = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		label_6.setBounds(12, 60, 829, 16);
		panel_1.add(label_6);
		
		JLabel lblCdigoDeProyecto_1 = new JLabel("C\u00F3digo de proyecto");
		lblCdigoDeProyecto_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDeProyecto_1.setBounds(189, 115, 194, 26);
		panel_1.add(lblCdigoDeProyecto_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(395, 115, 116, 26);
		panel_1.add(textField_4);
		
		JLabel label_8 = new JLabel("Nombre");
		label_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_8.setBounds(189, 170, 126, 26);
		panel_1.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(395, 170, 275, 26);
		panel_1.add(textField_5);
		
		JLabel lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCiudad_1.setBounds(189, 225, 126, 26);
		panel_1.add(lblCiudad_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(395, 225, 275, 26);
		panel_1.add(textField_6);
		
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
		
		JLabel label_11 = new JLabel("de");
		label_11.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_11.setBounds(244, 273, 32, 26);
		panel_1.add(label_11);
		
		JButton button_4 = new JButton("|<<");
		button_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_4.setBounds(334, 273, 71, 25);
		panel_1.add(button_4);
		
		JButton button_5 = new JButton("<<");
		button_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_5.setBounds(417, 273, 71, 25);
		panel_1.add(button_5);
		
		JButton button_6 = new JButton(">>");
		button_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_6.setBounds(516, 273, 71, 25);
		panel_1.add(button_6);
		
		JButton button_7 = new JButton(">>|");
		button_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_7.setBounds(599, 273, 71, 25);
		panel_1.add(button_7);
		
		JButton button_8 = new JButton("Ejecutar consulta");
		button_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_8.setBounds(189, 311, 481, 25);
		panel_1.add(button_8);
	}

}
