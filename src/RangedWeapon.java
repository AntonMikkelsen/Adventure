public class RangedWeapon extends Weapon {
        private double ammo;

    public RangedWeapon(String name, String description, double damage, double ammo){
        super(name, description, damage);
        this.ammo = ammo;
    }

    @Override
    public boolean canUse(){
        return ammo > 0;
    }

    @Override
    public void use(){
        if (ammo>0){
            ammo--;
        }
    }
    public double getAmmo(){
        return ammo;
    }
}
