package com.consultas.consultas_medicas.model.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultas.consultas_medicas.model.Consulta;
import com.consultas.consultas_medicas.repositories.ConsultaRepository;

@Service
public class ConsultaService {

	private final Logger logger = Logger.getLogger(ConsultaService.class.getName());

	@Autowired
	private ConsultaRepository repository;

	public List<Consulta> findAll() {
		logger.info("Finding all Consultas!");
		var consultas = repository.findAll();

		return consultas;
	}

	public Consulta findById(Long id) {
		logger.info("Finding one Consulta!");
		return repository.findById(id).orElse(null);
	}

	public Consulta create(Consulta consulta) {
		logger.info("Creating one Consulta!");
		var saved = repository.save(consulta);

		return saved;
	}

	public Consulta update(Consulta consulta) {
		logger.info("Updating one Consulta!");
		Consulta existing = repository.findById(consulta.getId()).orElse(null);

		if (existing != null) {
			existing.setDataHora(consulta.getDataHora());
			existing.setStatus(consulta.getStatus());
			existing.setAnotacoes(consulta.getAnotacoes());
			existing.setPaciente(consulta.getPaciente());
			existing.setMedico(consulta.getMedico());
			return repository.save(existing);
		}

		return null;
	}

	public void delete(Long id) {
		logger.info("Deleting one Consulta!");
		Consulta consulta = repository.findById(id).orElse(null);
		if (consulta != null) {
			repository.delete(consulta);
		}
	}

}
