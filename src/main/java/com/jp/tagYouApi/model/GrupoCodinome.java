package com.jp.tagYouApi.model;

public enum GrupoCodinome {
	VINGADORES("Vingadores", ""), 
	LIGA_DA_JUSTICA("Liga da Justiça", "");
	
	GrupoCodinome(String nome, String uri){
		this.nome = nome;
		this.uri = uri;
	}
	
	private final String nome;
	private final String uri;
	
	public String getNome() {
		return nome;
	}
	public String getUri() {
		return uri;
	}
	
	
	
}
