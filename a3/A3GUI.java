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
        setTitle("Algoritmos de Ordenação");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240));

        // Cria o painel superior com os botões
        JPanel buttonPanel = createButtonPanel();

        // Cria o painel inferior para a saída de texto
        JPanel textPanel = createTextPanel();

        // Adiciona os painéis à janela principal
        add(buttonPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));

        JButton selectionSortButton = createButton("SelectionSort", new Color(46, 134, 193), Color.WHITE);
        JButton insertionSortButton = createButton("InsertionSort", new Color(92, 184, 92), Color.WHITE);
        JButton shellSortButton = createButton("ShellSort", new Color(240, 173, 78), Color.WHITE);
        JButton resetButton = createButton("Limpar", new Color(217, 83, 79), Color.WHITE);

        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput();
                if (array.length > 0) {
                    SelectionSort.selectionSort(array);
                    appendOutput("Array utilizando SelectionSort: " + Arrays.toString(array));
                }
            }
        });

        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput();
                if (array.length > 0) {
                    InsertionSort.insertionSort(array);
                    appendOutput("Array utilizando InsertionSort: " + Arrays.toString(array));
                }
            }
        });

        shellSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = getUserInput();
                if (array.length > 0) {
                    ShellSort.shellSort(array);
                    appendOutput("Array utilizando ShellSort: " + Arrays.toString(array));
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextArea.setText("");
            }
        });

        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(shellSortButton);
        buttonPanel.add(resetButton);

        return buttonPanel;
    }

    private JPanel createTextPanel() {
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(Color.WHITE);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        textPanel.add(scrollPane, BorderLayout.CENTER);

        return textPanel;
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
            return new int[0];
        }
    }

    public void appendOutput(String text) {
        outputTextArea.append(text + "\n");
    }

    public JButton createButton(String text, Color backgroundColor, Color textColor) {
        JButton button = new JButton(text);
        button.setBackground(backgroundColor);
        button.setForeground(textColor);
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
