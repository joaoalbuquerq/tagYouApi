package com.jp.tagYouApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.tagYouApi.model.GrupoCodinome;
import com.jp.tagYouApi.model.Jogador;
import com.jp.tagYouApi.repository.JogadorRepository;

@Service
public class JogadorService {
	
	private final JogadorRepository repository;
	private final CodinomeService codinomeService;
	
	
	public JogadorService(JogadorRepository repository, CodinomeService service) {
		this.repository = repository;
		this.codinomeService = service;
	}



	public Jogador registrarJogador(Jogador jogador) throws Exception{
		var codinomesIndisponiveis = listarCodinomesIndisponiveis(jogador.grupoCodinome());
		var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(), codinomesIndisponiveis);
		
		var novoJogador = new Jogador(jogador.nome(), jogador.email(), 
				jogador.telefone(), novoCodinome, jogador.grupoCodinome());
		
		return repository.salvar(novoJogador);
	}



	private List<String> listarCodinomesIndisponiveis(GrupoCodinome grupoCodinome) {
		return repository.listarCodinomesIndisponiveisPorGrupo(grupoCodinome);
	}

}
