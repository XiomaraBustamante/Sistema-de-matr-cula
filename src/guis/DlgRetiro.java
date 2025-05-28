package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DlgRetiro extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNmeroDeRetiro;
	private JTextField txtNumRetiro;
	private JLabel lblNumDeMatrcula;
	private JTextField txtNumMatri;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRetiro dialog = new DlgRetiro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRetiro() {
		setTitle("Registro | Retiro");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 153, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNmeroDeRetiro = new JLabel("Número de retiro");
		lblNmeroDeRetiro.setForeground(Color.WHITE);
		lblNmeroDeRetiro.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblNmeroDeRetiro.setBounds(10, 11, 159, 32);
		contentPanel.add(lblNmeroDeRetiro);
		
		txtNumRetiro = new JTextField();
		txtNumRetiro.setColumns(10);
		txtNumRetiro.setBounds(163, 19, 159, 20);
		contentPanel.add(txtNumRetiro);
		
		lblNumDeMatrcula = new JLabel("N° de Matrícula");
		lblNumDeMatrcula.setForeground(Color.WHITE);
		lblNumDeMatrcula.setFont(new Font("Roboto Condensed", Font.BOLD, 17));
		lblNumDeMatrcula.setBounds(10, 54, 144, 32);
		contentPanel.add(lblNumDeMatrcula);
		
		txtNumMatri = new JTextField();
		txtNumMatri.setColumns(10);
		txtNumMatri.setBounds(163, 62, 159, 20);
		contentPanel.add(txtNumMatri);
	}
}
