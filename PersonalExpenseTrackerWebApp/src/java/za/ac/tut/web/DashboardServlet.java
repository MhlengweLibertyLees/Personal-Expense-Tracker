package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.ExpenseFacadeLocal;
import za.ac.tut.entity.Expense;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/DashboardServlet.do"})
public class DashboardServlet extends HttpServlet {

    @EJB
    private ExpenseFacadeLocal expenseFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the list of expenses from the database
        List<Expense> allExpenses = expenseFacade.findAll();
        int count = (allExpenses != null) ? allExpenses.size() : 0;
        System.out.println("DashboardServlet.do: Total expenses found: " + count);
        
        // Debug: Log each expense's details
        if (allExpenses != null) {
            for (Expense expense : allExpenses) {
                System.out.println("Expense: " + expense.getDescription() + " | Amount: " + expense.getAmount());
            }
        }
        
        // Calculate total expenses (skip null amounts)
        double totalExpenses = 0.0;
        if (allExpenses != null) {
            for (Expense expense : allExpenses) {
                if (expense.getAmount() != null) {
                    totalExpenses += expense.getAmount();
                }
            }
        }
        
        // Create a recent expenses list (last 5 records)
        List<Expense> recentExpenses = new ArrayList<>();
        if (allExpenses != null && !allExpenses.isEmpty()) {
            int start = Math.max(0, allExpenses.size() - 5);
            for (int i = start; i < allExpenses.size(); i++) {
                recentExpenses.add(allExpenses.get(i));
            }
        }
        
        // Compute aggregated expense amounts by category
        // Map key = category name, value = cumulative expense amount
        Map<String, Double> expenseByCategory = new HashMap<>();
        if (allExpenses != null) {
            for (Expense expense : allExpenses) {
                if (expense.getCategory() != null && expense.getAmount() != null) {
                    String catName = expense.getCategory().getName();
                    Double currentSum = expenseByCategory.getOrDefault(catName, 0.0);
                    expenseByCategory.put(catName, currentSum + expense.getAmount());
                }
            }
        }
        
        // Set request attributes for the JSP
        request.setAttribute("totalExpenses", totalExpenses);
        request.setAttribute("recentExpenses", recentExpenses);
        request.setAttribute("allExpenses", allExpenses);
        request.setAttribute("expenseByCategory", expenseByCategory);
        
        // Forward the request to dashboard.jsp
        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
    
    // Delegate POST requests to GET
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
