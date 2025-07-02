package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloAlumnos;
import arreglos.ArregloCursos;
import arreglos.ArregloMatricula;
import clases.Alumno;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import clases.Curso;
import utilidades.Utilidades;

public class DlgCurso extends JDialog implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblAsignatura;
	private JLabel lblCodigo;
	private JLabel lblCiclo;
	private JLabel lblNumCre;
	private JLabel lblHoras;
	private JTextField txtCodigo;
	private JButton btnBuscar;
	private JTextField txtAsigna;
	private JTextField txtCreditos;
	private JTextField txtHoras;
	private JButton btnOk;
	private JComboBox cboCiclo;
	private JButton btnOpciones;
	private JButton btnCerrar;
	private JLabel lblTipoDeCurso;
	private JComboBox cboTipo;
	private JLabel lblModalidad;
	private JComboBox cboModa;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scpPane;
	private JTable TablaCursos;
	private DefaultTableModel modelo;
//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;

//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR = 3;

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
		setTitle("Mantenimiento | Curso");
		getContentPane().setBackground(new Color(192, 192, 192));
		getContentPane().setLayout(null);

		
		
		lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setForeground(Color.BLACK);
		lblAsignatura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAsignatura.setBounds(10, 54, 95, 27);
		getContentPane().add(lblAsignatura);

		lblCodigo = new JLabel("Código del Curso");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 11, 113, 32);
		getContentPane().add(lblCodigo);

		lblCiclo = new JLabel("Ciclo");
		lblCiclo.setForeground(Color.BLACK);
		lblCiclo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiclo.setBounds(10, 99, 68, 20);
		getContentPane().add(lblCiclo);

		lblNumCre = new JLabel("N° Creditos");
		lblNumCre.setForeground(Color.BLACK);
		lblNumCre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumCre.setBounds(10, 142, 95, 21);
		getContentPane().add(lblNumCre);

		lblHoras = new JLabel("Horas");
		lblHoras.setForeground(Color.BLACK);
		lblHoras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoras.setBounds(10, 260, 68, 21);
		getContentPane().add(lblHoras);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(135, 18, 113, 20);
		getContentPane().add(txtCodigo);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(240, 240, 240));
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBuscar.setBounds(258, 16, 89, 23);
		getContentPane().add(btnBuscar);

		txtAsigna = new JTextField();
		txtAsigna.setColumns(10);
		txtAsigna.setEditable(false);
		txtAsigna.setBounds(135, 55, 212, 20);
		getContentPane().add(txtAsigna);

		txtCreditos = new JTextField();
		txtCreditos.setColumns(10);
		txtCreditos.setEditable(false);
		txtCreditos.setBounds(135, 143, 212, 20);
		getContentPane().add(txtCreditos);

		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setEditable(false);
		txtHoras.setBounds(135, 259, 113, 20);
		getContentPane().add(txtHoras);

		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOk.setBounds(258, 258, 89, 23);
		getContentPane().add(btnOk);
		
		
		cboCiclo = new JComboBox<String>();
		cboCiclo.setModel(new DefaultComboBoxModel<String>(Utilidades.getCicloCurso()));
		cboCiclo.setForeground(Color.BLACK);
		cboCiclo.setEnabled(false);
	    cboCiclo.setBounds(135, 99, 212, 20);
		getContentPane().add(cboCiclo);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(getClass().getResource("/img/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setForeground(Color.BLACK);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAdicionar.setBounds(643, 52, 111, 31);
		getContentPane().add(btnAdicionar);

		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(getClass().getResource("/img/consultar.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setForeground(Color.BLACK);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConsultar.setBounds(643, 93, 111, 29);
		getContentPane().add(btnConsultar);

		btnModificar = new JButton("Modificar");
		btnModificar .setIcon(new ImageIcon(getClass().getResource("/img/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModificar.setBounds(641, 136, 113, 27);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar .setIcon(new ImageIcon(getClass().getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEliminar.setBounds(643, 179, 113, 27);
		getContentPane().add(btnEliminar);

		scpPane = new JScrollPane();
		scpPane.setBounds(10, 292, 764, 258);
		getContentPane().add(scpPane);

		TablaCursos = new JTable();
		scpPane.setViewportView(TablaCursos);
		setBounds(100, 100, 800, 600);

		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO CURSO");
		modelo.addColumn("ASIGNATURA");
		modelo.addColumn("CICLO");
		modelo.addColumn("CREDITOS");
		modelo.addColumn("TIPO DE CURSO");
		modelo.addColumn("MODALIDAD");
		modelo.addColumn("HORAS");
		TablaCursos.setModel(modelo);
		
		btnOpciones = new JButton("opciones");
		btnOpciones.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setForeground(Color.BLACK);
		btnOpciones.setBounds(491, 95, 123, 116);
		getContentPane().add(btnOpciones);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar .setIcon(new ImageIcon(getClass().getResource("/img/cerrar.png")));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCerrar.setEnabled(true);
		btnCerrar.setBounds(643, 217, 113, 27);
		getContentPane().add(btnCerrar);
		
		lblTipoDeCurso = new JLabel("Tipo de curso");
		lblTipoDeCurso.setForeground(Color.BLACK);
		lblTipoDeCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipoDeCurso.setBounds(10, 184, 95, 16);
		getContentPane().add(lblTipoDeCurso);
		
		cboTipo = new JComboBox<String>();
		cboTipo.setModel(new DefaultComboBoxModel<String>(Utilidades.getTipocurso()));
		cboTipo.setEnabled(false);
		cboTipo.setBounds(135, 180, 212, 22);
		getContentPane().add(cboTipo);
		
		lblModalidad = new JLabel("Modalidad");
		lblModalidad.setForeground(Color.BLACK);
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModalidad.setBounds(10, 221, 95, 16);
		getContentPane().add(lblModalidad);
		
		cboModa = new JComboBox<String>();
		cboModa.setModel(new DefaultComboBoxModel<String>(Utilidades.getModalidad()));
		cboModa.setEnabled(false);
		cboModa.setBounds(135, 220, 212, 21);
		getContentPane().add(cboModa);
		
		tipoOperacion = -1;
		habilitarEntradas(false);
		habilitarBusqueda(false);
		habilitarBotones(true); 
		listar();
		

	}
	
	ArregloMatricula matriculas = new ArregloMatricula();
	ArregloCursos cursos = new ArregloCursos();
	
	// -----------------ACTION PERFORMED DE MIS BOTONES-----------------------
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}

		if (e.getSource() == btnAdicionar) {
			actionPerformedbtnAdicionar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}	
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
			
		}
		
	}

	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
		txt.setText("");
		txt.requestFocus();
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	private void adicionarCurso() {
		try {
			// ---------------------VALIDAR CÓDIGO-------------------------
			String scodigo = txtCodigo.getText().trim();
			if (!esNumero(scodigo)) {
				error("El código debe ser un número válido", txtCodigo);
				return;
					
			}
			
			
			if (scodigo.length() != 4) {
				error("El código debe tener exactamente 4 dígitos", txtCodigo);
				return;
			}

			int codigo = Integer.parseInt(scodigo);
			if (cursos.buscar(codigo) != null) {
				error("El código ya existe. Ingrese otro", txtCodigo);
				return;
			}

			// ---------------------VALIDAR ASIGNATURA---------------------
			String asignatura = txtAsigna.getText().trim();
			if (asignatura.isEmpty()) {
				error("Ingrese asignatura", txtAsigna);
				return;
			}
			
			if (!asignatura.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
			    error("La asignatura solo debe contener letras", txtAsigna);
			    return;
			}
			
			if (cursos.buscarPorAsignatura(asignatura) != null) {
			    error("Ya existe un curso con esa asignatura", txtAsigna);
			    return;
			}

			// ---------------------VALIDAR CRÉDITOS-----------------------
			String screditos = txtCreditos.getText().trim();
			if (!esNumero(screditos)) {
				error("Los créditos deben ser numéricos", txtCreditos);
				return;
			}
			int creditos = Integer.parseInt(screditos);
			if (creditos <= 0) {
				error("Los créditos deben ser mayores a 0", txtCreditos);
				return;
			}

			// ---------------------VALIDAR CICLO--------------------------
			int ciclo = cboCiclo.getSelectedIndex();
			if (ciclo == 0) {
				mensaje("Debe seleccionar un ciclo válido");
				cboCiclo.requestFocus();
				return;
			}

			// ---------------------VALIDAR TIPO DE CURSO------------------
			int tipoIndex = cboTipo.getSelectedIndex();
			if (tipoIndex == 0) {
				mensaje("Debe seleccionar un tipo de curso válido");
				cboTipo.requestFocus();
				return;
			}
			String tipoCurso = cboTipo.getSelectedItem().toString();

			// ---------------------VALIDAR MODALIDAD----------------------
			int modalidadIndex = cboModa.getSelectedIndex();
			if (modalidadIndex == 0) {
				mensaje("Debe seleccionar una modalidad válida");
				cboModa.requestFocus();
				return;
			}
			String modalidad = cboModa.getSelectedItem().toString();

			// ---------------------VALIDAR HORAS--------------------------
			String shoras = txtHoras.getText().trim();
			if (!esNumero(shoras)) {
				error("Las horas deben ser numéricas", txtHoras);
				return;
			}
			int horas = Integer.parseInt(shoras);
			if (horas <= 0) {
				error("Las horas deben ser mayores a 0", txtHoras);
				return;
			}

			// ------------------- CREAR Y AGREGAR ------------------------
			Curso nuevo = new Curso(codigo, asignatura, ciclo, creditos, tipoCurso, modalidad, horas);
			cursos.adicionar(nuevo);
			cursos.ordenarPorCodigo();
			cursos.grabarCurso();
			listar();
			mensaje("Curso registrado correctamente");

			// ------------------- RESTAURAR INTERFAZ ---------------------
			restaurarInterfazInicial();

		} catch (Exception e) {
			mensaje("Error inesperado al registrar el curso");
		}
	}
	
	private boolean esNumero(String texto) {
		return texto.matches("\\d+"); // uno o más dígitos
	}
	
	

	
	// --------------------LISTAR-----------------------------
	private void listar() {
	    int posFila = TablaCursos.getSelectedRow(); // seleccionar Fila antes de actualizar
	    modelo.setRowCount(0); // Limpiar la tabla

	    for (int i = 0; i < cursos.tamano(); i++) {
	        Curso a = cursos.obtener(i);
	        String nombreCiclo = obtenerNombreCicloDesdeUtilidad(a.getCiclo());
	        Object[] fila = {
	        		a.getCodCurso(),
	        		a.getAsignatura(),
	        		nombreCiclo,
	        		a.getCredi(),
	        		a.getTipoCurso(),
	        		a.getModalidad(),
	        		a.getHoras()
	        	};
	        modelo.addRow(fila);
	    }

	    if (cursos.tamano() > 0 && posFila >= 0 && posFila < modelo.getRowCount()) {
	        TablaCursos.getSelectionModel().setSelectionInterval(posFila, posFila);
	    }
	}
	
	
	

	private String obtenerNombreCicloDesdeUtilidad(int ciclo) {
		String[] ciclos = { "Elegir ciclo", "Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto" };
	    if (ciclo >= 1 && ciclo <= 6)
	        return ciclos[ciclo];
	    else
	        return "Desconocido";
	}
	
	

	// ------------------------BOTON BUSCAR-----------------------------
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		try {
			int codigo = Integer.parseInt(txtCodigo.getText().trim());
			Curso a = cursos.buscar(codigo);
			if (a == null) {
				error("El código " + codigo + " no existe", txtCodigo);
				return;
			}

			if (tipoOperacion == CONSULTAR) {
				mostrarDatos(a);
				habilitarEntradas(false);
				btnOk.setEnabled(false);
				habilitarBusqueda(false);
			} else if (tipoOperacion == MODIFICAR) {
				mostrarDatos(a);
				habilitarEntradas(true);
				txtCodigo.setEditable(false); // no modificar
				btnOk.setEnabled(true);
				habilitarBusqueda(false);
				
			}
				else if (tipoOperacion == ELIMINAR) {
				    matriculas.listarMatriculas(); // 👈 Cargar matrículas desde archivo
				    
				    if (matriculas.existeCursoMatriculado(a.getCodCurso())) {
				        mensaje("No se puede eliminar: curso tiene alumnos matriculados.");
				        restaurarInterfazInicial();
				        return;
				    }

				int ok = verificar("¿Desea eliminar el registro?");
				if (ok == JOptionPane.YES_OPTION) {
					if (TablaCursos.isEditing()) {
						TablaCursos.getCellEditor().stopCellEditing();
					}
					cursos.eliminar(a);
					cursos.grabarCurso();
					listar();
					limpiar();
					mensaje("Curso eliminado correctamente");

					// ✅ Reemplaza múltiples líneas por una sola:
					restaurarInterfazInicial();
				}
			}
		} catch (Exception ex) {
			error("Ingrese un código válido", txtCodigo);
		}
	}
	// -------------------BOTON ADICCIONAR-------------------
	protected void actionPerformedbtnAdicionar(ActionEvent e) {
		tipoOperacion = ADICIONAR;
		limpiar();
		habilitarEntradas(true);     // Aquí se activa txtCodigo si es ADICIONAR
		habilitarBotones(false);
		habilitarBusqueda(false);
		btnOk.setEnabled(true);
		txtCodigo.setText("");       // El usuario escribirá el código
		txtCodigo.requestFocus();    // Empieza por Asignatura
	}
	
	// ------------------BOTON CONSULTAR--------------------------
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;

		// Verificamos si hay alumnos registrados
		if (cursos.tamano() == 0) {
			habilitarEntradas(false);
			btnOk.setEnabled(false);
			mensaje("sin cursos registrados");
			return;
		}

		// Preparamos la interfaz
		limpiar();                         // Limpiar todos los campos
		habilitarBotones(false);          // Desactivar botones principales
		habilitarEntradas(false);         // No se puede editar
		habilitarBusqueda(true);          // Activar botón y campo de búsqueda
		
		
		
		
		txtCodigo.setText(""); // Borrar el campo de código
		txtCodigo.setEditable(true); // Habilitar solo el código
		txtCodigo.requestFocus(); // Enfocar en el código

	}

	// --------------------BOTON MODIFICAR------------------------
	protected void actionPerformedBtnModificar(ActionEvent e) {
		tipoOperacion = MODIFICAR;
		if (cursos.tamano() == 0) {
			habilitarEntradas(true);
			btnOk.setEnabled(true);
			mensaje("No existe ningún Curso el cual modificar");
			return;
		}
		listar();
		limpiar();
		habilitarBotones(false);
		habilitarBusqueda(true);
		habilitarEntradas(false); // Evita editar antes de buscar
		btnOk.setEnabled(false);
		txtCodigo.setText("");
		txtCodigo.setEditable(true);
		txtCodigo.requestFocus();
		

	}

	// ----------------------BOTON OK------------------------------
	protected void actionPerformedBtnOk(ActionEvent e) {
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarCurso();
			break;
		case MODIFICAR:
			modificarCurso();
			break;
		}
	}

	// -------------------BOTON ELIMINAR--------------------------
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	    tipoOperacion = ELIMINAR;

	    if (cursos.tamano() == 0) {
	        mensaje("No hay cursos registrados");
	        return;
	    }

	    limpiar();
	    habilitarEntradas(false);
	    habilitarBotones(false);
	    habilitarBusqueda(true);
	    txtCodigo.setText("");
	    txtCodigo.setEditable(true);
	    txtCodigo.requestFocus();
	    btnCerrar.setEnabled(false);
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnOpciones(ActionEvent e) {
		restaurarInterfazInicial();
	}
	
	private void modificarCurso() {
		try {
			int codigo = Integer.parseInt(txtCodigo.getText().trim());
			Curso a = cursos.buscar(codigo);

			if (a == null) {
				mensaje("Curso no encontrado");
				return;
			}
			
			if (cboCiclo.getSelectedIndex() == 0) {
				mensaje("Debe seleccionar un ciclo válido");
				cboCiclo.requestFocus();
				return;
			}

			// Leer y actualizar datos
			String asignatura = txtAsigna.getText().trim();
			int ciclo = cboCiclo.getSelectedIndex();
			int creditos = Integer.parseInt(txtCreditos.getText().trim());
			String tipoCurso = cboTipo.getSelectedItem().toString();
			String modalidad = cboModa.getSelectedItem().toString();
			int horas = Integer.parseInt(txtHoras.getText().trim());
			
			
			if (asignatura.isEmpty()) {
			    error("Ingrese la asignatura", txtAsigna);
			    return;
			}
			
			if (!asignatura.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
			    error("La asignatura solo debe contener letras", txtAsigna);
			    txtAsigna.requestFocus();
			    return;
			}
			
			Curso repetido = cursos.buscarPorAsignatura(asignatura);
			if (repetido != null && repetido.getCodCurso() != codigo) {
			    error("Ya existe otro curso con esa asignatura", txtAsigna);
			    txtAsigna.requestFocus();
			    return;
			}
			
			if (creditos <= 0) {
				error("Los créditos deben ser mayores a 0", txtCreditos);
				txtCreditos.requestFocus();  
				return;
			}
			if (horas <= 0) {
				error("Las horas deben ser mayores a 0", txtHoras);
				txtHoras.requestFocus();  
				return;
			}

			a.setAsignatura(asignatura);
			a.setCiclo(ciclo);
			a.setCredi(creditos);
			a.setTipoCurso(tipoCurso);
			a.setModalidad(modalidad);
			a.setHoras(horas);
			
			cursos.grabarCurso();
			cursos.ordenarPorCodigo();
			listar();
			mensaje("Curso modificado correctamente");

			// 👇 Usamos el método centralizado
			restaurarInterfazInicial();

		} catch (Exception e) {
			mensaje("Error al modificar. Verifique los datos.");
		}
	}

	// -----------------------MOSTRAR DATOS------------------------
	private void mostrarDatos(Curso a) {

		txtCodigo.setText("" + a.getCodCurso());
		txtAsigna.setText(a.getAsignatura());
		cboCiclo.setSelectedIndex(a.getCiclo());
		txtCreditos.setText(String.valueOf(a.getCredi()));
		cboTipo.setSelectedItem(a.getTipoCurso());
		cboModa.setSelectedItem(a.getModalidad());
		txtHoras.setText(String.valueOf(a.getHoras()));
	}

	// ----------metodos habilitar-----------------------
	private void habilitarEntradas(boolean b) {
		txtAsigna.setEditable(b);
		txtCreditos.setEditable(b);
		cboCiclo.setEnabled(b);         // El combo sí se habilita con setEnabled
		txtHoras.setEditable(b);   
		cboTipo.setEnabled(b);       // ✅ activar combo de tipo de curso
		cboModa.setEnabled(b);// ✅ Esto es lo nuevo y necesario
		
		if (tipoOperacion == ADICIONAR)
			txtCodigo.setEditable(true);
		else
			txtCodigo.setEditable(false);

		
	}

	private void habilitarBotones(boolean b) {
		btnAdicionar.setEnabled(b);
		btnModificar.setEnabled(b);
		btnConsultar.setEnabled(b);
		btnEliminar.setEnabled(b);
		btnCerrar.setEnabled(b); 
		btnOpciones.setEnabled(!b);

	}

	private void habilitarBusqueda(boolean b) {
		btnBuscar.setEnabled(b);
		
		// Solo editar código si estamos en una operación de búsqueda
		if (tipoOperacion == CONSULTAR || tipoOperacion == MODIFICAR || tipoOperacion == ELIMINAR)
			txtCodigo.setEditable(b);
	}
	
	
	private void restaurarInterfazInicial() {
	    habilitarEntradas(false);
	    habilitarBusqueda(false);
	    habilitarBotones(true);
	    btnOk.setEnabled(false);
	    txtCodigo.setEditable(false);
	    limpiar();
	}

	// -----------------LIMPIAR----------------------
	private void limpiar() {
		txtCodigo.setText("");
		txtAsigna.setText("");
		cboCiclo.setSelectedIndex(0);
		txtCreditos.setText("");
		cboTipo.setSelectedIndex(0);    // ✅
		cboModa.setSelectedIndex(0); 
		txtHoras.setText("");

	}
	
	
	private void eliminarCurso(Curso c) {
	    // Verificar si el curso tiene alguna matrícula
	    boolean estaMatriculado = matriculas.existeCursoMatriculado(c.getCodCurso());

	    if (estaMatriculado) {
	        mensaje("No se puede eliminar: Hay alumnos matriculados en este curso");
	        restaurarInterfazInicial();
	        return;
	    }

	    // Confirmar eliminación
	    int opcion = verificar("¿Desea eliminar el curso?");
	    if (opcion == JOptionPane.YES_OPTION) {
	        cursos.eliminar(c);
	        cursos.grabarCurso();
	        listar();
	        mensaje("Curso eliminado correctamente");
	        restaurarInterfazInicial();
	    }
	}
	
	private int verificar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Confirmación", JOptionPane.YES_NO_OPTION);
	
}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
}