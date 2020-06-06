package raman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PrimerVentana extends JFrame {

	private JPanel contentPane;
	private ButtonGroup opciones;
	private int ventanaSiguiente;
	private JButton btnSiguiente;
	private SegundaVentana1D segundaVentana1;
	private SegundaVentana2D segundaVentana2;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimerVentana frame = new PrimerVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PrimerVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaElTipo = new JLabel("Selecciona el tipo de mapa que tomaste:");
		lblSeleccionaElTipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSeleccionaElTipo.setBounds(10, 11, 338, 25);
		contentPane.add(lblSeleccionaElTipo);
		
		JRadioButton btnUnaDimension = new JRadioButton("En una dimension");
		btnUnaDimension.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ventanaSiguiente = 1;
				btnSiguiente.setEnabled(true);
				segundaVentana1 = new SegundaVentana1D();
			}
		});
		btnUnaDimension.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUnaDimension.setBounds(77, 60, 155, 23);
		contentPane.add(btnUnaDimension);
		
		JRadioButton btnDosDimensiones = new JRadioButton("En dos dimensiones");
		btnDosDimensiones.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ventanaSiguiente = 2;
				btnSiguiente.setEnabled(true);
				segundaVentana2 = new SegundaVentana2D();
			}
		});
		btnDosDimensiones.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDosDimensiones.setBounds(77, 98, 178, 23);
		contentPane.add(btnDosDimensiones);
		
		opciones = new ButtonGroup();
		opciones.add(btnUnaDimension);
		opciones.add(btnDosDimensiones);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(ventanaSiguiente == 1){
					PrimerVentana.this.dispose();
					segundaVentana1.setVisible(true);
					
				} else {
					PrimerVentana.this.dispose();
					segundaVentana2.setVisible(true);
				}
			}
		});
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(239, 143, 89, 23);
		contentPane.add(btnSiguiente);
	}
}
