package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Hibernate.Gestion;
import Hibernate.Piezas;
import Hibernate.Proveedores;
import Hibernate.Proyectos;
import Hibernate.Sesion;

public class VTablaProyectos extends JFrame {

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
		for(Proyectos p:proyectos){
			int[] tipoPieza = new int[piezas.size()];
			int[] tipoProvee = new int[proveedores.size()];
			for(int i=0;i<piezas.size();i++){
				tipoPieza[i] = 0;
			}
			for(int i=0;i<proveedores.size();i++){
				tipoProvee[i] = 0;
			}
			float cantPiezas=0f;
			int numPiezas=0;
			int numProvee=0;
			for(Gestion g:gestiones){
				if(g.getId().getCodproyecto().equals(p.getCodigo())){
					for(int i=0;i<piezas.size();i++){
						if(g.getId().getCodpieza().equals(piezas.get(i).getCodigo())){
							tipoPieza[i]++;
						}
					}
					for(int i=0;i<proveedores.size();i++){
						if(g.getId().getCodproveedor().equals(proveedores.get(i).getCodigo())){
							tipoProvee[i]++;
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
			
			for(int i=0;i<tipoProvee.length;i++){
				if(tipoProvee[i]!=0){
					numProvee++;
				}
			}
			model.addRow(new Object[]{
				p.getCodigo(),
				p.getNombre(),
				p.getCiudad(),
				numPiezas,
				cantPiezas,
				numProvee
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
		setTitle("N\u00DAMERO DE PIEZAS Y CANTIDAD DE PIEZAS SUMINISTRADAS EN PROYECTOS");
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
				"Cod Proyecto", "Nombre", "Ciudad", "N� Piezas", "Cantidad suministrada", "N� Proveedores"
			}
		));
		table.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(table);
	}

}
