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
import java.io.FileNotFoundException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SegundaVentana1D extends JFrame {

	private JPanel contentPane;
	private JTextField txtArchivoOrigen;
	private JTextField txtArchivoFinal;
	private JTextField txtInferior;
	private JTextField txtSuperior;
	private JTextField txtPaso;
	private JTextField txtCantidadEspectros;
	private JTextField txtCantidadDatos;
	private JLabel lblError;
	private JButton btnFinalizar;
	private FileChooser fileChooser;
	private FileChooserGuardar fileChooserGuardar;
	private File archivo;
	private File archivoFinal;
	private int extremoInferior1, extremoSuperior1, cantidadEspectros, intervalo1, paso1;
	private ArchivoTexto aplicacion;
	private UltimaVentana ultimaVentana;
	private PrimerVentana primerVentana;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegundaVentana1D frame = new SegundaVentana1D();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SegundaVentana1D() {
		
		primerVentana = new PrimerVentana();
		
		ultimaVentana = new UltimaVentana();
		
		fileChooser = new FileChooser();
		fileChooserGuardar = new FileChooserGuardar();
		aplicacion = new ArchivoTexto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 372);
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
			public void mouseClicked(MouseEvent e) {
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
		
		JLabel lblCoordenadasDeLa = new JLabel("Coordenadas de la recta");
		lblCoordenadasDeLa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCoordenadasDeLa.setBounds(10, 136, 168, 14);
		contentPane.add(lblCoordenadasDeLa);
		
		JLabel label = new JLabel("Ingrese la coordenada inferior de la recta: ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(10, 177, 238, 19);
		contentPane.add(label);
		
		txtInferior = new JTextField();
		txtInferior.setHorizontalAlignment(SwingConstants.CENTER);
		txtInferior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtInferior.setColumns(10);
		txtInferior.setBounds(258, 175, 59, 20);
		contentPane.add(txtInferior);
		
		JLabel lblIngreseLaCoordenada = new JLabel("Ingrese la coordenada superior de la recta: ");
		lblIngreseLaCoordenada.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseLaCoordenada.setBounds(10, 212, 238, 19);
		contentPane.add(lblIngreseLaCoordenada);
		
		txtSuperior = new JTextField();
		txtSuperior.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuperior.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSuperior.setColumns(10);
		txtSuperior.setBounds(258, 212, 59, 20);
		contentPane.add(txtSuperior);
		
		JLabel lblPaso = new JLabel("Ingrese el paso utilizado:");
		lblPaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaso.setBounds(10, 249, 238, 19);
		contentPane.add(lblPaso);
		
		txtPaso = new JTextField();
		txtPaso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPaso.setColumns(10);
		txtPaso.setBounds(258, 249, 59, 20);
		contentPane.add(txtPaso);
		
		JButton btnComprobarNumerosDe = new JButton("Comprobar cantidad de espectros");
		btnComprobarNumerosDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					extremoInferior1 = Integer.parseInt(txtInferior.getText());
				    extremoSuperior1 = Integer.parseInt(txtSuperior.getText());
				    paso1 = Integer.parseInt(txtPaso.getText());
				    intervalo1 = extremoSuperior1 - extremoInferior1;
			    	cantidadEspectros = (intervalo1 / paso1) + 1;
			    	txtCantidadEspectros.setText(Integer.toString(cantidadEspectros));
			    	lblError.setText("");
				}
				catch(NumberFormatException numberFormatException){
					lblError.setText("Hay algun error con algun numero");
				}
			}
		});
		btnComprobarNumerosDe.setBounds(10, 294, 231, 23);
		contentPane.add(btnComprobarNumerosDe);
		
		txtCantidadEspectros = new JTextField();
		txtCantidadEspectros.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadEspectros.setEditable(false);
		txtCantidadEspectros.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCantidadEspectros.setColumns(10);
		txtCantidadEspectros.setBounds(258, 295, 59, 20);
		contentPane.add(txtCantidadEspectros);
		
		JLabel lblNumerosDeDatos = new JLabel("Numeros de datos por espectro");
		lblNumerosDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumerosDeDatos.setBounds(342, 136, 218, 20);
		contentPane.add(lblNumerosDeDatos);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el numero de datos tomados por cada espectro:");
		lblIngreseElNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseElNumero.setBounds(342, 177, 319, 19);
		contentPane.add(lblIngreseElNumero);
		
		txtCantidadDatos = new JTextField();
		txtCantidadDatos.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidadDatos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCantidadDatos.setColumns(10);
		txtCantidadDatos.setBounds(665, 177, 59, 20);
		contentPane.add(txtCantidadDatos);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SegundaVentana1D.this.dispose();
				primerVentana.setVisible(true);
			}
		});
		btnAtras.setBounds(536, 294, 89, 23);
		contentPane.add(btnAtras);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
										
					extremoInferior1 = Integer.parseInt(txtInferior.getText());
				    extremoSuperior1 = Integer.parseInt(txtSuperior.getText());
				    paso1 = Integer.parseInt(txtPaso.getText());
				    intervalo1 = extremoSuperior1 - extremoInferior1;
			    	cantidadEspectros = (intervalo1 / paso1) + 1;
			    	
					aplicacion.abrirArchivo(archivo);
					aplicacion.abrirArchivoDos(archivoFinal);
					aplicacion.leerDato(cantidadEspectros, Integer.parseInt(txtCantidadDatos.getText()));
					aplicacion.cerrarArchivo();
					aplicacion.cerrarArchivoDos();
					
					SegundaVentana1D.this.dispose();
					
					ultimaVentana.setVisible(true);
					
				}
				catch(NumberFormatException numberFormatException) {
					lblError.setText("Hay algun error con algun numero");
				}
			}
		});
		btnFinalizar.setEnabled(false);
		btnFinalizar.setBounds(635, 294, 89, 23);
		contentPane.add(btnFinalizar);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblError.setBounds(400, 230, 271, 20);
		contentPane.add(lblError);
	}

}
