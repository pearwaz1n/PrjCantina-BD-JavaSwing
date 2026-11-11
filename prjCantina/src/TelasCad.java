
import DAO.ClienteDAO;
import classes.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro
 */
public class TelasCad extends javax.swing.JFrame {
    
    // vaiaveris para a tela de Vendas
    private List<classes.Cliente> listaClientesCombo;
    private List<classes.Produtos> listaProdutosCombo;
    private float totalVenda = 0.0f;        
    
    public TelasCad() {
        initComponents();
        preencheTabela();
        preencheTabelaProdutos();
        preencheComboBoxesVenda();
    }

    public void preencheTabela() {
    ClienteDAO cDAO = new ClienteDAO();
    List<Cliente> listaClientes = cDAO.getCliente();
    
 
    DefaultTableModel tabelaClientes = (DefaultTableModel) tbl_cliente.getModel();
   
    tabelaClientes.setRowCount(0);
    

    if (listaClientes != null) {
        for (Cliente c : listaClientes) {
            tabelaClientes.addRow(new Object[]{
                c.getId_cliente(),
                c.getNome(),
                c.getTelefone()
            });
        }
    }
}
    public void preencheTabelaProdutos() {
    DAO.ProdutosDAO pDAO = new DAO.ProdutosDAO();
    List<classes.Produtos> listaProdutos = pDAO.getProdutos();
         
    javax.swing.table.DefaultTableModel tabelaProdutos = (javax.swing.table.DefaultTableModel) jTable2.getModel();
    tabelaProdutos.setRowCount(0);
         
    if (listaProdutos != null) {
        for (classes.Produtos p : listaProdutos) {
            tabelaProdutos.addRow(new Object[]{
                p.getId(),
                p.getNomeProduto(),
                String.format("R$ %.2f", p.getValorProduto()), // Formatado com R$ 
                p.getDataValidade()
            });
        }
    }
}
    public void preencheComboBoxesVenda() {
        // carrega clientes
        DAO.ClienteDAO cDAO = new DAO.ClienteDAO();
        listaClientesCombo = cDAO.getCliente();
        jComboBoxCliente.removeAllItems();
        if (listaClientesCombo != null) {
            for (classes.Cliente c : listaClientesCombo) {
                jComboBoxCliente.addItem(c.getNome());
            }
        }
        
        // carrega produtos
        DAO.ProdutosDAO pDAO = new DAO.ProdutosDAO();
        listaProdutosCombo = pDAO.getProdutos();
        jComboBox2.removeAllItems();
        if (listaProdutosCombo != null) {
            for (classes.Produtos p : listaProdutosCombo) {
                // mostra o nome e o valor em R$
                jComboBox2.addItem(p.getNomeProduto() + " - " + String.format("R$ %.2f", p.getValorProduto()));
            }
        }
        
        // Limpa a tabela do carrinho
       
        javax.swing.table.DefaultTableModel carrinho = (javax.swing.table.DefaultTableModel) jTable3.getModel();
        carrinho.setRowCount(0);
        carrinho.setColumnIdentifiers(new Object[]{"ID", "Produto", "Qtd", "Valor Unit.", "Subtotal"});
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        txt_telefone = new javax.swing.JTextField();
        btn_salvar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_cliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nomeP = new javax.swing.JTextField();
        txt_valorP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dataValidade = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btn_salvarP = new javax.swing.JButton();
        btn_editarP = new javax.swing.JButton();
        btn_excluirP = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        btn_encomenda = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_quantidadeV = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bnt_pdf = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Telefone:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Dados dos Clientes:");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        txt_telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefoneKeyTyped(evt);
            }
        });

        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_excluir.setText("Excluir");
        btn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirActionPerformed(evt);
            }
        });

        tbl_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone"
            }
        ));
        tbl_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_cliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(426, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(186, 186, 186))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_salvar)
                    .addComponent(btn_editar)
                    .addComponent(btn_excluir))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("TelaClientes", jPanel1);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Registro de Produtos:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Nome do Produto:");

        txt_valorP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valorPKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Valor do Produto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Data de Validade:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "NomeProduto", "ValorProduto", "DataValidade"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btn_salvarP.setText("Salvar");
        btn_salvarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarPActionPerformed(evt);
            }
        });

        btn_editarP.setText("Editar");
        btn_editarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarPActionPerformed(evt);
            }
        });

        btn_excluirP.setText("Excluir");
        btn_excluirP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excluirPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_valorP)
                    .addComponent(dataValidade, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(txt_nomeP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(633, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(341, 341, 341))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_salvarP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_editarP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_excluirP, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_nomeP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txt_valorP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(dataValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_excluirP)
                    .addComponent(btn_salvarP)
                    .addComponent(btn_editarP))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TelaProdutos", jPanel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Dados da Venda");

        jComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cliente:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Data da Venda:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Status da Venda:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A Receber", "Pago", "Cancelada", " ", " " }));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Adicionar à Encomenda: ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Produto:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_encomenda.setText("Adicionar encomenda");
        btn_encomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_encomendaActionPerformed(evt);
            }
        });

        jLabel14.setText("Quantidade:");

        txt_quantidadeV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_quantidadeVKeyTyped(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel15.setText("Total a pagar:");

        jLabel16.setText("0");

        bnt_pdf.setText("Gerar pdf");
        bnt_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_pdfActionPerformed(evt);
            }
        });

        jButton1.setText("Finalizar encomenda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_quantidadeV, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_encomenda))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnt_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(571, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jLabel12)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_quantidadeV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_encomenda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bnt_pdf))
                .addContainerGap(136, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("TelaVendas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void btn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirActionPerformed
    //botao de escluir clientes
        int linhaSelecionada = tbl_cliente.getSelectedRow();
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para excluir!");
        return;
    }
    int resposta = javax.swing.JOptionPane.showConfirmDialog(
        this, 
        "Deseja realmente excluir este cliente?", 
        "Atenção", 
        javax.swing.JOptionPane.YES_NO_OPTION
    );
    
    if (resposta == javax.swing.JOptionPane.YES_OPTION) {
        //Pega o ID da linha selecionada
        int id = Integer.parseInt(tbl_cliente.getValueAt(linhaSelecionada, 0).toString());
        
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.excluir(id);
       
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso!");
        
        txt_nome.setText("");
        txt_telefone.setText("");
        preencheTabela();
    }

    }//GEN-LAST:event_btn_excluirActionPerformed

    private void bnt_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_pdfActionPerformed
   // Botão Gerar PDF
   try {
        int indexCliente = jComboBoxCliente.getSelectedIndex();
        if (indexCliente == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para gerar o comprovante!");
            return;
        }
        String nomeCliente = jComboBoxCliente.getSelectedItem().toString();
        String dataVenda = jDateChooser1.getDate() != null ? jDateChooser1.getDate().toString() : "Data Atual";
        String statusVenda = jComboBox1.getSelectedItem().toString();

        javax.swing.table.DefaultTableModel carrinho = (javax.swing.table.DefaultTableModel) jTable3.getModel();
        if (carrinho.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "O carrinho está vazio para gerar o PDF!");
            return;
        }

        // Monta o conteúdo HTML do Comprovante com o QR Code padrão
        StringBuilder html = new StringBuilder();
        html.append("<html><body style='font-family: Arial; padding: 20px;'>");
        html.append("<h2 style='text-align: center;'>Comprovante de Encomenda - Cantina</h2>");
        html.append("<hr>");
        html.append("<p><b>Cliente:</b> ").append(nomeCliente).append("</p>");
        html.append("<p><b>Data:</b> ").append(dataVenda).append("</p>");
        html.append("<p><b>Status:</b> ").append(statusVenda).append("</p>");
        
        html.append("<h3>Itens da Encomenda:</h3>");
        html.append("<table border='1' cellspacing='0' cellpadding='5' width='100%'>");
        html.append("<tr style='background-color: #f2f2f2;'><th>Produto</th><th>Qtd</th><th>Valor Unit.</th><th>Subtotal</th></tr>");
        
        for (int i = 0; i < carrinho.getRowCount(); i++) {
            html.append("<tr>");
            html.append("<td>").append(carrinho.getValueAt(i, 1)).append("</td>");
            html.append("<td align='center'>").append(carrinho.getValueAt(i, 2)).append("</td>");
            html.append("<td align='right'>").append(carrinho.getValueAt(i, 3)).append("</td>");
            html.append("<td align='right'>").append(carrinho.getValueAt(i, 4)).append("</td>");
            html.append("</tr>");
        }
        html.append("</table>");
        
        html.append("<h3 style='text-align: right;'>Total: ").append(jLabel16.getText()).append("</h3>");
        
        // QR Code padrão integrado via API pública para demonstração na faculdade
        html.append("<br><div style='text-align: center;'>");
        html.append("<p><b>Escaneie o QR Code para validar o pedido:</b></p>");
        html.append("<img src='https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=Pedido-Cantina-").append(nomeCliente.replace(" ", "")).append("' />");
        html.append("</div>");
        
        html.append("</body></html>");

        // Salva como arquivo HTML usando codificação UTF-8 correta
        java.io.File arquivoHtml = new java.io.File("comprovante_venda.html");
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(arquivoHtml), "UTF-8"));
        bw.write(html.toString());
        bw.close();

        // Abre no navegador padrão (basta apertar Ctrl+P no navegador para salvar em PDF)
        java.awt.Desktop.getDesktop().browse(arquivoHtml.toURI());
        
        JOptionPane.showMessageDialog(this, "Comprovante gerado com sucesso! Pressione Ctrl+P no navegador para salvar como PDF.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao gerar comprovante: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_bnt_pdfActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        //criando objeto cliente
        
        //validaocao telefone
    String telefone = txt_telefone.getText().trim();
    if (telefone.length() != 10 && telefone.length() != 11) {
        javax.swing.JOptionPane.showMessageDialog(this, "Telefone inválido! Digite o DDD seguido do número (10 ou 11 dígitos).");
        return; // Para a execução e não salva
    }

    // se passou na validação cria cliente
    Cliente c = new Cliente();
    c.setNome(txt_nome.getText());
    c.setTelefone(telefone);
          
    ClienteDAO cDAO = new ClienteDAO();
    cDAO.inserir(c);
    
    javax.swing.JOptionPane.showMessageDialog(this, "Cliente salvo com sucesso!");

    // limpar
    txt_nome.setText("");
    txt_telefone.setText("");          
    preencheTabela();
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        //botao de salvar clientes
    int linhaSelecionada = tbl_cliente.getSelectedRow();
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela para editar!");
        return;
    }
   
    // cria o objeto cliente com os novos dados dos campos de texto
    Cliente c = new Cliente();
    // pega o ID da coluna 0 da linha selecionada
    int id = Integer.parseInt(tbl_cliente.getValueAt(linhaSelecionada, 0).toString());
    c.setId_cliente(id);
    c.setNome(txt_nome.getText());
    c.setTelefone(txt_telefone.getText());
    
    ClienteDAO cDAO = new ClienteDAO();
    cDAO.editar(c);
    
    javax.swing.JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
    
    txt_nome.setText("");
    txt_telefone.setText("");
    preencheTabela();

    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_salvarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarPActionPerformed
        //botao de salvar produtos
        try {
        classes.Produtos p = new classes.Produtos();
        p.setNomeProduto(txt_nomeP.getText());
        p.setValorProduto(Float.parseFloat(txt_valorP.getText().replace(",", ".")));
        
        // convertendo a data p sql
        java.util.Date dataSelecionada = dataValidade.getDate();
        if (dataSelecionada != null) {
            p.setDataValidade(new java.sql.Date(dataSelecionada.getTime()));
        }
        
        DAO.ProdutosDAO pDAO = new DAO.ProdutosDAO();
        pDAO.inserir(p);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
        
        // limpar
        txt_nomeP.setText("");
        txt_valorP.setText("");
        dataValidade.setDate(null);
        preencheTabelaProdutos();
        
    } catch(Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar: Verifique os dados digitados.");
    }

    }//GEN-LAST:event_btn_salvarPActionPerformed

    private void btn_editarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarPActionPerformed
        //botao editar produto
        int linhaSelecionada = jTable2.getSelectedRow();
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para editar!");
        return;
    }
    
    try {
        classes.Produtos p = new classes.Produtos();
        int id = Integer.parseInt(jTable2.getValueAt(linhaSelecionada, 0).toString());
        p.setId(id);
        p.setNomeProduto(txt_nomeP.getText());
        p.setValorProduto(Float.parseFloat(txt_valorP.getText().replace(",", ".")));
        
        java.util.Date dataSelecionada = dataValidade.getDate();
        if (dataSelecionada != null) {
            p.setDataValidade(new java.sql.Date(dataSelecionada.getTime()));
        }
        
        DAO.ProdutosDAO pDAO = new DAO.ProdutosDAO();
        pDAO.editar(p);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        
        //limpar 
        txt_nomeP.setText("");
        txt_valorP.setText("");
        dataValidade.setDate(null);
        preencheTabelaProdutos();
        
    } catch(Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao editar: Verifique os dados.");
    }

    }//GEN-LAST:event_btn_editarPActionPerformed

    private void btn_excluirPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excluirPActionPerformed
    //Botao de excluir produto
    int linhaSelecionada = jTable2.getSelectedRow();
    if (linhaSelecionada == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto na tabela para excluir!");
        return;
    }
    
    int resposta = javax.swing.JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este produto?", "Atenção", javax.swing.JOptionPane.YES_NO_OPTION);
    if (resposta == javax.swing.JOptionPane.YES_OPTION) {
        int id = Integer.parseInt(jTable2.getValueAt(linhaSelecionada, 0).toString());
        
        DAO.ProdutosDAO pDAO = new DAO.ProdutosDAO();
        pDAO.excluir(id);
        
        javax.swing.JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
        txt_nomeP.setText("");
        txt_valorP.setText("");
        dataValidade.setDate(null);
        preencheTabelaProdutos();
    }
    }//GEN-LAST:event_btn_excluirPActionPerformed

    private void txt_quantidadeVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantidadeVKeyTyped
       // metodo para aceitar  apenas letras p Quantidade
    char c = evt.getKeyChar();
    if (!Character.isDigit(c)) {
        evt.consume(); // o que não for número vai ser ignorado 
    }
    }//GEN-LAST:event_txt_quantidadeVKeyTyped

    private void txt_valorPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorPKeyTyped
       // metodo para aceitar apenas letras p Produto                               
    char c = evt.getKeyChar();
    // permite apenas números, ponto, vírgula e teclas de controle
    if (!Character.isDigit(c) && c != '.' && c != ',' && c != java.awt.event.KeyEvent.VK_BACK_SPACE && c != java.awt.event.KeyEvent.VK_DELETE) {
        evt.consume();
    }
    }//GEN-LAST:event_txt_valorPKeyTyped

    private void btn_encomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encomendaActionPerformed
    //botao de adicionar encomenda                                             
    if (txt_quantidadeV.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Digite a quantidade!");
        return;
    }

    int indexProduto = jComboBox2.getSelectedIndex();
    if (indexProduto == -1 || listaProdutosCombo == null || listaProdutosCombo.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione um produto válido!");
        return;
    }

    classes.Produtos produtoSelecionado = listaProdutosCombo.get(indexProduto);
    int quantidade = Integer.parseInt(txt_quantidadeV.getText());
    float subtotal = produtoSelecionado.getValorProduto() * quantidade;

    // Adiciona na tabela do carrinho
    javax.swing.table.DefaultTableModel carrinho = (javax.swing.table.DefaultTableModel) jTable3.getModel();
    carrinho.addRow(new Object[]{
        produtoSelecionado.getId(),
        produtoSelecionado.getNomeProduto(),
        quantidade,
        String.format("R$ %.2f", produtoSelecionado.getValorProduto()),
        String.format("R$ %.2f", subtotal)
    });

    // Atualiza o total a pagar
    totalVenda += subtotal;
    jLabel16.setText(String.format("R$ %.2f", totalVenda));

    // Limpa o campo de quantidade
    txt_quantidadeV.setText("");

    }//GEN-LAST:event_btn_encomendaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //botao de finalizar encomenda
