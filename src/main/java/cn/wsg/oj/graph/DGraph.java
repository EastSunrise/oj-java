package cn.wsg.oj.graph;

import java.util.Iterator;
import java.util.Set;

/**
 * 有向图接口，定义需要实现的各个方法，可以选择使用邻接矩阵或者邻接链表来实现 顶点值不可重复，从指定起点到指定终点至多有一条有向边
 *
 * @author Kingen
 */
public interface DGraph<V> {

    /**
     * 添加一个端点
     *
     * @param v 值
     */
    boolean add(V v);

    /**
     * 添加一个边
     */
    boolean add(Edge<V> e);

    /**
     * 删除指定的顶点，与其相连的边也会被删除
     *
     * @return 被删除的顶点，如果找不到对应顶点则返回null
     */
    boolean remove(V v);

    /**
     * 删除一条边
     *
     * @return 被删除的边，如果找不到对应的边则返回null
     */
    boolean remove(Edge<V> e);

    /**
     * 获取指定起点的边集合
     */
    Set<Edge<V>> getEdges(V src);

    /**
     * 获得一条边
     *
     * @param src  起点
     * @param dest 终点
     */
    Edge<V> getEdge(V src, V dest);

    /**
     * 得到当前图的迭代器，用于对图进行遍历
     *
     * @param type 遍历类型，深度优先或者广度优先
     * @param root 从哪个点开始遍历
     */
    Iterator<V> iterator(int type, V root);

    /**
     * 将图转换为无环图
     */
    void convertDAG();
}
