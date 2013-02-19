import java.util.Random;

import javax.swing.JOptionPane;

public class Car {
	public static void main(String[] args) {

		Random generator = new Random();
		int xpos = generator.nextInt(21);
		int ypos = generator.nextInt(21);
		String opArray = "123";
		String input_op;
		boolean ignition_output = true;
		char col = color();
		int xposition = xpos;
		int yposition = ypos;

		do {
			input_op = JOptionPane
					.showInputDialog("Enter 1 to change ignition, 2 to change position of car and 3 to quit");
			if (input_op.equals("1")) {
				ignition_output = ignition();
				carStatus(col, ignition_output, xposition, yposition);
			} else if (input_op.equals("2")) {
				xposition = moveCarHor(xpos, ignition_output);
				yposition = moveCarVer(ypos, ignition_output);
				carStatus(col, ignition_output, xposition, yposition);

			} else if (input_op.equals("3")) {
				System.exit(0);
			}
		} while (opArray.indexOf(input_op) > -1);
	}

	public static char color() {
		final String alphabet = "RGBWS";
		final int N = alphabet.length();
		Random r = new Random();
		char c = ' ';
		for (int i = 0; i < 1; i++) {
			// System.out.println(alphabet.charAt(r.nextInt(N)));
			c = alphabet.charAt(r.nextInt(N));
		}
		return c;
	}

	public static boolean ignition() {

		boolean ignition_state = false;
		String ignition_input;
		ignition_input = JOptionPane.showInputDialog("Enter ignition state");
		if (ignition_input.equals("On")) {
			ignition_state = true;
		} else if (ignition_input.equals("Off")) {
			ignition_state = false;
		} else {
			ignition_state = false;
		}
		return ignition_state;
	}

	public static int moveCarHor(int xpos, boolean ignition_output) {
		if (ignition_output == true) {
			String x_increment = JOptionPane
					.showInputDialog("Enter x increment");
			int xpos_increment = Integer.parseInt(x_increment);
			xpos += xpos_increment;
			if (xpos > 20) {
				xpos = 0;
				JOptionPane.showMessageDialog(null,
						"Error:car position has exceeded grid, reset to zero");
			} else if (ignition_output == false) {
				JOptionPane.showMessageDialog(null, "Turn on ignition first");

			}
		}
		return xpos;
	}

	public static int moveCarVer(int ypos, boolean ignition_output) {
		if (ignition_output == true) {
			String y_increment = JOptionPane
					.showInputDialog("Enter y increment");
			int ypos_increment = Integer.parseInt(y_increment);
			ypos += ypos_increment;
			if (ypos > 20) {
				ypos = 0;
				JOptionPane.showMessageDialog(null,
						"Error:car position has exceeded grid, reset to zero");
			} else if (ignition_output == false) {
				JOptionPane.showMessageDialog(null, "Turn on ignition first");

			}
		}
		return ypos;
	}

	public static void carStatus(char col, boolean ignition_output,
			int xposition, int yposition) {
		System.out.println("Car Stats:");
		System.out.println("Color:" + col);
		System.out.println("Ignition:" + ignition_output);
		System.out.println("Location:" + xposition + "," + yposition);

		String[][] sarray = new String[20][20];
		String output = "-";
		String finaloutput = "";
		for (int dash = 0; dash < 20; dash++) {
			for (int i = 0; i < 20; i++) {
				sarray[dash][i] = output;
			}
		}
		sarray[xposition][yposition] = Character.toString(col);
		for (int dash = 0; dash < 20; dash++) {
			for (int i = 0; i < 20; i++) {
				finaloutput += sarray[dash][i];
			}
			System.out.println(finaloutput);
			finaloutput = "";
		}

	}

}
