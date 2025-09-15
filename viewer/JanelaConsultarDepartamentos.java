package viewer; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.departamento.CtrlManterDepartamentos;
import model.Departamento;

public class JanelaConsultarDepartamentos extends JanelaAbstrata<CtrlManterDepartamentos> {
	//
	// ATRIBUTOS
	//
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private Departamento[] conjDeptos;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarDepartamentos(CtrlManterDepartamentos ctrl, Departamento[] conjDeptos) {
		super(ctrl);
		setTitle("Departamentos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrar();
			}
		});
		btSair.setBounds(335, 227, 89, 23);
		contentPane.add(btSair);

		// A chamada a 'atualizarDados' precisa vir antes
		// da criação do JScrollPane
		this.atualizarDados(conjDeptos);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);

		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notifico ao controlador que o usuário quer iniciar 
				// o caso de uso Incluir Departamento
				ctrl.iniciarIncluirDepartamento();
			}
		});
		btIncluir.setBounds(10, 227, 89, 23);
		contentPane.add(btIncluir);

		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificando se o usuário selecionou alguma agência
				Departamento d = obterLinhaSelecionada();
				// Se o usuário selecionou algum departamento
				if (d != null) 
					ctrl.iniciarExcluirDepartamento(d);
				else
					notificar("Selecione um departamento para exclusão");
			}
		});
		btExcluir.setBounds(121, 227, 89, 23);
		contentPane.add(btExcluir);

		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificando se o usuário selecionou algum departamento
				Departamento d = obterLinhaSelecionada();
				// Se o usuário selecionou algum departamento
				if (d != null) 
					ctrl.iniciarAlterarDepartamento(d);
				else
					notificar("Selecione um departamento para alteração");
			}
		});
		btAlterar.setBounds(231, 227, 89, 23);
		contentPane.add(btAlterar);

		this.setVisible(true);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Departamento[] conjDeptos) {
		this.conjDeptos = conjDeptos;
		HelperTableModel h = new HelperTableModel(this.conjDeptos);
		if (this.tabela == null)
			this.tabela = new JTable(h.getTableModel());
		else
			this.tabela.setModel(h.getTableModel());
		new MeuHeaderListener(this.tabela);
	}

	/**
	 * Retorna qual objeto
	 * 
	 * @return
	 */
	public Departamento obterLinhaSelecionada() {
		int numLinhaSelecionada = this.tabela.getSelectedRow();
		if (numLinhaSelecionada != -1)
			return this.conjDeptos[numLinhaSelecionada];
		return null;
	}
}