import java.util.Scanner;
public class FITBOT {

    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        String nama;
        while(true) {
        System.out.print("Nickname : ");
        nama = masuk.nextLine();
        if(nama.length()<=7) {
            System.out.print("Yay berhasil");
            loading(400);
            break;
        }else {
            System.out.println("Usahain nickname tidak lebih dari 7 huruf ya!\n");
        }
        }

        String Uppernama = nama.toUpperCase(); //untuk membesarkan semua huruf
        
        System.out.println("\n");
        while(true) {
        System.out.print("""
                    *==================================================*
                    ║                  SELAMAT DATANG                  ║
                    ║                 -- FITs  Apps --                 ║
                    ╠══════════════════════════════════════════════════╣
                    ║             Haloo akunmu sudah aktif             ║
                    ║                                                  ║
                    ║                   0. KELUAR                      ║
                    ║                   1. MASUK                       ║
                    ║                                                  ║
                    ║    FitBot akan membantumu dengan senang hati     ║           
                    *==================================================*
                    """);
        System.out.print("Click : ");
        int pilLogin = masuk.nextInt();
        masuk.nextLine();
        System.out.print("Fitbot's loading");
        loading(400);
        System.out.println("\n");
            if(pilLogin == 0) {
                System.out.println("Yahh, sampai bertemu kembali..");
                break;
            }else if(pilLogin<0 || pilLogin>1) {
                System.out.printf("FitBot check %s salah click, harap click kembali ya!\n\n", nama);
                continue;
            }else if(pilLogin == 1) {
                while(true) {
                System.out.print("""
                        ╔═════════════════╗
                        ║      FITUR      ║  
                        ║═════════════════║
                        ║                 ║
                        ║   1. FitGo      ║
                        ║   2. FitShop    ║
                        ║   3. FitEnd     ║
                        ║                 ║
                        ╚═════════════════╝
                        """);
                
                System.out.print("Click Fitur : ");
                int fitur = masuk.nextInt();
                int usia;
                Double bb, tb, BMI, PLT, PKA, PMO;
                char gender, jwbn1, jwbn2;
                String descBMI="";
                if(fitur == 1) {
                    while(true) {
                        System.out.println("\nLengkapi pertanyaan dibawah ini.");
                        System.out.print("Berat Badan (kg)  : ");
                        bb = masuk.nextDouble();
                        System.out.print("Tinggi Badan (cm) : ");
                        tb = masuk.nextDouble();
                        System.out.print("Usia              : ");
                        usia = masuk.nextInt();
                        masuk.nextLine();
                        System.out.print("Gender P/L        : ");
                        gender = masuk.next().charAt(0);
                        System.out.print("Data diisi 100% valid (ya/tidak): ");
                        jwbn1 = masuk.next().charAt(0);

                        if(Character.toUpperCase(jwbn1) == 'Y') {
                            System.out.print("FitBot's loading");
                            loading(700);
                            System.out.println("\n");
                            break;
                        }else if(Character.toUpperCase(jwbn1) == 'T') {
                            System.out.println("Dimohon mengisi kembali");
                            // continue;
                        }else {
                            System.out.printf("%s salah ketik nih", nama);
                        }
                    }
                        while(true) {
                            System.out.printf("""
                                    --------- FitGo ---------
                                    %s mau lanjut yang mana :
                                    1. Cetak hasil
                                    2. Konsul FitBot
                                    3. Kembali ke menu fitur
                                    """, nama);

                            System.out.print("Click : ");
                            jwbn2 = masuk.next().charAt(0);
                            masuk.nextLine();
                            System.out.print("FitBot's processing");
                            loading(1050);
                            System.out.println("\n");

                            // PERHITUNGAN BMI
                            BMI = (bb/(Math.pow(tb,2)/10000));
                            if(BMI<=18) {
                                descBMI = "Underweight";
                            }
                            else if(BMI>18 && BMI<=25){
                                descBMI = "Normal";
                            }
                            else if(BMI>25 && BMI<=40){
                                descBMI = "Overweight";
                            }
                            else if(BMI>40){
                                descBMI = "Obese";
                            }

                            //Presentase LEMAK TUBUH (PLT)
                            if(gender == 'p') {
                                PLT = (1.20*BMI) + (0.23*usia) - 5.4;
                                
                            }else {
                                PLT = (1.20*BMI) + (0.23*usia) - 10.8 - 5.4;
                                
                            }

                            //Presentase MASSA OTOT (PMO)

                            //Step 1 --> hitung massa lemak tubuh (mlt)
                            Double mlt = bb*(PLT/100);
                            //Step 2 --> hitung massa otot (mo) tanpa lemak
                            Double mo = bb-mlt;
                            //Step 3 --> hitung PMO
                            PMO = (mo/bb)*100;
                            

                            //Presentase Kadar Air (PKA)
                            if(gender == 'p') {
                                PKA = (0.50*bb)/bb*100;
                                
                            }else {
                                PKA = (0.60*bb)/bb*100;  
                            }
                        
                            if(jwbn2 == '1') {
                                System.out.printf("""
                                                ╔══════════════════════════════════════════════════════════════════════════════════════════════╗
                                                ║                                    BODY FIT FORM %-7s                                     ║
                                                ║                                          by FITs                                             ║
                                                ╠══════════╦════════╦════════╦═════════╦═════════════╦══════════════╦════════════╦═════════════╣
                                                ║   Usia   ║ Gender ║   BB   ║   TB    ║     BMI     ║%% Lemak Tubuh ║%% Kadar Air ║%% Massa Otot ║
                                                """, Uppernama);

                                System.out.printf("""
                                                ╠══════════╦════════╦════════╦═════════╦═════════════╦══════════════╦════════════╦═════════════╣
                                                ║  %-2d thn  ║   %-1c    ║ %.1fkg ║ %.1fcm ║ %-11s ║     %.2f    ║    %.1f    ║   %.1f      ║
                                                ╚══════════════════════════════════════════════════════════════════════════════════════════════╝
                                                """, usia, gender, bb, tb, descBMI, PLT, PKA, PMO);
                                System.out.println("\n");
                                KadarAir();
                                MassaOtot();
                                LemakTubuh();
                                System.out.println("\n");
                                continue;
                            }else if(jwbn2 == '2') {
                                System.out.println("-----Selamat Datang di FitBot Konsul-----\n");
                                while(true) {
                                System.out.print("FitBot typing ");
                                loading(550);
                                System.out.println("");
                                System.out.printf("""
                                                ╔═════════════════════════════════════╗
                                                ║ FitBot suruh jelasin yang mana nih: ║
                                                ║ 1. Tentang Kadar Air                ║
                                                ║ 2. Tentang Massa Otot               ║
                                                ║ 3. Tentang Lemak Tubuh              ║
                                                ║ 4. Kembali ke fitur FitGo           ║
                                                ╚═════════════════════════════════════╝
                                                """);
                                System.out.printf("\n%s's answer : ", Uppernama);
                                int answrkonsul = masuk.nextInt();
                                
                                if(answrkonsul == 1) {
                                    KadarAir();
                                    System.out.println("");
                                    System.out.println("""
                                                    Tabel diatas memuat presentase normal untuk kadar air di dalam tubuh
                                                    sesuai dengan gender
                                                    --------------------------------------------------------------------
                                                    Akibat kekurangan kadar air di dalam tubuh :
                                                    - Tubuh mengalami dehidrasi
                                                    - Menyebabkan berbagai penyakit
                                                    --------------------------------------------------------------------
                                                    Cara meningkatkan kadar air dalam tubuh :
                                                    - Mengonsumsi air yang cukup
                                                      Perempuan --> 2,2L per hari
                                                      Laki-laki --> 3L per hari
                                                    - Makan buah dan sayur
                                                    """);
                                    System.out.println("");
                                }else if(answrkonsul == 2) {
                                    MassaOtot();
                                    System.out.println("");
                                    System.out.println("""
                                                    Tabel massa otot menunjukkan presentase massa otot normal di dalam
                                                    tubuh sesuai dengan gender dan usia
                                                    --------------------------------------------------------------------
                                                    Akibat yang timbul akibat massa otot kurang dari batas normal :
                                                    - Atrofi otot --> otot menyusut dan menipis
                                                    - Keterbatasan mobilitas
                                                    --------------------------------------------------------------------
                                                    Cara meningkatkan massa otot di dalam tubuh :
                                                    - Meningkatkan kadar air tubuh
                                                    - Olahraga --> renang, yoga, push-up, pull-up, aerobik, angkat beban
                                                    --------------------------------------------------------------------
                                                    Manfaat memiliki massa otot yang tinggi :
                                                    - Stamina dan kekuatan fisik yang baik
                                                    - Respons tubuh yang baik terhadap stres, cedera, dan penyakit
                                                    - Proses penyembuhan penyakit yang relatif cepat
                                                    """);
                                    System.out.println("");
                                }else if(answrkonsul == 3) {
                                    LemakTubuh();
                                    System.out.println("");
                                    System.out.println("""
                                                    Tabel lemak tubuh menunjukkan presentase lemak tubuh yang normal
                                                    sesuai dengan gender dan usia
                                                    --------------------------------------------------------------------
                                                    Akibat yang timbul akibat kekurangan lemak tubuh :
                                                    - Sistem kekebalan menurun
                                                    - Nyeri sendi
                                                    --------------------------------------------------------------------
                                                    Akibat yang timbul akibat kelebihan lemak tubuh : 
                                                    - Lebih cepat lelah
                                                    - Obesitas
                                                    --------------------------------------------------------------------
                                                    Cara mudah menjaga lemak tubuh :
                                                    - Perbanyak konsumsi protein
                                                    - Olahraga yang cukup
                                                    - Makan bergizi, sehat, dan seimbang
                                                    """);
                                    System.out.println("");
                                }else if(answrkonsul == 4) {
                                    System.out.println("\n");
                                    break;
                                }else {
                                    System.out.println("Salah click tanya nih, coba lagi ya");
                                }
                            }

                            }else if(jwbn2 == '3') {
                                    break;    
                            }else {
                                System.out.println("Salah click nih, coba ulangi lagi ya\n");
                            }
                            
                        }
                    
                }else if(fitur == 2) {
                    System.out.printf("""
                        ===================================================
                                     SELAMAT DATANG DI FITSHOP   
                            Menawarkan Produk Milk Shake Tinggi Protein
                        ===================================================
                        """);
    
                    int brcd;
                    int hargaTotal [] = new int[5];
                    int hargaBayar = 0;
                    int jmlh;
                    int jmlhTotal [] = new int[5];
                    String [] namaProduk = {"FitSlim Original", "FitSlim Choco", "FitSlim Taro", "FitSlim Madu", "FitSlim Greentea"};
                    int [][] brcdPrice = {
                        {1, 110000}, 
                        {2, 140000}, 
                        {3, 135000}, 
                        {4, 140000}, 
                        {5, 138000}
                        };
                    
                
                    System.out.println("\nPRODUK FITSHOP\n");
                        for(int i=0; i<5; i++) {
                            System.out.println(brcdPrice[i][0]+". "+namaProduk[i]+" --> Rp."+brcdPrice[i][1]+" /pcs\n");
                        }
                    System.out.println("===================================================\n");
                    while(true) {
                        System.out.printf("""
                                        PILIHAN :
                                        1. Belanja
                                        2. Kembali ke menu fitur
                                        """);
                        System.out.print("Click : ");
                        int answer = masuk.nextInt();

                        if(answer==1) {
                            System.out.println("\n--Memasukkan Keranjang--");
                                while(true) {
                                System.out.print("Barcode : ");
                                brcd = masuk.nextInt();
                                if(brcd<1 | brcd>6) {
                                    System.out.println("Barcode tidak ditemukan\n");
                                    continue;
                                }
                                System.out.print("Jumlah  : ");
                                switch (brcd) {
                                    case 1:
                                    jmlh=masuk.nextInt();
                                    jmlhTotal[0] += jmlh;
                                    hargaTotal[0] = jmlh* brcdPrice[0][1];
                                    hargaBayar += hargaTotal[0];
                                    System.out.println(hargaBayar);
                                    break;
                                    
                                    case 2:
                                    jmlh=masuk.nextInt();
                                    jmlhTotal[1] += jmlh;
                                    hargaTotal[1] = jmlh* brcdPrice[1][1];
                                    hargaBayar += hargaTotal[1];
                                    System.out.println(hargaBayar);
                                    break;

                                    case 3:
                                    jmlh=masuk.nextInt();
                                    jmlhTotal[2] += jmlh;
                                    hargaTotal[2] = jmlh* brcdPrice[2][1];
                                    hargaBayar += hargaTotal[2];
                                    System.out.println(hargaBayar);
                                    break;

                                    case 4:
                                    jmlh=masuk.nextInt();
                                    jmlhTotal[3] += jmlh;
                                    hargaTotal[3] = jmlh* brcdPrice[3][1];
                                    hargaBayar += hargaTotal[3];
                                    System.out.println(hargaBayar);
                                    break;

                                    case 5:
                                    jmlh=masuk.nextInt();
                                    jmlhTotal[4] += jmlh;
                                    hargaTotal[4] = jmlh* brcdPrice[4][1];
                                    hargaBayar += hargaTotal[4];
                                    System.out.println(hargaBayar);
                                    break;
                                }
                                masuk.nextLine();
                                System.out.print("Next (tambah--> + atau stop--> .): ");
                                String answr1 = masuk.nextLine();
                                
                                if(answr1.equals("+")) {
                                    System.out.println("Keranjangmu sebelumnya berhasil ditambahkan\n");
                                }else if(answr1.equals(".")) {
                                    System.out.print("Fitbot memproses nota");
                                    loading(700);
                                    break;
                                }else {
                                    System.out.println("Something wrong, try again\n");
                                }
                            }

                            System.out.printf("""
                                            \n
                                            ===================================================
                                                            NOTA BELANJA FITSHOP
                                            ===================================================
                                            Barcode         Produk        Jumlah      Harga/pcs
                                            ---------------------------------------------------
                                            """);

                            for(int i=0; i<namaProduk.length; i++) {
                                System.out.printf("""
                                                %d         %-16s      %d         %d
                                                """, brcdPrice[i][0], namaProduk[i], jmlhTotal[i] , brcdPrice[i][1]);
                            
                            }

                            System.out.printf("""
                                            ===================================================
                                                                ║ SUBTOTAL ║  Rp. %d
                                            ===================================================
                                                Terimakasih telah berbelanja di FitShop
                                                    FitBot tunggu kedatangannya kembali
                                            Kritik dan saran dapat diajukan di fitshp@gmail.com
                                            ===================================================
                                            """,hargaBayar);
                            System.out.println("\n");
                        }else if(answer==2) {
                            break;
                        }else {
                            System.out.println("\nSalah click nih, ulangi lagi\n");
                        }
                    }
                }else if(fitur == 3) {
                    System.out.printf("""
                                    \n
                                    ====================================================

                                       Terimakasih telah menggunakan fitur FIT's Apps
                                    Semoga Bermanfaat, Selamat Tinggal, dan Sampai Jumpa

                                    ====================================================
                                    \n""");
                    break;
                }
                }

            }
        }
    }


    static void KadarAir() {
        System.out.print ("""
                         * PRESENTASE KADAR AIR 
                         ╔══════════╦═════════╗
                         ║PEREMPUAN ║  45-60% ║
                         ╠══════════╠═════════╣
                         ║LAKI-LAKI ║  50-65% ║         
                         ╚══════════╩═════════╝
                         """);
    }

    static void LemakTubuh() {
         System.out.print("""
                         * PRESENTASE LEMAK TUBUH
                         ╔══════════╦══════════╦══════════╦══════════╦══════════╗
                         ║   USIA   ║   18-27  ║   28-29  ║   40-50  ║    >50   ║
                         ╠══════════╠══════════╠══════════╠══════════╠══════════╣
                         ║PEREMPUAN ║  17-25%  ║  26-30%  ║  31-34%  ║    <35%  ║
                         ╠══════════╠══════════╠══════════╠══════════╠══════════╣
                         ║LAKI-LAKI ║  14-18%  ║  16-20%  ║  21-23%  ║    <24%  ║         
                         ╚══════════╩══════════╩══════════╩══════════╩══════════╝
                         """);
    }
    static void MassaOtot() {
         System.out.print("""
                         * PRESENTASE MASSA OTOT
                         ╔══════════╦══════════╦══════════╦══════════╗
                         ║   USIA   ║   18-39  ║   40-59  ║    >60   ║
                         ╠══════════╠══════════╠══════════╠══════════╣
                         ║PEREMPUAN ║  65-75%  ║  60-70%  ║  55-65%  ║              
                         ╠══════════╠══════════╠══════════╠══════════╣
                         ║LAKI-LAKI ║  75-85%  ║  70-80%  ║  65-75%  ║          
                         ╚══════════╩══════════╩══════════╩══════════╝
                         """);
    }
    public static void loading(int durasiDlmMs) {
        for(int i=0; i<3; i++) {
                try {
                    System.out.print(". ");
                    Thread.sleep(durasiDlmMs);
                }
                catch(InterruptedException e) {}
        }
            System.out.print("");  
        
    }
}
