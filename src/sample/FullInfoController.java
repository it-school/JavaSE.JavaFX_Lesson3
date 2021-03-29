package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Paths;

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
      alert.showAndWait();
      //alert.show();

      Image image = new Image(file.toURI().toString());
      photo.setImage(image);


      alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Current project is modified");
      alert.setHeaderText(photo.getImage().getUrl());
      alert.setContentText("Save?");
      ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
      ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
      ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
      alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
      alert.showAndWait().ifPresent(type -> {
         String path = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator;
         if (type == ButtonType.OK) {
            path += "yes.png";
         } else if (type == ButtonType.NO) {
            path += "no.png";
         } else {
            path += "cancel.png";
         }
         System.out.println(path);
         photo.setImage(new Image(path));
      });

   }
}
