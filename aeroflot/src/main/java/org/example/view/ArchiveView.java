package org.example.view;

import org.example.controller.ArchiveController;
import org.example.entity.Archive;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ArchiveView {
    private ArchiveController archiveController = new ArchiveController();

    public void showArchive() throws SQLException {
        List<Archive> archives = archiveController.getAllArchive();
        System.out.println("Архив: ");
        archives.forEach(archive1 -> System.out.println(archive1.toString()));
    }


    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать архив");
            System.out.println(" 2. Выход");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showArchive();
                    break;
                case 2:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
                    System.out.println("Введите число от 1 до 2, пожалуйста");
            }
        }
    }
}
