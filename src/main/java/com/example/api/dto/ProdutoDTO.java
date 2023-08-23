package com.example.api.dto;

public class ProdutoDTO {
	private Long id;
	private String nome;
	private Integer quantidade;
	private Double valor;
	private Double preco_unitario;
	private String image_path;
	
	
	public ProdutoDTO() {
		super();
	}
	
		
	public Double getPreco_unitario() {
		return preco_unitario;
	}



	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}


	public String getImage_path() {
		return image_path;
	}


	public void setImage_path(String image_path) {
		this.image_path = image_path;
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
	public void setValor(Double valor) {
		this.valor = valor;
	}

}
