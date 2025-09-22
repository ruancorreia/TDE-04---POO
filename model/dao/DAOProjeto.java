package model;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private String descricao;
    private final List<Empregado> participantes;

    public Projeto(String nome, String descricao) throws ModelException {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ModelException("O nome do projeto não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Empregado> getParticipantes() {
        return new ArrayList<>(participantes); 
    }

    public void adicionarParticipante(Empregado emp) {
        if (!this.participantes.contains(emp)) {
            this.participantes.add(emp);
            emp.adicionarProjeto(this); 
        }
    }

    public void removerParticipante(Empregado emp) {
        if (this.participantes.contains(emp)) {
            this.participantes.remove(emp);
            emp.removerProjeto(this); 
        }
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
