module com.blackjack.blackjack {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.blackjack to javafx.fxml;
    exports com.blackjack;

    exports com.blackjack.view to javafx.fxml;
    opens com.blackjack.view to javafx.fxml;

    exports com.blackjack.controller to javafx.fxml;
    opens com.blackjack.controller to javafx.fxml;
}