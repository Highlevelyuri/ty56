package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        igra();

    }



    public static void igra()
    {
        Scanner scaner1 = new Scanner(System.in); //создание обьекта позволяющий считать входную информа
        System.out.println("вы зашли в игру крестики нолики");
        System.out.println("Введите имя Первого игрока ");
        String igrok_1 =scaner1.next();
        System.out.println("Поздравляем, " +igrok_1+", Ваш символ - 'Х' ");
        System.out.println("Введите имя Второго  игрока ");
        String igrok_2 =scaner1.next();
        System.out.println("Поздравляем, "+igrok_2+", Ваш символ - 'O' ");
        int count=1;
        char [][] array = new char[3][3];
        for (int i =0; i<array.length;i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = (char)(count+'0');//
                count +=1;
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        String winer="no";
        boolean number=true;
        char simbol = 'O';
        while (winer=="no")
        {
            String tekushiy_igrok="";
            if(number)
            {
                System.out.println(igrok_1 + " выбирете следующее положение");simbol='X';tekushiy_igrok=igrok_1;}
            else {
                System.out.println(igrok_2 + " выбирете следующее положение");simbol='O';tekushiy_igrok=igrok_2;
            }

            count = scaner1.nextInt();



            boolean target=true;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    if ((char) (count + '0') == array[i][j]){
                        array[i][j] = simbol;target=false;}

                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
            if (target)
            {System.out.println("ERROR повторите ввод");
                continue;}
            number= !number;
            int dia=0;
            int dia2=0;
            for (int i = 0; i < array.length; i++)
            {
                int gor = 0;
                int ver = 0;

                for (int j = 0; j < array.length; j++)
                {
                    if (array[i][j] == simbol)
                        gor+=1;
                    if (array[j][i] == simbol)
                        ver+=1;
                    if (i==j&&array[i][j] == simbol)
                        dia+=1;
                    if (i+j== array.length-1&&array[i][j] == simbol)
                        dia2+=1;


                }

                if (gor==3||ver==3)
                {
                    System.out.println(tekushiy_igrok + " WINER!!!!!" );winer="yes";

                }
                else
                {gor=0; ver=0;}

            }
            if (dia==3||dia2==3)
            {
                System.out.println(tekushiy_igrok + " WINER!!!!!" );winer="yes";

            }
            else
            {dia=0; dia2=0;}




        }
    }
}
