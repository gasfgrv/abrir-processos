package gusto.fatec.abrirprocessos.view;

import gusto.fatec.abrirprocessos.listener.CancelarActionListener;
import gusto.fatec.abrirprocessos.listener.ExecutarActionListener;
import gusto.fatec.abrirprocessos.listener.ProcurarActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {

    private static final long serialVersionUID = 1L;

    public Tela() {
        this.setContentPane(montarTela());
        this.setTitle("Abrir Processos");
        this.setSize(700, 125);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel montarTela() {
        var contentPane = new JPanel();

        var border = new EmptyBorder(5, 5, 5, 5);
        contentPane.setBorder(border);

        var layout = new BorderLayout(5, 5);
        contentPane.setLayout(layout);

        var panelNorte = montarPanelNorte();
        contentPane.add(panelNorte, BorderLayout.NORTH);

        var panelSul = montarPanelSul((JTextField) panelNorte.getComponent(1));
        contentPane.add(panelSul, BorderLayout.SOUTH);

        return contentPane;
    }

    private JPanel montarPanelSul(JTextField textField) {
        var panelSul = new JPanel();

        var gridLayout = new GridLayout(1, 3, 5, 0);
        panelSul.setLayout(gridLayout);

        var btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ExecutarActionListener(this, textField));
        btnExecutar.setBounds(105, 76, 97, 25);
        panelSul.add(btnExecutar);

        var btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CancelarActionListener(this));
        btnCancelar.setBounds(214, 76, 97, 25);
        panelSul.add(btnCancelar);

        var btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ProcurarActionListener(textField));
        btnProcurar.setBounds(323, 76, 97, 25);
        panelSul.add(btnProcurar);

        return panelSul;
    }

    private JPanel montarPanelNorte() {
        var panelNorte = new JPanel();

        var flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
        panelNorte.setLayout(flowLayout);

        var lblDigite = new JLabel("Digite o caminho do executável ou clique em procurar");
        lblDigite.setHorizontalAlignment(SwingConstants.CENTER);
        panelNorte.add(lblDigite);

        var textField = new JTextField();
        textField.setColumns(30);
        panelNorte.add(textField);

        return panelNorte;
    }

}
