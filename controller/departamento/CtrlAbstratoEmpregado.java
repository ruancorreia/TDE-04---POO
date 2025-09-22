package controller.empregado;

import controller.CtrlAbstrato;
import model.Departamento;
import model.Empregado;
import model.dao.DaoDepartamento;
import viewer.JanelaEmpregado;

public abstract class CtrlAbstratoEmpregado extends CtrlAbstrato {
    protected JanelaEmpregado janela;
    protected Empregado emp;

    public CtrlAbstratoEmpregado(CtrlAbstrato ctrlPai, Empregado emp) {
        super(ctrlPai);
        this.emp = emp;
        this.janela = new JanelaEmpregado(this, emp);
        DaoDepartamento dao = new DaoDepartamento();
        this.janela.atualizarDepartamentos(dao.obterTodos());
        this.janela.apresentar();
    }

    public CtrlAbstratoEmpregado(CtrlAbstrato ctrlPai) {
        this(ctrlPai, null);
    }

    public abstract void efetuar(String cpf, String nome, Departamento depto);

    @Override
    public void encerrar() {
        this.janela.fechar();
        if (this.getCtrlPai() instanceof CtrlManterEmpregados) {
            CtrlManterEmpregados c = (CtrlManterEmpregados) this.getCtrlPai();
            c.fimEditarEmpregado();
        }
    }

    @Override
    public Object getBemTangivel() {
        return this.emp;
    }
}
