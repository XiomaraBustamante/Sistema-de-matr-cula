package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsuCurso extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCurso;
	private JComboBox cboCurso;
	private JButton btnConsultar;
	private JScrollPane scpPane;
	private JTextArea txtS;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsuCurso dialog = new DlgConsuCurso();
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
	public DlgConsuCurso() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		lblCurso = new JLabel("Código del curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurso.setBounds(10, 22, 133, 14);
		getContentPane().add(lblCurso);
		
		cboCurso = new JComboBox();
		cboCurso.setBounds(113, 19, 176, 22);
		getContentPane().add(cboCurso);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlgConsuCurso.class.getResource("/img/consultar 3.png")));
		btnConsultar.setBounds(426, 15, 126, 30);
		getContentPane().add(btnConsultar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 101, 542, 326);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DlgConsuCurso.class.getResource("/img/cerrar.png")));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCerrar.setBounds(426, 56, 126, 30);
		getContentPane().add(btnCerrar);
		setTitle("Consulta | Curso");
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
