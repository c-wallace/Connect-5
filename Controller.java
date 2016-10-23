package GUI;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.awt.event.InputEvent;
import java.util.ArrayList;

import static javafx.scene.paint.Color.*;


public class Controller
{
    private Stage primaryStage;
    private Scene primaryScene;
    private GraphicsContext gc;

    //Buttons
    @FXML private Button NameEnter;
    @FXML private Button SizeEnter;
    @FXML private RadioButton HumBtn;
    @FXML private RadioButton AIBtn;
    @FXML private Canvas canvas;
    @FXML private TextField SizeText;
    @FXML private TextField status;
    @FXML private TextField numPlayers;
    @FXML private TextField xCoordinate;
    @FXML private TextField yCoordinate;
    @FXML private Button PlayBtn;
    @FXML private ListView<String> list;

    boolean keepPlay = true;
    ArrayList<String> humans = new ArrayList<String>(5);
    int turn =1;


    void setStage(Stage stage, Scene scene){
        this.primaryStage = stage;
        this.primaryScene = scene;
    }

    public void play() {

        int num = Integer.parseInt(numPlayers.getText());
        gc = canvas.getGraphicsContext2D();
        int size = Integer.parseInt(SizeText.getText());
        int x = Integer.parseInt(xCoordinate.getText());
        int y = Integer.parseInt(yCoordinate.getText());
            for (int col = y; col < size; col++) {
                for (int row = x; row < size; row++) {

                    if (turn == 1) {
                        gc.setFill(RED);
                        gc.fillOval(row * (750 / size) + (150 / 4), col * (750 / size) + (150 / 4), 600 / size, 600 / size);

                        status.setText("Player " + Integer.toString(turn) + " turn.");
                            /*
                            if(turn == numPlayers)
                            {
                                turn =1;
                                break;
                            }*/
                            //break;turn++;
                        turn++;
                        }

                    else if (turn == 2) {
                        gc.setFill(YELLOW);
                        gc.fillOval(row * (750 / size) + (150 / 4), col * (750 / size) + (150 / 4), 600 / size, 600 / size);
                        status.setText("Player " + Integer.toString(turn) + " turn.");

                            /*
                            if(turn == numPlayers)
                            {
                                turn --;
                            }*/
                            //break;
                        turn++;
                    }

                    else if (turn == 3) {
                        gc.setFill(GREEN);
                        gc.fillOval(row * (750 / size) + (150 / 4), col * (750 / size) + (150 / 4), 600 / size, 600 / size);

                        status.setText("Player " + Integer.toString(turn) + " turn.");
                        turn++;
                    }
                    else if (turn == 4) {
                        gc.setFill(PURPLE);
                        gc.fillOval(row * (750 / size) + (150 / 4), col * (750 / size) + (150 / 4), 600 / size, 600 / size);
                        status.setText("Player " + Integer.toString(turn) + " turn.");
                        turn++;
                    }
                    else if (turn == 5) {
                        gc.setFill(ORANGE);
                        gc.fillOval(row * (750 / size) + (150 / 4), col * (750 / size) + (150 / 4), 600 / size, 600 / size);

                        status.setText("Player " + Integer.toString(turn) + " turn.");
                        turn++;
                    }


                    if(turn > num)
                    {
                        turn =1;
                        status.setText(Integer.toString(turn));
                    }
                    break;
                }

                break;
            }


            xCoordinate.clear();
            yCoordinate.clear();

    }
    public void DrawGrid()
    {

        gc = canvas.getGraphicsContext2D();
        gc.setFill(WHITE);

        int size = Integer.parseInt(SizeText.getText());

        for(int col = 0; col <= size; col++) {
            for(int row = 0; row <= size; row++) {

                gc.fillOval(row*(750/size)+(150/4),col*(750/size)+(150/4),600/size,600/size);
            }
        }
    }

    /*public int getHumanNum(String Fuck)
    {
        int index = 0;
        for(int i = 0; i < humans.size(); i++)
        {
            if(Fuck.equals(humans.get(i)))
            {
                index = humans.indexOf(i);
            }
        }
        return index;
    }*/
    public void clearGrid()
    {
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,1000,800);
        humans.clear();

        turn=1;
    }
    public void SwitchScene()
    {

    }
    /*private void drawGrid()
    {
        gc = canvas.getGraphicsContext2D();
        SizeEnter.onMouseClickedProperty(new EventHandler<MouseEvent>() {

           @Override public void handle (MouseEvent e)
            {
                gc.fillOval(0,0,25,25);
            }
        });
    }*/



/*@Override
                public void handle(MouseEvent e) {
                    if (!e.isControlDown()) {
                        gc = canvas.getGraphicsContext2D();
                        gc.fillOval(canvas.getWidth() - 100, canvas.getHeight() - 100, 25, 25);
                    }
                }
            });
        }*/
    //void setBoard()

}

