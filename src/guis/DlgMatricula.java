package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//
import javax.swing.table.DefaultTableModel;
import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;
import clases.Alumno;
import clases.Curso;
import clases.Matricula;

//
import javax.swing.JOptionPane;

//
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//
import java.io.FileWriter;
import java.io.PrintWriter;

//
import javax.swing.Timer;

public class DlgMatricula extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNumeroMatricula;
	private JLabel lblAlumno;
	private JLabel lblEspecialidad;
	private JTextField txtNumeroMatricula;
	private JComboBox cboAlumno;
	private JComboBox cboEspecialidad;
	private JButton btnAdicionar;
	private JButton btnNuevo;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTable tblMatricula;
	private JLabel lblCurso;
	private JLabel lblTurno;
	private JComboBox cboCurso;
	private JComboBox cboTurno;
	
	//
	private DefaultTableModel modelo;
	private ArregloAlumnos alumnos = new ArregloAlumnos();
	private ArregloCursos cursos = new ArregloCursos();
	private ArregloMatricula matriculas = new ArregloMatricula();
	private ArregloMatricula matriculasNuevas = new ArregloMatricula();
	
	//
	private JLabel lblHora;
	private JLabel lblFecha;
	private JTextField txtHora;
	private JTextField txtFecha;
	private boolean seRegistroMatricula = false;
	private JTextField txtAlumno;
	private JComboBox cboCiclo;

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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Registro | Matrícula");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		lblNumeroMatricula = new JLabel("Número de Matrícula");
		lblNumeroMatricula.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroMatricula.setBounds(10, 11, 158, 32);
		getContentPane().add(lblNumeroMatricula);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAlumno.setBounds(10, 55, 113, 32);
		getContentPane().add(lblAlumno);
		
		lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspecialidad.setBounds(10, 99, 113, 32);
		getContentPane().add(lblEspecialidad);
		
		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setEditable(false);
		txtNumeroMatricula.setBounds(178, 18, 212, 20);
		getContentPane().add(txtNumeroMatricula);
		txtNumeroMatricula.setColumns(10);
		
		cboAlumno = new JComboBox();
		cboAlumno.setBounds(178, 62, 212, 20);
		getContentPane().add(cboAlumno);
		
		cboEspecialidad = new JComboBox();
		cboEspecialidad.setBounds(178, 106, 212, 20);
		getContentPane().add(cboEspecialidad);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(getClass().getResource("/img/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(644, 99, 130, 32);
		getContentPane().add(btnAdicionar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(getClass().getResource("/img/limpiar.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(644, 50, 130, 32);
		getContentPane().add(btnNuevo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setIcon(new ImageIcon(getClass().getResource("/img/grabar.png")));
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(644, 149, 130, 34);
		getContentPane().add(btnGrabar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(getClass().getResource("/img/cerrar.png")));
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(644, 194, 130, 32);
		getContentPane().add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 274, 764, 277);
		getContentPane().add(scrollPane);
		
		tblMatricula = new JTable();
		scrollPane.setViewportView(tblMatricula);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurso.setBounds(10, 187, 113, 32);
		getContentPane().add(lblCurso);
		
		lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTurno.setBounds(10, 231, 113, 32);
		getContentPane().add(lblTurno);
		
		cboCurso = new JComboBox();
		cboCurso.setBounds(178, 194, 212, 20);
		getContentPane().add(cboCurso);
		
		cboTurno = new JComboBox();
		cboTurno.setBounds(178, 238, 212, 20);
		getContentPane().add(cboTurno);
		
		lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHora.setBounds(449, 143, 113, 32);
		getContentPane().add(lblHora);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFecha.setBounds(449, 187, 113, 32);
		getContentPane().add(lblFecha);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(505, 149, 86, 20);
		getContentPane().add(txtHora);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(505, 194, 86, 20);
		getContentPane().add(txtFecha);
		
		txtAlumno = new JTextField();
		txtAlumno.setEditable(false);
		txtAlumno.setColumns(10);
		txtAlumno.setBounds(400, 62, 212, 20);
		getContentPane().add(txtAlumno);
		
		JLabel lblCiclo = new JLabel("Ciclo");
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiclo.setBounds(10, 142, 113, 32);
		getContentPane().add(lblCiclo);
		
		cboCiclo = new JComboBox();
		cboCiclo.setBounds(178, 149, 212, 20);
		getContentPane().add(cboCiclo);
		
		
		 // 🔽 Esta parte es clave:
	    matriculas.listarMatriculas(); // ✅ Cargar para mantener correlativo
	    int ultimoCodigo = matriculas.obtenerUltimoCodigo(); 
	    
	    txtNumeroMatricula.setText(String.valueOf(ultimoCodigo + 1));
		//
		llenarComboAlumno();
		llenarComboCurso();
		llenarComboEspecialidad();
		llenarComboCiclo();
		llenarComboTurno();
		configurarTabla();
		iniciarReloj();
		
		//
		    
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
	    cboAlumno.setEnabled(true);
	    cboCiclo.setEnabled(true);
	    cboCurso.setEnabled(true);
	    cboEspecialidad.setEnabled(true);
	    cboTurno.setEnabled(true);
	    cboAlumno.setSelectedIndex(0);
	    cboCiclo.setSelectedIndex(0);
	    cboCurso.setSelectedIndex(0);
	    cboEspecialidad.setSelectedIndex(0);
	    cboTurno.setSelectedIndex(0);
	    

	    if (seRegistroMatricula) {
	        generarCodigoMatricula();
	        seRegistroMatricula = false;
	    }
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		
		// Validar selección de combos
		if (cboAlumno.getSelectedIndex() <= 0) {
		    mostrarMensaje("Seleccione un alumno.");
		    return;
		}
		if (cboCurso.getSelectedIndex() <= 0) {
		    mostrarMensaje("Seleccione un curso.");
		    return;
		}
		if (cboEspecialidad.getSelectedIndex() <= 0) {
		    mostrarMensaje("Seleccione una especialidad.");
		    return;
		}
		if (cboTurno.getSelectedIndex() <= 0) {
		    mostrarMensaje("Seleccione un turno.");
		    return;
		}
		if (cboCiclo.getSelectedIndex() <= 0) {
		    mostrarMensaje("Seleccione un ciclo.");
		    return;
		}
		
	    try {
	        // Obtener código de alumno desde el texto seleccionado del combo
	        String alumnoTexto = cboAlumno.getSelectedItem().toString();
	        int codAlumno = Integer.parseInt(alumnoTexto.split(" - ")[0].trim());

	        // Obtener código de curso desde el texto seleccionado del combo
	        String cursoTexto = cboCurso.getSelectedItem().toString();
	        int codCurso = Integer.parseInt(cursoTexto.split(" - ")[0].trim());

	        String especialidad = cboEspecialidad.getSelectedItem().toString();
	        String turno = cboTurno.getSelectedItem().toString();

	        if (matriculas.alumnoYaMatriculado(codAlumno)) {
	            mostrarMensaje("Este alumno ya tiene una matrícula activa.");
	            return;
	        }
	        
	        int numMatricula = Integer.parseInt(txtNumeroMatricula.getText());
	        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
	        int estado = 1; // matriculado

	        // Obtener el objeto Curso para extraer el ciclo
	        Curso c = cursos.buscar(codCurso);
	        if (c == null) {
	            mostrarMensaje("Error: Curso no encontrado.");
	            return;
	        }
	        String ciclo = String.valueOf(c.getCiclo()); // Convertir ciclo a texto

	        // Crear matrícula con el ciclo extraído
	        Matricula m = new Matricula(numMatricula, codAlumno, codCurso, fecha, hora, especialidad, ciclo, turno, estado);
	        matriculas.adicionar(m);
	        matriculasNuevas.adicionar(m);
	        
	     // ✅ Cambiar el estado del alumno a 'Matriculado' porque solo puede tener una matrícula activa
	        Alumno a = alumnos.buscar(codAlumno);
	        if (a != null) {
	            a.setEstado(1); // "1" representa 'Matriculado'
	            alumnos.grabarAlumnos();

	        mostrarMensaje("Matrícula registrada con éxito.");
	        mostrarDatosEnTabla();
	        seRegistroMatricula = true;
	        
	        //
	        cboAlumno.setEnabled(false);
	        cboCiclo.setEnabled(false);
	        cboCurso.setEnabled(false);
	        cboEspecialidad.setEnabled(false);
	        cboTurno.setEnabled(false);
	        }
	        
	    } catch (Exception ex) {
	        mostrarMensaje("Error al adicionar matrícula.");
	    }
	}	
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
	    try {
	        // Paso 1: Leer del archivo lo que ya existía
	        ArregloMatricula anteriores = new ArregloMatricula();
	        anteriores.listarMatriculas();

	        // Paso 2: Unir lo anterior con las nuevas de esta sesión (matriculas)
	        for (int i = 0; i < matriculas.tamano(); i++) {
	            Matricula nueva = matriculas.obtener(i);
	            if (!anteriores.existeMatricula(nueva.getCodAlumno(), nueva.getCodCurso())) {
	                anteriores.adicionar(nueva);
	            }
	        }

	        // Paso 3: Grabar todos juntos (anteriores + nuevos)
	        anteriores.grabarMatricula();
	        JOptionPane.showMessageDialog(this, "Matrículas grabadas correctamente.");
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(this, "Error al grabar: " + ex.getMessage());
	    }
	}
	
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	//
	private void llenarComboAlumno() {
	    cboAlumno.removeAllItems();
	    cboAlumno.addItem("---Seleccione un código---");
	    for (int i = 0; i < alumnos.tamano(); i++) {
	        Alumno a = alumnos.obtener(i);
	        cboAlumno.addItem(a.getCodAlumno() + " - " + a.getApellidos() + ", " + a.getNombres());
	    }
	    
	    //	    
	    cboAlumno.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            actualizarTextoAlumno();
	        }
	    });
	}
	
	//
	private void llenarComboCiclo() {
	    cboCiclo.removeAllItems();
	    cboCiclo.addItem("---Seleccione un ciclo---");
	    cboCiclo.addItem("Primero");
	    cboCiclo.addItem("Segundo");
	    cboCiclo.addItem("Tercero");
	    cboCiclo.addItem("Cuarto");
	    cboCiclo.addItem("Quinto");
	    cboCiclo.addItem("Sexto");

	    // Evento para actualizar combo de cursos según el ciclo elegido
	    cboCiclo.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            actualizarComboCursoSegunCiclo();
	        }
	    });
	}
	
	//
	private void actualizarComboCursoSegunCiclo() {
	    cboCurso.removeAllItems();
	    cboCurso.addItem("---Seleccione un curso---");

	    if (cboCiclo.getSelectedIndex() <= 0) return;

	    // Convertir texto del ciclo a número
	    String cicloTexto = cboCiclo.getSelectedItem().toString();
	    int cicloSeleccionado = convertirCicloATextoANumero(cicloTexto);

	    for (int i = 0; i < cursos.tamano(); i++) {
	        Curso c = cursos.obtener(i);
	        if (c.getCiclo() == cicloSeleccionado) {
	            cboCurso.addItem(c.getCodCurso() + " - " + c.getAsignatura());
	        }
	    }
	}
	
	//
	private int convertirCicloATextoANumero(String ciclo) {
	    switch (ciclo) {
	        case "Primero": return 1;
	        case "Segundo": return 2;
	        case "Tercero": return 3;
	        case "Cuarto": return 4;
	        case "Quinto": return 5;
	        case "Sexto": return 6;
	        default: return -1;
	    }
	}

	private void llenarComboCurso() {
	    cboCurso.removeAllItems();
	    cboCurso.addItem("---Seleccione un curso---");
	    for (int i = 0; i < cursos.tamano(); i++) {
	        Curso c = cursos.obtener(i);
	        cboCurso.addItem(c.getCodCurso() + " - " + c.getAsignatura());
	    }
	}

	private void llenarComboEspecialidad() {
	    cboEspecialidad.removeAllItems();
	    cboEspecialidad.addItem("---Seleccione una especialidad---");
	    cboEspecialidad.addItem("Computación e Informática");
	    cboEspecialidad.addItem("Diseño Gráfico");
	    cboEspecialidad.addItem("Contabilidad");
	    
	}

	private void llenarComboTurno() {
	    cboTurno.removeAllItems();
	    cboTurno.addItem("---Seleccione un turno---");
	    cboTurno.addItem("Mañana");
	    cboTurno.addItem("Tarde");
	    cboTurno.addItem("Noche");
	}
	//
	private void generarCodigoMatricula() {
	    int codigo = matriculas.generarCodigo();
	    txtNumeroMatricula.setText(String.valueOf(codigo));
	}
	
	//
	private void configurarTabla() {
	    modelo = new DefaultTableModel();
	    modelo.addColumn("N° Matrícula");
	    modelo.addColumn("Nombre completo");
	    modelo.addColumn("Curso");
	    modelo.addColumn("N° Créditos");
	    modelo.addColumn("Tipo");
	    modelo.addColumn("Modalidad");
	    modelo.addColumn("Horas");
	    modelo.addColumn("Especialidad");
	    modelo.addColumn("Ciclo");
	    modelo.addColumn("Turno");
	    modelo.addColumn("Estado");

	    tblMatricula.setModel(modelo);
	}

	private void mostrarDatosEnTabla() {
	    modelo.setRowCount(0);
	    for (int i = 0; i < matriculasNuevas.tamano(); i++) {
	        Matricula m = matriculasNuevas.obtener(i);
	        Alumno a = alumnos.buscar(m.getCodAlumno());
	        Curso c = cursos.buscar(m.getCodCurso());
	        String nombreAlumno = a.getApellidos() + ", " + a.getNombres();
	        String nombreCurso = c.getAsignatura();

	        modelo.addRow(new Object[] {
	            m.getNumMatricula(),
	            nombreAlumno,
	            nombreCurso,
	            c.getCredi(),
	            c.getTipoCurso(),
	            c.getModalidad(),
	            c.getHoras(),
	            m.getEspecialidad(),
	            obtenerTextoCiclo(m.getCiclo()),
	            m.getTurno(),
	            m.getEstadoTexto()
	        });
	    }
	}
	//
	private void iniciarReloj() {
	    Timer timer = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	txtFecha.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	            txtHora.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss a")));	        }
	    });
	    timer.start();
	}
	
	//
	private void actualizarTextoAlumno() {
		if (cboAlumno.getSelectedIndex() > 0) {
	        try {
	            String seleccionado = cboAlumno.getSelectedItem().toString();
	            int codAlumno = Integer.parseInt(seleccionado.split(" - ")[0].trim());
	            Alumno a = alumnos.buscar(codAlumno);
	            if (a != null) {
	                txtAlumno.setText(a.getApellidos() + ", " + a.getNombres());
	            } else {
	                txtAlumno.setText("Alumno no encontrado");
	            }
	        } catch (Exception ex) {
	            txtAlumno.setText("Error");
	        }
	    } else {
	        txtAlumno.setText("");
	    }
	}
	
	//
	private String obtenerTextoCiclo(String ciclo) {
	    switch (ciclo) {
	        case "1": return "Primero";
	        case "2": return "Segundo";
	        case "3": return "Tercero";
	        case "4": return "Cuarto";
	        case "5": return "Quinto";
	        case "6": return "Sexto";
	        default: return "Desconocido";
	    }
	}
	
	//
	private void mostrarMensaje(String mensaje) {
	    JOptionPane.showMessageDialog(this, mensaje);
	}
}