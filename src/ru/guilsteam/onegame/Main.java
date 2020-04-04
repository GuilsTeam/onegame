package ru.guilsteam.onegame;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import java.io.IOException;
import java.util.Arrays;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.*;
import org.lwjgl.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class Main {
	Blocks blocks = new Blocks();
	
	public Main(String[] args) {
		try {
			Display.setDisplayModeAndFullscreen(Display.getDesktopDisplayMode());
			if (args.length == 3) {
				System.out.println("Got 3 arguments in start command: " + Arrays.hashCode(args));
				System.out.println("Setting data:");
				System.out.println("Display.setDisplayMode(" + args[1] + "," + args[2] + ")");
				System.out.println("Display.setTitle(" + args[0] + ")");
				Display.setDisplayMode(new DisplayMode(Integer.parseInt(args[1]), Integer.parseInt(args[2])));
				Display.setTitle(args[0]);
			}else if (args.length == 0){
				System.out.println("Got 0 arguments in start command: null");
				System.out.println("Setting data:");
				System.out.println("Display.setDisplayMode(1000, 600)");
				System.out.println("Display.setTitle(DEFAULT)");
				Display.setDisplayMode(new DisplayMode(1000, 600));
				Display.setTitle("[GuilsTeam] One Open-source game like Minecraft");
			}else{
				System.out.println("Can not start One Open-source game like Minecraft: arguments' length can be only 3 or 0, provided: " + args.length);
				System.out.println("[ru.guilsteam.onegame.Main] public static void main(String[] args) { new Main(args); }");
				System.out.println("[ru.guilsteam.onegame.Main] public Main(String[] args) {...}");
				System.out.println("[ru.guilsteam.onegame.Main] try {...}");
				System.out.println("[ru.guilsteam.onegame.Main] int length = args.length;");
				System.out.println("[ru.guilsteam.onegame.Main] else {...}");
				System.err.println("[ru.guilsteam.onegame.Main] Failed to set data: ");
				System.err.println("Display.setDisplayMode(width, height)");
				System.err.println("Display.setTitle(title)");
				System.err.println();
				System.err.println("Use command");
				System.err.println("		java -jar onegame.jar <title> <window height> <window width>");
				System.err.println("or");
				System.err.println("		java -jar onegame.jar");
				System.err.println("to start game");
				System.err.println("Process crashed with exit code 1");
				System.exit(1);
			}
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(60, (float) 1440 / (float) 900, 0.001f, 1000);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_DEPTH_TEST);
		
		
		int tex = 0;
		try {
			tex = TextureLoader.loadTexture("resources/textures.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Mouse.setGrabbed(true);
		
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			glClearColor(0.0f, 0.7f, 0.9f, 1.0f);
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();
				System.exit(0);
			}
			
			//Rendering
			blocks.Rendering();
			Controller.running();
			
			Display.update();
			Display.sync(75);
		}
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new Main(args);
	}

}
