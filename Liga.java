package jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Liga {
	private ArrayList <Time> times;
	private ArrayList <Partida> partidas;
	private ArrayList <Time> vencedores;
	private ArrayList <Jogador> jogadores;
	
	public Liga() {
		times = new ArrayList <Time>();
		partidas = new ArrayList <Partida>();
		vencedores = new ArrayList <Time>();
		jogadores = new ArrayList <Jogador>();
	}
	
	public void adcionarTimes(Time t) {
		times.add(t);
	}
	
	public void adcionarjogadores(Jogador j) {
		jogadores.add(j);
	}
	
	private void montarLiga() {
		for (int i = 0; i < times.size(); i++) {
			for (int j = i+1; j < times.size(); j++) {
				if(i != times.size()-1) {
					if(times.get(i).getCodigo() == times.get(j).getCodigo()) {
						times.get(j).setCodigo(times.get(j).getCodigo()+1);
					}
					
					Partida p = new Partida(times.get(i),times.get(j));
					partidas.add(p);
				}
			}
		}	
	}
	
	public Time pegarTimePorCodigo(int codigo) {
		
		for (int j = 0; j <times.size(); j++) {
			if(codigo == times.get(j).getCodigo()) {
				return times.get(j);
			}
		}
		return null;
	}
	
	public void iniciarPartidasDaLiga() {
		montarLiga();
		Apresentacao ap = new Apresentacao();
		
		for (int i = 0; i < partidas.size(); i++) {
			ap.mostrarPartidaTimes(i, partidas);
			
			for (int j = 0; j < jogadores.size(); j++) {
				jogadores.get(j).setPalpite(pegarTimePorCodigo(ap.pegarPalpite(jogadores.get(j),partidas.get(i))));
			}
			
			vencedores.add(partidas.get(i).ehHoraDoDuelo());
			
			for (int j = 0; j < jogadores.size(); j++) {
				if(vencedores.get(i) == jogadores.get(j).getPalpite() && jogadores.get(j).getPalpite() != null && vencedores.get(i) != null) {
					jogadores.get(j).setPontuacao(3);
					jogadores.get(j).setApostaDeFichas(3*jogadores.get(j).getApostaDeFichas());
				}else if(jogadores.get(j).getPalpite() == null && vencedores.get(i) == null) {
					jogadores.get(j).setPontuacao(1);
					jogadores.get(j).setApostaDeFichas(jogadores.get(j).getApostaDeFichas());
				}else {
					jogadores.get(j).setPontuacao(0);
					jogadores.get(j).setApostaDeFichas(-jogadores.get(j).getApostaDeFichas()/3);
				}
				if(jogadores.get(j).getApostaDeFichas() <= 0) {
					i=partidas.size();
				}
			}
			ap.mostrarPontuacaoJogadores(jogadores);
		}
	}
	
	public String tabelaLiga() {

		String resultado = "";
		
		resultado += "\n Número de partidas: "+ partidas.size()+"\n";
		for (int i = 0; i < vencedores.size(); i++) {
			if (vencedores.get(i) == null) {
				resultado += "\n Partida: " + (i + 1) + " empatou  ";
			} else {
				resultado += "\n Partida: " + (i + 1) + " vencedor " + vencedores.get(i).getNome();
			}
			resultado += "\t times: (1) " + partidas.get(i).getT1().getNome() + " (2) "
					+ partidas.get(i).getT2().getNome();
		}
		
		resultado += "\n\n Número de times: "+times.size()+"\n";

		for (int i = 0; i < times.size(); i++) {
			resultado += "\n Time: " + times.get(i).getNome() + " Código: "+times.get(i).getCodigo()
					+" Pontuação: " + times.get(i).getPontuacao();
		}
		
		resultado += "\n\n Número de jogadores: "+ jogadores.size()+"\n";
		
		for (int i = 0; i < jogadores.size(); i++) {
			resultado += "\n Jogador "+(i+1)+": "+jogadores.get(i).getNome()+" Número de fichas: "+jogadores.get(i).getApostaDeFichas()
					+" Pontuação: "+jogadores.get(i).getPontuacao();
		}
		
		float libertadores = (float) (((times.size() - 1)*3)*0.5);
		resultado += "\n\n Times rebaixados:\n";
		
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).getPontuacao() < libertadores) {
				resultado += " "+times.get(i).getNome()+"\n";
			}
		}
		
		resultado += "\n Times classificados na libertadores:\n";
		
		float sulAmericana = (float) (((times.size() - 1)*3)*0.75);
		
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).getPontuacao() > libertadores && times.get(i).getPontuacao() < sulAmericana) {
				resultado += " "+times.get(i).getNome()+"\n";
			}
		}
		
		resultado += "\n Times classificados na Sul-americana:\n";
		
		for (int i = 0; i < times.size(); i++) {
			if(times.get(i).getPontuacao() > sulAmericana) {
				resultado += " "+times.get(i).getNome()+"\n";
			}
		}
		
		return resultado;
	}
	
}
