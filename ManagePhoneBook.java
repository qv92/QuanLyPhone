

import java.util.Scanner;

public class ManagePhoneBook {
    static PhoneBook pb = new PhoneBook();
    static Scanner scanner = new Scanner(System.in);
    static String name, phone;

    static void menu() {
        System.out.println("Quản lý danh bạ");
        System.out.println("1. Thêm sđt");
        System.out.println("2. Xóa sđt");
        System.out.println("3. Sửa sđt");
        System.out.println("4. Tìm kiếm");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Thoát");
    }

    public static void main(String[] args) {
        menu();
        while (true) {
            System.out.print("Nhập lựa chọn: ");
            switch (scanner.nextInt()) {
                case 1:
                    insertPhone();
                    break;
                case 2:
                    removePhone();
                case 3:
                    updatePhone();
                    break;
                case 4:
                    searchPhone();
                    break;
                case 5:
                    sortPhone();
                    break;
                case 6:
                    return;
            }
        }
    }


    private static void updatePhone() {
        boolean searched = false;
        scanner.nextLine();
        System.out.print("Nhập tên muốn sửa: ");
        name = scanner.nextLine();
        for (String s : pb.PhoneList) {
            if (name.equals(s.substring(0, s.indexOf(",")))) {
                searched = true;
                System.out.print("Nhập tên: ");
                phone = scanner.nextLine();
                pb.updatePhone(name, phone);
                break;
            }
        }
        if (!searched) System.out.println("Không tìm thấy: " + name);
    }
    private static void searchPhone() {
        scanner.nextLine();
        System.out.print("Nhập tên muốn tìm: ");
        name = scanner.nextLine();
        pb.searchPhone(name);
    }
    private static void removePhone() {
        scanner.nextLine();
        System.out.print("Nhập tên muốn xóa: ");
        name = scanner.nextLine();
        pb.removePhone(name);
    }


    private static void sortPhone() {
        pb.sort();
    }

    private static void insertPhone() {
        scanner.nextLine();
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập số đt: ");
        phone = scanner.nextLine();
        pb.insertPhone(name, phone);
    }
}

