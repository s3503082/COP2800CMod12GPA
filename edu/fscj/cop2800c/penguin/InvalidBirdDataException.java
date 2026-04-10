// InvalidBirdDataException.java
// J. Washington
// 04/09/26
// Custom exception for Palmer Penguin data

package edu.fscj.cop2800c.penguin;

public class InvalidBirdDataException extends Exception {
    public InvalidBirdDataException(String message) {
        super(message);
    }
}
