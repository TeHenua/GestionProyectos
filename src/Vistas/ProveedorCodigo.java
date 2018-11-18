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

public class ProveedorCodigo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProveedorCodigo frame = new ProveedorCodigo();
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
	public ProveedorCodigo() {
		setTitle("Consulta de Proveedores por c\u00F3digo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeElCdigo = new JLabel("Escribe el c\u00F3digo o parte del c\u00F3digo");
		lblEscribeElCdigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeElCdigo.setBounds(57, 35, 326, 26);
		contentPane.add(lblEscribeElCdigo);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(395, 35, 116, 26);
		contentPane.add(textField);
		
		JButton btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarProveedor.setBounds(523, 35, 285, 25);
		contentPane.add(btnBuscarProveedor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(226, 100, 385, 26);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(226, 158, 385, 263);
		contentPane.add(textPane);
	}
}
