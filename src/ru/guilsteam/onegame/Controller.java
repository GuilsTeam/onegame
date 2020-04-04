package ru.guilsteam.onegame;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Controller {
	public static int mouseSpeed = 2;
	public static float maxLookUp = 85;
	public static float maxLookDown = -85;
	
	public static Vector3f position = new Vector3f(-1, 0, -5);
	public static Vector3f rotation = new Vector3f(0, 0, 0);
	
	public static int walkingSpeed = 40;
	
	public static long lastFrame;
	
	public static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public static int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	
	public static void running() {
		int delta = getDelta();
		
		glLoadIdentity();
		glRotatef(rotation.x, 1, 0, 0);
		glRotatef(rotation.y, 0, 1, 0);
		glRotatef(rotation.z, 0, 0, 1);
		glTranslatef(position.x, position.y, position.z);
		
		if(Mouse.isGrabbed()) {
			float mouseDX = Mouse.getDX() * mouseSpeed * 0.16f;
			float mouseDY = Mouse.getDY() * mouseSpeed * 0.16f;
			
			if(rotation.y + mouseDX >= 360) {
				rotation.y = rotation.y + mouseDX - 360;
			}
			else if(rotation.y + mouseDX < 0) {
				rotation.y = 360 - rotation.y + mouseDX;
			}
			else {
				rotation.y += mouseDX;
			}
			
			if(rotation.x - mouseDY >= maxLookDown && rotation.x - mouseDY <= maxLookUp) {
				rotation.x += -mouseDY;
			}
			else if(rotation.x - mouseDY < maxLookDown) {
				rotation.x = maxLookDown;
			}
			else if(rotation.x - mouseDY > maxLookUp) {
				rotation.x = maxLookUp;
			}
		}	
		
			
			boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP);
			boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN);
			boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT);
			boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT);
			boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_SPACE);
			boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_E);
			boolean moveFaster = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
			boolean moveSlower = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
			
			if(moveFaster && !moveSlower) {
				walkingSpeed = 80;
			}
			else if(moveSlower && !moveFaster) {
				walkingSpeed = 4;
			}
			else {
				walkingSpeed = 40;
			}
			
			if(keyUp && !keyDown && !keyRight && !keyLeft) {
				float angle = rotation.y;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position = newPosition;
			}
			if(!keyUp && keyDown && !keyRight && !keyLeft) {
				float angle = rotation.y - 180;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position = newPosition;
			}
			if(!keyUp && !keyDown && !keyRight && keyLeft) {
				float angle = rotation.y - 90;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position = newPosition;
			}
			if(!keyUp && !keyDown && keyRight && !keyLeft) {
				float angle = rotation.y + 90;
				Vector3f newPosition = new Vector3f(position);
				float hypotenuse = (walkingSpeed * 0.0002f) * delta;
				float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
				float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
				newPosition.z += adjacent;
				newPosition.x -= opposite;
				position = newPosition;
			}
			
			if(flyUp && !flyDown) {
				double newPositionY = (40 * 0.0002f) * delta;
				position.y -= newPositionY;
			}
			
			if(!flyUp && flyDown) {
				double newPositionY = (40 * 0.0002f) * delta;
				position.y += newPositionY;
			}
		}
	}
