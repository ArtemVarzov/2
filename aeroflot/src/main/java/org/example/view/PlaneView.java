package org.example.view;

import org.example.controller.PilotController;
import org.example.controller.PlaneController;
import org.example.entity.Pilot;
import org.example.entity.Plane;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PlaneView {

    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner1 = new Scanner(System.in);
    private PlaneController planeController = new PlaneController();

    public void showPlanes() throws SQLException {
        List<Plane> planes = planeController.getAllPanes();
        System.out.println("Список самолетов: ");
        planes.forEach(plane1 -> System.out.println(plane1.toString()));
    }

    public void savePlanes() {
        try {
            Plane newPlane = new Plane();

            System.out.println("Введите название самолета :");
            String brand = scanner1.nextLine();
            newPlane.setBrand(brand);

            System.out.println("Введите класс самолета :");
            String clazz = scanner1.nextLine();
            newPlane.setClazz(clazz);

            System.out.println("Введите количество мест в самолете :");
            int numberOfSeats = scanner1.nextInt();
            newPlane.setNumberofseats(numberOfSeats);

            planeController.savePlane(newPlane);
        } catch (
                InputMismatchException | SQLException e) {
            System.out.print(e.getMessage());
        }
    }

    public void deletePlanes() throws SQLException {
        System.out.println("Введите id самолета, которого хотите удалить : ");
        Long id = Long.parseLong(scanner.next());
        planeController.deletePlane(id);
    }

    public void updatePlanes() throws SQLException {
        try {
            System.out.println("Введите id самолета, информацию которого хотите изменить:");
            Long id = Long.parseLong(scanner.next());

            Plane newPlane;
            newPlane = planeController.getPlaneById(id);

            System.out.println("Введите название самолета :");
            String brand = scanner1.nextLine();
            newPlane.setBrand(brand);

            System.out.println("Введите класс самолета :");

            String clazz = scanner1.nextLine();
            newPlane.setClazz(clazz);

            System.out.println("Введите количество мест в самолете :");
            int numberOfSeats = scanner1.nextInt();
            newPlane.setNumberofseats(numberOfSeats);

            planeController.editPlane(newPlane);
        } catch (InputMismatchException e) {
            System.out.print(e.getMessage());
        }
    }

    public void getByIdPlanes() throws SQLException {
        System.out.println("введите id самолета которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (planeController.getPlaneById(id) != null) {
                System.out.println(planeController.getPlaneById(id).toString());
            } else {
                System.out.println("Такого самолета не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdPlanes();
        }
    }

    public void run() throws SQLException {
        boolean go = true;
        while (go) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все самолеты");
            System.out.println(" 2. Добавить новый самолет");
            System.out.println(" 3. Удалить самолет ");
            System.out.println(" 4. Обновить информацию о самолете  ");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showPlanes();
                    break;
                case 2:
                    savePlanes();
                    break;
                case 3:
                    deletePlanes();
                    break;
                case 4:
                    updatePlanes();
                    break;
                case 5:
                    getByIdPlanes();
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
