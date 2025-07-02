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

public class DlgConsuRetiro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblRetiro;
	private JComboBox cboReti;
	private JButton btnNConsultar;
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
					DlgConsuRetiro dialog = new DlgConsuRetiro();
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
	public DlgConsuRetiro() {
		setTitle("Consulta | Retiro");
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		lblRetiro = new JLabel("Número de Retiro");
		lblRetiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRetiro.setBounds(10, 22, 122, 14);
		getContentPane().add(lblRetiro);
		
		cboReti = new JComboBox();
		cboReti.setBounds(119, 19, 164, 22);
		getContentPane().add(cboReti);
		
		btnNConsultar = new JButton("Consultar");
		btnNConsultar.setIcon(new ImageIcon(DlgConsuRetiro.class.getResource("/img/consultar 3.png")));
		btnNConsultar.setBounds(426, 15, 126, 30);
		getContentPane().add(btnNConsultar);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 95, 542, 332);
		getContentPane().add(scpPane);
		
		txtS = new JTextArea();
		scpPane.setViewportView(txtS);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DlgConsuRetiro.class.getResource("/img/cerrar.png")));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCerrar.setBounds(426, 54, 126, 30);
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
