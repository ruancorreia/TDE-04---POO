package controller;

import controller.departamento.CtrlManterDepartamentos;
import controller.empregado.CtrlManterEmpregados;
import controller.projeto.CtrlManterProjetos;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
    private JanelaPrincipal janelaPrincipal;
    private CtrlManterDepartamentos ctrlManterDepartamentos;
    private CtrlManterEmpregados ctrlManterEmpregados;
    private CtrlManterProjetos ctrlManterProjetos;

    public CtrlPrograma() {
        super(null);
        this.janelaPrincipal = new JanelaPrincipal(this);
        this.janelaPrincipal.apresentar();
    }

    public void iniciarManterDepartamentos() {
        if (this.ctrlManterDepartamentos == null) {
            this.ctrlManterDepartamentos = new CtrlManterDepartamentos(this);
        } else {
            this.janelaPrincipal.notificar("O caso de uso 'Manter Departamentos' já está em execução!");
        }
    }

    public void manterDepartamentosFinalizado() {
        this.ctrlManterDepartamentos = null;
    }

    public void iniciarManterEmpregados() {
        if (this.ctrlManterEmpregados == null) {
            this.ctrlManterEmpregados = new CtrlManterEmpregados(this);
        } else {
            this.janelaPrincipal.notificar("O caso de uso 'Manter Empregados' já está em execução!");
        }
    }

    public void manterEmpregadosFinalizado() {
        this.ctrlManterEmpregados = null;
    }

    public void iniciarManterProjetos() {
        if (this.ctrlManterProjetos == null) {
            this.ctrlManterProjetos = new CtrlManterProjetos(this);
        } else {
            this.janelaPrincipal.notificar("O caso de uso 'Manter Projetos' já está em execução!");
        }
    }

    public void manterProjetosFinalizado() {
        this.ctrlManterProjetos = null;
    }

    @Override
    public void encerrar() {
        System.exit(0);
    }

    @Override
    public Object getBemTangivel() {
        return null;
    }

    public static void main(String[] args) {
        new CtrlPrograma();
    }
}
