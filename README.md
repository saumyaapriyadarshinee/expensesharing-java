# expensesharing-java
This is a simple Expense Sharing Application built in Java. The application helps users to share expenses among a group and track individual balances. It supports two types of users: Admin and Customer. The Admin can add or delete users, manage expenses, and view all user detaILS.
# Expense Sharing Application

## Description
This is a **Java-based Expense Sharing Application** designed to help users split and manage shared expenses. The application allows both **Admin** and **Customer** users to participate in managing and tracking expenses in a group.

### Features:
- **User Management**: Admin can add new users and delete existing ones.
- **Expense Management**: Users can add expenses, and the system will automatically split them among participants.
- **Balance Tracking**: Keeps track of the balance of each user, updated after every expense sharing.
- **Expense Report**: Displays a summary of all expenses with details about the participants and the amount each user needs to pay or receive.
- **Menu Interface**: Admin and Customer have different menus, giving them appropriate access to features based on their roles.

## Roles
- **Admin**: Can add or remove users, view all users, manage expenses, and remove an expense.
- **Customer**: Can add new expenses, view balances, and see the report of shared expenses.

## Technologies Used:
- **Java**: The core language used to build this application.
- **Collections**: Used for managing users and expenses (ArrayList, HashMap, etc.).

## How to Run the Application
1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/ExpenseSharingApplication.git
    ```
2. **Compile the Java file**:
    ```bash
    javac ExpenseSharing.java
    ```
3. **Run the program**:
    ```bash
    java ExpenseSharing
    ```
4. **Usage**: 
    - Log in using the predefined **admin** credentials:
      - Username: `admin`
      - Password: `admin123`
    - You can also create and manage regular users to simulate expense sharing.

## Usage Example:

- **Admin Login**:
    - Username: `admin`
    - Password: `admin123`

    After logging in as admin, you will have the ability to:
    - Add or delete users.
    - View and manage all expenses.

- **Customer Login**:
    - You can create new users and log in as a customer.
    - A customer can:
      - Add an expense with a description and amount.
      - Split the expense equally between selected participants.
      - View their current balance and the expense report.

## License
This project is open source and available under the [MIT License](LICENSE).
