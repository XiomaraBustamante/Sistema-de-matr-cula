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

public class DlConsuMatricula extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNumMatri;
	private JComboBox cboNumMatri;
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
					DlConsuMatricula dialog = new DlConsuMatricula();
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
	public DlConsuMatricula() {
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		lblNumMatri = new JLabel("Número de Matrícula");
		lblNumMatri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumMatri.setBounds(10, 23, 141, 14);
		getContentPane().add(lblNumMatri);
		
		cboNumMatri = new JComboBox();
		cboNumMatri.setBounds(139, 20, 168, 22);
		getContentPane().add(cboNumMatri);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(DlConsuMatricula.class.getResource("/img/consultar 1.png")));
		btnConsultar.setBounds(426, 16, 126, 30);
		getContentPane().add(btnConsultar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 101, 542, 326);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DlConsuMatricula.class.getResource("/img/cerrar.png")));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCerrar.setBounds(426, 60, 126, 30);
		getContentPane().add(btnCerrar);
		setTitle("Consulta | Matrícula");
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
