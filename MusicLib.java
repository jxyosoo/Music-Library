/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.musiclib;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This program creates a library of songs allows the user to search 
 * for song titles in the library, and prints the contents of the song library in sorted order.
 * 
 * csc 1350-03 Lab 9
 *
 * @author jhaney3
 * @since 11/17/2023
 */
public class MusicLib {

    public static int InputIntAbove(String UserPrompt, int LowerBound){
        Scanner in = new Scanner(System.in);
        int value = 0;
        boolean haveGoodInput = false;
        
        while(!haveGoodInput){
            System.out.print(UserPrompt);
            if(!in.hasNextInt()){
                in.nextLine();
                System.out.println("Input value must be a whole number of at least 1.");
                continue;
            }
            value = in.nextInt();
            
            if(value > LowerBound){
                haveGoodInput = true;
            }
            else{
                in.nextLine();
                System.out.println("Input value must be at least " + LowerBound + ".");
            }
        }
       return value;
    }
    public static String InputStringValue(String UserPrompt){
        Scanner in = new Scanner(System.in);
        String inputVal = "";
        while(inputVal.equals("")){
            System.out.print(UserPrompt);
            inputVal = in.nextLine();
        
            if(inputVal.equals("")){
            System.out.println("A non-empty string must be entered.");
            System.out.println();
            }
        }
        return inputVal;
    }
    public static void PrintStringArray(String[] StringArray){
        for(String value : StringArray){
            System.out.println(value);
        }
    }
    public static int LinearSearchForString(String[] values, String searchVal){
        int position = 0;
        boolean found = false;
        
        while(!found && position < values.length){
            if(values[position].equals(searchVal)){
                found = true;
            }
            else{
                position++;
            }
        }
        if(!found){
           position = -1;
        }
        return position;
    }
    public static void main(String[]args){
        int numSongs;
        String[] library;
        String currentSong;
        String searchVal;
        int songPosition;
        
        Scanner in = new Scanner(System.in);
        
        numSongs = InputIntAbove("How many songs do you want to put in your library?", 1);
        library = new String[numSongs];
        
        for(int i = 0; i < numSongs; i++){
            System.out.println();
            currentSong = InputStringValue("Enter song title: ");
            library[i] = currentSong;
        }
        
        System.out.println();
        System.out.println("Enter a song title to search for or Q to quit: ");
        searchVal = in.nextLine();
        
        while(!searchVal.equals("Q")){
            songPosition = LinearSearchForString(library, searchVal);
            if(songPosition <  0){
                System.out.println(searchVal + " is not a song in the library.");
            }
            else{
                System.out.println(searchVal + " is in the library at position " + songPosition + ".");
            }
            System.out.println();
            System.out.println("Enter a song title to search for or Q to quit: ");
            searchVal = in.nextLine();
        }
        Arrays.sort(library);
        
        System.out.println();
        System.out.println("Music Library: ");
        PrintStringArray(library);
    }
}
