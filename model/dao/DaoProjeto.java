package model.dao;

import model.Projeto;
import java.util.ArrayList;
import java.util.List;

public class DaoProjeto {
    private static final List<Projeto> repositorio = new ArrayList<>();

    public void adicionar(Projeto projeto) {
        repositorio.add(projeto);
    }

    public void excluir(Projeto projeto) {
        repositorio.remove(projeto);
    }

    public void alterar(Projeto projeto) {
    
    }

    public Projeto[] obterTodos() {
        return repositorio.toArray(new Projeto[0]);
    }
}
