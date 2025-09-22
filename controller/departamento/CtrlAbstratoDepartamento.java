package controller.departamento;

import controller.CtrlAbstrato;
import model.Departamento;
import viewer.JanelaDepartamento;

public abstract class CtrlAbstratoDepartamento extends CtrlAbstrato {
    protected JanelaDepartamento janela;
    protected Departamento depto;

    public CtrlAbstratoDepartamento(CtrlAbstrato ctrlPai, Departamento depto) {
        super(ctrlPai);
        this.depto = depto;
        this.janela = new JanelaDepartamento(this, depto);
        this.janela.apresentar();
    }

    public CtrlAbstratoDepartamento(CtrlAbstrato ctrlPai) {
        this(ctrlPai, null);
    }

    public abstract void efetuar(String sigla, String nome);

    @Override
    public void encerrar() {
        this.janela.fechar();
        if (this.getCtrlPai() instanceof CtrlManterDepartamentos) {
            CtrlManterDepartamentos c = (CtrlManterDepartamentos) this.getCtrlPai();
            c.fimEditarDepartamento();
        }
    }

    @Override
    public Object getBemTangivel() {
        return this.depto;
    }
}
