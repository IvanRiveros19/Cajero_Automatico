package cajeroh;

import java.util.*;

public class Procedimientos {

    //____________________________________
    Scanner lee = new Scanner(System.in);
    Scanner entr = new Scanner(System.in);
    Scanner ot=new Scanner (System.in);
    String dat[] = new String[9];
    String no, dir, tel, num, fec;
    int cla;

    //________________________________
    Saldo sa = new Saldo();
    Empleado em = new Empleado();
    Base ba = new Base();
    Billetes bi = new Billetes();

    Scanner s = new Scanner(System.in);
    String tar,nip;
    boolean t = false, u = false;
    int pos, op, p, q, mon, ret, salr, re, c1, c2, iva, sal, r, mas, cant, sel, inc, inr = 3;
    //Numero de billetes
    int d100 = 40, d200 = 30, d500 = 20, d1000 = 10;
    String tick[][] = new String[0][25];

    public void Inicio() {
        Scanner entre = new Scanner(System.in);
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println("||    BIENVENIDO AL CAJERO SANTANDER    ||");
        System.out.println("||       Elija su tipo de usuario:      ||");
        System.out.println("||           1. Cliente.                ||");
        System.out.println("||           2. Empleado.               ||");
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        sel = entre.nextInt();
        System.out.println("");

        if (sel >= 1 && sel <= 2) {
        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("xx    Opcion incorrecta    xx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
            Inicio();
        }
        switch (sel) {
            case 1:
                Busca();
                break;
            case 2:
                Datos();
                break;
        }

    }

    public void Busca() {
        
        System.out.println("----------------------------------");
        System.out.print("|| Inserte su tarjeta: ");
        tar = ot.nextLine();
        System.out.println("----------------------------------");
        System.out.println("");

        for (int i = 0; i <= 9; i++) {
            if (tar.equals(ba.base[i][2])) {
                p = i;
                t = true;
                Verificar();
            }

        }
        if (t == false) {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.err.println("xx La cuenta no se encontró en la base de datos xx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("");
        }
    }

    public void Verificar() {
        System.out.println("----------------------------------");
        System.out.print("|| Digite su NIP: ");
        nip = ot.nextLine();
        System.out.println("----------------------------------");
        System.out.println("");

        if (nip.equals(ba.base[p][3])) {
            u = true;
            System.out.println("-----------------------------------------------");
            System.out.println("|| Bienvenido Señor(a) " + ba.base[p][0]);
            System.out.println("-----------------------------------------------");
            System.out.println("");

            mon = ba.monto[p][0];
            sal = mon;
            Haz();
        }

        if (u == false) {
            inc++;
            inr--;
            if (inc < 3) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("xx NIP Incorrecto, intentos restantes: " + inr + " xx");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("");
                Verificar();
            } else {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("xx Ha insertado 3 veces de manera incorrecta si NIP, le sugerimos verificar su tarjeta xx");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("");
                Inicio();
            }
        }
    }

    public void Haz() {
        System.out.println("-------------------------------------------");
        System.out.println("|| Elija la operacion que desea realizar ||");
        System.out.println("||          1. Consulta de Saldo.        ||");
        System.out.println("||          2. Retiro en Efectivo.       ||");
        System.out.println("||              3. Salir.                ||");
        System.out.println("-------------------------------------------");
        op = s.nextInt();
        if (op >= 1 && op <= 3) {
            if (op == 1) {
                System.out.println("----------------------------------");
                System.out.println("||  Ha elegido Consultar Saldo  ||");
                Consulta();
            } else if (op == 2) {
                System.out.println("-----------------------------------");
                System.out.println("|| Ha elegido Retiro en efectivo ||");
                Retiro();
            } else if (op == 3) {
                Siguiente();
                Inicio();
            }
        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.err.println("xx Opcion incorrecta, reintente xx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("");
            Haz();
        }

    }

    public void Siguiente() {
        for (int i = 0; i < 15; i++) {
            System.out.println("");
        }
    }

    public void Consulta() {
        System.out.println("-----------------------------------");
        System.out.println("|| Su saldo actual es de: $" + ba.monto[p][0]);
        System.out.println("-----------------------------------");
        System.out.println("");
        TicketC();

    }

    public void Retiro() {
        System.out.println("-----------------------------------");
        System.out.print("||  Cantidad a retirar: ");
        ret = s.nextInt();
        System.out.println("-----------------------------------");
        System.out.println("");

        if (ret >= 100 && ret <= 6500 && ret % 100 == 0) {
            if (ret < sal) {
                salr = sal - ret;
                mon = salr;
                cant = ret;
               ba.monto[p][0]=salr;
                System.out.println("nuevo: "+ba.monto[p][0]);
                Entrega();
                TicketR();
            } else {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x No cuenta con saldo suficiente x");
                System.out.println("x      ¿Desea reintentar?:       x");
                System.out.println("x           1-SI  2-NO           x");
                mas = s.nextInt();
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("");
                ret = 0;
                if (mas == 1) {
                    Retiro();
                }
            }
        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("x  Recuerda que solo puedes retirar cantidades   x");
            System.out.println("x multiplos de $100 con monto entre $100 y $6500 x");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("");
            Retiro();
        }

    }

    public void TicketR() {
        System.out.println("--------------------------------------");
        System.out.println("|| ¿DESEA QUE SE IMPRIMA SU TICKET? ||");
        System.out.println("||         1-SI        2-NO         ||");
        re = s.nextInt();
        System.out.println("--------------------------------------");
        System.out.println("");
        if (re == 1) {
            System.out.println("******************************************");
            System.out.println("**     BANCO SANTANDER(MEXICO) S.A.     **");
            System.out.println("**    INSTITUCION DE BANCA MULTIPLE     **");
            System.out.println("**  GRUPO FINANCIERO SANTANDER MEXICO   **");
            System.out.println("******************************************");
            System.out.println("**  FECHA           HORA        CAJERO  **");
            System.out.println("* 31/03/2018     12:45:31 PM    X94846   *");
            System.out.println("* UBICACIÓN: VENUSTIANO CARRANZA SN COL. *");
            System.out.println("*     CIUDAD: CUAUTEPEC DE HINOJOSA      *");
            System.out.println("*            ESTADO: HIDALGO             *");
            System.out.println("******************************************");
            System.out.println("");

            System.out.println("******************************************");
            System.out.println("****     DISPOSICIÓN DE LA CUENTA     ****");
            System.out.println("***         IMPORTE: $" + ret + "             ***");
            System.out.println("***       SALDO ACTUAL: $" + salr + "          ***");
            System.out.println("***             CUENTA: ***" + tar.substring(3, 5) + "          ***");
            System.out.println("******************************************");
            System.out.println("******  GRACIAS POR SU PREFERENCIA  ******");
            System.out.println("******************************************");
            System.out.println("");
            Haz();
        } else if (re == 2) {
            Haz();
        }
    }

    public void TicketC() {
        System.out.println("--------------------------------------");
        System.out.println("|| ¿DESEA QUE SE IMPRIMA SU TICKET? ||");
        System.out.println("||         1-SI        2-NO         ||");
        re = s.nextInt();
        System.out.println("--------------------------------------");
        System.out.println("");
        if (re == 1) {
            System.out.println("******************************************");
            System.out.println("**     BANCO SANTANDER(MEXICO) S.A.     **");
            System.out.println("**    INSTITUCION DE BANCA MULTIPLE     **");
            System.out.println("**  GRUPO FINANCIERO SANTANDER MEXICO   **");
            System.out.println("******************************************");
            System.out.println("**  FECHA           HORA        CAJERO  **");
            System.out.println("* 31/03/2018     12:45:31 PM    X94846   *");
            System.out.println("* UBICACIÓN: VENUSTIANO CARRANZA SN COL. *");
            System.out.println("*     CIUDAD: CUAUTEPEC DE HINOJOSA      *");
            System.out.println("*            ESTADO: HIDALGO             *");
            System.out.println("******************************************");
            System.out.println("");

            System.out.println("******************************************");
            System.out.println("****     DISPOSICIÓN DE LA CUENTA     ****");
            System.out.println("***       SALDO ACTUAL: $" + sal + "          ***");
            System.out.println("***             CUENTA: ***" + tar.substring(3, 5) + "          ***");
            System.out.println("******************************************");
            System.out.println("******  GRACIAS POR SU PREFERENCIA  ******");
            System.out.println("******************************************");
            System.out.println("");
            Haz();
        } else if (re == 2) {
            Haz();
        }
    }

    public void Entrega() {
        int b10 = 0, b5 = 0, b2 = 0, b1 = 0;
        //if (cant >= 100 && cant <= 6500 && cant % 100 == 0) {
        while (cant > 0) {

            if (cant > 2500) {
                b10 = b10 + 1;
                cant = cant - 1000;
                d1000 = d1000 - 1;
            } else if (cant > 500) {
                b5 = b5 + 1;
                cant = cant - 500;
                d500 = d500 - 1;
            } else if (cant > 200) {
                b2++;
                cant = cant - 200;
                d200 = d200 - 1;
            } else if (cant >= 100) {
                b1 = b1 + 1;
                cant = cant - 100;
                d100 = d100 - 1;
            }

        }
        System.out.println("-------------------------------------");
        System.out.println("||     Procesando solictud...      ||");
        System.out.println("-------------------------------------");
        System.out.println("|| Entregando " + b1 + " billete(s) de $100 ||");
        System.out.println("|| Entregando " + b2 + " billete(s) de $200 ||");
        System.out.println("|| Entregando " + b5 + " billete(s) de $500 ||");
        System.out.println("|| Entregando " + b10 + " billete(s) de $1000 |");
        System.out.println("-------------------------------------");
        System.out.println("");
        //Restante();
    }

    public void Restante() {
        System.out.println("RESTAN " + d1000 + " BILLETES DE $1000");
        System.out.println("RESTAN " + d500 + " BILLETES DE $500");
        System.out.println("RESTAN " + d200 + " BILLETES DE $200");
        System.out.println("RESTAN " + d100 + " BILLETES DE $100");
    }

    public void Datos() {
        System.out.println("--------------------------------------------");
        System.out.print("|| INTRODUCE LA CLAVE DE SEGURIDAD: ");
        cla = entr.nextInt();
        System.out.println("--------------------------------------------");
        System.out.println("");

        if (cla == 890000) {
            System.out.println("----------------------------------------------------------");
            System.out.println("|| Bienvenido, por favor llene la siguiente informacion ||");
            System.out.println("----------------------------------------------------------");
            System.out.println("");

            System.out.println("--------------------------------------------------");
            System.out.print("|| Nombre completo: ");
            no = lee.nextLine();
            System.out.println("--------------------------------------------------");

            System.out.println("--------------------------------------------------");
            System.out.print("|| Direccion: ");
            dir = lee.nextLine();
            System.out.println("--------------------------------------------------");
            
            System.out.println("--------------------------------------------------");
            System.out.print("|| Numero telefonico: ");
            tel = lee.nextLine();
            System.out.println("--------------------------------------------------");

            System.out.println("--------------------------------------------------");
            System.out.print("|| Numero de empleado: ");
            num = lee.nextLine();
            System.out.println("--------------------------------------------------");

            System.out.println("--------------------------------------------------");
            System.out.print("|| Fecha de abstecimiento: ");
            fec = lee.nextLine();
            System.out.println("--------------------------------------------------");

            dat[0] = no;
            dat[1] = dir;
            dat[2] = tel;
            dat[3] = num;
            dat[4] = fec;
            Print();
        } else {
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("xx CLAVE INCORRECTA, VERIFICA POR FAVOR xx");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("");
            Inicio();
        }

    }

    public void Print() {
        System.out.println("Actualmente la boveda cuenta con: ");
        System.out.print(d100 + " Billetes de $100| ");
        System.out.print(d200 + " Billetes de $200| ");
        System.out.print(d500 + " Billetes de $500| ");
        System.out.println(d1000 + " Billetes de $1000");
        for (int i = 0; i < 5; i++) {
            System.out.print(dat[i] + ",");
        }
    }

    public void InfCaj() {
        System.out.println("******************************************");
        System.out.println("**     BANCO SANTANDER(MEXICO) S.A.     **");
        System.out.println("**    INSTITUCION DE BANCA MULTIPLE     **");
        System.out.println("**  GRUPO FINANCIERO SANTANDER MEXICO   **");
        System.out.println("******************************************");
        System.out.println("* UBICACIÓN: VENUSTIANO CARRANZA SN COL. *");
        System.out.println("*     CIUDAD: CUAUTEPEC DE HINOJOSA      *");
        System.out.println("*            ESTADO: HIDALGO             *");
        System.out.println("******************************************");
        System.out.println("");
    }
    
    public void Boveda(){
        int dmax=5000, dmin=7000, m10=d100*100, m20=d200*200, m50=d500*500, m100=d1000*1000, t=(m10+m20+m50+m100);
        do{
        System.out.println("Monto por billetes: ");
        System.out.println("billetes de $100= $"+m10);
        System.out.println("billetes de $200= $"+m20);
        System.out.println("billetes de $500= $"+m50);
        System.out.println("billetes de $1000= $"+m100);
        System.out.println("TOTAL EN BOVEDA: $"+t);
        System.out.println("");
        }while(t<dmax);
        if (t>dmax) {
            System.out.println("MONTO SOBREPASADO");
        }
    }
}
