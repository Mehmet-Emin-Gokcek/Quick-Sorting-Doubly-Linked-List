public class person {
    public class Node {

        String name;
        Node next;
        Node prev;
        int age;


        public Node(String name, int age) {
            this.name = name;
            this.age = age;
            next = null;
            prev = null;
        }


    }

    Node head;
    Node tail;

    public void insertQ(String value, int data){ //inserting via queing, first in last out
        Node node = new Node(value, data);
        if(head == null) {
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void display(){
        Node currentNode = head;
        String heading1 = "Person Name";
        String heading2 = "Person Age";
        System.out.printf( "%-15s %15s %n", heading1, heading2);
        System.out.println( "-------------------------------");

        while(currentNode != null){
            System.out.printf( "%-15s %10s %n", currentNode.name, currentNode.age);
            currentNode = currentNode.next;
        }

        System.out.println( "-------------------------------");
        System.out.println();
        System.out.println();



        return;

    }



    public int findLenght(){
        int length = 0;
        Node temp = head;
        while(temp!= null) {
            temp = temp.next;
            length++;
        }

        return length;
    }

    public Node findNode(int position){
        Node found = null;
        Node temp = head;
        int counter  = 0;

        while(temp!= null) {
            counter++;

            if (position == counter) {
                found = temp;
            }

            temp = temp.next;
        }
        return found;
    }





    public  void quickSortLinkedList(){
        int listLength = findLenght();
        System.out.println("-------- Sorted List ---------");
            quickSortLinkedList(1, listLength);
        }

        public  void quickSortLinkedList(int left, int right){

            if (left >= right) { //exit condition applies when left index becomes equal or greater than the right index
                return;
            }
            int agePivot = findNode((left + right) / 2).age;

            int index = partition(left, right, agePivot);

            quickSortLinkedList(left, index - 1); //apply quicksort to the left side of the partition point
            quickSortLinkedList(index, right); //apply quicksort to the right side of the partition point

        }

        public int partition(int left, int right, int pivot){ //divides the mother array into smaller children arrays

            while (left <= right) { //while left index is smaller than right index, loop stops once left and right reaches the pivot and becomes equal


                while (findNode(left).age < pivot){  //move left index until an element bigger than pivot is found
                    left++;

                }

                while (findNode(right).age > pivot){  //move right index until an element smaller  than pivot is found
                    right--;
                }

                if(left <= right) { //if left index is smaller than the right index swap the values at those indexes
                    swap(left, right);
                    left++; // continue to the next left index
                    right--; //continue to the right index
                }

            }

            return left; //left is the partition point of the array
        }

        public  void swap(int left, int right){
            Node temp = new Node("temp", 0);

            temp.age = findNode(left).age;
            temp.name = findNode(left).name;


            findNode(left).age = findNode(right).age;
            findNode(left).name = findNode(right).name;


            findNode(right).age = temp.age;
            findNode(right).name = temp.name;


        }





    public static void main(String[] args) {
        Person nm = new Person();
        nm.insertQ("David", 30);
        nm.insertQ("Sam", 35);
        nm.insertQ("Betty", 20);
        nm.insertQ("Ali", 24);
        nm.insertQ("Jonh", 19);
        nm.insertQ("Mehmet ", 12);
        nm.insertQ("Fatih", 45);
        nm.insertQ("johnhy", 12);
        nm.insertQ("sam", 55);
        nm.insertQ("Helly", 26);
        nm.insertQ("Oliver", 55);

        nm.display();

        nm.quickSortLinkedList();
        nm.display();



    }

}




