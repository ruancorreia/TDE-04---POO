package model.dao;

import java.util.ArrayList;

import model.Empregado;

public class DaoEmpregado {
	
	private static ArrayList<Empregado> listaEmpregados;
	
	static {
		// TODO falar sobre carga de bytecodes e bloco static
		DaoEmpregado.listaEmpregados = new ArrayList<Empregado>();
	}
	
	// TODO explicar por que não criamos um construtor
	
	public boolean adicionar(Empregado novo) {
		return DaoEmpregado.listaEmpregados.add(novo);
	}

	public ArrayList<Empregado> obterTodos() {
		return new ArrayList(DaoEmpregado.listaEmpregados);
	}
}
