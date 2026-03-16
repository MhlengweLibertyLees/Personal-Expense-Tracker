package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.entity.Expense;

@Stateless
public class ExpenseFacade extends AbstractFacade<Expense> implements ExpenseFacadeLocal {

    @PersistenceContext(unitName = "PersonalExpenseTrackerEJBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExpenseFacade() {
        super(Expense.class);
    }

    //new methods
    @Override
    public List<Expense> findRecentExpenses(int maxResults) {
        return em.createQuery("SELECT e FROM Expense e ORDER BY e.date DESC", Expense.class)
                .setMaxResults(maxResults)
                .getResultList();
    }
    
    @Override
    public Double getTotalExpenses() {
    Double total = (Double) em.createQuery("SELECT SUM(e.amount) FROM Expense e")
                              .getSingleResult();
    return total != null ? total : 0.0;
}


}
