
package model;
        public class Cat {
    private String breed;
    private String age;
    private int price;
    private int quantity;

    // Constructors
    public Cat(String breed, String age, int price, int quantity) {
        this.breed = breed;
        this.age = age;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
