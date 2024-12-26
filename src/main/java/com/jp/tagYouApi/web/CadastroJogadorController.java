package com.jp.tagYouApi.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.tagYouApi.model.GrupoCodinome;
import com.jp.tagYouApi.model.Jogador;
import com.jp.tagYouApi.service.JogadorService;

@Controller
@RequestMapping("cadastro-jogador")
public class CadastroJogadorController {
	private final JogadorService jogadorService;
	
	public CadastroJogadorController(JogadorService serv) {
		this.jogadorService = serv;
	}
	
	@GetMapping
	public String paginaCadastroJogador(Model model) {
		model.addAttribute("gruposCodinomes", GrupoCodinome.values());
		
		return "cadastro_jogador";
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
