/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author vazig
 */
public class JDBCCliente {
    
    Connection conexao;

    public JDBCCliente(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirCliente(Cliente c){
        String sql = "insert into cliente (nome, cpf, rg, chave) values (?, ?, ?, ?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpf());
            ps.setString(3, c.getRg());
            ps.setInt(4, c.getChave());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
        }
    }
    
    public ResultSet listarEndereco(){
        String sql = "select * from endereco";
        
        try {
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
            return resposta;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public ArrayList<Cliente> listarCliente() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "select * from cliente";
        
        try {
            Statement declaracao = conexao.createStatement();
            ResultSet resposta = declaracao.executeQuery(sql);
            
            while(resposta.next()) {
                
                int codigo = resposta.getInt("codigo");
                String nome = resposta.getString("nome");
                String cpf = resposta.getString("cpf");
                String rg = resposta.getString("rg");
                //Object endereco = resposta.getObject("endereco_codigo");
                
                Cliente c = new Cliente(codigo, nome, cpf, rg);
                
                clientes.add(c);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return clientes;
    }
    
    
    public boolean excluir(String codigo){
        try {
            String sql = "delete from cliente where codigo=?";
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.executeUpdate();  
        } catch (SQLException ex) {
            Logger.getLogger(JDBCCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public Cliente encontraCodigoCliente(int codigo){
        String sql = "select * from cliente where codigo=?";
        Cliente cliente = new Cliente();
        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            cliente.setCodigo(rs.getInt("codigo"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setRg(rs.getString("rg"));
            //System.out.println("Imprimindo obj cliente: " + cliente);    
            }else{
                System.out.println("Cliente não existe!");
            }
            
        } catch (SQLException e) {
            return null;
        }
        return cliente;
    }
}
