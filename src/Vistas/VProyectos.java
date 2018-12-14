package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Hibernate.Gestion;
import Hibernate.Modo;
import Hibernate.Proyectos;
import Hibernate.Sesion;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Iterator;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VProyectos extends JFrame {

	private JPanel contentPane;
	private JTextField jtlCodigo;
	private JTextField jtlNombre;
	private JTextField jtlCiudad;
	private JTextField jtlPag;
	private JTextField jtlPagTotal;
	private JTextField jtCodigo;
	private JTextField jtNombre;
	private JTextField jtCiudad;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btInicio;
	private JButton btAnterior;
	private JButton btSiguiente;
	private JButton btFin;
	public JTabbedPane tabbedPane;
	private Proyectos p;
	private List<Proyectos> proyectos;
	private List<Gestion> gestiones;
	public Modo modo;
	private int proyectoActual=0;
	
	private boolean comprobarCamposVacios(){
		String errorMsg ="";
		boolean error = false;
		if(jtCodigo.getText().equals("")){
			errorMsg += "El código no puede estar vacío\n";
			error = true;
		}
		if(jtNombre.getText().equals("")){
			errorMsg += "El nombre no puede estar vacío\n";
			error = true;
		}
		if(jtCiudad.getText().equals("")){
			errorMsg += "La ciudad no puede estar vacía\n";
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
				cargarProyectos();
				break;
			case ELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(false);
				cargarProyectos();
				break;
			case MODIFICARELIMINAR:
				btnInsertar.setEnabled(false);
				btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				cargarProyectos();
				break;
			case LISTAR:
				tabbedPane.setSelectedIndex(1);
				cargarProyectos();
				break;
		}
	}
	
	public void comprobarBotones(){
		if(proyectoActual==0){	
			btInicio.setEnabled(false);
			btAnterior.setEnabled(false);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(proyectoActual>0 && proyectoActual<proyectos.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(true);
			btFin.setEnabled(true);
		}else if(proyectoActual==proyectos.size()-1){
			btInicio.setEnabled(true);
			btAnterior.setEnabled(true);
			btSiguiente.setEnabled(false);
			btFin.setEnabled(false);
		}else if(proyectos.size()==1){
			btInicio.setEnabled(false);
			btAnterior.setEnabled(false);
			btSiguiente.setEnabled(false);
			btFin.setEnabled(false);
		}
	}

	public void llenarCamposListado() {
		jtlCodigo.setText(proyectos.get(proyectoActual).getCodigo());
		jtlNombre.setText(proyectos.get(proyectoActual).getNombre());
		jtlCiudad.setText(proyectos.get(proyectoActual).getCiudad());
		jtlPag.setText(String.valueOf(proyectoActual+1));
		jtlPagTotal.setText(String.valueOf(proyectos.size()));
	}

	public void rellenarCampos(){
		jtCodigo.setText(p.getCodigo());
		jtNombre.setText(p.getNombre());
		jtCiudad.setText(p.getCiudad());
	}

	private void cargarProyectos() {
		proyectos = Sesion.cargarProyectos();
		gestiones = Sesion.cargarGestiones();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectos frame = new VProyectos();
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
	public VProyectos() {
		setTitle("Gesti\u00F3n de Proyectos");
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
					cargarProyectos();
				}
			}
		});
		tabbedPane.setBounds(10, 11, 858, 427);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		tabbedPane.addTab("Gesti\u00F3n de Proyectos", null, panel, null);
		
		JLabel label = new JLabel("ALTAS BAJAS Y MODIFICACIONES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.BOLD, 20));
		label.setBounds(12, 25, 829, 16);
		panel.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(null);
		panel_2.setBounds(0, 78, 853, 217);
		panel.add(panel_2);
		
		JLabel lblCdigoDeProyecto = new JLabel("C\u00F3digo de proyecto");
		lblCdigoDeProyecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCdigoDeProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDeProyecto.setBounds(180, 35, 189, 24);
		panel_2.add(lblCdigoDeProyecto);
		
		jtCodigo = new JTextField();
		jtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				boolean encontrado = false;
				if(!jtCodigo.getText().equalsIgnoreCase("")){
					Iterator it = proyectos.iterator();
					while(it.hasNext()){
						Proyectos pro = (Proyectos) it.next();
						if(pro.getCodigo().equalsIgnoreCase(jtCodigo.getText())){
							p = pro;
							rellenarCampos();
							encontrado = true;
							cambiarModo(Modo.MODIFICARELIMINAR);
							break;
						}
					}
					if(!encontrado){
						if(modo==Modo.MODIFICARELIMINAR || modo==Modo.MODIFICAR || modo==Modo.ELIMINAR){
							JOptionPane.showMessageDialog(contentPane, "Proyecto no encontrado", "Búsqueda de proyectos", JOptionPane.INFORMATION_MESSAGE);
							cambiarModo(Modo.INSERTAR);
						}else if(modo==Modo.INSERTAR){
							cambiarModo(Modo.INSERTAR);
						}else{
							cambiarModo(Modo.MODIFICARELIMINAR);
						}
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de proyectos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		jtCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtCodigo.setColumns(10);
		jtCodigo.setBounds(404, 35, 275, 24);
		panel_2.add(jtCodigo);
		
		jtNombre = new JTextField();
		jtNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtNombre.setColumns(10);
		jtNombre.setBounds(404, 94, 275, 26);
		panel_2.add(jtNombre);
		
		jtCiudad = new JTextField();
		jtCiudad.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtCiudad.setColumns(10);
		jtCiudad.setBounds(404, 155, 275, 26);
		panel_2.add(jtCiudad);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_2.setBounds(180, 94, 189, 26);
		panel_2.add(label_2);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCiudad.setBounds(180, 155, 189, 26);
		panel_2.add(lblCiudad);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(null);
		panel_3.setBounds(185, 323, 500, 45);
		panel.add(panel_3);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnLimpiar.setBounds(14, 5, 101, 31);
		panel_3.add(btnLimpiar);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarCamposVacios()){
					p =  new Proyectos();
					String codigo = jtCodigo.getText().toUpperCase();
					String nombre = jtNombre.getText();
					String ciudad = jtCiudad.getText();
					
					if(codigo.length()>6){
						p.setCodigo(codigo.substring(0,6));
					}else{
						p.setCodigo(codigo);
					}
					if(nombre.length()>40){
						p.setNombre(nombre.substring(0, 40));
					}else{
						p.setNombre(nombre);
					}
					if(ciudad.length()>40){
						p.setCiudad(ciudad.substring(0, 40));
					}else{
						p.setCiudad(ciudad);
					}
					Sesion.guardar(p);
					JOptionPane.showMessageDialog(contentPane, "Guardado correctamente", "Guardar proyecto", JOptionPane.INFORMATION_MESSAGE);
					limpiar();
					cargarProyectos();
				}
				
			}
		});
		btnInsertar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnInsertar.setBounds(129, 5, 105, 31);
		panel_3.add(btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarCamposVacios()){
					String codigo = jtCodigo.getText().toUpperCase();
					String nombre = jtNombre.getText();
					String ciudad = jtCiudad.getText();
					
					if(!p.getCodigo().equals(codigo)){
						if(codigo.length()>6){
							p.setCodigo(codigo.substring(0,6));
						}else{
							p.setCodigo(codigo);
						}
					}
					if(!p.getNombre().equals(nombre)){
						if(nombre.length()>40){
							p.setNombre(nombre.substring(0, 40));
						}else{
							p.setNombre(nombre);
						}
					}
					if(!p.getCiudad().equals(ciudad)){
						if(ciudad.length()>40){
							p.setCiudad(ciudad.substring(0, 40));
						}else{
							p.setCiudad(ciudad);
						}
					}
					Sesion.modificar(p);
					JOptionPane.showMessageDialog(contentPane, "Modificado correctamente", "Modificar proyecto", JOptionPane.INFORMATION_MESSAGE);
					limpiar();
					cargarProyectos();
				}
				
			}
		});
		btnModificar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnModificar.setBounds(248, 5, 113, 31);
		panel_3.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int opcion = JOptionPane.showConfirmDialog(contentPane, "¿Quieres eliminar el proyecto?", "Eliminar proyecto",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(opcion==JOptionPane.OK_OPTION){
					boolean encontrado = false;
					for(Gestion g:gestiones){
						if(g.getId().getCodproyecto().equals(p.getCodigo())){
							encontrado=true;
						}
					}
					if(encontrado){
						JOptionPane.showMessageDialog(contentPane, "No se puede borrar porque hay gestiones asociadas", "Borrar proyecto", JOptionPane.ERROR_MESSAGE);
					}else{
						Sesion.borrar(p);
						JOptionPane.showMessageDialog(contentPane, "Borrado correctamente", "Borrar proyecto", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
						cargarProyectos();
					}
				}
			}
		});
		btnEliminar.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnEliminar.setBounds(375, 5, 107, 31);
		panel_3.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		tabbedPane.addTab("Listado de Proyectos", null, panel_1, null);
		
		JLabel lblListaDeProyectos = new JLabel("LISTA DE PROYECTOS ");
		lblListaDeProyectos.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeProyectos.setFont(new Font("Verdana", Font.BOLD, 20));
		lblListaDeProyectos.setBounds(12, 29, 829, 16);
		panel_1.add(lblListaDeProyectos);
		
		JLabel label_6 = new JLabel("UTILIZA LOS BOTONES PARA IR DE UN REGISTRO A OTRO");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 15));
		label_6.setBounds(12, 60, 829, 16);
		panel_1.add(label_6);
		
		JLabel lblCdigoDeProyecto_1 = new JLabel("C\u00F3digo de proyecto");
		lblCdigoDeProyecto_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCdigoDeProyecto_1.setBounds(189, 115, 194, 26);
		panel_1.add(lblCdigoDeProyecto_1);
		
		jtlCodigo = new JTextField();
		jtlCodigo.setEnabled(false);
		jtlCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlCodigo.setColumns(10);
		jtlCodigo.setBounds(395, 115, 116, 26);
		panel_1.add(jtlCodigo);
		
		JLabel label_8 = new JLabel("Nombre");
		label_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		label_8.setBounds(189, 170, 126, 26);
		panel_1.add(label_8);
		
		jtlNombre = new JTextField();
		jtlNombre.setEnabled(false);
		jtlNombre.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlNombre.setColumns(10);
		jtlNombre.setBounds(395, 170, 275, 26);
		panel_1.add(jtlNombre);
		
		JLabel lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblCiudad_1.setBounds(189, 225, 126, 26);
		panel_1.add(lblCiudad_1);
		
		jtlCiudad = new JTextField();
		jtlCiudad.setEnabled(false);
		jtlCiudad.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtlCiudad.setColumns(10);
		jtlCiudad.setBounds(395, 225, 275, 26);
		panel_1.add(jtlCiudad);
		
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
				proyectoActual=0;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btInicio.setFont(new Font("Verdana", Font.PLAIN, 16));
		btInicio.setBounds(334, 273, 71, 25);
		panel_1.add(btInicio);
		
		btAnterior = new JButton("<<");
		btAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyectoActual-=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btAnterior.setFont(new Font("Verdana", Font.PLAIN, 16));
		btAnterior.setBounds(417, 273, 71, 25);
		panel_1.add(btAnterior);
		
		btSiguiente = new JButton(">>");
		btSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyectoActual+=1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btSiguiente.setFont(new Font("Verdana", Font.PLAIN, 16));
		btSiguiente.setBounds(516, 273, 71, 25);
		panel_1.add(btSiguiente);
		
		btFin = new JButton(">>|");
		btFin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proyectoActual=proyectos.size()-1;
				llenarCamposListado();
				comprobarBotones();
			}
		});
		btFin.setFont(new Font("Verdana", Font.PLAIN, 16));
		btFin.setBounds(599, 273, 71, 25);
		panel_1.add(btFin);
		
		JButton button_8 = new JButton("Ejecutar consulta");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProyectos();
				proyectoActual = 0;
				if(proyectos.size()==0){
					JOptionPane.showMessageDialog(getContentPane(), "No existen proyectos", "Búsquedad de proyectos", JOptionPane.ERROR_MESSAGE);
				}else{
					llenarCamposListado();
					comprobarBotones();
				}
			}
		});
		button_8.setFont(new Font("Verdana", Font.PLAIN, 18));
		button_8.setBounds(189, 311, 481, 25);
		panel_1.add(button_8);
	}

	protected void limpiar() {
		// TODO Auto-generated method stub
		jtCodigo.setText("");
		jtNombre.setText("");
		jtCiudad.setText("");
	}

}
