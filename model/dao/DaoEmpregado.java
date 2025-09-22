package model.dao;

import java.util.ArrayList;

import model.Empregado;

public class DaoEmpregado {
	
	private static ArrayList<Empregado> listaEmpregados;
	
	static {
		
		DaoEmpregado.listaEmpregados = new ArrayList<Empregado>();
	}
	
	
	
	public boolean adicionar(Empregado novo) {
		return DaoEmpregado.listaEmpregados.add(novo);
	}

	public ArrayList<Empregado> obterTodos() {
		return new ArrayList(DaoEmpregado.listaEmpregados);
	}
}

