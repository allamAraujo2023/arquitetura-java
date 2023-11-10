package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Calcado;
import br.edu.infnet.appvenda.model.domain.Produto;
import br.edu.infnet.appvenda.model.domain.Roupa;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.VendedorService;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendedorService vendedorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/produto.txt");	
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;

		Vendedor vendedor = new Vendedor();
		
		while(linha != null) {
			
			campos = linha.split(";");
			
			switch (campos[7]) {
			
			case "C":
				
				try {
					
					Calcado calcado = new Calcado();

					calcado.setCodigo(Integer.valueOf(campos[0]));
					calcado.setDescricao(campos[1]);
					calcado.setEstoque(Boolean.valueOf(campos[2]));
					calcado.setPreco(Float.valueOf(campos[3]));
					calcado.setNumero(Integer.parseInt(campos[4]));
					calcado.setCor(campos[5]);
					calcado.setMarca(campos[6]);
					
					vendedor.setId(Integer.valueOf(campos[8]));
					
					calcado.setVendedor(vendedor);
					
					try {
						
						produtoService.incluir(calcado);
						
					} catch (ConstraintViolationException e) {
						FileLogger.logException("[Calcado] " + vendedor + " - " + e.getMessage());
					}
					
					break;
					
				} catch (Exception e) {
					System.out.println("Erro : " + e);
				}

			case "R":
				
				Roupa roupa = new Roupa();

				roupa.setCodigo(Integer.valueOf(campos[0]));
				roupa.setDescricao(campos[1]);
				roupa.setEstoque(Boolean.valueOf(campos[2]));
				roupa.setPreco(Float.valueOf(campos[3]));
				roupa.setTamanho(campos[4]);
				roupa.setCor(campos[5]);
				roupa.setTipo(campos[6]);
				
				vendedor.setId(Integer.valueOf(campos[8]));
				
				roupa.setVendedor(vendedor);
				
				try {
					
					produtoService.incluir(roupa);
					
				} catch (ConstraintViolationException e) {
					FileLogger.logException("[Roupa] " + vendedor + " - " + e.getMessage());
				}
				
				break;

			default:
				break;
			}
									
			linha = leitura.readLine();
		}
		
		for(Vendedor v : vendedorService.obterLista()) {
			for(Produto produto : produtoService.obterLista(v) ) {
				System.out.println("[Produto] " + produto);				
			}			
		}
		
		leitura.close();
	}
}