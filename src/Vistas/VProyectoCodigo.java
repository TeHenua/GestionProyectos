package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Proveedores;
import Hibernate.Proyectos;
import Hibernate.Sesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class VProyectoCodigo extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JComboBox comboBox;
	private JTextPane textPane;
	private List<Proyectos> proyectos;
	private List<Proyectos> proyectosCombo;
	private Proyectos p;


	public void cargarProyectos() {
		proyectos = Sesion.cargarProyectos();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectoCodigo frame = new VProyectoCodigo();
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
	public VProyectoCodigo() {
		setTitle("Consulta de Proyectos por c\u00F3digo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Escribe el c\u00F3digo o parte del c\u00F3digo");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(65, 29, 326, 26);
		contentPane.add(label);
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(403, 29, 116, 26);
		contentPane.add(tfCodigo);
		
		JButton btnBuscarProyecto = new JButton("Buscar Proyecto");
		btnBuscarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					comboBox.removeAllItems();
					textPane.setText("");
					Iterator it = proyectos.iterator();
					proyectosCombo = new ArrayList<>();
					while(it.hasNext()){
						Proyectos pro = (Proyectos) it.next();
						if(pro.getCodigo().toLowerCase().contains(tfCodigo.getText().toLowerCase())){
							proyectosCombo.add(pro);
							comboBox.addItem(pro.getNombre()+" "+pro.getCiudad());
							encontrado = true;
						}
					}
					if(!encontrado){
						JOptionPane.showMessageDialog(contentPane, "Proyecto no encontrado", "Búsqueda de proyectos", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de proyectos", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBuscarProyecto.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarProyecto.setBounds(531, 29, 285, 25);
		contentPane.add(btnBuscarProyecto);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>-1){
					p = proyectosCombo.get(comboBox.getSelectedIndex());
					String salida = "\nCÓDIGO: "+p.getCodigo().toString()+"\n\n";
					salida += "NOMBRE: "+p.getNombre()+"\n\n";
					salida += "APELLIDOS: "+p.getCiudad()+"\n\n";
					textPane.setText(salida);	
				}	
			}
		});
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(234, 94, 385, 26);
		contentPane.add(comboBox);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(234, 152, 385, 263);
		contentPane.add(textPane);
	}



}
