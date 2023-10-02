
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
@Developer By :Chhorn Seyha
 */
public class Test {

    public static void Add() {
        try {
            FileWriter fileWriter = new FileWriter("student_info.txt", true); // Creating FileWriter object to append to the file

            Scanner scanner = new Scanner(System.in);
            String input;

            while (true) {
                System.out.print("Enter ID (type 'exit' to quit): ");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) {
                    break; // Exit the loop if 'exit' is entered
                }

                String id = input;

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter BHD: ");
                String bhd = scanner.nextLine();

                System.out.print("Enter Department: ");
                String department = scanner.nextLine();

                System.out.print("Enter Class: ");
                String className = scanner.nextLine();

                System.out.print("Enter Year of Join: ");
                String yearOfJoin = scanner.nextLine();

                System.out.print("Enter Address: ");
                String address = scanner.nextLine();

                System.out.print("Enter Gmail: ");
                String gmail = scanner.nextLine();

                System.out.print("Enter Telephone (+855): ");
                String telephone = scanner.nextLine();

                System.out.print("Enter Parent Telephone (+855): ");
                String parentTelephone = scanner.nextLine();

                // Writing the information to the file
                fileWriter.write(id + "," + name + "," + bhd + "," + department + "," + className + ","
                        + yearOfJoin + "," + address + "," + gmail + "@gmail.com" + "," + "+855" + telephone + "," + "+855" + parentTelephone + "\n");
            }

            fileWriter.close(); // Closing the FileWriter

            System.out.println("Student information successfully written to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ShOwInfo() {
        try {
            File myObj = new File("student_info.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                String[] lineSplit = data.split(",");
                // Print the contact data
                System.out.println("\033[32m==========================================================================================\033[0m");
                System.out.println("\033[33mID :\033[0m " + lineSplit[0] + " " + "\033[33mName :\033[0m " + lineSplit[1] + " " + "\033[33mDate Of Birth :\033[0m " + lineSplit[2] + " " + "\033[33mDepartment :\033[0m " + lineSplit[3] + "\n" + "\033[33mClass :\033[0m " + lineSplit[4] + " " + "\033[33mYear Of Join :\033[0m " + lineSplit[5] + " " + "\033[33mCurrent Stay :\033[0m " + lineSplit[6]
                        + "\n" + "\033[33mGmail :\033[0m " + lineSplit[7] + " " + "\033[33mTelephone :\033[0m " + lineSplit[8] + " " + "\033[33mParents Telephone :\033[0m " + lineSplit[9] + "\n");
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void SearCh() {
        Scanner scanner = new Scanner(System.in);
        boolean searchAgain = true;

        while (searchAgain) {
            System.out.print("Enter the ID to search (or 'q' to quit): ");
            String idToSearch = scanner.nextLine();

            if (idToSearch.equalsIgnoreCase("q")) {
                searchAgain = false;
                System.out.println("\033[33mSearch Stopped\033[0m");
            } else {
                try {
                    File csvFile = new File("student_info.txt");
                    try (Scanner fileScanner = new Scanner(csvFile)) {
                        boolean found = false;
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] lineSplit = line.split(",");

                            if (lineSplit[0].equals(idToSearch)) {
                                System.out.println("ID was found!");
                                // Do something with the found data
                                found = true;
                                System.out.println("\033[31m==========================================================================================\033[0m");
                                System.out.println("\033[33mID :\033[0m " + lineSplit[0] + " " + "\033[33mName :\033[0m " + lineSplit[1] + " " + "\033[33mDate Of Birth :\033[0m " + lineSplit[2] + " " + "\033[33mDepartment :\033[0m " + lineSplit[3] + "\n" + "\033[33mClass :\033[0m " + lineSplit[4] + " " + "\033[33mYear Of Join :\033[0m " + lineSplit[5] + " " + "\033[33mCurrent Stay :\033[0m " + lineSplit[6]
                                        + "\n" + "\033[33mGmail :\033[0m " + lineSplit[7] + " " + "\033[33mTelephone :\033[0m " + lineSplit[8] + " " + "\033[33mParents Telephone :\033[0m " + lineSplit[9] + "\n");
                                System.out.println("\033[31m==========================================================================================\033[0m");
                                break;

                            }
                        }

                        if (!found) {
                            System.out.println("ID not found.");
                        }
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + "Im sorry");
                }

            }
        }
    }

    public static void ReMovE() {
        Scanner input = new Scanner(System.in);
        String filePath = "student_info.txt"; // Replace with your file path
        while (true) {
            System.out.println("Enter ID (yes to Exit, Go on)");
            String searchString = input.nextLine();; // Replace with your search string
            if (searchString.equalsIgnoreCase("yes")) {
                break;
            }

            try {
                File inputFile = new File(filePath);
                File tempFile = new File("tempFile.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.contains(searchString)) {
                        writer.write(line + System.lineSeparator());
                    }
                }

                reader.close();
                writer.close();

                // Delete the original file
                if (inputFile.delete()) {
                    // Rename the temp file to the original file name
                    if (tempFile.renameTo(inputFile)) {
                        System.out.println("Text removed successfully.");
                    }
                } else {
                    System.out.println("Failed to remove text.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void UPdate() {
        String filePath = "student_info.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the person to update: ");
        String id = scanner.nextLine();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(",");

                if (lineSplit.length >= 2 && lineSplit[0].trim().equals(id)) {
                    // Display current information
                    System.out.println("Current information:");
                    System.out.println("\033[33mID :\033[0m " + lineSplit[0]);
                    System.out.println("\033[33mName :\033[0m " + lineSplit[1]);
                    System.out.println("\033[33mDate Of Birth :\033[0m " + lineSplit[2]);
                    System.out.println("\033[33mDepartment :\033[0m " + lineSplit[3]);
                    System.out.println("\033[33mClass :\033[0m " + lineSplit[4]);
                    System.out.println("\033[33mYear of Join :\033[0m " + lineSplit[5]);
                    System.out.println("\033[33mAddreas :\033[0m " + lineSplit[6]);
                    System.out.println("\033[33mGmail :\033[0m " + lineSplit[7]);
                    System.out.println("\033[33mTelephone :\033[0m " + lineSplit[8]);
                    System.out.println("\033[33mParents Telephone :\033[0m " + lineSplit[9]);
                    break;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

// Continue with updating the information
        //System.out.print("Enter the file path: ");
        System.out.println("Enter the new ID :");
        String idn = scanner.nextLine();

        System.out.print("Enter the new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the new birthday: ");
        String birthday = scanner.nextLine();

        System.out.print("Enter the new department: ");
        String department = scanner.nextLine();

        System.out.print("Enter the new class: ");
        String className = scanner.nextLine();

        System.out.print("Enter the new year of join: ");
        String yearOfJoin = scanner.nextLine();

        System.out.print("Enter the new address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the new Gmail: ");
        String gmail = scanner.nextLine();

        System.out.print("Enter the new telephone  (+855): ");
        String telephone = scanner.nextLine();

        System.out.print("Enter the new parents telephone  (+855): ");
        String parentsTelephone = scanner.nextLine();

        // Update the information in the file
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split(",");

                if (lineSplit.length >= 2 && lineSplit[0].trim().equals(id)) {
                    line = idn + "," + name + "," + birthday + "," + department + "," + className
                            + "," + yearOfJoin + "," + address + "," + gmail + "@gmail.com" + "," + "+855" + telephone + ","
                            + "+855" + parentsTelephone;
                }
                sb.append(line).append("\n");
            }

            reader.close();

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(sb.toString());
            writer.close();

            System.out.println("Information updated successfully!");
        } catch (IOException e) {
            System.err.println("Error updating information: " + e.getMessage());
        }
    }

    public static void cls() {
        for (byte i = 0; i < 127; i++) {
            System.out.println();
        }
    }

    public static void exit() {
        System.exit(0);
    }
    public static void StyLe() throws FileNotFoundException, IOException{
      try {
   FileReader reader = new FileReader("art.txt");
   int data = reader.read();
   while(data != -1) {
    System.out.print((char)data);
    data = reader.read();
   }
   reader.close();
   
  } catch (FileNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.print("W");
            Thread.sleep(270);
            System.out.print("E");
            Thread.sleep(270);
            System.out.print("L");
            Thread.sleep(280);
            System.out.print("C");
            Thread.sleep(280);
            System.out.print("O");
            Thread.sleep(280);
            System.out.print("M");
            Thread.sleep(280);
            System.out.print("E");
            Thread.sleep(280);
            System.out.print(" ");
            System.out.print("T");
            Thread.sleep(280);
            System.out.print("O");
            Thread.sleep(280);
            System.out.print(" ");
            System.out.print("O");
            Thread.sleep(280);
            System.out.print("U");
            Thread.sleep(280);
            System.out.print("R");
            Thread.sleep(280);
            System.out.print(" ");
            System.out.print("S");
            Thread.sleep(280);
            System.out.print("Y");
            Thread.sleep(280);
            System.out.print("S");
            Thread.sleep(280);
            System.out.print("T");
            Thread.sleep(280);
            System.out.print("E");
            Thread.sleep(280);
            System.out.print("M");
            // print menu options
            System.out.println();
            System.out.println("\u001B[35m******************************\033[0m");
            System.out.println("\033[41mSTU STUDENT SYSTEM MANAGEMENT\033[0m");
            System.out.println("\u001B[35m******************************\033[0m");
            System.out.println("\033[32m1.\033[0m" + "Insert Students Name");
            Thread.sleep(200);
            System.out.println("\033[32m2.\033[0m" + "Show Student Infomation");
            Thread.sleep(200);
            System.out.println("\033[32m3.\033[0m" + "Search Student ID");
            Thread.sleep(200);
            System.out.println("\033[32m4.\033[0m" + "Update Student infomation");
            Thread.sleep(200);
            System.out.println("\033[32m5.\033[0m" + "Remove Student Infomation");
            Thread.sleep(200);
            System.out.println("\033[32m6.\033[0m" + "Exit");
            Thread.sleep(200);
            System.out.println("\u001B[35m**************************************\033[0m");
            System.out.println("\033[33mDeveloper by : Team One\033[0m");
            System.out.println("B.CS.C18 Y-1");
            System.out.println("\u001B[35m**************************************\033[0m");
            System.out.print("Please choose the option : ");
            // get user's choice
            choice = scanner.nextInt();

            // process user's choice
            switch (choice) {
                case 1:
                    cls();
                    System.out.println("\u001B[31mPlease Insert Student Names\033[0m");
                    Add();
                    // perform Option 1 operation
                    break;
                case 2:
                    cls();

                    System.out.println("\u001B[36mImfomation Students List\033[0m");
                    // perform Option 2 operation
                    ShOwInfo();
                    break;
                case 3:
                    cls();
                    System.out.println("\u001B[32mWelcome to Search Option\033[0m");
                    // perform Option 3 operation
                    SearCh();
                    break;
                case 4:
                    cls();
                    System.out.println("\u001B[35mWelcome to Update Option\033[0m");
                    UPdate();
                    break;
                case 5:
                    cls();
                    System.out.println("\u001B[37mWelcome to Remove Option\033[0m");
                    ReMovE();
                    break;
                case 6:
                    cls();
                    StyLe();
                    System.out.println();
                    System.out.println("\033[33mThank You Good Luck!!!\033[0m");
                    System.out.println("Exiting...");
                    exit();
                    break;
                default:
                    cls();
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println(); // empty line for readability

        } while (choice != 7);

        scanner.close();
    }

}
