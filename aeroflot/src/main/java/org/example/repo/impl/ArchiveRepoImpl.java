package org.example.repo.impl;

import org.example.entity.Archive;
import org.example.entity.Manager;
import org.example.repo.GenericRepo;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ArchiveRepoImpl implements GenericRepo<Archive, Long> {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Archive archive) throws SQLException {

    }

    @Override
    public List<Archive> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Archive";
        List<Archive> archives = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return archives;
    }

    @Override
    public Archive getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Archive update(Archive archive) throws SQLException {
        return null;
    }

    @Override
    public void delete(Long id) throws SQLException {

    }
}
