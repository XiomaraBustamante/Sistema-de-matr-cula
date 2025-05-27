package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DlgCurso extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblAsignatura;
	private JLabel lblCodigo;
	private JLabel lblCiclo;
	private JLabel lblNumCre;
	private JLabel lblHoras;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JTextField txtAsigna;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnOk;
	private JComboBox cboCiclo;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scpPane;
	private JTable TablaCursos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCurso dialog = new DlgCurso();
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
	public DlgCurso() {
		setTitle("Mantenimiento | Curso");
		getContentPane().setBackground(new Color(51, 153, 204));
		getContentPane().setLayout(null);
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setForeground(Color.WHITE);
		lblAsignatura.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblAsignatura.setBounds(10, 54, 95, 32);
		getContentPane().add(lblAsignatura);
		
		lblCodigo = new JLabel("Código del Curso");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCodigo.setBounds(10, 11, 140, 32);
		getContentPane().add(lblCodigo);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCiclo.setBounds(10, 99, 68, 32);
		getContentPane().add(lblCiclo);
		
		lblNumCre = new JLabel("N° Creditos");
		lblNumCre.setForeground(Color.WHITE);
		lblNumCre.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblNumCre.setBounds(10, 142, 95, 32);
		getContentPane().add(lblNumCre);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setForeground(Color.WHITE);
		lblHoras.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblHoras.setBounds(10, 187, 68, 32);
		getContentPane().add(lblHoras);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(135, 12, 113, 20);
		getContentPane().add(txtCodigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnBuscar.setBackground(new Color(102, 204, 102));
		btnBuscar.setBounds(258, 11, 89, 23);
		getContentPane().add(btnBuscar);
		
		txtAsigna = new JTextField();
		txtAsigna.setColumns(10);
		txtAsigna.setBounds(135, 55, 212, 20);
		getContentPane().add(txtAsigna);
		
		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(135, 143, 212, 20);
		getContentPane().add(txtCreditos);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(135, 188, 113, 20);
		getContentPane().add(txtHoras);
		
		btnOk = new JButton("Ok");
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		btnOk.setBackground(new Color(102, 204, 102));
		btnOk.setBounds(258, 187, 89, 23);
		getContentPane().add(btnOk);
		
		cboCiclo = new JComboBox();
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"Primero", "Segundo", "Tercero", "Cuarto", "Quinto"}));
		cboCiclo.setForeground(Color.BLACK);
		cboCiclo.setFont(new Font("Roboto Condensed", Font.PLAIN, 12));
		cboCiclo.setBackground(new Color(204, 204, 204));
		cboCiclo.setBounds(135, 99, 212, 20);
		getContentPane().add(cboCiclo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnAdicionar.setBackground(new Color(102, 204, 102));
		btnAdicionar.setBounds(382, 45, 154, 143);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnConsultar.setBackground(new Color(102, 204, 102));
		btnConsultar.setBounds(587, 28, 176, 40);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnModificar.setBackground(new Color(102, 204, 102));
		btnModificar.setBounds(587, 89, 176, 40);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		btnEliminar.setBackground(new Color(102, 204, 102));
		btnEliminar.setBounds(587, 156, 176, 40);
		getContentPane().add(btnEliminar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 230, 764, 320);
		getContentPane().add(scpPane);
		
		TablaCursos = new JTable();
		scpPane.setViewportView(TablaCursos);
		setBounds(100, 100, 800, 600);

	}
}
