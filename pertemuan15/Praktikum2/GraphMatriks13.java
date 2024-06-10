import java.util.ArrayList;

public class GraphMatriks13 {
    int vertex;
    int[][] matriks;
    ArrayList<Integer>[] list;

    public GraphMatriks13(int v) {
        vertex = v;
        matriks = new int[v][v];
        list = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
        list[asal].add(tujuan);
    }

    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = -1;
        list[asal].remove((Integer) tujuan);
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Gedung " + (char) ('A' + i) + ": ");
            for (int j = 0; j < vertex; j++) {
                if (matriks[i][j] > 0) {
                    System.out.print("Gedung " + (char) ('A' + j) + " (" + matriks[i][j] + " m), ");
                }
            }
            System.out.println();
        }
    }


    public void degree(int asal) {
        System.out.println("Degree of vertex " + (char) ('A' + asal) + " is: " + list[asal].size());
    }

    public boolean isConnected(int asal, int tujuan) {
        return matriks[asal][tujuan] > 0;
    }
}
