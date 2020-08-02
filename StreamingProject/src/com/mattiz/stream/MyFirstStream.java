package com.mattiz.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyFirstStream {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(new Person("John", "Doe", 10), new Person("John1", "Doe1", 11),
				new Person("John2", "Doe2", 12), new Person("John3", "Doe3", 13), new Person("John4", "Doe4", 14),
				new Person("John5", "Doe5", 15), new Person("John6", "Doe6", 16), 
				new Person("John7", "Doe7", 17), new Person("John8", "Doe8", 18), 
				new Person("John9", "Doe9", 19));
		
		
		
		personList.forEach(person->System.out.println(person.getAge()));
		
		System.out.println("=========1===========");
		
		personList.stream().	
		filter(person -> person.getAge()<16).
		limit(3).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("=========2===========");
		personList.stream().
		filter(person -> person.getAge()<16).
		collect(Collectors.toList()).
		forEach(person->System.out.println(person.getAge()));
		
		System.out.println("========3============");
		
		personList.stream().
		filter(person -> person.getAge()<16).
		collect(Collectors.toList()).
		forEach(person->{int age = person.getAge(); System.out.println(age);});
		
		System.out.println("========4============");
		
		Map<Person,Integer> newMap = new HashMap<Person,Integer>();
		newMap.put(new Person("John", "Doe"),11);
		newMap.put(new Person("John2", "Doe2"),12);
		newMap.put(new Person("John3", "Doe3"),13);
		newMap.put(new Person("John4", "Doe4"),14);
		newMap.put(new Person("John5", "Doe5"),15);
		newMap.put(new Person("John6", "Doe6"),16);
		newMap.put(new Person("John7", "Doe7"),17);
		newMap.put(new Person("John8", "Doe8"),18);
		
		newMap.forEach((key,value)->System.out.println(key.getFirstName()+" "+value+"\n"));
		
		System.out.println("=========5===========");
		
		IntStream.range(0, 10).
		forEach(System.out::println);
				
		System.out.println("========6============");
		
		IntStream.range(0, 9).
		forEach(i->System.out.println(personList.get(i).getFirstName()));
		
		System.out.println("========7============");
		
		IntStream.rangeClosed(0, 9).
		forEach(i->System.out.println(personList.get(i).getFirstName()));
		
		System.out.println("========8============");
		
		IntStream.range(0, personList.size()).
		forEach(i->System.out.println(personList.get(i).getFirstName()));
		
		System.out.println("========9============");
	
		IntStream.iterate(0, operand->operand+2).
		limit(10).
		forEach(System.out::println);
		
		System.out.println("========10============");
		
		IntStream.iterate(0, operand->operand+1).
		filter(i->i%2==0).
		limit(10).
		forEach(System.out::println);
		
		System.out.println("========11============");
		//run with vm argument -ea
		List<Integer> ranNumList = Arrays.asList(2, 5, 22, 4, 6, 89, 2, 3, 45, 4, 12);
				
		System.out.println("========12============");
		
		int min = ranNumList.stream().
				min((num1, num2) -> num1 > num2 ? 1 : 0)
				.get();
		assert (min == 2) : "Correct2";
		//assert (max == 2) : "Correct3";
		
		System.out.println("========13============");
		
		int max = ranNumList.stream().
				max(Comparator.naturalOrder())
				.get();
		System.out.println(max);
		
		System.out.println("========14============");
		
		final List<Integer> mylist = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 7, 8, 9, 9, 2, 3, 5, 8,
				9);
		List<Integer> uniqueList = mylist.stream().
		distinct().
		collect(Collectors.toList());
		IntStream.range(0, uniqueList.size()).forEach(i->{System.out.println(uniqueList.get(i));});
		System.out.println(" uniqueList.size()   "+uniqueList.size());
		
		System.out.println("========15============");
		
		Set<Integer> intSet = mylist.stream().collect(Collectors.toSet());
		intSet.forEach(System.out::println);
		System.out.println(" intSet.size()   "+intSet.size());
		
		System.out.println("========16============");
		
		intSet.stream().forEach(i->System.out.println(i));
		System.out.println("========or============");
		
		intSet.stream().forEach(System.out::println);
		System.out.println("========17============");
		personList.stream().
		filter(person->person.getAge()<16).
		collect(Collectors.toList()).
		forEach(person->System.out.println(person.getAge()));
		
		System.out.println("========18============");
		
		personList.stream().
		filter(person->person.getAge()<16).
		forEach(person->System.out.println(person.getAge()));
		
		System.out.println("========19============");
		
		Predicate<Person> personPredicate = person->person.getAge()>16;
		
		personList.stream().
		filter(personPredicate).
		forEach(person->System.out.println(person.getAge()));
		
		System.out.println("========20============");
		
		personList.stream().
		map(person->new PersonDTO(person.getFirstName())).
		//collect(Collectors.toList()).
		forEach(personDto->System.out.println(personDto.getFirstName()));
		
		System.out.println("========21===========");
		
		Function<Person, PersonDTO> personFunction = person->new PersonDTO(person.getFirstName());
		
		personList.stream().
		map(personFunction).
		//collect(Collectors.toList()).
		forEach(personDto->System.out.println(personDto.getFirstName()));
		
		System.out.println("========22===========");
		
		List<PersonDTO> personDtoList = personList.stream().
		map(PersonDTO::myMap).
		collect(Collectors.toList());
		
		personDtoList.forEach(System.out::println);
		
		System.out.println("========23===========");
		
		double ave = personList.stream().
				mapToInt(person->person.getAge()).average().
				orElse(0);
		
		System.out.println(ave);
		
		double ave2 = personList.stream().
				mapToInt(Person::getAge).average().
				orElse(0);
		
		System.out.println(ave2);
		
		System.out.println("========24===========");
		
		Integer[] intArray= {1,2,3,4,5,6,3,2,4,5,8,9};
		
		Predicate<Integer> greaterThanFiveLessThanSeven = i -> (i >= 5 && i <= 7);
		
	    int any = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		findAny().get();
	    System.out.println(any);
	    
	    int first = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		findFirst().get();
	    System.out.println(first);
	    
	    System.out.println("========25===========");
	    
	    Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		forEach(System.out::println);
	    
	    long count = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		count();
	    
	    System.out.println("count "+count);
	    
	    int sum = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		reduce(0,Integer::sum);
	    
	    System.out.println("sum  "+sum);	    
	    
	    
	    System.out.println("========25===OR========");
	    
	    int sum33 = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		reduce(0,(a,b)->a+b);
	    
	    System.out.println("sum33  "+sum33);
	    
	    
	    System.out.println("========26===========");
	    
	    int sum2 = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		mapToInt(Integer::intValue).
	    		sum();//sum() not applicable to Stream<Integer> but to IntStream
	        
	    int sum23 = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		mapToInt(i -> i).
	    		sum();//sum() not applicable to Stream<Integer> but to IntStream
	    
	    System.out.println("sum  "+sum2);
	    System.out.println("sum  "+sum23);
	    
	    double sumxyz = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		mapToDouble(i->i).
	    		sum();
	    
	    System.out.println("double sum  "+sumxyz);
	    
	    System.out.println("========27===========");
	    
	    double min2 = ranNumList.stream().
	    		mapToDouble(Integer::doubleValue).
				min().
				getAsDouble();
	    
	    double max2 = ranNumList.stream().
	    		mapToDouble(Integer::doubleValue).
				max().
				getAsDouble();
	    
	    System.out.println(min2+"     "+max2);
	    
	    System.out.println("========28===========");
	    	    
	    int max22 = ranNumList.stream().
	    		mapToInt(i -> i).
				max().
				getAsInt();//convert stream to int stream then apply max()
	    
	    System.out.println(max22);
	   //Stream.max() accepts comparator but IntStream.max() has no args
	    
	    System.out.println("========29===========");
	    
	    double maxx = personList.stream().
	    		mapToDouble(person -> person.getAge()).
				max().
				getAsDouble();
	    
	    System.out.println("max age      "+maxx);
	    
	    System.out.println("========30===========");
	    
	    int maxxx = Arrays.stream(intArray).
	    		filter(greaterThanFiveLessThanSeven).
	    		reduce(0,Integer::max);
	    
	    System.out.println("maxxx "+maxxx);
	    
	    System.out.println("========31===========");
	    
	    List<Person> newPersonList = Arrays.asList(new Person("John", "Doe", 10, "M"), new Person("John1", "Doe1", 11, "F"),
				new Person("John2", "Doe2", 12, "F"), new Person("John3", "Doe3", 13, "M"), new Person("John4", "Doe4", 14, "M"),
				new Person("John5", "Doe5", 15, "M"), new Person("John6", "Doe6", 16, "M"), 
				new Person("John7", "Doe7", 17, "F"), new Person("John8", "Doe8", 18, "M"), 
				new Person("John9", "Doe9", 19, "F"));
	    
	    Map<String, List<Person>> sortedList = newPersonList.stream().
	    collect(Collectors.groupingBy(person -> person.getSex()));
	    
	    sortedList.forEach((k,v)->{
	    	System.out.println(k);
	    	v.forEach(person -> System.out.println(person.getFirstName()));}
	    );

	    System.out.println("========31===========");
	    
	    Map<String, Long> countedList = newPersonList.stream().
	    		map(person->person.getSex()).
	    	    collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    
	    countedList.forEach((k,v)->{
	    	System.out.print(k);
	    	System.out.println(v);
	    	});
	    System.out.println("========32===========");
	    
	    List<List> nestedList = Arrays.asList(newPersonList, ranNumList, personDtoList);
	    
	    System.out.println("nestedList   "+nestedList);
	    
	    List flattenedList = (List) nestedList.stream().
	    		flatMap(List::stream).
	    		collect(Collectors.toList());
	    System.out.println("flattenedList     "+flattenedList);//List::stream means List->List.stream()
	    
	    System.out.println("========33===========");
	    
	    String concatenatedName = personList.stream().
	    		map(person -> person.getFirstName()).
	    		collect(Collectors.joining());
	    
	    System.out.println(concatenatedName);
	    
	    
	    String concatenatedName2 = personList.stream().
	    		map(person -> person.getFirstName()).
	    		collect(Collectors.joining(", "));
	    
	    System.out.println(concatenatedName2);
	    
	    System.out.println("=====actual construct of stream======");
	    
	    List<String> lizzie =personList.stream().
	    		map(person -> person.getFirstName()).collect(
				() -> new ArrayList(), (list, element) -> list.add(element), 
				(list1, list2)->list1.addAll(list2));
	    
	    List<String> lizzie2 =personList.stream().
	    		map(person -> person.getFirstName()).collect(
				ArrayList::new, ArrayList::add, 
				ArrayList:: addAll);//another representation
	    
	    
	    lizzie.forEach(System.out::println);
	    System.out.println("\n");
	    lizzie2.forEach(System.out::println);
	    
	    System.out.println("=====34======");
	    		
	}
	

}
