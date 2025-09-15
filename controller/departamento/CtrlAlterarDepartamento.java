package controller.departamento;

import controller.CtrlAbstrato;
import model.Departamento;
import model.ModelException;
import model.dao.DaoDepartamento;

public class CtrlAlterarDepartamento extends CtrlAbstratoDepartamento {
	//
	// MÉTODOS
	//
	public CtrlAlterarDepartamento(CtrlAbstrato c, Departamento depto) {
		super(c, depto);
	}
	
	public void efetuar(String sigla, String nome) {
		try {
			this.depto.setSigla(sigla);
			this.depto.setNome(nome);
			DaoDepartamento dao = new DaoDepartamento();
			dao.alterar(this.depto);
			this.janela.notificar("Departamento Alterado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
}
