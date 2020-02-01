package wsg.oj.java.graph;

import java.util.Objects;

/**
 * @author Kingen
 */
public class Edge<V> {

    // 起点
    private V src;

    // 终点
    private V dest;

    // 权值
    private double weight;

    /**
     * 不带权值的一条边
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }

    /**
     * 带权值的一条边
     */
    public Edge(V src, V dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public V getSource() {
        return this.src;
    }

    public V getDest() {
        return this.dest;
    }

    public double getWeight() {
        return this.weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(src, edge.src) && Objects.equals(dest, edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dest);
    }
}
