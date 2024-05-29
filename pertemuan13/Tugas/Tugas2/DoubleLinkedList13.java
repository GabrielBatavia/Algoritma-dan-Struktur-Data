package Tugas.Tugas2;
public class DoubleLinkedList13 {
    Node13 head;
    int size;

    public DoubleLinkedList13() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int id, String title, double rating) {
        if (isEmpty()) {
            head = new Node13(id, title, rating, null, null);
        } else {
            Node13 newNode = new Node13(id, title, rating, null, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int id, String title, double rating) {
        if (isEmpty()) {
            addFirst(id, title, rating);
        } else {
            Node13 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node13 newNode = new Node13(id, title, rating, current, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int id, String title, double rating, int index) {
        if (index < 0 || index > size) {
            System.out.println("Nilai indeks di luar batas");
            return;
        } else if (isEmpty() || index == 0) {
            addFirst(id, title, rating);
        } else {
            Node13 current = head;
            int i = 0;
            while (i < index && current.next != null) {
                current = current.next;
                i++;
            }
            if (i == index) {
                Node13 newNode = new Node13(id, title, rating, current.prev, current);
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
                if (index == 0) {
                    head = newNode;
                }
                size++;
            } else {
                addLast(id, title, rating);
            }
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            head = null;
            size--;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node13 current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
            size--;
        }
    }

    public void remove(int index) {
        if (isEmpty() || index >= size) {
            System.out.println("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node13 current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current.next.prev = null;
                head = current.next;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public Node13 searchById(int id) {
        Node13 current = head;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void sortDescendingByRating() {
        if (size > 1) {
            boolean wasChanged;
            do {
                Node13 current = head;
                Node13 previous = null;
                Node13 next = head.next;
                wasChanged = false;
                while (next != null) {
                    if (current.rating < next.rating) {
                        wasChanged = true;
                        if (previous != null) {
                            Node13 sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node13 sig = next.next;
                            head = next;
                            next.next = current;
                            current.next = sig;
                        }
                        Node13 temp = current;
                        current = next;
                        next = temp;
                    }
                    previous = current;
                    current = next;
                    next = next.next;
                }
            } while (wasChanged);
        }
    }

    public void print() {
        if (!isEmpty()) {
            Node13 tmp = head;
            System.out.println("+-------------------------------------+");
            System.out.println("Daftar Film Layar Lebar");
            System.out.println("+-------------------------------------+");
            System.out.println("|ID\t|Judul\t|Rating");
            System.out.println("+-------------------------------------+");
            while (tmp != null) {
                System.out.println("|" + tmp.id + "\t|" + tmp.title + "\t|" + tmp.rating);
                tmp = tmp.next;
            }
            System.out.println("+-------------------------------------+");
        } else {
            System.out.println("Linked List Kosong");
        }
    }
}
