package za.ac.tut.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-18T14:20:32")
@StaticMetamodel(Expense.class)
public class Expense_ { 

    public static volatile SingularAttribute<Expense, Date> date;
    public static volatile SingularAttribute<Expense, Double> amount;
    public static volatile SingularAttribute<Expense, Long> expenseId;
    public static volatile SingularAttribute<Expense, String> description;
    public static volatile SingularAttribute<Expense, Category> category;

}