package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	//
	// CONSTANTES
	//
	final public static int TAMANHO_SIGLA = 2;
	final public static int TAMANHO_MAX_NOME = 20;

	//
	// ATRIBUTOS
	//
	private String sigla;
	private String nome;

	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	private List<Empregado> listaEmpregados;
	private Empregado gerente;

	//
	// MÉTODOS
	//
	public Departamento(String sigla, String nome) throws ModelException {
		this.setSigla(sigla);
		this.setNome(nome);
		this.listaEmpregados = new ArrayList<Empregado>();
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) throws ModelException {
		Departamento.validarSigla(sigla);
		this.sigla = sigla;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws ModelException {
		Departamento.validarNome(nome);
		this.nome = nome;
	}

	public List<Empregado> getListaEmpregados() {
		// Não passamos o objeto de coleção diretamente.
		// Criamos uma cópia dele através da instanciação
		// de um novo ArrayList.
		return new ArrayList<>(this.listaEmpregados);
	}

	public void setListaEmpregados(List<Empregado> listaEmpregados) throws ModelException {
		Departamento.validarListaEmpregados(listaEmpregados);
		this.listaEmpregados = listaEmpregados;
	}
	
	public boolean adicionarEmpregado(Empregado novo) throws ModelException {
		Departamento.validarEmpregado(novo);
		return this.listaEmpregados.add(novo);
	}
	
	public boolean removerEmpregado(Empregado ex) throws ModelException {
		Departamento.validarEmpregado(ex);
		return this.listaEmpregados.remove(ex);		
	}

	public Empregado getGerente() {
		return this.gerente;
	}

	public void setGerente(Empregado gerente) throws ModelException {
		Departamento.validarGerente(gerente, this.listaEmpregados);
		this.gerente = gerente;
	}

	public String toString() {
		return this.nome;
	}
	
	public static void validarSigla(String sigla) throws ModelException {
		if (sigla == null || sigla.length() == 0)
			throw new ModelException("A sigla do Departamento não pode ser nula!");
		if (sigla.length() != TAMANHO_SIGLA)
			throw new ModelException("A sigla deve ter " + TAMANHO_SIGLA + " letras maiúsculos!");
		for (int i = 0; i < TAMANHO_SIGLA; i++) {
			char c = sigla.charAt(i);
			if (!Character.isUpperCase(c))
				throw new ModelException("O caracter na posição " + i + " não é letra maiúscula!");
		}
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome do Departamento não pode ser nulo!");
		if (nome.length() > TAMANHO_MAX_NOME)
			throw new ModelException("O nome deve ter até " + TAMANHO_MAX_NOME + " caracteres!");
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("O caracter na posição " + i + " não é válido!");
		}
	}

	public static void validarListaEmpregados(List<Empregado> listaEmpregados) throws ModelException {
		if (listaEmpregados == null)
			throw new ModelException("A Lista de Empregados do Departamento não pode ser nulo!");
	}

	public static void validarGerente(Empregado gerente, List<Empregado> listaEmpregados) throws ModelException {
		if( ! listaEmpregados.contains(gerente))
			throw new ModelException("O gerente deve fazer parte da lista de empregados do departamento!");
	}

	public static void validarEmpregado(Empregado e) throws ModelException {
		if(e == null)
			throw new ModelException("É necessário indicar o empregado para essa operação");
	}
}
