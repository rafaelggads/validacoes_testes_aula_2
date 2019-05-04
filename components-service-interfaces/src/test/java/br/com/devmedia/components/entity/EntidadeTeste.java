package br.com.devmedia.components.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.devmedia.components.model.ModelBase;

@Entity
@Table(name = "ENTIDADE_TESTE")
public class EntidadeTeste implements ModelBase<Long> {

	private static final long serialVersionUID = -2522241519598944582L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}