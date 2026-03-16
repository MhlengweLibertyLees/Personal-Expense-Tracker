<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add New Expense - Expense Tracker</title>
  <!-- Bootstrap 5 CSS via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background: #f0f2f5;
      color: #333;
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      padding-top: 70px; /* Space for fixed navbar */
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
              data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" 
              aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <a class="nav-link" href="DashboardServlet.do">Dashboard</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="AddExpenseServlet.do">Add Expense</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
  <!-- Hero Section -->
  <div class="hero">
    <div class="container">
      <h1>Add New Expense</h1>
      <p>Enter your expense details below</p>
    </div>
  </div>
  
  <!-- Main Content (Add Expense Form) -->
  <div class="container my-5">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card card-shadow">
          <div class="card-body">
            <form action="AddExpenseServlet.do" method="post">
              <div class="mb-3">
                <label for="amount" class="form-label">Amount</label>
                <input type="number" step="0.01" class="form-control" id="amount" name="amount" required>
              </div>
              <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" class="form-control" id="date" name="date" required>
              </div>
              <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
              </div>
              <div class="mb-3">
                <label for="categoryId" class="form-label">Category</label>
                <select class="form-select" id="categoryId" name="categoryId" required>
                  <option value="">-- Select Category --</option>
                  <!-- Static category options; adjust them to match your database -->
                  <option value="1">Food</option>
                  <option value="2">Transportation</option>
                  <option value="3">Entertainment</option>
                  <option value="4">Utilities</option>
                  <option value="9">Other</option>
                </select>
              </div>
              <button type="submit" class="btn btn-primary">Add Expense</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Footer -->
  <footer>
    <div class="container">
      <p>&copy; 2025 Expense Tracker. All rights reserved.</p>
    </div>
  </footer>
  
  <!-- Bootstrap 5 JS Bundle with Popper via CDN -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
