
package za.ac.tut.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.entity.Expense;

@Local
public interface ExpenseFacadeLocal {

    void create(Expense expense);

    void edit(Expense expense);

    void remove(Expense expense);

    Expense find(Object id);

    List<Expense> findAll();

    List<Expense> findRange(int[] range);

    int count();
    
    //new 
    List<Expense> findRecentExpenses(int maxResults);
    public Double getTotalExpenses();
    
}
