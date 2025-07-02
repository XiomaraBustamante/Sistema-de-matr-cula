package guis;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import clases.Alumno;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import arreglos.ArregloAlumnos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import utilidades.Utilidades;

public class DlgAlumno extends JDialog implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDNI;
	private JLabel lblEdad;
	private JLabel lblCelular;
	private JLabel lblEstado;
	private JLabel lblCorreo;
	private JLabel lblDirec;
	private JTextField txtDirec;
    private JTextField txtCorreo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;
	private JScrollPane scpPane;
	private JTable TablaEstudiantes;
	private JComboBox cboEstado;
	private DefaultTableModel modelo;
	private JButton btnBuscar;
	private JButton btnOk;
	private JButton btnOpciones;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	
//  Tipo de operación a procesar: Adicionar, Consultar, Modificar o Eliminar
	private int tipoOperacion;
	
//  Constantes para los tipos de operaciones
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgAlumno dialog = new DlgAlumno();
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
	public DlgAlumno() {
		setTitle("Mantenimiento | Alumno");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(Color.BLACK);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigo.setBounds(10, 11, 68, 32);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(81, 19, 113, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 49, 68, 32);
		getContentPane().add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.BLACK);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellidos.setBounds(10, 88, 68, 32);
		getContentPane().add(lblApellidos);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setForeground(Color.BLACK);
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDNI.setBounds(10, 122, 68, 32);
		getContentPane().add(lblDNI);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setForeground(Color.BLACK);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdad.setBounds(10, 153, 68, 32);
		getContentPane().add(lblEdad);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setForeground(Color.BLACK);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCelular.setBounds(10, 190, 68, 32);
		getContentPane().add(lblCelular);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstado.setBounds(10, 292, 68, 32);
		getContentPane().add(lblEstado);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(81, 57, 212, 20);
		getContentPane().add(txtNombre);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(81, 96, 212, 20);
		getContentPane().add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setColumns(10);
		txtDni.setBounds(81, 130, 212, 20);
		getContentPane().add(txtDni);
		
		txtEdad = new JTextField();
		txtEdad.setEditable(false);
		txtEdad.setColumns(10);
		txtEdad.setBounds(81, 161, 212, 20);
		getContentPane().add(txtEdad);
		
		txtCelular = new JTextField();
		txtCelular.setEditable(false);
		txtCelular.setColumns(10);
		txtCelular.setBounds(81, 198, 212, 20);
		getContentPane().add(txtCelular);
		
		scpPane = new JScrollPane();
		scpPane.setBounds(10, 335, 889, 243);
		getContentPane().add(scpPane);
		
		cboEstado = new JComboBox<String>();
		cboEstado.setFont(new Font("Roboto Condensed", Font.PLAIN, 13));
		cboEstado.setModel(new DefaultComboBoxModel<String>(Utilidades.getEstadoAlumno()));
		cboEstado.setEnabled(false);
		cboEstado.setBounds(81, 299, 113, 22);
		getContentPane().add(cboEstado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setEnabled(false);
		btnBuscar.setBounds(204, 18, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		btnOk.setBounds(204, 299, 89, 23);
		getContentPane().add(btnOk);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(this);
		btnOpciones.setEnabled(false);
		btnOpciones.setBounds(554, 93, 143, 122);
		getContentPane().add(btnOpciones);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(getClass().getResource("/img/adicionar.png")));
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(740, 52, 141, 32);
		getContentPane().add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(getClass().getResource("/img/consultar.png")));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(740, 94, 141, 32);
		getContentPane().add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(getClass().getResource("/img/modificar.png")));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(740, 143, 141, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(getClass().getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(740, 183, 141, 32);
		getContentPane().add(btnEliminar);
		setBounds(100, 100, 925, 628);
		
		TablaEstudiantes = new JTable();
		TablaEstudiantes.setFillsViewportHeight(true);
		TablaEstudiantes.addMouseListener(this);
		scpPane.setViewportView(TablaEstudiantes);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("EDAD");
		modelo.addColumn("CELULAR");
		modelo.addColumn("CORREO");
		modelo.addColumn("DIRECCIÓN");
		modelo.addColumn("ESTADO");
		TablaEstudiantes.setModel(modelo);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 223, 68, 32);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setText("");
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(81, 229, 212, 20);
		getContentPane().add(txtCorreo);
		
		lblDirec = new JLabel("Dirección");
		lblDirec.setForeground(Color.BLACK);
		lblDirec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDirec.setBounds(10, 261, 68, 20);
		getContentPane().add(lblDirec);
		
		txtDirec = new JTextField();
		txtDirec.setText("");
		txtDirec.setEditable(false);
		txtDirec.setColumns(10);
		txtDirec.setBounds(81, 261, 212, 20);
		getContentPane().add(txtDirec);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(getClass().getResource("/img/cerrar.png")));
		btnCerrar.setBounds(740, 229, 141, 32);
		getContentPane().add(btnCerrar);
		
		
		habilitarEntradas(false);
		habilitarBusqueda(false);
		habilitarBotones(true); 
		fijarAnchoColumnas();
		listar();
		
		aa.listarAlumnos();
		listar();  // Este método ya llena la tabla correctamente

	}
	
	 

	// DECLARACION GLOBAL : ARREGLO ALUMNO
    ArregloAlumnos aa = new ArregloAlumnos();
    
   
    
   
 // ACTION PERFORMED DE MIS BOTONES
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnCerrar) {
    		actionPerformedBtnCerrar(e);
    	}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnNewButton(e);
		}
		if (e.getSource() == btnOpciones) {
			actionPerformedBtnOpciones(e);
		}
		if (e.getSource() == btnOk) {
			actionPerformedBtnOk(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		
		
		
		
	}
    
    
    /** COMIENZO DE LOS LLAMADOS A LOS BOTONES */

    // BOTON ADICIONAR
    protected void actionPerformedBtnNewButton(ActionEvent e) {
    	tipoOperacion = ADICIONAR;
    	limpiar();

    	txtCodigo.setText("" + aa.codigoCorrelativo());
    	habilitarEntradas(true);
    	habilitarBotones(false);     // 🔁 Aquí cambias de true a false
    	habilitarBusqueda(false);
    	cboEstado.setSelectedIndex(0);
    	cboEstado.setEnabled(false);
    	

    	txtNombre.requestFocus();
    	btnCerrar.setEnabled(false);
    	
    	
    }
    
    
    
    // BOTON MODIFICAR
    protected void actionPerformedBtnModificar(ActionEvent e) {
    	tipoOperacion = MODIFICAR;
    	if (aa.tamano() == 0) {
    		habilitarEntradas(false);
    		btnOk.setEnabled(false);
    		mensaje("No existe ningún ALUMNO el cual modificar");
    		return;
    	}

    	limpiar();
    	habilitarBotones(false);
    	habilitarBusqueda(true);
    	habilitarEntradas(false); // Evita editar antes de buscar
    	txtCodigo.setText("");
    	txtCodigo.setEditable(true);
    	txtCodigo.requestFocus();
    	btnCerrar.setEnabled(false);
	}
    
    //BOTON ELIMINAR
    protected void actionPerformedBtnEliminar(ActionEvent e) {
    	tipoOperacion = ELIMINAR;

    	if (aa.tamano() == 0) {
    		mensaje("No hay alumnos registrados");
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
    
    //BOTON BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		 try {
		        int codigo = leerCodigoAlumno();
		        Alumno a = aa.buscar(codigo);

		        if (a == null) {
		            error("El código " + codigo + " no existe", txtCodigo);
		            return;
		        }

		        if (tipoOperacion == MODIFICAR) {
		            prepararModificacion(a);
		        }
		        else if (tipoOperacion == ELIMINAR) {
		            eliminarAlumno(a);
		            habilitarBusqueda(false);
		        }
		        else if (tipoOperacion == CONSULTAR) {
		            mostrarDatos(a);
		            habilitarEntradas(false);
		            btnOk.setEnabled(false);
		            habilitarBusqueda(false);
		        }

		    } catch (Exception ex) {
		        error("Ingrese un código válido", txtCodigo);
		    }
		
	}
	
	

	

	// Métodos que retornan valor (sin parámetros)
    int leerCodigoAlumno() {
	return Integer.parseInt(txtCodigo.getText().trim());
    }

    String leerNombres() {
	return txtNombre.getText().trim();
    }

    String leerApellidos() {
	return txtApellidos.getText().trim();
    }

    String leerDni() {
	return txtDni.getText().trim();
    }

    int leerEdad() {
	return Integer.parseInt(txtEdad.getText().trim());
    }

    int leerCelular() {
	return Integer.parseInt(txtCelular.getText().trim());
    }

    int leerEstado() {
	return cboEstado.getSelectedIndex();
    }
    
    
    String leerCorreo() {
    	return txtCorreo.getText().trim();
    }

    String leerDireccion() {
    	return txtDirec.getText().trim();
    }

	private int confirmar(String s) {
			return JOptionPane.showConfirmDialog(this, s, "Confirmación", JOptionPane.YES_NO_OPTION);
		
	}

	//BOTON OK
		protected void actionPerformedBtnOk(ActionEvent e) {
			switch (tipoOperacion) {
				case ADICIONAR:
					adicionarAlumno();
					break;
				case MODIFICAR:
					modificarAlumno();
					break;
			}
		}
	
	private void adicionarAlumno() {
	    try {
	        // Leer código generado automáticamente
	        int codigo = Integer.parseInt(txtCodigo.getText().trim());

	        // Leer campos de texto
	        String nombres = txtNombre.getText().trim();
	        String apellidos = txtApellidos.getText().trim();
	        String dni = txtDni.getText().trim();
	        String txtEdadStr = txtEdad.getText().trim();
	        String txtCelStr = txtCelular.getText().trim();
	        String correo = txtCorreo.getText().trim();
	        String direccion = txtDirec.getText().trim();
	        int estado = cboEstado.getSelectedIndex();

	        // --- Validaciones ---

	        if (nombres.isEmpty()) {
	            error("Ingrese los nombres", txtNombre);
	            return;
	        }
	        if (!esTextoValido(nombres)) {
	            error("Los nombres solo deben contener letras", txtNombre);
	            return;
	        }

	        if (apellidos.isEmpty()) {
	            error("Ingrese los apellidos", txtApellidos);
	            return;
	        }
	        if (!esTextoValido(apellidos)) {
	            error("Los apellidos solo deben contener letras", txtApellidos);
	            return;
	        }

	        if (dni.isEmpty()) {
	            error("Ingrese el DNI", txtDni);
	            return;
	        }
	        if (!esNumero(dni)) {
	            error("El DNI debe contener solo números", txtDni);
	            return;
	        }
	        if (dni.length() != 8) {
	            error("El DNI debe tener 8 dígitos", txtDni);
	            return;
	        }
	        if (aa.existeDni(dni)) {
	            error("El DNI ingresado ya está registrado", txtDni);
	            return;
	        }

	        if (txtEdadStr.isEmpty()) {
	            error("Ingrese la edad", txtEdad);
	            return;
	        }
	        if (!esNumero(txtEdadStr)) {
	            error("La edad debe contener solo números", txtEdad);
	            return;
	        }
	        int edad = Integer.parseInt(txtEdadStr);
	        if (edad < 16 || edad > 90) {
	            error("La edad ingresada no es válida", txtEdad);
	            return;
	        }

	        if (txtCelStr.isEmpty()) {
	            error("Ingrese el celular", txtCelular);
	            return;
	        }
	        if (!esNumero(txtCelStr)) {
	            error("El celular debe contener solo números", txtCelular);
	            return;
	        }
	        if (txtCelStr.length() != 9) {
	            error("El celular debe tener 9 dígitos", txtCelular);
	            return;
	        }
	        int celular = Integer.parseInt(txtCelStr);

	        if (correo.isEmpty()) {
	            error("Ingrese el correo", txtCorreo);
	            return;
	        }
	        if (!esCorreoValido(correo)) {
	            error("Ingrese un correo válido (ejemplo@dominio.com)", txtCorreo);
	            return;
	        }

	        if (direccion.isEmpty()) {
	            error("Ingrese la dirección", txtDirec);
	            return;
	        }
	        
	        if (aa.existeCorreo(correo)) {
	            error("El correo ingresado ya está registrado", txtCorreo);
	            return;
	        }

	        if (aa.existeCelular(celular)) {
	            error("El celular ingresado ya está registrado", txtCelular);
	            return;
	        }

	        // --- Crear y agregar alumno ---
	        Alumno nuevo = new Alumno(codigo, nombres, apellidos, dni, edad, celular, correo, direccion, estado);
	        aa.adicionar(nuevo);
	        aa.grabarAlumnos();
	        listar();
	        mensaje("Alumno registrado correctamente");
	        restaurarInterfazInicial();
	        

	        // Restaurar interfaz
	        habilitarEntradas(false);
	        habilitarBotones(true);
	        btnOk.setEnabled(false);

	    } catch (Exception e) {
	        mensaje("Error inesperado al registrar el alumno");
	    }
	}
	
	
	private void modificarAlumno() {
		try {
			int codigo = Integer.parseInt(txtCodigo.getText().trim());
			Alumno a = aa.buscar(codigo);

			if (a == null) {
				mensaje("Alumno no encontrado");
				return;
			}

			// Leer y actualizar datos
			String nombres = txtNombre.getText().trim();
			String apellidos = txtApellidos.getText().trim();
			int edad = Integer.parseInt(txtEdad.getText().trim());
			int celular = Integer.parseInt(txtCelular.getText().trim());
			String correo = leerCorreo();
			String direccion = leerDireccion();
			
			
			if (aa.existeCorreoEnOtro(correo, codigo)) {
			    error("El correo ingresado ya está registrado por otro alumno", txtCorreo);
			    return;
			}

			if (aa.existeCelularEnOtro(celular, codigo)) {
			    error("El celular ingresado ya está registrado por otro alumno", txtCelular);
			    return;
			}
			

			a.setNombres(nombres);
			a.setApellidos(apellidos);
			a.setEdad(edad);
			a.setCelular(celular);
			a.setCorreo(correo);
			a.setDirec(direccion);
			
			
			aa.grabarAlumnos();

			listar();
			mensaje("Alumno modificado correctamente");
			restaurarInterfazInicial(); 

			// Reiniciar estado
			habilitarEntradas(false);
			habilitarBotones(true);
			btnOk.setEnabled(false);

		} catch (Exception e) {
			mensaje("Error al modificar. Verifique los datos.");
		}
		
	}

	

	protected void actionPerformedBtnConsultar(ActionEvent e) {
		tipoOperacion = CONSULTAR;

		// Verificamos si hay alumnos registrados
		if (aa.tamano() == 0) {
			habilitarEntradas(false);
			btnOk.setEnabled(false);
			mensaje("No hay alumnos registrados");
			return;
		}

		// Preparamos la interfaz
		limpiar();                         // Limpiar todos los campos
		habilitarBotones(false);          // Desactivar botones principales
		habilitarEntradas(false);         // No se puede editar
		habilitarBusqueda(true);          // Activar botón y campo de búsqueda
		txtCodigo.setText("");      // Borrar el campo de código
		txtCodigo.setEditable(true); // Habilitar solo el código
		txtCodigo.requestFocus();   // Enfocar en el código
		btnCerrar.setEnabled(false);
		
		
		
	}
	
	
	// Verifica que el texto solo tenga letras y espacios
	boolean esTextoValido(String texto) {
		return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
	}

	// Verifica que el texto tenga solo números
	boolean esNumero(String texto) {
		return texto.matches("\\d+");
	}
	
	
	//BOTON OPCIONES
	protected void actionPerformedBtnOpciones(ActionEvent e) {
		tipoOperacion = -1;
		limpiar();
		habilitarEntradas(false);
		habilitarBotones(true);     // ✅ Restaurar botones principales
		habilitarBusqueda(false);
		btnOk.setEnabled(false);
		txtCodigo.setEditable(false);
		btnCerrar.setEnabled(true); // 👈 habilitar
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	private void eliminarAlumno(Alumno a) {
		if (a.getEstado() == 0) {
			int ok = confirmar("¿Desea eliminar el registro?");
			if (ok == JOptionPane.YES_OPTION) {
				if (TablaEstudiantes.isEditing()) {
					TablaEstudiantes.getCellEditor().stopCellEditing();
				}
				aa.eliminar(a);
				aa.grabarAlumnos();
				listar();
				limpiar();
				mensaje("Alumno eliminado correctamente");
				restaurarInterfazInicial();
			}
		} else {
			mensaje("Solo se puede eliminar alumnos REGISTRADOS");
			restaurarInterfazInicial();
		}
	}
	
	
	private void prepararModificacion(Alumno a) {
		mostrarDatos(a);
		cboEstado.setEnabled(false);
		habilitarEntradas(true);
		txtCodigo.setEditable(false);
		txtDni.setEditable(false);
		btnOk.setEnabled(true);
		habilitarBusqueda(false);
	}
	
	


	

	private void limpiar() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtEdad.setText("");
		txtCelular.setText("");
		txtCorreo.setText("");
		txtDirec.setText("");
		cboEstado.setSelectedIndex(0); // "Registrado"
		
	}
	
	private void listar() {
		int posFila = TablaEstudiantes.getSelectedRow();  // Fila seleccionada antes de actualizar
	    modelo.setRowCount(0); // Limpiar la tabla

	    for (int i = 0; i < aa.tamano(); i++) {
	        Alumno a = aa.obtener(i);
	        Object[] fila = {
	            a.getCodAlumno(),
	            a.getNombres(),
	            a.getApellidos(),
	            a.getDni(),
	            a.getEdad(),
	            a.getCelular(),
	            a.getCorreo(),
	            a.getDirec(),
	            enTextoEstado(a.getEstado())
	        };
	        modelo.addRow(fila);
	    }

	    // ✅ Validar que la fila exista antes de seleccionarla
	    if (aa.tamano() > 0 && posFila >= 0 && posFila < modelo.getRowCount()) {
	        TablaEstudiantes.getSelectionModel().setSelectionInterval(posFila, posFila);
	    }
	   
		
	}
	
	
	private Object enTextoEstado(int estado) {
		 return Utilidades.getEstadoAlumno()[estado]; // o Utilidades.getEstadoAlumno()[i];
		
	}

	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", JOptionPane.INFORMATION_MESSAGE);
	}

	// Mensaje de error (ícono rojo)
	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
		txt.setText("");
		txt.requestFocus();
	}
	
	
	private void habilitarEntradas(boolean b) {
		btnOk.setEnabled(b);
		txtNombre.setEditable(b);
		txtApellidos.setEditable(b);
		txtEdad.setEditable(b);
		txtCelular.setEditable(b);
		txtCorreo.setEditable(b);
		txtDirec.setEditable(b);
		
		cboEstado.setEnabled(false); // 👈 SIEMPRE deshabilitado
		txtDni.setEditable(tipoOperacion == ADICIONAR && b);

		// Permitir editar DNI solo en Adicionar
		if (tipoOperacion == ADICIONAR)
			txtDni.setEditable(b);
		else
			txtDni.setEditable(false);
		
	}
	
	private void habilitarBotones(boolean b) {
		btnAdicionar.setEnabled(b);
		btnModificar.setEnabled(b);
		btnConsultar.setEnabled(b);
		btnEliminar.setEnabled(b);
		
		btnOpciones.setEnabled(!b); // Se activa cuando los demás se desactivan
	}
	
	private void habilitarBusqueda(boolean b) {
		btnBuscar.setEnabled(b);
		txtCodigo.setEditable(b);
	}
	
	

	private void mostrarDatos(Alumno a) {
		
			txtCodigo.setText("" + a.getCodAlumno());
			txtNombre.setText(a.getNombres());
			txtApellidos.setText(a.getApellidos());
			txtDni.setText(a.getDni());
			txtEdad.setText(String.valueOf(a.getEdad()));
			txtCelular.setText(String.valueOf(a.getCelular()));
			txtCorreo.setText(a.getCorreo());
			txtDirec.setText(a.getDirec());
			cboEstado.setSelectedIndex(a.getEstado());	
	}
	
	private void restaurarInterfazInicial() {
		limpiar();
		habilitarEntradas(false);
		habilitarBusqueda(false);
		habilitarBotones(true);    // habilita adicionar, modificar, consultar, eliminar
		btnOk.setEnabled(false);
		txtCodigo.setEditable(false);
		btnCerrar.setEnabled(true);
	}
	
	

	
	boolean esCorreoValido(String correo) {
	    return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
	}
	

	
	private void fijarAnchoColumnas() {
		TableColumnModel tcm = TablaEstudiantes.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(100); // Código
	    tcm.getColumn(1).setPreferredWidth(130); // Nombres
	    tcm.getColumn(2).setPreferredWidth(150); // Apellidos
	    tcm.getColumn(3).setPreferredWidth(90);  // DNI
	    tcm.getColumn(4).setPreferredWidth(70);  // Edad
	    tcm.getColumn(5).setPreferredWidth(100); // Celular
	    tcm.getColumn(6).setPreferredWidth(200); // ✅ Correo 
	    tcm.getColumn(7).setPreferredWidth(150); // ✅ Dirección
	    tcm.getColumn(8).setPreferredWidth(80);  // Estado
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    int fila = TablaEstudiantes.rowAtPoint(e.getPoint());
	    if (fila < 0 || tipoOperacion < 0) return; // Nada seleccionado o sin operación

	    Alumno a = aa.obtener(fila);
	    mostrarDatos(a);

	    if (tipoOperacion == MODIFICAR) {
	        prepararModificacion(a);
	    }
	    else if (tipoOperacion == CONSULTAR) {
	        habilitarEntradas(false);
	        btnOk.setEnabled(false);
	    }
	    else if (tipoOperacion == ELIMINAR) {
	        eliminarAlumno(a);
	    }
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
