package GUI;

import Logic.Player;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class game extends Application{

	private Player player1 = new Player();
	private Player player2 = new Player();
	private GridPane gp = new GridPane();
	private PlayerView pv1 = new PlayerView(player1);
	private PlayerView pv2 = new PlayerView(player2);
	private Image rps = new Image("file:./Images/rock-paper-scissors.png");
	private ImageView iv = new ImageView(rps);
	private Button fight = new Button("Fight!");

	
    private PauseTransition delay = new PauseTransition(Duration.seconds(2));
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		//Game starts
		fight.setOnAction(e -> {
			Stage winStage = new Stage();
			Label wLabel;
			
			if(player1.getHand().getSign().equals(player2.getHand().getSign()))
				wLabel = new Label("Draw!");
			else {
				if(player1.getHand().isHandSignStronger(player2.getHand())) {
					wLabel = new Label("Player 1 wins");
				}
				else
					wLabel = new Label("Player 2 wins");
			}
			wLabel.setAlignment(Pos.CENTER);
			Scene wScene = new Scene(wLabel, 300,200);
			winStage.setScene(wScene);
			winStage.show();
			delay.setOnFinished(event -> winStage.close());
			delay.play();
			pv1.setOpacity(1);
			pv2.setOpacity(1);
			
		});
		GridPane.setHalignment(fight, javafx.geometry.HPos.CENTER);
		
		//fine adjustments
		iv.setFitWidth(200);
		iv.setFitHeight(200);
		
		gp.add(new Label("Player 1"), 0, 0);
		gp.add(new Label("Player 2"), 2, 0);
		gp.add(pv1, 0, 1);
		gp.add(pv2, 2, 1);
		gp.add(iv, 1, 1);
		gp.add(fight, 1, 2);
	
		gp.setHgap(20);
		gp.setVgap(10);
		gp.setPadding(new Insets(50,50,20,50));

		Scene scene = new Scene(gp, 480,350);
		primaryStage.setTitle("Rock, Paper, Scissors!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}	
}
