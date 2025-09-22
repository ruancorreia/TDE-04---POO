package controller;

public abstract class CtrlAbstrato {
    private final CtrlAbstrato ctrlPai;

    public CtrlAbstrato(CtrlAbstrato pai) {
        this.ctrlPai = pai;
    }

    public CtrlAbstrato getCtrlPai() {
        return this.ctrlPai;
    }

    public abstract void encerrar();

    public abstract Object getBemTangivel();
}
