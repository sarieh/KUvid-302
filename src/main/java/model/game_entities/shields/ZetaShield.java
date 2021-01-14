package model.game_entities.shields;

import model.game_entities.Atom;

import static model.game_building.GameConstants.ZETA_EFFICIENCY_BOOST;
import static model.game_building.GameConstants.ZETA_SPEED_REDUCTION_PERCENTAGE;

public class ZetaShield extends ShieldDecorator {

    public ZetaShield(Atom atom) {
        super(atom);
    }

    @Override
    public double getEfficiency() {
        //MODIFIES: the efficiency of the original atom, or possibly the shielded atom
        //EFFECTS: the efficiency of the original atom/shielded atom will be reduced depending on some criteria

        double oldEfficiency = this.getAtom().getEfficiency();
        double efficiencyFactor = (1 - oldEfficiency) * ZETA_EFFICIENCY_BOOST;

        boolean canImprove = this.getAtom().getNumberOfNeutrons() == this.getAtom().getNumberOfProtons();

        if (canImprove)
            return oldEfficiency * (1 + efficiencyFactor);
        return oldEfficiency;
    }

    @Override
    public double getAtomSpeedPercentage() {
        //MODIFIES: the speed of the original atom, or possibly the shielded atom
        //EFFECTS: the speed of the original atom/shielded atom will be reduced by a 11%
        return super.getAtom().getAtomSpeedPercentage() * (1 - ZETA_SPEED_REDUCTION_PERCENTAGE);
    }
}