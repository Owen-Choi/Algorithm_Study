package Java_Algorithms;

import java.util.Scanner;
import java.io.IOException;

class Croatia_Alphabet {
    public static void main(String[] args) throws IOException{
        String input;
        int[] letter;
        int letterCount;
        int i;

        Scanner sc = new Scanner(System.in);
        input = sc.next();

            letter = new int[input.length()];
            letterCount = input.length();

            for (i = 0; i < input.length(); i++) {
                letter[i] = input.charAt(i);
            }

            for (i = 0; i < input.length(); i++) {
                switch (letter[i]) {
                    case '=':
                        if(i >= 1) {
                            if (letter[i - 1] == 'c' || letter[i - 1] == 's') {
                                letterCount--;
                                break;
                            } else if (letter[i - 1] == 'z') {
                                if (i >= 2) {
                                    if (letter[i - 2] == 'd') {
                                        letterCount -= 2;
                                        break;
                                    }
                                }
                                letterCount--;
                                break;
                            }
                        }
                        break;
                    case '-':
                        if(i >= 1) {
                            if (letter[i - 1] == 'c' || letter[i - 1] == 'd') {
                                letterCount--;
                                break;
                            }
                        }
                        break;
                    case 'j':
                        if(i >= 1) {
                            if (letter[i - 1] == 'l' || letter[i - 1] == 'n') {
                                letterCount--;
                                break;
                            }
                        }
                        break;
                    default :
                        break;
                }
            }

        System.out.println(letterCount);
    }
}
