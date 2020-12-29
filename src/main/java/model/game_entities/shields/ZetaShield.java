package model.game_entities.shields;

import static model.game_building.GameConstants.*;
import model.game_entities.Atom;

public class ZetaShield extends ShieldDecorator {

    public ZetaShield(Atom atom) {
        super(atom);
    }

    @Override
    public double getEfficiency() {
        double oldEfficiency = this.getAtom().getEfficiency();
        double efficiencyFactor = (1 - oldEfficiency) * ZETA_EFFICIENCY_BOOST;

        boolean canImprove = this.getAtom().getNumberOfNeutrons() == this.getAtom().getNumberOfProtons();

        if (canImprove)
            return oldEfficiency + oldEfficiency * efficiencyFactor;
        return oldEfficiency;
    }

    @Override
    public double getAtomSpeedPercentage() {
        return super.getAtom().getAtomSpeedPercentage() - ZETA_SPEED_REDUCTION_PERCENTAGE;
    }
}
