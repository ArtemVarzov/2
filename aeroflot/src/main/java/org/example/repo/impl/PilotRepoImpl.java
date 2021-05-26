package org.example.repo.impl;

import org.example.entity.Pilot;
import org.example.repo.GenericRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class PilotRepoImpl implements GenericRepo<Pilot, Long> {
    private Session  session;
    private Transaction transaction;

    @Override
    public void add(Pilot pilot) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(pilot);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Pilot> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Pilot ";
        List<Pilot> pilots = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return pilots;
    }

    @Override
    public Pilot getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Pilot pilot = session.get(Pilot.class, id);
        transaction.commit();
        session.close();
        return pilot;
    }

    @Override
    public Pilot update(Pilot pilot) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(pilot);
        transaction.commit();
        session.close();
        return pilot;
    }

    @Override
    public void delete(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Pilot pilot = session.get(Pilot.class, id);
        session.remove(pilot);
        transaction.commit();
        session.close();
    }
}
