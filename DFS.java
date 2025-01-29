import java.util.*;

public class DFS {
    public static void addUndirectedEdge(List<List<Integer>> adj, int s, int t)
    {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }
    public static void print(List<List<Integer>> adj, int v)
    {
        for(int i=0;i<v;i++)
        {
            System.out.print("Vertex "+i+" is connected to: ");
            for(int x:adj.get(i))
            System.out.print(x+" , ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int i,v,e,s,t;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        v=sc.nextInt();

        List<List<Integer> > adj=new ArrayList(v);
        for(i=0;i<v;i++)
        adj.add(new ArrayList<>());

        System.out.print("Enter the number of edges(e)= ?");
        e=sc.nextInt();

        System.out.println("Enter the edges ");
        for(i=0;i<e;i++)
        {
        s=sc.nextInt();
        t=sc.nextInt();
        addUndirectedEdge(adj, s, t);
        }

        print(adj,v);

        boolean[] visited=new boolean[v+1];

        

        //call dfs on (adj,visited,source)

        System.out.println("Enter source vertex ");
        int source=sc.nextInt();
        System.out.println("Depth first search traversal from source "+source+" is ::: ");

        dfs(adj,visited,source);

    }
    public static void dfs(List<List<Integer>> adj,boolean[] visited,int source)
    {
        visited[source]=true;
        System.out.print(source+" ");

        //check for it's neighbours

        for(int i:adj.get(source))
        {
            if(visited[i]==false)
            {
                dfs(adj,visited,i);   //recursive so goes in depth
            }
        }
    }
}
