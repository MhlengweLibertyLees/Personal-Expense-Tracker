<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Update Expense - Expense Tracker</title>
  <!-- Bootstrap 5 CSS via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background: #f0f2f5;
      padding-top: 70px;
    }
    .navbar {
      background: linear-gradient(90deg, #0066ff, #00ccff);
    }
    .hero {
      background: linear-gradient(90deg, #00ccff, #0066ff);
      color: #fff;
      text-align: center;
      padding: 60px 0;
      margin-bottom: 40px;
      border-bottom-left-radius: 20px;
      border-bottom-right-radius: 20px;
    }
    .card {
      border: none;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.15);
    }
  </style>
</head>
<body>
  <!-- Navigation Bar -->
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="DashboardServlet.do">Expense Tracker</a>
      <div class="collapse navbar-collapse">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item"><a class="nav-link" href="DashboardServlet.do">Dashboard</a></li>
          <li class="nav-item"><a class="nav-link" href="AddExpenseServlet.do">Add Expense</a></li>
          <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Hero Section -->
  <div class="hero">
    <div class="container">
      <h1>Update Expense</h1>
      <p>Edit your expense information below</p>
    </div>
  </div>

  <!-- Update Expense Form -->
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card p-4">
          <form action="UpdateExpenseServlet.do" method="post">
            <!-- Hidden field carrying the expense ID -->
            <input type="hidden" name="id" value="${expense.expenseId}" />
            <div class="mb-3">
              <label for="amount" class="form-label">Amount</label>
              <input type="number" step="0.01" class="form-control" id="amount" name="amount" required
                     value="${expense.amount}" />
            </div>
            <div class="mb-3">
              <label for="date" class="form-label">Date</label>
              <input type="date" class="form-control" id="date" name="date" required
                     value="${expense.date}" />
            </div>
            <div class="mb-3">
              <label for="description" class="form-label">Description</label>
              <textarea class="form-control" id="description" name="description" rows="3" required>${expense.description}</textarea>
            </div>
            <div class="mb-3">
              <label for="categoryId" class="form-label">Category</label>
              <select class="form-select" id="categoryId" name="categoryId" required>
                <option value="">-- Select Category --</option>
                <c:forEach var="cat" items="${categories}">
                  <option value="${cat.categoryId}" <c:if test="${cat.categoryId == expense.category.categoryId}">selected</c:if>>
                    ${cat.name}
                  </option>
                </c:forEach>
              </select>
            </div>
            <div class="d-grid gap-2">
              <button type="submit" class="btn btn-primary">Update Expense</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Footer -->
  <footer class="text-center py-3 mt-5 bg-dark text-light">
    <div class="container">
      <p class="mb-0">&copy; 2025 Expense Tracker. All rights reserved.</p>
    </div>
  </footer>
  
  <!-- Bootstrap 5 JS Bundle via CDN -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
