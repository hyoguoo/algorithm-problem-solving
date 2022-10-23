package DataStructure.Tree;

import java.util.*;

public class BinaryTree implements Tree {
    public Node root;
    int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            this.size++;
        } else {
            Node currentNode = root;
            while (true) {
                int currentData = currentNode.getData();
                if (currentData > data) {
                    Node leftNode = currentNode.getLeft();
                    if (leftNode == null) {
                        currentNode.setLeft(new Node(data));
                        this.size++;
                        break;
                    } else {
                        currentNode = leftNode;
                    }
                } else {
                    Node rightNode = currentNode.getRight();
                    if (rightNode == null) {
                        currentNode.setRight(new Node(data));
                        this.size++;
                        break;
                    } else {
                        currentNode = rightNode;
                    }
                }
            }
        }
    }

    @Override
    public boolean delete(int data) {
        Node removedNode = this.root;
        Node parentNode = null;

        while (removedNode.getData() != data) {
            parentNode = removedNode;
            if (removedNode.getData() > data) {
                removedNode = removedNode.getLeft();
            } else {
                removedNode = removedNode.getRight();
            }
            if (removedNode == null) return false;
        }

        Node removedLeftNode = removedNode.getLeft();
        Node removedRightNode = removedNode.getRight();
        if (removedLeftNode == null && removedRightNode == null) {
            linkNode(removedNode, null, parentNode);
        } else if (removedLeftNode == null) {
            linkNode(removedNode, removedRightNode, parentNode);
        } else if (removedRightNode == null) {
            linkNode(removedNode, removedLeftNode, parentNode);
        } else {
            Node replaceNode = removedLeftNode;
            Node parentOfReplaceNode = removedNode;

            while (replaceNode.getRight() != null) {
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.getRight();
            }

            if (replaceNode.getLeft() != null) {
                linkNode(replaceNode, replaceNode.getLeft(), parentOfReplaceNode);
            }

            linkNode(removedNode, replaceNode, parentNode);
            if (removedLeftNode != replaceNode) replaceNode.setLeft(removedLeftNode);
            if (removedRightNode != replaceNode) replaceNode.setRight(removedRightNode);
        }
        return true;
    }

    private void linkNode(Node removeNode, Node linkNode, Node parentNode) {
        if (removeNode == this.root) {
            this.root = linkNode;
        } else if (parentNode.getRight() == removeNode) {
            parentNode.setRight(linkNode);
        } else {
            parentNode.setLeft(linkNode);
        }
    }

    @Override
    public Node find(int data) {
        Node currentNode = this.root;

        while (true) {
            if (currentNode == null) return null;

            int currentData = currentNode.getData();
            if (currentData == data) {
                return currentNode;
            } else if (currentData > data) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
    }

    @Override
    public List<Integer> bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode != null) {
                result.add(currentNode.getData());

                if (currentNode.getLeft() != null) {
                    queue.offer(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.offer(currentNode.getRight());
                }
            }
        }

        return result;
    }

    @Override
    public List<Integer> dfs() {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        stack.push(this.root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode.getRight() != null) {
                stack.push(currentNode.getRight());
            }
            if (currentNode.getLeft() != null) {
                stack.push(currentNode.getLeft());
            }
            result.add(currentNode.getData());
        }

        return result;
    }

    private void printData(int data, int depth) {
        for (int i = 0; i < depth; i++) System.out.print("└ ");
        System.out.println(data);
    }

    @Override
    public void preorder(Node node, int depth) {
        if (node != null) {
            this.printData(node.getData(), depth);
            this.preorder(node.getLeft(), depth + 1);
            this.preorder(node.getRight(), depth + 1);
        }
    }

    @Override
    public void inorder(Node node, int depth) {
        if (node != null) {
            this.inorder(node.getLeft(), depth + 1);
            this.printData(node.getData(), depth);
            this.inorder(node.getRight(), depth + 1);
        }
    }

    @Override
    public void postorder(Node node, int depth) {
        if (node != null) {
            this.postorder(node.getLeft(), depth + 1);
            this.postorder(node.getRight(), depth + 1);
            this.printData(node.getData(), depth);
        }
    }
}
