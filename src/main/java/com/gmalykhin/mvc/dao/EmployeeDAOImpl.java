package com.gmalykhin.mvc.dao;

import com.gmalykhin.mvc.dto.EmployeeDTO;
import com.gmalykhin.mvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public List<EmployeeDTO> getEmpByDepartment() {
        Session session = sessionFactory.getCurrentSession();

        Query<EmployeeDTO> query = session.createQuery("select new com.gmalykhin.mvc.dto" +
                ".EmployeeDTO(e.id, e.name, e.surname, e.salary, d.departmentName) " +
                "from Department d join Employee e ON (d.id = e.department) " +
                "order by d.departmentName", EmployeeDTO.class);

        return query.list();
    }

    @Override
    public List<EmployeeDTO> searchEmployee(List<String> strData) {
        Session session = sessionFactory.getCurrentSession();

        Query<EmployeeDTO> query = session.createQuery("select new com.gmalykhin.mvc.dto" +
                ".EmployeeDTO(e.id, e.name, e.surname, e.salary, d.departmentName) " +
                "from Department d join Employee e ON (d.id = e.department) " +
                "where e.birthday between :fD and :sD order by d.departmentName", EmployeeDTO.class);
        query.setParameter("fD", strData.get(0));
        query.setParameter("sD", strData.get(1));

        return query.list();
    }
}
