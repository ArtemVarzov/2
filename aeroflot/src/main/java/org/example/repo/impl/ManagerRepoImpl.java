package org.example.repo.impl;

import org.example.entity.Manager;
import org.example.entity.Pilot;
import org.example.repo.GenericRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ManagerRepoImpl implements GenericRepo<Manager, Long> {

    private Session session;
    private Transaction transaction;

    @Override
    public void add(Manager manager) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Manager> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Manager ";
        List<Manager> managers = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return managers;
    }

    @Override
    public Manager getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Manager manager = session.get(Manager.class, id);
        transaction.commit();
        session.close();
        return manager;
    }

    @Override
    public Manager update(Manager manager) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(manager);
        transaction.commit();
        session.close();
        return manager;
    }

    @Override
    public void delete(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Manager manager = session.get(Manager.class, id);
        session.remove(manager);
        transaction.commit();
        session.close();
    }
}
