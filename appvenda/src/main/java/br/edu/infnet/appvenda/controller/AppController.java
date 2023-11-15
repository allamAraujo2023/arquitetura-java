package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appvenda.model.service.CalcadoService;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.RoupaService;
import br.edu.infnet.appvenda.model.service.InformacaoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CalcadoService calcadoService;
	
	@Autowired
	private RoupaService roupaService;
	
	@Autowired
	private InformacaoService informacaoService;

	
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("informacoes", informacaoService.obterLista());
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeCalcado", calcadoService.obterQtde());
		model.addAttribute("qtdeRoupa", roupaService.obterQtde());

		return "home";
	}
	
//	@GetMapping(value = "/produto/lista")
//	public String obterListaProduto(Model model) {
//		
//		model.addAttribute("titulo", "Produtos:");
//		model.addAttribute("listagem", produtoService.obterLista());
//
//		return showHome(model);
//	}

//	@GetMapping(value = "/calcado/lista")
//	public String obterListaAlimenticio(Model model) {
//		
//		model.addAttribute("titulo", "Produtos Calcados:");
//		model.addAttribute("listagem", calcadoService.obterLista());
//
//		return showHome(model);
//	}

//	@GetMapping(value = "/roupa/lista")
//	public String obterListaEletronico(Model model) {
//		
//		model.addAttribute("titulo", "Produtos Roupas:");
//		model.addAttribute("listagem", roupaService.obterLista());
//
//		return showHome(model);
//	}
	
}