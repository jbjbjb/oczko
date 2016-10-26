/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oczko;

import java.util.Random;

/**
 *
 * @author Justyna
 */
public class Card {
    private int value;
    private String figure;
    static int[] cards={11,2,3,4,5,6,7,8,9,10,10,10,10};//A,2,3,4,5,6,7,8,9,10,J,D,K

    public Card(){
        value=0;
        figure="0";
    }
    public Card(int value, String figure){
        this.value=value;
        this.figure=figure;
    }
    public Card drowCard(){
        int tmp;
       Random r=new Random();
       tmp=r.nextInt(13);
       value=cards[tmp];
       switch (tmp){
           case 0:
                   {figure="A";
                   break;
                   }
           case 10:
                    {figure="J";
                   break;
                   }
           case 11:
                    {figure="D";
                   break;
                   }
           case 12:
                    {figure="K";
                   break;
                   }
           default:
                    {
                        tmp++;
                        figure=String.valueOf(tmp);
                     }
    }
       tmp=r.nextInt(4);
       Card x=new Card(value,figure);
       return x;
       
    }   
    public int getValue() {
        return value;
    }

    public String getFigure() {
        return figure;
    }
    
}
