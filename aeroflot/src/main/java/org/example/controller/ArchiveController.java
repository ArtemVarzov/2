package org.example.controller;

import org.example.entity.Archive;
import org.example.repo.GenericRepo;
import org.example.repo.impl.ArchiveRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ArchiveController {
    private GenericRepo genericRepo = new ArchiveRepoImpl();


    public List<Archive> getAllArchive() throws SQLException {
        return genericRepo.getAll();
    }

}
