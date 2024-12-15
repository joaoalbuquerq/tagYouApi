package com.jp.tagYouApi.repository;

import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.jp.tagYouApi.model.GrupoCodinome;
import com.jp.tagYouApi.model.Jogador;

@Repository
public class JogadorRepository {
	
	private final JdbcClient  jdbcClient;
	
	public JogadorRepository(JdbcClient client) {
		this.jdbcClient=client;
	}
	
	public Jogador salvar(Jogador jogador) {
		
		jdbcClient.sql("""
				INSERT INTO JOGADORES(nome, email, telefone, codinome, grupo_codinome)
				VALUES(:nome, :email, :telefone, :codinome, :grupoCodinome)
		""")
		.param("nome", jogador.nome())
		.param("email", jogador.email())
		.param("telefone",jogador.telefone())
		.param("codinome", jogador.codinome())
		.param("grupoCodinome", jogador.grupoCodinome())
		.update();
		
		return jogador;
	}

	public List<String> listarCodinomesIndisponiveisPorGrupo(GrupoCodinome grupoCodinome) {
		
		return jdbcClient.sql("SELECT distinct(codinomes) FROM JOGADORES WHERE grupo_codinome = :codinome")
				.param("codinome", grupoCodinome.name())
				.query(String.class)
				.list();
	}
}
