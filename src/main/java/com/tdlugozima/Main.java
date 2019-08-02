package com.tdlugozima;

import com.tdlugozima.domain.IndexedTextStructure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in, "UTF-8");
        while (true) {
            System.out.print("enter string to index > ");
            String inputLine = keyboard.nextLine();

            if (inputLine.equals(":quit")) break;

            System.out.println(String.format("Input: %s", inputLine));
            IndexedTextStructure indexedStructure = new IndexedTextStructure(TextIndexer.indexContent(inputLine));
            System.out.println(String.format("Output:\n%s", indexedStructure));
        }
    }
}
