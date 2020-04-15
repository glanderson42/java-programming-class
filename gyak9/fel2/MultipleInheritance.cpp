#include <iostream>

struct A {
   void printA() {
		std::cout << "A\n";
   }
};

struct B {
	void printB() {
		std::cout << "B\n";
	}
};

struct C : public A, B {
	void print() {
		printA();
		printB();
	}
};


int main() {
	C var;
	var.print();
}
