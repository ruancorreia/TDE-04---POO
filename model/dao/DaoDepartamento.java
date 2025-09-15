package model.dao;

import java.util.ArrayList;

import model.Departamento;

public class DaoDepartamento {
	
	private static ArrayList<Departamento> listaDepartamentos;
	
	static {
		// TODO falar sobre carga de bytecodes e bloco static
		DaoDepartamento.listaDepartamentos = new ArrayList<Departamento>();
	}
	
	public boolean adicionar(Departamento novo) {
		return DaoDepartamento.listaDepartamentos.add(novo);
	}

	public boolean alterar(Departamento depto) {
		if(DaoDepartamento.listaDepartamentos.contains(depto))
			return true;
		return false;
	}

	public boolean excluir(Departamento novo) {
		return DaoDepartamento.listaDepartamentos.remove(novo);
	}

	public Departamento[] obterTodos() {
		int qtde = DaoDepartamento.listaDepartamentos.size();
		Departamento[] copia = new Departamento[qtde];
		int i = 0;
		for(Departamento d : DaoDepartamento.listaDepartamentos)
			copia[i++] = d;
		return copia;
	}
}
