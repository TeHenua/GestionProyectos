package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.GridLayout;

import Hibernate.Modo;
import Hibernate.Proveedores;
import Hibernate.Sesion;

public class VProveedores extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnBuscar;
	public JTabbedPane tabbedPane;
	private Proveedores p;
	private List<Proveedores> proveedores;
	public Modo modo;
	
	
	public void cambiarModo(Modo modo){
		this.modo = modo;
		switch(modo){
			case INSERTAR:
				btnInsertar.setEnabled(true);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
				btnBuscar.setVisible(false);
				break;
			case MODIFICAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(true);
				btnBuscar.setVisible(true);
				cargarProveedores();
				break;
			case ELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(false);
				btnBuscar.setVisible(false);
				break;
		}
	}
	
	public void rellenarCampos(){
		tfCodigo.setText(p.getCodigo());
		tfNombre.setText(p.getNombre());
		tfApellidos.setText(p.getApellidos());
		tfDireccion.setText(p.getDireccion());
	}

	private void cargarProveedores() {
		proveedores = Sesion.cargarProveedores();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProveedores frame = new VProveedores();
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
	public VProveedores() {
		setTitle("Gesti\u00F3n de Proveedores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel pGestion = new JPanel();
		tabbedPane.addTab("Gesti\u00F3n de Proveedores", null, pGestion, null);
		pGestion.setLayout(null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 25, 829, 16);
		pGestion.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBounds(0, 52, 853, 217);
		pGestion.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo de proveedor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(180, 23, 189, 24);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(404, 23, 275, 24);
		panel_2.add(tfCodigo);
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(404, 70, 275, 26);
		panel_2.add(tfNombre);
		tfNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setBounds(404, 119, 275, 26);
		panel_2.add(tfApellidos);
		tfApellidos.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfApellidos.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(404, 168, 275, 26);
		panel_2.add(tfDireccion);
		tfDireccion.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfDireccion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(180, 70, 189, 26);
		panel_2.add(lblNombre);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setBounds(180, 119, 189, 26);
		panel_2.add(lblApellidos);
		lblApellidos.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setBounds(180, 168, 189, 26);
		panel_2.add(lblDireccin);
		lblDireccin.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					Iterator it = proveedores.iterator();
					while(it.hasNext()){
						Proveedores pro = (Proveedores) it.next();
						if(pro.getCodigo().equalsIgnoreCase(tfCodigo.getText())){
							p = pro;
							rellenarCampos();
							break;
						}
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnBuscar.setBounds(689, 20, 101, 31);
		panel_2.add(btnBuscar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBounds(180, 302, 500, 45);
		pGestion.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodigo.setText("");
				tfNombre.setText("");
				tfApellidos.setText("");
				tfDireccion.setText("");
			}
		});
		btnLimpiar.setBounds(14, 5, 101, 31);
		panel_3.add(btnLimpiar);
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(129, 5, 105, 31);
		panel_3.add(btnInsertar);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p =  new Proveedores();
				p.setNombre(tfNombre.getText());
				p.setApellidos(tfApellidos.getText());
				p.setCodigo(tfCodigo.getText());
				p.setDireccion(tfDireccion.getText());
				Sesion.guardar(p);
				
			}
		});
		btnInsertar.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!p.getApellidos().equals(tfApellidos.getText())){
					p.setApellidos(tfApellidos.getText());
				}
				if(!p.getCodigo().equals(tfCodigo.getText())){
					p.setCodigo(tfCodigo.getText());
				}
				if(!p.getNombre().equals(tfNombre.getText())){
					p.setNombre(tfNombre.getText());
				}
				if(!p.getNombre().equals(tfNombre.getText())){
					p.setNombre(tfNombre.getText());
				}
				Sesion.modificar(p);
			}
		});
		btnModificar.setBounds(248, 5, 113, 31);
		panel_3.add(btnModificar);
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(375, 5, 107, 31);
		panel_3.add(btnEliminar);
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JPanel pListado = new JPanel();
		tabbedPane.addTab("Listado de Proveedores", null, pListado, null);
		pListado.setLayout(null);
		
		JLabel lblListaDeProveedores = new JLabel("LISTA DE PROVEEDORES ");
		lblListaDeProveedores.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProveedores.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDeProveedores.setBounds(12, 29, 829, 16);
		pListado.add(lblListaDeProveedores);
		
		JLabel lblUtilizaLosBotones = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		lblUtilizaLosBotones.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilizaLosBotones.setFont(new Font("Verdana", Font.BOLD, 15));
		lblUtilizaLosBotones.setBounds(12, 60, 829, 16);
		pListado.add(lblUtilizaLosBotones);
		
		JLabel label_1 = new JLabel("C\u00F3digo de proveedor");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_1.setBounds(189, 117, 194, 26);
		pListado.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(395, 117, 116, 26);
		pListado.add(textField_4);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(189, 156, 126, 26);
		pListado.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(395, 156, 275, 26);
		pListado.add(textField_5);
		
		JLabel label_3 = new JLabel("Apellidos");
		label_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_3.setBounds(189, 195, 126, 26);
		pListado.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(395, 195, 275, 26);
		pListado.add(textField_6);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_4.setBounds(189, 234, 126, 26);
		pListado.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(395, 234, 275, 26);
		pListado.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_8.setColumns(10);
		textField_8.setBounds(189, 273, 43, 26);
		pListado.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Verdana", Font.PLAIN, 18));
		textField_9.setColumns(10);
		textField_9.setBounds(279, 273, 43, 26);
		pListado.add(textField_9);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDe.setBounds(244, 273, 32, 26);
		pListado.add(lblDe);
		
		JButton button = new JButton("|<<");
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(334, 273, 71, 25);
		pListado.add(button);
		
		JButton button_1 = new JButton("<<");
		button_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_1.setBounds(417, 273, 71, 25);
		pListado.add(button_1);
		
		JButton button_2 = new JButton(">>");
		button_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_2.setBounds(516, 273, 71, 25);
		pListado.add(button_2);
		
		JButton button_3 = new JButton(">>|");
		button_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_3.setBounds(599, 273, 71, 25);
		pListado.add(button_3);
		
		JButton btnEjecutarConsultla = new JButton("Ejecutar consulta");
		btnEjecutarConsultla.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEjecutarConsultla.setBounds(189, 311, 481, 25);
		pListado.add(btnEjecutarConsultla);
	}
}
