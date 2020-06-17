package gusto.fatec.abrirprocessos.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gusto.fatec.abrirprocessos.controller.ProcessosController;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		ProcessosController pc = new ProcessosController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 164);
		contentPane = new JPanel();
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
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc.executar(textField.getText(), Tela.this);
			}
		});
		btnOk.setBounds(105, 76, 97, 25);
		contentPane.add(btnOk);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc.Sair(Tela.this);
			}
		});
		btnCancelar.setBounds(214, 76, 97, 25);
		contentPane.add(btnCancelar);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pc.procurar(textField);
			}
		});
		btnProcurar.setBounds(323, 76, 97, 25);
		contentPane.add(btnProcurar);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(85, 41, 335, 22);
		contentPane.add(textField);
	}

}
