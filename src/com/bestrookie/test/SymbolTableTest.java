package com.bestrookie.test;

import com.bestrookie.symbol.SymbolTable;

/**
 * @author bestrookie
 * @date 2022/5/12 17:10
 */
public class SymbolTableTest {
    public static void main(String[] args) {
        SymbolTable<Integer, String> table = new SymbolTable<>();
        table.put(1,"a");
        table.put(2,"b");
        table.put(3,"c");
        table.remove(2);
        System.out.println(table.get(1));
    }
}
