package gusto.fatec.abrirprocessos;

import gusto.fatec.abrirprocessos.view.Tela;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível usar a biblioteca padrão do seu SO.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );
        } finally {
            new Tela();
        }

    }
}
