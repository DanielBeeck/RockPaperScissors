package GUI;

import Logic.Hand;
import Logic.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView extends VBox{
	
	private Button scissors = new Button();
	private Button rock = new Button();
	private Button paper = new Button();
	
	private Image s = new Image("file:./Images/scissors.png");
	private Image st = new Image("file:./Images/stone.png");
	private Image p = new Image("file:./Images/paper.png");
	
	private ImageView ivs = new ImageView(s);
	private ImageView ivst = new ImageView(st);
	private ImageView ivp = new ImageView(p);
	
	

	public PlayerView(Player player) {
		
	this.getChildren().addAll(scissors,rock,paper);
	
	//disabling the focus on the buttons
	scissors.setFocusTraversable(false);
	rock.setFocusTraversable(false);
	paper.setFocusTraversable(false);
	
	scissors.setGraphic(ivs);
	rock.setGraphic(ivst);
	paper.setGraphic(ivp);
	
	ivs.setFitWidth(50);
	ivst.setFitWidth(50);
	ivp.setFitWidth(50);
	
	ivs.setFitHeight(50);
	ivst.setFitHeight(50);
	ivp.setFitHeight(50);
	
	scissors.setOnAction(e -> {
		player.getHand().setSign(1);
		this.setOpacity(0.5);
	});
	
	rock.setOnAction(e -> {
		player.getHand().setSign(2);
		this.setOpacity(0.5);
	});
	
	paper.setOnAction(e -> {
		player.getHand().setSign(3);
		this.setOpacity(0.5);
	});
	

	this.setAlignment(Pos.CENTER);
	this.setSpacing(10);
	}
	
	

}

