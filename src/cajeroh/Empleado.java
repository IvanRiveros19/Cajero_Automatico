package cajeroh;

import java.util.Scanner;

public class Empleado {

    Scanner lee = new Scanner(System.in);
     Scanner entr = new Scanner(System.in);
    String dat[] = new String[9];
    String no, dir, tel, num, fec;
    int cla;

    public void Datos() {
        
        System.out.print("INTRODUCE LA CLAVE DE SEGURIDAD:");
        cla = entr.nextInt();
        
        if (cla == 890000) {
            System.out.println("Bienvenido, por favor llene la siguiente informacion");
            System.out.print("Nombre completo: ");
            no=lee.nextLine();
            
            System.out.print("Direccion: ");
            dir = lee.nextLine();
        
            System.out.print("Numero telefonico: ");
            tel = lee.nextLine();
            
            System.out.print("Numero de empleado: ");
            num = lee.nextLine();
            
            System.out.print("Fecha de abstecimiento: ");
            fec = lee.nextLine();

            dat[0] = no;
            dat[1] = dir;
            dat[2] = tel;
            dat[3] = num;
            dat[4] = fec;
            Print();
        }else{
            System.err.println("CLAVE INCORRECTA, VERIFICA POR FAVOR");
            Datos();
        }

    }

    public void Print() {
        /*System.out.println("El monto actual en boveda es de: ");
        System.out.print(d100+" Billetes de $100");
        System.out.print(d200+" Billetes de $200");
        System.out.print(d500+" Billetes de $500");
        System.out.print(d1000+" Billetes de $1000");*/
        for (int i = 0; i < 5; i++) {
            System.out.print(dat[i] + ",");
        }
    }
}
