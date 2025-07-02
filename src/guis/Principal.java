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
import java.awt.SystemColor;

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
					frame.setLocationRelativeTo(null);
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
		setTitle("SISTEMA DE MATRICULA | CIBERTEC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(70, 130, 180));
		menuBar.setBounds(0, 0, 909, 39);
		contentPane.add(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(new Color(255, 255, 255));
		mnArchivo.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/img/salir.png")));
		mntmSalir.setBackground(new Color(255, 255, 255));
		mntmSalir.addActionListener(this);
		mntmSalir.setForeground(new Color(0, 0, 0));
		mntmSalir.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setForeground(new Color(255, 255, 255));
		mnMantenimiento.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnMantenimiento);
		
		mntmAlumnos = new JMenuItem("Alumnos");
		mntmAlumnos.setForeground(new Color(0, 0, 0));
		mntmAlumnos.setIcon(new ImageIcon(Principal.class.getResource("/img/alumno.png")));
		mntmAlumnos.setBackground(new Color(255, 255, 255));
		mntmAlumnos.addActionListener(this);
		mntmAlumnos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnMantenimiento.add(mntmAlumnos);
		
		separator1 = new JSeparator();
		mnMantenimiento.add(separator1);
		
		mntmCursos = new JMenuItem("Curso");
		mntmCursos.setIcon(new ImageIcon(Principal.class.getResource("/img/curso.png")));
		mntmCursos.setBackground(Color.WHITE);
		mntmCursos.addActionListener(this);
		mntmCursos.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnMantenimiento.add(mntmCursos);
		
		mnRegistro = new JMenu("Registro");
		mnRegistro.setForeground(new Color(255, 255, 255));
		mnRegistro.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnRegistro);
		
		mntmMatrícula = new JMenuItem("Matrícula");
		mntmMatrícula.setIcon(new ImageIcon(Principal.class.getResource("/img/matri.png")));
		mntmMatrícula.setBackground(new Color(255, 255, 255));
		mntmMatrícula.addActionListener(this);
		mntmMatrícula.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnRegistro.add(mntmMatrícula);
		
		separator2 = new JSeparator();
		mnRegistro.add(separator2);
		
		mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.setIcon(new ImageIcon(Principal.class.getResource("/img/reti.png")));
		mntmRetiro.setBackground(new Color(255, 255, 255));
		mntmRetiro.addActionListener(this);
		mntmRetiro.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnRegistro.add(mntmRetiro);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setForeground(new Color(255, 255, 255));
		mnConsulta.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnConsulta);
		
		mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.setIcon(new ImageIcon(Principal.class.getResource("/img/consulta.png")));
		mntmAlumno.setBackground(Color.WHITE);
		mntmAlumno.addActionListener(this);
		mntmAlumno.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnConsulta.add(mntmAlumno);
		
		separator = new JSeparator();
		mnConsulta.add(separator);
		
		mntmCurso2 = new JMenuItem("Curso");
		mntmCurso2.addActionListener(this);
		mntmCurso2.setIcon(new ImageIcon(Principal.class.getResource("/img/consulta.png")));
		mntmCurso2.setBackground(Color.WHITE);
		mntmCurso2.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnConsulta.add(mntmCurso2);
		
		separator_1 = new JSeparator();
		mnConsulta.add(separator_1);
		
		mntmMatrí = new JMenuItem("Matrícula");
		mntmMatrí.addActionListener(this);
		mntmMatrí.setIcon(new ImageIcon(Principal.class.getResource("/img/consulta.png")));
		mntmMatrí.setBackground(Color.WHITE);
		mntmMatrí.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnConsulta.add(mntmMatrí);
		
		separator_2 = new JSeparator();
		mnConsulta.add(separator_2);
		
		mntmReti = new JMenuItem("Retiro");
		mntmReti.addActionListener(this);
		mntmReti.setIcon(new ImageIcon(Principal.class.getResource("/img/consulta.png")));
		mntmReti.setBackground(Color.WHITE);
		mntmReti.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnConsulta.add(mntmReti);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setForeground(new Color(255, 255, 255));
		mnReporte.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		menuBar.add(mnReporte);
		
		mntmGeneral = new JMenuItem("General");
		mntmGeneral.setIcon(new ImageIcon(Principal.class.getResource("/img/reporte.png")));
		mntmGeneral.setBackground(Color.WHITE);
		mntmGeneral.setFont(new Font("Segoe UI Black", Font.PLAIN, 13));
		mnReporte.add(mntmGeneral);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon(Principal.class.getResource("/img/principal.png")));
		lblImagen.setBounds(0, 35, 909, 554);
		contentPane.add(lblImagen);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReti) {
			actionPerformedMntmReti(e);
		}
		if (e.getSource() == mntmMatrí) {
			actionPerformedMntmMatrí(e);
		}
		if (e.getSource() == mntmCurso2) {
			actionPerformedMntmCurso2(e);
		}
		if (e.getSource() == mntmAlumno) {
			actionPerformedMntmAlumno(e);
		}
		if (e.getSource() == mntmRetiro) {
			actionPerformedMntmRetiro(e);
		}
		if (e.getSource() == mntmMatrícula) {
			actionPerformedMntmMatrícula(e);
		}
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
	protected void actionPerformedMntmMatrícula(ActionEvent e) {
		DlgMatricula dc = new DlgMatricula();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
	protected void actionPerformedMntmRetiro(ActionEvent e) {
		DlgRetiro dc = new DlgRetiro();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
	protected void actionPerformedMntmAlumno(ActionEvent e) {
		DlgConsuAlumno dc = new DlgConsuAlumno();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
	

	protected void actionPerformedMntmCurso2(ActionEvent e) {
		DlgConsuCurso dc = new DlgConsuCurso();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
	protected void actionPerformedMntmMatrí(ActionEvent e) {
		DlConsuMatricula dc = new DlConsuMatricula();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
		
	}
	protected void actionPerformedMntmReti(ActionEvent e) {
		DlgConsuRetiro dc = new DlgConsuRetiro();
		 dc.setLocationRelativeTo(this);
		 dc.setVisible(true);
	}
}
