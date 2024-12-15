package com.jp.tagYouApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jp.tagYouApi.model.GrupoCodinome;
import com.jp.tagYouApi.repository.CodinomeRepositoryFactory;

@Service
public class CodinomeService {
	
	private final CodinomeRepositoryFactory factory;
	
	public CodinomeService(CodinomeRepositoryFactory fac) {
		this.factory = fac;
	}
	
	public String gerarCodinome(GrupoCodinome grupo, List<String> codionomesIndisponiveis) throws Exception {
		
		var codinomesDisponiveis = listarCodinomesDisponiveis(grupo,codionomesIndisponiveis);
		if(codinomesDisponiveis.isEmpty()) {
			throw new Exception("Não há codinomes disponíveis para o grupo: " + grupo.getNome());
		}
		
		var codinomeSorteado = sortearCodinome(codinomesDisponiveis);
		return codinomeSorteado;
	}

	private List<String> listarCodinomesDisponiveis(GrupoCodinome grupo, List<String> indisponiveis) throws Exception{
		
		var codinomes = buscarCodinomes(grupo);
		var codinomesDisponiveis = codinomes.stream()
				.filter(codinome -> !codinomes.contains(codinome))
				.toList();
		return codinomesDisponiveis;
	}
	
	private List<String> buscarCodinomes(GrupoCodinome grupo) throws Exception{	
		var codinomeRepository = factory.create(grupo);
		return codinomeRepository.buscarCodinomes();
	}
	
	private String sortearCodinome(List<String> codinomesDisponiveis) {
		return null;
	}

}
