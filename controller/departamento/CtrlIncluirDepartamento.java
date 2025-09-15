package controller.departamento;

import controller.CtrlAbstrato;
import model.Departamento;
import model.ModelException;
import model.dao.DaoDepartamento;

public class CtrlIncluirDepartamento extends CtrlAbstratoDepartamento {
	//
	// MÉTODOS
	//
	public CtrlIncluirDepartamento(CtrlAbstrato c) {
		super(c);
	}
	
	public void efetuar(String sigla, String nome) {
		try {
			this.depto = new Departamento(sigla,nome);
			DaoDepartamento dao = new DaoDepartamento();
			dao.adicionar(this.depto);
			this.janela.notificar("Departamento Criado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
}
