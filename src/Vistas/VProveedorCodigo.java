package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Proveedores;
import Hibernate.Sesion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VProveedorCodigo extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JComboBox comboBox;
	private JTextPane textPane;
	private List<Proveedores> proveedores;
	private List<Proveedores> proveedoresCombo;
	private Proveedores p;

	public void cargarProveedores() {
		proveedores = Sesion.cargarProveedores();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProveedorCodigo frame = new VProveedorCodigo();
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
	public VProveedorCodigo() {
		setTitle("Consulta de Proveedores por c\u00F3digo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeElCdigo = new JLabel("Escribe el c\u00F3digo o parte del c\u00F3digo");
		lblEscribeElCdigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeElCdigo.setBounds(57, 35, 326, 26);
		contentPane.add(lblEscribeElCdigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(395, 35, 116, 26);
		contentPane.add(tfCodigo);
		
		JButton btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					comboBox.removeAllItems();
					textPane.setText("");
					Iterator it = proveedores.iterator();
					proveedoresCombo = new ArrayList<>();
					while(it.hasNext()){
						Proveedores pro = (Proveedores) it.next();
						if(pro.getCodigo().toLowerCase().contains(tfCodigo.getText().toLowerCase())){
							proveedoresCombo.add(pro);
							comboBox.addItem(pro.getNombre()+" "+pro.getApellidos());
							encontrado = true;
						}
					}
					if(!encontrado){
						JOptionPane.showMessageDialog(contentPane, "Proveedor no encontrado", "Búsqueda de proveedores", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(contentPane, "Debes escribir algo que buscar", "Búsqueda de proveedores", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBuscarProveedor.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnBuscarProveedor.setBounds(523, 35, 285, 25);
		contentPane.add(btnBuscarProveedor);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>-1){
					p = proveedoresCombo.get(comboBox.getSelectedIndex());
					String salida = "\nCÓDIGO: "+p.getCodigo().toString()+"\n\n";
					salida += "NOMBRE: "+p.getNombre()+"\n\n";
					salida += "APELLIDOS: "+p.getApellidos()+"\n\n";
					salida += "DIRECCIÓN: "+p.getDireccion()+"\n\n";
					textPane.setText(salida);	
				}	
			}
		});
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setBounds(226, 100, 385, 26);
		contentPane.add(comboBox);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(226, 158, 385, 263);
		contentPane.add(textPane);
	}


}
