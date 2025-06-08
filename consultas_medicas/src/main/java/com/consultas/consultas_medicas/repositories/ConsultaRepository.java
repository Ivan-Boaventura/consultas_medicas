package com.consultas.consultas_medicas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultas.consultas_medicas.model.Consulta;

public interface ConsultaRepository  extends JpaRepository<Consulta, Long>{

}
