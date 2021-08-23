package cn.kobe;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] res = new int[N];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            list.add(new Node(i));
        }
        for (int i = 0; i < N; i++) {
            Node nodeA = list.get(edges[i][0]);
            Node nodeB = list.get(edges[i][1]);
            nodeA.link(nodeB);
        }
        Node root = list.get(0);
        root.traverse();//主要是remove功能
        root.initate();
        root.totalDistance = root.subDistance;
        root.calculateDistance(N);
        //保存结果
        for (int i = 0; i < N; i++) {
            res[i] = list.get(i).totalDistance;
        }
        return res;
    }

    class Node {
        int val;
        List<Node> nodes;//与该节点相连的节点
        int size;//子树节点数+该节点
        int subDistance;
        int totalDistance;

        public Node(int val) {
            this.val = val;
            this.nodes = new ArrayList<>();
            this.size = 1;
            this.subDistance = 0;
            this.totalDistance = 0;
        }

        public void link(Node newNode) {//连接节点，双向
            this.nodes.add(newNode);
            newNode.nodes.add(this);
        }

        //dfs遍历
        public void traverse() {
            for (Node ch : nodes) {
                ch.nodes.remove(this);//防止遍历回去
                ch.traverse();
            }
        }

        public void initate() {
            for (Node ch : nodes) {
                //由下而上计算
                ch.initate();
                this.size += ch.size;
                this.subDistance += ch.subDistance;
                this.subDistance += ch.size;
            }
        }

        public void calculateDistance(int N) {
            for (Node ch : nodes) {
                //这个公式。。。多理解
                ch.totalDistance = this.totalDistance + N - ch.size * 2;
                ch.calculateDistance(N);
            }
        }
    }
}
