 package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.modal.Aluno;

public interface AlunoDao extends JpaRepository<Aluno, Integer>{
	
	@Query(
			  value = "SELECT * FROM tb_aluno u WHERE u.status = 'ATIVO'", 
			  nativeQuery = true)
	public List<Aluno> findByStatusAtivos();
	
	@Query(
			  value = "SELECT * FROM tb_aluno u WHERE u.status = 'INATIVO'", 
			  nativeQuery = true)
	public List<Aluno> findByStatusInativos();
	
	@Query(
			  value = "SELECT * FROM tb_aluno u WHERE u.status = 'CANCELADO'", 
			  nativeQuery = true)
	public List<Aluno> findByStatusCancelados();
	
	@Query(
			  value = "SELECT * FROM tb_aluno u WHERE u.status = 'TRANCADO'", 
			  nativeQuery = true)
	public List<Aluno> findByStatusTrancados();
	
	public List<Aluno> findByNome(String nome);
	
}
