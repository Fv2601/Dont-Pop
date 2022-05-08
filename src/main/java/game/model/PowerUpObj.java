package game.model;

import game.collider.*;
import game.engine.GameEngine;
import game.graphics.*;
import game.util.Point2D;

/**
 * Models powerup objects.
 */
public class PowerUpObj extends AbstractGameObject {

	private static final double SIZE = 0.1;
	
	private double timer;	//0
	
	/**
	 * Creates a new powerup object of the type specified in its proper argument.
	 * @param position
	 * @param type
	 * @param gameEngine
	 */
    public PowerUpObj(final Point2D position, final ObjectType type, final GameEngine gameEngine) {
		super(position, type, gameEngine);
		
		switch (type) {
		    case PWRUP_SHIELD -> this.setRenderer((Renderer) new ImageRenderer(this, ImageRenderer.Sprite.PWRUP_SHIELD, SIZE, 0));
		    case PWRUP_MULTIPLIER -> this.setRenderer((Renderer) new ImageRenderer(this, ImageRenderer.Sprite.PWRUP_MULTIPLIER, SIZE, 0));
		    default -> this.setRenderer((Renderer) new ImageRenderer(this, ImageRenderer.Sprite.PWRUP_SWEEPER, SIZE, 0));
		}
		
		this.setCollider((Collider)new CircleCollider(this, SIZE / 2, Point2D.of(0, 0)));
	}

	/**
	 * Updates the remaining life of the powerup.
	 * Counts elapsed time and destroys it when time's up. 
	 */
	@Override
	public void update() {
		timer += this.getGameEngine().getDeltaTime();
		if (timer >= 5) {
			this.destroy();
		}
	}
}
