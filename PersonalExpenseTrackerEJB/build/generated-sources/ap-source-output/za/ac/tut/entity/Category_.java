package za.ac.tut.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.entity.Expense;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-18T14:20:32")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile SingularAttribute<Category, Long> categoryId;
    public static volatile ListAttribute<Category, Expense> expenses;

}