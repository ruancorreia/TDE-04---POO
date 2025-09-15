package viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.departamento.CtrlAbstratoDepartamento;
import controller.departamento.CtrlExcluirDepartamento;
import model.Departamento;

public class JanelaDepartamento extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfSigla;
	private JTextField tfNome;

	/**
	 * Sobrecarga (Overload) de construtores na classe, pois
	 * terá dois construtores
	 */
	public JanelaDepartamento(CtrlAbstrato ctrl, Departamento depto) {
		//
		// Chamada ao construtor DESTA CLASSE que recebe somente 
		// um parâmetro. Para isso usamos a INSTRUÇÃO this(...)
		//
		this(ctrl);
		
		//
		// Se a operação é de "Alteração" ou "Exclusão", vou preencher
		// os campos do formulário para o usuário ver os dados do objeto 
		// a ser alterado/excluído
		//
		if (depto != null) {
			tfSigla.setText(depto.getSigla());
			tfNome.setText(depto.getNome());
		}
		
		// Se a operação é de Exclusão, vou inabilitar os textfields
		if(ctrl instanceof CtrlExcluirDepartamento) {
			tfSigla.setEnabled(false);
			tfNome.setEnabled(false);
			
			JLabel lbMsg = new JLabel("Deseja excluir esse Departamento?");
			lbMsg.setForeground(new Color(255, 0, 0));
			lbMsg.setFont(new Font("Calibri", Font.PLAIN, 14));
			lbMsg.setBounds(139, 150, 187, 14);
			contentPane.add(lbMsg);
		}
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public JanelaDepartamento(CtrlAbstrato ctrl) {
		super(ctrl);
		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sigla:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 40, 46, 14);
		contentPane.add(lblNewLabel);

		tfSigla = new JTextField();
		tfSigla.setBounds(89, 35, 111, 20);
		contentPane.add(tfSigla);
		tfSigla.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 80, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfNome = new JTextField();
		tfNome.setBounds(89, 75, 311, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mando para 'tfSigla' a mensagem 'getText()'
				// Que retorna o conteúdo digitado dentro do textfield
				String sigla =  tfSigla.getText();
				// Mando para 'tfNome' a mensagem 'getText()'
				// Que retorna o conteúdo digitado dentro do textfield
				String nome = tfNome.getText();
				//
				// Após ter recuperado o que o usuário definiu, vamos
				// acionar o controlador de caso de uso associado à janela
				//
				CtrlAbstratoDepartamento ctrl = (CtrlAbstratoDepartamento) getCtrl();
				ctrl.efetuar(sigla, nome);
			}
		});
		btOk.setBounds(103, 167, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getCtrl().encerrar();
			}
		});
		btCancelar.setBounds(237, 167, 89, 23);
		contentPane.add(btCancelar);
	}
}
