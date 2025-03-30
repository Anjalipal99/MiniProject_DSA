import java.util.Scanner;

class MiniProject {
    Node start;

    static class Node {
        String name;
        String pnumber;
        Node next;

        Node(String name, String pnumber) {
            this.name = name;
            this.pnumber = pnumber;
            this.next = null;
        }
    }

    // Add a contact
    void addContact(String name, String pnumber) {
        Node new_node = new Node(name, pnumber);
        if (start == null) {
            start = new_node;
        } else {
            new_node.next = start;
            start = new_node;
        }
        System.out.println("Contact Added: " + name + ", " + pnumber);
    }

    // Remove a contact by name
    void removeContact(String name) {
        if (start == null) {
            System.out.println("Contact list is empty.");
            return;
        }
        
        // If the contact to be deleted is the first node
        if (start.name.equals(name)) {
            start = start.next;
            System.out.println("Contact removed: " + name);
            return;
        }

        // Search for the contact in the list
        Node temp = start;
        Node prev = null;
        while (temp != null && !temp.name.equals(name)) {
            prev = temp;
            temp = temp.next;
        }

        // If contact was not found
        if (temp == null) {
            System.out.println("Contact not found.");
            return;
        }

        // Unlink the node from the linked list
        prev.next = temp.next;
        System.out.println("Contact removed: " + name);
    }

    // Search for a contact by name
    void searchContact(String name) {
        Node temp = start;
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println("Contact Found: " + temp.name + "," + temp.pnumber);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Contact not found.");
    }

    // Display all contacts
    void displayContacts() {
        if (start == null) {
            System.out.println("Empty Contact list!");
            return;
        }
        System.out.println("Contact List:");
        Node temp = start;
        while (temp != null) {
            System.out.println(temp.name + " ,"+temp.pnumber);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MiniProject contactList = new MiniProject();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.print("Select your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone Number: ");
                    String pnumber = sc.nextLine();
                    contactList.addContact(name, pnumber);
                    break;
                case 2:
                    System.out.print("Enter Name to Remove: ");
                    name = sc.nextLine();
                    contactList.removeContact(name);
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    name = sc.nextLine();
                    contactList.searchContact(name);
                    break;
                case 4:
                    contactList.displayContacts();
                    break;
                case 5:
                    System.out.println("Exiting.........!");
                    break;
                default:
                    System.out.println("choice not exist! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
