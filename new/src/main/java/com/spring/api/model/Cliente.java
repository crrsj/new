package com.spring.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

  @Entity 
  @SequenceGenerator(name = "seq_cliente",sequenceName = "sequence_cliente",allocationSize = 1, initialValue = 1)
  public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")
	private Long id;
	private String nome;	
	private String cpf;
	private String telefone;
	private String placa;
	private String seguradora;
	@Temporal(TemporalType.DATE)
	private Date inicioVig = new Date();
	@Temporal(TemporalType.DATE)
	private Date fimVig;
	private double franquia;
	private double valordoSeguro;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(String seguradora) {
		this.seguradora = seguradora;
	}
	public Date getInicioVig() {
		return inicioVig;
	}
	public void setInicioVig(Date inicioVig) {
		this.inicioVig = inicioVig;
	}
	public Date getFimVig() {
		return fimVig;
	}
	public void setFimVig(Date fimVig) {
		this.fimVig = fimVig;
	}
	public double getFranquia() {
		return franquia;
	}
	public void setFranquia(double franquia) {
		this.franquia = franquia;
	}
	public double getValordoSeguro() {
		return valordoSeguro;
	}
	public void setValordoSeguro(double valordoSeguro) {
		this.valordoSeguro = valordoSeguro;
	}
	
	
	
	
}



