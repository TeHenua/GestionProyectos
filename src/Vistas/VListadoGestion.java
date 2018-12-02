package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Hibernate.Gestion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class VListadoGestion extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Gestion> gestiones;
	private DefaultTableModel model;
	
	
	public void pintarGestiones(List<Gestion> gestiones) {
		this.gestiones = gestiones;
		for (Gestion gestion : gestiones) {
			model.addRow(new Object[]{
					gestion.getId().getCodproveedor(), 
					gestion.getId().getCodpieza(),
					gestion.getId().getCodproyecto(),
					gestion.getCantidad()
					});
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VListadoGestion frame = new VListadoGestion();
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
	public VListadoGestion() {
		setTitle("LISTADO TODAS GESTIONES");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(0, 0, 432, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setBounds(0, 0, 432, 253);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Código Proveedor", "Código Pieza", "Código Proyecto", "Cantidad"
				}
			));
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(120);
		columnModel.getColumn(1).setPreferredWidth(120);
		columnModel.getColumn(2).setPreferredWidth(120);
		columnModel.getColumn(3).setPreferredWidth(72);
		model = (DefaultTableModel) table.getModel();
	}
}
