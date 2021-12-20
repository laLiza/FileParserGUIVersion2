package GUI;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;




import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;



public class FileParserGUI extends Application {

    private Desktop desktop = Desktop.getDesktop();

    @Override
    public void start(Stage primaryStage) throws Exception {

        final FileChooser fileChooser = new FileChooser();

        TextArea textArea = new TextArea();
        textArea.setMinHeight(70);

        Button button1 = new Button("Select One File and Open");

        Button button2 = new Button("Start it !");
        //Button button4 = new Button("Start ixkkt !");

        button1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.clear();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try {
                        openFile(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    List<File> files = Arrays.asList(file);
                    printLog(textArea, files);
                }
            }
        });
        Button saveButton = new Button("save");

        //Creating a File chooser
        FileChooser fileChooser1 = new FileChooser();
        fileChooser1.setTitle("Save");
        fileChooser1.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //Opening a dialog box
                fileChooser.showSaveDialog(primaryStage);
            }
        });

            VBox root = new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(5);

        root.getChildren().addAll(textArea, button1, button2, saveButton);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("JavaFX FileChooser (o7planning.org)");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(FileParserGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void printLog(TextArea textArea, List<File> files) {
        if (files == null || files.isEmpty()) {
            return;
        }
        for (File file : files) {
            textArea.appendText(file.getAbsolutePath() + "\n");
        }
    }

    private void openFile(File file) throws Exception {
            FileEngine FEnginer = new FileEngine();
            FEnginer.FolderControl();
            FEnginer.ProcessFile(file.getAbsolutePath());

        }

    public static void main(String[] args) {
        Application.launch(args);
    }
    

}