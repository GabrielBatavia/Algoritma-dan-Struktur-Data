package Tugas.Tugas2;
public class Node13 {
    int id;
    String title;
    double rating;
    Node13 prev;
    Node13 next;

    public Node13(int id, String title, double rating, Node13 prev, Node13 next) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.prev = prev;
        this.next = next;
    }
}
