package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
		lblBaseDeDatos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
				vp.setVisible(true);
				vp.cambiarModo(Modo.INSERTAR);
			}
		});
		mnGestinDeProveedores.add(mntmAltas);
		
		JMenuItem mntmBajas = new JMenuItem("Bajas");
		mntmBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setVisible(true);
				vp.cambiarModo(Modo.ELIMINAR);
			}
		});
		mnGestinDeProveedores.add(mntmBajas);
		
		JMenuItem mntmModificaciones = new JMenuItem("Modificaciones");
		mntmModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
				vp.setVisible(true);
				vp.cambiarModo(Modo.MODIFICAR);
			}
		});
		mnGestinDeProveedores.add(mntmModificaciones);
		
		JMenuItem mntmListado = new JMenuItem("Listado");
		mntmListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedores vp = new VProveedores();
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
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorCdigo);
		
		JMenuItem mntmPorNombre = new JMenuItem("Consulta por Nombre");
		mntmPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedorNombre vpc = new VProveedorNombre();
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorNombre);
		
		JMenuItem mntmPorDireccin = new JMenuItem("Consulta por Direcci\u00F3n");
		mntmPorDireccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VProveedorDireccion vpc = new VProveedorDireccion();
				vpc.setVisible(true);
				vpc.cargarProveedores();
			}
		});
		mnConsultaDeProveedores.add(mntmPorDireccin);
		
		JMenu mnPiezas = new JMenu("Piezas");
		menuBar.add(mnPiezas);
		
		JMenu mnGestinDePiezas = new JMenu("Gesti\u00F3n de Piezas");
		mnPiezas.add(mnGestinDePiezas);
		
		JMenuItem menuItem = new JMenuItem("Altas");
		mnGestinDePiezas.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("Bajas");
		mnGestinDePiezas.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Modificaciones");
		mnGestinDePiezas.add(menuItem_3);
		
		JMenuItem menuItem_1 = new JMenuItem("Listado");
		mnGestinDePiezas.add(menuItem_1);
		
		JMenu mnConsultaPiezas = new JMenu("Consulta de Piezas");
		mnPiezas.add(mnConsultaPiezas);
		
		JMenuItem menuItem_4 = new JMenuItem("Consulta por C\u00F3digo");
		mnConsultaPiezas.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Consulta por Nombre");
		mnConsultaPiezas.add(menuItem_5);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenu mnGestinDeProyectos = new JMenu("Gesti\u00F3n de Proyectos");
		mnProyectos.add(mnGestinDeProyectos);
		
		JMenuItem menuItem_6 = new JMenuItem("Altas");
		mnGestinDeProyectos.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Bajas");
		mnGestinDeProyectos.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Modificaciones");
		mnGestinDeProyectos.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("Listado");
		mnGestinDeProyectos.add(menuItem_9);
		
		JMenu mnConsultaDeProyectos = new JMenu("Consulta de Proyectos");
		mnProyectos.add(mnConsultaDeProyectos);
		
		JMenuItem menuItem_10 = new JMenuItem("Consulta por C\u00F3digo");
		mnConsultaDeProyectos.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("Consulta por Nombre");
		mnConsultaDeProyectos.add(menuItem_11);
		
		JMenuItem mntmConsultaPorCiudad = new JMenuItem("Consulta por Ciudad");
		mnConsultaDeProyectos.add(mntmConsultaPorCiudad);
		
		JMenu mnGestin = new JMenu("Gesti\u00F3n Global");
		menuBar.add(mnGestin);
		
		JMenu mnPiezas_1 = new JMenu("Piezas, Proveedores y Productos");
		mnGestin.add(mnPiezas_1);
		
		JMenu mnSuministrosPorProveedor = new JMenu("Suministros por Proveedor");
		mnGestin.add(mnSuministrosPorProveedor);
		
		JMenu mnSuministrosPorPiezas = new JMenu("Suministros por Piezas");
		mnGestin.add(mnSuministrosPorPiezas);
		
		JMenu mnEstadsticas = new JMenu("Estad\u00EDsticas");
		mnGestin.add(mnEstadsticas);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
