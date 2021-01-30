package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;

public class Main extends Application {

    VBox mainBox;
    HBox topBox;
    HBox bottomBox;
    HBox middleBox;


    Button EncryptingButton;
    Button DecryptingButton;


    TextField PlainText = new TextField();
    TextField CipherText = new TextField();
    TextField CipherKey = new TextField();

    Label PlainTextLabel = new Label("Plain/Cipher Text:");
    Label CipherTextLabel = new Label("Output Text:");
    Label CipherKeyLabel = new Label("Cipher Key:");


    @Override
    public void start(Stage primaryStage) throws Exception {
//******************************* Window GUI ****************************************
        Stage window = primaryStage;
        window.setTitle("AES Cipher");
        window.setMinWidth(880);
        window.setMinHeight(200);

        mainBox = new VBox(10);
        mainBox.setPadding(new Insets(10, 10, 10, 10));
        topBox = new HBox(50);
        topBox.setPadding(new Insets(10, 10, 10, 10));
        bottomBox = new HBox(75);
        bottomBox.setPadding(new Insets(10, 10, 10, 10));
        middleBox = new HBox(50);
        middleBox.setPadding(new Insets(10, 10, 10, 10));

        PlainTextLabel.setPadding(new Insets(10, 10, 10, 10));
        CipherTextLabel.setPadding(new Insets(10, 10, 10, 10));
        CipherKeyLabel.setPadding(new Insets(10, 10, 10, 10));

        PlainText.setPromptText("Write Input Text Here...");
        CipherKey.setPromptText("Write Cipher Key Here...");
        CipherText.setPromptText("Output Shows Here...");

        PlainText.setMinWidth(450);
        CipherKey.setMinWidth(450);
        CipherText.setMinWidth(450);

        CipherText.setEditable(false);

        EncryptingButton = new Button("Encrypt");
        DecryptingButton = new Button("Decrypt");



//**************************** Handling Requests **************************************

        EncryptingButton.setOnAction(e -> {
            AES test = new AES();
            String word = PlainText.getText();
            int [][] keys = test.keyExpansion(CipherKey.getText());
            CipherText.setText(test.Encrypt(word,keys).toUpperCase(Locale.ROOT));
        });
        DecryptingButton.setOnAction(e -> {
            AES test = new AES();
            String word = PlainText.getText();
            int [][] keys = test.keyExpansion(CipherKey.getText());
            CipherText.setText(test.Decrypt(word,keys).toUpperCase(Locale.ROOT));
        });


//**************************** Scene Building ***************************************
        mainBox.getChildren().addAll(topBox, middleBox, bottomBox);
        topBox.getChildren().addAll(PlainTextLabel,PlainText);
        middleBox.getChildren().addAll(CipherKeyLabel,CipherKey);
        bottomBox.getChildren().addAll(CipherTextLabel,CipherText,EncryptingButton,DecryptingButton);
        Scene scene = new Scene(mainBox);
        window.setScene(scene);
        window.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
