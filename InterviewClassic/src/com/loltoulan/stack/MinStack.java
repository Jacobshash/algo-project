package com.loltoulan.stack;

public class MinStack {

    private final Integer[] stack;
    private Integer top;
    private Integer min;
    private int size;

    public MinStack() {
        this.size = -1;
        this.stack = new Integer[30000000];
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        top = val;
        min = Math.min(min, val);
        size ++;
        stack[size] = val;
    }

    public void pop() {
        stack[size] = null;
        size--;
        if(size == -1){
            top = null;
            min = Integer.MAX_VALUE;
            return;
        }
        min = Integer.MAX_VALUE;
        top = stack[size];
        for (int i = 0; i <= size; i++) {
            min = Math.min(min, stack[i]);
        }
    }

    public int top() {
        return this.top;
    }

    public int getMin() {
        return this.min;
    }

}

class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        // ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        // [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        System.out.println("=============");

        minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        System.out.println("=============");
    }
}

/*

![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadly1hv1c9s2rwxj61y82llx6p02.9kg7yvlm0f.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadly1hv1c9qhldqj62ds1sc4qq02.2yye7uhk18.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadly1hv1c9oibi5j62781nf1kx02.7egtd3ty96.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadly1hv1c9kv7m3j62a51pmtzt02.8ojqjfbxk8.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hvwf66ec41j62ds1scnpd02.3k81u5c0br.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hvo9yoq5irj629e30jkjn02.67xi4i51np.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hvo9ylqwhdj61w92i4kjm02.7zqgzeoejl.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hvo9ykdn84j625n2uyx6r02.7p3n6996e4.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hvo9yh1onpj62cy3451l102.92q6aak8ev.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wr8nwtj61sc2e9b2a02.4ckxbvsm1e.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wpimrtj61sc2e4npe02.8s3ch5509a.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wo7d9rj626i2wohdu02.7ax7fe0vii.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wledxnj61i91zwx6r02.3d4typpuva.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81whh1mlj62c03401kz02.491be5zjb6.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wfwol9j62c0340u0y02.73tzjyeq2m.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1hv81wbh0wfj63402c0u0y02.32i05kampm.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huw76zdr5lj62db35sqv602.99te5q6dtk.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huvah9jtrjj60zu1brqi702.41y3iqddv8.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huvadq9f2hj616u1hk7rf02.6ikbxnk9rn.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huvadp81spj61l824k4qp02.361m3a3pf5.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huvado96d0j61c41s61kx02.1ovh1izkoe.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/0040jbadgy1huvadmom6qj624k2u3u0y02.1hs963df8s.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgw7e47j30q01gp7p1.7i0fatn0x4.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgvtteij30qb1kw7wh.4jo57berfr.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgva4l1j30qa1kyb29.7pbzrvfxi.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjguc24bj30qa1ky4qp.m44c9ahx.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgtxgbsj30zk24wb29.8dwwq9wpd0.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgte3rrj30zk24wb29.86touuajxg.webp)
![](https://github.com/Jacobshash/picx-images-hosting/raw/master/20241130/008yVqcfly1hujjgsy41zj30qa1ky7wh.64dw6sbyw2.webp)
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
![]()
 */