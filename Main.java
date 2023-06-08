import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
//		new Thread( () -> {
//			System.out.println("Printing from the Runnable");
//			System.out.println("Line 2");
//			System.out.format("This is line %d\n", 3);
//		}).start();
		
		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Doe", 21);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(john);
		employees.add(jane);
		employees.add(jack);
		employees.add(snow);
		
		Collections.sort(employees, (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
		
		
//		Collections.sort(employees, new Comparator<Employee>() {
//			@Override
//			public int compare(Employee e1, Employee e2) {
//				return e1.getName().compareTo(e2.getName());
//			}
//		});
		
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
		
//		String ss = doStringStuff(new UpperConcat() {
//			@Override
//			public String upperAndConcat(String s1, String s2) {
//				return s1.toUpperCase() + s2.toUpperCase();
//			}
//		}, employees.get(0).getName(), employees.get(1).getName());
//		
//		System.out.println(ss);
		
//		String sl = doStringStuff( (s1, s2) -> {
//			String result = s1.toUpperCase() + s2.toUpperCase();
//			return result;
//		},
//				employees.get(0).getName(), employees.get(1).getName());
//		
//		System.out.println(sl);
		
		AnotherClass ac = new AnotherClass();
		String s = ac.doSomething();
		System.out.println(s);
		
	}
		
	public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
		return uc.upperAndConcat(s1, s2);
	}
}

class Employee {
	
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

interface UpperConcat {
	public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
	public String doSomething() {
		
		int i = 0; 
		
		{
			UpperConcat uc = new UpperConcat() {
				@Override
				public String upperAndConcat(String s1, String s2) {
					//System.out.println(i); error, i must be [final]
					return s1.toUpperCase() + s2.toUpperCase();
				}
			};
		
			System.out.println("AC Name is " + getClass().getSimpleName());
			
			i++;
			System.out.println(i);
			
			return Main.doStringStuff(uc, "String1", "String2");
		}
	
	}
}

