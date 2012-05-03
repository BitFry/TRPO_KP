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
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByPost", query = "SELECT e FROM Employee e WHERE e.post = :post"),
    @NamedQuery(name = "Employee.findBySeries", query = "SELECT e FROM Employee e WHERE e.series = :series"),
    @NamedQuery(name = "Employee.findByPnumber", query = "SELECT e FROM Employee e WHERE e.pnumber = :pnumber"),
    @NamedQuery(name = "Employee.findByIssueDate", query = "SELECT e FROM Employee e WHERE e.issueDate = :issueDate"),
    @NamedQuery(name = "Employee.findByIssuedBy", query = "SELECT e FROM Employee e WHERE e.issuedBy = :issuedBy")})
public class Employee implements Serializable {
    @Basic(optional = false)
    @Column(name = "ISSUE_DATE")
    @Temporal(TemporalType.DATE)
    private Date issueDate;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "POST")
    private String post;
    @Basic(optional = false)
    @Column(name = "SERIES")
    private String series;
    @Basic(optional = false)
    @Column(name = "PNUMBER")
    private String pnumber;
    @Basic(optional = false)
    @Column(name = "ISSUED_BY")
    private String issuedBy;
    @JoinColumn(name = "DEP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department depId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplId", fetch = FetchType.LAZY)
    private List<Warrant> warrantList;

    public Employee() {
    }

    public Employee(BigDecimal id) {
        this.id = id;
    }

    public Employee(BigDecimal id, String name, String post, String series, String pnumber, Date issueDate, String issuedBy) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.series = series;
        this.pnumber = pnumber;
        this.issueDate = issueDate;
        this.issuedBy = issuedBy;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Department getDepId() {
        return depId;
    }

    public void setDepId(Department depId) {
        this.depId = depId;
    }

    @XmlTransient
    public List<Warrant> getWarrantList() {
        return warrantList;
    }

    public void setWarrantList(List<Warrant> warrantList) {
        this.warrantList = warrantList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Employee[ id=" + id + " ]";
    }

    public double getWarrantsSumIncludingTaxes(Date from, Date until) {
        /*EntityManager entityManager = OrganisationControl.getEntityManager();
        entityManager.refresh(this);*/
        List<Warrant> lst = warrantList;
        double result = 0;
        for (Warrant warrant : lst) {
            if (warrant.checkDate(from, until)) {
                result += warrant.getWarrantsSumIncludingTaxes(from, until);
            }
        }
        //entityManager.close();
        return result;
    }
}
