package br.edu.infnet.appvenda;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appvenda.model.domain.Roupa;
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.RoupaService;

@Order(4)
@Component
public class RoupaLoader implements ApplicationRunner {
	
	@Autowired
	private RoupaService roupaService;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/roupa.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Roupa roupa = new Roupa();

			roupa.setCodigo(Integer.valueOf(campos[0]));
			roupa.setDescricao(campos[1]);
			roupa.setEstoque(Boolean.valueOf(campos[2]));
			roupa.setPreco(Float.valueOf(campos[3]));
			roupa.setTamanho(campos[4]);
			roupa.setCor(campos[5]);
			roupa.setTipo(campos[6]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.parseInt(campos[7]));
			roupa.setVendedor(vendedor);
			
			try {
			
				roupaService.incluir(roupa);
				
			} catch (ConstraintViolationException e) {
				FileLogger.logException("[Roupa] " + vendedor + " - " + e.getMessage());
			}
			
			linha = leitura.readLine();
		}

		for(Roupa roupa : roupaService.obterLista()) {
			
			System.out.println("[Roupa] " + roupa);
		}
		
		leitura.close();
	}
}