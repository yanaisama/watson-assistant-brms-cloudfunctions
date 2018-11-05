package br.com.dasa;

import java.io.Serializable;

public class Cliente implements Serializable{

	private static final long serialVersionUID = 4038262898561371082L;
	
	private double peso;
	private double altura;
	private String sexo;
	private int idade;
	private double imc;
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	} 
	
	

}
