package gusto.fatec.abrirprocessos.controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.getProperty;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.FILES_ONLY;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class ProcessosController {

	private static final Logger LOGGER = Logger.getLogger(ProcessosController.class.getName());

	public void procurar(JTextField textField) {
		String[] exec = {"exe", "sh"};
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executaveis", exec);
		String dir = getProperty("user.home");
		File exe = new File(dir);

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(exe);
		chooser.setFileSelectionMode(FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(filter);

		int retorno = chooser.showOpenDialog(null);

		if (retorno == APPROVE_OPTION) {
			String path = chooser.getSelectedFile().getAbsolutePath();
			textField.setText(path);
		}
	}

	public void executar(String path, JFrame tela) {
		try {
			if (path.contains(".exe") || path.contains(".sh")) {
				getRuntime().exec(path);
			} else {
				showMessageDialog(null,
						"Caminho ou arquivo inválidos",
						"Erro",
						ERROR_MESSAGE);
			}
			sair(tela);
		} catch (IOException e) {
			String erro = e.getMessage();
			LOGGER.warning(erro);
		}
	}

	public void sair(JFrame tela) {
		tela.dispose();
	}
}
