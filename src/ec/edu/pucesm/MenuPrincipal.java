package ec.edu.pucesm;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.pucesm.cliente.Cliente;
import ec.edu.pucesm.cliente.CrearCliente;
import ec.edu.pucesm.producto.CrearProducto;
import ec.edu.pucesm.producto.Producto;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

public class MenuPrincipal extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuItem salirApp;
	private JMenuItem crearClientes;
	private JMenuItem crearProductos;
	private JMenuItem crearFactura;
	CrearCliente formCliente;
	CrearProducto formProducto;
	
	public ArrayList<Producto> productos=new ArrayList<>();
	public ArrayList<Cliente> clientes=new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setBackground(new Color(255, 255, 255));
		setTitle("SISTEMA FACTURACION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 515);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(150, 177, 241));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistema");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		salirApp = new JMenuItem("Salir");
		salirApp.addActionListener(this);
		mnNewMenu.add(salirApp);
		
		JMenu mnNewMenu_1 = new JMenu("Clientes");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		crearClientes = new JMenuItem("Crear Clientes");
		crearClientes.addActionListener(this);
		mnNewMenu_1.add(crearClientes);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Lista de Clientes");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Productos");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		crearProductos = new JMenuItem("Crear Producto");
		crearProductos.addActionListener(this);
		mnNewMenu_2.add(crearProductos);
		
		JMenu mnNewMenu_3 = new JMenu("Factura");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);
		
		crearFactura = new JMenuItem("Generar Factura");
		crearFactura.addActionListener(this);
		mnNewMenu_3.add(crearFactura);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, "desktopPane");
		desktopPane.setLayout(null);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == salirApp) {
			System.exit(EXIT_ON_CLOSE);
		} else if (e.getSource().equals(crearClientes)) {
			formCliente = new CrearCliente(clientes);
			crear(formCliente);					
		} else if (e.getSource().equals(crearProductos)) {
			formProducto = new CrearProducto(productos);
			crear(formProducto);	
		} else if (e.getSource().equals(crearFactura)) {
			Factura form = new Factura(clientes, productos);
			crear(form);			
		}		
	}
	
	

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	

	private void crear(JInternalFrame form) {		
		boolean mostrar=true;

		for (int a=0;a<desktopPane.getComponentCount();a++){     
		    if( form.getClass().isInstance( desktopPane.getComponent(a) )){
		        System.out.println("es instancia, no se debe mostrar");
		        mostrar=false;
		    }else{
		        System.out.println("no lo es, puede mostrarse");
		    }
		}
		if(mostrar){ 
			desktopPane.add(form);
			form.setVisible(true);
		}	
		
	}
}
