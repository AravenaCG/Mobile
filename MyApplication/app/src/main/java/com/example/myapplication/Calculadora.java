package com.example.myapplication;

public class Calculadora {

    public static int Suma(int a,int b)
    {
        int ans= a+b;
        return ans;
    }

    public static int Resta(int a, int b) {
        int answer = a-b;
        return answer;
    }

    public static int Multi (int a , int b ) {
        int answer = a*b;
        return answer;
    }

    public static float Div(int a , int b, String msj) {

        float answer=0;
        msj = "No se puede dividir por 0";

        if (b != 0) {
            answer = a/b;
        }
        else {
            System.out.println(msj);
        }
        return answer;
    }
}
