package za.ac.tut.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.CategoryFacadeLocal;
import za.ac.tut.bl.ExpenseFacadeLocal;
import za.ac.tut.entity.Category;
import za.ac.tut.entity.Expense;

@WebServlet(name = "AddExpenseServlet", urlPatterns = {"/AddExpenseServlet.do"})
public class AddExpenseServlet extends HttpServlet {

    @EJB
    private ExpenseFacadeLocal expenseFacade;
    
    @EJB
    private CategoryFacadeLocal categoryFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the list of categories from the database
        List<Category> categories = categoryFacade.findAll();
        System.out.println("AddExpenseServlet.do GET: Number of categories retrieved: " 
                + (categories != null ? categories.size() : 0));
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("addExpense.jsp").forward(request, response);
    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form parameters
        String amountStr = request.getParameter("amount");
        String dateStr = request.getParameter("date");
        String description = request.getParameter("description");
        String categoryIdStr = request.getParameter("categoryId");
        
        // Convert parameters to appropriate types
        Double amount = Double.parseDouble(amountStr);
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Long categoryId = Long.parseLong(categoryIdStr);
        Category category = categoryFacade.find(categoryId);
        
        // Create and persist the new Expense
        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setDate(date);
        expense.setDescription(description);
        expense.setCategory(category);
        expenseFacade.create(expense);
        
        // Redirect after successfully adding the expense (adjust target as needed)
        response.sendRedirect("dashboard.jsp");
    }
}
