package com.practice.simpleTest;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        List<OnlineLecture> springLectures = new ArrayList<>();
        springLectures.add(new OnlineLecture(1l, "spring boot", true));
        springLectures.add(new OnlineLecture(2l, "spring data jpa", true));
        springLectures.add(new OnlineLecture(3l, "spring mvc", false));
        springLectures.add(new OnlineLecture(4l, "spring core", false));
        springLectures.add(new OnlineLecture(5l, "rest api development", false));


//        List<String> lectureTitles = new ArrayList<>();
//
//        for(OnlineLecture ol : springLectures) {
//            if(ol.getTitle().startsWith("spring")) {
//                lectureTitles.add(ol.getTitle());
//            }
//        }

//        for (OnlineLecture ol : springLectures) {
//            if (ol.isClosed() == false) {
//                lectureTitles.add(ol.getTitle());
//            }
//        }
//
//        System.out.println(lectureTitles);


        System.out.println("spring 으로 시작하는 강의 출력");
        List<String> springSubjects = springLectures.stream()
                .filter(ol -> ol.getTitle().startsWith("spring"))
                .map(ol -> ol.getTitle())
                .collect(Collectors.toList());
        springSubjects.forEach(System.out::println);

        System.out.println("close 되지 않은 수업 출력");
        List<String> notClosedLecture = springLectures.stream()
                .filter(ol -> !ol.isClosed())
                .map(ol -> ol.getTitle())
                .collect(Collectors.toList());
        notClosedLecture.forEach(System.out::println);

        System.out.println("close된 수업 출력");
        List<String> closedLecture = springLectures.stream()
                .filter(ol -> ol.isClosed())
                .map(ol -> ol.getTitle())
                .collect(Collectors.toList());
        closedLecture.forEach(System.out::println);

        System.out.println("수업 이름만 모아서 스트림 만들기");
        List<String> lectureNames = springLectures.stream()
                .map(OnlineLecture::getTitle)
                .collect(Collectors.toList());
        lectureNames.forEach(System.out::println);

        List<OnlineLecture> javaLectures = new ArrayList<>();
        javaLectures.add(new OnlineLecture(6l, "java test", true));
        javaLectures.add(new OnlineLecture(7l, "java code manipulation", true));
        javaLectures.add(new OnlineLecture(8l, "java8 to 11", false));

        List<List<OnlineLecture>> events = new ArrayList<>();
        events.add(springLectures);
        events.add(javaLectures);

        System.out.println("두 수업 목록에 들어 있는 모든 수업 보기");
        // 힌트 : flatMap 사용
        List<OnlineLecture> allLectures = events.stream()
                .flatMap(Collection::stream).collect(Collectors.toList());

                allLectures.forEach(al -> System.out.println(al.getTitle()));


        System.out.println("10부터 1씩 증가 하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만 출력");
        // 힌트 : iterate, skip, limit 사용
        IntStream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(i -> System.out.println(i + ""));



        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인 : boolean type으로 출력");
        // 힌트 anyMatch 사용
        Boolean testLectures = javaLectures.stream()
                .filter(tl -> tl.getTitle().contains("test"))
                .anyMatch(tl -> tl.getTitle().contains("test"));
        System.out.println(testLectures);


//      filter를 사용하여 spring 이 들어간 강의 추출, map을 통해 형태 변경.
        System.out.println("스프링 수업 중에 제목에 spring 들어간 제목만 모아서 List로 만들기");
        List<String> includeSpring = springLectures.stream()
                .filter(il -> il.getTitle().contains("spring"))
                .map(il -> il.getTitle())
                .collect(Collectors.toList());
        includeSpring.forEach(System.out::println);
    }
}