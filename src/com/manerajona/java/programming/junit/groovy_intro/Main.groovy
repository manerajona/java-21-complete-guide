package com.manerajona.java.programming.junit.groovy_intro

import java.text.SimpleDateFormat

class Main {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy")

    static void main(String[] args) {
        // System out
        println("Hello World")

        // Return
        println(doubleIt(69))

        // Types
        def date = new Date()
        println("Today is ${sdf.format(date)}")

        def x = doubleIt(20)
        println("x is $x")

        // Strings
        def s1 = "A string"
        def s2 = 'A string'
        def s3 = """Groovy
                is
                cool!
         """
        println([s1, s2, s3])

        def s = "JoNaThAn"
        println("My name is ${s.toUpperCase()}")
        println('My name is ${s.toUpperCase()}') // Literal

        // Objects
        def jonathan = new Person("Jonathan", 30)
        jonathan.describePerson()

        jonathan.name = "Robert"
        jonathan.age = 56
        jonathan.describePerson()

        // Collections
        Map m = new HashMap()
        m.put("p1", jonathan)
        m.put("p2", new Person("Julia", 23))

        ((Person) m.get("p2")).describePerson()

        m.p1 = new Person("Margaret", 10)
        ((Person) m.p1).describePerson()

        // Closures (anonymous obj)
        def echoIt = {
            println(it)
        }
        echoIt("Hello closure!")

        def echoThat = { that ->
            println(that)
        }
        echoThat("This is that...")

        def echoABC = { a, b, c ->
            println(a)
            println(b)
            println(c)
        }
        echoABC("A", "B", "C")

        println(oneArgMethod { 10 })
        println(twoArgMethod(40, { 10 }))

        def i = oneArgMethod {
            def y = 3
            y * 2
        }

        assert i == 12

        // Iterators
        for (int j in [1, 2, 3]) {
            println(j)
        }

        [3, 2, 1].each {
            println(it)
        }

        // Closure Resolution
        jonathan.countdownYears()
        jonathan.executeInside { println(age)}
    }

    static Integer doubleIt(i) {
        return i * 2
    }

    static class Person {
        String name
        Integer age

        Person(String name, Integer age) {
            this.name = name
            this.age = age
        }

        void describePerson() {
            println("Person name is ${this.name}, ${this.age} years old")
        }

        Closure countdownYears = {
            for (def j = this.age; j > 0; j--) {
                print(j)
            }
            printf("\n")
        }

        def executeInside(Closure c) {
            c.delegate = this
            c()
        }
    }

    static def oneArgMethod(closure) {
        closure() * 2
    }

    static def twoArgMethod(factor, closure) {
        closure() * factor
    }
}
