package com.imooc.javaWebFlux.lambda.chapter03;

import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo06Stream {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("小明", 10, Gender.MAIL, Grade.ONE),
                new Student("大明", 9, Gender.MAIL, Grade.THREE),
                new Student("小白", 8, Gender.EMALE, Grade.TWO),
                new Student("小黑", 13, Gender.EMALE, Grade.FOUR),
                new Student("小红", 7, Gender.EMALE, Grade.THREE),
                new Student("小黄", 13, Gender.EMALE, Grade.ONE),
                new Student("小青", 13, Gender.EMALE, Grade.THREE),
                new Student("小紫", 9, Gender.EMALE, Grade.TWO),
                new Student("小王", 6, Gender.MAIL, Grade.ONE),
                new Student("小李", 6, Gender.MAIL, Grade.ONE),
                new Student("小马", 14, Gender.EMALE, Grade.FOUR),
                new Student("小刘", 13, Gender.MAIL, Grade.FOUR));
//        得到所有学生的年龄列表

//        s -> s.getAge() 等价于 Student::getAge 不会多生成一个类似lambda$0这样的函数
//        List<Integer> list = students.stream().map(s -> s.getAge()).collect(Collectors.toList());
        List<Integer> list = students.stream().map(Student::getAge).collect(Collectors.toList());
        System.out.println("所有学生的年龄：" + list);
        Set<Integer> set = students.stream().map(Student::getAge).collect(Collectors.toSet());
        System.out.println("所有学生的年龄：" + set);

        //统计汇总信息
        students.stream().collect(Collectors.summarizingInt(s -> s.getAge()));
        IntSummaryStatistics agesSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄汇总=" + agesSummaryStatistics);

        //分块
        Map<Boolean, List<Student>> genders = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MAIL));
//        System.out.println("男女学生列表："+ genders);
        MapUtils.verbosePrint(System.out, "男女学生列表", genders);

//        分组
        Map<Grade, List<Student>> grades = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        MapUtils.verbosePrint(System.out, "男女班级列表", grades);

//得到所有班级学生的个数
        Map<Grade, Long> gradesCount = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        MapUtils.verbosePrint(System.out, "男女学生个数列表", gradesCount);


    }
}
