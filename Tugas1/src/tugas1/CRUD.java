
package tugas1;

import java.util.ArrayList;

public class CRUD {
    
    private static ArrayList<MahasiswaModel> listMhs = new ArrayList<MahasiswaModel>();
    private ArrayList<MahasiswaModel> searchMhs = new ArrayList<MahasiswaModel>();
    private int countData = 0;
    
    
    public static ArrayList<MahasiswaModel> getListMhs() {
        return listMhs;
    }
    
    public void create(String nama, String nim, String alamat) {
        MahasiswaModel model = new MahasiswaModel(nama, nim, alamat);
        listMhs.add(model);
    }
    
    public void read() {
        System.out.println("No.\tNama\t\tNIM\t\t\tAlamat");
        System.out.println("===================================================================");
        for (int i = 1; i <= listMhs.size(); i++) {
            System.out.print(i + ".\t");
            System.out.print(listMhs.get(i-1).getNama() + "\t\t");
            System.out.print(listMhs.get(i-1).getNim() + "\t\t");
            System.out.print(listMhs.get(i-1).getAlamat());
            System.out.println("");
        }
    }
    
    public void search(String hint) {
        String dataFromList;
        for (int i = 1; i <= listMhs.size(); i++) {
            dataFromList = (listMhs.get(i-1).getNama() + listMhs.get(i-1).getNim() + listMhs.get(i-1).getAlamat()).toLowerCase();
            if (dataFromList.contains(hint.toLowerCase())) {
                searchMhs.add(listMhs.get(i-1));
            }
        }
        System.out.println("\nNo.\tNama\t\tNIM\t\t\tAlamat");
        System.out.println("===================================================================");
        for (int i = 1; i <= searchMhs.size(); i++) {
            System.out.print(i + ".\t");
            System.out.print(searchMhs.get(i-1).getNama() + "\t\t");
            System.out.print(searchMhs.get(i-1).getNim() + "\t\t");
            System.out.print(searchMhs.get(i-1).getAlamat());
        }
        System.out.println("");
    }
    
    public boolean update(String nim, String nama, String newNim, String alamat) {
        boolean isExist = false;
        for (int i = 1; i <= listMhs.size(); i++) {
            if (listMhs.get(i-1).getNim().equals(nim)) {
                if (!nama.equals("-")) {
                    listMhs.get(i-1).setNama(nama);
                }
                if (!newNim.equals("-")) {
                    listMhs.get(i-1).setNim(newNim);
                }
                if (!alamat.equals("-")) {
                    listMhs.get(i-1).setAlamat(alamat);
                }
                isExist = true;
            }
        }
        return isExist;
    }
    
    public boolean delete(String nim) {
        boolean isExist = false;
        for (int i = 1; i <= listMhs.size(); i++) {
            if (listMhs.get(i-1).getNim().equals(nim)) {
                listMhs.remove(i-1);
                isExist = true;
            }
        }
        return isExist;
    }
    
}
