package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("Gesti\u00F3n de Proyectos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 499);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JLabel lblBaseDeDatos = new JLabel("Base de Datos");
		menuBar.add(lblBaseDeDatos);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		menuBar.add(mnProveedores);
		
		JMenu mnGestinDeProveedores = new JMenu("Gesti\u00F3n de Proveedores");
		mnProveedores.add(mnGestinDeProveedores);
		
		JMenu mnAltas = new JMenu("Altas");
		mnGestinDeProveedores.add(mnAltas);
		
		JMenu mnBajas = new JMenu("Bajas");
		mnGestinDeProveedores.add(mnBajas);
		
		JMenu mnModificaciones = new JMenu("Modificaciones");
		mnGestinDeProveedores.add(mnModificaciones);
		
		JMenu mnLisstado = new JMenu("Listado");
		mnGestinDeProveedores.add(mnLisstado);
		
		JMenu mnConsultaDeProveedores = new JMenu("Consulta de Proveedores");
		mnProveedores.add(mnConsultaDeProveedores);
		
		JMenu mnNewMenu = new JMenu("Por C\u00F3digo");
		mnConsultaDeProveedores.add(mnNewMenu);
		
		JMenu mnPorNombre = new JMenu("Por Nombre");
		mnConsultaDeProveedores.add(mnPorNombre);
		
		JMenu mnPorDireccin = new JMenu("Por Direcci\u00F3n");
		mnConsultaDeProveedores.add(mnPorDireccin);
		
		JMenu mnPiezas = new JMenu("Piezas");
		menuBar.add(mnPiezas);
		
		JMenu mnGestinDePiezas = new JMenu("Gesti\u00F3n de Piezas");
		mnPiezas.add(mnGestinDePiezas);
		
		JMenu mnAltas_1 = new JMenu("Altas");
		mnGestinDePiezas.add(mnAltas_1);
		
		JMenu mnBajas_1 = new JMenu("Bajas");
		mnGestinDePiezas.add(mnBajas_1);
		
		JMenu mnModificaciones_1 = new JMenu("Modificaciones");
		mnGestinDePiezas.add(mnModificaciones_1);
		
		JMenu mnListados = new JMenu("Listados");
		mnGestinDePiezas.add(mnListados);
		
		JMenu mnNewMenu_1 = new JMenu("Consulta de Piezas");
		mnPiezas.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Consulta por C\u00F3digo");
		mnNewMenu_1.add(mnNewMenu_2);
		
		JMenu mnConsultaPorNombre = new JMenu("Consulta por Nombre");
		mnNewMenu_1.add(mnConsultaPorNombre);
		
		JMenu mnProyectos = new JMenu("Proyectos");
		menuBar.add(mnProyectos);
		
		JMenu mnGestinDeProyectos = new JMenu("Gesti\u00F3n de Proyectos");
		mnProyectos.add(mnGestinDeProyectos);
		
		JMenu menu_2 = new JMenu("Altas");
		mnGestinDeProyectos.add(menu_2);
		
		JMenu menu_3 = new JMenu("Bajas");
		mnGestinDeProyectos.add(menu_3);
		
		JMenu menu_4 = new JMenu("Modificaciones");
		mnGestinDeProyectos.add(menu_4);
		
		JMenu mnListado = new JMenu("Listado");
		mnGestinDeProyectos.add(mnListado);
		
		JMenu mnConsultaDeProyectos = new JMenu("Consulta de Proyectos");
		mnProyectos.add(mnConsultaDeProyectos);
		
		JMenu menu_7 = new JMenu("Por C\u00F3digo");
		mnConsultaDeProyectos.add(menu_7);
		
		JMenu menu_8 = new JMenu("Por Nombre");
		mnConsultaDeProyectos.add(menu_8);
		
		JMenu mnPorCiudad = new JMenu("Por Ciudad");
		mnConsultaDeProyectos.add(mnPorCiudad);
		
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
