import java.util.Scanner;

// GradeAnalyzer
public class Task01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        int[] grades = new int[n];
        int sum = 0;

        // Input grades
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            sum += grades[i];
        }

        // Compute average
        double average = (double) sum / n;

        // Find highest and lowest grades
        int highest = grades[0];
        int lowest = grades[0];
        for (int i = 1; i < n; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }

        // Display results
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close();
    }
}
