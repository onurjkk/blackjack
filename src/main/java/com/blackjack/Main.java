package com.blackjack;

import com.blackjack.view.IntroView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        IntroView introView = new IntroView(stage);

        Scene scene = new Scene(introView.getLoader().load());

        
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.jpg")));
        stage.setScene(scene);
        stage.setTitle("Blackjack");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
