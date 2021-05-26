package org.example.controller;

import org.example.entity.Pilot;
import org.example.repo.GenericRepo;
import org.example.repo.impl.PilotRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class PilotController {
    private GenericRepo genericRepo = new PilotRepoImpl();

    public Pilot getPilotById(Long id) throws SQLException {
        return (Pilot) genericRepo.getById(id);
    }

    public Pilot editPilot(Pilot pilot) throws SQLException {
        return (Pilot) genericRepo.update(pilot);
    }

    public List<Pilot> getAllPilots() throws SQLException {
        return genericRepo.getAll();
    }

    public void savePilot(Pilot pilot) throws SQLException {
        genericRepo.add(pilot);
    }

    public void deletePilot(Long id) throws SQLException {
        genericRepo.delete(id);
    }
}
