package com.javarush.task.pro.task10.task1007;

/* 
С крышей или без? Вот в чем вопрос
*/

public class Bugatti {
    private String color;
    private int year;
    private String body ;

    //напишите тут ваш код
    public Bugatti(){
        color = "BLACK";
        year = 2020;
        body = "Coupe";
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }
}
