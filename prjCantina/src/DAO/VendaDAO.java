
package DAO;

import classes.Venda;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Pedro
 */

public class VendaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public VendaDAO() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    // salva a Venda e retorna o ID que foi gerado no banco
    public int inserirVenda(Venda venda) {
        String sql = "INSERT INTO vendas (id_cliente, data_venda, status_venda, valor_total) VALUES (?, ?, ?, ?)";
        try {
            // RETURN_GENERATED_KEYS serve para devolver o ID gerado.
            PreparedStatement stmt = this.conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, venda.getId_cliente());
            stmt.setDate(2, venda.getData_venda());
            stmt.setString(3, venda.getStatus_venda());
            stmt.setFloat(4, venda.getValor_total());
            stmt.execute();
            
            // Pega o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // returna o ID da venda
            }
        } catch(SQLException ex) {
            System.out.println("Erro ao salvar venda: " + ex.getMessage());
        }
        return -1; // Retorna -1 se der erro
    }
    
    // salva cada produto da lista na tabela itens_venda
    public void inserirItemVenda(int idVenda, int idProduto, int quantidade, float precoUnitario, float subtotal) {
    String sql = "INSERT INTO itens_venda (id_venda, id_produto, quantidade, preco_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, idVenda);
        stmt.setInt(2, idProduto);
        stmt.setInt(3, quantidade);
        stmt.setFloat(4, precoUnitario);
        stmt.setFloat(5, subtotal);
        stmt.execute();
    } catch(SQLException ex) {
        System.out.println("Erro ao salvar item da venda: " + ex.getMessage());
    }
}
}