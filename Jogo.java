package jogo;

import java.util.Scanner;

public class Jogo {
	public Jogador cadastrarJogador() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do jogador:");
		String nome = ler.nextLine();
		System.out.println("Digite a quantidade de fichas:");
		int qtdFichas = ler.nextInt();
		
		Jogador j = new Jogador(nome, qtdFichas);
		return j;
	}
	
	public int quantidadeJogadores() {
		int numPlayers;
		do {
			Scanner ler = new Scanner(System.in);
			System.out.println("Digite o número de Player (máx: 6, mín: 2):");
			numPlayers = ler.nextInt();
		}while(numPlayers <2 || numPlayers>6);
		return numPlayers;
	}
	
	public int quantidadeTimes() {
		int numTimes;
		do {
			Scanner ler = new Scanner(System.in);
			System.out.println("Quantos times você quer que participem?(máx: 16, mín: 4):");
			numTimes = ler.nextInt();
		}while(numTimes<4 || numTimes>16);
		return numTimes;
	}
	
	public Time cadastrarTime() {
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Digite o nome do time:");
		String nome = ler.nextLine();
		int codigo;
		
		do {
			System.out.println("Digite o código:");
			codigo = ler.nextInt();
		}while(codigo <= 0);
		
		Time t = new Time(codigo, nome);
		return t;
	}
	
	public void cadastrarTimesParaLiga(Liga liga) {
		int qtdTimes = quantidadeTimes();
		for (int i = 0; i <qtdTimes; i++) {
			liga.adcionarTimes(cadastrarTime());
		}
	}
	
	public void cadastrarJogadores(Liga liga) {
		int qtdJogadores = quantidadeJogadores();
		for (int i = 0; i < qtdJogadores; i++) {
			liga.adcionarjogadores(cadastrarJogador());
			
		}
	}
	
	public void play(){
		Liga liga = new Liga();
		cadastrarTimesParaLiga(liga);
		cadastrarJogadores(liga);
		liga.iniciarPartidasDaLiga();
		System.out.println(liga.tabelaLiga());
	}
}
