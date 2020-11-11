package lycheenoisi.paintball.model;

public class FightType extends Model {
    private String name;
    private String description;
    private int id;

    public FightType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public FightType() { }

    public FightType(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
