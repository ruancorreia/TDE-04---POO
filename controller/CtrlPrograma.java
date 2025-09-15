package controller;

import controller.departamento.CtrlManterDepartamentos;
import viewer.JanelaPrincipal;

/**
 * Este é o controlador 
 */
public class CtrlPrograma extends CtrlAbstrato {
	//
	// ATRIBUTOS
	//
	
	// Referência para o viewer associado ao CtrlPrograma
	private JanelaPrincipal          janelaPrincipal;
	// Referências para os Casos de Uso que o CtrlPrograma pode demandar
	// sua execução.
	private CtrlManterDepartamentos  ctrlManterDepartamentos; 
	private CtrlIncluirEmpregado     ctrlIncluirEmpregado; 
	
	//
	// MÉTODOS
	//
	public CtrlPrograma() {
		// Chamando o construtor da superclasse CtrlAbstrato
		// Como o CtrlPrograma não é demandado por ninguém,
		// é o único controlador que não tem "pai", daí o 
		// parâmetro ser 'null'
		super(null);
		// Solicita a apresentação do viewer
		this.janelaPrincipal = new JanelaPrincipal(this);
		this.janelaPrincipal.apresentar();
	}
	
	/**
	 * Iniciando o caso de uso Manter Departamentos
	 */
	public void iniciarManterDepartamentos() {
		if(this.ctrlManterDepartamentos == null)
			this.ctrlManterDepartamentos = new CtrlManterDepartamentos(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}

	/**
	 * Encerrando o caso de uso Manter Departamentos
	 */
	public void manterDepartamentosFinalizado() {
		this.ctrlManterDepartamentos = null;		
	}

	/**
	 * Iniciando o caso de uso Incluir Empregado
	 */
	public void iniciarIncluirEmpregado() {
		if(this.ctrlIncluirEmpregado == null)
			this.ctrlIncluirEmpregado = new CtrlIncluirEmpregado(this);
		else
			this.janelaPrincipal.notificar("Este Caso de Uso já está em execução!");
	}

	/**
	 * Encerrando o caso de uso Incluir Empregado
	 */
	public void incluirEmpregadoFinalizado() {
		this.ctrlIncluirEmpregado = null;		
	}

	/**
	 * Encerrando o programa
	 */
	public void encerrar() {
		System.exit(0);
	}

	public Object getBemTangivel() {
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		new CtrlPrograma();
	}
}
