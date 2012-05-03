/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import trpo_kp.control.OrganisationControl;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "WARRANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warrant.findAll", query = "SELECT w FROM Warrant w"),
    @NamedQuery(name = "Warrant.findById", query = "SELECT w FROM Warrant w WHERE w.id = :id"),
    @NamedQuery(name = "Warrant.findByIssueDate", query = "SELECT w FROM Warrant w WHERE w.issueDate = :issueDate"),
    @NamedQuery(name = "Warrant.findByValidUntil", query = "SELECT w FROM Warrant w WHERE w.validUntil = :validUntil")})
@SequenceGenerator(name="WarrantSeq", sequenceName="WARRANT_SEQ", initialValue=1000, allocationSize=1)
public class Warrant implements Serializable {
    @Basic(optional = false)
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Column(name = "VALID_UNTIL")
    @Temporal(TemporalType.DATE)
    private Date validUntil;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="WarrantSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Paymentorder orderId;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee emplId;
    @OneToMany(mappedBy = "warId", fetch = FetchType.LAZY)
    private List<Docrow> docrowList;

    public Warrant() {
    }

    public Warrant(BigDecimal id) {
        this.id = id;
    }

    public Warrant(BigDecimal id, Date issueDate) {
        this.id = id;
        this.issueDate = issueDate;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Paymentorder getOrderId() {
        return orderId;
    }

    public void setOrderId(Paymentorder orderId) {
        this.orderId = orderId;
    }

    public Employee getEmplId() {
        return emplId;
    }

    public void setEmplId(Employee emplId) {
        this.emplId = emplId;
    }

    @XmlTransient
    public List<Docrow> getDocrowList() {
        return docrowList;
    }

    public void setDocrowList(List<Docrow> docrowList) {
        this.docrowList = docrowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warrant)) {
            return false;
        }
        Warrant other = (Warrant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Warrant[ id=" + id + " ]";
    }
    public double getWarrantsSumIncludingTaxes(Date from, Date until) {
        /*EntityManager entityManager = OrganisationControl.getEntityManager();
        entityManager.refresh(this);*/
        double result = 0;
        List<Docrow> lst = docrowList;
        for (Docrow docrow : lst) {
            result += docrow.getSumIncludingTaxes();
        }
        //entityManager.close();
        return result;
    }
    public boolean checkDate(Date from, Date until){
        /*System.out.println(from);
        System.out.println(until);
        System.out.println(this.getIssueDate());*/
        if ((this.getIssueDate().after(from) || this.getIssueDate().equals(from))
                    && (this.getIssueDate().before(until) || this.getIssueDate().equals(until))) {
            return true;
        }
        return false;
    }
}
