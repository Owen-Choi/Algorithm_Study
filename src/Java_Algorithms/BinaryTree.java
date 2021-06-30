package Java_Algorithms;

import java.util.Comparator;

public class BinaryTree <K,V>{
    static class Node<K,V>{
        private K key;
        private V data;
        private Node<K,V> left;
        private Node<K,V> right;

        Node(K key,V data, Node<K,V> left, Node<K,V> right){
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey(){
            return this.key;
        }

        V getValue(){
            return this.data;
        }

        void print(){
            System.out.println(data);
        }
    }
    private Node<K,V> root;
    private Comparator<? super K> comparator = null;

    public BinaryTree(){
        root = null;
    }
    public BinaryTree(Comparator<? super K> c){
        this();                                     //디폴트 생성자 불러옴
        comparator = c;
    }

    private int comp(K key1, K key2){
        // # 디폴트 생성자로 생성했는지 comparator를 인자로 받는 생성자로 생성했는지 구분
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) :
                comparator.compare(key1, key2);
    }

    public V search(K key){
            Node<K,V> ptr = root;
            int temp;
            while(ptr != null){
                temp = comp(ptr.getKey(), key);
                // # ptr.key가 더 큰 경우
                if(temp > 0)
                    ptr = ptr.left;
                if(temp < 0)
                    ptr = ptr.right;
                if(temp == 0) {
                    System.out.println("Find");
                    return ptr.getValue();
                }
            }
            return null;
    }

    private void addNode(Node<K,V> node, K key, V data){        //여기서 node는 subtree
        int cond = comp(key, node.getKey());
        if(cond == 0)
            return;
        else if(cond < 0){
            if(node.left == null)
                node.left = new Node<K,V>(key, data, null, null);
            else
                addNode(node.left, key, data);                  //다시 node의 왼쪽 subtree를 재귀로 호출
        }
        else{
            if(node.right == null)
                node.right = new Node<K,V>(key, data, null, null);
            else
                addNode(node.right, key, data);
        }
    }

    public void add(K key, V data){
        if(root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);                           //루트부터 아래로 재귀 시작
    }

    public boolean remove(K key){
        Node<K,V>ptr = root;
        Node<K,V>parent = null;
        boolean isLeftChild = true;

        while(true){
            if(ptr == null)
                return false;
            int cond = comp(key, ptr.getKey());
            if(cond == 0)
                break;
            else {
                parent = ptr;
                if(cond < 0){
                    isLeftChild = true;
                    ptr = ptr.left;
                }
                else{
                    isLeftChild = false;
                    ptr = ptr.right;
                }
            }
        }
        // # 루프를 나왔다는 건 삭제할 값 위에 ptr이 있다는 뜻
        if(ptr.left == null){
            if(ptr == root){                                        //루트의 왼쪽이 비었다면 크기에 맞춰 다시 tree를 구성해줘야 함.
                ptr.right = ptr;
            }
            else if(isLeftChild) {                                  //ptr, 즉 현재 선택 노드가 부모의 왼쪽 자식이라면
                parent.left = ptr.right;
            }
            else{
                parent.right = ptr.right;
            }
        }
        else if(ptr.right == null){
            if(ptr == root){
                root = ptr.left;
            }
            else if(isLeftChild){
                parent.left = ptr.left;
            }
            else{
                parent.right = ptr.left;
            }
        }
        else {
            parent = ptr;
            Node<K,V>left = ptr.left;
            isLeftChild = true;
            while(left.right != null){                              //왼쪽 서브트리의 가장 큰 값에 도달할 때 까지
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            ptr.key = left.key;
            ptr.data = left.data;
            if(isLeftChild){
                parent.left = left.left;
            }
            else
                parent.right = left.left;
        }
        return true;
    }

    private void Print_SubTree(Node node){
        if(node != null){
            Print_SubTree(node.left);
            System.out.println(node.data);
            Print_SubTree(node.right);
        }
    }
    // test
    public void print(){
        Print_SubTree(root);
    }
}
