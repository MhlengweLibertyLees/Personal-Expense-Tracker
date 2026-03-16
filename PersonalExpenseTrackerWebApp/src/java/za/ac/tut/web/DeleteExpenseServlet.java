package za.ac.tut.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.ExpenseFacadeLocal;
import za.ac.tut.entity.Expense;

@WebServlet(name = "DeleteExpenseServlet", urlPatterns = {"/DeleteExpenseServlet.do"})
public class DeleteExpenseServlet extends HttpServlet {

    @EJB
    private ExpenseFacadeLocal expenseFacade;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        String expenseIdStr = request.getParameter("id");
        if(expenseIdStr != null){
            Long expenseId = Long.parseLong(expenseIdStr);
            Expense expense = expenseFacade.find(expenseId);
            if(expense != null){
                expenseFacade.remove(expense);
            }
        }
        response.sendRedirect("DashboardServlet.do");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        doGet(request, response);
    }
}
