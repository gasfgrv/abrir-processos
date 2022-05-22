package gusto.fatec.abrirprocessos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JFileChooser.FILES_ONLY;

public class ProcurarActionListener implements ActionListener {

    private final JTextField textField;

    public ProcurarActionListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Executaveis", "exe", "sh");

        File diretorioInicial = new File(System.getProperty("user.home"));

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(diretorioInicial);
        chooser.setFileSelectionMode(FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(filter);

        int retorno = chooser.showOpenDialog(null);

        if (retorno == APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            textField.setText(path);
        }
    }

}
