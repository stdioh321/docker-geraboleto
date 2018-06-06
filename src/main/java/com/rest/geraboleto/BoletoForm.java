package com.rest.geraboleto;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.Bancos;
import java.math.BigDecimal;
import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

public class BoletoForm {

    private String numeroDoBanco;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar dataDocumento;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar dataProcessamento;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Calendar dataVencimento;

    private BigDecimal valorBoleto;
    private String numeroDoDocumento;
    
    private String instrucao1;
    private String instrucao2;
    private String instrucao3;
    private String instrucao4;
    private String instrucao5;
    
    private String localDePagamento1;
    private String localDePagamento2;
    
    private String nomeBeneficiario;
    private String agencia;
    private String digitoAgencia;

    private String codigoBeneficiario;
    private String digitoCodigoBeneficiario;
    private String numeroConvenio;
    private String carteira;
    private String nossoNumero;
    private String digitoNossoNumero;
    
    private String pagadorDocumento;
    private String pagadorNome;
    
    private String formatoSaida;
    
    public String getFormatoSaida(){
        return formatoSaida;
    }
    
    public void setFormatoSaida(String formatoSaida) {
    	this.formatoSaida = formatoSaida;
    }

    public String getNumeroDoBanco() {
        return numeroDoBanco;
    }

    public void setNumeroDoBanco(String numeroDoBanco) {
        this.numeroDoBanco = numeroDoBanco;
    }

    public Calendar getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(Calendar dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public Calendar getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(Calendar dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    public String getNumeroDoDocumento() {
        return numeroDoDocumento;
    }

    public void setNumeroDoDocumento(String numeroDoDocumento) {
        this.numeroDoDocumento = numeroDoDocumento;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getCodigoBeneficiario() {
        return codigoBeneficiario;
    }

    public void setCodigoBeneficiario(String codigoBeneficiario) {
        this.codigoBeneficiario = codigoBeneficiario;
    }

    public String getDigitoCodigoBeneficiario() {
        return digitoCodigoBeneficiario;
    }

    public void setDigitoCodigoBeneficiario(String digitoCodigoBeneficiario) {
        this.digitoCodigoBeneficiario = digitoCodigoBeneficiario;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getDigitoNossoNumero() {
        return digitoNossoNumero;
    }

    public void setDigitoNossoNumero(String digitoNossoNumero) {
        this.digitoNossoNumero = digitoNossoNumero;
    }
    
    public String getPagadorDocumento() {
		return pagadorDocumento;
	}

	public void setPagadorDocumento(String pagadorDocumento) {
		this.pagadorDocumento = pagadorDocumento;
	}

	public String getPagadorNome() {
		return pagadorNome;
	}

	public void setPagadorNome(String pagadorNome) {
		this.pagadorNome = pagadorNome;
	}
	
	public String getInstrucao1() {
		return instrucao1;
	}

	public void setInstrucao1(String instrucao1) {
		this.instrucao1 = instrucao1;
	}

	public String getInstrucao2() {
		return instrucao2;
	}

	public void setInstrucao2(String instrucao2) {
		this.instrucao2 = instrucao2;
	}

	public String getInstrucao3() {
		return instrucao3;
	}

	public void setInstrucao3(String instrucao3) {
		this.instrucao3 = instrucao3;
	}

	public String getInstrucao4() {
		return instrucao4;
	}

	public void setInstrucao4(String instrucao4) {
		this.instrucao4 = instrucao4;
	}

	public String getInstrucao5() {
		return instrucao5;
	}

	public void setInstrucao5(String instrucao5) {
		this.instrucao5 = instrucao5;
	}

	public String getLocalDePagamento1() {
		return localDePagamento1;
	}

	public void setLocalDePagamento1(String localDePagamento1) {
		this.localDePagamento1 = localDePagamento1;
	}

	public String getLocalDePagamento2() {
		return localDePagamento2;
	}

	public void setLocalDePagamento2(String localDePagamento2) {
		this.localDePagamento2 = localDePagamento2;
	}

	public Boleto toBoleto(){
        Banco banco = Bancos.getPorNumero(numeroDoBanco);

        Datas datas = Datas.novasDatas()
                .comDocumento(dataDocumento)
                .comProcessamento(dataProcessamento)
                .comVencimento(dataVencimento);

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario(nomeBeneficiario)
                .comAgencia(agencia).comDigitoAgencia(digitoAgencia)
                .comCodigoBeneficiario(codigoBeneficiario)
                .comDigitoCodigoBeneficiario(digitoCodigoBeneficiario)
                .comNumeroConvenio(numeroConvenio)
                .comCarteira(carteira)
                //.comEndereco(enderecoBeneficiario)
                .comNossoNumero(nossoNumero)
                .comDigitoNossoNumero(digitoNossoNumero);

        Pagador pagador = Pagador.novoPagador()
        		.comDocumento(pagadorDocumento)
        		.comNome(pagadorNome);
        
        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)  
                .comValorBoleto(valorBoleto)
                .comNumeroDoDocumento(numeroDoDocumento)
                .comInstrucoes(instrucao1, instrucao2, instrucao3, instrucao4, instrucao5)
                .comLocaisDePagamento(localDePagamento1, localDePagamento2);
        return boleto;
    }    
    
}
