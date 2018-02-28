LFU:最不常使用

两个关键的操作：get和put
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, 
   it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, 
   when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

思想：统计每个key的get和put总频率，设容量存储为n,保留top n的key，每put或get一次更新存储的统计结果。
具体实现：类中有三个HashMap类型的成员变量，分别存储key以及对应的值，key及其出现的次数，每个出现次数的key的集合，还有两个整型成员变量，分别用来记录容量
和HashMap保存的最小的出现次数min。
   两个核心方法get(key)和put(key,value)的实现：按要求更新三个HashMap和min即可。
