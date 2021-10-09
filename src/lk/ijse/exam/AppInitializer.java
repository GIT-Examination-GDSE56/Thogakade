package lk.ijse.exam;/**
 * @author Ushan Shanilka <ushanshanilka80@gmail.com>
 * @since 10/9/2021
 **/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene ( new Scene( FXMLLoader.load ( getClass ().getResource ( "view/ItemForm.fxml" ) ) ) );
        primaryStage.show ();
    }
}
