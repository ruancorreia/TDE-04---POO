package controller.departamento;

import controller.CtrlAbstrato;
import controller.CtrlIncluirEmpregado;
import model.Departamento;
import viewer.JanelaDepartamento;

abstract public class CtrlAbstratoDepartamento extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	protected JanelaDepartamento janela;
	protected Departamento depto;

	//
	// MÉTODOS
	//

	/**
	 * Quando instanciarmos um objeto CtrlAbstratoDepartamento, nós desejamos
	 * iniciar a execução do caso de uso 'Incluir' OU 'Alterar' OU 'Excluir'
	 * Departamento
	 */
	public CtrlAbstratoDepartamento(CtrlAbstrato ctrlPai, Departamento depto) {
		super(ctrlPai);
		// Guardando o objeto a ser alterado
		this.depto = depto;
		// Instanciando o viewer associado ao caso de uso
		this.janela = new JanelaDepartamento(this, depto);
		this.janela.apresentar();
	}

	/**
	 * Sobrecarga do construtor para o caso da Inclusão
	 * 
	 * @param ctrlPai
	 */
	public CtrlAbstratoDepartamento(CtrlAbstrato ctrlPai) {
		// Guardando que é o controlador pai do CtrlAlterarDepartamento; ou seja,
		// estamos guardando quem solicitou a execução deste caso de uso
		this(ctrlPai, null);
	}

	/**
	 * Método promove a efetivação da ação do controlador
	 */
	abstract public void efetuar(String sigla, String nome);

	/**
	 * Método que indica o encerramento do caso de uso
	 */
	public void encerrar() {
		// Fechando a janela de alteração de Departamento
		this.janela.fechar();

		// Recuperando o controlador pai de 'Alterar Departamento'
		this.janela.fechar();
		if (this.getCtrlPai() instanceof CtrlManterDepartamentos) {
			CtrlManterDepartamentos c = (CtrlManterDepartamentos) this.getCtrlPai();
			c.fimEditarDepartamento();
		} else if (this.getCtrlPai() instanceof CtrlIncluirEmpregado) {
			CtrlIncluirEmpregado c = (CtrlIncluirEmpregado) this.getCtrlPai();
			c.incluirDepartamentoFinalizado();
		}
	}

	/**
	 * Retorna o bem tangível produzido pelo caso de uso
	 */
	public Object getBemTangivel() {
		return this.depto;
	}

}
