package ra.bussiness;

import ra.entity.Customer;
import ra.validate.InputValidator;

import java.util.Scanner;

public class CustomerBusiness {
    private static final int MAX_CUSTOMERS = 100;
    private Customer[] customers = new Customer[MAX_CUSTOMERS];
    private int customerCount = 0;

    public void listCustomers() {
        if (customerCount == 0) {
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < customerCount; i++) {
            customers[i].displayData();
        }
    }

    public void addCustomer(Scanner sc) {
        if (customerCount >= MAX_CUSTOMERS) {
            System.out.println("Danh sách đã đầy");
            return;
        }

        System.out.print("Nhập số lượng khách hàng cần thêm: ");
        int count = Integer.parseInt(sc.nextLine());
        if (count <= 0 || count > MAX_CUSTOMERS - customerCount) {
            System.out.println("Số lượng không hợp lệ");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.printf("Nhập thông tin khách hàng thứ %d:%n", i + 1);
            String id = InputValidator.validateCustomerId(sc);
            if (isCustomerIdExists(id)) {
                System.out.println("Mã khách hàng đã tồn tại");
                i--;
                continue;
            }
            Customer customer = new Customer(id);
            customer.inputData(sc);
            customers[customerCount++] = customer;
        }
        System.out.println("Thêm khách hàng thành công");
    }

    public void editCustomer(Scanner sc) {
        String id = InputValidator.validateCustomerId(sc);
        Customer customer = findCustomerById(id);
        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        customer.displayData();
        System.out.println("Chọn thuộc tính cần sửa (1-8):");
        System.out.println("1. Tên - 2. Họ - 3. Ngày sinh - 4. Giới tính - 5. Địa chỉ - 6. SĐT - 7. Email - 8. Loại Khách Hanàng");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                customer.setFirstName(InputValidator.validateString(sc, "Tên", 50, false));
                break;
            case 2:
                customer.setLastName(InputValidator.validateString(sc, "Họ", 30, false));
                break;
            case 3:
                System.out.print("Nhập ngày sinh mới: ");
                customer.setDateOfBirth(sc.nextLine().trim());
                break;
            case 4:
                customer.setGender(InputValidator.validateGender(sc));
                break;
            case 5:
                customer.setAddress(InputValidator.validateString(sc, "Địa chỉ", 255, false));
                break;
            case 6:
                System.out.print("Nhập số điện thoại mới: ");
                customer.setPhoneNumber(sc.nextLine().trim());
                break;
            case 7:
                System.out.print("Nhập email mới: ");
                customer.setEmail(sc.nextLine().trim());
                break;
            case 8:
                customer.setCustomerType(InputValidator.validateString(sc, "Loại KH", 50, false));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }
        System.out.println("Chỉnh sửa thành công");
    }

    public void deleteCustomer(Scanner sc) {
        String id = InputValidator.validateCustomerId(sc);
        int index = findCustomerIndexById(id);
        if (index == -1) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        customers[index].displayData();
        System.out.print("Xác nhận xóa (Y/N): ");
        if (sc.nextLine().trim().equalsIgnoreCase("Y")) {
            for (int i = index; i < customerCount - 1; i++) {
                customers[i] = customers[i + 1];
            }
            customers[--customerCount] = null;
            System.out.println("Xóa thành công");
        }
    }

    public void searchCustomer(Scanner sc) {
        System.out.println("1. Theo tên - 2. Theo loại KH - 3. Theo SĐT");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập từ khóa: ");
        String keyword = sc.nextLine().trim().toLowerCase();

        boolean found = false;
        for (int i = 0; i < customerCount; i++) {
            switch (choice) {
                case 1:
                    if (customers[i].getFirstName().toLowerCase().contains(keyword)) {
                        customers[i].displayData();
                        found = true;
                    }
                    break;
                case 2:
                    if (customers[i].getCustomerType().toLowerCase().contains(keyword)) {
                        customers[i].displayData();
                        found = true;
                    }
                    break;
                case 3:
                    if (customers[i].getPhoneNumber().contains(keyword)) {
                        customers[i].displayData();
                        found = true;
                    }
                    break;
            }
        }
        if (!found) System.out.println("Không tìm thấy kết quả phù hợp");
    }

    public void sortCustomers(Scanner sc) {
        System.out.println("Chức năng sắp xếp em chưa làm kịp ạ.");
    }

    private boolean isCustomerIdExists(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Customer findCustomerById(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                return customers[i];
            }
        }
        return null;
    }

    private int findCustomerIndexById(String id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}