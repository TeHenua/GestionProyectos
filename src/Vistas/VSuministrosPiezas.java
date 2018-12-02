package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Hibernate.Gestion;
import Hibernate.Piezas;
import Hibernate.Proveedores;
import Hibernate.Sesion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Rectangle;
import java.util.List;

public class VSuministrosPiezas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JComboBox comboBox;
	private List<Piezas> piezas;
	private Piezas pieza;
	private List<Gestion> gestiones;
	
	public void cargarPiezas() {
		piezas = Sesion.cargarPiezas();
		gestiones = Sesion.cargarGestiones();
		for(Piezas pie:piezas){
			comboBox.addItem(pie.getCodigo());
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VSuministrosPiezas frame = new VSuministrosPiezas();
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
	public VSuministrosPiezas() {
		setTitle("PIEZAS SUMINISTRADAS A PROYECTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBounds(24, 13, 834, 173);
		contentPane.add(panel);
		
		JLabel lblPieza = new JLabel("Pieza");
		lblPieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPieza.setBounds(12, 0, 124, 31);
		panel.add(lblPieza);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(148, 0, 141, 31);
		panel.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(314, 0, 508, 31);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(314, 44, 508, 31);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(314, 91, 508, 31);
		panel.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 44, 276, 116);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(new Rectangle(0, 0, 300, 300));
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Código Pieza", "Código Proyecto","Cantidad"
				}
			));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(75);
		columnModel.getColumn(1).setPreferredWidth(90);
		columnModel.getColumn(2).setPreferredWidth(75);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(268, 213, 172, 31);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("Piezas suministradas");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_1.setBounds(54, 213, 202, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Proyectos");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(54, 267, 124, 31);
		contentPane.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(268, 267, 172, 31);
		contentPane.add(textField_4);
		
		JButton button = new JButton("Ver piezas suministradas");
		button.setFont(new Font("Verdana", Font.PLAIN, 16));
		button.setEnabled(false);
		button.setBounds(501, 241, 306, 31);
		contentPane.add(button);
	}


}
