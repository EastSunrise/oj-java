package cn.wsg.oj.graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * 邻接链表（Adjacency List）实现的有向图
 *
 * @author Kingen
 */
public class ListDGraph<V> implements DGraph<V> {

    // 顶点列表，由于会经常进行插入删除，使用链表队列
    private final Set<Vertex> mVertexSet;

    public ListDGraph() {
        mVertexSet = new HashSet<>();
    }

    @Override
    public boolean add(V v) {
        if (v != null) {
            return mVertexSet.add(new Vertex(v));
        }
        return false;
    }

    @Override
    public boolean add(Edge<V> e) {
        if (e != null) {
            Vertex vertex = getVertex(e.getSource());
            if (vertex != null) {
                if (vertex.addEdge(e)) {
                    mVertexSet.add(new Vertex(e.getDest()));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(V v) {
        if (mVertexSet.remove(new Vertex(v))) {
            if (v != null) {
                for (Vertex vertex : mVertexSet) {
                    vertex.removeEdge(v);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Edge<V> e) {
        if (e != null) {
            Vertex vertex = getVertex(e.getSource());
            if (vertex != null) {
                return vertex.removeEdge(e.getDest());
            }
        }
        return false;
    }

    @Override
    public Set<Edge<V>> getEdges(V src) {
        if (src != null) {
            Vertex vertex = getVertex(src);
            if (vertex != null) {
                return vertex.mEdgeSet;
            }
        }
        return null;
    }

    @Override
    public Edge<V> getEdge(V src, V dest) {
        if (src != null && dest != null) {
            Vertex vertex = getVertex(src);
            if (vertex != null) {
                return vertex.getEdge(dest);
            }
        }
        return null;
    }

    @Override
    public Iterator<V> iterator(int type, V root) {
        return null;
    }

    @Override
    public void convertDAG() {

    }

    /**
     * 从顶点对象列表中读取输入顶点对应的对象
     */
    private Vertex getVertex(V v) {
        if (v != null) {
            for (Vertex vertex : mVertexSet) {
                if (v.equals(vertex.src)) {
                    return vertex;
                }
            }
        }
        return null;
    }

    // 顶点对象，其中有对应的顶点以及从以此顶点为起点的边
    private class Vertex {

        private final V src;

        // 以此顶点为起点的边的集合
        private final Set<Edge<V>> mEdgeSet;

        Vertex(V src) {
            this.src = src;
            this.mEdgeSet = new HashSet<>();
        }

        /**
         * 将一条边添加到边集合中
         *
         * @return false-已存在
         */
        boolean addEdge(Edge<V> e) {
            if (!e.getSource().equals(src)) {
                return false;
            }
            return mEdgeSet.add(e);
        }

        /**
         * 读取某条边
         */
        Edge<V> getEdge(V dest) {
            if (dest != null) {
                for (Edge<V> edge : mEdgeSet) {
                    if (dest.equals(edge.getDest())) {
                        return edge;
                    }
                }
            }
            return null;
        }

        /**
         * 移除某条边
         */
        boolean removeEdge(V dest) {
            return mEdgeSet.remove(new Edge<V>(src, dest));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Vertex vertex = (Vertex) o;
            return Objects.equals(src, vertex.src);
        }

        @Override
        public int hashCode() {
            return Objects.hash(src);
        }
    }
}
