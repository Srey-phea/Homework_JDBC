package view;

import controller.CustomerController;
import controller.OrderController;
import controller.ProductController;
import exception.ExceptionHandle;


import java.util.Scanner;

public class View {
    private static final CustomerController customerController = new CustomerController();
    private static final OrderController orderController = new OrderController();
    private static final ProductController productController = new ProductController();

    public static void menu() throws ExceptionHandle {
        while (true) {
            System.out.println("============| Food Panda |============");
            System.out.println("1. Display All Data");
            System.out.println("2. Add New Data");
            System.out.println("3. Update Data");
            System.out.println("4. Delete Data");
            System.out.println("0. Exit");
            System.out.println( "=".repeat(38));
            System.out.print("[+] Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            switch(op){
                case 1->queryAllData();
                case 2->addNewData();
                case 3->updateData();
                case 4->deleteData();
                case 0->System.exit(0);
                default -> System.out.println("[+] Invalid option !");
            }
        }
    }

    public static void deleteData() throws ExceptionHandle{
        while (true) {
            System.out.println("===========| Delete System |===========");
            System.out.println("1. Delete Customer");
            System.out.println("2. Delete Order");
            System.out.println("3. Delete Product");
            System.out.println("0. Exit");
            System.out.println( "=".repeat(38));
            System.out.print("[+] Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            switch(op){
                case 1->customerController.deleteCustomer();
                case 2->orderController.deleteOrder();
                case 3->productController.deleteProduct();
                case 0-> {
                    return;
                }
                default -> System.out.println("[+] Invalid option !");
            }
        }
    }

    public static void updateData() throws ExceptionHandle {
        while (true) {
            System.out.println("===========| Update System |===========");
            System.out.println("1. Update Customer");
            System.out.println("2. Update Order");
            System.out.println("3. Update Product");
            System.out.println("0. Exit");
            System.out.println( "=".repeat(38));
            System.out.print("[+] Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            switch(op){
                case 1->customerController.updateCustomer();
                case 2->orderController.updateOrder();
                case 3->productController.updateProduct();
                case 0-> {
                    return;
                }
                default -> System.out.println("[+] Invalid option !");
            }
        }
    }

    public static void addNewData() throws ExceptionHandle {
        while (true) {
            System.out.println("============| Add System |============");
            System.out.println("1. Add New Customer");
            System.out.println("2. Add New Order");
            System.out.println("3. Add New Product");
            System.out.println("0. Back");
            System.out.println( "=".repeat(38));
            System.out.print("[+] Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            switch(op){
                case 1->customerController.addNewCustomer();
                case 2->orderController.addNewOrder();
                case 3->productController.addNewProduct();
                case 0-> {
                    return;
                }
                default -> System.out.println("[+] Invalid option !");
            }
        }
    }

    public static void queryAllData() throws ExceptionHandle {
        while(true){
            System.out.println("==========| Display System |==========");
            System.out.println("1. Display All Customers");
            System.out.println("2. Display All Orders");
            System.out.println("3. Display All Products");
            System.out.println("0. Back");
            System.out.println("=".repeat(38));
            System.out.print("[+] Choose your option: ");
            int op = new Scanner(System.in).nextInt();
            switch(op){
                case 1-> customerController.queryAllCustomers().forEach(System.out::println);
                case 2-> orderController.queryAllOrders().forEach(System.out::println);
                case 3-> productController.queryAllProducts().forEach(System.out::println);
                case 0 -> {
                    return;
                }
                default -> System.out.println("[+] Invalid option !");
            }
        }
    }
}
