package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Modo;
import Hibernate.Proveedores;
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

public class VProveedorDireccion extends JFrame {

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
					VProveedorDireccion frame = new VProveedorDireccion();
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
	public VProveedorDireccion() {
		setTitle("Consulta de Proveedores por direcci\u00F3n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribeLaDireccin = new JLabel("Escribe la direcci\u00F3n o parte de ella");
		lblEscribeLaDireccin.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblEscribeLaDireccin.setBounds(36, 32, 351, 26);
		contentPane.add(lblEscribeLaDireccin);
		
		tfCodigo = new JTextField();
		tfCodigo.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(399, 32, 116, 26);
		contentPane.add(tfCodigo);
		
		JButton button = new JButton("Buscar Proveedor");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean encontrado = false;
				if(!tfCodigo.getText().equalsIgnoreCase("")){
					comboBox.removeAllItems();
					textPane.setText("");
					Iterator it = proveedores.iterator();
					proveedoresCombo = new ArrayList<>();
					while(it.hasNext()){
						Proveedores pro = (Proveedores) it.next();
						if(pro.getDireccion().toLowerCase().contains(tfCodigo.getText().toLowerCase())){
							proveedoresCombo.add(pro);
							comboBox.addItem(pro.getCodigo()+" "+pro.getNombre());
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
		button.setFont(new Font("Verdana", Font.PLAIN, 18));
		button.setBounds(527, 32, 285, 25);
		contentPane.add(button);
		
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
		comboBox.setBounds(230, 97, 385, 26);
		contentPane.add(comboBox);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Verdana", Font.PLAIN, 15));
		textPane.setBounds(230, 155, 385, 263);
		contentPane.add(textPane);
	}

}
