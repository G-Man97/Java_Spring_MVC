package com.gmalykhin.mvc.dao;

import com.gmalykhin.mvc.entity.Department;
import com.gmalykhin.mvc.dto.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    private DepartmentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Department> getAllDepartments() {
        Session session = sessionFactory.getCurrentSession();
        Query<Department> query = session.createQuery("from Department ", Department.class);

        return query.getResultList();
    }

    @Override
    public Department getDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class, id);
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<?> query = session.createQuery("delete from Department where id = :departmentId");

        query.setParameter("departmentId", id);
        query.executeUpdate();
    }

    @Override
    public void saveDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);
    }

    @Override
    public List<AverageSalaryByDepartmentDTO> getAvgSalaryByDepartment() {
        Session session = sessionFactory.getCurrentSession();

        Query<AverageSalaryByDepartmentDTO> query = session.createQuery("select new com.gmalykhin.mvc.dto" +
                ".AverageSalaryByDepartmentDTO(d.departmentName, avg(e.salary)) " +
                "from Department d join Employee e ON (d.id = e.department) group by d.departmentName", AverageSalaryByDepartmentDTO.class);

        return query.getResultList();
    }

    @Override
    public List<EmployeeDTO> getEmpByDepartment() {
        Session session = sessionFactory.getCurrentSession();

        Query<EmployeeDTO> query = session.createQuery("select new com.gmalykhin.mvc.dto.EmployeeDTO(e.id, e.name, e.surname, e.salary, d.departmentName) " +
                "from Department d join Employee e ON (d.id = e.department) order by d.departmentName", EmployeeDTO.class);

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
