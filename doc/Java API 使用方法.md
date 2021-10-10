- [ ] 链表转 int 数组

    ```java
    int[] result = list.toArray(new int[list.size()]);
    ```

- [ ] int 数组转链表

    ```java
    Arrays.steam(array).boxed().collect(Collectors.toList())
    ```
- [ ] Integer 数组转链表

    ```java
    List<Integer> result = new ArrayList<Integer>(Arrays.asList(array));
    ```

- [ ] map 输出

    直接标准输出即可(sout)

- [ ] map 判断元素中某个条件是否成立

    ```java
    // 判断 map 中是否有一个元素的值不为0
    map.entrySet().stream().anyMatch(item -> item.getValue() != 0);
    ```

- [ ] 二维基本类型数组排序

    ```java
    // 以第一维排序
    Arrays.sort(array,Comparator.comparingInt(o->o[0]));
    // 以第二维排序
    Arrays.sort(array,Comparator.comparingInt(o->o[1]));
    ```