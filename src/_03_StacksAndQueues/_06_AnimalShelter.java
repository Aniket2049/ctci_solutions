package _03_StacksAndQueues;

import java.util.LinkedList;

/*
Animal Shelter: An animal shelter, which holds only dogs and cats, operates on 
a strictly "first in, first out" basis. People must adopt either the "oldest" 
(based on arrival time) of all animals at the shelter, or they can select 
whether they would prefer a dog or a cat (and will receive the oldest animal of
that type). They cannot select which specific animal they would like. Create 
the data structures to maintain this system and implement operations such as 
enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in 
LinkedList data structure.
*/

public class _06_AnimalShelter {
	public static class AnimalShelter {

		private static LinkedList<Dog> dogs = new LinkedList<>();
		private static LinkedList<Cat> cats = new LinkedList<>();
		private static int order = 0;

		public void enqueue(Animal animal) {
			if (animal != null) {
				animal.setOrder(order);
				order++;
				if (animal instanceof Dog) {
					dogs.addLast((Dog) animal);
				} else if (animal instanceof Cat) {
					cats.addLast((Cat) animal);
				}
			}
		}

		public Animal dequeueAny() {
			if (dogs.size() == 0) {
				dequeueCat();
			} else if (cats.size() == 0) {
				dequeueDog();
			}
			Dog dog = dogs.peek();
			Cat cat = cats.peek();
			if (dog.isOlderThen(cat)) {
				return dogs.poll();
			} else {
				return cats.poll();
			}
		}

		public Dog dequeueDog() {
			return dogs.poll();
		}

		public Cat dequeueCat() {
			return cats.poll();
		}

		public int size() {
			return dogs.size() + cats.size();
		}

		public static abstract class Animal {

			private int order;
			protected String name;

			public Animal(String name) {
				this.name = name;
			}

			public int getOrder() {
				return order;
			}

			public void setOrder(int order) {
				this.order = order;
			}

			public boolean isOlderThen(Animal animal) {
				return this.order < animal.getOrder();
			}

		}

		public static class Cat extends Animal {
			public Cat(String name) {
				super(name);
			}

			public String name() {
				return "Cat : " + name;
			}

		}

		public static class Dog extends Animal {
			public Dog(String name) {
				super(name);
			}

			public String name() {
				return "Dog : " + name;
			}
		}

	}
}
