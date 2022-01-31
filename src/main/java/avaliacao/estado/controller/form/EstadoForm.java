package avaliacao.estado.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import avaliacao.estado.model.Estado;
import avaliacao.estado.model.Regiao;
import avaliacao.estado.repository.EstadoRepository;

public class EstadoForm {
	
	@NotNull @NotEmpty
	private String nome, capital;
	@NotNull @Min(value = 0)
	private BigDecimal populacao, area;
	@NotNull
	private Regiao regiao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public BigDecimal getPopulacao() {
		return populacao;
	}
	public void setPopulacao(BigDecimal populacao) {
		this.populacao = populacao;
	}
	public BigDecimal getArea() {
		return area;
	}
	public void setArea(BigDecimal area) {
		this.area = area;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
	public Estado converter(EstadoRepository estadoRepository) {
		return new Estado(nome, regiao, populacao, capital, area);
	}
	
	
}
