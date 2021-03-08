package gusto.fatec.abrirprocessos.view;

import gusto.fatec.abrirprocessos.controller.ProcessosController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public void start() {
		EventQueue.invokeLater(() -> {
			try {
				Tela frame = new Tela();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Tela() {
		ProcessosController pc = new ProcessosController();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\gustavo\\Desktop\\avatar379238.gif"));
		lblNewLabel.setBounds(12, 13, 50, 50);
		contentPane.add(lblNewLabel);

		JLabel lblDigite = new JLabel("Digite o caminho do executável ou clique em procurar");
		lblDigite.setHorizontalAlignment(SwingConstants.CENTER);
		lblDigite.setBounds(85, 13, 335, 16);
		contentPane.add(lblDigite);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(e -> pc.executar(textField.getText(), Tela.this));
		btnOk.setBounds(105, 76, 97, 25);
		contentPane.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> pc.sair(Tela.this));
		btnCancelar.setBounds(214, 76, 97, 25);
		contentPane.add(btnCancelar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(e -> pc.procurar(textField));
		btnProcurar.setBounds(323, 76, 97, 25);
		contentPane.add(btnProcurar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 41, 335, 22);
		contentPane.add(textField);
	}

}
