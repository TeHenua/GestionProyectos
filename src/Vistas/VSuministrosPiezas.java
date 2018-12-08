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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class VSuministrosPiezas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField jtProyectos;
	private JTextField jtProveedores;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox comboBox;
	private JButton button;
	private List<Piezas> piezas;
	private Piezas pieza;
	private List<Gestion> gestiones;
	private JTextField jtCantidad;
	private int totalProyectos = 0;
	private int totalProveedores = 0;
	private int totalPiezas = 0;
	
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
		panel.setBounds(24, 13, 834, 246);
		contentPane.add(panel);
		
		JLabel lblPieza = new JLabel("Pieza");
		lblPieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPieza.setBounds(12, 0, 124, 31);
		panel.add(lblPieza);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige c\u00F3digo"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>0){
					pieza = piezas.get(comboBox.getSelectedIndex()-1);
					textField.setText(pieza.getNombre());
					textField_1.setText(pieza.getDescipcion());
					if(model!=null){
						model.setRowCount(0);
					}
					jtProveedores.setText("");
					jtProyectos.setText("");
					jtCantidad.setText("");
					totalPiezas = 0;
					totalProveedores = 0;
					totalProyectos = 0;
					button.setEnabled(true);
				}else{
					textField.setText("");
					textField_1.setText("");
					jtCantidad.setText("");
					jtProveedores.setText("");
					jtProyectos.setText("");
					if(model!=null){
						model.setRowCount(0);
					}
					button.setEnabled(false);
				}
			}
		});
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(504, 88, 318, 116);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(new Rectangle(0, 0, 300, 300));
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Cód. Pieza", "Cód. Proyecto","Cód. Proveedor"
				}
			));
		
		JLabel lblNDeProyectos = new JLabel("N\u00BA de Proyectos");
		lblNDeProyectos.setBounds(12, 88, 180, 31);
		panel.add(lblNDeProyectos);
		lblNDeProyectos.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		jtProyectos = new JTextField();
		jtProyectos.setBounds(204, 88, 172, 31);
		panel.add(jtProyectos);
		jtProyectos.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProyectos.setEnabled(false);
		jtProyectos.setColumns(10);
		
		JLabel lblNDeProveedores = new JLabel("N\u00BA de Proveedores");
		lblNDeProveedores.setBounds(12, 142, 180, 31);
		panel.add(lblNDeProveedores);
		lblNDeProveedores.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		jtProveedores = new JTextField();
		jtProveedores.setBounds(204, 142, 172, 31);
		panel.add(jtProveedores);
		jtProveedores.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedores.setEnabled(false);
		jtProveedores.setColumns(10);
		
		JLabel lblCantidadTotalSuministrada = new JLabel("Cantidad total suministrada");
		lblCantidadTotalSuministrada.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCantidadTotalSuministrada.setBounds(12, 202, 277, 31);
		panel.add(lblCantidadTotalSuministrada);
		
		jtCantidad = new JTextField();
		jtCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtCantidad.setEnabled(false);
		jtCantidad.setColumns(10);
		jtCantidad.setBounds(320, 202, 172, 31);
		panel.add(jtCantidad);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(75);
		columnModel.getColumn(1).setPreferredWidth(90);
		columnModel.getColumn(2).setPreferredWidth(75);
		
		button = new JButton("Ver piezas suministradas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				jtCantidad.setText("");
				jtProveedores.setText("");
				jtProyectos.setText("");
				totalPiezas = 0;
				totalProveedores = 0;
				totalProyectos = 0;
				for(Gestion gestion:gestiones){
					if(gestion.getId().getCodpieza().toLowerCase().equals(pieza.getCodigo())){
						model.addRow(new Object[]{
								gestion.getId().getCodpieza(),
								gestion.getId().getCodproyecto(),
								gestion.getId().getCodproveedor()
						});
						totalPiezas+=gestion.getCantidad();
						totalProveedores++;
						totalProyectos++;
					}
				}
				jtProyectos.setText(String.valueOf(totalProyectos));
				jtProveedores.setText(String.valueOf(totalProveedores));
				jtCantidad.setText(String.valueOf(totalPiezas));
			}
		});
		button.setFont(new Font("Verdana", Font.PLAIN, 16));
		button.setEnabled(false);
		button.setBounds(501, 272, 306, 31);
		contentPane.add(button);
	}
}
