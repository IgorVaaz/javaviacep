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
import javax.swing.JTextField;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author vazig
 */
public class JDBCEndereco {
    
    Connection conexao;
    
    public JDBCEndereco(Connection conexao){
        this.conexao = conexao;
    }
    
    public Endereco inserirEndereco(Endereco e){
        String sql = "insert into endereco (rua, numero, complemento, bairro, cidade, estado) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, e.getRua());
            ps.setString(2, e.getNumero());
            ps.setString(3, e.getComplemento());
            ps.setString(4, e.getBairro());
            ps.setString(5, e.getCidade());
            ps.setString(6, e.getEstado());
            ps.executeUpdate();
        } catch (SQLException ex) {
        }
        return e;
    }
}
