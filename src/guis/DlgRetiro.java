package guis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;
import arreglos.ArregloRetiro;
import clases.Alumno;
import clases.Matricula;
import clases.Retiro;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class DlgRetiro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNumRetiro;
	private JTextField txtNumReti;
	private JLabel lblAlumno;
	private JTextField txtNombreALum;
	private JLabel lblEspecialidad;
	private JComboBox cboAlumno;
	private JTextField txtEspe;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JLabel lblCiclo;
	private JTextField txtCiclo;
	private JButton btnNuevo;
	private JButton btnAdicionar;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tablaRetiro;
	private DefaultTableModel modelo;
	private JLabel lblHora;
	private JTextField txtHora;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblMotivo;
	private JTextField txtMotivo;
	
	private ArregloAlumnos alum = new ArregloAlumnos();
	private ArregloCursos cursos = new ArregloCursos();
	private ArregloRetiro reti = new ArregloRetiro();
	private ArregloMatricula matriculas = new ArregloMatricula();

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
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);
		
		lblNumRetiro = new JLabel("Número de Retiro");
		lblNumRetiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumRetiro.setBounds(10, 22, 103, 14);
		getContentPane().add(lblNumRetiro);
		
		txtNumReti = new JTextField();
		txtNumReti.setEditable(false);
		txtNumReti.setBounds(133, 20, 211, 20);
		getContentPane().add(txtNumReti);
		txtNumReti.setColumns(10);
		
		lblAlumno = new JLabel("Número de matrícula");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlumno.setBounds(10, 65, 120, 14);
		getContentPane().add(lblAlumno);
		
		txtNombreALum = new JTextField();
		txtNombreALum.setEditable(false);
		txtNombreALum.setBounds(354, 63, 227, 20);
		getContentPane().add(txtNombreALum);
		txtNombreALum.setColumns(10);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspecialidad.setBounds(10, 106, 103, 14);
		getContentPane().add(lblEspecialidad);
		
		cboAlumno = new JComboBox();
		cboAlumno.setBounds(133, 62, 211, 22);
		getContentPane().add(cboAlumno);
		
		txtEspe = new JTextField();
		txtEspe.setEditable(false);
		txtEspe.setBounds(133, 104, 211, 20);
		getContentPane().add(txtEspe);
		txtEspe.setColumns(10);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurso.setBounds(10, 144, 103, 14);
		getContentPane().add(lblCurso);
		
		txtCurso = new JTextField();
		txtCurso.setEditable(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(133, 142, 211, 20);
		getContentPane().add(txtCurso);
		
		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiclo.setBounds(10, 179, 103, 14);
		getContentPane().add(lblCiclo);
		
		txtCiclo = new JTextField();
		txtCiclo.setEditable(false);
		txtCiclo.setColumns(10);
		txtCiclo.setBounds(133, 177, 211, 20);
		getContentPane().add(txtCiclo);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(DlgRetiro.class.getResource("/img/limpiar.png")));
		btnNuevo.setBounds(647, 40, 127, 31);
		getContentPane().add(btnNuevo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setIcon(new ImageIcon(DlgRetiro.class.getResource("/img/adicionar.png")));
		btnAdicionar.setBounds(647, 82, 127, 31);
		getContentPane().add(btnAdicionar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(DlgRetiro.class.getResource("/img/grabar.png")));
		btnGrabar.setBounds(647, 124, 127, 31);
		getContentPane().add(btnGrabar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(DlgRetiro.class.getResource("/img/cerrar.png")));
		btnCerrar.setBounds(647, 166, 127, 31);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 254, 764, 296);
		getContentPane().add(scrollPane);
		
		tablaRetiro = new JTable();
		tablaRetiro.setFillsViewportHeight(true);
		scrollPane.setViewportView(tablaRetiro); // ✅ cambia esto
		
		modelo = new DefaultTableModel();
		modelo.addColumn("N° DE RETIRO");
		modelo.addColumn("NOMBRE COMPLETO");
		modelo.addColumn("ESPECIALIDAD");
		modelo.addColumn("CURSO");
		modelo.addColumn("CICLO");
		modelo.addColumn("MOTIVO");
		tablaRetiro.setModel(modelo);
		
		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHora.setBounds(491, 145, 46, 14);
		getContentPane().add(lblHora);
		
		txtHora = new JTextField();
		txtHora.setBounds(528, 142, 86, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(491, 177, 46, 14);
		getContentPane().add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(528, 177, 86, 20);
		getContentPane().add(txtFecha);
		
		lblMotivo = new JLabel("Motivo");
		lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMotivo.setBounds(10, 222, 103, 14);
		getContentPane().add(lblMotivo);
		
		txtMotivo = new JTextField();
		txtMotivo.setEditable(false);
		txtMotivo.setColumns(10);
		txtMotivo.setBounds(133, 220, 211, 20);
		getContentPane().add(txtMotivo);
		setTitle("Registro | Retiro");
		setBounds(100, 100, 800, 600);
		
		reti.listarRetiro(); // ✅ Cargar para mantener correlativo
	    int ultimoCodigo = reti.obtenerUltimoCodigo(); 
	    
	    txtNumReti.setText(String.valueOf(ultimoCodigo + 1));
		
	    matriculas.vaciar(); // Limpia por si acaso
	    matriculas.listarMatriculas(); // <<-- Asegúrate de CARGAR el archivo .txt
	    alum.listarAlumnos(); // 👈 carga los alumnos
	    llenarComboMatriculasActivas();
		iniciarReloj();
		
		
		
	}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevo();
	}
	
	
	
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		adicionar();
	}
	
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
	    try {
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            int numRetiro = Integer.parseInt(modelo.getValueAt(i, 0).toString());
	            String nombre = modelo.getValueAt(i, 1).toString();
	            String especialidad = modelo.getValueAt(i, 2).toString();
	            String curso = modelo.getValueAt(i, 3).toString();
	            String ciclo = modelo.getValueAt(i, 4).toString();
	            String motivo = modelo.getValueAt(i, 5).toString();

	            int numMatri = -1;

	            // Buscar matrícula por nombre
	            for (int j = 0; j < matriculas.tamano(); j++) {
	                Matricula m = matriculas.obtener(j);
	                Alumno a = alum.buscar(m.getCodAlumno());
	                String nombreCompleto = a.getApellidos() + ", " + a.getNombres();
	                if (nombreCompleto.equals(nombre)) {
	                    m.setEstado(0); // Dar de baja matrícula
	                    numMatri = m.getNumMatricula();
	                    break;
	                }
	            }

	            if (numMatri != -1) {
	                String fecha = txtFecha.getText();
	                String hora = txtHora.getText();

	                Retiro nuevoRetiro = new Retiro(numRetiro, numMatri, curso, especialidad, ciclo, fecha, hora, motivo);
	                reti.adicionar(nuevoRetiro);
	            }
	        }

	        // Cambiar estado del alumno a "Retirado"
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            String nombre = modelo.getValueAt(i, 1).toString();

	            for (int j = 0; j < alum.tamano(); j++) {
	                Alumno a = alum.obtener(j);
	                String nombreCompleto = a.getApellidos() + ", " + a.getNombres();
	                if (nombreCompleto.equals(nombre)) {
	                    a.setEstado(2); // 0 = Retirado
	                    break;
	                }
	            }
	        }

	        reti.grabarRetiro();       // Guarda los retiros
	        matriculas.grabarMatricula(); // Guarda los cambios de estado en matrículas
	        alum.grabarAlumnos();      // Guarda los cambios de estado de alumnos

	        mostrarMensaje("Los retiros fueron grabados correctamente.");
	        nuevo(); // Limpia

	    } catch (Exception ex) {
	        mostrarMensaje("Error al grabar: " + ex.getMessage());
	    }
	}
	
	private void limpiarCampos() {
	    txtNombreALum.setText("");
	    txtEspe.setText("");
	    txtCurso.setText("");
	    txtCiclo.setText("");
	    txtMotivo.setText("");
	    txtMotivo.setEditable(false);
	}
	
	void nuevo() {
	    int nuevoCodigo = reti.obtenerUltimoCodigo() + 1;
	    txtNumReti.setText(String.valueOf(nuevoCodigo));
	    cboAlumno.setSelectedIndex(0);
	    limpiarCampos();
	}
	
	void adicionar() {
		if (cboAlumno.getSelectedIndex() <= 0) {
	        mostrarMensaje("Seleccione una matrícula válida.");
	        return;
	    }

	    String motivo = txtMotivo.getText().trim();
	    if (motivo.isEmpty()) {
	        mostrarMensaje("Ingrese el motivo del retiro.");
	        return;
	    }
	    
	    if (!motivo.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
	        mostrarMensaje("El motivo debe contener solo letras.");
	        return;
	    }

	    String codRetiro = txtNumReti.getText();
	    String nombre = txtNombreALum.getText();
	    String especialidad = txtEspe.getText();
	    String curso = txtCurso.getText();
	    String cicloNum = txtCiclo.getText();
	  
	    
	 // Validar que no esté repetida la matrícula en la tabla
	    for (int i = 0; i < modelo.getRowCount(); i++) {
	        String nombreTabla = modelo.getValueAt(i, 1).toString();
	        if (nombreTabla.equals(txtNombreALum.getText())) {
	            mostrarMensaje("Este alumno ya tiene un retiro registrado.");
	            return;
	        }
	    }

	    modelo.addRow(new Object[] { codRetiro, nombre, especialidad, curso, cicloNum, motivo });

	    mostrarMensaje("Retiro adicionado a la tabla.");
		
	}
	
	private String obtenerNombreCiclo(String cicloNum) {
	    switch (cicloNum) {
	        case "1": return "Primero";
	        case "2": return "Segundo";
	        case "3": return "Tercero";
	        case "4": return "Cuarto";
	        case "5": return "Quinto";
	        case "6": return "Sexto";
	        default: return "Ciclo Desconocido";
	    }
	}

	
	
	private void llenarComboMatriculasActivas() {
	    cboAlumno.removeAllItems();
	    cboAlumno.addItem("---Seleccione---");
	    for (int i = 0; i < matriculas.tamano(); i++) {
	        Matricula m = matriculas.obtener(i);
	        if (m.getEstado() == 1) {
	            Alumno a = alum.buscar(m.getCodAlumno());
	            String nombre = a.getApellidos() + ", " + a.getNombres();
	            cboAlumno.addItem(m.getNumMatricula() + " - " + nombre);
	        }
	    }

	    cboAlumno.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            actualizarCamposDesdeMatricula();
	        }
	    });
	}
	
	
	private void actualizarCamposDesdeMatricula() {
	    if (cboAlumno.getSelectedIndex() <= 0) {
	        limpiarCampos();
	        return;
	    }
	    
	    String seleccionado = cboAlumno.getSelectedItem().toString();
	    int codMatricula = Integer.parseInt(seleccionado.split(" - ")[0].trim());

	    Matricula m = matriculas.buscar(codMatricula); // necesitas implementar este método si no lo tienes

	    if (m != null) {
	        Alumno a = alum.buscar(m.getCodAlumno());
	        txtNombreALum.setText(a.getApellidos() + ", " + a.getNombres());
	        txtEspe.setText(m.getEspecialidad());
	        txtCurso.setText(cursos.buscar(m.getCodCurso()).getAsignatura());
	        txtCiclo.setText(obtenerNombreCiclo(m.getCiclo()));
	        txtMotivo.setEditable(true);
	    }
	    
	}
	    

	private void mostrarMensaje(String mensaje) {
		
	 JOptionPane.showMessageDialog(this, mensaje);	
		
	}

	private void iniciarReloj() {
	    Timer timer = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txtFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            txtHora.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));	        }
	    });
	    timer.start();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	}
