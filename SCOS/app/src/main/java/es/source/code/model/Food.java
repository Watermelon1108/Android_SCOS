package es.source.code.model;

/**
 * Created by huang on 2016/6/17.
 */
public class Food {
    String name;
    String price;
    String amount;
    String note;
    public Food(String strName,String strPrice,String strAmount,String strNote){
        this.name = strName;
        this.price = strPrice;
        this.amount = strAmount;
        this.note = strNote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", amount='" + amount + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
