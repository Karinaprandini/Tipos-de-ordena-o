package a3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class A3GUI extends JFrame {
    private JTextArea outputTextArea;

    public A3GUI() {
        // Define as configurações da GUI
        setTitle("Algoritmos de Ordenação"); // Título
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Parar o programa ao fechar
        setSize(400, 300); // Tamanho da janela
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new BorderLayout());// Define o layout
        getContentPane().setBackground(Color.WHITE); // Cor do fundo

        //--------------- Exibe o texto de saída ----------
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputTextArea.setBackground(Color.WHITE);
        //--------------------------------------------------
        
        // Permite fazer o scroll no texto de saída
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        
        // Cria o btão do selection sort e define a cor do botão
        JButton selectionSortButton = createButton("SelectionSort", Color.decode("#4CAF50"));
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput(); // Cria a caixa para o usuário digitar os valores no array
                if (array.length > 0){ // Chamar a função apenas se o array for maior que zero
                SelectionSort.selectionSort(array);
                appendOutput("Array utilizando SelectionSort: " + Arrays.toString(array));
                }
            }
        });

        // Cria o botão do selection sort e define a cor do botão
        JButton insertionSortButton = createButton("InsertionSort", Color.decode("#2196F3"));
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput(); // Cria a caixa para o usuário digitar os valores no array
                if (array.length > 0){ // Chamar a função apenas se o array for maior que zero
                InsertionSort.insertionSort(array);
                appendOutput("Array utilizando InsertionSort: " + Arrays.toString(array));
                }
            }
        });

        // Cria o btão do selection sort e define a cor do botão
        JButton shellSortButton = createButton("ShellSort", Color.decode("#FF5722"));
        shellSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput(); // Cria a caixa para o usuário digitar os valores no array
                if (array.length > 0){ // Chamar a função apenas se o array for maior que zero
                ShellSort.shellSort(array);
                appendOutput("Array utilizando ShellSort: " + Arrays.toString(array));
                }
            }
        });

        // Adiciona os botões e a posição deles
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(shellSortButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public int[] getUserInput() {
        String input = JOptionPane.showInputDialog(this, "Digite os valores separados por espaço:");
        if (input != null) {
            input = input.trim();
            if (!input.isEmpty()) {
                if (input.matches("\\d+(\\s+\\d+)*")) {
                    String[] inputValues = input.split("\\s+");
                    int[] array = new int[inputValues.length];
                    for (int i = 0; i < inputValues.length; i++) {
                        array[i] = Integer.parseInt(inputValues[i]);
                    }
                    return array;
                } else {
                    JOptionPane.showMessageDialog(this, "Digite apenas números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return getUserInput();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Digite pelo menos um número!", "Erro", JOptionPane.ERROR_MESSAGE);
                return getUserInput();
            }
        } else {
            return new int[0]; // Retorna um array vazio se o usuário clicar em "Cancelar"
        }
    }
    

    // Exibe o texto na tela
    public void appendOutput(String text) {
        outputTextArea.append(text + "\n");
    }

    public JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 30));
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                A3GUI gui = new A3GUI();
                gui.setVisible(true);
            }
        });
    }
}
