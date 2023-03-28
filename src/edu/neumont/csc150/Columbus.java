package edu.neumont.csc150;

import edu.neumont.csc150.controller.ZedGenerator;

import java.io.IOException;

public class Columbus {
    public static void main(String[] args) throws IOException {
        ZedGenerator controller = new ZedGenerator();
        controller.run();
    }
}
