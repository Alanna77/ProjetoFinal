package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model {

	public String nome;
	public String matricula;
	public String curso;
	public String turma;
	public String tamanho;
	public int quantidade;
	
	
}

