package avaliacao.estado.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome, capital;
	private BigDecimal populacao, area;
	@Enumerated(EnumType.STRING)
	private Regiao regiao;
	
	
	public Estado() {
		
	}

	public Estado(String nome, Regiao regiao, BigDecimal populacao, String capital,  BigDecimal area) {
		this.nome = nome;
		this.capital = capital;
		this.populacao = populacao;
		this.area = area;
		this.regiao = regiao;
	}


	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCapital() {
		return capital;
	}

	public BigDecimal getPopulacao() {
		return populacao;
	}

	public BigDecimal getArea() {
		return area;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setPopulacao(BigDecimal populacao) {
		this.populacao = populacao;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	
	
	
	
}
