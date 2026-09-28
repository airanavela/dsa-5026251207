public class main {
    package lw02.unguided;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<String[]> requests = new LinkedList<String[]>();
        Scanner sc = new Scanner(new File(pathname : "borrowing.txt"));

        while (sc.hasNextLine()) {
            String baris = sc.nextLine();
            if (baris == null) {
                continue;
            }
            if (baris.trim().equals(anObject :"")) {
                continue;
            }
            String[] pecah = baris.split(anObject :" ");
            String nama = pecah[0];
            String judulBuku = pecah[1];
            String[] satuRequest = new String[2];
            satuRequest[0] = nama;
            satuRequest[1] = judulBuku;
            requests.add(satuRequest);
        }

        sc.close();
        LinkedList<String[]> books = new LinkedList<String[]>();
        books.add(new String[]{"Kalkulus", "2"});
        books.add(new String[]{"Fisika", "1"});
        books.add(new String[]{"Statistika", "2"});

        LinkedList<String[]> members = new LinkedList<String[]>();
        for (int i = 0; i < requests.size(); i++) {
            String[] req = requests.get(i);
            String namaSekarang = req[0];
            int sudahAda = 0;
            for (int j = 0; j < members.size(); j++) {
                String[] m = members.get(j);
                if (m[0].equals(namaSekarang)) {
                    sudahAda = 1;
                }
            }

            if (sudahAda == 0) {
                String[] memberBaru = new String[2];
                memberBaru[0] = namaSekarang;
                memberBaru[1] = "0";
                members.add(memberBaru);
            }
        }

        Queue<String[]> antrian = new LinkedList<String[]>();
        for (int i = 0; i < requests.size(); i++) {
            antrian.add(requests.get(i));
        }

        LinkedList<String[]> berhasil = new LinkedList<String[]>();
        Stack<String[]> gagal = new Stack<String[]>();
        while (antrian.isEmpty() == false) {

            String[] reqSekarang = antrian.poll();
            String namaReq = reqSekarang[0];
            String judulReq = reqSekarang[1];

            int indexBuku = -1;
            for (int i = 0; i < books.size(); i++) {
                String[] b = books.get(i);
                if (b[0].equals(judulReq)) {
                    indexBuku = i;
                }
            }

            int indexMember = -1;
            for (int i = 0; i < members.size(); i++) {
                String[] m = members.get(i);
                if (m[0].equals(namaReq)) {
                    indexMember = i;
                }
            }

            if (indexBuku != -1 && indexMember != -1) {
                String[] bukuNya = books.get(indexBuku);
                String[] memberNya = members.get(indexMember);

                int stokSekarang = Integer.parseInt(bukuNya[1]);
                int pinjamSekarang = Integer.parseInt(memberNya[1]);

                boolean adaStok = stokSekarang > 0;
                boolean belumMax = pinjamSekarang < MAX_BORROW;

                if (adaStok == true && belumMax == true) {
                    int stokBaru = stokSekarang - 1;
                    bukuNya[1] = "" + stokBaru;
                    books.set(indexBuku, bukuNya);

                    int pinjamBaru = pinjamSekarang + 1;
                    memberNya[1] = "" + pinjamBaru;
                    members.set(indexMember, memberNya);

                    berhasil.add(reqSekarang);
                } else {
                    
                    gagal.push(reqSekarang);
                }
            }
        }

        System.out.println(x:"=== Successfully Processed Requests ===");
        for (int i = 0; i < berhasil.size(); i++) {
            String[] r = berhasil.get(i);
            System.out.println(r[0] + " " + r[1]);
        }
        System.out.println();
        System.out.println(x: "=== Remaining Book Stock ===");
        for (int i = 0; i < books.size(); i++) {
            String[] b = books.get(i);
            System.out.println(b[0] + " : " + b[1]);
        }
        System.out.println();
        System.out.println(x: "=== Failed Requests ===");
        while (gagal.empty() == false) {
            String[] r = gagal.pop();
            System.out.println(r[0] + " " + r[1]);
        }
    }
