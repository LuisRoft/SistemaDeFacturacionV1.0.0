package ec.edu.pucesm.producto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ProductosModel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<Producto> productos;

	/**
	 * Create the frame.
	 */
	public ProductosModel(ArrayList<Producto> productos) {
		this.setProductos(productos);
		setTitle("Lista de Productos");
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Codigo", "Cantidad", "Descripcion", "Precio Unitario", "Precio Total" }));
		scrollPane.setViewportView(table);


		model = (DefaultTableModel) table.getModel();
		CargarProductos();
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public void CargarProductos() {
		model.setRowCount(0);
		for (Producto producto : productos) {
			model.addRow(new Object[] {
					producto.getCodigo(),
					producto.getCantidad(),
					producto.getDescripcion(),
					producto.getPrecio(),
					producto.precioFinal()
			});
			
		}
	}

}

