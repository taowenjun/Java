LRU:最近最少使用

两个关键的操作：
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
  it should invalidate the least recently used item before inserting a new item.
  
具体实现：使用一个HashMap和一个双向链表
