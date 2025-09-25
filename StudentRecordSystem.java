import java.io.*;
import java.util.Scanner;

public class StudentRecordSystem {
    static final String FILE_NAME = "students.txt";

    // Ensure file exists
    static void ensureFile() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) file.createNewFile();
    }

    // Add new student (append mode)
    static void addStudent(String record) throws IOException {
        ensureFile();
        FileWriter fw = new FileWriter(FILE_NAME, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(record);
        bw.newLine();
        bw.close();
        System.out.println("Record added successfully.");
    }

    // Display all student records
    static void displayStudents() throws IOException {
        ensureFile();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        System.out.println("\n--- Student Records ---");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    // Update student record (replace line)
    static void updateStudent(String oldRecord, String newRecord) throws IOException {
        ensureFile();
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;
        boolean updated = false;
        while ((line = br.readLine()) != null) {
            if (line.trim().equals(oldRecord.trim())) {
                bw.write(newRecord);
                updated = true;
            } else {
                bw.write(line);
            }
            bw.newLine();
        }
        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (updated)
            System.out.println("Record updated successfully.");
        else
            System.out.println("Record not found!");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Student\n2. Display Students\n3. Update Student\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student record (ID Name Dept): ");
                    String record = sc.nextLine();
                    addStudent(record);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.print("Enter old record: ");
                    String oldRec = sc.nextLine();
                    System.out.print("Enter new record: ");
                    String newRec = sc.nextLine();
                    updateStudent(oldRec, newRec);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}