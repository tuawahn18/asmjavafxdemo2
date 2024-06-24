package org.example.demofx2.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import org.example.demofx2.Entity.Student;
import org.example.demofx2.Respository.StudentRespository;

public class StudentForm {

    public TextField studentName;
    public TextField studentPhone;
    public TextField studentEmail;
    public TextField studentCode;
    private StudentRespository studentRespository = new StudentRespository();
    public void doSomething(ActionEvent actionEvent) {
        // validate
        Student student = new Student();
        student.setCode(studentCode.getText());
        student.setEmail(studentEmail.getText());
        student.setPhone(studentPhone.getText());
        student.setFullName(studentName.getText());
        studentRespository.save(student);
        System.out.println("Success");
    }
}
