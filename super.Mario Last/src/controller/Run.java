package controller;

import view.MainFrame;

public class Run {

	public static void main(String[] args) {
		MainFrame.Sound("audio/MainTheme.wav", false);

		new MainFrame();

	}
}
