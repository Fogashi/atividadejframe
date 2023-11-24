package atividadeswing;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Color;

public class tela extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nm_produto;
    private JTextField vl_preco;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    tela frame = new tela();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public tela() {
    	setBackground(new Color(128, 255, 0));
    	setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
    	setResizable(false);
        setTitle("Cadastro JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 697, 299);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Produto");
        lblNewLabel.setForeground(new Color(128, 255, 0));
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 29));
        lblNewLabel.setBounds(11, 12, 323, 36);
        contentPane.add(lblNewLabel);

        nm_produto = new JTextField();
        nm_produto.setBounds(89, 68, 170, 22);
        contentPane.add(nm_produto);
        nm_produto.setColumns(10);

        vl_preco = new JTextField();
        vl_preco.setColumns(10);
        vl_preco.setBounds(89, 111, 170, 22);
        contentPane.add(vl_preco);

        JLabel lblNewLabel_1 = new JLabel("Produto:");
        lblNewLabel_1.setForeground(new Color(128, 255, 0));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblNewLabel_1.setBounds(13, 73, 60, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Preço (R$):");
        lblNewLabel_1_1.setForeground(new Color(128, 255, 0));
        lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblNewLabel_1_1.setBounds(11, 116, 82, 15);
        contentPane.add(lblNewLabel_1_1);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(424, 30, 247, 219);
        contentPane.add(textArea);

        

        JButton btnCadastrar = new JButton("CADASTRAR");
        btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String produtoNome = nm_produto.getText();
                String preco = vl_preco.getText();

                Produto novoProduto = new Produto(produtoNome, preco,"");
                produtos.add(novoProduto);

                nm_produto.setText("");
                vl_preco.setText("");
                

                textArea.setText("Todos os Produtos:\n");
                produtos.forEach(produto -> textArea.setText(
                		"Os dados cadastrados são" + "\n"
                		+ "O nome é: " + produto.getNome() + "\n"
                		+ "O valor é: " + produto.getPreco() + "\n"));
                
              
            }
        });
        btnCadastrar.setBounds(104, 165, 135, 36);
        contentPane.add(btnCadastrar);
        
        JLabel lblNewLabel_3 = new JLabel("Exibir Produtos:");
        lblNewLabel_3.setForeground(new Color(128, 255, 0));
        lblNewLabel_3.setBounds(424, 5, 201, 14);
        contentPane.add(lblNewLabel_3);
        
        
    }

    public class Produto {
        private String nome;
        private String preco;
        private String tipo;

        public Produto(String nome, String preco, String tipo) {
            this.nome = nome;
            this.preco = preco;
            this.tipo = tipo;
        }

        public String getNome() {
            return nome;
        }
        public String getTipo() {
            return tipo;
        }

        public String getPreco() {
            return preco;
        }
    }
}
