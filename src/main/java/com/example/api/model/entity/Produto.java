package com.example.api.model.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto", schema = "eletronico")
public class Produto {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "quantidade" , nullable = false)
	private Integer quantidade;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
		
	@Column(name = "image_path", nullable = false)
	private String image_path;
	
	@Column(name = "preco_unitario", nullable = false)
	private Double preco_unitario;
	
	//@ManyToOne
	//@JoinColumn(name = "id_usuario")
	//private Usuario usuario;
	
	
	


	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double d) {
		this.valor = d;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, quantidade, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(valor, other.valor);
	}

	
	
	
}
