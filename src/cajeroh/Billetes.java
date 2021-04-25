package cajeroh;

import java.util.Scanner;

public class Billetes {

    Scanner entr = new Scanner(System.in);
    int cant, b10 = 0, b5 = 0, b2 = 0, b1 = 0;

    public void Entrega() {

        while (cant > 0) {

            if (cant > 2500) {
                b10 = b10 + 1;
                cant = cant - 1000;

            } else if (cant > 500) {
                b5 = b5 + 1;
                cant = cant - 500;

            } else if (cant > 200) {
                b2 = b2 + 1;
                cant = cant - 200;

            } else if (cant >= 100) {
                b1 = b1 + 1;
                cant = cant - 100;

            }
        }

        System.out.println("Entregando " + b1 + " billetes de $100");
        System.out.println("Entregando " + b2 + " billetes de $200");
        System.out.println("Entregando " + b5 + " billetes de $500");
        System.out.println("Entregando " + b10 + " billetes de $1000");
    }
}
