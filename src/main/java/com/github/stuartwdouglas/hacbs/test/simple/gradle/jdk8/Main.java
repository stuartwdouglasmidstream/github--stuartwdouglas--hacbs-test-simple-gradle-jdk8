package com.github.stuartwdouglas.hacbs.test.simple.gradle.jdk8;

import org.gradle.api.JavaVersion;

/**
 * The main class.
 */
public class Main {
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.out.println(JavaVersion.current());
    }
}
