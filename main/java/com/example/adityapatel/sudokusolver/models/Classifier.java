package com.example.adityapatel.sudokusolver.models;

/**
 * Created by Shruti Patel on 8/22/2018.
 */

public interface Classifier {
    String name();

    Classification recognize(final float[] pixels);
}
