package jogo;

public class Jogador {
	private String nome;
	private int pontuacao;
	private Time palpite;
	private int apostaDeFichas;
	
	public Jogador(String nome, int apostaDeFichas) {
		this.nome = nome;
		if(apostaDeFichas<10) {
			this.apostaDeFichas = 10;
		}else {
			this.apostaDeFichas = apostaDeFichas;
		}
		this.pontuacao = 0;
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

	public Time getPalpite() {
		return palpite;
	}

	public void setPalpite(Time palpite) {
		this.palpite = palpite;
	}

	public int getApostaDeFichas() {
		return apostaDeFichas;
	}

	public void setApostaDeFichas(int aposta) {
		this.apostaDeFichas += aposta;
	}
}
