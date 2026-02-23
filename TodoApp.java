import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add Task\n2.View Tasks\n3.Delete Task\n4.Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter task: ");
                String task = sc.nextLine();
                tasks.add(task);
                System.out.println("Task added");

            } else if (choice == 2) {
                System.out.println("Tasks:");
                for (String t : tasks) {
                    System.out.println(t);
                }

            } else if (choice == 3) {
                System.out.print("Enter task to delete: ");
                String task = sc.nextLine();
                if (tasks.remove(task)) {
                    System.out.println("Deleted");
                } else {
                    System.out.println("Not found");
                }

            } else if (choice == 4) {
                break;
            }
        }

        sc.close();
    }
}
