package br.com.dasa;

import java.util.List;

public class Agendamento {
	
	private List<String> unidadesDisponiveis;

	public List<String> getUnidadesDisponiveis() {
		return unidadesDisponiveis;
	}

	public void setUnidadesDisponiveis(List<String> unidadesDisponiveis) {
		this.unidadesDisponiveis = unidadesDisponiveis;
	}
	
	public void adicionarUnidade(String unidade){
		this.unidadesDisponiveis.add(unidade);
	}

}
