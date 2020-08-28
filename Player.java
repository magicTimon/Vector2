package cc.retzlaff.timon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player {
	public Vector2 pos;
	public Vector2 vel = new Vector2(0, 0);
	public Vector2 acc = new Vector2(0, 0);
	public float speed;
	public float maxS;
	public float maxA;
	char left;
	char right;
	char up;
	char down;
	boolean mU = false;
	boolean mL = false;
	boolean mD = false;
	boolean mR = false;
	Player(Vector2 pos, float maxSpeed, float maxAcc, float speed, char left, char right, char up, char down) {
		this.pos = pos;
		this.maxS = maxSpeed;
		this.maxA = maxAcc;
		this.speed = speed;
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	public void update(Graphics g) {
		if (mU) {
			acc.addY(-speed);
		}
		if (mL) {
			acc.addX(-speed);
		}
		if (mD) {
			acc.addY(speed);
		}
		if (mR) {
			acc.addX(speed);
		}
		vel.add(acc);
		acc.limit(maxA);
		acc.mult(0.9f);
		vel.limit(maxS);
		vel.mult(0.9f);
		pos.add(vel);
		g.setColor(Color.blue);
		g.fillOval(Math.round(pos.getX()), Math.round(pos.getY()), 100, 100);
	}

	public void keyPressed (KeyEvent e) {
		char Char = e.getKeyChar();
		if (Char == up) {
			mU = true;
		} else if (Char == left) {
			mL = true;
		} else if (Char == down) {
			mD = true;
		} else if (Char == right) {
			mR = true;
		}
	}

	public void keyReleased (KeyEvent e) {
		char Char = e.getKeyChar();
		if (Char == up) {
			mU = false;
		} else if (Char == left) {
			mL = false;
		} else if (Char == down) {
			mD = false;
		} else if (Char == right) {
			mR = false;
		}
	}
}
