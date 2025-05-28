package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DlgConsuAlumno extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodAlum;
	private JTextField txtCodAlum;
	private JScrollPane scpPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsuAlumno dialog = new DlgConsuAlumno();
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
	public DlgConsuAlumno() {
		setTitle("Consulta | Alumno");
		getContentPane().setBackground(new Color(51, 153, 204));
		getContentPane().setLayout(null);
		
		lblCodAlum = new JLabel("Código del alumno");
		lblCodAlum.setForeground(Color.WHITE);
		lblCodAlum.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblCodAlum.setBounds(10, 11, 132, 32);
		getContentPane().add(lblCodAlum);
		
		txtCodAlum = new JTextField();
		txtCodAlum.setColumns(10);
		txtCodAlum.setBounds(141, 19, 159, 20);
		getContentPane().add(txtCodAlum);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 54, 542, 361);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		setBounds(100, 100, 578, 477);

	}
}
