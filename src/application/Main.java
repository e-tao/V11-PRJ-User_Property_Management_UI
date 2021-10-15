package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainUILayout.fxml"));
			Scene scene = new Scene(root, 1024, 768);

			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/rec/icon.png"));
			primaryStage.setTitle("FireRnR Database Query System");

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
