package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); // загрузка xml, разметка для нашего визуального проекта
        primaryStage.setTitle("Калькулятор"); // имя окна(сцена)
        primaryStage.setScene(new Scene(root, 450, 450)); // размеры окна
        primaryStage.show();  // отобразить окно
    }


    public static void main(String[] args) {
        launch(args);
    }
}
