package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class ProveedorNombre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveedorNombre frame = new ProveedorNombre();
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
	public ProveedorNombre() {
		setTitle("Consulta de Proveedores por nombre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeElNombre = new JLabel("Escribe el nombre o parte del nombre");
		lblEscribeElNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeElNombre.setBounds(58, 35, 326, 26);
		contentPane.add(lblEscribeElNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(396, 35, 116, 26);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar Proveedor");
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(524, 35, 285, 25);
		contentPane.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(227, 100, 385, 26);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(227, 158, 385, 263);
		contentPane.add(textPane);
	}

}
