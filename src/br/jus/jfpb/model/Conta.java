package br.jus.jfpb.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
@SequenceGenerator(sequenceName="conta_seq", name="conta_id", allocationSize=1)
public class Conta extends AbstractEntityModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="conta_id")
	private Long id;
	private String cpf;
	private int banco;
    private int agencia;
    private String numeroDaConta;
    private String sequencial;
    private String processoJudicial;
    private String acaoJudiciaria;
    private String nomeBeneficiario;
    private String cDoBeneficiario;
    private String varaDeOrigem;
    private String ufDaVaraOrigem;
    private Date dataDoDeposito;
    private double saldoAtualizado;
    private String origemAcaoOrigianaria;
    private String sobrestamentoAtivo;
    private String comAlvara;
    private String saldoClass;
	
    
  //gets e setts
    public String getSaldoClass() {
		return saldoClass;
	}
	public void setSaldoClass(String saldoClass) {
		this.saldoClass = saldoClass;
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getBanco() {
		return banco;
	}
	public void setBanco(int banco) {
		this.banco = banco;
	}
	public double getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public String getNumeroDaConta() {
		return numeroDaConta;
	}
	public void setNumeroDaConta(String numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
	public String getSequencial() {
		return sequencial;
	}
	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}
	public String getProcessoJudicial() {
		return processoJudicial;
	}
	public void setProcessoJudicial(String processoJudicial) {
		this.processoJudicial = processoJudicial;
	}
	public String getAcaoJudiciaria() {
		return acaoJudiciaria;
	}
	public void setAcaoJudiciaria(String acaoJudiciaria) {
		this.acaoJudiciaria = acaoJudiciaria;
	}
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}
	public String getcDoBeneficiario() {
		return cDoBeneficiario;
	}
	public void setcDoBeneficiario(String cDoBeneficiario) {
		this.cDoBeneficiario = cDoBeneficiario;
	}
	public String getVaraDeOrigem() {
		return varaDeOrigem;
	}
	public void setVaraDeOrigem(String varaDeOrigem) {
		this.varaDeOrigem = varaDeOrigem;
	}
	public String getUfDaVaraOrigem() {
		return ufDaVaraOrigem;
	}
	public void setUfDaVaraOrigem(String ufDaVaraOrigem) {
		this.ufDaVaraOrigem = ufDaVaraOrigem;
	}
	public Date getDataDoDeposito() {
		return dataDoDeposito;
	}
	public void setDataDoDeposito(Date dataDoDeposito) {
		this.dataDoDeposito = dataDoDeposito;
	}
	public double getSaldoAtualizado() {
		return saldoAtualizado;
	}
	public void setSaldoAtualizado(double saldoAtualizado) {
		this.saldoAtualizado = saldoAtualizado;
	}
	public String getOrigemAcaoOrigianaria() {
		return origemAcaoOrigianaria;
	}
	public void setOrigemAcaoOrigianaria(String origemAcaoOrigianaria) {
		this.origemAcaoOrigianaria = origemAcaoOrigianaria;
	}
	public String getSobrestamentoAtivo() {
		return sobrestamentoAtivo;
	}
	public void setSobrestamentoAtivo(String sobrestamentoAtivo) {
		this.sobrestamentoAtivo = sobrestamentoAtivo;
	}
	public String getComAlvara() {
		return comAlvara;
	}
	public void setComAlvara(String comAlvara) {
		this.comAlvara = comAlvara;
	}	
}

//Desenvolvido por Yuri Santos