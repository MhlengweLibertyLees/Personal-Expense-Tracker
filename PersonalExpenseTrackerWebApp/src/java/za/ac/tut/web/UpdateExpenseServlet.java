package za.ac.tut.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet(name = "UpdateExpenseServlet", urlPatterns = {"/UpdateExpenseServlet.do"})
public class UpdateExpenseServlet extends HttpServlet {

    @EJB
    private ExpenseFacadeLocal expenseFacade;
    
    @EJB
    private CategoryFacadeLocal categoryFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        String expenseIdStr = request.getParameter("id");
        if(expenseIdStr == null){
            response.sendRedirect("DashboardServlet.do");
            return;
        }
        Long expenseId = Long.parseLong(expenseIdStr);
        Expense expense = expenseFacade.find(expenseId);
        if(expense == null){
            response.sendRedirect("DashboardServlet.do");
            return;
        }
        // Load list of categories for the dropdown.
        List<Category> categories = categoryFacade.findAll();
        request.setAttribute("expense", expense);
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("updateExpense.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        // Retrieve the updated form fields
        String expenseIdStr = request.getParameter("id");
        Long expenseId = Long.parseLong(expenseIdStr);
        Expense expense = expenseFacade.find(expenseId);
        if(expense == null){
            response.sendRedirect("DashboardServlet.do");
            return;
        }
        
        String amountStr = request.getParameter("amount");
        String dateStr = request.getParameter("date");
        String description = request.getParameter("description");
        String categoryIdStr = request.getParameter("categoryId");
        
        Double amount = Double.parseDouble(amountStr);
        expense.setAmount(amount);
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            expense.setDate(sdf.parse(dateStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        Long categoryId = Long.parseLong(categoryIdStr);
        Category category = categoryFacade.find(categoryId);
        expense.setDescription(description);
        expense.setCategory(category);
        
        expenseFacade.edit(expense);
        response.sendRedirect("DashboardServlet.do");
    }
}
