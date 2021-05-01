##Stream 流编程
    > imooc网的收费视频  播放地址:https://pan.baidu.com/play/video#/video?path=%2Fitspxx.com%2FSpringBoot2.0%E4%B8%8D%E5%AE%B9%E9%94%99%E8%BF%87%E7%9A%84%E6%96%B0%E7%89%B9%E6%80%A7%E5%92%8CWebFlux%E5%93%8D%E5%BA%94%E5%BC%8F%E7%BC%96%E7%A8%8B-2018%E5%B9%B4%E6%85%95%E8%AF%BE%E7%BD%91%2F%E7%AC%AC3%E7%AB%A0%20Stream%E6%B5%81%E7%BC%96%E7%A8%8B%2F3-1%20Stream%E6%B5%81%E7%BC%96%E7%A8%8B-%E6%A6%82%E5%BF%B5.mp4&t=0

  ###概念
     外部迭代
     内部迭代
   ###创建
    > Collection.Stream/ parallelStream
     Arrays.stream
     IntStream/LongStream.range /RangeClosed
     Random.ints/longs/doubles
     Stream.generate/iterate
     
     
   ###中间操作
   #####无状态操作
    map/mapTOX
    flatMap/flatMapToXXX
    filter
    peek
    unordered
####有状态操作
    distinct
    sorted
    limit/skip
###终止操作
####非短路操作
    forEach/forEachOrdered
    collect/toArray
    reduce
    min/max/count
####短路操作
    findFirst/firstAny
    allMatch/anyMatch/noneMatch
   


###并行流


###收集器