if (totalVenda == 0) {
    javax.swing.JOptionPane.showMessageDialog(this, "O carrinho está vazio!");
    return;
}

try {
    classes.Venda v = new classes.Venda();
    
    // pega o ID do Cliente Selecionado
    int indexCliente = jComboBoxCliente.getSelectedIndex();
    classes.Cliente clienteSelecionado = listaClientesCombo.get(indexCliente);
    v.setId_cliente(clienteSelecionado.getId_cliente());
    
    // data da Venda
    java.util.Date dataSelecionada = jDateChooser1.getDate();
    if (dataSelecionada != null) {
        v.setData_venda(new java.sql.Date(dataSelecionada.getTime()));
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Selecione a data da venda!");
        return;
    }
    
    // status da venda e total
    v.setStatus_venda(jComboBox1.getSelectedItem().toString());
    v.setValor_total(totalVenda);
    
    // salva a nova venda no banco e recupera o ID gerado
    DAO.VendaDAO vDAO = new DAO.VendaDAO();
    int idVendaGerada = vDAO.inserirVenda(v);
    
    if (idVendaGerada != -1) {
        // Percorre a tabela do carrinho para salvar os itens na tabela itens_venda
        javax.swing.table.DefaultTableModel carrinho = (javax.swing.table.DefaultTableModel) jTable3.getModel();
        for (int i = 0; i < carrinho.getRowCount(); i++) {
        int idProduto = Integer.parseInt(carrinho.getValueAt(i, 0).toString());  // Coluna 0: ID do produto
        int quantidade = Integer.parseInt(carrinho.getValueAt(i, 2).toString()); // Coluna 2: Quantidade
    
    // Limpa o "R$" e converte para float o Valor Unitário e o Subtotal
    float precoUnitario = Float.parseFloat(carrinho.getValueAt(i, 3).toString().replace("R$", "").replace(",", ".").trim());
    float subtotal = Float.parseFloat(carrinho.getValueAt(i, 4).toString().replace("R$", "").replace(",", ".").trim());
    
    vDAO.inserirItemVenda(idVendaGerada, idProduto, quantidade, precoUnitario, subtotal);
}
        
        javax.swing.JOptionPane.showMessageDialog(this, "Venda salva com sucesso!");
        
        // limpa toda a tela
        totalVenda = 0.0f;
        jLabel16.setText("R$ 0,00");
        txt_quantidadeV.setText("");
        jDateChooser1.setDate(null);
        carrinho.setRowCount(0); // Limpa a tabelinha de venda
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao gerar o ID da venda no banco de dados.");
    }
    
} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Erro ao finalizar venda: " + e.getMessage());
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_telefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefoneKeyTyped
     // vallidação do telefone para não poder texto nem ujm numero maior                           
    char c = evt.getKeyChar();
    // Se não for dígito  ou se já atingiu 11 caracteres bloqueia
    if (!Character.isDigit(c) || txt_telefone.getText().length() >= 11) {
        evt.consume();
    }
    }//GEN-LAST:event_txt_telefoneKeyTyped

    private void tbl_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clienteMouseClicked
   // Pega a linha que o usuário clicou para editar
    int linhaSelecionada = tbl_cliente.getSelectedRow();
    if (linhaSelecionada != -1) {
        // Joga os valores da tabela de volta nas caixas de texto
        txt_nome.setText(tbl_cliente.getValueAt(linhaSelecionada, 1).toString());
        txt_telefone.setText(tbl_cliente.getValueAt(linhaSelecionada, 2).toString());
    }

    }//GEN-LAST:event_tbl_clienteMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
         // Pega a linha que o usuário clicou para editar
    int linhaSelecionada = jTable2.getSelectedRow();
    if (linhaSelecionada != -1) {
        // Joga os valores da tabela de volta nas caixas de texto
        txt_nomeP.setText(jTable2.getValueAt(linhaSelecionada, 1).toString());
        txt_valorP.setText(jTable2.getValueAt(linhaSelecionada, 2).toString());
       // com o JDateChooser ele pega o objeto da tabela e converte
        java.util.Date data = (java.util.Date) jTable2.getValueAt(linhaSelecionada, 3);
        dataValidade.setDate(data);
    }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelasCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelasCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelasCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelasCad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelasCad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_pdf;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_editarP;
    private javax.swing.JButton btn_encomenda;
    private javax.swing.JButton btn_excluir;
    private javax.swing.JButton btn_excluirP;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_salvarP;
    private com.toedter.calendar.JDateChooser dataValidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxCliente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable tbl_cliente;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_nomeP;
    private javax.swing.JTextField txt_quantidadeV;
    private javax.swing.JTextField txt_telefone;
    private javax.swing.JTextField txt_valorP;
    // End of variables declaration//GEN-END:variables

}
