/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "PAYMENTORDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paymentorder.findAll", query = "SELECT p FROM Paymentorder p"),
    @NamedQuery(name = "Paymentorder.findById", query = "SELECT p FROM Paymentorder p WHERE p.id = :id"),
    @NamedQuery(name = "Paymentorder.findByPodate", query = "SELECT p FROM Paymentorder p WHERE p.podate = :podate"),
    @NamedQuery(name = "Paymentorder.findByAmount", query = "SELECT p FROM Paymentorder p WHERE p.amount = :amount")})
@SequenceGenerator(name="PaymentorderSeq", sequenceName="PAYMENTORDER_SEQ", initialValue=1000, allocationSize=1)
public class Paymentorder implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="PaymentorderSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "PODATE")
    @Temporal(TemporalType.DATE)
    private Date podate;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private double amount;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderId", fetch = FetchType.LAZY)
    private Warrant warrant;
    @OneToMany(mappedBy = "poId", fetch = FetchType.LAZY)
    private List<Docrow> docrowList;
    @JoinColumn(name = "BILL_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Bill billId;
    @JoinColumn(name = "SUP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency supId;
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency orgId;

    public Paymentorder() {
    }

    public Paymentorder(BigDecimal id) {
        this.id = id;
    }

    public Paymentorder(BigDecimal id, Date podate, double amount) {
        this.id = id;
        this.podate = podate;
        this.amount = amount;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getPodate() {
        return podate;
    }

    public void setPodate(Date podate) {
        this.podate = podate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Warrant getWarrant() {
        return warrant;
    }

    public void setWarrant(Warrant warrant) {
        this.warrant = warrant;
    }

    @XmlTransient
    public List<Docrow> getDocrowList() {
        return docrowList;
    }

    public void setDocrowList(List<Docrow> docrowList) {
        this.docrowList = docrowList;
    }

    public Bill getBillId() {
        return billId;
    }

    public void setBillId(Bill billId) {
        this.billId = billId;
    }

    public Agency getSupId() {
        return supId;
    }

    public void setSupId(Agency supId) {
        this.supId = supId;
    }

    public Agency getOrgId() {
        return orgId;
    }

    public void setOrgId(Agency orgId) {
        this.orgId = orgId;
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
        if (!(object instanceof Paymentorder)) {
            return false;
        }
        Paymentorder other = (Paymentorder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Paymentorder[ id=" + id + " ]";
    }
    
}
