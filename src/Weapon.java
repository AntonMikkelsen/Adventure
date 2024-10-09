public abstract class Weapon extends Item{


    private double damage;
    private double durability;


    public Weapon (String name, String description, double damage, double durability){
        super(name, description);
        this.damage = damage;
        this.durability = durability;
    }


    public double getDamage() {
        return damage;
    }


    public double getDurability() {
        return durability;
    }


    public void useWeapon(){
        durability--;
    }


}
