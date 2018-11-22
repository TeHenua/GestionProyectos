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

public class VProyectoCiudad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectoCiudad frame = new VProyectoCiudad();
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
	public VProyectoCiudad() {
		setTitle("Consulta de Proveedores por ciudad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeLaCiudad = new JLabel("Escribe la ciudad o parte de ella");
		lblEscribeLaCiudad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeLaCiudad.setBounds(48, 38, 351, 26);
		contentPane.add(lblEscribeLaCiudad);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(411, 38, 116, 26);
		contentPane.add(textField);
		
		JButton btnBuscarProyecto = new JButton("Buscar Proyecto");
		btnBuscarProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarProyecto.setBounds(539, 38, 285, 25);
		contentPane.add(btnBuscarProyecto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(242, 103, 385, 26);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(242, 161, 385, 263);
		contentPane.add(textPane);
	}

}
