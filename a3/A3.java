package a3;

import java.util.Arrays;

public class A3 {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        int [] selection = arr.clone();
        int [] insertion = arr.clone();
        int [] shell = arr.clone();

        System.out.println("SelectionSort - Encontra o menor elemento e o coloca na primeira posição:");
        System.out.println("Array original: " + Arrays.toString(arr));
        SelectionSort.selectionSort(selection);
        System.out.println("Resultado da ordenação com SelectionSort: " + Arrays.toString(selection));
        System.out.println("-------------------------------------------------------------------");
        
        System.out.println("InsetionSort - Percorre o array e insere cada elemento na posição correta, deslocando os elementos maiores conforme necessário:");
        System.out.println("Array original: " + Arrays.toString(arr));
        InsertionSort.insertionSort(insertion);
        System.out.println("Resultado da ordenação com InsertionSort: " + Arrays.toString(insertion));
        System.out.println("-------------------------------------------------------------------");
 
        
        System.out.println("InsetionSort -  divide o array em subarrays menores e aplica o Insertion Sort em cada subarray:");
        System.out.println("Array original: " + Arrays.toString(arr));
        ShellSort.shellSort(shell);
        System.out.println("Resultado da ordenação com ShellSort: " + Arrays.toString(shell));
        System.out.println("-------------------------------------------------------------------");
    }

    static void selectionSort(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void insertionSort(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void shellSort(int[] array) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}