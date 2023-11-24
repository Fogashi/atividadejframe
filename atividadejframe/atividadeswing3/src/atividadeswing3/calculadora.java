package atividadeswing3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;

class CalculadoraNumeros {
    public static double calcularMedia(ArrayList<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        return (double) soma / numeros.size();
    }
}

public class calculadora extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField numeroField1;
    private JTextField numeroField2;
    private JTextArea resultadoArea;

    public calculadora() {
    	getContentPane().setBackground(Color.DARK_GRAY);
    	getContentPane().setForeground(Color.DARK_GRAY);
        setTitle("CalcularJframe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(658, 334);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setForeground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 618, 236);
        JLabel label1 = new JLabel("Número 1:");
        label1.setForeground(new Color(128, 255, 0));
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        label1.setBounds(10, 71, 74, 14);
        JLabel label2 = new JLabel("Número 2:");
        label2.setForeground(new Color(128, 255, 0));
        label2.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        label2.setBounds(10, 110, 60, 14);
        numeroField1 = new JTextField(10);
        numeroField1.setBounds(79, 69, 86, 20);
        numeroField2 = new JTextField(10);
        numeroField2.setBounds(79, 121, 86, 20);
        JButton calcularButton = new JButton("Calcular Média");
        calcularButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        calcularButton.setBounds(50, 174, 133, 23);
        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setBounds(271, 67, 164, 94);
        resultadoArea.setEditable(false);
        panel.setLayout(null);

        
        panel.add(label1);
        panel.add(numeroField1);
        panel.add(label2);
        panel.add(numeroField2);
        panel.add(calcularButton);
        panel.add(resultadoArea);

       
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Calcular média");
        lblNewLabel.setForeground(new Color(128, 255, 0));
        lblNewLabel.setBackground(new Color(128, 255, 0));
        lblNewLabel.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 47));
        lblNewLabel.setBounds(7, 0, 329, 60);
        panel.add(lblNewLabel);

        
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int numero1 = Integer.parseInt(numeroField1.getText().trim());
                    int numero2 = Integer.parseInt(numeroField2.getText().trim());

                   
                    ArrayList<Integer> numeros = new ArrayList<>();
                    numeros.add(numero1);
                    numeros.add(numero2);

                   
                    double media = CalculadoraNumeros.calcularMedia(numeros);

                    
                    resultadoArea.setText("Média dos números: " + media);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculadora().setVisible(true);
            }
        });
    }
}
