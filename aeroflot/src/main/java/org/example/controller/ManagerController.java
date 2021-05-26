package org.example.controller;

import org.example.entity.Manager;
import org.example.entity.Plane;
import org.example.repo.GenericRepo;
import org.example.repo.impl.ManagerRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ManagerController {
    private GenericRepo genericRepo = new ManagerRepoImpl();


    public Manager getManagerById(Long id) throws SQLException {
        return (Manager) genericRepo.getById(id);
    }

    public Manager editManager(Manager manager) throws SQLException {
        return (Manager) genericRepo.update(manager);
    }

    public List<Manager> getAllManagers() throws SQLException {
        return genericRepo.getAll();
    }

    public void saveManager(Manager manager) throws SQLException {
        genericRepo.add(manager);
    }

    public void deleteManager(Long id) throws SQLException {
        genericRepo.delete(id);
    }
}
