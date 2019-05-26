package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.AlunoService;

@RestController
@RequestMapping({"/Aluno"})
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/{ra}")
	public Aluno getByRa(@PathVariable("ra") int ra) {
		return alunoService.buscarAlunoPeloRra(ra);
	}
	
	
	@GetMapping({"/getAll"})
	public Iterable<Aluno> findAll(){
		Iterable<Aluno> response = alunoService.findAll();
		return response;
	}
	
	@PostMapping({"/cadastrarAluno"})
	public Aluno create(@RequestBody Aluno aluno,BindingResult bindingResult) {
		Aluno response = alunoService.save(aluno);
		return response;
	}
	
	
	@DeleteMapping(value = "/{ra}")
	public void delete(@PathVariable int ra) {
		alunoService.deletarAluno(ra);
	}
	@DeleteMapping({"/deletarTodos"})
	public void deleteAll() {
		alunoService.deletarTodosAlunos();
	}
	@PutMapping(value = "/{ra}")
	public Aluno update(@PathVariable(value = "ra") int ra,@Valid @RequestBody Aluno aluno) {
		Aluno response = alunoService.buscarAlunoPeloRra(ra);
		response.setRa(aluno.getRa());
		response.setNome(aluno.getNome());
		response.setEmail(aluno.getEmail());
		response.setCurso(aluno.getCurso());
		response.setTelefone(aluno.getTelefone());
		response.setNota1(aluno.getNota1());
		response.setNota2(aluno.getNota2());
		response.setNota3(aluno.getNota3());
		response.setNota4(aluno.getNota4());
		Aluno updatedAluno = alunoService.save(response);
		return updatedAluno;
	}
}
