package com.metanit;

enum Size{
    XXS(32){
        @Override
        public String getDescription(){
            return "Детский размер";
        }
    }, XS(34), S(36), M(38), L(40);
    int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription(){
        return "Взрослый размер";
    }
    public String toString(){
        return name() + " |" + euroSize + "| " + getDescription();
    }
}

abstract class Clothes{
    Size size;
    String color;
    double price;

    Clothes(Size size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public Size getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}

class Atelier{
    void dressAMan(Clothes[] clothes){
        System.out.println("\n" + "==== Мужская одежда ====");
        for(Clothes cloth : clothes){
            if(cloth instanceof MensClothing){
                System.out.println(cloth);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("\n" + "==== Женская одежда ====");
        for(Clothes cloth : clothes){
            if(cloth instanceof WomenClothing){
                System.out.println(cloth);
            }
        }
    }

    interface MensClothing{
        default void dressAmen(){
            System.out.println("Одеть мужчину");
        }
    }

    interface WomenClothing{
        default void dressAwomen(){
            System.out.println("Одеть женщину");
        }
    }

    public static class Cargigan extends Clothes implements MensClothing, WomenClothing{
        Cargigan(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер кардиган " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Hoodies extends Clothes implements MensClothing, WomenClothing{
        Hoodies(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер худи " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Longsleeve extends Clothes implements WomenClothing{
        Longsleeve(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер лонгслив " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }

    public static class Jeans extends Clothes implements MensClothing{
        Jeans(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "\n" + "Размер джинсы " + getSize() + "\n" + "Цвет: " + getColor() + "\n" + "Цена: " + getPrice() + " рублей";
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Atelier.Cargigan(Size.XXS, "Бежевый", 6100),
                new Atelier.Cargigan(Size.M, "Коричневый", 3300),
                new Atelier.Hoodies(Size.XS, "Чёрная", 5800),
                new Atelier.Hoodies(Size.L, "Фуксия", 4900),
                new Atelier.Longsleeve(Size.XS, "Белый", 2600),
                new Atelier.Longsleeve(Size.XXS, "Голубой", 2500),
                new Atelier.Jeans(Size.M, "Хаки", 1500),
                new Atelier.Jeans(Size.S, "Синие", 2500),
        };

        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        atelier.dressAWoman(clothes);
    }
}