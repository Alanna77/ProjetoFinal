package controllers;

import java.util.List;

import models.Aluno;

import play.mvc.Controller;

public class Alunos extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void detalhar(Aluno aluno) {
		render(aluno);
	}
	
	public static void salvar(Aluno aluno) {
		String mensagem = "Pedido registrado com sucesso!";
		if (aluno.id != null) {
			mensagem = "Pedido editado com sucesso!";
		}
		aluno.nome = aluno.nome.toUpperCase();
		aluno.matricula = aluno.matricula;
		aluno.curso = aluno.curso.toUpperCase();
		aluno.turma = aluno.turma;
		aluno.tamanho = aluno.tamanho.toUpperCase();
		aluno.quantidade = aluno.quantidade;
		aluno.save();
		flash.success(mensagem);
		listar(null);
	

		
	}
	
	public static void remover(Long id) {
		Aluno a = Aluno.findById(id);
		a.delete();
		flash.success("Pedido Cancelado com sucesso!");
		listar(null);
	}
	
	public static void listar(String termo) {
		List<Aluno> alunos = null;
		if (termo == null) {
			alunos = Aluno.findAll();
		} else {
			alunos = Aluno.find("lower(nome) like ?1 or lower(tamanho) like ?1 or lower(curso) like?1 or matricula like ?1 or turma like ?1",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(alunos, termo);
	}
	
	public static void editar(Long id) {
		Aluno a = Aluno.findById(id);
		renderTemplate("Alunos/form.html", a);
	}

	
	
}
