package za.ac.tut.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.ExpenseFacadeLocal;
import za.ac.tut.entity.Expense;

@WebServlet(name = "ViewAllExpensesServlet", urlPatterns = {"/ViewAllExpensesServlet.do"})
public class ViewAllExpensesServlet extends HttpServlet {

    @EJB
    private ExpenseFacadeLocal expenseFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        // Retrieve all expense records from the database
        List<Expense> allExpenses = expenseFacade.findAll();
        request.setAttribute("allExpenses", allExpenses);
        request.getRequestDispatcher("viewAllExpenses.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        doGet(request, response);
    }
}
