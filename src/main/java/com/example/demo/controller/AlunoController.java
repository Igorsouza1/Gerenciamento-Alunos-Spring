package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlunoDao;
import com.example.demo.modal.Aluno;


@Controller
public class AlunoController {
	
	@Autowired
	private AlunoDao alunoDao;
	
	@GetMapping("/inseriralunos")
	public ModelAndView insertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/formaluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("InsertAlunos")
	public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors()) {
			mv.setViewName("aluno/formaluno");
			mv.addObject("aluno");
		}else {
		mv.setViewName("redirect:/aluno-adicionados");
		alunoDao.save(aluno);
		}	
		return mv;
	}
	
	@GetMapping("aluno-adicionados")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/listAlunos");
		mv.addObject("alunoList", alunoDao.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("aluno/alterar");
		Aluno aluno = alunoDao.getById(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoDao.save(aluno);
		mv.setViewName("redirect:/aluno-adicionados");
		return mv;
	}
	
	@GetMapping("/excluir/{id}")
	public String exlcuirAluno(@PathVariable Integer id) {
		alunoDao.deleteById(id);
		return "redirect:/aluno-adicionados";
	}
	
	@GetMapping("/filtro-alunos")
	public ModelAndView filtroAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/filtrosAlunos");
		return mv;		
	}
	
	@GetMapping("alunos-ativos")
	public ModelAndView listaAlunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/alunos-ativos");
		mv.addObject("alunosAtivos", alunoDao.findByStatusAtivos());
		return mv;
	}
	
	@GetMapping("alunos-inativos")
	public ModelAndView listaAlunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/alunos-inativos");
		mv.addObject("alunosInativos", alunoDao.findByStatusInativos());
		return mv;
	}
	
	@GetMapping("alunos-cancelados")
	public ModelAndView listaAlunosCancelados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/alunos-cancelados");
		mv.addObject("alunosCancelados", alunoDao.findByStatusCancelados());
		return mv;
	}
	
	@GetMapping("alunos-trancados")
	public ModelAndView listaAlunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aluno/alunos-trancados");
		mv.addObject("alunosTrancados", alunoDao.findByStatusTrancados());
		return mv;
	}
	
	@PostMapping("pesquisar-aluno")
	public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView();
		List<Aluno> listAlunos;
		if(nome == null || nome.trim().isEmpty()) {
			listAlunos = alunoDao.findAll();
		}else {
			listAlunos = alunoDao.findByNome(nome);
		}
		mv.addObject("listaDeAluno", listAlunos);
		mv.setViewName("aluno/pesquisa-resultado");
		return mv;
	}

	
}