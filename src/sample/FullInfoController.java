package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

public class FullInfoController {
   @FXML
   ImageView photo;

   public void btnChoosePictureClick(ActionEvent actionEvent) {
      FileChooser fileChooser = new FileChooser();
      fileChooser.setTitle("Choose photo...");
      File file = fileChooser.showOpenDialog(MainController.InfoStage);

      Alert alert = new Alert(Alert.AlertType.INFORMATION, file.getAbsolutePath(), ButtonType.OK, ButtonType.CANCEL);
      alert.setTitle("Мы выбирали фотографию...");
      alert.setHeaderText("И наконец-то выбрали");
      alert.setContentText(file.getAbsolutePath());
      //alert.showAndWait();
      alert.show();

      Image image = new Image(file.toURI().toString());
      photo.setImage(image);
   }
}
