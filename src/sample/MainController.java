package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
   public static Stage InfoStage = new Stage();

   public void showPhoto(ActionEvent actionEvent) {
      Parent mainForm = null;
      try
      {
         mainForm = FXMLLoader.load(getClass().getResource("fullInfo.fxml"));
         InfoStage.setTitle("Full info");
         InfoStage.setScene(new Scene(mainForm, 600, 400));
         InfoStage.show();
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
