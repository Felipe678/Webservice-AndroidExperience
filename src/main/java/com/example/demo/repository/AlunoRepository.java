package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, String>{
	Aluno findByRa(int ra);
	void deleteByRa(int ra);
}
