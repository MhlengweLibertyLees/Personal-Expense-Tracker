<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Dashboard - Personal Expense Tracker</title>
  <!-- Bootstrap 5 CSS via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background: #f0f2f5;
      color: #333;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      padding-top: 70px; /* To account for fixed navbar */
    }
    .navbar {
      background: linear-gradient(90deg, #0066ff, #00ccff);
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
    }
    .navbar-brand {
      font-weight: bold;
      font-size: 1.8rem;
    }
    .nav-link {
      font-size: 1.15rem;
      transition: color 0.3s ease-in-out;
    }
    .nav-link:hover {
      color: #ffc107 !important;
    }
    .hero {
      background: linear-gradient(90deg, #00ccff, #0066ff);
      color: #fff;
      padding: 60px 0;
      text-align: center;
      border-bottom-left-radius: 20px;
      border-bottom-right-radius: 20px;
      margin-bottom: 40px;
    }
    .hero h1 {
      font-size: 3rem;
      font-weight: bold;
    }
    .hero p {
      font-size: 1.25rem;
      margin-top: 10px;
    }
    .card {
      border: none;
      border-radius: 10px;
    }
    .card-shadow {
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
    }
    .table thead th {
      background-color: #0066ff;
      color: #fff;
    }
    .expense-category {
      font-size: 1rem;
      margin-right: 10px;
      margin-bottom: 5px;
    }
    footer {
      background-color: #212529;
      color: #aaa;
      padding: 20px 0;
      text-align: center;
    }
  </style>
</head>
<body>
  <!-- Navigation Bar -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="DashboardServlet.do">Expense Tracker</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
              data-bs-target="#navbarNav" aria-controls="navbarNav" 
              aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link active" href="DashboardServlet.do">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="AddExpenseServlet.do">Add Expense</a>
          </li>
          <!-- Updated Navigation: "View All Expenses" to manage all records -->
          <li class="nav-item">
            <a class="nav-link" href="ViewAllExpensesServlet.do">View All Expenses</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- Hero Section -->
  <div class="hero">
    <div class="container">
      <h1>Welcome to Expense Tracker</h1>
      <p>Manage your expenses smartly and efficiently.</p>
    </div>
  </div>

  <!-- Main Content -->
  <div class="container my-5">
    <!-- Dashboard Overview Card -->
    <div class="row mb-4">
      <div class="col">
        <div class="card card-shadow">
          <div class="card-body">
            <div class="d-flex justify-content-between align-items-center mb-3">
              <h2 class="card-title mb-0">Dashboard Overview</h2>
              <span class="badge bg-light text-dark">
                <c:out value="${fn:length(allExpenses)}" /> expense(s) loaded
              </span>
            </div>
            <h4 class="fw-normal">
              Total Expenses: <span class="text-success">$${totalExpenses}</span>
            </h4>
            <!-- Expense by Category Section -->
            <div class="mt-3">
              <h5>Expense by Category:</h5>
              <div>
                <c:forEach var="entry" items="${expenseByCategory}">
                  <span class="badge bg-info text-dark expense-category">
                    ${entry.key}: $${entry.value}
                  </span>
                </c:forEach>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Recent Expenses Table with Update/Delete Actions -->
    <div class="row">
      <div class="col">
        <div class="card card-shadow mb-4">
          <div class="card-body">
            <h3 class="card-title mb-3 text-primary">Recent Expenses</h3>
            <div class="table-responsive">
              <table class="table table-hover">
                <thead>
                  <tr>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Amount</th>
                    <th>Actions</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="expense" items="${recentExpenses}">
                    <tr>
                      <td>${expense.date}</td>
                      <td>${expense.description}</td>
                      <td>$${expense.amount}</td>
                      <td>
                        <a href="UpdateExpenseServlet.do?id=${expense.expenseId}" class="btn btn-sm btn-warning me-1">Edit</a>
                        <a href="DeleteExpenseServlet.do?id=${expense.expenseId}" class="btn btn-sm btn-danger" 
                           onclick="return confirm('Are you sure you want to delete this expense?');">
                           Delete
                        </a>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer>
    <div class="container">
      <p class="mb-0">&copy; 2025 Expense Tracker. All rights reserved.</p>
    </div>
  </footer>
  
  <!-- Bootstrap 5 JS Bundle with Popper via CDN -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
