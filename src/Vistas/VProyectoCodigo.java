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

public class VProyectoCodigo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectoCodigo frame = new VProyectoCodigo();
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
	public VProyectoCodigo() {
		setTitle("Consulta de Proyectos por c\u00F3digo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Escribe el c\u00F3digo o parte del c\u00F3digo");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(65, 29, 326, 26);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(403, 29, 116, 26);
		contentPane.add(textField);
		
		JButton btnBuscarProyecto = new JButton("Buscar Proyecto");
		btnBuscarProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarProyecto.setBounds(531, 29, 285, 25);
		contentPane.add(btnBuscarProyecto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(234, 94, 385, 26);
		contentPane.add(comboBox);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(234, 152, 385, 263);
		contentPane.add(textPane);
	}

}
