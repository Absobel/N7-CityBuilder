package simcity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Circle {
    private Vector2 position;
    private float radius;
    private Vector3 color;
    private float velocityY;

    public Circle(ShapeRenderer shapeRenderer, Vector2 position, float radius, Vector3 color) {
        this.position = position;
        this.radius = radius;
        this.color = color;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getRadius() {
        return radius;
    }

    public Vector3 getColor() {
        return color;
    }

    public void addVelocityY(float delta_velocity_y) {
        this.velocityY += delta_velocity_y;
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color.x, color.y, color.z, 1);
		shapeRenderer.circle(position.x, position.y, radius);
    }

    public void update(float delta) {
        velocityY -= Game.GRAVITY * delta;
        position.y += velocityY * delta;
        if (position.y < radius) {
            position.y = radius;
            velocityY *= -Game.FRICTION;
        }
    }

}
