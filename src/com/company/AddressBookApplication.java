package com.company;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Ryan Johnson
 */
public class AddressBookApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AddressBook ab = new AddressBook();
        Menu menu = new Menu();
        menu.menuLoop(ab);
        //String file = "C:\\Users\\The_r\\OneDrive\\Desktop\\ImportantStuff\\AddressInputDataFile.txt";
        //init(file);
        //initAddressBookExercise(ab);
    }

    /**

    @param ab the addressbook used to input entries.
*/
    public static void initAddressBookExercise(AddressBook ab)
    {
        AddressEntry ae1 = new AddressEntry("A", "B", "C", "D", "E", 0, "F", "G");
        AddressEntry ae2 = new AddressEntry("H", "I", "J", "K", "L", 1, "O", "P");

        ab.add(ae1);
        ab.add(ae2);

        ab.list();
    }

    /**

    @param filename the name of the file
*/
    public static void init(String filename)
    {
        AddressBook ab = new AddressBook();
        ArrayList<String> al = new ArrayList<String>();
        try
        {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                al.add(myReader.nextLine());
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(int i = 0; i < al.size()-7; i += 8)
        {
            AddressEntry ae = new AddressEntry(al.get(i), al.get(i+1), al.get(i+2), al.get(i+3), al.get(i+4), Integer.parseInt(al.get(i+5)), al.get(i+6), al.get(i+7));
            ab.add(ae);
        }

        ab.list();
    }
}
