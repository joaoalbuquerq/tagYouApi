package com.jp.tagYouApi.repository;

import org.springframework.stereotype.Component;

import com.jp.tagYouApi.model.GrupoCodinome;

@Component
public class CodinomeRepositoryFactory {
	
	private final LigaDaJusticaRepository ligaJusticaRepository;
	private final VingadoresRepository vingadoresRepository;
	
	public CodinomeRepositoryFactory(LigaDaJusticaRepository justicaRepository, VingadoresRepository vingadoresRepository) {
		this.ligaJusticaRepository = justicaRepository;
		this.vingadoresRepository = vingadoresRepository;
	}
	
	public CodinomeRepository create(GrupoCodinome grupo) {
		return switch(grupo) {
		case LIGA_DA_JUSTICA -> ligaJusticaRepository;
		case VINGADORES -> vingadoresRepository;
		};
	}

}
