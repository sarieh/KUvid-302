package model.game_running.runnables;

import model.game_building.GameConstants;
import model.game_entities.AutonomousEntity;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * This runnable handles moving objets in the background
 */
public class MovementRunnable extends GameRunnable {

    CopyOnWriteArrayList<AutonomousEntity> entities; // A reference to the list of autonomous game entities in the space.

    public MovementRunnable(CopyOnWriteArrayList<AutonomousEntity> entities) {
        super();
        this.entities = entities;
    }

    @Override
    public void run() {
        running = true; //this will be set to false from somewhere else (when the game ends).
        while (running) {
            try {
                latch.await(); // if the game is paused, this latch clogs this runnable.
                // move all entities in the space
                for (AutonomousEntity entity : entities)
                    entity.move();

                Thread.sleep(GameConstants.GAME_THREAD_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
