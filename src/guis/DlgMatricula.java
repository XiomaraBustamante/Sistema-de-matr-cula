package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DlgMatricula extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNmeroDeMatrcula;
	private JLabel lblCodAlumno;
	private JLabel lblCodCurso;
	private JTextField txtNumMatri;
	private JComboBox cboCodAlum;
	private JComboBox CodCurso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgMatricula dialog = new DlgMatricula();
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
	public DlgMatricula() {
		setTitle("Registro | Matrícula");
		getContentPane().setBackground(new Color(51, 153, 204));
		getContentPane().setLayout(null);
		
		lblNmeroDeMatrcula = new JLabel("Número de matrícula");
		lblNmeroDeMatrcula.setForeground(Color.WHITE);
		lblNmeroDeMatrcula.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblNmeroDeMatrcula.setBounds(10, 11, 159, 32);
		getContentPane().add(lblNmeroDeMatrcula);
		
		lblCodAlumno = new JLabel("Código del alumno");
		lblCodAlumno.setForeground(Color.WHITE);
		lblCodAlumno.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCodAlumno.setBounds(10, 54, 144, 32);
		getContentPane().add(lblCodAlumno);
		
		lblCodCurso = new JLabel("Código del curso");
		lblCodCurso.setForeground(Color.WHITE);
		lblCodCurso.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCodCurso.setBounds(10, 99, 144, 32);
		getContentPane().add(lblCodCurso);
		
		txtNumMatri = new JTextField();
		txtNumMatri.setBounds(163, 19, 159, 20);
		getContentPane().add(txtNumMatri);
		txtNumMatri.setColumns(10);
		
		cboCodAlum = new JComboBox();
		cboCodAlum.setBounds(160, 62, 162, 20);
		getContentPane().add(cboCodAlum);
		
		CodCurso = new JComboBox();
		CodCurso.setBounds(160, 106, 162, 20);
		getContentPane().add(CodCurso);
		setBounds(100, 100, 800, 600);

	}
}
