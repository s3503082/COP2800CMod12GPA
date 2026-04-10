// DataWrapper.java
// JaTavion Washington
// 04/09/2026
// Handling code to incorporate a generic class

package edu.fscj.cop2800c.util;

import java.util.List;

public class DataWrapper<T> {
    private T value;

    public DataWrapper() {
        value = null;
    }

    public DataWrapper(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static <T> void displayList(List<DataWrapper<T>> list) {
        for (DataWrapper<T> element : list) {
            System.out.println(element.getValue());
        }
    }
}