package com.sas.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.desafio.model.Questao;
import com.sas.desafio.model.RespostaAluno;
import com.sas.desafio.model.tipos.TipoNivel;

public interface RespostaAlunoRepository extends JpaRepository<RespostaAluno, Long> {

	@Query("SELECT ra FROM RespostaAluno ra WHERE aluno_id = ?1")
	List<RespostaAluno> findAllByAluno(Long alunoId);

	@Query("SELECT ra FROM RespostaAluno ra WHERE aluno_id = ?1 AND simulado_id = ?2 AND prova_id = ?3 AND questao_id = ?4")
	List<RespostaAluno> findAlreadyExist(Long alunoId, Long simuladoId, Long provaId, Long questaoId);

}
