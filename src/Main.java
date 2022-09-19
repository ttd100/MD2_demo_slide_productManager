import ra.entity.Product;

import java.util.Scanner;

public class Main {

    //khoi tao mang toan cuc
    static Product[] arrProduct = new Product[1000];
    static int index = -1;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //xay dung menu
        do {
            System.out.println("*******MENU*******");
            System.out.println("1.nhap thong tin cac san pham");
            System.out.println("2.tinh gia ban cac san pham");
            System.out.println("3.hien thi thong tin cac san pham");
            System.out.println("4.tim kiem cac san pham");
            System.out.println("5.sap xep cac sam pham theo gia tang dan");
            System.out.println("6.thoat");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Main.inputListProduct(sc);
                    break;
                case 2:
                    Main.calListExportPrice();
                    break;
                case 3:
                    Main.displayListProduct();
                    break;
                case 4:
                    Main.searchProductByName(sc);
                    break;
                case 5:
                    Main.sortByExportPriceASC();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("nhap tu 1 den 6");
            }
        }while (true);

    }
    public static void inputListProduct(Scanner sc){
        System.out.println("nhap so luong san pham can nhap thong tin: ");
        int cnt = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cnt; i++) {
            // khoi tao doi tuong san pham de nhap thong tin
            Product pro = new Product();
            pro.inputData(sc);
            // them san pham vao danh sach san pham
            index++;
            arrProduct[index] = pro;
        }
    }
    public static void displayListProduct(){
        for (int i = 0; i <= index; i++) {
            arrProduct[i].displayData();
        }
    }
    public static void calListExportPrice(){
        //Duyen tung phan tu
        for (int i = 0; i <= index; i++) {
            //Đối tượng product
            arrProduct[i].calExportPrice();
        }
    }
    public static void searchProductByName(Scanner sc){
        //Dung co kiem tra trong danh sach có tên cần tìm hay không
        boolean checkExist = false;
        //false là không tồn tại, true là có tồn tại
        //1.nhap ten san pham can tim
        System.out.println("nhap ten san pham can tim");
        String strSearch = sc.nextLine();
        //Duyet tung san pham
        for (int i = 0; i <= index; i++){
            //3.So sanh ten san pham can tìm với ten của từng sản phẩm trong danh sách
            if (arrProduct[i].getProductName().equals(strSearch)){
                Main.displayListProduct();
                checkExist = true;
            }
        }
        if (!checkExist) {
            System.out.println("không tồn tại sản phẩm nào có tên trong danh sách");
        }
    }
    public static void sortByExportPriceASC(){
        for (int i = 0; i < index; i++) {
            for (int j = i+1; j <= index ; j++) {
                if (arrProduct[i].getExportPrice() > arrProduct[j].getExportPrice()) {
                    // doi cho 2 phan tu
                    Product temp = arrProduct[i];
                    arrProduct[i] = arrProduct[j];
                    arrProduct[j] = temp;
                }
            }
        }
        System.out.println("Da sap xep cac san pham theo gia ban tang dan");
    }

}