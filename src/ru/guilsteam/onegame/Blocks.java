package ru.guilsteam.onegame;
import static org.lwjgl.opengl.GL11.*;

public class Blocks {
	public int sizeX = 128;
	public int sizeZ = 128;
	
	public int offsetX;
	public int offsetY;
	public int offsetZ;
	
	public void Rendering() {
		for(int x = 0; x < sizeX; x += 2) {
			for(int z = 0; z < sizeZ; z += 2) {
				glBegin(GL_QUADS);
				//Front
				glTexCoord2f(0.015625f, 0);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0, 0);
				glVertex3f(1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0, 0.015625f);
				glVertex3f(1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0.015625f);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				
				//Right
				glTexCoord2f(0.015625f, 0);
				glVertex3f(1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0, 0);
				glVertex3f(1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0, 0.015625f);
				glVertex3f(1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0.015625f);
				glVertex3f(1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				
				//Down
				glTexCoord2f(0.046875f, 0);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0.03125f, 0);
				glVertex3f(1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0.03125f, 0.015625f);
				glVertex3f(1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0.046875f, 0.015625f);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				
				//Back
				glTexCoord2f(0.015625f, 0);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0, 0);
				glVertex3f(1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0, 0.015625f);
				glVertex3f(1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0.015625f);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				
				//Left
				glTexCoord2f(0.015625f, 0);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0, 0);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0, 0.015625f);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0.015625f);
				glVertex3f(-1 + x + offsetX, -1 + offsetY, 1 + offsetZ + z);
				
				//Up
				glTexCoord2f(0.03125f, 0);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0);
				glVertex3f(1 + x + offsetX, 1 + offsetY, 1 + offsetZ + z);
				glTexCoord2f(0.015625f, 0.015625f);
				glVertex3f(1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glTexCoord2f(0.03125f, 0.015625f);
				glVertex3f(-1 + x + offsetX, 1 + offsetY, -1 + offsetZ + z);
				glEnd();
			}
		}
	}
}
