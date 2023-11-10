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
import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.service.CalcadoService;

@Order(3)
@Component
public class CalcadoLoader implements ApplicationRunner {
	
	@Autowired
	private CalcadoService calcadoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		FileReader file = new FileReader("files/calcado.txt");		
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();

		String[] campos = null;
				
		while(linha != null) {
			
			campos = linha.split(";");
			
			Calcado calcado = new Calcado();

			calcado.setCodigo(Integer.valueOf(campos[0]));
			calcado.setDescricao(campos[1]);
			calcado.setEstoque(Boolean.valueOf(campos[2]));
			calcado.setPreco(Float.valueOf(campos[3]));
			calcado.setNumero(Integer.parseInt(campos[4]));
			calcado.setCor(campos[5]);
			calcado.setMarca(campos[6]);
			
			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.parseInt(campos[7]));
			calcado.setVendedor(vendedor);
			
			try {
				
				calcadoService.incluir(calcado);
				
			}  catch (ConstraintViolationException e) {
				
				FileLogger.logException("[Calcado] " + vendedor + " - " + e.getMessage());
			}
			
			linha = leitura.readLine();
		}

		for(Calcado calcado: calcadoService.obterLista()) {
			
			System.out.println("[Calçado:] " + calcado);			
		}

		leitura.close();
	}
	
}