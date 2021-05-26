package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class View {
    private static View view;
    private PilotView pilotView;
    private PlaneView planeView;
    private ManagerView managerView;
    private ArchiveView archiveView;

    private View() {
        pilotView = new PilotView();
        planeView = new PlaneView();
        managerView = new ManagerView();
        archiveView = new ArchiveView();
    }

    public static View getInstance() {
        if (view == null) {
            view = new View();
        }
        return view;
    }

    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Пилот");
            System.out.println("2. Самолет");
            System.out.println("3. Менаджер");
            System.out.println("4. Архив");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runPilot();
                    break;
                case 2:
                    runPlane();
                    break;
                case 3:
                    runManager();
                    break;
                case 4:
                    runArchive();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runPilot() throws SQLException {
        pilotView.run();
    }

    private void runPlane() throws SQLException {
        planeView.run();
    }

    private void runManager() throws SQLException {
        managerView.run();
    }
    private void runArchive() throws SQLException {
        archiveView.run();
    }
}
