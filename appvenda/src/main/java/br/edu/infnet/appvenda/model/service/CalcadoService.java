package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Calcado;

@Service
public class CalcadoService {

	private Map<Integer, Calcado> mapaCalcados = new HashMap<Integer, Calcado>();

	public void incluir(Calcado calcado) {
		
		mapaCalcados.put(calcado.getCodigo(), calcado);
	}
	
	public Collection<Calcado> obterLista(){
		
		return mapaCalcados.values();
	}
}