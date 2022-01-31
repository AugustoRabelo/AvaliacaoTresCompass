package avaliacao.estado.controller.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import avaliacao.estado.model.Estado;
import avaliacao.estado.model.Regiao;


public class EstadoDto {
	
	private Long id;
	private String nome, capital;
	BigDecimal populacao;
	private BigDecimal area;
	private Regiao regiao;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.capital = estado.getCapital();
		this.area = estado.getArea();
		
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
	
	public static List<EstadoDto> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}
}
