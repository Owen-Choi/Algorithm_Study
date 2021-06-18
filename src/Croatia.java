import java.util.Scanner;

class Main {

    int[] letter;
    int letterCount;

    public void CheckInput(String input) {
        int i;
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
            }

        }
    }


    public void PrintCount() {
        System.out.println("number is " + letterCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence;
        System.out.println("Please enter sample sentence : ");
        sentence = sc.next();

        Main cr = new Main();
        cr.CheckInput(sentence);
        cr.PrintCount();
    }
}
