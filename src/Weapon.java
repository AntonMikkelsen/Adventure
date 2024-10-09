public abstract class Weapon extends Item{

    private String name;
    private double damage;


    public Weapon (String name, String description, double damage){
        super(name, description);
        this.damage = damage;
        this.name = name;
    }

    public abstract boolean canUse();
    public abstract void use();

    public String getName(){
        return this.name;
    }

    public double getDamage(){
        return damage;
    }

}
