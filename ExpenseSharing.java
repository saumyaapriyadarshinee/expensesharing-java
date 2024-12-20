import java.util.*;

class User {
    private String username;
    private double balance;

    // Constructor now accepts only the username
    public User(String username) {
        this.username = username;
        this.balance = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }
}

class Expense {
    private String description;
    private double amount;
    private List<User> participants;
    private double sharePerUser;

    public Expense(String description, double amount, List<User> participants) {
        this.description = description;
        this.amount = amount;
        this.participants = participants;
        this.sharePerUser = amount / participants.size();
    }

    public void splitExpense() {
        for (User user : participants) {
            user.updateBalance(-sharePerUser);
        }
    }

    public String getSummary() {
        return "Description: " + description + ", Total: " + amount + ", Share per user: " + sharePerUser;
    }
}

public class ExpenseSharing {
    private List<User> users;
    private List<Expense> expenses;

    public ExpenseSharing() {
        users = new ArrayList<>();
        expenses = new ArrayList<>();
    }

    public void addUser(String username) {
        users.add(new User(username));  // User constructor that accepts only the username
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addExpense(String description, double amount, List<String> participantUsernames) {
        List<User> participants = new ArrayList<>();
        for (String username : participantUsernames) {
            User user = getUserByUsername(username);
            if (user != null) {
                participants.add(user);
            }
        }
        if (participants.size() > 0) {
            Expense expense = new Expense(description, amount, participants);
            expenses.add(expense);
            expense.splitExpense();
        } else {
            System.out.println("Error: No participants found for this expense.");
        }
    }

    public void viewBalances() {
        for (User user : users) {
            System.out.println(user.getUsername() + " balance: " + user.getBalance());
        }
    }

    public void viewExpenseReport() {
        for (Expense expense : expenses) {
            System.out.println(expense.getSummary());
        }
    }

    public void deleteUser(String username) {
        users.removeIf(user -> user.getUsername().equals(username));
    }

    public void removeExpense(String description) {
        expenses.removeIf(expense -> expense.getSummary().contains(description));
    }

    public void viewUserInfo(String username) {
        User user = getUserByUsername(username);
        if (user != null) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Balance: " + user.getBalance());
        } else {
            System.out.println("User not found.");
        }
    }

    public void adminMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. View All Users");
            System.out.println("4. View All Expenses");
            System.out.println("5. View Balances");
            System.out.println("6. Remove Expense");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username to add: ");
                    String username = scanner.nextLine();
                    addUser(username);
                    System.out.println("User added successfully.");
                    break;
                case 2:
                    System.out.print("Enter username to delete: ");
                    String deleteUsername = scanner.nextLine();
                    deleteUser(deleteUsername);
                    System.out.println("User deleted successfully.");
                    break;
                case 3:
                    for (User user : users) {
                        System.out.println(user.getUsername());
                    }
                    break;
                case 4:
                    viewExpenseReport();
                    break;
                case 5:
                    viewBalances();
                    break;
                case 6:
                    System.out.print("Enter description of the expense to remove: ");
                    String expenseDescription = scanner.nextLine();
                    removeExpense(expenseDescription);
                    System.out.println("Expense removed successfully.");
                    break;
                case 7:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void customerMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Balances");
            System.out.println("3. View Expense Report");
            System.out.println("4. View User Info");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter total amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter participants (comma-separated): ");
                    String participantsInput = scanner.nextLine();
                    List<String> participants = Arrays.asList(participantsInput.split(","));
                    addExpense(description, amount, participants);
                    break;
                case 2:
                    viewBalances();
                    break;
                case 3:
                    viewExpenseReport();
                    break;
                case 4:
                    System.out.print("Enter username to view info: ");
                    String username = scanner.nextLine();
                    viewUserInfo(username);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Expense Sharing System");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals("admin") && password.equals("admin123")) {
                adminMenu();
            } else {
                User user = getUserByUsername(username);
                if (user != null) {
                    customerMenu(user);
                } else {
                    System.out.println("Invalid credentials. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        ExpenseSharing app = new ExpenseSharing();
        app.addUser("admin"); // Admin user
        app.start();
    }
}

                 