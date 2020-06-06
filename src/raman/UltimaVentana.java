package raman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class UltimaVentana extends JFrame {

	private JPanel contentPane;
	private PrimerVentana primerVentana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UltimaVentana frame = new UltimaVentana();
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
	public UltimaVentana() {
		
		primerVentana = new PrimerVentana();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblElMapeoRaman = new JLabel("El mapeo raman se corto exitosamente!!!");
		lblElMapeoRaman.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblElMapeoRaman.setBounds(10, 11, 307, 20);
		contentPane.add(lblElMapeoRaman);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(209, 61, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnCortarOtroArchivo = new JButton("Cortar otro archivo");
		btnCortarOtroArchivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UltimaVentana.this.dispose();
				primerVentana.setVisible(true);
			}
		});
		btnCortarOtroArchivo.setBounds(48, 61, 151, 23);
		contentPane.add(btnCortarOtroArchivo);
	}
}
