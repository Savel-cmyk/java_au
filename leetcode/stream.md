# Stream

+ [Top K Frequent Words](#top-k-frequent-words)
<!---->

## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> l = new ArrayList<String>();
        HashMap<String,Integer> hm = new HashMap<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(hm.get(a)==hm.get(b)) return a.compareTo(b)>=0?-1:1;
            else return hm.get(a)-hm.get(b);
        });


        for(String s:words)
            hm.put(s,hm.getOrDefault(s,0)+1);

        for(String s:hm.keySet()){
            pq.add(s);
            if(pq.size()>k) pq.poll();
        }
        while(!pq.isEmpty())
            l.add(pq.poll());

        Collections.reverse(l);
        return l;
    }
}
```
