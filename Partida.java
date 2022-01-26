package jogo;

import java.util.ArrayList;

public class Partida {
	private Time t1;
	private Time t2;
	private ArrayList <Integer> pontuacaoTime1;
	private ArrayList <Integer> pontuacaoTime2;
	private ArrayList <Integer> acoesTime1;
	private ArrayList <Integer> acoesTime2;
	private Time vencedor;
	
	public Partida(Time t1, Time t2) {
		if(t1!=null && t2!=null) {
			this.t1 = t1;
			this.t2 = t2;
		}
		pontuacaoTime1 = new ArrayList <Integer>();
		pontuacaoTime2 = new ArrayList <Integer>();
		acoesTime1 = new ArrayList <Integer>();
		acoesTime2 = new ArrayList <Integer>();
	}
	
	private void computarAcoesTime() {
		t1.computarAcoes();
		acoesTime1 = t1.getAcoes();
		
		t2.computarAcoes();
		acoesTime2 = t2.getAcoes();
	}
	
	private void pontuacaoPontoAPonto() {
		for (int i = 0; i <10; i++) {
			if(t1.getAcoesIndividual(i) > t2.getAcoesIndividual(i)) {
				pontuacaoTime1.add(3);
				pontuacaoTime2.add(0);
			}else if( t2.getAcoesIndividual(i) > t1.getAcoesIndividual(i)) {
				pontuacaoTime1.add(0);
				pontuacaoTime2.add(3);
			}else {
				pontuacaoTime1.add(1);
				pontuacaoTime2.add(1);
			}
		}
	}
	
	private void verificarVencedor() {
		int somaTime1 = 0, somaTime2 = 0;
		
		for (int i = 0; i < 10; i++) {
			somaTime1+=pontuacaoTime1.get(i);
			somaTime2+=pontuacaoTime2.get(i);
		}
		
		if(somaTime1 > somaTime2) {
			t1.setPontuacao(3);
			t2.setPontuacao(0);
			vencedor = t1;
		}else if(somaTime2 > somaTime1) {
			t1.setPontuacao(0);
			t2.setPontuacao(3);
			vencedor = t2;
		}else {
			t1.setPontuacao(1);
			t2.setPontuacao(1);
			vencedor = null;
		}
	}
	
	public Time ehHoraDoDuelo() {
		computarAcoesTime();
		pontuacaoPontoAPonto();
		verificarVencedor();
		return vencedor;
	}

	public Time getT1() {
		return t1;
	}

	public Time getT2() {
		return t2;
	}
	
	
}
