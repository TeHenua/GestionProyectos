package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Piezas;
import Hibernate.Proveedores;
import Hibernate.Sesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

public class VPiezaNombre extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JComboBox comboBox;
	private JTextPane textPane;
	private List<Piezas> piezas;
	private List<Piezas> piezasCombo;
	private Piezas p;
	
	public void cargarPiezas() {
		piezas = Sesion.cargarPiezas();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPiezaNombre frame = new VPiezaNombre();
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
	public VPiezaNombre() {
		setTitle("Consulta de Piezas por nombre");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Escribe el nombre o parte del nombre");
		label.setFont(new Font("Verdana", Font.PLAIN, 18));
		label.setBounds(47, 33, 342, 26);
		contentPane.add(label);
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(401, 33, 116, 26);
		contentPane.add(tfCodigo);
		
		JButton btnBuscarPieza = new JButton("Buscar Pieza");
		btnBuscarPieza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					comboBox.removeAllItems();
					textPane.setText("");
					Iterator it = piezas.iterator();
					piezasCombo = new ArrayList<>();
					while(it.hasNext()){
						Piezas pro = (Piezas) it.next();
						if(pro.getNombre().toLowerCase().contains(tfCodigo.getText().toLowerCase())){
							piezasCombo.add(pro);
							comboBox.addItem(pro.getCodigo()+" "+pro.getDescipcion());
							encontrado = true;
						}
					}
					if(!encontrado){
						JOptionPane.showMessageDialog(contentPane, "Pieza no encontrada", "Búsqueda de piezas", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de piezas", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBuscarPieza.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarPieza.setBounds(529, 33, 285, 25);
		contentPane.add(btnBuscarPieza);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>-1){
					p = piezasCombo.get(comboBox.getSelectedIndex());
					String salida = "\nCÓDIGO: "+p.getCodigo().toString()+"\n\n";
					salida += "NOMBRE: "+p.getNombre()+"\n\n";
					salida += "PRECIO: "+p.getPrecio()+"\n\n";
					salida += "DESCRIPCIÓN: "+p.getDescipcion()+"\n\n";
					textPane.setText(salida);	
				}
				
			}
		});
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(232, 98, 385, 26);
		contentPane.add(comboBox);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(232, 156, 385, 263);
		contentPane.add(textPane);
	}



}
