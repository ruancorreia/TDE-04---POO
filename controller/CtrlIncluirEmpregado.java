package controller.empregado;

import controller.CtrlAbstrato;
import model.Departamento;
import model.Empregado;
import model.ModelException;
import model.dao.DaoEmpregado;

public class CtrlIncluirEmpregado extends CtrlAbstratoEmpregado {

	public CtrlIncluirEmpregado(CtrlAbstrato c) {
		super(c);
	}

	@Override
	public void efetuar(String cpf, String nome, Departamento depto) {
		try {
			this.emp = new Empregado(cpf, nome, depto);
			DaoEmpregado dao = new DaoEmpregado();
			dao.adicionar(this.emp);
			this.janela.notificar("Empregado Criado!");
			this.encerrar();
		} catch (ModelException e1) {
			this.janela.notificar(e1.getMessage());
		}
	}
}