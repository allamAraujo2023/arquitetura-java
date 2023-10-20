package br.edu.infnet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Roupa;

@Service
public class RoupaService {

	private Map<Integer, Roupa> mapaRoupas = new HashMap<Integer, Roupa>();

	public void incluir(Roupa roupa) {
		
		mapaRoupas.put(roupa.getCodigo(), roupa);
	}
	
	public Collection<Roupa> obterLista(){	
		
		return mapaRoupas.values();
	}
}