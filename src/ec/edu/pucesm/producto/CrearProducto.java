package ec.edu.pucesm.producto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class CrearProducto extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private DefaultTableModel model;
	private JTextField txtFieldCodigo;
	private JTextField txtFieldCantidad;
	private JTextField txtFieldDescripcion;
	private JTextField txtFieldPrecio;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProducto frame = new CrearProducto();
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
	public CrearProducto() {
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 457, 583);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 51, 77, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 100, 77, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(33, 152, 77, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 202, 77, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtFieldCodigo = new JTextField();
		txtFieldCodigo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldCodigo.setBounds(146, 49, 193, 20);
		getContentPane().add(txtFieldCodigo);
		txtFieldCodigo.setColumns(10);
		
		txtFieldCantidad = new JTextField();
		txtFieldCantidad.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldCantidad.setBounds(146, 98, 193, 20);
		getContentPane().add(txtFieldCantidad);
		txtFieldCantidad.setColumns(10);
		
		txtFieldDescripcion = new JTextField();
		txtFieldDescripcion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldDescripcion.setBounds(146, 150, 193, 20);
		getContentPane().add(txtFieldDescripcion);
		txtFieldDescripcion.setColumns(10);
		
		txtFieldPrecio = new JTextField();
		txtFieldPrecio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldPrecio.setBounds(146, 200, 193, 20);
		getContentPane().add(txtFieldPrecio);
		txtFieldPrecio.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 373, 404, 156);
		getContentPane().add(scrollPane);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(55, 279, 89, 23);
		getContentPane().add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(175, 279, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(311, 279, 89, 23);
		getContentPane().add(btnCancelar);
		
		
		String[] columnNames = {
				"Codigo",
                "Cantidad",
                "Descripcion",
                "Precio Unitario",
                "Precio final"};
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNuevo) {
			nuevo();			
		} else if (e.getSource() == btnGuardar) {
			guardar();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
		
	}

	private void guardar() {
		Producto producto = new Producto(txtFieldCodigo.getText(), Integer.parseInt(txtFieldCantidad.getText()), txtFieldDescripcion.getText(), Float.valueOf(txtFieldPrecio.getText()));
		Object[] row = new Object[5];
		row[0] = producto.getCodigo();
		row[1] = producto.getCantidad();
		row[2] = producto.getDescripcion();
		row[3] = producto.getPrecio();
		row[4] = producto.precioFinal();
		
		model.addRow(row);
		
		
	}

	private void nuevo() {
		Producto producto = new Producto();
		txtFieldCodigo.setText(producto.getCodigo());
		txtFieldCantidad.setText(producto.getCantidad() + "");
		txtFieldDescripcion.setText(producto.getDescripcion());
		txtFieldPrecio.setText(producto.getPrecio() + "");		
	}
}
