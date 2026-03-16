
package za.ac.tut.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EXPENSE")
public class Expense implements Serializable {

    private static final long serialVersionUID = 1L;
    // Primary key, auto-generated using GenerationType.IDENTITY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPENSE_ID")
    private Long expenseId;
    
    // Expense amount (should be required)
    @Column(name = "AMOUNT", nullable = false)
    private Double amount;
    
    // Expense date, stored as DATE (without time)
    @Temporal(TemporalType.DATE)
    @Column(name = "EXPENSE_DATE", nullable = false)
    private Date date;
    
    // Description of the expense
    @Column(name = "DESCRIPTION", length = 255)
    private String description;
    
    // Many-to-One relationship: Many Expense entries can belong to one Category.
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;
    
    // Default constructor required by JPA
    public Expense() { }
    
    // Convenience constructor
    public Expense(Double amount, Date date, String description, Category category) {
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.category = category;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expenseId != null ? expenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expense)) {
            return false;
        }
        Expense other = (Expense) object;
        if ((this.expenseId == null && other.expenseId != null) || (this.expenseId != null && !this.expenseId.equals(other.expenseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entity.Expense[ id=" + expenseId + " ]";
    }
    
}
