package ec.edu.pucesm;

import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ec.edu.pucesm.cliente.Cliente;
import ec.edu.pucesm.cliente.ClientesModel;
import ec.edu.pucesm.producto.Producto;
import ec.edu.pucesm.producto.ProductosModel;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Factura extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldNombre;
	private JTextField txtFieldCedula;
	private JTextField txtFieldDireccion;
	private JTextField txtFieldTelefono;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtFieldSubTotal;
	private JTextField txtFieldIva;
	private JTextField txtFieldTotal;
	private ArrayList<Cliente> clientes;
	private ArrayList<Producto> productos;
	/**
	 * Create the frame.
	 */
	public Factura(ArrayList<Cliente> clientes, ArrayList<Producto> productos) {
		this.setClientes(clientes);
		this.setProductos(productos);
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 572, 443);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 38, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula");
		lblNewLabel_1.setBounds(10, 63, 70, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(10, 88, 70, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 113, 70, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtFieldNombre = new JTextField();
		txtFieldNombre.setBackground(new Color(255, 255, 255));
		txtFieldNombre.setEditable(false);
		txtFieldNombre.setBounds(90, 35, 116, 20);
		getContentPane().add(txtFieldNombre);
		txtFieldNombre.setColumns(10);
		
		txtFieldCedula = new JTextField();
		txtFieldCedula.setBackground(new Color(255, 255, 255));
		txtFieldCedula.setEditable(false);
		txtFieldCedula.setBounds(90, 60, 116, 20);
		getContentPane().add(txtFieldCedula);
		txtFieldCedula.setColumns(10);
		
		txtFieldDireccion = new JTextField();
		txtFieldDireccion.setBackground(new Color(255, 255, 255));
		txtFieldDireccion.setEditable(false);
		txtFieldDireccion.setBounds(90, 85, 116, 20);
		getContentPane().add(txtFieldDireccion);
		txtFieldDireccion.setColumns(10);
		
		txtFieldTelefono = new JTextField();
		txtFieldTelefono.setBackground(new Color(255, 255, 255));
		txtFieldTelefono.setEditable(false);
		txtFieldTelefono.setBounds(90, 110, 116, 20);
		getContentPane().add(txtFieldTelefono);
		txtFieldTelefono.setColumns(10);
		
		JButton agregarCliente = new JButton("Buscar Cliente");
		agregarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientesModel clientModel = new ClientesModel(clientes);
				clientModel.setVisible(true);
			}
		});
		agregarCliente.setBounds(216, 34, 133, 23);
		getContentPane().add(agregarCliente);
		
		JLabel lblNewLabel_4 = new JLabel("Num. Factura:");
		lblNewLabel_4.setBounds(366, 10, 88, 17);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(456, 8, 96, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha:");
		lblNewLabel_5.setBounds(401, 38, 45, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(456, 35, 96, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Subtotal");
		lblNewLabel_6.setBounds(401, 319, 49, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Iva");
		lblNewLabel_7.setBounds(401, 344, 49, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Total");
		lblNewLabel_8.setBounds(401, 369, 49, 14);
		getContentPane().add(lblNewLabel_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 542, 141);
		getContentPane().add(scrollPane);
		
		txtFieldSubTotal = new JTextField();
		txtFieldSubTotal.setBounds(456, 316, 96, 20);
		getContentPane().add(txtFieldSubTotal);
		txtFieldSubTotal.setColumns(10);
		
		txtFieldIva = new JTextField();
		txtFieldIva.setBounds(456, 341, 96, 20);
		getContentPane().add(txtFieldIva);
		txtFieldIva.setColumns(10);
		
		txtFieldTotal = new JTextField();
		txtFieldTotal.setBounds(456, 366, 96, 20);
		getContentPane().add(txtFieldTotal);
		txtFieldTotal.setColumns(10);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductosModel productModel = new ProductosModel(productos);
				productModel.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 0));
		btnNewButton.setBounds(304, 133, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quitar");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(439, 133, 89, 23);
		getContentPane().add(btnNewButton_1);

	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
}
