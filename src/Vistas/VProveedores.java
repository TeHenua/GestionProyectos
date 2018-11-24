package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class VProveedores extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfDireccion;
	private JTextField jtlCodigo;
	private JTextField jtlNombre;
	private JTextField jtlApellidos;
	private JTextField jtlDireccion;
	private JTextField jtlPag;
	private JTextField jtlPagTotal;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btInicio;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JButton btFin;
	public JTabbedPane tabbedPane;
	private Proveedores p;
	private List<Proveedores> proveedores;
	public Modo modo;
	private int proveedorActual=0;
	
	
	public void cambiarModo(Modo modo){
		this.modo = modo;
		switch(modo){
			case INSERTAR:
				btnInsertar.setEnabled(true);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(false);
				break;
			case MODIFICAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnModificar.setEnabled(true);
				cargarProveedores();
				break;
			case ELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(false);
				cargarProveedores();
				break;
			case MODIFICARELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				cargarProveedores();
				break;
			case LISTAR:
				tabbedPane.setSelectedIndex(1);
				cargarProveedores();
				break;
		}
	}
	
	public void comprobarBotones(){
		if(proveedorActual==0){	
			btInicio.setEnabled(false);
			btAnterior.setEnabled(false);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(proveedorActual>0 && proveedorActual<proveedores.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(proveedorActual==proveedores.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(false);
			btFin.setEnabled(false);
		}
	}

	public void llenarCamposListado() {
		jtlCodigo.setText(proveedores.get(proveedorActual).getCodigo());
		jtlNombre.setText(proveedores.get(proveedorActual).getNombre());
		jtlApellidos.setText(proveedores.get(proveedorActual).getApellidos());
		jtlDireccion.setText(proveedores.get(proveedorActual).getDireccion());
		jtlPag.setText(String.valueOf(proveedorActual+1));
		jtlPagTotal.setText(String.valueOf(proveedores.size()));
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
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex()==1){
					cambiarModo(Modo.INSERTAR);
				}else{
					cargarProveedores();
				}
			}
		});

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
		tfCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					Iterator it = proveedores.iterator();
					while(it.hasNext()){
						Proveedores pro = (Proveedores) it.next();
						if(pro.getCodigo().equalsIgnoreCase(tfCodigo.getText())){
							p = pro;
							rellenarCampos();
							encontrado = true;
							cambiarModo(Modo.MODIFICARELIMINAR);
							break;
						}
					}
					if(!encontrado){
						if(modo==Modo.MODIFICARELIMINAR || modo==Modo.MODIFICAR || modo==Modo.ELIMINAR){
							JOptionPane.showMessageDialog(contentPane, "Proveedor no encontrado", "Búsqueda de proveedores", JOptionPane.INFORMATION_MESSAGE);
							cambiarModo(Modo.INSERTAR);
						}else if(modo==Modo.INSERTAR){
							cambiarModo(Modo.INSERTAR);
						}else{
							cambiarModo(Modo.MODIFICARELIMINAR);
						}
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de proveedores", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
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
				JOptionPane.showMessageDialog(contentPane, "Guardado correctamente", "Guardar proveedor", JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(contentPane, "Modificado correctamente", "Modificar proveedor", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModificar.setBounds(248, 5, 113, 31);
		panel_3.add(btnModificar);
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Quieres eliminar el proveeodor?", "Eliminar proveedor",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcion==JOptionPane.OK_OPTION){
					Sesion.borrar(p);
					JOptionPane.showMessageDialog(contentPane, "Borrado correctamente", "Borrar proveedor", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
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
		
		jtlCodigo = new JTextField();
		jtlCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlCodigo.setColumns(10);
		jtlCodigo.setBounds(395, 117, 116, 26);
		pListado.add(jtlCodigo);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(189, 156, 126, 26);
		pListado.add(label_2);
		
		jtlNombre = new JTextField();
		jtlNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlNombre.setColumns(10);
		jtlNombre.setBounds(395, 156, 275, 26);
		pListado.add(jtlNombre);
		
		JLabel label_3 = new JLabel("Apellidos");
		label_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_3.setBounds(189, 195, 126, 26);
		pListado.add(label_3);
		
		jtlApellidos = new JTextField();
		jtlApellidos.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlApellidos.setColumns(10);
		jtlApellidos.setBounds(395, 195, 275, 26);
		pListado.add(jtlApellidos);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_4.setBounds(189, 234, 126, 26);
		pListado.add(label_4);
		
		jtlDireccion = new JTextField();
		jtlDireccion.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlDireccion.setColumns(10);
		jtlDireccion.setBounds(395, 234, 275, 26);
		pListado.add(jtlDireccion);
		
		jtlPag = new JTextField();
		jtlPag.setEnabled(false);
		jtlPag.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlPag.setColumns(10);
		jtlPag.setBounds(189, 273, 43, 26);
		pListado.add(jtlPag);
		
		jtlPagTotal = new JTextField();
		jtlPagTotal.setEnabled(false);
		jtlPagTotal.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlPagTotal.setColumns(10);
		jtlPagTotal.setBounds(279, 273, 43, 26);
		pListado.add(jtlPagTotal);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDe.setBounds(244, 273, 32, 26);
		pListado.add(lblDe);
		
		btInicio = new JButton("|<<");
		btInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				proveedorActual=0;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btInicio.setFont(new Font("Verdana", Font.PLAIN, 16));
		btInicio.setBounds(334, 273, 71, 25);
		pListado.add(btInicio);
		
		btAnterior = new JButton("<<");
		btAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proveedorActual-=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btAnterior.setFont(new Font("Verdana", Font.PLAIN, 16));
		btAnterior.setBounds(417, 273, 71, 25);
		pListado.add(btAnterior);
		
		btSiguiente = new JButton(">>");
		btSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proveedorActual+=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btSiguiente.setFont(new Font("Verdana", Font.PLAIN, 16));
		btSiguiente.setBounds(516, 273, 71, 25);
		pListado.add(btSiguiente);
		
		btFin = new JButton(">>|");
		btFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proveedorActual=proveedores.size()-1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btFin.setFont(new Font("Verdana", Font.PLAIN, 16));
		btFin.setBounds(599, 273, 71, 25);
		pListado.add(btFin);
		
		JButton btnEjecutarConsultla = new JButton("Ejecutar consulta");
		btnEjecutarConsultla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarProveedores();
				proveedorActual = 0;
				if(proveedores.size()==0){
					JOptionPane.showMessageDialog(getContentPane(), "No existen proveedores", "Búsquedad de proveedores", JOptionPane.ERROR_MESSAGE);
				}else{
					llenarCamposListado();
					comprobarBotones();
				}
				
			}
		});
		btnEjecutarConsultla.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEjecutarConsultla.setBounds(189, 311, 481, 25);
		pListado.add(btnEjecutarConsultla);
	}


}
