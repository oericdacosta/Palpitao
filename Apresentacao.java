package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Apresentacao {
	
	public int pegarPalpite(Jogador jogador, Partida partida) {
		int palpite = 0;
		do {
			Scanner ler = new Scanner(System.in);
			System.out.println(jogador.getNome()+", informe o codigo do seu palpite ou -1 para apostar no empate:");
			palpite = ler.nextInt();
		}while(palpite != partida.getT1().getCodigo() && palpite != partida.getT2().getCodigo() && palpite != -1);
		return palpite;
	}
	
	public void mostrarPartidaTimes(int numero, ArrayList<Partida> partidas) {
		System.out.println("\nPartida " + (numero + 1) + "\t time 1: " + partidas.get(numero).getT1().getNome()
				+ "\t time 2: " + partidas.get(numero).getT2().getNome()
				+"\n\t\t Codigo: "+partidas.get(numero).getT1().getCodigo()+"\t Codigo: "+partidas.get(numero).getT2().getCodigo());
	}
	
	public void mostrarPontuacaoJogadores(ArrayList<Jogador> jogadores) {
		for (int i = 0; i < jogadores.size(); i++) {
			System.out.println("Pontuação " + jogadores.get(i).getNome() + ": " + jogadores.get(i).getPontuacao()+"  Fichas:"+jogadores.get(i).getApostaDeFichas());
		}
	}
}
