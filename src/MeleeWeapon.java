public class MeleeWeapon extends Weapon {


    public MeleeWeapon(String name, String description, double damage) {
        super(name, description, damage);
    }

    @Override
    public boolean canUse(){
        return true;
    }

    @Override
    public void use(){
    }

}
