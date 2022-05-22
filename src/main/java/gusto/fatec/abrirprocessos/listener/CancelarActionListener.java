package gusto.fatec.abrirprocessos.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CancelarActionListener implements ActionListener {

    private final JFrame jFrame;

    public CancelarActionListener(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.jFrame.dispose();
    }

}
