package a3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class A3GUI extends JFrame {
    private JTextArea outputTextArea;

    public A3GUI() {
        setTitle("Sorting Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputTextArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JButton selectionSortButton = createButton("SelectionSort", Color.decode("#4CAF50"));
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = {64, 25, 12, 22, 11};
                SelectionSort.selectionSort(array);
                appendOutput("Array utilizando SelectionSort: " + Arrays.toString(array));
            }
        });

        JButton insertionSortButton = createButton("InsertionSort", Color.decode("#2196F3"));
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = {64, 25, 12, 22, 11};
                InsertionSort.insertionSort(array);
                appendOutput("Array utilizando InsertionSort: " + Arrays.toString(array));
            }
        });

        JButton shellSortButton = createButton("ShellSort", Color.decode("#FF5722"));
        shellSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] array = {64, 25, 12, 22, 11};
                ShellSort.shellSort(array);
                appendOutput("Array utilizando ShellSort: " + Arrays.toString(array));
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(selectionSortButton);
        buttonPanel.add(insertionSortButton);
        buttonPanel.add(shellSortButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

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