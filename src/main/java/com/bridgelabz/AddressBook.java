package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {


    static Scanner scanner = new Scanner(System.in);
    static HashMap<String, ArrayList> map = new HashMap<>();

    public static void addressBookOperations() {
        System.out.println("Enter how many addressBook you want to add: ");
        int addressBookNumber = scanner.nextInt();
        for (int i = 1; i <= addressBookNumber; i++) {
            ArrayList<Contact> list = new ArrayList<>();
            System.out.println("Enter the name of your AddressBook: ");
            String addressBookName = scanner.next();
            boolean reRun = true;
            do {
                System.out.println("Enter the operation number to perform the task. ");
                System.out.println(" 1. Add Contact \n 2. Edit Contact \n 3. Delete Contact \n 4. Add Multiple Contact \n 5. Display Contact \n ");
                System.out.println(" 6. Search City with Contact Name \n 7. Search Contact with City \n 8. Get Phone number and Name by City \n 9. Sort the Addressbook with first name of contacts \n 10. Sort the Addressbook with Zip Code of contacts \n 11. Add AddressBook to a file \n 12. Display/Read AddressBok From The file \n 13. Add AddressBook to the CSV File \n 14. Read data from the CSV File \n 0. To terminate the program and add another Addressbook to the Hashmap. \n");
                int select = scanner.nextInt();
                switch (select) {
                    case 1:  //Add contact to the list
                        System.out.println("Enter the first name of the contact to check whether it is already there in the addressBook :");
                        String name = scanner.next();
                        // Using stream Api to check for duplicate entrey in the addressbook.

                        Optional<Contact> search = list.stream().filter(contact -> contact.getFirstName().equals(name)).findFirst();
                        if (search.isPresent()) {
                            System.out.println("The contact with the same name is already present in the AddressBook: ");
                        } else {
                            Contact contact = new Contact();
                            System.out.println("Enter firstName: ");
                            String firstName = scanner.next();
                            System.out.println("Enter lastName: ");
                            String lastName = scanner.next();
                            System.out.println("Enter address: ");
                            String address = scanner.next();
                            System.out.println("Enter the city name: ");
                            String city = scanner.next();
                            System.out.println("Enter State name: ");
                            String state = scanner.next();
                            System.out.println("Enter zip code: ");
                            String zip = scanner.next();
                            System.out.println("Enter Phone number: ");
                            String phoneNumber = scanner.next();
                            System.out.println("Enter email id: ");
                            String emailId = scanner.next();
                            contact.setFirstName(firstName);
                            contact.setLastName(lastName);
                            contact.setAddress(address);
                            contact.setCity(city);
                            contact.setState(state);
                            contact.setZip(zip);
                            contact.setPhoneNumber(phoneNumber);
                            contact.setEmailId(emailId);
                            list.add(contact);
                        }
                        break;
                    case 2: // edit contact from the list
                        System.out.println("Enter the first name of the contact to edit :");
                        Scanner scanner1 = new Scanner(System.in);
                        name = scanner1.next();
                        for (Contact item : list) {
                            if (item.getFirstName().equalsIgnoreCase(name)) {
                                System.out.println("Enter firstName: ");
                                String firstName = scanner1.next();
                                System.out.println("Enter lastName: ");
                                String lastName = scanner1.next();
                                System.out.println("Enter address: ");
                                String address = scanner1.next();
                                System.out.println("Enter the city name: ");
                                String city = scanner1.next();
                                System.out.println("Enter State name: ");
                                String state = scanner1.next();
                                System.out.println("Enter zip code: ");
                                String zip = scanner1.next();
                                System.out.println("Enter Phone number: ");
                                String phoneNumber = scanner1.next();
                                System.out.println("Enter email id: ");
                                String emailId = scanner1.next();
                                item.setFirstName(firstName);
                                item.setLastName(lastName);
                                item.setAddress(address);
                                item.setCity(city);
                                item.setState(state);
                                item.setZip(zip);
                                item.setPhoneNumber(phoneNumber);
                                item.setPhoneNumber(phoneNumber);
                                item.setEmailId(emailId);
                            } else {
                                System.out.println("Entered contact is not available in the address book: ");
                            }
                        }
                        break;
                    case 3: // Delete contact from the list
                        System.out.println("Enter the first name of the contact to delete the contact :");
                        Scanner scanner2 = new Scanner(System.in);
                        name = scanner2.next();
                        for (Contact item : list) {
                            if (item.getFirstName().equalsIgnoreCase(name)) {
                                list.remove(item);
                                System.out.println("The contact with name : " + name + " is deleted from the address book:");
                                return;
                            }
                        }
                        break;
                    case 4:  //Add multiple contacts in the addressbook
                        System.out.println("How many contact you want to add ? Enter number: ");
                        Scanner scanner4 = new Scanner(System.in);
                        int number = scanner4.nextInt();
                        for (int j = 1; j <= number; j++) {
                            System.out.println("Enter the first name of the contact to check whether it is already there in the addressBook :");
                            String searchName = scanner4.next();
                            /*
                            Using stream Api the search through the list for duplicate contacts.
                             */
                            search = list.stream().filter(contact -> contact.getFirstName().equals(searchName)).findFirst();
                            if (search.isPresent()) {
                                System.out.println("The contact with the same name is already present in the AddressBook: ");
                            } else {
                                Contact contact = new Contact();
                                System.out.println("Enter firstName: ");
                                String firstName = scanner4.next();
                                System.out.println("Enter lastName: ");
                                String lastName = scanner4.next();
                                System.out.println("Enter address: ");
                                String address = scanner4.next();
                                System.out.println("Enter the city name: ");
                                String city = scanner4.next();
                                System.out.println("Enter State name: ");
                                String state = scanner4.next();
                                System.out.println("Enter zip code: ");
                                String zip = scanner4.next();
                                System.out.println("Enter Phone number: ");
                                String phoneNumber = scanner4.next();
                                System.out.println("Enter email id: ");
                                String emailId = scanner4.next();
                                contact.setFirstName(firstName);
                                contact.setLastName(lastName);
                                contact.setAddress(address);
                                contact.setCity(city);
                                contact.setState(state);
                                contact.setZip(zip);
                                contact.setPhoneNumber(phoneNumber);
                                contact.setEmailId(emailId);
                                list.add(contact);
                            }

                        }
                        break;
                    case 5:  // to show the items in side the List or in the addressbook
                        for (Contact items : list) {
                            System.out.println(items.toString());
                        }
                        break;
                    case 6: //Getting the city name with persons name
                        System.out.println("Enter the person first name : ");
                        String personName = scanner.next();
                        List<Contact> list1 = list.stream()
                                .filter(person_name -> person_name.getFirstName().equals(personName)).collect(Collectors.toList());
                        for (Contact address : list1) {
                            System.out.println("Name of the city is : " + address.getCity());
                        }
                        break;
                    case 7: // To search contact with the same city name.
                        System.out.println("Enter the city to search for the contact :");
                        String searchCity = scanner.next();
                        List<Contact> list2 =list.stream().filter(city_name -> city_name.getCity().equals(searchCity)).collect(Collectors.toList());
                        for (Contact address : list2) {
                            System.out.println("The first and Last name of the person : " + address.getFirstName() + " " + address.getLastName());
                        }
                        break;
                    case 8:  //to get the phone number and First name by city
                        System.out.println("Enter the city name :");
                        String cityName = scanner.next();
                        List<Contact> list3 = list.stream().filter(p_number -> p_number.getCity().equals(cityName)).collect(Collectors.toList());
                        for (Contact address : list3) {
                            System.out.println("The person phone number is : " + address.getPhoneNumber() + " and Name : " + address.getFirstName());
                        }
                        break;
                    case 9: // To sort all the contacts of the addressbook with their name.
                        List<String> sortedContacts = list.stream().map(address -> address.getFirstName()).sorted().collect(Collectors.toList());
                        sortedContacts.forEach(System.out::println);
                        break;
                    case 10: // To sort all the contacts of the addressbook with their Zip.
                        List<String> sortedZip = list.stream().map(contact -> contact.getZip()).sorted().collect(Collectors.toList());
                        sortedZip.forEach(System.out::println);
                        break;
                    case 11: // To add contact in a text file.
                        try {
                            addContactToFile(list);
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 12:  // To retrive data from the file
                        try {
                            displayRecordsFromTextFile();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 13:
                        try {
                            addDataToCSV(list);
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 14:
                        readFromCSVFile();
                        break;
                    case 0:
                        reRun = false;
                    default:
                        System.out.println("The program is terminated. Thank you for using Address Book Program ! ");
                }
            } while (reRun);
            map.put(addressBookName, list);
        }
    }

    public static void displayMap() { //To display the hashmap of multiple addressbooks.
        for (Map.Entry<String, ArrayList> entry : map.entrySet()) {
            String key = entry.getKey();
            ArrayList value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
    // Here Adding contact details to the text file by using IO stream.
    public static void addContactToFile(ArrayList<Contact> list) throws IOException {  //This method will right the data to a file.
        FileWriter fileWriter = new FileWriter("/home/akhil/IdeaProjects/AddressBookSystem/AddressBookFile/AddressBook.txt");
        for (Contact data : list) {
            fileWriter.write(data + System.lineSeparator());  //This line separator method will separate each entry line by line.
        }
        fileWriter.close();
    }
    public static void displayRecordsFromTextFile() throws IOException {  //This method will read data from the file who's path is given.
        Files.lines(new File("/home/akhil/IdeaProjects/AddressBookSystem/AddressBookFile/AddressBook.txt").toPath()).forEach(System.out::println);
        /*
        Files.lines: This is a method from the Files class in Java's standard library that allows you to read the lines of a file as a Stream<String> object.
        toPath(): This creates a File object representing the "AddressBook.txt" file and converts it to a Path object that can be used by the Files.lines method.
         */
    }
    public static void addDataToCSV(List<Contact> listData) throws IOException {
        CSVWriter write = new CSVWriter(new FileWriter("/home/akhil/IdeaProjects/AddressBookSystemMaven/AddressBookSyatemCSVFile/AddressBookSystem.csv"));
        ArrayList<String[]> csvData = new ArrayList<String[]>();
        csvData.add(new String[] { "First_name", "Last_name", "address", "city", "state", "zip", "phoneNumber", "email" });
        for (Contact contact : listData) {
            csvData.add(new String[] { contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getCity(), contact.getState(), contact.getZip(), contact.getPhoneNumber(), contact.getEmailId() });
        }
        write.writeAll(csvData);
        write.flush();
    }
    public static void readFromCSVFile() {
        try {
            CSVReader reader = new CSVReader(new FileReader("/home/akhil/IdeaProjects/AddressBookSystemMaven/AddressBookSyatemCSVFile/AddressBookSystem.csv"));
            String[] nextLine;
            // Read each line of the CSV file
            while ((nextLine = reader.readNext()) != null) {
                // Process the data in the current line
                for (String item : nextLine) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }
            reader.close();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }



}
