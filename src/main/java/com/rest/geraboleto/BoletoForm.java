package com.rest.geraboleto;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
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
    private String[] instrucoes;
    private String[] locaisDePagamento;
    private String nomeBeneficiario;
    private String agencia;
    private String digitoAgencia;

    private String codigoBeneficiario;
    private String digitoCodigoBeneficiario;
    private String numeroConvenio;
    private String carteira;
    private String nossoNumero;
    private String digitoNossoNumero;
    private String formatoSaida;
    
    public String getFormatoSaida(){
        return formatoSaida;
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

    public String[] getInstrucoes() {
        return instrucoes;
    }

    public void setInstrucoes(String[] instrucoes) {
        this.instrucoes = instrucoes;
    }

    public String[] getLocaisDePagamento() {
        return locaisDePagamento;
    }

    public void setLocaisDePagamento(String[] locaisDePagamento) {
        this.locaisDePagamento = locaisDePagamento;
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

        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(datas)
                .comBeneficiario(beneficiario)
                //.comPagador(pagador)  
                .comValorBoleto(valorBoleto)
                .comNumeroDoDocumento(numeroDoDocumento)
                .comInstrucoes(instrucoes)
                .comLocaisDePagamento(locaisDePagamento);
        return boleto;
    }    
    
}
