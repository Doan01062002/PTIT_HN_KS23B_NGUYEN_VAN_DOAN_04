package ra.validate;

import java.util.Scanner;

public class InputValidator {
    public static String validateString(Scanner sc, String fieldName, int maxLength, boolean allowEmpty) {
        while (true) {
            System.out.printf("Nhập %s: ", fieldName);
            String input = sc.nextLine().trim();
            if ((!allowEmpty && input.isEmpty()) || input.length() > maxLength) {
                System.out.printf("%s không được để trống và tối đa %d ký tự%n", fieldName, maxLength);
                continue;
            }
            return input;
        }
    }

    public static boolean validateGender(Scanner sc) {
        while (true) {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("nam")){
                return true;
            }
            if (input.equals("nữ")){
                return false;
            }
            System.out.println("Giới tính không hợp lệ");
        }
    }

    public static String validateCustomerId(Scanner sc) {
        while (true) {
            System.out.print("Nhập mã khách hàng (Cxxxx): ");
            String input = sc.nextLine().trim();
            if (input.matches("C\\d{4}")){
                return input;
            }
            System.out.println("Mã khách hàng phải bắt đầu bằng 'C' và theo sau là 4 số");
        }
    }
}