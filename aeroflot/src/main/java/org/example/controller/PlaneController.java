package org.example.controller;

import org.example.entity.Plane;
import org.example.repo.GenericRepo;
import org.example.repo.impl.PlaneRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class PlaneController {
    private GenericRepo genericRepo = new PlaneRepoImpl();

    public Plane getPlaneById(Long id) throws SQLException {
        return (Plane) genericRepo.getById(id);
    }

    public Plane editPlane(Plane plane) throws SQLException {
        return (Plane) genericRepo.update(plane);
    }

    public List<Plane> getAllPanes() throws SQLException {
        return genericRepo.getAll();
    }

    public void savePlane(Plane plane) throws SQLException {
        genericRepo.add(plane);
    }

    public void deletePlane(Long id) throws SQLException {
        genericRepo.delete(id);
    }

}
