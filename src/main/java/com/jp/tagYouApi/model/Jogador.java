package com.jp.tagYouApi.model;

public record Jogador(
	String nome,
	String email,
	String telefone,
	String codinome,
	GrupoCodinome grupoCodinome
) {

}
