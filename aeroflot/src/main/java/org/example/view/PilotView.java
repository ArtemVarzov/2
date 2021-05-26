package org.example.view;

import org.example.controller.PilotController;
import org.example.entity.Pilot;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PilotView {
    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private PilotController pilotController = new PilotController();

    public void showPilots() throws SQLException {
        List<Pilot> pilots = pilotController.getAllPilots();
        System.out.println("Список пилотов: ");
        pilots.forEach(pilot1 -> System.out.println(pilot1.toString()));
    }

    public void savePilot() {
        try {
            Pilot newPilot = new Pilot();

            System.out.println("Введите имя :");
            String name = scanner1.nextLine();
            newPilot.setName(name);

            System.out.println("Введите имэил :");
            String mail = scanner1.nextLine();
            newPilot.setMail(mail);

            System.out.println("Введите номер телефона :");
            String telephone = scanner1.nextLine();
            newPilot.setTelephone(telephone);

            System.out.println("Введите дату рождения :");
            String dayOfBirth = scanner1.nextLine();
            newPilot.setDayofbirthday(dayOfBirth);

            pilotController.savePilot(newPilot);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deletePilot() throws SQLException {
        System.out.println("Введите id пилота, которого хотите удалить : ");
        Long id = Long.parseLong(scanner.next());
        pilotController.deletePilot(id);
    }

    public void updatePilot() throws SQLException {
        try {
            System.out.println("Введите id пилота, информацию которого хотите изменить:");
            Long id = Long.parseLong(scanner.next());

            Pilot newPilot;
            newPilot = pilotController.getPilotById(id);

            System.out.println("Введите имя :");
            String name = scanner1.nextLine();
            newPilot.setName(name);

            System.out.println("Введите имэил :");
            String mail = scanner1.nextLine();
            newPilot.setMail(mail);

            System.out.println("Введите номер телефона :");
            String telephone = scanner1.nextLine();
            newPilot.setTelephone(telephone);

            System.out.println("Введите дату рождения :");
            String dayOfBirth = scanner1.nextLine();
            newPilot.setDayofbirthday(dayOfBirth);

            pilotController.editPilot(newPilot);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdPilot() throws SQLException {
        System.out.println("введите id пилота которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (pilotController.getPilotById(id) != null) {
                System.out.println(pilotController.getPilotById(id).toString());
            } else {
                System.out.println("Такого пилота не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdPilot();
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех пилотов");
            System.out.println(" 2. Добавить нового пилота");
            System.out.println(" 3. Удалить пилота ");
            System.out.println(" 4. Обновить информацию о пилоте  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showPilots();
                    break;
                case 2:
                    savePilot();
                    break;
                case 3:
                    deletePilot();
                    break;
                case 4:
                    updatePilot();
                    break;
                case 5:
                    getByIdPilot();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Неверное число!");
                    System.out.println("Введите число от 1 до 6, пожалуйста");
            }
        }
    }
}
