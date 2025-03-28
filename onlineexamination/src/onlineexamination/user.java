package onlineexamination;

import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String name;
    
    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public void updateProfile(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public String getUsername() { return username; }
    public String getName() { return name; }
}

class Exam {
    private String[][] questions = {
        {"What is Java?", "1. Language", "2. OS", "3. Database", "4. None", "1"},
        {"Who invented Java?", "1. Dennis Ritchie", "2. James Gosling", "3. Bjarne Stroustrup", "4. Guido van Rossum", "2"}
    };
    
    public void startExam() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60000; // 1 minute timer
        
        for (String[] q : questions) {
            if (System.currentTimeMillis() > endTime) {
                System.out.println("Time up! Auto-submitting...");
                break;
            }
            System.out.println(q[0]);
            for (int i = 1; i <= 4; i++) {
                System.out.println(q[i]);
            }
            System.out.print("Your Answer: ");
            String answer = scanner.next();
            if (answer.equals(q[5])) {
                score++;
            }
        }
        System.out.println("Exam finished. Your score: " + score + "/" + questions.length);
    }
}