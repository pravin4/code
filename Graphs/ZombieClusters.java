package Graphs;

public class ZombieClusters {
	
	public static void main(String[] args) {
        String[] zombies = new String[4];
        zombies[0] = "1100";
        zombies[1] = "1110";
        zombies[2] = "0110";
        zombies[3] = "0001";
        
        System.out.println(zombieCluster(zombies));
	}
 	
    // Complete the zombieCluster function below.
    static int zombieCluster(String[] zombies) {
        boolean[] visited = new boolean[zombies.length];
        int numClusters = 0;
        
        // here go over the zombies string array and do a dfs
        for (int i = 0; i < zombies.length; i++) {
            if (!visited[i]) {
                dfs(zombies, i, visited);
                numClusters++;
            }
        }
        
        return numClusters;
    }

    static void dfs(String[] zombies, int zombie, boolean[] visited) {
        visited[zombie] = true;
        
        for (int i = 0; i < zombies.length; i++) {
        	// only do another search if not visited and the zombie is clustered with another
        	// this is given in our adjacency matrix input above
            if (!visited[i] && zombies[zombie].charAt(i) == '1') {
                dfs(zombies, i, visited);
            }
        }
    }

}
