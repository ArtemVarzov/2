package org.example.repo.impl;

import org.example.entity.Plane;
import org.example.repo.GenericRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class PlaneRepoImpl implements GenericRepo <Plane, Long> {

    private Session session;
    private Transaction transaction;

    @Override
    public void add(Plane plane) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(plane);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Plane> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Plane ";
        List<Plane> planes = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return planes;
    }

    @Override
    public Plane getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Plane plane = session.get(Plane.class, id);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public Plane update(Plane plane) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(plane);
        transaction.commit();
        session.close();
        return plane;
    }

    @Override
    public void delete(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Plane plane = session.get(Plane.class, id);
        session.remove(plane);
        transaction.commit();
        session.close();
    }
}
