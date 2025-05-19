# Personal-Expense-Tracker
Personal Expense Tracker is a Java EE web application designed to help users manage their daily expenses efficiently.


# Personal Expense Tracker
Personal Expense Tracker is a Java EE web application designed to help users manage their daily expenses efficiently. The application provides an intuitive interface to create, read, update, and delete expense records, along with a dashboard that summarizes your spending.

# Features
# Dashboard Overview
-Displays a summary of total expenses.
-Shows expenses aggregated by category (e.g., Food, Transportation, Utilities, etc.).
-Presents a list of recent expenses with options to update or delete them.

# Add Expense
Users can add new expense records by specifying an amount, date, description, and selecting a category.
The form is styled using Bootstrap to ensure a modern and responsive design.

# Edit/Update Expense
Existing expense records can be updated.
Clicking the “Edit” button directs users to an update expense form pre-populated with the current details.

# Delete Expense
Allows users to remove unwanted expense records.
A confirmation prompt is provided before deletion to avoid accidental removal.

# View All Expenses
-A dedicated page lists every expense record from the database.
-Users can review the entire list and manage the records (update or delete) as needed.

# Technologies Used
# Java EE
-Servlets: Handle HTTP requests and manage application flow.
-JSP (JavaServer Pages): Render dynamic web pages with JSTL.
-EJB (Enterprise Java Beans): Provide a business logic layer for CRUD operations.
-JPA (Java Persistence API): Persist expense and category data in a relational database.

# Bootstrap 5
-Used for responsive and modern user interface styling across all pages.

# GlassFish (or your application server of choice)
-Deployed on a Java EE server for enterprise-level execution.

# Application Structure
1. DashboardServlet
Retrieves expense data from the database.
Calculates the total expense, recent expenses, and aggregates expenses by category.
Forwards the data to dashboard.jsp for display.

2. AddExpenseServlet
Provides a form (via addExpense.jsp) to add new expenses.
Processes form submissions to create new expense entries.

3. UpdateExpenseServlet
Loads an existing expense based on its ID.
Populates the updateExpense.jsp form with current details.
Processes updates to modify the expense record.

4. DeleteExpenseServlet
Deletes an expense record upon confirmation.
Redirects the user back to the dashboard.

5. ViewAllExpensesServlet & viewAllExpenses.jsp
Offers a full list of expense records.
Enables users to edit or delete any expense listed.

# How It Works
# User Workflow:

1. Dashboard: Upon logging in or accessing the dashboard, users see a summary of their expenses—total expenses, distribution by category, and a list of recent expenses with options for edit or delete.

2. Add Expense: Users navigate to the add expense page to submit new expenses. The form captures details such as amount, date, description, and category.
3. Update Expense: For any expense record, users can click the "Edit" button, which brings them to an update form where they can modify the details.
4. Delete Expense: Users can remove expense records by clicking the "Delete" button, after which a confirmation prompt ensures accidental deletions are minimized.
5. View All Expenses: A dedicated view lets users see all expense records from the database, making it easy to manage records that aren’t part of the recent list on the dashboard.
