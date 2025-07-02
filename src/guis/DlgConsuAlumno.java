package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsuAlumno extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodAlum;
	private JScrollPane scpPane;
	private JTextArea txtS;
	private JButton btnConsultar;
	private JComboBox cboAlumno;
	private JButton btnCerrar;

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
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		lblCodAlum = new JLabel("Código del alumno");
		lblCodAlum.setForeground(new Color(0, 0, 0));
		lblCodAlum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodAlum.setBounds(10, 11, 132, 32);
		getContentPane().add(lblCodAlum);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 96, 542, 319);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlgConsuAlumno.class.getResource("/img/consultar 1.png")));
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.setBounds(414, 11, 126, 30);
		getContentPane().add(btnConsultar);
		
		cboAlumno = new JComboBox();
		cboAlumno.setBounds(128, 17, 178, 22);
		getContentPane().add(cboAlumno);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DlgConsuAlumno.class.getResource("/img/cerrar.png")));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCerrar.setBounds(414, 52, 126, 30);
		getContentPane().add(btnCerrar);
		setBounds(100, 100, 578, 477);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
