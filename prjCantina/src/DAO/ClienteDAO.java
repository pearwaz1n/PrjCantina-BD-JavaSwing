package DAO;

import classes.Cliente;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class ClienteDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ClienteDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    // Método para Inserir
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO pessoa (nome, telefone) VALUES (?, ?)"; 
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.execute();
            System.out.println("Cliente inserido com sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir cliente: " + ex.getMessage());
        }
    }
    
    // Método para Editar
    public void editar(Cliente cliente) {
        String sql = "UPDATE pessoa SET nome = ?, telefone = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setInt(3, cliente.getId_cliente());
            stmt.execute();
            System.out.println("Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }
    
    // Método para Excluir
    public void excluir(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Cliente excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir cliente: " + ex.getMessage());
        }
    }
    
    // Método GET
    public List<Cliente> getCliente() {
        String sql = "SELECT * FROM pessoa";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Cliente> listaClientes = new ArrayList<>();
            
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId_cliente(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                listaClientes.add(c);
            }
            return listaClientes;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar clientes: " + ex.getMessage());
            return null;
        }
    }
}