package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

//	Booking booking = new Booking();
//	TableColumn<Booking, String> column;

	private Queryable booking = new Booking();
	private TableView<Queryable> bookingTable = new TableView<>();
	private ViewGenerator view = new ViewGenerator();

	private SecLevelWindow bookingWindow;

	private String employeeNnumber;

	@Override
	public void start(Stage primaryStage) {
		try {

			int buttonW = 150;
			int buttonH = 100;
			int centerSpacing = 45;

//  Main UI layout
//  -------------------------------
//      EMPLOYEE NO ___________        root.top - vTop - hTop - Label, Text field
//     
//
//		  -----	     -----
//        |   |      |   |             root.center - vCenter - hCenterTop - Buttons
//		  |	  |      |   |
//        -----		 -----	
//		  -----      -----	
//		  |	  |      |   |             root.center - vCenter - hCenterBottom - Buttons
//		  |   |      |   |	
//		  -----      -----	
//	-------------------------------	   root.bottom - vBottom - Separator
//      FIRERNR COPYRIGHT INFO		   root.bottom - vBottom - Label 			
//  

			BorderPane root = new BorderPane();

			VBox vTop = new VBox();
			VBox vCenter = new VBox();
			VBox vBottom = new VBox();
			HBox hTop = new HBox();
			HBox hCenterTop = new HBox();
			HBox hCenterBottom = new HBox();

			hTop.setPrefHeight(20);
			vTop.setPrefHeight(40);

//=========================== Misc. components ============================================

			Label employee = new Label("Employee No.");
			TextField employeeNo = new TextField();
			employeeNo.setPromptText("8 digts Employee No.");
			employeeNo.setFocusTraversable(false);

			Separator separator = new Separator();
			Label copyRight = new Label("FireRnR All Rights Reserved 2019 - 2021");

//======================= Buttons and Decorations Start ===================================	

			Button booking = new Button("_BOOKING");
			Button user = new Button("_USER");
			Button property = new Button("_PROPERTY");
			Button log = new Button("_LOG");

			ImageView bookingImg = new ImageView(new Image(getClass().getResourceAsStream("/rec/booking.png")));
			ImageView userImg = new ImageView(new Image(getClass().getResourceAsStream("/rec/user.png")));
			ImageView propertyImg = new ImageView(new Image(getClass().getResourceAsStream("/rec/property.png")));
			ImageView logImg = new ImageView(new Image(getClass().getResourceAsStream("/rec/log.png")));

			booking.setGraphic(bookingImg);
			user.setGraphic(userImg);
			property.setGraphic(propertyImg);
			log.setGraphic(logImg);

			String bgStyle = "-fx-background-color: BurlyWood; -fx-font-size:13px;";

			Tooltip bookingTip = new Tooltip("Manage Bookings");
			bookingTip.setStyle(bgStyle);
			booking.setTooltip(bookingTip);

			Tooltip userTip = new Tooltip("Manage User Accounts");
			userTip.setStyle(bgStyle);
			user.setTooltip(userTip);

			Tooltip propertyTip = new Tooltip("Manage Available Properties");
			propertyTip.setStyle(bgStyle);
			property.setTooltip(propertyTip);

			Tooltip logTip = new Tooltip("System Logs");
			logTip.setStyle(bgStyle);
			log.setTooltip(logTip);

			booking.setPrefSize(buttonW, buttonH);
			user.setPrefSize(buttonW, buttonH);
			property.setPrefSize(buttonW, buttonH);
			log.setPrefSize(buttonW, buttonH);

//======================= Buttons and Decorations End ===================================	

//================================ Actions config start =================================
			employeeNo.setOnAction((ae) -> {
				employeeNnumber = employeeNo.getText();
			});

			booking.setOnAction((ae) -> {
				bookingWindow = new SecLevelWindow();
				bookingWindow.show();
			});

//================================ Actions config end ===================================

//======================= Main UI Arrangement Starts ====================================

			hTop.getChildren().addAll(employee, employeeNo);
			hTop.setAlignment(Pos.CENTER);
			hTop.setSpacing(20);
			vTop.getChildren().add(hTop);
			vTop.setAlignment(Pos.BOTTOM_CENTER);

			hCenterTop.getChildren().addAll(booking, property);
			hCenterBottom.getChildren().addAll(user, log);
			vCenter.getChildren().addAll(hCenterTop, hCenterBottom);
			hCenterTop.setAlignment(Pos.CENTER);
			hCenterTop.setSpacing(centerSpacing);
			hCenterBottom.setAlignment(Pos.CENTER);
			hCenterBottom.setSpacing(centerSpacing);
			vCenter.setAlignment(Pos.CENTER);
			vCenter.setSpacing(centerSpacing);

			vBottom.getChildren().addAll(separator, copyRight);
			vBottom.setAlignment(Pos.CENTER);

			root.setTop(vTop);
			root.setCenter(vCenter);
			root.setBottom(vBottom);

			// ============ scene and stage config start = ===================

			Scene scene = new Scene(root, 550, 450);
			scene.setCursor(Cursor.HAND);

			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/rec/icon.png"));
			primaryStage.setTitle("FireRnR Database Query System");
			primaryStage.show();

			// ============ scene and stage config end =======================

		} catch (Exception e) {
			e.printStackTrace();
		}

////======================= Main UI Arrangement Ends ====================================

//			bookingTable = view.getView(booking);
//			root.setCenter(bookingTable);

//			DBCon.init();
//			ArrayList<Booking> booking = Booking.GetBooking();
//
//			DBCon.close();

//			bookingTable.getItems().addAll(booking);

	}

	public static void main(String[] args) {
		launch(args);
	}

	public String getEmployeeNnumber() {
		return employeeNnumber;
	}

}
