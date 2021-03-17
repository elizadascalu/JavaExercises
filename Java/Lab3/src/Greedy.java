class Greedy
{
    private TravelMap map;
    private int V;

    public Greedy(TravelMap map){
        this.map = map;
        this.V = map.getNrOfNodes();
    }

    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void dijkstra(Node start, Node end) {

        int graph[][] = this.map.toGraph();
        int src = this.map.getNodes().indexOf(start);
        int ending = this.map.getNodes().indexOf(end);
        int dist[] = new int[V]; // vector de distante

        for(int nodei=0;nodei<V;nodei++) {
            src=nodei;
            // sptSet[i] true if node i takes part of the shortest path
            Boolean sptSet[] = new Boolean[V];

            // Initializare distante si sptSet
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i] = false;
            }

            dist[src] = 0;

            // Calculam distantele pentru toate nodurile
            for (int count = 0; count < V - 1; count++) {
                int u = minDistance(dist, sptSet);

                // setam nodul pentru procesare
                sptSet[u] = true;

                //Actualizam distante pentru nodurile adiacente
                for (int v = 0; v < V; v++) {
                    // Actualizam distanta doar daca nu gasim o muchie de la u la v si distanta gasita este mai scurta decat cea veche
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
                }
            }

            for (int i = 0; i < V; i++) {
                if(src != i)
                    if(dist[i]!=Integer.MAX_VALUE)
                        System.out.println("Dist: "+ map.getNodes().get(src).getName() + " - " + map.getNodes().get(i).getName() + " = " + dist[i]);
                    //else
                    //    System.out.println("No edge between: " + map.getNodes().get(src).getName() + " and " + map.getNodes().get(i).getName());
            }
        }

    }
}