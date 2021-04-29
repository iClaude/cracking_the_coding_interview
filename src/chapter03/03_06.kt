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

fun main() {
    val animalShelter = AnimalShelter().apply {
        enqueue(Cat("Tommy"))
        enqueue(Cat("Timmy"))
        enqueue(Cat("Jerry"))
        enqueue(Dog("Alpha"))
        enqueue(Cat("Micio"))
        enqueue(Cat("Micetto"))
        enqueue(Dog("Micia"))

        println(dequeueDog()?.name)
        println(dequeueDog()?.name)

        println(dequeueAny()?.name)
        println(dequeueAny()?.name)
        println(dequeueAny()?.name)
        println(dequeueAny()?.name)
        println(dequeueAny()?.name)
        println(dequeueAny()?.name)
    }
}

sealed class Animal(val name: String, val race: String) {
    class Dog(name: String, race: String = "no race") : Animal(name, race)
    class Cat(name: String, race: String = "no race") : Animal(name, race)
}

class AnimalShelter {
    private val animals = LinkedList<Animal>()
    private val tmpStack = Stack<Animal>()

    fun isEmpty() = animals.isEmpty()

    fun enqueue(animal: Animal) {
        animals.add(animal)
    }

    fun dequeueAny(): Animal? = animals.poll()

    fun dequeueDog(): Dog? {
        if (isEmpty()) throw Exception("Animal shelter is empty!")

        while (!animals.isEmpty() && animals.peek() is Cat) {
            tmpStack.push(animals.poll())
        }
        if (animals.isEmpty()) return null

        val dog = animals.pop()
        while (!tmpStack.empty()) {
            animals.addFirst(tmpStack.pop())
        }

        return dog as Dog
    }

    fun dequeueCat(): Cat? {
        if (isEmpty()) throw Exception("Animal shelter is empty!")

        while (!animals.isEmpty() && animals.peek() is Dog) {
            tmpStack.push(animals.poll())
        }
        if (animals.isEmpty()) return null

        val cat = animals.pop()
        while (!tmpStack.empty()) {
            animals.addFirst(tmpStack.pop())
        }

        return cat as Cat
    }

}