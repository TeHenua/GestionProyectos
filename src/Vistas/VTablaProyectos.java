package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Hibernate.Gestion;
import Hibernate.Proveedores;
import Hibernate.Sesion;

public class VTablaProyectos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Gestion> gestiones;
	private List<Proveedores> proveedores;
	private DefaultTableModel model;

	public void cargarDatos() {
		gestiones = Sesion.cargarGestiones();
		proveedores = Sesion.cargarProveedores();
		model = (DefaultTableModel) table.getModel();
		for(Proveedores p:proveedores){
			int numPiezas=0;
			float cantPiezas=0f;
			int numProy=0;
			for(Gestion g:gestiones){
				if(g.getId().getCodproveedor().equals(p.getCodigo())){
					
				}
			}
			model.addRow(new Object[]{
				p.getCodigo(),
				p.getNombre(),
				p.getApellidos(),
				
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
					VTablaProyectos frame = new VTablaProyectos();
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
	public VTablaProyectos() {
		setTitle("N\u00DAMERO DE PIEZAS Y CANTIDAD DE PIEZAS SUMINISTRADAS POR PROVEEDOR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 882, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod Proveedor", "Nombre", "Apellidos", "Nº Piezas", "Cantidad suministrada", "Nº Proyectos"
			}
		));
		table.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(table);
	}

	
}
