package simcity;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import java.util.List;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import java.util.Random;


public class Game extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	List<Circle> circles;

	Random random = new Random();

	static final float GRAVITY = 2000f;
	static final float FRICTION = 0.8f;
	static final float JUMP_VELOCITY = 100f;

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		circles = new java.util.ArrayList<Circle>();
	}


	@Override
	public void render () {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Circle circle : circles) {
			circle.update(Gdx.graphics.getDeltaTime());
			circle.render(shapeRenderer);
		}
		shapeRenderer.end();

		if (Gdx.input.justTouched()) {
			circles.add(new Circle(shapeRenderer, new Vector2(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()), 10, new Vector3(random.nextFloat(), random.nextFloat(), random.nextFloat())));
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			for (Circle circle : circles) {
				circle.addVelocityY(JUMP_VELOCITY);
			}
		}
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}