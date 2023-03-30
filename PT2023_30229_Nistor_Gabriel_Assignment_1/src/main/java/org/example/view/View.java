package org.example.view;

import org.example.model.Model;

import javax.swing.*;

public class View extends JFrame {
    Model model;
    GUI view;
    public View() {

    }
    public View(Model model) {
        this.model = model;

        view = new GUI();

        //this.pack(); modifica frameul astfel incat sa includa taote elementele
    }
    public GUI getView() {
        return view;
    }
}

