package com.example.adityapatel.sudokusolver;

import android.util.Log;

import java.util.ArrayList;

public class cell {
    private int input_value;
    private char type;
    private ArrayList<Integer> options = new ArrayList<Integer>();
    private int Size;

    public cell(){
        type = 'u';
        input_value =0;
        for(int i =1; i<10; i++)
            options.add(i);
        Size = options.size();

    }
    public void setInput_Value(int value){
        input_value = value;
        type = 'c';
        if(Size !=0) {
            options.clear();
            Size=options.size();
        }
    }
    public void eraseInput_Value(){
        type = 'u';
        input_value =0;
        options.clear();
        for(int i =1; i<10; i++)
            options.add(i);
        Size = options.size();
    }

    public void addOption(int possibleValue){
        options.add(possibleValue);
        Size = options.size();
    }
    public void removeOption (int notPossibleValue){
        int location=0;
        boolean found = false;
        if(Size>0) {
            for(int i=0; i<Size; i++){
                if (options.get(i)==notPossibleValue){
                    found = true;
                    location = i;
                }
            }
            //Log.d("sudokusolver", "found " + options.get(i));
            if (found) {
                options.remove(location);
                //Log.d("sudokusolver", "removed");
            }
        }

        Size = options.size();
    }
    public void printAllOptions(){

        for (int i = 0; i< Size; i++)
            Log.d("sudokusolver", options.get(i)+" ");
        if(Size==0)
            Log.d("sudokusolver", "Already Completed");
    }

    public void clearOptions(){
        if(Size !=0) {
            options.clear();
            Size = 0;
        }
    }

    public boolean isOption(int value){
        boolean found = false;
        if(Size>0) {
            for(int i=0; i<Size; i++){
                if (options.get(i)==value){
                    found = true;
                }
            }
        }
        return(found);
    }

    public int getInput_value(){
        if(type=='c')
            return (input_value);
        else
            return(0);
    }
    public int getSize(){
        return(options.size());
    }
    public void completeSingle(){ //FOR SOME REASON WHEN 9 IS THE LAST SINGLE OPTION, IT WONT CONFIRM IT
        if(Size==1){
            setInput_Value(options.get(0));
        }
    }
}
