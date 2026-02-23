import java.sql.*;
import java.util.Scanner;

public class TodoDB {

    static final String URL = "jdbc:mysql://localhost:3306/todo_db";
    static final String USER = "root";
    static final String PASS = "1234";   

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Scanner sc = new Scanner(System.in);

            while(true){
                System.out.println("\n1.Add Task\n2.View Tasks\n3.Delete Task\n4.Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if(choice==1){
                    System.out.print("Enter task: ");
                    String task = sc.nextLine();

                    PreparedStatement ps = con.prepareStatement("insert into tasks(task) values(?)");
                    ps.setString(1, task);
                    ps.executeUpdate();
                    System.out.println("Task added");
                }

                else if(choice==2){
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from tasks");

                    while(rs.next()){
                        System.out.println(rs.getInt(1)+" "+rs.getString(2));
                    }
                }

                else if(choice==3){
                    System.out.print("Enter task id to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement("delete from tasks where id=?");
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    System.out.println("Deleted");
                }

                else break;
            }

            con.close();
            sc.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
