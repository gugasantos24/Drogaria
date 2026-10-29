package br.com.fiap.model.entity;

import br.com.fiap.model.dto.RemedioDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Remedio")
@Table(name = "dddj_remedios")
public class Remedio {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private double preco;
    private LocalDate dataDeFabricacao;
    private LocalDate dataDeValidade;
    private String urlImagem;

    public Remedio() {
    }

    public Remedio(RemedioDTO remedioDTO) {
        this.nome = remedioDTO.nome();
        this.preco = remedioDTO.preco();
        this.dataDeFabricacao = remedioDTO.dataDeFabricacao();
        this.dataDeValidade = remedioDTO.dataDeValidade();
        this.urlImagem = remedioDTO.urlImagem();
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }


}
