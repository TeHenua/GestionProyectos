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
import Hibernate.Proyectos;
import Hibernate.Sesion;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Rectangle;

public class VSuministrosProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField jtPiezas;
	private JTextField jtProyectos;
	private JComboBox comboBox;
	private JButton btnVerPiezasSuministradas;
	private List<Proveedores> proveedores;
	private Proveedores proveedor;
	private List<Gestion> gestiones;
	private JTable table;
	private DefaultTableModel model;
	private int totalPiezas = 0;
	private int totalProyectos = 0;

	public void cargarProveedores() {
		proveedores = Sesion.cargarProveedores();	
		gestiones = Sesion.cargarGestiones();
		for(Proveedores pro:proveedores){
			comboBox.addItem(pro.getCodigo());
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VSuministrosProveedor frame = new VSuministrosProveedor();
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
	public VSuministrosProveedor() {
		setTitle("SUMINISTROS POR PROVEEDOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBounds(22, 13, 834, 173);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Proveedor");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(12, 0, 124, 31);
		panel.add(label);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>0){
					proveedor = proveedores.get(comboBox.getSelectedIndex()-1);
					textField.setText(proveedor.getNombre());
					textField_1.setText(proveedor.getApellidos());
					textField_2.setText(proveedor.getDireccion());
					if(model!=null){
						model.setRowCount(0);
					}
					jtPiezas.setText("");
					jtProyectos.setText("");
					totalPiezas=0;
					totalProyectos=0;
					btnVerPiezasSuministradas.setEnabled(true);
				}else{
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					jtPiezas.setText("");
					jtProyectos.setText("");
					if(model!=null){
						model.setRowCount(0);
					}
					btnVerPiezasSuministradas.setEnabled(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elige c\u00F3digo"}));
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
		
		JLabel lblPiezasSuministradas = new JLabel("Piezas suministradas");
		lblPiezasSuministradas.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPiezasSuministradas.setBounds(37, 208, 202, 31);
		contentPane.add(lblPiezasSuministradas);
		
		jtPiezas = new JTextField();
		jtPiezas.setEnabled(false);
		jtPiezas.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPiezas.setColumns(10);
		jtPiezas.setBounds(251, 208, 172, 31);
		contentPane.add(jtPiezas);
		
		JLabel lblProyectos = new JLabel("Proyectos");
		lblProyectos.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProyectos.setBounds(37, 262, 124, 31);
		contentPane.add(lblProyectos);
		
		jtProyectos = new JTextField();
		jtProyectos.setEnabled(false);
		jtProyectos.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProyectos.setColumns(10);
		jtProyectos.setBounds(251, 262, 172, 31);
		contentPane.add(jtProyectos);
		
		btnVerPiezasSuministradas = new JButton("Ver piezas suministradas");
		btnVerPiezasSuministradas.setEnabled(false);
		btnVerPiezasSuministradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				jtPiezas.setText("");
				jtProyectos.setText("");
				totalPiezas=0;
				totalProyectos=0;
				for(Gestion gestion:gestiones){
					if(gestion.getId().getCodproveedor().toLowerCase().equals(proveedor.getCodigo())){
						model.addRow(new Object[]{
								gestion.getId().getCodpieza(),
								gestion.getId().getCodproyecto(),
								gestion.getCantidad()
								});
						totalProyectos++;
						totalPiezas+=gestion.getCantidad();
					}
				}
				jtPiezas.setText(String.valueOf(totalPiezas));
				jtProyectos.setText(String.valueOf(totalProyectos));
			}
		});
		btnVerPiezasSuministradas.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnVerPiezasSuministradas.setBounds(484, 236, 306, 31);
		contentPane.add(btnVerPiezasSuministradas);
	}
}
