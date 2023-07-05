package comp2112_project1_q2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        StackArray stack = new StackArray(0);
        int usernumber = 0;
        while (usernumber != 6) {
            System.out.println("Which task you want to do?");
            System.out.println("1-push " + "\n" + "2-pop" + "\n" + "3-print" + "\n" + "4-deletemiddle" + "\n"
                    + "5-is palindrome" + "\n" + "6-exit" + "\n");
            usernumber = scn.nextInt();
            switch (usernumber) {
                case 1:
                    System.out.println("How may pushes you want to do?");
                    int pushnumber = scn.nextInt();
                    if (stack.top == -1) {
                        StackArray stack2 = new StackArray(pushnumber);
                        stack = stack2;
                    }

                    if (stack.isFull()) {
                        stack.resize();
                    }
                    System.out.println("enter " + pushnumber + " strings");

                    for (int i = 0; i < pushnumber; i++) {
                        if (stack.isFull()) {
                            stack.resize();
                        }
                        String userstring = scn.next();
                        stack.push(userstring);

                    }
                    break;
                case 2:
                    System.out.println("the value(" + stack.pop() + ") is removed" + "\n");
                    break;

                case 3:
                    System.out.println(stack.toString() + "\n");
                    break;
                case 4:
                    if (stack.deleteMiddle()) {
                        System.out.println("middle element has been deleted" + "\n");
                    } else {
                        System.out.println("there's no middle element cause of the size of array is even" + "\n");
                    }
                    break;

                case 5:
                    if (stack.isPalindrome()) {
                        System.out.println("stack is palindrome" + "\n");
                    } else {
                        System.out.println("stack is not palindrome" + "\n");
                    }

                    break;
                case 6:
                    System.out.println("goodbye " + "\n");
                    break;
                default:
                    System.out.println("you entered invalid value" + "\n");
            }

        }
    }

}
