package lycheenoisi.paintball.model;

public class Field extends Model{
    private String name;
    private String description;
    private boolean is_inside;
    private int level;
    private int maxPlayers;
    private int minPlayers;
    private boolean vip;
    private double price;

    public Field(String name, String description, boolean is_inside, int level, int maxPlayers, int minPlayers, boolean vip, double price) {
        this.setName(name);
        this.setDescription(description);
        this.setIs_inside(is_inside);
        this.setLevel(level);
        this.setMaxPlayers(maxPlayers);
        this.setMinPlayers(minPlayers);
        this.setVip(vip);
        this.setPrice(price);
    }

    @Override
    public String toString(){
        return "Name field: " + this.getName() + ", Description: " + this.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_inside() {
        return is_inside;
    }

    public void setIs_inside(boolean is_inside) {
        this.is_inside = is_inside;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}