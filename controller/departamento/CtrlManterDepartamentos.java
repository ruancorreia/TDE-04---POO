package controller.departamento;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import model.Departamento;
import model.dao.DaoDepartamento;
import viewer.JanelaConsultarDepartamentos;

public class CtrlManterDepartamentos extends CtrlAbstrato {

	//
	// ATRIBUTOS
	//
	private JanelaConsultarDepartamentos janela;
	private CtrlAbstratoDepartamento     ctrlDepartamento;

	//
	// MÉTODOS
	//
	public CtrlManterDepartamentos(CtrlAbstrato ctrlPai) {
		// Chamando o construtor de CtrlAbstrato para determinar
		// quem é o controlador que está solicitando a execução
		// do caso de uso "Consultar Departamentos"
		super(ctrlPai);
		// Instanciando um DaoDepartamento
		DaoDepartamento dao = new DaoDepartamento();
		// Recuperando os objetos Departamento existentes
		Departamento[] conjDepartamentos = dao.obterTodos();
		// Instancio a JanelaConsultarDepartamentos, passando a lista inicial de Departamentos
		this.janela = new JanelaConsultarDepartamentos(this, conjDepartamentos);
		// Torno a janela visível
		this.janela.setVisible(true);
	}

	/* *********************************************************** */

	/**
	 * Iniciando a execução do caso de uso 'Incluir Departamento' a partir deste caso de
	 * uso de consulta de Departamentos
	 */
	public void iniciarIncluirDepartamento() {
		// Iniciando a execução do caso de uso 'Incluir Departamento' a partir
		// da instanciação do objeto CtrlIncluirDepartamento. Observe que vamos
		// guardar como atributo desta classe a referência para o controlador
		// do caso de uso 'Incluir Departamento'
		this.ctrlDepartamento = new CtrlIncluirDepartamento(this);
	}

	/* *********************************************************** */

	/**
	 * Iniciando a execução do caso de uso 'Alterar Departamento' a partir deste caso de
	 * uso de consulta de Departamentos
	 */
	public void iniciarAlterarDepartamento(Departamento departamentoSelecionado) {
		if (departamentoSelecionado == null)
			this.janela.notificar("Selecione um departamento para alteração");
		else
			// Iniciando a execução do caso de uso 'Alterar Departamento' a partir
			// da instanciação do objeto CtrlAlterarDepartamento. Observe que vamos
			// guardar como atributo desta classe a referência para o controlador
			// do caso de uso 'Alterar Departamento'
			this.ctrlDepartamento = new CtrlAlterarDepartamento(this, departamentoSelecionado);
	}

	/* *********************************************************** */

	/**
	 * Iniciando a execução do caso de uso 'Excluir Departamento' a partir deste caso de
	 * uso de consulta de Departamentos
	 */
	public void iniciarExcluirDepartamento(Departamento departamentoSelecionado) {
		if (departamentoSelecionado == null)
			this.janela.notificar("Selecione um departamento para exclusão");
		else
			// Iniciando a execução do caso de uso 'Excluir Departamento' a partir
			// da instanciação do objeto CtrlExcluirDepartamento. Observe que vamos
			// guardar como atributo desta classe a referência para o controlador
			// do caso de uso 'Excluir Departamento'
			this.ctrlDepartamento = new CtrlExcluirDepartamento(this, departamentoSelecionado);
	}

	/**
	 * Método que será executado quando o caso de uso 'Excluir Departamento' for finalizado
	 */
	public void fimEditarDepartamento() {
		this.ctrlDepartamento = null;
		// Instanciando um DaoDepartamento
		DaoDepartamento dao = new DaoDepartamento();
		// Recuperando os objetos Departamentos existentes
		Departamento[] conjDepartamentos = dao.obterTodos();
		// Informo à janela quais são os objetos para exibição
		this.janela.atualizarDados(conjDepartamentos);
	}

	@Override
	public void encerrar() {
		this.janela.fechar();
		CtrlPrograma ctrl = (CtrlPrograma) getCtrlPai();
		ctrl.manterDepartamentosFinalizado();
	}

	@Override
	public Object getBemTangivel() {
		DaoDepartamento dao = new DaoDepartamento();
		// Recuperando os objetos Departamento existentes
		return dao.obterTodos();
	}

}
