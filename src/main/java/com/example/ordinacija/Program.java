package com.example.ordinacija;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Program extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("intro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("EL PASO BRACES - bringing teeth together!");
        stage.setScene(scene);
        Image image = new Image("C:\\Users\\Lucija\\Desktop\\ordinacija\\src\\main\\resources\\icons\\icon.png");
        stage.getIcons().add(image);
        stage.show();

    }

    public static void swapScene(Stage stage, String viewName, String title){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setTitle(title);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nastala je pogreška!" + e.getMessage());
        }
    }


    public static void display (String viewName, String viewTitle) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(Program.class.getResource(viewName));
        Stage newWindow = new Stage();
        Scene newScene = new Scene(fxmlLoader.load(), 800, 600);
        Image image = new Image("C:\\Users\\Lucija\\Desktop\\ordinacija\\src\\main\\resources\\icons\\icon.png");
        newWindow.getIcons().add(image);
        newWindow.setScene(newScene);
        newWindow.setTitle(viewTitle);
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.show();
    }


    public static void alertDisplay (String viewName, String viewTitle) throws IOException {
        FXMLLoader fxmlLoader3 = new FXMLLoader(Program.class.getResource(viewName));
        Stage newWindow2 = new Stage();
        Scene newScene2 = new Scene(fxmlLoader3.load(), 350, 200);
        Image image = new Image("C:\\Users\\Lucija\\Desktop\\ordinacija\\src\\main\\resources\\icons\\icon.png");
        newWindow2.getIcons().add(image);
        newWindow2.setScene(newScene2);
        newWindow2.setTitle(viewTitle);
        newWindow2.initModality(Modality.APPLICATION_MODAL);
        newWindow2.show();

    }


    public static void main(String[] args) {
        launch();
    }
}