package controller.empregado;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import model.Empregado;
import model.dao.DaoEmpregado;
import viewer.JanelaConsultarEmpregados;

public class CtrlManterEmpregados extends CtrlAbstrato {
    private JanelaConsultarEmpregados janela;
    private CtrlAbstratoEmpregado ctrlEmpregado;

    public CtrlManterEmpregados(CtrlAbstrato ctrlPai) {
        super(ctrlPai);
        DaoEmpregado dao = new DaoEmpregado();
        Empregado[] conjEmpregados = dao.obterTodos();
        this.janela = new JanelaConsultarEmpregados(this, conjEmpregados);
        this.janela.setVisible(true);
    }

    public void iniciarIncluirEmpregado() {
        this.ctrlEmpregado = new CtrlIncluirEmpregado(this);
    }

    public void iniciarAlterarEmpregado(Empregado empregadoSelecionado) {
        if (empregadoSelecionado == null) {
            this.janela.notificar("Selecione um empregado para alteração");
        } else {
            this.ctrlEmpregado = new CtrlAlterarEmpregado(this, empregadoSelecionado);
        }
    }

    public void iniciarExcluirEmpregado(Empregado empregadoSelecionado) {
        if (empregadoSelecionado == null) {
            this.janela.notificar("Selecione um empregado para exclusão");
        } else {
            this.ctrlEmpregado = new CtrlExcluirEmpregado(this, empregadoSelecionado);
        }
    }

    public void fimEditarEmpregado() {
        this.ctrlEmpregado = null;
        DaoEmpregado dao = new DaoEmpregado();
        Empregado[] conjEmpregados = dao.obterTodos();
        this.janela.atualizarDados(conjEmpregados);
    }

    @Override
    public void encerrar() {
        this.janela.fechar();
        CtrlPrograma ctrl = (CtrlPrograma) getCtrlPai();
        ctrl.manterEmpregadosFinalizado();
    }

    @Override
    public Object getBemTangivel() {
        DaoEmpregado dao = new DaoEmpregado();
        return dao.obterTodos();
    }
}
