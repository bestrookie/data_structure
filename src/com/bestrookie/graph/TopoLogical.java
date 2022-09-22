package com.bestrookie.graph;

import com.bestrookie.stack.MyStack;

/**
 * @author bestrookie
 * @des 拓扑排序
 * @date 2022/9/22 16:39
 */
public class TopoLogical {
    private MyStack<Integer> order;

    public  TopoLogical(Digraph digraph){
        DirectedCycle cycle = new DirectedCycle(digraph);
        if (!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
            order = depthFirstOrder.reversePost();
        }

    }

    private boolean isCycle(){
        return order == null;
    }

    public MyStack<Integer> getOrder(){
        return order;
    }

}
