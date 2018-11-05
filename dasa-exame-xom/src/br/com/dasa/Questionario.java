package br.com.dasa;

import java.io.Serializable;
import java.util.List;

public class Questionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6839579691165832076L;
	
	private String exame;
	
	private List<String> perguntas;
	
	private List<String> respostas;
	
	public String getExame() {
		return exame;
	}

	public void setExame(String exame) {
		this.exame = exame;
	}

	public List<String> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<String> perguntas) {
		this.perguntas = perguntas;
	}
	
	public void adicionarPergunta(String pergunta){
		this.perguntas.add(pergunta);
	}

	public List<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}
	
}
