/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labex11;
import java.util.*;
/**
 *
 * @author Desktop pc
 */
public class threadprgrm{
	public static void main(String args[]) {
		RandomNumberThread rnThread = new RandomNumberThread();
		rnThread.start();
	}
}

class RandomNumberThread extends Thread {
	public void run() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int randomInteger = random.nextInt(100);
			System.out.println("Random Integer generated : " + randomInteger);
			if((randomInteger%2) == 0) {
				SquareThread sThread = new SquareThread(randomInteger);
				sThread.start();
			}
			else {
				CubeThread cThread = new CubeThread(randomInteger);
				cThread.start();
			}
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}
}

class SquareThread extends Thread {
	int number;

	SquareThread(int randomNumbern) {
		number = randomNumbern;
	}

	public void run() {
		System.out.println("Square of " + number + " = " + (number * number));
	}
}

class CubeThread extends Thread {
	int number;

	CubeThread(int randomNumber) {
		number = randomNumber;
	}

	public void run() {
		System.out.println("Cube of " + number + " = " + number * number * number);
	}
}
