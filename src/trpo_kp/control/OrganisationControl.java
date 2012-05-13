/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trpo_kp.control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import trpo_kp.tables.Agency;
import trpo_kp.tables.Department;
import trpo_kp.tables.Employee;
import trpo_kp.tables.Paymentorder;

/**
 *
 * @author Администратор
 */
public class OrganisationControl {

    private static String orgName = "Моя уютная контора";
    private static Agency org = null;
    private static EntityManagerFactory emf = null;
    //private static EntityManager em = null;

    public static void initEntityManagerFactory() {
        try {
            emf = Persistence.createEntityManagerFactory("TRPO_KPPU");
            //em = emf.createEntityManager();
            getOrg();
        } catch (javax.persistence.PersistenceException e) {
            emf = null;
            javax.swing.JOptionPane.showMessageDialog(null, e.getLocalizedMessage(), "Ошибка", javax.swing.JOptionPane.ERROR_MESSAGE);
            //e.printStackTrace();
        }
    }
    
    private static void getOrg(){
        if(emf == null){return;}
        EntityManager em = emf.createEntityManager();
        TypedQuery<Agency> query = em.createNamedQuery("Agency.findByName", Agency.class);
        query.setParameter("name", orgName);
        org = query.getSingleResult();
        em.close();
    }
    public static Agency getOrganisation(){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        org = em.merge(org);
        em.refresh(org);
        em.close();
        return org;
    }
    public static EntityManager getEntityManager(){
        if(emf == null){return null;}
        return emf.createEntityManager();
    }
    public static List<Department> getDepartments(){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        org = em.merge(org);
        em.refresh(org);
        List<Department> departmentList = org.getDepartmentList();
        em.close();
        return departmentList;
    }
    public static List<Paymentorder> getPaymentOrders(){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        org = em.merge(org);
        em.refresh(org);
        List<Paymentorder> paymentorderList = org.getPaymentorderList();
        em.close();
        return paymentorderList;
    }
    public static List<Paymentorder> getFreePaymentOrders(){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        //org = em.merge(org);
        //em.refresh(org);
        TypedQuery<Paymentorder> findpo = em.createNamedQuery("Paymentorder.findFreeByOrgId", Paymentorder.class);
        //findpo.setParameter("orgid", org.getId());
        List<Paymentorder> paymentorderList = findpo.getResultList();
        em.close();
        return paymentorderList;
    }
    public static Department findDepartment(String DepName){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        org = em.merge(org);
        em.refresh(org);
        Department findDepartment = org.findDepartment(DepName);
        em.close();
        return findDepartment;
    }
    public static Paymentorder findPaymentOrder(BigDecimal Id){
        if(emf == null){return null;}
        EntityManager em = emf.createEntityManager();
        org = em.merge(org);
        em.refresh(org);
        Paymentorder findPaymentOrder = org.findPaymentOrder(Id);
        em.close();
        return findPaymentOrder;
    }
    public static double getWarrantsSumIncludingTaxes(Date from, Date until, Department dep){
        if(emf == null){return 0.0;}
        EntityManager em = emf.createEntityManager();
        dep = em.merge(dep);
        em.refresh(dep);
        double warrantsSumIncludingTaxes = dep.getWarrantsSumIncludingTaxes(from, until);
        em.close();
        return warrantsSumIncludingTaxes;
    }
    /*Не знаю нахера здесь этот метод но пока удалять не буду*/
    public static void test(){
        if(emf == null){return;}
        EntityManager em = emf.createEntityManager();
        Department find = em.find(Department.class, new BigDecimal(1));
        em.close();
        List<Employee> employeeList = find.getEmployeeList();
        for (Employee employee : employeeList) {
            System.out.println(employee.getName());
        }
    }
}
/* заметки на полях:
 * если пользоваться одним EntityManager то refresh работает нормально,
 * если в каждой операции открывать и закрывать EntityManager то refresh выдаёт эксепшн и перед ним нужно делать merge.
 * 
 * Соответственно можно использовать один EntityManager для работы с объектом организация, а в остальных бизнес функциях
 * использовать способ: открыть EntityManager в начале и закрыть в конце функции.(плюс транзакции).
 */
