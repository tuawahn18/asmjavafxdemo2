package org.example.demofx2.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import org.example.demofx2.Entity.Article;
import org.example.demofx2.Entity.Student;
import org.example.demofx2.Respository.ArticleRespository;
import org.example.demofx2.Respository.StudentRespository;

import java.net.URL;
import java.util.ResourceBundle;

public class DemoTableView implements Initializable {

    public TableView tableView;

//    private StudentRespository studentRepository = new StudentRespository();
    private ArticleRespository articleRespository = new ArticleRespository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Article> data = FXCollections.observableArrayList(articleRespository.findAll());
        tableView.setItems(data);
    }
}
