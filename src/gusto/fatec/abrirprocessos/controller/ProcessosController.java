package gusto.fatec.abrirprocessos.controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProcessosController {
	public void procurar(JTextField textField) {
		String[] exec = {"exe", "sh"};
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executaveis", exec);
		String dir = System.getProperty("user.home");
		File exe = new File(dir);
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(exe);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(filter);
		String path = "";
		int retorno = chooser.showOpenDialog(null);
		if (retorno == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			textField.setText(path);
		}
	}

	public void executar(String path, JFrame tela) {
		try {
			if (path.contains(".exe") || path.contains(".sh")) {
				Runtime.getRuntime().exec(path);
			} else {
				JOptionPane.showMessageDialog(null, "Caminho ou arquivo inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			Sair(tela);
		} catch (IOException e) {
			String erro = e.getMessage();
			System.out.println(erro);
		}
	}

	public void Sair(JFrame tela) {
		tela.dispose();
	}
}
