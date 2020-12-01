package model.game_entities;

import model.game_entities.enums.EntityType;
import model.game_physics.hitbox.Hitbox;
import utils.Coordinates;

/**
 * Entity: a Superclass for all the game objects
 */
public class Entity {
    private Coordinates coordinates;
    private Hitbox hitbox;
    private EntityType superType;

    public Entity(Coordinates coordinates, Hitbox hitbox) {
        this.coordinates = coordinates;
        this.hitbox = hitbox;
    }

    public EntityType getSuperType() {
        return superType;
    }

    public void setSuperType(EntityType superType) {
        this.superType = superType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
}