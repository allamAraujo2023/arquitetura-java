package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Calcado;
import br.edu.infnet.appvenda.model.domain.Roupa;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.service.ProdutoService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produto.txt");	
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[7]) {
			
			case "C":
				
				Calcado calcado = new Calcado();

				calcado.setCodigo(Integer.valueOf(campos[0]));
				calcado.setDescricao(campos[1]);
				calcado.setEstoque(Boolean.valueOf(campos[2]));
				calcado.setPreco(Float.valueOf(campos[3]));
				calcado.setNumero(Integer.parseInt(campos[4]));
				calcado.setCor(campos[5]);
				calcado.setMarca(campos[6]);
				
				produtoService.incluir(calcado);
				
				break;

			case "R":
				
				Roupa roupa = new Roupa();

				roupa.setCodigo(Integer.valueOf(campos[0]));
				roupa.setDescricao(campos[1]);
				roupa.setEstoque(Boolean.valueOf(campos[2]));
				roupa.setPreco(Float.valueOf(campos[3]));
				roupa.setTamanho(campos[4]);
				roupa.setCor(campos[5]);
				roupa.setTipo(campos[6]);
				
				produtoService.incluir(roupa);
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}

		for(Produto produto: produtoService.obterLista()) {
			System.out.println("[Produto] " + produto);			
		}
		
		leitura.close();
	}
}