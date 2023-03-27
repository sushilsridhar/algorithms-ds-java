package ds.hashtable;

class HashMap {

    int size = 500;
    private Node[] map = new Node[size];

    class Node {
        int hash;
        int key;
        int val;
        Node next;

        public Node(int hash, int key, int val, Node next) {
            this.hash = hash;
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public HashMap() {

    }

    private int hashing(int key) {
        return key % size;
    }


    public void put(int key, int val) {

        int hash = hashing(key);
        Node startNode = map[hash];
        Node newNode = new Node(hash, key, val, null);

        if(startNode == null) {
            map[hash] = newNode;
        } else {
            Node prevNode = startNode;
            boolean isValUpdated = false;

            while(startNode != null) {
                if(startNode.key == key) {
                    startNode.val = val;
                    isValUpdated = true;
                    break;
                }
                prevNode = startNode;
                startNode = startNode.next;
            }

            if(!isValUpdated)
                prevNode.next = newNode;
        }
    }

    public int get(int key) {
        int hash = hashing(key);

        Node startNode = map[hash];

        while(startNode != null) {
            if(startNode.key == key) {
                return startNode.val;
            }
            startNode = startNode.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hashing(key);

        Node startNode = map[hash];

        Node prevNode = startNode;

        if(startNode != null) {
            if(startNode.key == key) {
                map[hash] = prevNode.next;
            } else {
                while(startNode != null) {

                    if(startNode.key == key) {
                        break;
                    }

                    prevNode = startNode;
                    startNode = startNode.next;
                }

                if(startNode != null)
                    prevNode.next = startNode.next;
            }
        }
    }

    public boolean contains(int key) {
        int hash = hashing(key);

        Node startNode = map[hash];

        while(startNode != null) {
            if(startNode.key == key) {
                return true;
            }
            startNode = startNode.next;
        }

        return false;
    }
}


