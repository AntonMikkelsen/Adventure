public class Enemy {

    private String name;
    private String description;
    private Weapon weapon;
    private double health;


    public Enemy(String name, String description, Weapon weapon, double health){
        this.name = name;
        this.description = description;
        this.weapon = weapon;
        this.health = health;
    }

    public double getHealth(){
        return health;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void attack (Player player){
        double weaponDamage = weapon.getDamage();
        if (health < 0){
            System.out.println("Enemy attacks you, hitting for " + weaponDamage + " your health is now at " + player.getPlayerHealth());
            player.decreaseHealth(weaponDamage);
        } else {
            System.out.println("Player is dead");
        }
    }

    public void hit (double damage){
        health-= damage;
        System.out.println("player hits enemy for: " + damage);
        System.out.println("enemy health is now at: " + health);
        if (health <= 0){
            die();
        }
    }

    private void die () {
        System.out.println(name + " has died and drops " + weapon.getName());
    }
    @Override
    public String toString(){
        return getName() + " description: " + getDescription() + getName() + " health is: " + getHealth() +
                " and has: " + getWeapon().getName() + " as their weapon";
    }
}
