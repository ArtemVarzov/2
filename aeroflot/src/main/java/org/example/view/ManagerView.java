package org.example.view;

import org.example.controller.ManagerController;
import org.example.entity.Manager;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ManagerView {

    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private ManagerController managerController = new ManagerController();

    public void showManagers() throws SQLException {
        List<Manager> managers = managerController.getAllManagers();
        System.out.println("Список Менеджеров: ");
        managers.forEach(m1 -> System.out.println(m1.toString()));
    }

    public void saveManger() {
        try {
            Manager newManager = new Manager();

            System.out.println("Введите имя :");
            String name = scanner1.nextLine();
            newManager.setName(name);

            System.out.println("Введите номер телефона :");
            String tel = scanner1.nextLine();
            newManager.setTelephone(tel);

            System.out.println("Введите эл. почту :");
            String mail = scanner1.nextLine();
            newManager.setMail(mail);

            managerController.saveManager(newManager);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deleteManager() throws SQLException {
        System.out.println("Введите id менеджера, которого хотите удалить : ");
        Long id = Long.parseLong(scanner.next());
        managerController.deleteManager(id);
    }

    public void updateManager() throws SQLException {
        try {
            System.out.println("Введите id менеджера, информацию которого хотите изменить:");
            Long id = Long.parseLong(scanner.next());

            Manager newManager;
            newManager = managerController.getManagerById(id);

            System.out.println("Введите имя :");
            String name = scanner1.nextLine();
            newManager.setName(name);

            System.out.println("Введите номер телефона :");
            String tel = scanner1.nextLine();
            newManager.setTelephone(tel);

            System.out.println("Введите эл. почту :");
            String mail = scanner1.nextLine();
            newManager.setMail(mail);

            managerController.editManager(newManager);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdManager() throws SQLException {
        System.out.println("введите id менеджера которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (managerController.getManagerById(id) != null) {
                System.out.println(managerController.getManagerById(id).toString());
            } else {
                System.out.println("Такого меннеджера не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdManager();
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать список менеджеров");
            System.out.println(" 2. Добавить нового менеджера");
            System.out.println(" 3. Удалить меннеджера ");
            System.out.println(" 4. Обновить информацию о менеджере  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showManagers();
                    break;
                case 2:
                    saveManger();
                    break;
                case 3:
                    deleteManager();
                    break;
                case 4:
                    updateManager();
                    break;
                case 5:
                    getByIdManager();
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
