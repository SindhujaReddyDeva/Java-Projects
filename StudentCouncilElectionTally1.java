import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

// Parent class
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void displayName() {
        System.out.println("Name: " + name);
    }
}

// Child class demonstrating inheritance
class Student extends Person {
    int studentId;

    Student(int studentId, String name) {
        super(name);
        this.studentId = studentId;
    }

    @Override
    void displayName() {
        System.out.println("Student ID: " + studentId
                + ", Name: " + name);
    }
}

// Candidate class demonstrating encapsulation
class Candidate {
    private String name;
    private int voteCount;

    Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    String getName() {
        return name;
    }

    int getVoteCount() {
        return voteCount;
    }

    void addVote() {
        voteCount++;
    }

    @Override
    public String toString() {
        return name + " : " + voteCount + " votes";
    }
}

// Main election system
public class StudentCouncilElectionTally1 {

    static Scanner sc = new Scanner(System.in);

    static int n, m;
    static int[] studentId;

    // Module 6: ArrayList and Generics
    static ArrayList<Candidate> candidates =
            new ArrayList<>();

    // Read and validate integer input
    static int readNumber(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(
                        sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input! Please enter a whole number.");
            }
        }
    }

    // Enter candidate names
    static void enterCandidates() {
        System.out.println("\nEnter Candidate Names:");

        for (int i = 0; i < m; i++) {
            System.out.print("Candidate " + (i + 1) + ": ");
            String name = sc.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print(
                        "Name cannot be empty. Enter name again: ");
                name = sc.nextLine().trim();
            }

            candidates.add(new Candidate(name));
        }
    }

    // Conduct the election
    static void conductVoting() {
        studentId = new int[n];

        System.out.println("\n===== VOTING STARTED =====");

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            int id = readNumber("Enter your student ID: ");

            boolean duplicate;

            do {
                duplicate = false;

                for (int j = 0; j < i; j++) {
                    if (studentId[j] == id) {
                        duplicate = true;

                        System.out.println(
                                "This student ID has already voted!");

                        id = readNumber(
                                "Enter a different student ID: ");
                        break;
                    }
                }
            } while (duplicate);

            studentId[i] = id;

            Student student =
                    new Student(id, "Voter " + (i + 1));

            student.displayName();

            System.out.println("\nCandidates:");

            for (int j = 0; j < candidates.size(); j++) {
                System.out.println(
                        (j + 1) + ". "
                        + candidates.get(j).getName());
            }

            int choice;

            do {
                choice = readNumber(
                        "Enter candidate number to vote for: ");

                if (choice < 1 || choice > candidates.size()) {
                    System.out.println(
                            "Invalid choice! Select a number from 1 to "
                            + candidates.size());
                }
            } while (choice < 1 || choice > candidates.size());

            candidates.get(choice - 1).addVote();

            System.out.println("Vote recorded successfully!");
        }
    }

    // Display results using ArrayList and Stream API
    static void displayResults() {
        System.out.println(
                "\n===== FINAL ELECTION RESULTS =====");

        // Sort candidates from highest to lowest votes
        System.out.println("\nCandidates Ranked by Votes:");

        candidates.stream()
                .sorted(Comparator.comparingInt(
                        Candidate::getVoteCount).reversed())
                .forEach(System.out::println);

        // Count candidates who received votes
        long candidatesWithVotes = candidates.stream()
                .filter(c -> c.getVoteCount() > 0)
                .count();

        System.out.println(
                "\nCandidates receiving votes: "
                + candidatesWithVotes);

        // Find the highest vote count
        int maxVotes = candidates.stream()
                .mapToInt(Candidate::getVoteCount)
                .max()
                .orElse(0);

        // Collect all candidates with the highest vote count
        ArrayList<Candidate> winners = candidates.stream()
                .filter(c -> c.getVoteCount() == maxVotes)
                .collect(Collectors.toCollection(ArrayList::new));

        // Display winner or draw
        if (winners.size() == 1) {
            System.out.println(
                    "Winner: " + winners.get(0).getName());
        } else {
            String winnerNames = winners.stream()
                    .map(Candidate::getName)
                    .collect(Collectors.joining(", "));

            System.out.println(
                    "It's a draw between: " + winnerNames);
        }

        System.out.println("Total votes cast: " + n);
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("==================================");
        System.out.println(" STUDENT COUNCIL ELECTION SYSTEM");
        System.out.println("==================================");

        // Get the number of students
        do {
            n = readNumber(
                    "Enter number of students voting: ");

            if (n < 1) {
                System.out.println(
                        "Please enter at least 1 student.");
            }
        } while (n < 1);

        // Get the number of candidates
        do {
            m = readNumber(
                    "Enter number of candidates: ");

            if (m < 1) {
                System.out.println(
                        "Please enter at least 1 candidate.");
            }
        } while (m < 1);

        // Initialize the candidate list
        candidates = new ArrayList<>();

        enterCandidates();
        conductVoting();
        displayResults();

        sc.close();
    }
}