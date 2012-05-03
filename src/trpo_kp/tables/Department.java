/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.tables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import trpo_kp.control.OrganisationControl;

/**
 *
 * @author Администратор
 */
@Entity
@Table(name = "DEPARTMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findById", query = "SELECT d FROM Department d WHERE d.id = :id"),
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")})
@SequenceGenerator(name="DepartmentSeq", sequenceName="DEPARTMENT_SEQ", initialValue=1000, allocationSize=1)
public class Department implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="DepartmentSeq")
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    @JoinColumn(name = "ORG_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agency orgId;

    public Department() {
    }

    public Department(BigDecimal id) {
        this.id = id;
    }

    public Department(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        BigDecimal oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Agency getOrgId() {
        return orgId;
    }

    public void setOrgId(Agency orgId) {
        Agency oldOrgId = this.orgId;
        this.orgId = orgId;
        changeSupport.firePropertyChange("orgId", oldOrgId, orgId);
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trpo_kp.tables.Department[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    public double getWarrantsSumIncludingTaxes(Date from, Date until){
        /*EntityManager entityManager = OrganisationControl.getEntityManager();
        entityManager.merge(this);
        entityManager.refresh(this);*/
        List<Employee> lst = employeeList;
        double result = 0;
        for (Employee employee : lst) {
            //System.out.println(employee.getName());
            result += employee.getWarrantsSumIncludingTaxes(from, until);
        }
        //entityManager.close();
        return result;
    }
    public Employee findEmployee(String name){
        for (Employee employee : employeeList) {
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
}
