package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class DlgMantenimiento extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JButton btnBuscar;
	private JComboBox cboEstado;
	private JButton btnAdicionar;
	private JButton btnOk;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scpPane;
	private JTable tablaEstudiantes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMantenimiento dialog = new DlgMantenimiento();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgMantenimiento() {
		getContentPane().setBackground(new Color(51, 153, 204));
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCodigo.setBounds(10, 11, 68, 32);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(81, 19, 113, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblNombre.setBounds(10, 54, 68, 32);
		getContentPane().add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblApellidos.setBounds(10, 99, 68, 32);
		getContentPane().add(lblApellidos);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblDNI.setBounds(10, 142, 68, 32);
		getContentPane().add(lblDNI);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblEdad.setBounds(10, 187, 68, 32);
		getContentPane().add(lblEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCelular.setBounds(10, 230, 68, 32);
		getContentPane().add(lblCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblEstado.setBounds(10, 274, 68, 32);
		getContentPane().add(lblEstado);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(81, 62, 212, 20);
		getContentPane().add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(81, 107, 212, 20);
		getContentPane().add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(81, 150, 212, 20);
		getContentPane().add(txtDni);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(81, 195, 212, 20);
		getContentPane().add(txtEdad);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(81, 238, 212, 20);
		getContentPane().add(txtCelular);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.setBackground(new Color(102, 204, 102));
		btnBuscar.setBounds(204, 18, 89, 23);
		getContentPane().add(btnBuscar);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		cboEstado.setBackground(new Color(204, 204, 204));
		cboEstado.setForeground(new Color(0, 0, 0));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado", "Matrículado", "Retirado"}));
		cboEstado.setBounds(81, 281, 113, 25);
		getContentPane().add(cboEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(new Color(255, 255, 255));
		btnAdicionar.setBackground(new Color(102, 204, 102));
		btnAdicionar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnAdicionar.setBounds(352, 99, 176, 165);
		getContentPane().add(btnAdicionar);
		
		btnOk = new JButton("Ok");
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnOk.setBackground(new Color(102, 204, 102));
		btnOk.setBounds(204, 281, 89, 23);
		getContentPane().add(btnOk);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConsultar.setBackground(new Color(102, 204, 102));
		btnConsultar.setBounds(598, 87, 176, 40);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnModificar.setBackground(new Color(102, 204, 102));
		btnModificar.setBounds(598, 149, 176, 40);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(102, 204, 102));
		btnEliminar.setBounds(598, 215, 176, 40);
		getContentPane().add(btnEliminar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 321, 764, 229);
		getContentPane().add(scpPane);
		
		tablaEstudiantes = new JTable();
		tablaEstudiantes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"C\u00D3DIGO", "NOMBRES", "APELLIDOS", "DNI", "EDAD", "CELULAR", "ESTADO"
			}
		));
		scpPane.setViewportView(tablaEstudiantes);
		setBounds(100, 100, 800, 600);

	}
}
