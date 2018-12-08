package Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Hibernate.Gestion;
import Hibernate.Piezas;
import Hibernate.Proveedores;
import Hibernate.Proyectos;
import Hibernate.Sesion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VEstadisticas extends JFrame {

	private JPanel contentPane;
	private JTextField jtPiezaMasCantidad;
	private JTextField jtPiezaMasCantidadDes;
	private JTextField jtPiezaMasProyec;
	private JTextField jtPiezaMasProyecDes;
	private JTextField jtProveedMasPiez;
	private JTextField jtProveedMasPiezDes;
	private JTextField jtProveedMasPro;
	private JTextField jtProveedMasProNum;
	private JLabel lblProveedorQueHa_2;
	private JTextField jtProveedMasPie;
	private JTextField jtProveedMasPieNum;
	private List<Gestion> gestiones;
	private List<Proveedores> proveedores;
	private List<Proyectos> proyectos;
	private List<Piezas> piezas;
	
	public void cargarEstadisticas() {
		gestiones = Sesion.cargarGestiones();
		proveedores = Sesion.cargarProveedores();
		proyectos = Sesion.cargarProyectos();
		piezas = Sesion.cargarPiezas();
		
		piezaMasCantidad();
		piezaMasProyectos();
		proveedorMasPiezas();
		proveedorMasProyectos();
		proveedorMasPiezasDif();
	}
	
	private void piezaMasCantidad(){
		ArrayList<Float> cantidades = new ArrayList<>();
		for(int i=0;i<piezas.size();i++){
			cantidades.add((float) 0.0);
		}
		for(int i=0;i<piezas.size();i++){
			for(Gestion g:gestiones){
				if(g.getId().getCodpieza().equals(piezas.get(i).getCodigo())){
					cantidades.set(i, cantidades.get(i)+g.getCantidad());
				}
			}
		}
		Float max=Float.MIN_VALUE;
		String cod = "";
		String des = "";
		for(int i=0;i<cantidades.size();i++){
			if(cantidades.get(i)>max){
				max=cantidades.get(i);
				cod=piezas.get(i).getCodigo();
				des=piezas.get(i).getNombre();
			}
		}
		jtPiezaMasCantidad.setText(cod);
		jtPiezaMasCantidadDes.setText(des);
	}
	
	private void piezaMasProyectos(){
		ArrayList<Float> cantidades = new ArrayList<>();
		for(int i=0;i<piezas.size();i++){
			cantidades.add((float) 0.0);
		}
		for(int i=0;i<piezas.size();i++){
			for(Gestion g:gestiones){
				if(g.getId().getCodpieza().equals(piezas.get(i).getCodigo())){
					cantidades.set(i, cantidades.get(i)+1);
				}
			}
		}
		Float max=Float.MIN_VALUE;
		String cod = "";
		String des = "";
		for(int i=0;i<cantidades.size();i++){
			if(cantidades.get(i)>max){
				max=cantidades.get(i);
				cod=piezas.get(i).getCodigo();
				des=piezas.get(i).getNombre();
			}
		}
		jtPiezaMasProyec.setText(cod);
		jtPiezaMasProyecDes.setText(des);
	}
	
	private void proveedorMasPiezas(){
		ArrayList<Float> cantidades = new ArrayList<>();
		for(int i=0;i<proveedores.size();i++){
			cantidades.add((float) 0.0);
		}
		for(int i=0;i<proveedores.size();i++){
			for(Gestion g:gestiones){
				if(g.getId().getCodproveedor().equals(proveedores.get(i).getCodigo())){
					cantidades.set(i, cantidades.get(i)+g.getCantidad());
				}
			}
		}
		Float max=Float.MIN_VALUE;
		String cod = "";
		String des = "";
		for(int i=0;i<cantidades.size();i++){
			if(cantidades.get(i)>max){
				max=cantidades.get(i);
				cod=proveedores.get(i).getCodigo();
				des=proveedores.get(i).getNombre();
			}
		}
		jtProveedMasPiez.setText(cod);
		jtProveedMasPiezDes.setText(des);
	}
	
	private void proveedorMasProyectos(){
		ArrayList<Integer> cantidades = new ArrayList<>();
		for(int i=0;i<proveedores.size();i++){
			cantidades.add(0);
		}
		for(int i=0;i<proveedores.size();i++){
			for(Gestion g:gestiones){
				if(g.getId().getCodproveedor().equals(proveedores.get(i).getCodigo())){
					cantidades.set(i, cantidades.get(i)+1);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		String cod = "";
		String des = "";
		for(int i=0;i<cantidades.size();i++){
			if(cantidades.get(i)>max){
				max=cantidades.get(i);
				cod=proveedores.get(i).getCodigo();
			}
		}
		jtProveedMasPro.setText(cod);
		jtProveedMasProNum.setText(String.valueOf(max));
	}
	
	private void proveedorMasPiezasDif(){
		int[][] cont = new int[proveedores.size()][piezas.size()];
		for(int i=0;i<proveedores.size();i++){
			for(int j=0;j<piezas.size();j++){
				for(Gestion g:gestiones){
					if(g.getId().getCodproveedor().equals(proveedores.get(i).getCodigo())){
						if(g.getId().getCodpieza().equals(piezas.get(j).getCodigo())){
							cont[i][j] ++;
						}
					}
				}
			}
		}
		int max = Integer.MIN_VALUE;
		String codProv = "";
		int[] contProv = new int[proveedores.size()];
		for(int i=0;i<proveedores.size();i++){
			for(int j=0;j<piezas.size();j++){
				contProv[i]+=cont[i][j];
			}
		}
		for(int i=0;i<contProv.length;i++){
			if(contProv[i]>max){
				max=contProv[i];
				codProv = proveedores.get(i).getCodigo();
			}
		}
		jtProveedMasPie.setText(codProv);
		jtProveedMasPieNum.setText(String.valueOf(max));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VEstadisticas frame = new VEstadisticas();
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
	public VEstadisticas() {
		setTitle("RES\u00DAMENES ESTAD\u00CDSTICOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResmenesEstadsticos = new JLabel("RES\u00DAMENES ESTAD\u00CDSTICOS - PIEZAS PROYECTOS Y PROVEEDORES");
		lblResmenesEstadsticos.setHorizontalAlignment(SwingConstants.CENTER);
		lblResmenesEstadsticos.setFont(new Font("Verdana", Font.BOLD, 20));
		lblResmenesEstadsticos.setBounds(12, 32, 858, 16);
		contentPane.add(lblResmenesEstadsticos);
		
		JButton btnProy = new JButton("N\u00BA de piezas y cantidad de piezas suministradas en proyectos");
		btnProy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnProy.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnProy.setBounds(47, 76, 798, 31);
		contentPane.add(btnProy);
		
		JLabel lblPiezaDeLa = new JLabel("Pieza de la que se ha suministrado m\u00E1s cantidad:");
		lblPiezaDeLa.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPiezaDeLa.setBounds(36, 132, 446, 31);
		contentPane.add(lblPiezaDeLa);
		
		jtPiezaMasCantidad = new JTextField();
		jtPiezaMasCantidad.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPiezaMasCantidad.setEnabled(false);
		jtPiezaMasCantidad.setColumns(10);
		jtPiezaMasCantidad.setBounds(494, 132, 128, 31);
		contentPane.add(jtPiezaMasCantidad);
		
		jtPiezaMasCantidadDes = new JTextField();
		jtPiezaMasCantidadDes.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPiezaMasCantidadDes.setEnabled(false);
		jtPiezaMasCantidadDes.setColumns(10);
		jtPiezaMasCantidadDes.setBounds(634, 132, 225, 31);
		contentPane.add(jtPiezaMasCantidadDes);
		
		JLabel lblPiezaQueSe = new JLabel("Pieza que se ha suministrado a m\u00E1s proyectos:");
		lblPiezaQueSe.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPiezaQueSe.setBounds(36, 186, 446, 31);
		contentPane.add(lblPiezaQueSe);
		
		jtPiezaMasProyec = new JTextField();
		jtPiezaMasProyec.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPiezaMasProyec.setEnabled(false);
		jtPiezaMasProyec.setColumns(10);
		jtPiezaMasProyec.setBounds(494, 186, 128, 31);
		contentPane.add(jtPiezaMasProyec);
		
		jtPiezaMasProyecDes = new JTextField();
		jtPiezaMasProyecDes.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtPiezaMasProyecDes.setEnabled(false);
		jtPiezaMasProyecDes.setColumns(10);
		jtPiezaMasProyecDes.setBounds(634, 186, 225, 31);
		contentPane.add(jtPiezaMasProyecDes);
		
		JButton btnProv = new JButton("N\u00BA de piezas y cantidad de piezas suministradas por proveedor");
		btnProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VTablaProyectos vtp = new VTablaProyectos();
				vtp.setLocation(150,400);
				vtp.setVisible(true);
				vtp.cargarDatos();
			}
		});
		btnProv.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnProv.setBounds(47, 247, 798, 31);
		contentPane.add(btnProv);
		
		JLabel lblProveedorQueHa = new JLabel("Proveedor que ha suministrado m\u00E1s cantidad de piezas:");
		lblProveedorQueHa.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProveedorQueHa.setBounds(36, 303, 507, 31);
		contentPane.add(lblProveedorQueHa);
		
		jtProveedMasPiez = new JTextField();
		jtProveedMasPiez.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasPiez.setEnabled(false);
		jtProveedMasPiez.setColumns(10);
		jtProveedMasPiez.setBounds(555, 303, 106, 31);
		contentPane.add(jtProveedMasPiez);
		
		jtProveedMasPiezDes = new JTextField();
		jtProveedMasPiezDes.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasPiezDes.setEnabled(false);
		jtProveedMasPiezDes.setColumns(10);
		jtProveedMasPiezDes.setBounds(673, 303, 186, 31);
		contentPane.add(jtProveedMasPiezDes);
		
		JLabel lblProveedorQueHa_1 = new JLabel("Proveedor que ha suministrado a m\u00E1s proyectos / n\u00BA proyectos:");
		lblProveedorQueHa_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProveedorQueHa_1.setBounds(36, 357, 586, 31);
		contentPane.add(lblProveedorQueHa_1);
		
		jtProveedMasPro = new JTextField();
		jtProveedMasPro.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasPro.setEnabled(false);
		jtProveedMasPro.setColumns(10);
		jtProveedMasPro.setBounds(635, 357, 106, 31);
		contentPane.add(jtProveedMasPro);
		
		jtProveedMasProNum = new JTextField();
		jtProveedMasProNum.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasProNum.setEnabled(false);
		jtProveedMasProNum.setColumns(10);
		jtProveedMasProNum.setBounds(753, 357, 106, 31);
		contentPane.add(jtProveedMasProNum);
		
		lblProveedorQueHa_2 = new JLabel("Proveedor que ha suministrado m\u00E1s piezas / n\u00BA de piezas:");
		lblProveedorQueHa_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblProveedorQueHa_2.setBounds(36, 409, 586, 31);
		contentPane.add(lblProveedorQueHa_2);
		
		jtProveedMasPie = new JTextField();
		jtProveedMasPie.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasPie.setEnabled(false);
		jtProveedMasPie.setColumns(10);
		jtProveedMasPie.setBounds(635, 409, 106, 31);
		contentPane.add(jtProveedMasPie);
		
		jtProveedMasPieNum = new JTextField();
		jtProveedMasPieNum.setFont(new Font("Verdana", Font.PLAIN, 18));
		jtProveedMasPieNum.setEnabled(false);
		jtProveedMasPieNum.setColumns(10);
		jtProveedMasPieNum.setBounds(753, 409, 106, 31);
		contentPane.add(jtProveedMasPieNum);
	}


}
