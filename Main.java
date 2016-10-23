package GUI;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Main extends Application {
    @FXML
    Button SizeEnter;
    @FXML Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Connect 5");
        Controller controller = new Controller();
        Scene scene =new Scene(root, 900, 800);
        controller.setStage(primaryStage, scene);
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(1000);



        primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);
    }
}
