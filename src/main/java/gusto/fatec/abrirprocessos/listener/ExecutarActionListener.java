package gusto.fatec.abrirprocessos.listener;

import gusto.fatec.abrirprocessos.exception.FileExecutionExcetion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class ExecutarActionListener implements ActionListener {

    private static final Logger LOGGER = Logger.getLogger(ExecutarActionListener.class.getName());
    private final JFrame frame;
    private final JTextField textField;

    public ExecutarActionListener(JFrame frame, JTextField textField) {
        this.frame = frame;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        var caminho = textField.getText().trim();

        try {
            executarProcesso(caminho);
        } catch (IOException e) {
            throw new FileExecutionExcetion(e);
        }
    }

    private void executarProcesso(String caminho) throws IOException {
        if (!caminho.endsWith(".exe") && !caminho.endsWith(".sh")) {
            JOptionPane.showMessageDialog(null, "Caminho ou arquivo inválido", "Erro", ERROR_MESSAGE);
        }

        var exec = Runtime.getRuntime().exec(caminho);
        logarSaida(exec);
        frame.dispose();
    }

    private void logarSaida(Process exec) {
        try {
            var inputStreamReader = new InputStreamReader(exec.getInputStream());
            var bufferedReader = new BufferedReader(inputStreamReader);
            var saida = montarSaida(bufferedReader).toString();

            if (exec.waitFor() == 0) {
                LOGGER.info(saida);
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private StringBuilder montarSaida(BufferedReader bufferedReader) throws IOException {
        var linha = bufferedReader.readLine();
        var saida = new StringBuilder();

        while (linha != null) {
            saida.append(linha).append("\n");
            linha = bufferedReader.readLine();
        }

        return saida;
    }
}
