public class SingleLinkedList13 {
    Node13 head, tail;

    public boolean isEmpty() {
        return head == null;
    }


    void print() {
        if (isEmpty()) {
            System.out.println("Linked List kosong");
        } else {
            Node13 tmp = head;
            System.out.println("Isi Linked List : \t");
            while (tmp != null) {
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            }
            System.out.println("");
        }
    }
    


    void addFirst(int input) {
        Node13 ndInput = new Node13(input, null);
    
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }


    void addLast(int input) {
        Node13 ndInput = new Node13(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }


    public void insertAfter(int key, int input) {
        Node13 temp = head;
        while(temp != null) {
            if(temp.data == key) {
                Node13 ndInput = new Node13(input, temp.next);
                temp.next = ndInput;
                if(temp == tail) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        }
    }



    public void insertAt(int index, int input) {
        if(index < 0) {
            System.out.println("Index tidak valid!");
        } else if (index == 0) {
            addFirst(input);
        } else {
            Node13 temp = head;
            for(int i = 0; i < index - 1; i++) {
                if(temp.next == null) {
                    System.out.println("Indeks di luar batas!");
                    return;
                }
                temp = temp.next;
            }
            Node13 ndInput = new Node13(input, temp.next);
            temp.next = ndInput;
            if(ndInput.next == null) {
                tail = ndInput;
            }
        }
    }

    int getData(int index) {
        Node13 tmp = head;
        for (int i = 0; i < index && tmp != null; i++) {
            tmp = tmp.next;
        }
        if (tmp == null) {
            System.out.println("Index out of bounds.");
            return -1; 
        }
        return tmp.data;
    }

    int indexOf(int key){
        
        Node13 tmp = head;
        int index = 0;
        while(tmp != null && tmp.data != key){
            tmp = tmp.next;
            index++;
        }
        if(tmp == null){
            return -1;
        } else {
            return index;
        }
    }

    void removeFirst(){
        if(isEmpty()){
            System.out.println("Linked List masih kosong, tidak dapat dihapus");
        } else {
            if(head == tail){
                head = tail = null;
            } else {
                head = head.next;
            }
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong, tidak dapat dihapus");
        } else if (head == tail) {
            head = tail = null;
        } else {
            Node13 temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }


    void remove(int key){
        if(isEmpty()){
            System.out.println("Linked list masih kosong, tidak dapat dihapus");
        } else {
            Node13 temp = head;
            while(temp != null){
                if(temp.data == key && temp == head){
                    removeFirst();
                    break;
                } else if(temp.next.data == key){
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void removeAt(int index){
        if(index == 0){
            removeFirst();
        } else {
            Node13 temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if(temp.next == null){
                tail = temp;
            }
        }
    }
        

}
