package model;

public class Empregado implements Comparable<Empregado> {
	// 
	// CONSTANTES
	//
	final public static int TAMANHO_MAX_NOME = 40;
	
	//
	// ATRIBUTOS
	//
	private String cpf;
	private String nome;
	
	//
	// ATRIBUTOS DE RELACIONAMENTO
	//
	private Departamento depto;
	
	//
	// MÉTODOS
	//
	public Empregado(String cpf, String nome, Departamento depto) 
			throws ModelException {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setDepto(depto);
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) throws ModelException{
		Empregado.validarCpf(cpf);
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws ModelException {
		Empregado.validarNome(nome);
		this.nome = nome;
	}

	public Departamento getDepto() {
		return this.depto;
	}

	public void setDepto(Departamento depto) throws ModelException {
		Empregado.validarDepto(depto);
		// Verificando se o empregado pertencia a um outro departamento
		// Se sim, vamos tirá-lo desse departamento
		if(this.depto != null)
			this.depto.removerEmpregado(this);		
		// Associamos o empregado ao departamento novo
		this.depto = depto;
		// Notificamos ao novo departamento para adicionar o empregado
		this.depto.adicionarEmpregado(this);
	}
		
	public static void validarCpf(String cpf) throws ModelException {
		if (cpf == null || cpf.length() == 0)
			throw new ModelException("O cpf do empregado não pode ser nulo!");
		String expRegular = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
		if(!cpf.matches(expRegular))
			throw new ModelException("O cpf passado é inválido!");	
	}
	
	public static void validarNome(String nome) throws ModelException {
		if (nome == null || nome.length() == 0)
			throw new ModelException("O nome do empregado não pode ser nulo!");
		String expRegular = "[A-Za-zÀ-ÿ ]{5," + TAMANHO_MAX_NOME + "}";
		if(!nome.matches(expRegular))
			throw new ModelException("O nome passado é inválido!");
	}
	
	public static void validarDepto(Departamento depto) throws ModelException {
		if(depto == null)
			throw new ModelException("O departamento do empregado não pode ser nulo!");
	}
	
	public int compareTo(Empregado outro) {
		System.out.println(this + " comparando com " + outro);
		return this.cpf.compareTo(outro.cpf);
	}
	
	@Override
	public String toString() {
		return this.cpf + "-" + this.nome;
	}
}
