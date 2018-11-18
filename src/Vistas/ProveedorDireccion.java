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

public class ProveedorDireccion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveedorDireccion frame = new ProveedorDireccion();
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
	public ProveedorDireccion() {
		setTitle("Consulta de Proveedores por direcci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeLaDireccin = new JLabel("Escribe la direcci\u00F3n o parte de ella");
		lblEscribeLaDireccin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeLaDireccin.setBounds(36, 32, 351, 26);
		contentPane.add(lblEscribeLaDireccin);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(399, 32, 116, 26);
		contentPane.add(textField);
		
		JButton button = new JButton("Buscar Proveedor");
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(527, 32, 285, 25);
		contentPane.add(button);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(230, 97, 385, 26);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(230, 155, 385, 263);
		contentPane.add(textPane);
	}

}
