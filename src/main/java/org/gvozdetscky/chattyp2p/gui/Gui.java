package org.gvozdetscky.chattyp2p.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Gui extends Application {

	public static void launchMyApp(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("chatty p2p");



		primaryStage.show();
	}
}
