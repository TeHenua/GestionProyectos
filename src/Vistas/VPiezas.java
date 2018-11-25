package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Hibernate.Modo;
import Hibernate.Piezas;
import Hibernate.Proveedores;
import Hibernate.Sesion;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class VPiezas extends JFrame {

	private JPanel contentPane;
	private JTextField jtlCodigo;
	private JTextField jtlNombre;
	private JTextField jtlPrecio;
	private JTextField jtlDescripcion;
	private JTextField jtlPag;
	private JTextField jtlPagTotal;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfDescripcion;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btInicio;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JButton btFin;
	public JTabbedPane tabbedPane;
	private Piezas p;
	private List<Piezas> piezas;
	public Modo modo;
	private int piezaActual=0;
	
	private boolean comprobarCamposVacios(){
		String errorMsg ="";
		boolean error = false;
		try{
			Float.parseFloat(tfPrecio.getText());
			if(Float.parseFloat(tfPrecio.getText())==0){
				errorMsg += "El precio no puede ser 0";			
				error = true;
			}
		}catch(NumberFormatException e){
			errorMsg += "El precio debe ser un número\n";			
			error = true;
		}
		if(tfCodigo.getText().equals("")){
			errorMsg += "El código no puede estar vacío";
			error = true;
		}else if(tfNombre.getText().equals("")){
			errorMsg += "El nombre no puede estar vacío";
			error = true;
		}else if(tfPrecio.getText().equals("")){
			errorMsg += "El precio no puede estar vacío";			
			error = true;
		}else if(tfDescripcion.getText().equals("")){
			errorMsg += "La descripción no puede estar vacía";
			error = true;
		}
		if(error){
			JOptionPane.showMessageDialog(contentPane, errorMsg, "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return error;
	}
	
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
				cargarPiezas();
				break;
			case ELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(false);
				cargarPiezas();
				break;
			case MODIFICARELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				cargarPiezas();
				break;
			case LISTAR:
				tabbedPane.setSelectedIndex(1);
				cargarPiezas();
				break;
		}
	}
	public void comprobarBotones(){
		if(piezaActual==0){	
			btInicio.setEnabled(false);
			btAnterior.setEnabled(false);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(piezaActual>0 && piezaActual<piezas.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(piezaActual==piezas.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(false);
			btFin.setEnabled(false);
		}else if(piezas.size()==1){
			btInicio.setEnabled(false);
			btAnterior.setEnabled(false);
			btSiguiente.setEnabled(false);
			btFin.setEnabled(false);
		}
	}
	
	public void llenarCamposListado() {
		jtlCodigo.setText(piezas.get(piezaActual).getCodigo());
		jtlNombre.setText(piezas.get(piezaActual).getNombre());
		jtlPrecio.setText(String.valueOf(piezas.get(piezaActual).getPrecio()));
		jtlDescripcion.setText(piezas.get(piezaActual).getDescipcion());
		jtlPag.setText(String.valueOf(piezaActual+1));
		jtlPagTotal.setText(String.valueOf(piezas.size()));
	}
	
	public void rellenarCampos(){
		tfCodigo.setText(p.getCodigo());
		tfNombre.setText(p.getNombre());
		tfPrecio.setText(String.valueOf(p.getPrecio()));
		tfDescripcion.setText(p.getDescipcion());
	}

	private void cargarPiezas() {
		piezas = Sesion.cargarPiezas();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPiezas frame = new VPiezas();
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
	public VPiezas() {
		setTitle("Gesti\u00F3n de Piezas");
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
					cargarPiezas();
				}
			}
		});
		tabbedPane.setBounds(16, 11, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Gesti\u00F3n de Piezas", null, panel, null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setBounds(12, 25, 829, 16);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel_2.setBounds(187, 322, 500, 45);
		panel.add(panel_2);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnLimpiar.setBounds(14, 5, 101, 31);
		panel_2.add(btnLimpiar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarCamposVacios()){
					p =  new Piezas();
					p.setNombre(tfNombre.getText());
					p.setPrecio(Float.parseFloat(tfPrecio.getText()));
					p.setCodigo(tfCodigo.getText().toUpperCase());
					p.setDescipcion(tfDescripcion.getText());
					Sesion.guardar(p);
					JOptionPane.showMessageDialog(contentPane, "Guardado correctamente", "Guardar pieza", JOptionPane.INFORMATION_MESSAGE);
					limpiar();
					cargarPiezas();
				}
				
			}
		});
		btnInsertar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnInsertar.setBounds(129, 5, 105, 31);
		panel_2.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarCamposVacios()){
					if(!(Float.parseFloat(tfPrecio.getText())==p.getPrecio())){
					p.setPrecio(Float.parseFloat(tfPrecio.getText()));
					}
					if(!p.getCodigo().equals(tfCodigo.getText())){
						p.setCodigo(tfCodigo.getText().toUpperCase());
					}
					if(!p.getNombre().equals(tfNombre.getText())){
						p.setNombre(tfNombre.getText());
					}
					if(!p.getDescipcion().equals(tfDescripcion.getText())){
						p.setDescipcion(tfDescripcion.getText());
					}
					Sesion.modificar(p);
					JOptionPane.showMessageDialog(contentPane, "Modificado correctamente", "Modificar pieza", JOptionPane.INFORMATION_MESSAGE);
					limpiar();
					cargarPiezas();
				}	
			}
		});
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnModificar.setBounds(248, 5, 113, 31);
		panel_2.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Quieres eliminar la pieza?", "Eliminar pieza",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcion==JOptionPane.OK_OPTION){
					Sesion.borrar(p);
					JOptionPane.showMessageDialog(contentPane, "Borrado correctamente", "Borrar pieza", JOptionPane.INFORMATION_MESSAGE);
					limpiar();
					cargarPiezas();
				}
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnEliminar.setBounds(375, 5, 107, 31);
		panel_2.add(btnEliminar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBounds(0, 80, 853, 217);
		panel.add(panel_3);
		
		JLabel lblCdigoDePieza_1 = new JLabel("C\u00F3digo de pieza");
		lblCdigoDePieza_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoDePieza_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDePieza_1.setBounds(180, 23, 189, 24);
		panel_3.add(lblCdigoDePieza_1);
		
		tfCodigo = new JTextField();
		tfCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					Iterator it = piezas.iterator();
					while(it.hasNext()){
						Piezas pie = (Piezas) it.next();
						if(pie.getCodigo().equalsIgnoreCase(tfCodigo.getText())){
							p = pie;
							rellenarCampos();
							encontrado = true;
							cambiarModo(Modo.MODIFICARELIMINAR);
							break;
						}
					}
					if(!encontrado){
						if(modo==Modo.MODIFICARELIMINAR || modo==Modo.MODIFICAR || modo==Modo.ELIMINAR){
							JOptionPane.showMessageDialog(contentPane, "Pieza no encontrada", "Búsqueda de piezas", JOptionPane.INFORMATION_MESSAGE);
							cambiarModo(Modo.INSERTAR);
						}else if(modo==Modo.INSERTAR){
							cambiarModo(Modo.INSERTAR);
						}else{
							cambiarModo(Modo.MODIFICARELIMINAR);
						}
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de piezas", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(404, 23, 275, 24);
		panel_3.add(tfCodigo);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfNombre.setColumns(10);
		tfNombre.setBounds(404, 70, 275, 26);
		panel_3.add(tfNombre);
		
		tfPrecio = new JTextField();
		tfPrecio.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(404, 119, 275, 26);
		panel_3.add(tfPrecio);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfDescripcion.setColumns(10);
		tfDescripcion.setBounds(404, 168, 275, 26);
		panel_3.add(tfDescripcion);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(180, 70, 189, 26);
		panel_3.add(label_2);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPrecio.setBounds(180, 119, 189, 26);
		panel_3.add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcin.setBounds(180, 168, 189, 26);
		panel_3.add(lblDescripcin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Listado de Piezas", null, panel_1, null);
		
		JLabel lblListaDePiezas = new JLabel("LISTA DE PIEZAS");
		lblListaDePiezas.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDePiezas.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDePiezas.setBounds(12, 29, 829, 16);
		panel_1.add(lblListaDePiezas);
		
		JLabel label_6 = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		label_6.setBounds(12, 60, 829, 16);
		panel_1.add(label_6);
		
		JLabel lblCdigoDePieza = new JLabel("C\u00F3digo de pieza");
		lblCdigoDePieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDePieza.setBounds(189, 117, 194, 26);
		panel_1.add(lblCdigoDePieza);
		
		jtlCodigo = new JTextField();
		jtlCodigo.setEnabled(false);
		jtlCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlCodigo.setColumns(10);
		jtlCodigo.setBounds(395, 117, 116, 26);
		panel_1.add(jtlCodigo);
		
		JLabel label_8 = new JLabel("Nombre");
		label_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_8.setBounds(189, 156, 126, 26);
		panel_1.add(label_8);
		
		jtlNombre = new JTextField();
		jtlNombre.setEnabled(false);
		jtlNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlNombre.setColumns(10);
		jtlNombre.setBounds(395, 156, 275, 26);
		panel_1.add(jtlNombre);
		
		JLabel lblPrecio_1 = new JLabel("Precio");
		lblPrecio_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPrecio_1.setBounds(189, 195, 126, 26);
		panel_1.add(lblPrecio_1);
		
		jtlPrecio = new JTextField();
		jtlPrecio.setEnabled(false);
		jtlPrecio.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlPrecio.setColumns(10);
		jtlPrecio.setBounds(395, 195, 275, 26);
		panel_1.add(jtlPrecio);
		
		JLabel lblDescripcin_1 = new JLabel("Descripci\u00F3n");
		lblDescripcin_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblDescripcin_1.setBounds(189, 234, 126, 26);
		panel_1.add(lblDescripcin_1);
		
		jtlDescripcion = new JTextField();
		jtlDescripcion.setEnabled(false);
		jtlDescripcion.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlDescripcion.setColumns(10);
		jtlDescripcion.setBounds(395, 234, 275, 26);
		panel_1.add(jtlDescripcion);
		
		jtlPag = new JTextField();
		jtlPag.setEnabled(false);
		jtlPag.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlPag.setColumns(10);
		jtlPag.setBounds(189, 273, 43, 26);
		panel_1.add(jtlPag);
		
		jtlPagTotal = new JTextField();
		jtlPagTotal.setEnabled(false);
		jtlPagTotal.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlPagTotal.setColumns(10);
		jtlPagTotal.setBounds(279, 273, 43, 26);
		panel_1.add(jtlPagTotal);
		
		JLabel label_11 = new JLabel("de");
		label_11.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_11.setBounds(244, 273, 32, 26);
		panel_1.add(label_11);
		
		btInicio = new JButton("|<<");
		btInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				piezaActual=0;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btInicio.setBounds(334, 273, 71, 25);
		panel_1.add(btInicio);
		
		btAnterior = new JButton("<<");
		btAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piezaActual-=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btAnterior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btAnterior.setBounds(417, 273, 71, 25);
		panel_1.add(btAnterior);
		
		btSiguiente = new JButton(">>");
		btSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piezaActual+=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btSiguiente.setBounds(516, 273, 71, 25);
		panel_1.add(btSiguiente);
		
		btFin = new JButton(">>|");
		btFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				piezaActual=piezas.size()-1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btFin.setBounds(599, 273, 71, 25);
		panel_1.add(btFin);
		
		JButton btnEjecutarConsultla = new JButton("Ejecutar consulta");
		btnEjecutarConsultla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarPiezas();
				piezaActual = 0;
				if(piezas.size()==0){
					JOptionPane.showMessageDialog(getContentPane(), "No existen proveedores", "Búsquedad de proveedores", JOptionPane.ERROR_MESSAGE);
				}else{
					llenarCamposListado();
					comprobarBotones();
				}
				
			}
		});
		btnEjecutarConsultla.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnEjecutarConsultla.setBounds(189, 311, 481, 25);
		panel_1.add(btnEjecutarConsultla);
	}

	protected void limpiar() {
		// TODO Auto-generated method stub
		tfCodigo.setText("");
		tfNombre.setText("");
		tfPrecio.setText("");
		tfDescripcion.setText("");
	}
}
