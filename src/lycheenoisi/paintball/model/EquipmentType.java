package lycheenoisi.paintball.model;

public class EquipmentType extends Model{
    private String name;
    private double rent_price;

    public EquipmentType(String name, double rent_price){
        this.setName(name);
        this.setRent_price(rent_price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRent_price() {
        return rent_price;
    }

    public void setRent_price(double rent_price) {
        this.rent_price = rent_price;
    }
}
