package onlineexamination;

import java.util.Scanner;

public class OnlineExamSystem {
    static User user = new User("admin", "password", "Admin");
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        
        if (!user.login(username, password)) {
            System.out.println("Invalid login credentials.");
            return;
        }
        
        System.out.println("Login successful! Welcome, " + user.getName());
        
        while (true) {
            System.out.println("1. Update Profile & Password\n2. Start Exam\n3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = scanner.next();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();
                    user.updateProfile(newName, newPassword);
                    System.out.println("Profile updated!");
                    break;
                case 2:
                    new Exam().startExam();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}

