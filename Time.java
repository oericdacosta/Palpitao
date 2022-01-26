package jogo;

import java.util.ArrayList;

public class Time {
	private String nome;
	private int codigo;
	private ArrayList <Integer> acoes;
	private int pontuacao;
	
	public Time(int codigo, String nome) {
		if(nome!="") {
			this.nome = nome;
		}else {
			this.nome = "Default";
		}
		if(codigo>0) {
			this.codigo = codigo;
		}
		acoes = new ArrayList <Integer>();
	}
	
	private int iniciarAcao() {
		return (int) ((Math.random() * 50) + 0);
	}
	
	public void computarAcoes() {
		for (int i = 0; i < 10; i++) {
			acoes.add(iniciarAcao());
		}
	}
	
	
	
	public ArrayList<Integer> getAcoes() {
		return acoes;
	}
	
	public int getAcoesIndividual(int i) {
		return acoes.get(i);
	}

	public String getNome() {
		return nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		if(pontuacao>=0) {
			this.pontuacao += pontuacao;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
