package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Iterable<Aluno> findAll(){
		Iterable<Aluno> listAluno = alunoRepository.findAll();
		return listAluno;
	}
	
	public Aluno save(Aluno aluno){
		return alunoRepository.save(aluno);
	}
	
	
	public Aluno buscarAlunoPeloRra(int ra) {
		Aluno response = alunoRepository.findByRa(ra);
		return response;
	}
	
	public String deletarAluno(int ra) {
		Aluno buscaRa = alunoRepository.findByRa(ra);
		alunoRepository.delete(buscaRa);
		return "Deleted Aluno with RA: "+ra;
	}
	public String deletarTodosAlunos() {
		alunoRepository.deleteAll();
		return "Deleted all registers";
	}
}
