package raman;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooserGuardar {
public File obtenerArchivo(JPanel jpanel){
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(jpanel);
		fileChooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
		File archivo = fileChooser.getSelectedFile();
		return archivo;
	}
}