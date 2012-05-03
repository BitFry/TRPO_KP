/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.panels;

import java.util.Vector;
import trpo_kp.tables.Agency;
import trpo_kp.tables.Employee;
import trpo_kp.tables.Paymentorder;

/**
 *
 * @author Администратор
 */
public class resultInfo {

    private Agency org = null;
    private Paymentorder paymentorder = null;
    private Employee employee = null;

    public resultInfo(){
    }
    
    public resultInfo(Agency org, Paymentorder paymentorder, Employee employee, Vector rowData) {
        this.org = org;
        this.paymentorder = paymentorder;
        this.employee = employee;
        this.rowData = rowData;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRowData(Vector rowData) {
        this.rowData = rowData;
    }
    private Vector rowData;

    /**
     * Get the value of paymentorder
     *
     * @return the value of paymentorder
     */
    public Paymentorder getPaymentorder() {
        return paymentorder;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Vector getRowData() {
        return rowData;
    }

    /**
     * Set the value of paymentorder
     *
     * @param paymentorder new value of paymentorder
     */
    public void setPaymentorder(Paymentorder paymentorder) {
        this.paymentorder = paymentorder;
    }


    /**
     * Get the value of org
     *
     * @return the value of org
     */
    public Agency getOrg() {
        return org;
    }

    /**
     * Set the value of org
     *
     * @param org new value of org
     */
    public void setOrg(Agency org) {
        this.org = org;
    }

}
