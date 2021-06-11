import java.util.Scanner;
import java.util.Arrays;

//CHALLENGE: https://edabit.com/challenge/KZrmicjc8zCZyGNee
public class Main {

    public static int[] encrypt (String str) {
        int[] enc = new int [str.length()];                     //makes an array with the size of the string
        enc[0] = str.charAt(0);                                //first position of the array is the value of the first position of the string (ascii table)

        for (int i = 1; i < enc.length; i++) {
            enc[i] = str.charAt(i) - str.charAt (i - 1);             //value of the character minus the value of the past character (the cryptography)
        }

        return enc;

    }

    public static String decrypt (int[] arr) {
        String dec = (char) arr[0] + "";             //casts the string to char and puts it in the first position of the array. the "" is because the variable type is string, so it needs one

        for (int i = 1; i < arr.length; i++) {
            dec = dec + (char) (arr[i] + dec.charAt(i - 1));            //undoes the process of encrypting by summing the current value to the previous one and then adds the character to the string
        }

        return dec;

    }

    public static void main(String[] args) {

        Scanner prompt = new Scanner (System.in);
        //so testing could be easier
        System.out.println("Type -1 to start the program.");
        System.out.println("Type -2 to stop the program.");
        int end_or_continue = prompt.nextInt();

        while (end_or_continue == -1) {
            System.out.println("Type 1 if you want to encrypt, or 2 if you want to decrypt.");
            int choice = prompt.nextInt();

            if (choice == 1) {
                System.out.print("Type the word you want to encrypt: ");
                String string = prompt.next();
                System.out.println("encrypt('" + string + "') -> " + Arrays.toString(encrypt(string)));
            }
            if (choice == 2) {
                System.out.println("Type the quantity of numbers in the array you want to decrypt");
                int n = prompt.nextInt();
                System.out.println("Type the array of numbers you want to decrypt");
                int[] array = new int[n];
                for (int i = 0; i < array.length; i++) {
                    System.out.print("Type number: ");
                    array[i] = prompt.nextInt();
                }
                System.out.println("decrypt(" + Arrays.toString(array) + ") -> '" + decrypt(array) + "'");
            }


            System.out.println("Type -1 to continue the program.");
            System.out.println("Type -2 to stop the program.");
            end_or_continue = prompt.nextInt();

            if (end_or_continue == -2) {
                System.out.println("Program ended!");
                break;
            }
        }

    }

}
