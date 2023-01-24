package ec.edu.pucesm.cliente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ClientesModel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cliente> clientes; 
	private DefaultTableModel model;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public ClientesModel(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
		setTitle("Lista de Clientes");
		setBounds(100, 100, 600, 427);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 566, 368);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(model.getValueAt(0, 0));
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cedula", "Nombres", "Direccion", "Telefono", "Email" }));
		scrollPane.setViewportView(table);


		model = (DefaultTableModel) table.getModel();
		CargarClientes();

	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void CargarClientes() {
		model.setRowCount(0);
		for (Cliente cliente : clientes) {
			model.addRow(new Object[] {
					cliente.getCedula(),
					cliente.getNombres(),
					cliente.getDireccion(),
					cliente.getTelefono(),
					cliente.getEmail()
			});
			
		}
				
	}
}


