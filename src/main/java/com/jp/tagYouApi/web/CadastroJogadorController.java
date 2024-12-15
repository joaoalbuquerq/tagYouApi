package com.jp.tagYouApi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.tagYouApi.model.Jogador;
import com.jp.tagYouApi.service.JogadorService;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
	private final JogadorService jogadorService;
	
	public CadastroJogadorController(JogadorService serv) {
		this.jogadorService = serv;
	}
	
	@PostMapping
	public String cadastrarJogador(@ModelAttribute Jogador jogador) {
		try{
			jogadorService.registrarJogador(jogador);
			return "redirect:/cadastro-jogador";
		}catch(Exception e) {
			return "redirect:/cadastro-jogador";
		}
		
	}
	
}
