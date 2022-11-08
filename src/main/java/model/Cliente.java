/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vazig
 */
public class Cliente {
    private int codigo;
    private String nome;
    private String cpf;
    private String rg;
    private int chave;

    public Cliente(String nome, String cpf, String rg, int chave) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.chave = chave;
    }

    public Cliente(int codigo, String nome, String cpf, String rg) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public Cliente() {
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    public int getChave(){
        return chave;
    }
    
    public void setChave(){
        this.chave = chave;
    }
}
