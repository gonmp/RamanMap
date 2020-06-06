package raman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.io.File;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class SegundaVentana2D extends JFrame {

	private JPanel contentPane;
	private JTextField txtArchivoOrigen;
	private JTextField txtArchivoFinal;
	private JTextField txtInferior1;
	private JTextField txtSuperior1;
	private JTextField txtPaso1;
	private JTextField txtCantidadEspectros;
	private JTextField txtCantidadDatos;
	private JTextField txtInferior2;
	private JTextField txtSuperior2;
	private JTextField txtPaso2;
	private JLabel lblError;
	private JButton btnFinalizar;
	private FileChooser fileChooser;
	private FileChooserGuardar fileChooserGuardar;
	private File archivo;
	private File archivoFinal;
	private int extremoInferior1, extremoSuperior1, extremoInferior2, extremoSuperior2, cantidadEspectros, intervalo1, intervalo2, paso1, paso2;
	private ArchivoTexto aplicacion;
	private UltimaVentana ultimaVentana;
	private PrimerVentana primerVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundaVentana2D frame = new SegundaVentana2D();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SegundaVentana2D() {
		
		primerVentana = new PrimerVentana();
		
        ultimaVentana = new UltimaVentana();
		
		fileChooser = new FileChooser();
		fileChooserGuardar = new FileChooserGuardar();
		aplicacion = new ArchivoTexto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArchivosConLos = new JLabel("Archivos con los datos");
		lblArchivosConLos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArchivosConLos.setBounds(10, 25, 152, 14);
		contentPane.add(lblArchivosConLos);
		
		txtArchivoOrigen = new JTextField();
		txtArchivoOrigen.setEditable(false);
		txtArchivoOrigen.setBounds(166, 22, 459, 20);
		contentPane.add(txtArchivoOrigen);
		txtArchivoOrigen.setColumns(10);
		
		JButton btnArchivoOrigen = new JButton("Buscar");
		btnArchivoOrigen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				archivo = fileChooser.obtenerArchivo(contentPane);
				txtArchivoOrigen.setText(archivo.getAbsolutePath());
				if(archivo != null && archivoFinal != null){
					btnFinalizar.setEnabled(true);
				}
			}
		});
		btnArchivoOrigen.setBounds(635, 21, 89, 23);
		contentPane.add(btnArchivoOrigen);
		
		JLabel lblArchivoFinal = new JLabel("Archivo final");
		lblArchivoFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArchivoFinal.setBounds(39, 76, 89, 14);
		contentPane.add(lblArchivoFinal);
		
		txtArchivoFinal = new JTextField();
		txtArchivoFinal.setEditable(false);
		txtArchivoFinal.setColumns(10);
		txtArchivoFinal.setBounds(166, 73, 459, 20);
		contentPane.add(txtArchivoFinal);
		
		JButton btnArchivoFinal = new JButton("Buscar");
		btnArchivoFinal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				archivoFinal = fileChooserGuardar.obtenerArchivo(contentPane);
				txtArchivoFinal.setText(archivoFinal.getAbsolutePath());
				if(archivo != null && archivoFinal != null){
					btnFinalizar.setEnabled(true);
				}
			}
		});
		btnArchivoFinal.setBounds(635, 72, 89, 23);
		contentPane.add(btnArchivoFinal);
		
		JLabel lblCoordenadasDeLa = new JLabel("Coordenadas de la cuandricula en x");
		lblCoordenadasDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenadasDeLa.setBounds(10, 136, 231, 14);
		contentPane.add(lblCoordenadasDeLa);
		
		JLabel lblIngreseLaCoordenada_1 = new JLabel("Ingrese la coordenada inferior en x: ");
		lblIngreseLaCoordenada_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseLaCoordenada_1.setBounds(10, 177, 238, 19);
		contentPane.add(lblIngreseLaCoordenada_1);
		
		txtInferior1 = new JTextField();
		txtInferior1.setHorizontalAlignment(SwingConstants.CENTER);
		txtInferior1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInferior1.setColumns(10);
		txtInferior1.setBounds(258, 175, 59, 20);
		contentPane.add(txtInferior1);
		
		JLabel lblIngreseLaCoordenada = new JLabel("Ingrese la coordenada superior en x: ");
		lblIngreseLaCoordenada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseLaCoordenada.setBounds(10, 212, 238, 19);
		contentPane.add(lblIngreseLaCoordenada);
		
		txtSuperior1 = new JTextField();
		txtSuperior1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuperior1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSuperior1.setColumns(10);
		txtSuperior1.setBounds(258, 212, 59, 20);
		contentPane.add(txtSuperior1);
		
		JLabel lblPaso = new JLabel("Ingrese el paso utilizado en x:");
		lblPaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaso.setBounds(10, 249, 238, 19);
		contentPane.add(lblPaso);
		
		txtPaso1 = new JTextField();
		txtPaso1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaso1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPaso1.setColumns(10);
		txtPaso1.setBounds(258, 249, 59, 20);
		contentPane.add(txtPaso1);
		
		JButton btnComprobarNumerosDe = new JButton("Comprobar cantidad de espectros");
		btnComprobarNumerosDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					extremoInferior1 = Integer.parseInt(txtInferior1.getText());
				    extremoSuperior1 = Integer.parseInt(txtSuperior1.getText());
				    paso1 = Integer.parseInt(txtPaso1.getText());
				    intervalo1 = extremoSuperior1 - extremoInferior1;
				    extremoInferior2 = Integer.parseInt(txtInferior2.getText());
				    extremoSuperior2 = Integer.parseInt(txtSuperior2.getText());
				    paso2 = Integer.parseInt(txtPaso2.getText());
				    intervalo2 = extremoSuperior2 - extremoInferior2;
				    cantidadEspectros = ((intervalo1 / paso1) + 1) * ((intervalo2 / paso2) + 1);
			    	txtCantidadEspectros.setText(Integer.toString(cantidadEspectros));
			    	lblError.setText("");
				}
				catch(NumberFormatException numberFormatException){
					lblError.setText("Hay algun error con algun numero");
				}
			}
		});
		btnComprobarNumerosDe.setBounds(10, 300, 231, 23);
		contentPane.add(btnComprobarNumerosDe);
		
		txtCantidadEspectros = new JTextField();
		txtCantidadEspectros.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadEspectros.setEditable(false);
		txtCantidadEspectros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCantidadEspectros.setColumns(10);
		txtCantidadEspectros.setBounds(258, 301, 59, 20);
		contentPane.add(txtCantidadEspectros);
		
		JLabel lblNumerosDeDatos = new JLabel("Numeros de datos por espectro");
		lblNumerosDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumerosDeDatos.setBounds(10, 352, 218, 20);
		contentPane.add(lblNumerosDeDatos);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de datos tomados por cada espectro:");
		lblIngreseElNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElNumero.setBounds(10, 386, 319, 19);
		contentPane.add(lblIngreseElNumero);
		
		txtCantidadDatos = new JTextField();
		txtCantidadDatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCantidadDatos.setColumns(10);
		txtCantidadDatos.setBounds(339, 384, 59, 20);
		contentPane.add(txtCantidadDatos);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SegundaVentana2D.this.dispose();
				primerVentana.setVisible(true);
			}
		});
		btnAtras.setBounds(536, 396, 89, 23);
		contentPane.add(btnAtras);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				extremoInferior1 = Integer.parseInt(txtInferior1.getText());
			    extremoSuperior1 = Integer.parseInt(txtSuperior1.getText());
			    paso1 = Integer.parseInt(txtPaso1.getText());
			    intervalo1 = extremoSuperior1 - extremoInferior1;
			    extremoInferior2 = Integer.parseInt(txtInferior2.getText());
			    extremoSuperior2 = Integer.parseInt(txtSuperior2.getText());
			    paso2 = Integer.parseInt(txtPaso2.getText());
			    intervalo2 = extremoSuperior2 - extremoInferior2;
			    cantidadEspectros = ((intervalo1 / paso1) + 1) * ((intervalo2 / paso2) + 1);
			    
			    aplicacion.abrirArchivo(archivo);
				aplicacion.abrirArchivoDos(archivoFinal);
				aplicacion.leerDato(cantidadEspectros, Integer.parseInt(txtCantidadDatos.getText()));
				aplicacion.cerrarArchivo();
				aplicacion.cerrarArchivoDos();
				
				SegundaVentana2D.this.dispose();
				
				ultimaVentana.setVisible(true);
			}
		});
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBounds(635, 396, 89, 23);
		contentPane.add(btnFinalizar);
		
		JLabel lblCoordenadasDeLa_1 = new JLabel("Coordenadas de la cuandricula en y");
		lblCoordenadasDeLa_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenadasDeLa_1.setBounds(391, 136, 231, 20);
		contentPane.add(lblCoordenadasDeLa_1);
		
		JLabel lblIngreseLaCoordenada_2 = new JLabel("Ingrese la coordenada inferior en y: ");
		lblIngreseLaCoordenada_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseLaCoordenada_2.setBounds(391, 177, 238, 19);
		contentPane.add(lblIngreseLaCoordenada_2);
		
		txtInferior2 = new JTextField();
		txtInferior2.setHorizontalAlignment(SwingConstants.CENTER);
		txtInferior2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInferior2.setColumns(10);
		txtInferior2.setBounds(639, 175, 59, 20);
		contentPane.add(txtInferior2);
		
		txtSuperior2 = new JTextField();
		txtSuperior2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuperior2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSuperior2.setColumns(10);
		txtSuperior2.setBounds(639, 212, 59, 20);
		contentPane.add(txtSuperior2);
		
		JLabel lblIngreseLaCoordenada_3 = new JLabel("Ingrese la coordenada superior en y: ");
		lblIngreseLaCoordenada_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseLaCoordenada_3.setBounds(391, 212, 238, 19);
		contentPane.add(lblIngreseLaCoordenada_3);
		
		JLabel lblIngreseElPaso = new JLabel("Ingrese el paso utilizado en y:");
		lblIngreseElPaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElPaso.setBounds(391, 249, 238, 19);
		contentPane.add(lblIngreseElPaso);
		
		txtPaso2 = new JTextField();
		txtPaso2.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaso2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPaso2.setColumns(10);
		txtPaso2.setBounds(639, 249, 59, 20);
		contentPane.add(txtPaso2);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(405, 313, 271, 20);
		contentPane.add(lblError);
	}
}
