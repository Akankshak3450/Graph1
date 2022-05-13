package com.company;
import java.util.*;
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int ch =0;
        System.out.println("-----------------Welcome------------------");
         Graph g = new Graph(20,20);
         do{
             System.out.println("1)Create graph using adjacency matrix\n2)Display graph using adjacency matrix\n3)Create graph using adjacency list\n4)Display using adjacency list");
             System.out.println("5)Print DFS\n6)Print BFS\n-----------------------------------\nEnter your choice : ");
             ch = sc.nextInt();
             switch(ch){
                 case 1:
                     g.addEdge();
                     break;
                 case 2:
                     g.printGraph();
                     break;
                 case 3:
                     g.createUsingAdjList();
                     break;
                 case 4:
                     g.displayAdjList();
                     break;
                 case 5:
                     g.DFS();
                     break;
                 case 6:
                     g.BFS();
                     break;
             }
         }while(ch !=0);
    }
}
