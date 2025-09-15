package controller.departamento;

import controller.CtrlAbstrato;
import model.Departamento;
import model.ModelException;
import model.dao.DaoDepartamento;

public class CtrlExcluirDepartamento extends CtrlAbstratoDepartamento {
	//
	// MÉTODOS
	//
	public CtrlExcluirDepartamento(CtrlAbstrato c, Departamento depto) {
		super(c, depto);
	}

	public void efetuar(String sigla, String nome) {
		DaoDepartamento dao = new DaoDepartamento();
		dao.excluir(this.depto);
		this.janela.notificar("Departamento Excluído!");
		this.encerrar();
	}
}
