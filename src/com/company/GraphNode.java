package com.company;
import java.util.*;
import java.io.*;
public class GraphNode {
    GraphNode next;
    int data;
    GraphNode head;
    GraphNode(){
        data =0;
        next = null;
        head = null;
    }
    GraphNode(int data){
        this.data = data;
        next = null;
    }
}
