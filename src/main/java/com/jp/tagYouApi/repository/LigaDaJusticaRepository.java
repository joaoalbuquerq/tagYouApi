package com.jp.tagYouApi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jp.tagYouApi.model.GrupoCodinome;
import com.jp.tagYouApi.web.LigaDaJusticaDTO;

@Repository
public class LigaDaJusticaRepository implements CodinomeRepository{

	@Override
	public List<String> buscarCodinomes()  throws Exception{
		var codinomes = RestClient.builder()
				.baseUrl(GrupoCodinome.LIGA_DA_JUSTICA.getUri())
				.build()
				.get()
				.retrieve()
				.body(String.class);
		
		
		var xmlMapper = new XmlMapper();
		var ligaJustica = xmlMapper.readValue(codinomes, LigaDaJusticaDTO.class);
		return ligaJustica.getCodinomes();
	}

}
