import java.util.*;

public class TextEditorundo {
    interface TextStack {
        void push(String item);
        String pop();
        String peek();
        boolean isEmpty();
    }

    static class ArrayStack implements TextStack {
        private String[] elements = new String[10];
        private int top = -1;

        public void push(String item) {
            if (top == elements.length - 1) {
                System.out.println("Stack is full! cannot push");
                return;
            }
            elements[++top] = item;
        }

        public String pop() {
            if (isEmpty()) {
                System.out.println("Stack is Empty! nothing to undo");
                return null;
            }
            return elements[top--];
        }

        public String peek() {
            if (isEmpty()) return null;
            return elements[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayStack UndoStack = new ArrayStack();
        while (true) {
            System.out.println("\n__Text Editor__");
            System.out.println("1.Type text");
            System.out.println("2.Undo");
            System.out.println("3.View Current text.");
            System.out.println("4.Exit");
            System.out.println("Enter Choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter text:");
                    String text = sc.nextLine();
                    UndoStack.push(text);
                    break;
                case 2:
                    String undone = UndoStack.pop();
                    if (undone != null) {
                        System.out.println("Undo:" + undone);
                    }
                    break;
                case 3:
                    String current = UndoStack.peek();
                    System.out.println("current text:" + (current != null ? current : "No Text"));
                    break;
                case 4:
                    System.out.println("Exiting..");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice! Try again");
            }
        }
    }
}