package model.game_entities.factories;

import model.game_building.Configuration;
import model.game_entities.Blocker;
import model.game_entities.enums.BlockerType;
import model.game_physics.hitbox.HitboxFactory;
import model.game_physics.path_patterns.PathPatternFactory;
import utils.Coordinates;

public class BlockerFactory {

    private static BlockerFactory blockerFactory = new BlockerFactory();

    private BlockerFactory(){
    }

    public static BlockerFactory getInstance(){
        if(blockerFactory == null){
            blockerFactory = new BlockerFactory();
        }
        return blockerFactory;
    }

    public Blocker getBlocker(int i){// TODO : modify implementation.
        Coordinates defaultCoordinates = new Coordinates(0,0);
        double blockingRadius =  Configuration.getInstance().getUnitL() * 0.5;
        double explosionRadius =  Configuration.getInstance().getUnitL() * 2;

        switch (i){
            case 0:
                return new Blocker(defaultCoordinates, HitboxFactory.getInstance().getBlockerHitbox(),
                        PathPatternFactory.getInstance().getBlockerPathPattern(), BlockerType.ALPHA_B, blockingRadius,
                        explosionRadius);
            case 1:
                return new Blocker(defaultCoordinates, HitboxFactory.getInstance().getBlockerHitbox(),
                    PathPatternFactory.getInstance().getBlockerPathPattern(), BlockerType.BETA_B, blockingRadius,
                    explosionRadius);
            case 2:
                return new Blocker(defaultCoordinates, HitboxFactory.getInstance().getBlockerHitbox(),
                    PathPatternFactory.getInstance().getBlockerPathPattern(), BlockerType.GAMMA_B, blockingRadius,
                    explosionRadius);
            case 3:
                return new Blocker(defaultCoordinates, HitboxFactory.getInstance().getBlockerHitbox(),
                    PathPatternFactory.getInstance().getBlockerPathPattern(), BlockerType.SIGMA_B, blockingRadius,
                    explosionRadius);
            default:
                return null;
        }
    }
}