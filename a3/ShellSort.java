/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a3;

import java.util.Arrays;

/**
 *
 * @author Karina
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Define o tamanho do intervalo inicial
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Exibe o estado dos subarrays antes de cada iteração do gap
            System.out.println("Subarrays com gap " + gap + ": " + Arrays.toString(arr));

            // Realiza o insertion sort em cada subarray com o intervalo gap
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;

                // Move os elementos do subarray que são maiores que a chave
                // para uma posição à frente de sua posição atual
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;

                    // Exibe o estado do subarray após cada troca
                    System.out.println("Passo com gap " + gap + ": " + Arrays.toString(arr));
                }

                arr[j] = key;
            }
        }

        // Exibe o array ordenado
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}

