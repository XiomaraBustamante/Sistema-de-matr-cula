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
import clases.Alumno;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class DlgAlumno extends JDialog implements MouseListener {

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
	private JScrollPane scpPane;
	private JTable TablaEstudiantes;
	private JComboBox cboEstado;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnOk;
	private JButton btnOpciones;
	private JButton btnNewButton;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumno dialog = new DlgAlumno();
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
	public DlgAlumno() {
		setTitle("Mantenimiento | Alumno");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 11, 68, 32);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(81, 19, 113, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 54, 68, 32);
		getContentPane().add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 99, 68, 32);
		getContentPane().add(lblApellidos);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setForeground(Color.BLACK);
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDNI.setBounds(10, 142, 68, 32);
		getContentPane().add(lblDNI);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(10, 187, 68, 32);
		getContentPane().add(lblEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelular.setBounds(10, 230, 68, 32);
		getContentPane().add(lblCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 321, 764, 229);
		getContentPane().add(scpPane);
		
		TablaEstudiantes = new JTable();
		TablaEstudiantes.addMouseListener(this);
		TablaEstudiantes.setFillsViewportHeight(true);
		scpPane.setViewportView(TablaEstudiantes);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EDAD");
		modelo.addColumn("CELULAR");
		modelo.addColumn("ESTADO");
		TablaEstudiantes.setModel(modelo);
		
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Registrado", "Matrículado", "Retirado"}));
		cboEstado.setBounds(81, 281, 113, 22);
		getContentPane().add(cboEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(204, 18, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(204, 281, 89, 23);
		getContentPane().add(btnOk);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.setBounds(480, 49, 143, 122);
		getContentPane().add(btnOpciones);
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(633, 49, 141, 23);
		getContentPane().add(btnNewButton);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(633, 83, 141, 23);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(633, 118, 141, 23);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(633, 149, 141, 23);
		getContentPane().add(btnEliminar);
		setBounds(100, 100, 800, 600);
		
		
		

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == TablaEstudiantes) {
			mouseClickedTablaEstudiantes(e);
		}
	}
	
	protected void mouseClickedTablaEstudiantes(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
}
