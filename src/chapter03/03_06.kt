package chapter03

import chapter03.Animal.Cat
import chapter03.Animal.Dog
import java.util.*

/*
    Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
    out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
    or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
    that type). They cannot select which specific animal they would like. Create the data structures to
    maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
    and dequeueCat. You may use the built-in Linked list data structure.
 */

sealed class Animal(val name: String, val race: String) {
    class Dog(name: String, race: String = "no race") : Animal(name, race)
    class Cat(name: String, race: String = "no race") : Animal(name, race)
}

class AnimalShelterWithOneList {
    private val animals = LinkedList<Animal>()
    private val tmpStack = Stack<Animal>()

    fun isEmpty() = animals.isEmpty()

    fun enqueue(animal: Animal) {
        animals.add(animal)
    }

    fun dequeueAny(): Animal? = animals.poll()

    fun dequeueDog(): Dog? {
        if (isEmpty()) return null

        while (!animals.isEmpty() && animals.peek() is Cat) {
            tmpStack.push(animals.poll())
        }

        val dog = animals.poll()
        while (!tmpStack.empty()) {
            animals.addFirst(tmpStack.pop())
        }

        return dog as Dog
    }

    fun dequeueCat(): Cat? {
        if (isEmpty()) return null

        while (!animals.isEmpty() && animals.peek() is Dog) {
            tmpStack.push(animals.poll())
        }

        val cat = animals.poll()
        while (!tmpStack.empty()) {
            animals.addFirst(tmpStack.pop())
        }

        return cat as Cat
    }

}

class AnimalShelterWithTwoLists {
    private var count = 0
    private val dogs = LinkedList<Pair<Dog, Int>>()
    private val cats = LinkedList<Pair<Cat, Int>>()

    fun isEmpty() = dogs.isEmpty() && cats.isEmpty()

    fun enqueue(animal: Animal) {
        if (animal is Dog) {
            dogs.add(animal to count++)
        } else {
            cats.add((animal as Cat) to count++)
        }
    }

    fun dequeueDog(): Dog? {
        return dogs.poll()?.first
    }

    fun dequeueCat(): Cat? {
        return cats.poll()?.first
    }

    fun dequeueAny(): Animal? {
        if (isEmpty()) return null

        val dogIndex = dogs.peek()?.second ?: Integer.MAX_VALUE
        val catIndex = cats.peek()?.second ?: Integer.MAX_VALUE

        return if (dogIndex < catIndex) {
            dogs.poll().first
        } else {
            cats.poll().first
        }
    }
}