package ec.edu.pucesm.cliente;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CrearCliente extends JInternalFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldName;
	private JTextField txtFieldCI;
	private JTextField txtFieldDir;
	private JTextField txtFieldMail;
	private JTextField txtFieldTlf;
	private JButton btnNuevo;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private DefaultTableModel model;
	private ArrayList<Cliente> clientes; 
	

	/**
	 * Create the frame.
	 */
	public CrearCliente(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		setResizable(true);
		setMaximizable(true);
		setBounds(100, 100, 660, 621);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 51, 77, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 100, 77, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(33, 152, 77, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 202, 77, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(33, 259, 77, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtFieldName = new JTextField();
		txtFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldName.setBounds(146, 97, 193, 20);
		getContentPane().add(txtFieldName);
		txtFieldName.setColumns(10);
		
		txtFieldDir = new JTextField();
		txtFieldDir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldDir.setBounds(146, 149, 193, 20);
		getContentPane().add(txtFieldDir);
		txtFieldDir.setColumns(10);
		
		txtFieldMail = new JTextField();
		txtFieldMail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldMail.setBounds(146, 256, 193, 20);
		getContentPane().add(txtFieldMail);
		txtFieldMail.setColumns(10);
		
		txtFieldTlf = new JTextField();
		txtFieldTlf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldTlf.setBounds(146, 201, 193, 20);
		getContentPane().add(txtFieldTlf);
		txtFieldTlf.setColumns(10);
		
		txtFieldCI = new JTextField();
		txtFieldCI.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtFieldCI.setBounds(146, 50, 193, 20);
		getContentPane().add(txtFieldCI);
		txtFieldCI.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getContentPane().add(btnNuevo);
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAgregar.setBounds(191, 322, 106, 36);
		getContentPane().add(btnAgregar);
		
		
		String[] columnNames = {
				"Cedula",
                "Nombres",
                "Direccion",
                "Telefono",
                "Email"
        };
		
		model = new DefaultTableModel(columnNames, 0);	
		
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCancelar.setBounds(320, 322, 102, 36);
		getContentPane().add(btnCancelar);
		

		JTable table = new JTable();	
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		scrollPane.setBounds(33, 395, 595, 132);
		getContentPane().add(scrollPane);
		
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnNuevo) {
			nuevo();			
		} else if (e.getSource() == btnAgregar) {
			guardar();
		} else if (e.getSource() == btnCancelar) {
			dispose();
		}
		
	}

	private void guardar() {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente(Integer.parseInt(txtFieldCI.getText()), txtFieldName.getText(), txtFieldDir.getText(), Integer.parseInt(txtFieldTlf.getText()), txtFieldMail.getText());
		String cedula = cliente.getCedula() + "";
		String nombres = cliente.getNombres();
		String direccion = cliente.getDireccion();
		String telefono = cliente.getTelefono() + "";
		String email = cliente.getEmail();
		String[] dataRow ={cedula, nombres, direccion, telefono, email};
		model.addRow(dataRow);
		
		clientes.add(cliente);
//		System.out.print(clientes);
		
	}

	private void nuevo() {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		txtFieldCI.setText(cliente.getCedula() + "");
		txtFieldName.setText(cliente.getNombres());
		txtFieldDir.setText(cliente.getDireccion());
		txtFieldTlf.setText(cliente.getTelefono() + "");
		txtFieldMail.setText(cliente.getEmail());
		
	}
	
	
}
