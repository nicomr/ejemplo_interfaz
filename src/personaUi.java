import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import entidades.Persona;

public class personaUi {

	private JFrame frame;
	private JTextField campoNombre;
	private JTextField campoApellido;
	private JTextField campoDNI;
	
	private Controlador ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					personaUi window = new personaUi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public personaUi() {
		initialize();
		ctrl=new Controlador();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("78px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(210dlu;pref):grow"),},
			new RowSpec[] {
				RowSpec.decode("46px"),
				RowSpec.decode("46px"),
				RowSpec.decode("max(36dlu;default)"),
				RowSpec.decode("max(38dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		Persona p;
		p=new Persona();
		
		JLabel lblNombre = new JLabel("Nombre");
		frame.getContentPane().add(lblNombre, "1, 1, right, center");
		
		campoNombre = new JTextField();
		frame.getContentPane().add(campoNombre, "3, 1, default, center");
		campoNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		frame.getContentPane().add(lblNewLabel, "1, 2, right, center");
		
		campoApellido = new JTextField();
		frame.getContentPane().add(campoApellido, "3, 2, fill, default");
		campoApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		frame.getContentPane().add(lblDni, "1, 3, right, default");
		
		campoDNI = new JTextField();
		frame.getContentPane().add(campoDNI, "3, 3, fill, default");
		campoDNI.setColumns(10);
		
		
		p.setApellido(campoApellido.toString());
		p.setDni(campoDNI.toString());
		p.setNombre(campoNombre.toString());
		
		
		JCheckBox chckbxHabilitado = new JCheckBox("Habilitado");
		frame.getContentPane().add(chckbxHabilitado, "3, 4");
		
		JButton btnAceptar = new JButton("Aceptar");
		frame.getContentPane().add(btnAceptar, "1, 6");
		
		JButton btnCancelar = new JButton("Cancelar");
		frame.getContentPane().add(btnCancelar, "1, 8");
	}
	
	private void nuevaPersona(){
		Persona p= new Persona();
		p.setApellido(campoApellido.getText());
		
		ctrl.agregar(p);
	}

}
