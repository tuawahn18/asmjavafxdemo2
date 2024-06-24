package org.example.demofx2.Respository;

import org.example.demofx2.Entity.Article;
import org.example.demofx2.Entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class ArticleRespository {
    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/article_fx";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    public void save(Article obj){
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String strSql = "insert into articledemofx (title, description, content) values (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, obj.getTitle());
            preparedStatement.setString(2, obj.getDescription());
            preparedStatement.setString(3, obj.getContent());
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Article> findAll(){
        ArrayList<Article> articles = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD);
            String prSql = "select * from articledemofx";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String content = resultSet.getString("content");
                Article obj = new Article();
                obj.setTitle(title);
                obj.setDescription(description);
                obj.setContent(content);
                articles.add(obj);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public static void main(String[] args) {
        ArticleRespository articleRepository = new ArticleRespository();
        Article article = new Article();
        article.setTitle("Title");
        article.setDescription("Description");
        article.setContent("content");
        articleRepository.save(article);
        System.out.println("Okie");
    }
}