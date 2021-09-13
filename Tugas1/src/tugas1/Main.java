// Stanley Mesa Ariel - A11.2019.11665
package tugas1;


import java.util.Scanner;


public class Main {
    
    public static void menu() {
        System.out.println("===================================================================");
        System.out.println("\tCRUD Data Mahasiswa");
        System.out.println("===================================================================");
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Search");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("0. Exit");
        System.out.println("===================================================================");
    }
    
  
    
    public static boolean aksiCreate(Scanner scanner, CRUD client) {
        System.out.println("===================================================================");
        System.out.println("\tCreate Data");
        System.out.println("===================================================================");

        System.out.print("Nama\t: ");
        String nama = scanner.next();
        System.out.print("NIM\t: ");
        String nim = scanner.next();
        System.out.print("Alamat\t: ");
        String alamat = scanner.next();

        client.create(nama, nim, alamat);

        System.out.println("Data berhasil masuk!");
        
        boolean bool = true;
        boolean ulang = true;

        while (ulang) {
            System.out.print("Kembali ke menu? (y/n) : ");
            String repeat = scanner.next();

            if (repeat.equals("y")) {
                bool = true;
                ulang = false;
            } else if (repeat.equals("n")){
                bool = false;
                ulang = false;
            } else {
               ulang = true;
            }
        }
        System.out.println("\n\n");
        return bool;
    }
    
    public static boolean aksiRead(Scanner scanner, CRUD client) {
        System.out.println("===================================================================");
        System.out.println("\tCreate Data");
        System.out.println("===================================================================");
        
        client.read();
        
        boolean bool = true;
        boolean ulang = true;

        while (ulang) {
            System.out.print("Kembali ke menu? (y/n) : ");
            String repeat = scanner.next();

            if (repeat.equals("y")) {
                bool = true;
                ulang = false;
            } else if (repeat.equals("n")){
                bool = false;
                ulang = false;
            } else {
               ulang = true;
            }
        }
        System.out.println("\n\n");
        return bool;
        
    }
    
    public static boolean aksiSearch(Scanner scanner, CRUD client) {
        System.out.println("===================================================================");
        System.out.println("\tSearch Data");
        System.out.println("===================================================================");
        
        System.out.print("Cari Mahasiswa\t: ");
        String hint = scanner.next();
        
        client.search(hint);
        
        boolean bool = true;
        boolean ulang = true;
        
        while (ulang) {
            System.out.print("Kembali ke menu? (y/n) : ");
            String repeat = scanner.next();

            if (repeat.equals("y")) {
                bool = true;
                ulang = false;
            } else if (repeat.equals("n")){
                bool = false;
                ulang = false;
            } else {
               ulang = true;
            }
        }
        System.out.println("\n\n");
        return bool;
        
    }
    
    public static boolean aksiUpdate(Scanner scanner, CRUD client) {
        System.out.println("===================================================================");
        System.out.println("\tUpdate Data");
        System.out.println("===================================================================");
        
        client.read();
        
        
        boolean bool = true;
        boolean ulang = true;
        
        while (ulang) {
            System.out.print("NIM Mahasiswa yang ingin di-update (0 untuk keluar) : ");
            String nim = scanner.next();
            if (nim.equals("0")) {
                ulang = false;
            } else {
                System.out.print("Nama baru (skip => - ) : ");
                String nama = scanner.next();
                System.out.print("NIM baru (skip => - ) : ");
                String newNim = scanner.next();
                System.out.print("Alamat baru (skip => - ) : ");
                String alamat = scanner.next();


                if (client.update(nim, nama, newNim, alamat)) {
                    System.out.println("Data berhasil di-update!");
                    ulang = false;
                } else {
                    System.out.println("\nMahasiswa dengan NIM " + nim + " tidak ditemukan!\n");
                    ulang = true;
                }
            }
            
        }
        
        
        ulang = true;

        while (ulang) {
            System.out.print("Kembali ke menu? (y/n) : ");
            String repeat = scanner.next();

            if (repeat.equals("y")) {
                bool = true;
                ulang = false;
            } else if (repeat.equals("n")){
                bool = false;
                ulang = false;
            } else {
               ulang = true;
            }
        }
        System.out.println("\n\n");
        return bool;
        
    }
    
    public static boolean aksiDelete(Scanner scanner, CRUD client) {
        System.out.println("===================================================================");
        System.out.println("\tDelete Data");
        System.out.println("===================================================================");
        
        client.read();
        
        boolean bool = true;
        boolean ulang = true;
        
        while (ulang) {
            System.out.print("NIM Mahasiswa yang ingin di-delete (0 untuk keluar) : ");
            String nim = scanner.next();
            if (nim.equals("0")) {
                ulang = false;
            } else {
                if (client.delete(nim)) {
                    System.out.println("Data berhasil di-delete!");
                    ulang = false;
                } else {
                    System.out.println("\nMahasiswa dengan NIM " + nim + " tidak ditemukan!\n");
                    ulang = true;
                }
            }
            
        }
        
        
        ulang = true;

        while (ulang) {
            System.out.print("Kembali ke menu? (y/n) : ");
            String repeat = scanner.next();

            if (repeat.equals("y")) {
                bool = true;
                ulang = false;
            } else if (repeat.equals("n")){
                bool = false;
                ulang = false;
            } else {
               ulang = true;
            }
        }
        System.out.println("\n\n");
        return bool;
        
    }

    public static void main(String[] args)  {
        
        CRUD client = new CRUD();
        boolean bool = true;
        
        while (bool) {
            menu();
            Scanner pilihan = new Scanner(System.in);
            System.out.print("Pilih Nomor Aksi : ");
            String aksi = pilihan.next();
            System.out.println("\n\n");


            if (aksi.equals("1")){
                bool = aksiCreate(pilihan, client);
            }
            else if (aksi.equals("2")) {
                bool = aksiRead(pilihan, client);
            }
            else if (aksi.equals("3")) {
                bool = aksiSearch(pilihan, client);
            }
            else if (aksi.equals("4")) {
                bool = aksiUpdate(pilihan, client);
            }
            else if (aksi.equals("5")) {
                bool = aksiDelete(pilihan, client);
            }
            else if (aksi.equals("0")) {
                System.exit(0);
            }
            else {
                bool = true;
            }
        } 
        
        
       
    }
    
}
