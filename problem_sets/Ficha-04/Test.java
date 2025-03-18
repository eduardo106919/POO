import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int choice = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Chose an exercise to run:");
        System.out.println("1 - Stack");
        System.out.println("2 - Encomenda Eficiente");
        System.out.println("3 - Casa Inteligente");
        System.out.println("4 - Facebook Feed");
        System.out.println("5 - Sistema de Suporte");
        System.out.print("choice: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                Stack st = new Stack();
                System.out.println("stack is empty: " +  st.isEmpty());

                st.push("hello");
                st.push("everybody");
                st.push("my");
                st.push("name");
                st.push("is");
                st.push("ahaha");
                st.push("not");
                st.push("gonna");
                st.push("tell");
                st.push("you");

                System.out.println(st.toString());
                System.out.println("top: " + st.top());
                System.out.println("size: " + st.length());

                st.pop();
                st.pop();
                st.pop();
                st.pop();

                System.out.println(st.toString());
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        input.close();
    }
}
