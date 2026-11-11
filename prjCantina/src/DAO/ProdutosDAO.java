package DAO;

import classes.Produtos;
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


public class ProdutosDAO {
    private Conexao conexao;
    private Connection conn;
    
    public ProdutosDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    // Método para Inserir
    public void inserir(Produtos produto) {
        String sql = "INSERT INTO produto (nome, valor, data_validade) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setFloat(2, produto.getValorProduto());
            stmt.setDate(3, produto.getDataValidade());
            stmt.execute();
            System.out.println("Produto inserido com sucesso!");
        } catch(SQLException ex) {
            System.out.println("Erro ao inserir produto: " + ex.getMessage());
        }
    }
    
    // Método para Editar
    public void editar(Produtos produto) {
        String sql = "UPDATE produto SET nome = ?, valor = ?, data_validade = ? WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setFloat(2, produto.getValorProduto());
            stmt.setDate(3, produto.getDataValidade());
            stmt.setInt(4, produto.getId());
            stmt.execute();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar produto: " + ex.getMessage());
        }
    }
    
    // Método para Excluir
    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Produto excluído com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir produto: " + ex.getMessage());
        }
    }
    
    // Método para consultar todos
    public List<Produtos> getProdutos() {
    String sql = "SELECT * FROM produto";
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Produtos> listaProdutos = new ArrayList<>();
                      
        while (rs.next()) {
            Produtos p = new Produtos();
            p.setId(rs.getInt("Id")); 
            p.setNomeProduto(rs.getString("nome")); 
            p.setValorProduto(rs.getFloat("valor"));
            p.setDataValidade(rs.getDate("data_validade"));
            listaProdutos.add(p);
        }
        return listaProdutos;
    } catch (SQLException ex) {
        System.out.println("Erro ao consultar produtos: " + ex.getMessage());
        return null;
    }
}
}