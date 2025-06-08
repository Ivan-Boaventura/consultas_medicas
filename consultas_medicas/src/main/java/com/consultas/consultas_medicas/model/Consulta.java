package com.consultas.consultas_medicas.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataHora;
	private String status;

	@Column(length = 1000)
	private String anotacoes;

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@OneToMany(mappedBy = "consulta")
	private List<Notificacao> notificacoes;

	public Consulta() {
	}

	public Consulta(Long id, LocalDateTime dataHora, String status, String anotacoes, Paciente paciente,
			Medico medico) {
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.anotacoes = anotacoes;
		this.paciente = paciente;
		this.medico = medico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnotacoes() {
		return anotacoes;
	}

	public void setAnotacoes(String anotacoes) {
		this.anotacoes = anotacoes;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Consulta consulta = (Consulta) o;
		return Objects.equals(id, consulta.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
