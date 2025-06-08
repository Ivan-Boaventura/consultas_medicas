package com.consultas.consultas_medicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultas.consultas_medicas.model.Consulta;
import com.consultas.consultas_medicas.model.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/consultas")
@Tag(name = "Consultas", description = "API para gerenciamento de consultas médicas")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@Operation(summary = "Listar todas as consultas", description = "Retorna uma lista com todas as consultas registradas no sistema", responses = {
			@ApiResponse(responseCode = "200", description = "Lista de consultas retornada com sucesso", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Consulta.class)))) })
	@GetMapping
	public List<Consulta> findAll() {
		return consultaService.findAll();
	}

	@Operation(summary = "Buscar uma consulta por ID", description = "Retorna os detalhes de uma consulta específica", responses = {
			@ApiResponse(responseCode = "200", description = "Consulta encontrada", content = @Content(schema = @Schema(implementation = Consulta.class))),
			@ApiResponse(responseCode = "404", description = "Consulta não encontrada") })
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> findById(@PathVariable Long id) {
		Consulta consulta = consultaService.findById(id);
		if (consulta == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(consulta);
	}

	@Operation(summary = "Criar uma nova consulta", description = "Cadastra uma nova consulta médica no sistema", responses = {
			@ApiResponse(responseCode = "200", description = "Consulta criada com sucesso", content = @Content(schema = @Schema(implementation = Consulta.class))) })
	@PostMapping
	public Consulta create(@RequestBody Consulta consulta) {
		return consultaService.create(consulta);
	}

	@Operation(summary = "Atualizar uma consulta existente", description = "Atualiza os dados de uma consulta com base no ID", responses = {
			@ApiResponse(responseCode = "200", description = "Consulta atualizada com sucesso", content = @Content(schema = @Schema(implementation = Consulta.class))),
			@ApiResponse(responseCode = "404", description = "Consulta não encontrada") })
	@PutMapping("/{id}")
	public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta consulta) {
		consulta.setId(id);
		Consulta updated = consultaService.update(consulta);
		if (updated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updated);
	}

	@Operation(summary = "Excluir uma consulta", description = "Remove uma consulta do sistema com base no ID", responses = {
			@ApiResponse(responseCode = "204", description = "Consulta excluída com sucesso") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		consultaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
