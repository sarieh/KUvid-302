package model.game_space;

import model.game_entities.*;
import model.game_entities.enums.BlockerType;
import model.game_entities.enums.MoleculeStructure;
import model.game_entities.enums.MoleculeType;
import model.game_entities.enums.PowerupType;
import model.game_physics.hitbox.CircularHitbox;
import model.game_physics.hitbox.Hitbox;
import model.game_physics.hitbox.HitboxFactory;
import model.game_physics.hitbox.RectangularHitbox;
import model.game_physics.path_patterns.PathPattern;
import model.game_physics.path_patterns.PathPatternFactory;
import model.game_physics.path_patterns.StraightPattern;
import model.game_physics.path_patterns.ZigzagPatten;
import model.game_running.GameConstants;
import model.game_running.RunningMode;
import org.apache.log4j.Logger;
import utils.Coordinates;
import utils.Velocity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
/**
 * responsible for creating blockers, and powerups, molecules in the game space
 */
public class ObjectGenerator  implements Runnable{
    private Map<Map<MoleculeType, MoleculeStructure>, Integer> numberOfMolecules;
    private Map<BlockerType, Integer> numberOfBlockers;
    private Map<PowerupType, Integer> numberOfPowerup;
    private RunningMode runningMode;

    private static Random random = new Random();
    private static Logger logger = Logger.getLogger(ObjectGenerator.class.getName());


    public ObjectGenerator(RunningMode runningMode) {
        this.runningMode = runningMode;
    }

    @Override
    public void run() {
        while (true){
            int choice = random.nextInt(3);
            switch (choice){
                case 0:
                    this.runningMode.addEntity(generateMolecule());
                    break;
                case 1:
                    this.runningMode.addEntity(generateBlocker());
                    break;
                case 2:
                    this.runningMode.addEntity(generatePowerup());
                    break;
            }
            //sleep before adding new objects
            try {
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    // TODO: generator ALWAYS generate entities of the same type
    /**
     * generates a random Blocker to be thrown in the space
     * @return a Blocker of a random type
     */
    public Blocker generateBlocker(){
        double x_coord = Math.random() * GameConstants.BUILDING_WINDOW_SIZE.width;
        logger.info("[ObjectGenerator: generating a blocker at coordinates " + new Coordinates(x_coord, 0) + " ]");
        return new Blocker(new Coordinates(x_coord, 0), HitboxFactory.getInstance().getBlockerHitbox(), PathPatternFactory.getInstance().getBlockerPathPattern(), BlockerType.ALPHA_B, 5, 10 );
    }

    /**
     * generates a random powerup to be thrown in the space
     * @return a Powerup of a random type
     */
    public Powerup generatePowerup(){
        double x_coord = Math.random() * GameConstants.BUILDING_WINDOW_SIZE.width;
        logger.info("[ObjectGenerator: generating a powerup at coordinates " + new Coordinates(x_coord, 0) + " ]");
        return new Powerup(new Coordinates(x_coord, 0), HitboxFactory.getInstance().getPowerUpHitbox(), PathPatternFactory.getInstance().getPowerUpPathPattern(), PowerupType._ALPHA_B);
    }

    /**
     * generates a random Molecule to be thrown in the space
     * @return a Molecule of a random type
     */
    public Molecule generateMolecule(){
        double x_coord = Math.random() * GameConstants.BUILDING_WINDOW_SIZE.width;
        logger.info("[ObjectGenerator: generating a molecule at coordinates " + new Coordinates(x_coord, 0) + " ]");
        return  new Molecule(new Coordinates(x_coord, 0), HitboxFactory.getInstance().getMoleculeHitbox(), PathPatternFactory.getInstance().getMoleculePathPattern(), MoleculeType.ALPHA_, MoleculeStructure.CIRCULAR);
    }
}
