package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;

@RestController
@RequestMapping({"/Aluno"})
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	
	@GetMapping({"/getAll"})
	public Iterable<Aluno> findAll(){
		Iterable<Aluno> response = alunoService.findAll();
		return response;
	}
	
	@PostMapping({"/Create"})
	public Aluno create(@RequestBody Aluno aluno,BindingResult bindingResult) {
		Aluno response = alunoService.save(aluno);
		return response;
	}
	
	@DeleteMapping(value = "/{ra}")
	public void delete(@PathVariable int ra) {
		alunoService.deletarAluno(ra);
	}
	@PutMapping(value = "/{ra}")
	public Aluno update(@PathVariable("ra") int ra, @RequestBody Aluno aluno) {
		Aluno response = alunoService.editarAluno(ra,aluno);
		return response;
	}
}
