public class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertFront(Node newNode){
        // في حالة عدم وجود اي عنصر
        if (this.head==null){
            // خليت النود الجديدة هي الهيد و التيل مع بعض
            head = tail = newNode;
        }
        //في حالة وجود عناصر
        else{
            // هخلي الاتنين يشاوروا علي بعض
            newNode.next=head;
            head.prev=newNode;
            // خليت النود الجديدة هي الهيد
            head=newNode;
            // خليت الهيد قبلها null عشان دي مش ليست دائرية circle
            head.prev=null;
        }
    }



    
}
