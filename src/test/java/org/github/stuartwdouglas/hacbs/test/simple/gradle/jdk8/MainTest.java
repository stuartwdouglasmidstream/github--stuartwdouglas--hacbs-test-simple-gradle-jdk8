package org.github.stuartwdouglas.hacbs.test.simple.gradle.jdk8;

import org.gradle.api.JavaVersion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testJavaVersion() {
        assertEquals(JavaVersion.VERSION_1_8, JavaVersion.current());
    }
}
