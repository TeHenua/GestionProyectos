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

public class VPiezas extends JFrame {

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
					VPiezas frame = new VPiezas();
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
	public VPiezas() {
		setTitle("Gesti\u00F3n de Piezas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(16, 11, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Gesti\u00F3n de Piezas", null, panel, null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setBounds(12, 25, 829, 16);
		panel.add(label);
		
		JLabel lblCdigoDePiezas = new JLabel("C\u00F3digo de pieza");
		lblCdigoDePiezas.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDePiezas.setBounds(195, 112, 194, 26);
		panel.add(lblCdigoDePiezas);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(401, 112, 116, 26);
		panel.add(textField);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(195, 151, 126, 26);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(401, 151, 275, 26);
		panel.add(textField_1);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPrecio.setBounds(195, 190, 126, 26);
		panel.add(lblPrecio);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(401, 190, 275, 26);
		panel.add(textField_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcin.setBounds(195, 229, 126, 26);
		panel.add(lblDescripcin);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(401, 229, 275, 26);
		panel.add(textField_3);
		
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
		tabbedPane.addTab("Listado de Piezas", null, panel_1, null);
		
		JLabel lblListaDePiezas = new JLabel("LISTA DE PIEZAS");
		lblListaDePiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePiezas.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDePiezas.setBounds(12, 29, 829, 16);
		panel_1.add(lblListaDePiezas);
		
		JLabel label_6 = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		label_6.setBounds(12, 60, 829, 16);
		panel_1.add(label_6);
		
		JLabel lblCdigoDePieza = new JLabel("C\u00F3digo de pieza");
		lblCdigoDePieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDePieza.setBounds(189, 117, 194, 26);
		panel_1.add(lblCdigoDePieza);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(395, 117, 116, 26);
		panel_1.add(textField_4);
		
		JLabel label_8 = new JLabel("Nombre");
		label_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_8.setBounds(189, 156, 126, 26);
		panel_1.add(label_8);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(395, 156, 275, 26);
		panel_1.add(textField_5);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPrecio_1.setBounds(189, 195, 126, 26);
		panel_1.add(lblPrecio_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(395, 195, 275, 26);
		panel_1.add(textField_6);
		
		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcin_1.setBounds(189, 234, 126, 26);
		panel_1.add(lblDescripcin_1);
		
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
