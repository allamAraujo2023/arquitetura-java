package br.edu.infnet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appvenda.model.domain.Calcado;
import br.edu.infnet.appvenda.model.repository.CalcadoRepository;

@Service
public class CalcadoService {

	@Autowired
	private CalcadoRepository calcadoRepository;
	
	public void incluir(Calcado calcado) {
		
		calcadoRepository.save(calcado);
	}
	
	public Collection<Calcado> obterLista(){
		
		return (Collection<Calcado>) calcadoRepository.findAll();
	}
}