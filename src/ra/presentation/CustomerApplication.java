package ra.presentation;

import ra.bussiness.CustomerBusiness;

import java.util.Scanner;

public class CustomerApplication {
    private static final CustomerBusiness customerBusiness = new CustomerBusiness();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------------------------Customer Menu----------------------------");
            System.out.println("1. Hiển thị danh sách các khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Đã thoát chương trình");
                    System.exit(0);
                case 1:
                    customerBusiness.listCustomers();
                    break;
                case 2:
                    customerBusiness.addCustomer(scanner);
                    break;
                case 3:
                    customerBusiness.editCustomer(scanner);
                    break;
                case 4:
                    customerBusiness.deleteCustomer(scanner);
                    break;
                case 5:
                    customerBusiness.searchCustomer(scanner);
                    break;
                case 6:
                    customerBusiness.sortCustomers(scanner);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}