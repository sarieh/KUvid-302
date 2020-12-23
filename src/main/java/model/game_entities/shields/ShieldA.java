package model.game_entities.shields;

public class ShieldA extends ShieldDecorator{

    public ShieldA(Shieldable shield) {
        super(shield);
    }

    @Override
    public double getEfficiency() {
        return 0;
    }
}
