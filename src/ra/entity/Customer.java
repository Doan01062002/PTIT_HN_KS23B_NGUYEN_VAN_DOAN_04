package ra.entity;

import ra.validate.InputValidator;

import java.util.Scanner;

public class Customer implements IApp {
    private String customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String customerType;

    public Customer() {
    }

    public Customer(String customerId) {
        this.customerId = customerId;
    }

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        this.firstName = InputValidator.validateString(sc, "Tên khách hàng", 50, false);
        this.lastName = InputValidator.validateString(sc, "Họ khách hàng", 30, false);
        System.out.print("Nhập ngày sinh: ");
        this.dateOfBirth = sc.nextLine().trim();
        this.gender = InputValidator.validateGender(sc);
        this.address = InputValidator.validateString(sc, "Địa chỉ", 255, false);
        System.out.print("Nhập số điện thoại: ");
        this.phoneNumber = sc.nextLine().trim();
        System.out.print("Nhập email: ");
        this.email = sc.nextLine().trim();
        this.customerType = InputValidator.validateString(sc, "Loại khách hàng", 50, false);
    }

    @Override
    public void displayData() {
        System.out.printf("Mã KH: %s - Họ: %s - Tên: %s - Ngày sinh: %s - Giới tính: %s%n", customerId, lastName, firstName, dateOfBirth, gender ? "Nam" : "Nữ");
        System.out.printf("Địa chỉ: %s - SĐT: %s - Email: %s - Loại KH: %s%n", address, phoneNumber, email, customerType);
        System.out.println("----------------------------------------");
    }
}
