package com.code.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangzongyu
 * @Description:
 * @date 2021/12/23 8:52 下午
 */
public class Solution314Test {

    @Test
    public void verticalOrder() {
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = new Solution314.TreeNode(3,
                new Solution314.TreeNode(9, null, null),
                new Solution314.TreeNode(20,
                        new Solution314.TreeNode(15, null, null),
                        new Solution314.TreeNode(7, null, null)));
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        //[[9],[3,15],[20],[7]]
        expt.add(Arrays.asList(9));
        expt.add(Arrays.asList(3, 15));
        expt.add(Arrays.asList(20));
        expt.add(Arrays.asList(7));
        assertE(verticalOrder, expt);

    }

    @Test
    public void verticalOrder1() {
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = new Solution314.TreeNode(3,
                new Solution314.TreeNode(9,
                        new Solution314.TreeNode(4, null, null),
                        new Solution314.TreeNode(0, null, null)),
                new Solution314.TreeNode(8,
                        new Solution314.TreeNode(1),
                        new Solution314.TreeNode(7)));
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        //[[9],[3,15],[20],[7]]
        expt.add(Arrays.asList(4));
        expt.add(Arrays.asList(9));
        expt.add(Arrays.asList(3, 0, 1));
        expt.add(Arrays.asList(8));
        expt.add(Arrays.asList(7));
        assertE(verticalOrder, expt);

    }

    @Test
    public void verticalOrder4() {
        //[1,null,3,2,5,null,null,4]
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = new Solution314.TreeNode(1,
                null,
                new Solution314.TreeNode(3,
                        new Solution314.TreeNode(2),
                        new Solution314.TreeNode(5, new Solution314.TreeNode(4), null)));
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        //[[1,2],[3,4],[5]]
        expt.add(Arrays.asList(1, 2));
        expt.add(Arrays.asList(3, 4));
        expt.add(Arrays.asList(5));
        assertE(verticalOrder, expt);

    }

    @Test
    public void verticalOrder2() {
        // [3,9,8,4,0,1,7,null,null,null,2,5]
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = new Solution314.TreeNode(3,
                new Solution314.TreeNode(9,
                        new Solution314.TreeNode(4),
                        new Solution314.TreeNode(0,
                                null,
                                new Solution314.TreeNode(2))),
                new Solution314.TreeNode(8,
                        new Solution314.TreeNode(1,
                                new Solution314.TreeNode(5),
                                null),
                        new Solution314.TreeNode(7)));
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        //[[4],[9,5],[3,0,1],[8,2],[7]]
        expt.add(Arrays.asList(4));
        expt.add(Arrays.asList(9, 5));
        expt.add(Arrays.asList(3, 0, 1));
        expt.add(Arrays.asList(8, 2));
        expt.add(Arrays.asList(7));
        assertE(verticalOrder, expt);

    }

    @Test
    public void verticalOrder7() {
        // [3,9,8,4,0,1,7,null,null,null,2,5]
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = null;
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        assertE(verticalOrder, expt);

    }


    @Test
    public void verticalOrder5() {
        //[1,2,3,4,5,6,null,null,7,8,null,null,9,null,10,null,11,10]
        Solution314 solution314 = new Solution314();
        Solution314.TreeNode root = new Solution314.TreeNode(1,
                new Solution314.TreeNode(2,
                        new Solution314.TreeNode(4,
                                null,
                                new Solution314.TreeNode(7,
                                        null,
                                        new Solution314.TreeNode(10))),
                        new Solution314.TreeNode(5,
                                new Solution314.TreeNode(8,
                                        null,
                                        new Solution314.TreeNode(11)), null)),
                new Solution314.TreeNode(3,
                        new Solution314.TreeNode(6,
                                null,
                                new Solution314.TreeNode(9,
                                        new Solution314.TreeNode(10),
                                        null)),
                        null));
        List<List<Integer>> verticalOrder = solution314.verticalOrder(root);
        List<List<Integer>> expt = new ArrayList<>();
        //[[4],[2,7,8],[1,5,6,10,11,10],[3,9]]
        expt.add(Arrays.asList(4));
        expt.add(Arrays.asList(2, 7, 8));
        expt.add(Arrays.asList(1, 5, 6, 10, 11, 10));
        expt.add(Arrays.asList(3, 9));

        assertE(verticalOrder, expt);

    }

    private void assertE(List<List<Integer>> verticalOrder, List<List<Integer>> expt) {
        for (int i = 0; i < expt.size(); i++) {
            List<Integer> list = expt.get(i);
            List<Integer> list1 = verticalOrder.get(i);
            Assert.assertEquals(list.size(), list1.size());
            for (int j = 0; j < list.size(); j++) {
                Assert.assertEquals(list.get(j), list1.get(j));
            }
        }
    }

    //[[-4,78,73,-77,-54,-36],[12,-51,-81,4,8,3,-30,-33,86,81,98,24],[-64,-4,-53,72,-31,47,-35,-67,-37,-38,-31,-31,-18,-66,-72,43],[18,-24,-11,-91,-93,33,-51,80,44,-38,47,-42,-40,70,-93],[76,26,-31,-19,10,3,-64,-85,-96,67,34,-92,-1],[-44,-60,12,-59,-51,67,3,-88,48,-26,92,72],[53,-81,27,60,-55,72,-70,56,-88,-98,-84],[11,-49,-90,90,-34,-27,-67,98],[74,17,-17,-65,-53,39],[37]]
    //[[-4,78,73,-77,-54,-36],[12,-51,-81,4,8,3,-30,-33,86,81,98,24],[-64,-53,-31,47,-35,-67,-37,72,-4,-38,-31,-31,-18,-66,-72,43],[18,-93,33,-51,-38,47,-24,-11,80,44,-91,-42,-40,70,-93],[76,3,-64,26,-31,-19,10,-85,-96,67,34,-92,-1],[3,-44,-60,12,-59,-51,67,-88,48,-26,92,72],[53,-81,27,60,-55,-70,72,56,-88,-98,-84],[11,-49,-90,90,-34,-27,-67,98],[74,17,-17,-65,-53,39],[37]]

}