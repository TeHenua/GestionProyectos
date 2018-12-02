package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Modo;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class VHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VHome frame = new VHome();
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
	public VHome() {
		setTitle("Gesti\u00F3n de Proyectos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JLabel lblBaseDeDatos = new JLabel("Base de Datos");
		lblBaseDeDatos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(lblBaseDeDatos);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		menuBar.add(mnProveedores);
		
		JMenu mnGestinDeProveedores = new JMenu("Gesti\u00F3n de Proveedores");
		mnProveedores.add(mnGestinDeProveedores);
		
		//PROVEEDORES
		JMenuItem mntmAltas = new JMenuItem("Altas");
		mntmAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.INSERTAR);
			}
		});
		mnGestinDeProveedores.add(mntmAltas);
		
		JMenuItem mntmBajas = new JMenuItem("Bajas");
		mntmBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.ELIMINAR);
			}
		});
		mnGestinDeProveedores.add(mntmBajas);
		
		JMenuItem mntmModificaciones = new JMenuItem("Modificaciones");
		mntmModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.MODIFICAR);
			}
		});
		mnGestinDeProveedores.add(mntmModificaciones);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.LISTAR);
			}
		});
		mnGestinDeProveedores.add(mntmListado);
		
		JMenu mnConsultaDeProveedores = new JMenu("Consulta de Proveedores");
		mnProveedores.add(mnConsultaDeProveedores);
		
		JMenuItem mntmPorCdigo = new JMenuItem("Consulta por C\u00F3digo");
		mntmPorCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedorCodigo vpc = new VProveedorCodigo();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorCdigo);
		
		JMenuItem mntmPorNombre = new JMenuItem("Consulta por Nombre");
		mntmPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedorNombre vpc = new VProveedorNombre();				
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorNombre);
		
		JMenuItem mntmPorDireccin = new JMenuItem("Consulta por Direcci\u00F3n");
		mntmPorDireccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedorDireccion vpc = new VProveedorDireccion();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorDireccin);
		
		JMenu mnPiezas = new JMenu("Piezas");
		menuBar.add(mnPiezas);
		
		JMenu mnGestinDePiezas = new JMenu("Gesti\u00F3n de Piezas");
		mnPiezas.add(mnGestinDePiezas);
		
		//PIEZAS
		JMenuItem menuItem = new JMenuItem("Altas");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezas vp = new VPiezas();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.INSERTAR);
			}
		});
		mnGestinDePiezas.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("Bajas");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezas vp = new VPiezas();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.ELIMINAR);
			}
		});
		mnGestinDePiezas.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Modificaciones");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezas vp = new VPiezas();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.MODIFICAR);
			}
		});
		mnGestinDePiezas.add(menuItem_3);
		
		JMenuItem menuItem_1 = new JMenuItem("Listado");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezas vp = new VPiezas();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.LISTAR);
			}
		});
		mnGestinDePiezas.add(menuItem_1);
		
		JMenu mnConsultaPiezas = new JMenu("Consulta de Piezas");
		mnPiezas.add(mnConsultaPiezas);
		
		JMenuItem menuItem_4 = new JMenuItem("Consulta por C\u00F3digo");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezaCodigo vpc = new VPiezaCodigo();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarPiezas();
			}
		});
		mnConsultaPiezas.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Consulta por Nombre");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezaNombre vpc = new VPiezaNombre();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarPiezas();
			}
		});
		mnConsultaPiezas.add(menuItem_5);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenu mnGestinDeProyectos = new JMenu("Gesti\u00F3n de Proyectos");
		mnProyectos.add(mnGestinDeProyectos);
		//PROYECTOS
		JMenuItem menuItem_6 = new JMenuItem("Altas");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectos vp = new VProyectos();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.INSERTAR);
			}
		});
		mnGestinDeProyectos.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Bajas");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectos vp = new VProyectos();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.ELIMINAR);
			}
		});
		mnGestinDeProyectos.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Modificaciones");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectos vp = new VProyectos();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.MODIFICAR);
			}
		});
		mnGestinDeProyectos.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("Listado");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectos vp = new VProyectos();
				vp.setLocation(150,180);
				vp.setVisible(true);
				vp.cambiarModo(Modo.LISTAR);
			}
		});
		mnGestinDeProyectos.add(menuItem_9);
		
		JMenu mnConsultaDeProyectos = new JMenu("Consulta de Proyectos");
		mnProyectos.add(mnConsultaDeProyectos);
		
		JMenuItem menuItem_10 = new JMenuItem("Consulta por C\u00F3digo");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectoCodigo vpc = new VProyectoCodigo();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProyectos();
			}
		});
		mnConsultaDeProyectos.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("Consulta por Nombre");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectoNombre vpc = new VProyectoNombre();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProyectos();
			}
		});
		mnConsultaDeProyectos.add(menuItem_11);
		
		JMenuItem mntmConsultaPorCiudad = new JMenuItem("Consulta por Ciudad");
		mntmConsultaPorCiudad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProyectoCiudad vpc = new VProyectoCiudad();
				vpc.setLocation(150,180);
				vpc.setVisible(true);
				vpc.cargarProyectos();
			}
		});
		mnConsultaDeProyectos.add(mntmConsultaPorCiudad);
		
		JMenu mnGestin = new JMenu("Gesti\u00F3n Global");
		menuBar.add(mnGestin);
		
		JMenuItem mntmPiezasProveedoresY = new JMenuItem("Piezas, Proveedores y Productos");
		mntmPiezasProveedoresY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VPiezasProveedoresProductos vpp = new VPiezasProveedoresProductos();
				vpp.setLocation(150,180);
				vpp.setVisible(true);
				vpp.cargarDatos();
			}
		});
		mnGestin.add(mntmPiezasProveedoresY);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Suministros por Proveedor");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VSuministrosProveedor vsp = new VSuministrosProveedor();
				vsp.setLocation(150, 200);
				vsp.setVisible(true);
				vsp.cargarProveedores();
				
			}
		});
		mnGestin.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Suministros por Piezas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VSuministrosPiezas vss = new VSuministrosPiezas();
				vss.setLocation(150, 200);
				vss.setVisible(true);
				vss.cargarPiezas();
			}
		});
		mnGestin.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Estad\u00EDsticas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnGestin.add(mntmNewMenuItem_2);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(0, 0, 982, 527);
		imagen.setIcon(new ImageIcon(VHome.class.getResource("../fondo.png")));
		contentPane.add(imagen);
	}
}
