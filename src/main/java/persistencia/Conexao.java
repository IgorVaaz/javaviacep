/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vazig
 */
public class Conexao {
    private Connection conexao;
    
    public Connection abrirConexao() throws SQLException {
        
        String url = "jdbc:mysql://localhost:3306/meuBanco?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "";
        
        conexao = DriverManager.getConnection(url, user, password);
        
        return conexao;
    }
    
    public void fecharConexao(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
