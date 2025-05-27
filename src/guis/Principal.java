package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmAlumnos;
	private JMenuItem mntmCursos;
	private JSeparator separator1;
	private JMenu mnRegistro;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmMatrícula;
	private JMenuItem mntmRetiro;
	private JSeparator separator2;
	private JMenuItem mntmAlumno;
	private JMenuItem mntmCurso2;
	private JMenuItem mntmMatrí;
	private JMenuItem mntmReti;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JMenuItem mntmGeneral;
	private JLabel lblImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 153, 204));
		menuBar.setBounds(0, 0, 784, 48);
		contentPane.add(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(new Color(0, 0, 0));
		mnArchivo.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setForeground(new Color(0, 0, 0));
		mntmSalir.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(new Color(0, 0, 0));
		mnMantenimiento.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		menuBar.add(mnMantenimiento);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.addActionListener(this);
		mntmAlumnos.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnMantenimiento.add(mntmAlumnos);
		
		separator1 = new JSeparator();
		mnMantenimiento.add(separator1);
		
		mntmCursos = new JMenuItem("Curso");
		mntmCursos.addActionListener(this);
		mntmCursos.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnMantenimiento.add(mntmCursos);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setForeground(new Color(0, 0, 0));
		mnRegistro.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		menuBar.add(mnRegistro);
		
		mntmMatrícula = new JMenuItem("Matrícula");
		mntmMatrícula.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnRegistro.add(mntmMatrícula);
		
		separator2 = new JSeparator();
		mnRegistro.add(separator2);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setForeground(new Color(0, 0, 0));
		mnConsulta.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		menuBar.add(mnConsulta);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnConsulta.add(mntmAlumno);
		
		separator = new JSeparator();
		mnConsulta.add(separator);
		
		mntmCurso2 = new JMenuItem("Curso");
		mntmCurso2.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnConsulta.add(mntmCurso2);
		
		separator_1 = new JSeparator();
		mnConsulta.add(separator_1);
		
		mntmMatrí = new JMenuItem("Matrícula");
		mntmMatrí.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnConsulta.add(mntmMatrí);
		
		separator_2 = new JSeparator();
		mnConsulta.add(separator_2);
		
		mntmReti = new JMenuItem("Retiro");
		mntmReti.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnConsulta.add(mntmReti);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setForeground(new Color(0, 0, 0));
		mnReporte.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		menuBar.add(mnReporte);
		
		mntmGeneral = new JMenuItem("General");
		mntmGeneral.setFont(new Font("Roboto Condensed", Font.BOLD, 13));
		mnReporte.add(mntmGeneral);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Principal.class.getResource("/img/MENU.jpg")));
		lblImagen.setBounds(0, 46, 784, 515);
		contentPane.add(lblImagen);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmCursos) {
			actionPerformedMntmCursos(e);
		}
		if (e.getSource() == mntmAlumnos) {
			actionPerformedMntmAlumnos(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent e) {
		System.exit(0);
	}
	
	protected void actionPerformedMntmAlumnos(ActionEvent e) {
		DlgAlumno dc = new DlgAlumno();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
	protected void actionPerformedMntmCursos(ActionEvent e) {
		DlgCurso dc = new DlgCurso();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
}
