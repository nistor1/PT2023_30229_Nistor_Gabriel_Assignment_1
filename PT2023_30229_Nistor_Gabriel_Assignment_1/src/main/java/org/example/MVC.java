package org.example;

import org.example.model.Model;
import org.example.controller.Controller;
import org.example.view.View;

public class MVC {
    public static void main(String[] args) {
        Model model       = new Model();
        View view        = new View(model);
        Controller controller  = new Controller(model, view);    }
}