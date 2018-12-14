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

import Hibernate.*;

public class VTablaProveedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Gestion> gestiones;
	private List<Proveedores> proveedores;
	private List<Piezas> piezas;
	private List<Proyectos> proyectos;
	private DefaultTableModel model;

	public void cargarDatos() {
		gestiones = Sesion.cargarGestiones();
		proveedores = Sesion.cargarProveedores();
		piezas = Sesion.cargarPiezas();
		proyectos = Sesion.cargarProyectos();
		model = (DefaultTableModel) table.getModel();		
		for(Proveedores p:proveedores){
			int[] tipoPieza = new int[piezas.size()];
			int[] tipoProy = new int[proyectos.size()];
			for(int i=0;i<piezas.size();i++){
				tipoPieza[i] = 0;
			}
			for(int i=0;i<proyectos.size();i++){
				tipoProy[i] = 0;
			}
			float cantPiezas=0f;
			int numPiezas=0;
			int numProy=0;
			for(Gestion g:gestiones){
				if(g.getId().getCodproveedor().equals(p.getCodigo())){
					for(int i=0;i<piezas.size();i++){
						if(g.getId().getCodpieza().equals(piezas.get(i).getCodigo())){
							tipoPieza[i]++;
						}
					}
					for(int i=0;i<proyectos.size();i++){
						if(g.getId().getCodproyecto().equals(proyectos.get(i).getCodigo())){
							tipoProy[i]++;
						}
					}
					cantPiezas+=g.getCantidad();
				}
			}
			for(int i=0;i<tipoPieza.length;i++){
				if(tipoPieza[i]>numPiezas){
					numPiezas=tipoPieza[i];
				}
			}
			for(int i=0;i<tipoProy.length;i++){
				if(tipoProy[i]!=0){
					numProy++;
				}
			}
			model.addRow(new Object[]{
				p.getCodigo(),
				p.getNombre(),
				p.getApellidos(),
				numPiezas,
				cantPiezas,
				numProy
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
					VTablaProveedor frame = new VTablaProveedor();
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
	public VTablaProveedor() {
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
