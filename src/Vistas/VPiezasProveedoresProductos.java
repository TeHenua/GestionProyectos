package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class VPiezasProveedoresProductos extends JFrame {

	private JPanel contentPane;
	private JTextField jtProveedor1;
	private JTextField jtProveedor2;
	private JTextField jtPieza1;
	private JTextField jtPieza2;
	private JTextField jtProyecto1;
	private JTextField jtProyecto2;
	private JTextField jtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPiezasProveedoresProductos frame = new VPiezasProveedoresProductos();
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
	public VPiezasProveedoresProductos() {
		setTitle("GESTI\u00D3N GLOBAL - PROVEEDORES - PIEZAS - PROYECTOS\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 882, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnInsertar.setBounds(56, 5, 150, 31);
		panel.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnModificar.setBounds(262, 5, 150, 31);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnEliminar.setBounds(468, 5, 150, 31);
		panel.add(btnEliminar);
		
		JButton btnListado = new JButton("Listado");
		btnListado.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnListado.setBounds(674, 5, 150, 31);
		panel.add(btnListado);
		
		JLabel lblRelacionesPiezas = new JLabel("RELACIONES PIEZAS - PROVEEDORES - PROYECTOS");
		lblRelacionesPiezas.setHorizontalAlignment(SwingConstants.LEFT);
		lblRelacionesPiezas.setFont(new Font("Verdana", Font.BOLD, 20));
		lblRelacionesPiezas.setBounds(24, 74, 829, 16);
		contentPane.add(lblRelacionesPiezas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(24, 121, 834, 76);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProveedor.setBounds(12, 0, 124, 31);
		panel_1.add(lblProveedor);
		
		JComboBox cbProveedor = new JComboBox();
		cbProveedor.setModel(new DefaultComboBoxModel(new String[] {"Elige c\u00F3digo"}));
		cbProveedor.setFont(new Font("Verdana", Font.PLAIN, 18));
		cbProveedor.setBounds(148, 0, 141, 31);
		panel_1.add(cbProveedor);
		
		jtProveedor1 = new JTextField();
		jtProveedor1.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedor1.setColumns(10);
		jtProveedor1.setBounds(314, 0, 508, 31);
		panel_1.add(jtProveedor1);
		
		jtProveedor2 = new JTextField();
		jtProveedor2.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedor2.setColumns(10);
		jtProveedor2.setBounds(314, 44, 508, 31);
		panel_1.add(jtProveedor2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel_2.setBounds(24, 214, 834, 76);
		contentPane.add(panel_2);
		
		JLabel lblPieza = new JLabel("Pieza");
		lblPieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPieza.setBounds(12, 0, 124, 31);
		panel_2.add(lblPieza);
		
		JComboBox cbPieza = new JComboBox();
		cbPieza.setModel(new DefaultComboBoxModel(new String[] {"Elige c\u00F3digo"}));
		cbPieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		cbPieza.setBounds(148, 0, 141, 31);
		panel_2.add(cbPieza);
		
		jtPieza1 = new JTextField();
		jtPieza1.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPieza1.setColumns(10);
		jtPieza1.setBounds(314, 0, 508, 31);
		panel_2.add(jtPieza1);
		
		jtPieza2 = new JTextField();
		jtPieza2.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPieza2.setColumns(10);
		jtPieza2.setBounds(314, 44, 508, 31);
		panel_2.add(jtPieza2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBounds(24, 303, 834, 76);
		contentPane.add(panel_3);
		
		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProyecto.setBounds(12, 0, 124, 31);
		panel_3.add(lblProyecto);
		
		JComboBox cbProyecto = new JComboBox();
		cbProyecto.setModel(new DefaultComboBoxModel(new String[] {"Elige c\u00F3digo"}));
		cbProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		cbProyecto.setBounds(148, 0, 141, 31);
		panel_3.add(cbProyecto);
		
		jtProyecto1 = new JTextField();
		jtProyecto1.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProyecto1.setColumns(10);
		jtProyecto1.setBounds(314, 0, 508, 31);
		panel_3.add(jtProyecto1);
		
		jtProyecto2 = new JTextField();
		jtProyecto2.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProyecto2.setColumns(10);
		jtProyecto2.setBounds(314, 44, 508, 31);
		panel_3.add(jtProyecto2);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCantidad.setBounds(34, 392, 124, 31);
		contentPane.add(lblCantidad);
		
		jtCantidad = new JTextField();
		jtCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtCantidad.setColumns(10);
		jtCantidad.setBounds(170, 392, 172, 31);
		contentPane.add(jtCantidad);
	}
}
