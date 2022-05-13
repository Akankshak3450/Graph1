package com.company;
import java.util.*;
public class Graph {
    Scanner sc = new Scanner(System.in);
    int houses,lanes;
    int[][] admatrix;
    GraphNode[] head;

    public Graph(int houses,int lanes) {
        this.houses = houses;
        this.lanes=lanes;
        this.admatrix = new int[houses][houses];
    }
    public void addEdge() {
        int source,destination;
        System.out.println("Enter the no. of houses(vertices) :--");
        houses=sc.nextInt();
        System.out.println("Enter the no. of lanes(edges) :--");
        lanes=sc.nextInt();
        for(int i=0;i<lanes;i++) {
            System.out.println("Enter the start of lane :--");
            source =sc.nextInt();
            System.out.println("Enter the end of lane :--");
            destination =sc.nextInt();
            admatrix[source][destination]=1;
            admatrix[destination][source]=1;
        }
    }
    public void printGraph() {
        System.out.println("Adjacency Matrix-------");
        for (int i = 0; i < houses; i++) {
            for (int j = 0; j <houses ; j++) {
                System.out.print(admatrix[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i <houses; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <houses ; j++) {
                if(admatrix[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
    void createUsingAdjList()
    {
        int start,end;
        System.out.print("Enter the number of houses(vertices):--");
        houses=sc.nextInt();
        System.out.print("Enter the number of lanes(edges):--");
        lanes=sc.nextInt();
        head=new GraphNode[houses];
        System.out.println("\nEnter house number for every lane:--");
        for(int i=0;i<lanes;i++) {
            System.out.print("Enter the starting house(start vertex):--");
            start=sc.nextInt();
            System.out.print("Enter the ending house(ending vertex):--");
            end=sc.nextInt();
            insert(start,end);
            insert(end,start);
        }
    }

    void insert(int v1,int v2) {
        GraphNode newnode=new GraphNode(v2);
        if(head[v1]==null)
            head[v1]=newnode;
        else
        {
            GraphNode ptr=head[v1];
            while(ptr.next!=null) {
                ptr = ptr.next;
            }
            ptr.next=newnode;
        }
    }
    public void displayAdjList() {
        System.out.println("Adjacency list: ---------");
        for(int i=0;i<houses;i++) {
            if(head[i]==null)
                System.out.println(i);
            else {
                GraphNode ptr=head[i];
                System.out.print(i);
                while(ptr!=null) {
                    System.out.print("--> "+ptr.data);
                    ptr=ptr.next;
                }
                System.out.println();
            }
        }
    }

    void DFS() //Using Stack
    {
        int start=0,flag=0,unvisited_h=0;
        Stack<Integer> s = new Stack<Integer>();
        boolean visited[]= new boolean[houses];
        System.out.println("Enter a starting house (to start traversal from):--");
        start=sc.nextInt();
        System.out.println("Depth First Search is as follows:--");
        s.add(start);
        visited[start]=true;
        System.out.print(start+" ");
        while(!s.isEmpty())
        {
            int v=s.peek();
            flag=0;
            unvisited_h=-1;
            for(int i=0;i<houses;i++)
            {
                if(admatrix[v][i]==1 && !visited[i])
                {
                    flag=1;
                    unvisited_h=i;
                }
            }
            if(flag==1)
            {
                visited[unvisited_h]=true;
                System.out.print(unvisited_h+" ");
                s.add(unvisited_h);
            }
            else
                s.pop();
        }System.out.println("\n");
    }
    public void BFS() { // using Queue AdjList
        int s;
        boolean visited[] = new boolean[houses+1];
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.println("Enter a starting house:--");
        s=sc.nextInt();
        System.out.println("Breadth First Search is as follows:--");
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty()) {
            s=q.poll();
            System.out.print(s+" ");
            GraphNode ptr=head[s];
            while(ptr!=null) {
                if(!visited[ptr.data]){
                    visited[ptr.data]=true;
                    q.add(ptr.data);
                }
                ptr=ptr.next;
            }
        }System.out.println("\n");
    }
}
