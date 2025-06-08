package com.consultas.consultas_medicas.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tipo;

	@Column(length = 2000)
	private String conteudo;

	private LocalDateTime dataGeracao;

	public Relatorio() {
	}

	public Relatorio(Long id, String tipo, String conteudo, LocalDateTime dataGeracao) {
		this.id = id;
		this.tipo = tipo;
		this.conteudo = conteudo;
		this.dataGeracao = dataGeracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public LocalDateTime getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(LocalDateTime dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Relatorio that = (Relatorio) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
