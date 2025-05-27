package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;

public class DlgCurso extends JDialog {

	private static final long serialVersionUID = 1L;

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
		getContentPane().setBackground(new Color(51, 153, 204));
		setBounds(100, 100, 800, 600);

	}

}
